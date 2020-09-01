/*************************************************************
 Licensed to the Apache Software Foundation (ASF) under one
 or more contributor license agreements.  See the NOTICE file
 distributed with this work for additional information
 regarding copyright ownership.  The ASF licenses this file
 to you under the Apache License, Version 2.0 (the
 "License"); you may not use this file except in compliance
 with the License.  You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing,
 software distributed under the License is distributed on an
 "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 KIND, either express or implied.  See the License for the
 specific language governing permissions and limitations
 under the License.
 *************************************************************/
package se.gu.faxe.commands;

import org.apache.commons.io.FileUtils;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.ResetCommand;
import org.eclipse.jgit.api.errors.GitAPIException;
import picocli.CommandLine;
import picocli.CommandLine.Parameters;
import se.gu.faxe.EmbeddedAnnotation;
import se.gu.faxe.FAXE;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

@CommandLine.Command(name = "fbpc", description = "Perform Feature-Based Partial Commit.")
public class FeatureBasedPartialCommit implements Callable<Integer> {

	@Parameters(index = "0", description = "Path to git working directory (with .git) of project. (data provided by calling bash script).")
    private File gitWorkingDirectory;

	@Parameters(index = "1", description = "Source code folder inside working directory. (relative path from gitWorkingDirectory)")
	private String srcFolder;

	@CommandLine.Option(names = {"-f", "--feature"}, description = "Feature to be commited via partial commit.")
	private String featureLPQ = "";

	@CommandLine.Option(names = {"-m", "--message"}, description = "Text for commit message.")
	private String message = "";

	@CommandLine.Option(names = {"-nc", "--no-commit"}, description = "Create partial commit in staging area. Manual get-commit required afterwards.")
	private boolean flagNoCommit = false;


	@Override
	public Integer call() throws Exception {
		System.out.println(">>> FeatureBasedPartialCommit");

		gitWorkingDirectory = CommonMethods.verifyReceivedFilePath(gitWorkingDirectory);
		if(gitWorkingDirectory==null){
			System.out.println("<<< FeatureBasedPartialCommit");
			return -1;
		}

		// IF no feature for FBPC is given
		if(featureLPQ.equals("")){
			System.out.println("List of changed features - select the one for partial commit:");
			List<String> changed = findChangedFeatures(gitWorkingDirectory, srcFolder);
			//System.out.println(changed);
			if(changed.size()>0) {
				for (int i = 0; i < changed.size(); i++) {
					System.out.println("(" + i + ") " + changed.get(i));
				}

				System.out.print("Please enter changed feature number: ");
				Scanner in = new Scanner(System.in);
				int a = in.nextInt();

				while(a>=changed.size()) {
					System.out.println("Entered number " +a +" to large. Select value between 0 and " +(changed.size()-1));
					System.out.print("Please enter changed feature number: ");
					a = in.nextInt();
				}
				featureLPQ = changed.get(a);
			} else {
				System.out.println("No features changed. Stop process.");
				return 0;
			}
		}

		// IF no commit message is given
		if(message.equals("")){
			System.out.print("Please provide commit message (optional):");
			Scanner in = new Scanner(System.in);
			String s = in.nextLine();
			System.out.println("You entered commit message \"" +s +"\"");

			message = s;
		}

		performPartialCommit(featureLPQ, gitWorkingDirectory, srcFolder, message, flagNoCommit);

		System.out.println("<<< FeatureBasedPartialCommit");
		return 0;
	}

	/**
	 * Extracts unique feature names from @EmbeddedAnnoations list
	 * @param eaList input list
	 * @return List<String> with unique feature names
	 */
	private static List<String> extractUniqueFeatureNamesfromList(List<EmbeddedAnnotation> eaList) {
		HashSet<String> hSet = new HashSet<String>();
		for(EmbeddedAnnotation ea : eaList) {
			hSet.add(ea.getFeature());
		}

		List<String> newList = new ArrayList<String>(hSet);
		java.util.Collections.sort(newList);
		return newList;
	}
	
	//public static void main(String[] args) {
	private void performPartialCommit(String optFeatureName, File optWorkingDirectory, String optSourceDirectory, String optCommitMessage, boolean optNoCommit){
		System.out.println(">>> FeatureBasedPartialCommit::performPartialCommit");

		System.out.println("workingDirectory=" +optWorkingDirectory.getPath());
		System.out.println("sourceDirectory=" +optSourceDirectory);
        if(optFeatureName.equals("")){
        	System.out.println("ERROR: Add feature (-f=featureName | --feature=featureName) and restart process.");
        	return;
		}
		System.out.println("feature = \"" +optFeatureName  +"\"");
        System.out.println("message = \"" +optCommitMessage+"\"");
        System.out.println("no-commit=" +optNoCommit);

		List<EmbeddedAnnotation> listEA = null;

//		/**************************************************************/
//		/** (0) PREPARATION
//		/** Check if to be committed feature is present and if not
//		/** list available EA for commit **/
//		/**************************************************************/
//		if(featureLPQ.equals("")){
//			System.out.println("No to be committed feature provided by command line");
//			System.out.println("Feature (Embedded Annotations) available to be committed.");
//			listEA = FAXE.getEmbeddedAnnotations(optWorkingDirectory);
//			System.out.println("Found " +listEA.size() +"EA in " +optWorkingDirectory.getName());
//			List<String> uniqueFeatureList = extractUniqueFeatureNamesfromList(listEA);
//			System.out.println("Found " +uniqueFeatureList.size() +"unique feature");
//
//
//
//			System.out.println("Select feature to be committed:");
//			for(int i=1; i<=uniqueFeatureList.size(); i++){
//				System.out.println("(" +i +") " +uniqueFeatureList.get(i) );
//			}
//		}




		/**************************************************************/
		/** (1) SAVE CURRENT STATE OF WORKING DIRECTORY TO BACKUP DIR */
		/**************************************************************/
        //String src = "\\src";
		File mainDir = new File(optWorkingDirectory.getPath().concat("\\").concat(optSourceDirectory));
		System.out.println("Working in main source directory: " +mainDir.getPath());
		//File mainDir = optWorkingDirectory;
		if (!mainDir.exists()) {
			System.out.println("ERROR: Working-Directory " +mainDir.getPath() +" not found.");
			return;
		}
//		File backUpDir = new File(mainDir + "_Backup");
		File backUpDir = new File("C:\\temp\\Backup");
		if (!backUpDir.exists()) {
			backUpDir.mkdir();
		} else {
			try {
				FileUtils.deleteDirectory(backUpDir);
				FileUtils.forceMkdir(backUpDir);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try {
		    FileUtils.copyDirectory(mainDir,backUpDir);
		} catch (IOException e) {
		    e.printStackTrace();
		}

		Git git = null;
		git = gitInitRepository(git, optWorkingDirectory);
		//git = gitInitRepository(git, new File(workingDirectory));

		/*****************************************/
		/** (2) Check if staging area is empty and ask for deletion permit */
		/*****************************************/
		//System.out.println("Check staging area if empty");





		/*****************************************/
		/** (3) Reset the Working Directory      */
		/*****************************************/
		try {
			git.reset().setMode(ResetCommand.ResetType.HARD).call();
			System.out.println("Git-Repository Reset success.");
		} catch (GitAPIException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


		/*****************************************/
		/** (4) Get List of Embedded Annotations */
		/*****************************************/
		// Receive EA-List of project
		listEA = FAXE.getEmbeddedAnnotations(mainDir);
		if(listEA.isEmpty()){listEA = FAXE.getEmbeddedAnnotations(mainDir);};
		List<EmbeddedAnnotation> listEABackup = FAXE.getEmbeddedAnnotations(backUpDir);

//		List<EmbeddedAnnotation> listEA = FAXE.extractEAfromRootDirectory(mainDir.getAbsolutePath());
//		List<EmbeddedAnnotation> listEABackup = FAXE.extractEAfromRootDirectory(backUpDir.getAbsolutePath());


		/***************************************************************************************/
		/** Go through backup list an copy all changes of requested feature into Git-Directory */
		/***************************************************************************************/
		if(listEA.size()!=listEABackup.size()) {
			System.out.println("ERROR: UNKOWN SITUATION. listEA.size()!=listEABackup.size()");
			return;
		}

		System.out.println("Search for embedded annotation \"" +optFeatureName +"\"");
		boolean changeInStagingArea = false;	// tracks if any change will be moved to staging area
		for(int i=0; i<listEA.size(); i++) {
			// check if searched feature
			String currentF = listEA.get(i).getFeature();
			if(currentF.equals(optFeatureName)) {
				String backupF = listEABackup.get(i).getFeature();
				if(!backupF.equals(optFeatureName)) {
					System.out.println("ERROR: UNKOWN SITUATION. !listEABackup.get(i).getFeature().equals(demoFeature)");
					return;
				}

				// -> Both EA Lists contain the same element.
				// Check if content of parts is equal or different
				// Compare code in backup and working directory

				int openingLine = listEA.get(i).getOpeningLine();
				int closingLine = listEA.get(i).getClosingLine();
				boolean differenceFound = false;

				try {
					List<String> listLine = Files.readAllLines(Paths.get(listEA.get(i).getFile()));
					List<String> listLineBackup = Files.readAllLines(Paths.get(listEABackup.get(i).getFile()));
					for (int j = openingLine-1; j < (closingLine); j++) {	// openingLine-1 -> due to line count start with 1 and List-object with 0
						String line = listLine.get(j);
						String lineBackup = listLineBackup.get(j);

						if(!line.equals(lineBackup)) {
							differenceFound = true;
						} /*else {
							System.out.println(line);
							System.out.println("Lines identical");
						}*/
					}
				} catch (IOException e) {
					System.out.println(e);
				}


				// If different merge backup to working directory
				// If difference between source code parts found, copy full code from backup to working directory
				if(differenceFound==true) {
					// Delete EA content in working directory file
					System.out.println("Difference found in EA" +listEA.get(i).toString());

					try {
						List<String> listLine = Files.readAllLines(Paths.get(listEA.get(i).getFile()));
						for(int j=0; j<=(closingLine-openingLine); j++) {
							listLine.remove(openingLine-1);	// openingLine-1 -> due to line count start with 1 and List-object with 0
						}

						List<String> listLineBackup = Files.readAllLines(Paths.get(listEABackup.get(i).getFile()));


						int newOpeningLine = listEABackup.get(i).getOpeningLine();
						int newClosingLine = listEABackup.get(i).getClosingLine();
						for(int j=0; j<=(newClosingLine-newOpeningLine); j++) {
							String lineBackup = listLineBackup.get(newOpeningLine+j-1);	// openingLine-1 -> due to line count start with 1 and List-object with 0
							listLine.add(openingLine+j-1, lineBackup);	// openingLine-1 -> due to line count start with 1 and List-object with 0
						}

						//new File(listEA.get(i).getFile()).delete();
						Files.write(Paths.get(listEA.get(i).getFile()), listLine);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					changeInStagingArea = true;
				}	// if(differenceFound==true) {

			}	// currentF.equals(demoFeature)

		}	// for(int i=0; i<listEA.size(); i++)


		/********************************/
		/** Add changed files to INDEX **/
		/********************************/
		try {
			// Define relative path from git root.
//			String pattern = listEA.get(i).getFile();
//			String tmp = pattern.substring(workingDirectory.length()+1).replace("\\", "/");
			git.add().addFilepattern(".").call();
			System.out.println("git-add performed.");
		} catch (GitAPIException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


		/******************************************************/
		/** Commit changes to repository (unless suppressed) **/
		/******************************************************/
	    if(optNoCommit || changeInStagingArea==false) {
			System.out.println("NO git-commit performed.");
		} else {
			if(optCommitMessage.equals("")) {
				optCommitMessage = "Update Feature " +optFeatureName +" in whole project (auto msg)";
			}

			try {
				git.commit()
//					    .setAuthor("...", "...@example.com") // Skip step to use local git setup
						.setMessage(optCommitMessage)
						.call();
			} catch (GitAPIException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("git-commit performed.");
	    }


		/**********************************/
		/** CLEANUP                       */
		/**********************************/
		// Close Git
		git.close();

		// Move data from backup to main
	    try {
	    	System.out.println("Cleaning Up ...");
	    	TimeUnit.SECONDS.sleep(2);
	    	FileUtils.deleteDirectory(mainDir);

	    	System.out.println("FileUtils.forceMkdir(mainDir)");
	    	TimeUnit.SECONDS.sleep(2);
			FileUtils.forceMkdir(mainDir);

			System.out.println("FileUtils.copyDirectory(backUpDir,mainDir)");
			TimeUnit.SECONDS.sleep(2);
		    FileUtils.copyDirectory(backUpDir,mainDir);

		    // Delete backup folder
		    FileUtils.deleteDirectory(backUpDir);
			System.out.println("            ... Done");
		} catch (IOException e) {
		    e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		
		System.out.println("<<< FeatureBasedPartialCommit::performPartialCommit");
	}



	private List<String> findChangedFeatures(File optWorkingDirectory, String optSourceDirectory){
		System.out.println(">>> FeatureBasedPartialCommit::findChangedFeatures");

		System.out.println("workingDirectory=" +optWorkingDirectory.getPath());
		System.out.println("sourceDirectory=" +optSourceDirectory);

		List<String> changedFeatures = new ArrayList<String>();
		List<EmbeddedAnnotation> listEA = null;




		/**************************************************************/
		/** (1) SAVE CURRENT STATE OF WORKING DIRECTORY TO BACKUP DIR */
		/**************************************************************/
		//String src = "\\src";
		File mainDir = new File(optWorkingDirectory.getPath().concat("\\").concat(optSourceDirectory));
		System.out.println("Working in main source directory: " +mainDir.getPath());
		//File mainDir = optWorkingDirectory;
		if (!mainDir.exists()) {
			System.out.println("ERROR: Working-Directory " +mainDir.getPath() +" not found.");
			return null;
		}
//		File backUpDir = new File(mainDir + "_Backup");
		File backUpDir = new File("C:\\temp\\Backup");
		if (!backUpDir.exists()) {
			backUpDir.mkdir();
		} else {
			try {
				FileUtils.deleteDirectory(backUpDir);
				FileUtils.forceMkdir(backUpDir);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try {
			FileUtils.copyDirectory(mainDir,backUpDir);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Git git = null;
		git = gitInitRepository(git, optWorkingDirectory);
		//git = gitInitRepository(git, new File(workingDirectory));


		/*****************************************/
		/** (3) Reset the Working Directory      */
		/*****************************************/
		try {
			git.reset().setMode(ResetCommand.ResetType.HARD).call();
			System.out.println("Git-Repository Reset success.");
		} catch (GitAPIException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


		/*****************************************/
		/** (4) Get List of Embedded Annotations */
		/*****************************************/
		// Receive EA-List of project
		listEA = FAXE.getEmbeddedAnnotations(mainDir);
		if(listEA.isEmpty()){listEA = FAXE.getEmbeddedAnnotations(mainDir);};
		List<EmbeddedAnnotation> listEABackup = FAXE.getEmbeddedAnnotations(backUpDir);


		/***************************************************************************************/
		/** Go through backup list an copy all changes of requested feature into Git-Directory */
		/***************************************************************************************/
		if(listEA.size()!=listEABackup.size()) {
			System.out.println("ERROR: UNKOWN SITUATION. listEA.size()!=listEABackup.size()");
			return null;
		}

		System.out.println("Search for changed embedded annotation");
		boolean changeInStagingArea = false;	// tracks if any change will be moved to staging area
		for (int i = 0; i < listEA.size(); i++) {
			// check if searched feature
			String currentF = listEA.get(i).getFeature();


			// -> Both EA Lists contain the same element.
			// Check if content of parts is equal or different
			// Compare code in backup and working directory

			int openingLine = listEA.get(i).getOpeningLine();
			int closingLine = listEA.get(i).getClosingLine();
			boolean differenceFound = false;

			try {
				List<String> listLine = Files.readAllLines(Paths.get(listEA.get(i).getFile()));
				List<String> listLineBackup = Files.readAllLines(Paths.get(listEABackup.get(i).getFile()));
				for (int j = openingLine - 1; j < (closingLine); j++) {    // openingLine-1 -> due to line count start with 1 and List-object with 0
					String line = listLine.get(j);
					String lineBackup = listLineBackup.get(j);

					if (!line.equals(lineBackup)) {
						differenceFound = true;
						System.out.println("Feature " +listEA.get(i).getFeature() +" changed.");
						changedFeatures.add(listEA.get(i).getFeature());
					} /*else {
							System.out.println(line);
							System.out.println("Lines identical");
						}*/
				}
			} catch (IOException e) {
				System.out.println(e);
			}

		}    // for(int i=0; i<listEA.size(); i++)


		/**********************************/
		/** CLEANUP                       */
		/**********************************/
		// Close Git
		git.close();

		// Move data from backup to main
		try {
			System.out.println("Cleaning Up ...");
			TimeUnit.SECONDS.sleep(2);
			FileUtils.deleteDirectory(mainDir);

			System.out.println("FileUtils.forceMkdir(mainDir)");
			TimeUnit.SECONDS.sleep(2);
			FileUtils.forceMkdir(mainDir);

			System.out.println("FileUtils.copyDirectory(backUpDir,mainDir)");
			TimeUnit.SECONDS.sleep(2);
			FileUtils.copyDirectory(backUpDir,mainDir);

			// Delete backup folder
			FileUtils.deleteDirectory(backUpDir);
			System.out.println("            ... Done");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		System.out.println("<<< FeatureBasedPartialCommit::findChangedFeatures");
		return changedFeatures;
	}

	private static Git gitInitRepository(Git git, File mainDir) {
		/** ******************************************** */
		/** OPEN INSTANCE OF EXAMPLE PROJECT             */
		/** ******************************************** */
		try {
			git = Git.open(mainDir);
			System.out.println("Repository " +mainDir.getAbsolutePath() +" instantiated.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR: no Git repository found");
			e.printStackTrace();
		}
		return git;
	}

//	/**
//	 * Verifies the provided File and in case of non-existens to rework the given File path to find the file
//	 * @param inputFile File under analysis
//	 * @return inputFile if this one is existing
//	 *         File object with successfully reworked path
//	 *         NULL if rework did not succeed
//	 */
//	private File verifyReceivedFilePath(File inputFile){
//		// Refactor received path (if necessary) and return it for further proceeding
//		if(!gitWorkingDirectory.exists()){
//			System.out.println("Received path not found. Try to rework.");
//			String newPath = gitWorkingDirectory.getPath();
//			// remove leading "/"
//			newPath = newPath.substring(1);
//
//			// Switch "\" to "\\"
//			newPath = newPath.replace("\\", "\\\\");
//
//			// Individual drive letter? -> Add ":"
//			String[] strArr = newPath.split("\\\\", 2);
//			newPath = strArr[0].toUpperCase() +":" +strArr[1];
//
//			File newFilePath = new File(newPath);
//			if(newFilePath.exists()){
//				System.out.println("Reworked worked out, new path = " +newPath);
//				return newFilePath;
//			} else {
//				System.out.println("ERROR: Rework not possible. User to fix given path.");
//				return null;
//			}
//		} else {
//			return inputFile;
//		}
//	}
}
