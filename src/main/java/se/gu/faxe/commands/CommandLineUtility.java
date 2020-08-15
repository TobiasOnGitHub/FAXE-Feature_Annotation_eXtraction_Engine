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

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import se.gu.faxe.EmbeddedAnnotation;
import se.gu.faxe.FAXE;

import java.io.File;
import java.util.List;
import java.util.concurrent.Callable;

@Command(name = "", mixinStandardHelpOptions = true, version = "faxe 0.1", description = "Feature Annotations eXtraction Engine. Provides from given source a list of embedded annotations.",
        subcommands = {CheckConsistency.class, Get.class, CLIMetrics.class, Rename.class, FeatureBasedPartialCommit.class})
public class CommandLineUtility implements Callable<Integer> {

//    @Parameters(index = "0", description = "The folder/file to be analyzed.")
//    private File file;

    /**
     * Main method for command line usage
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        int exitCode = new CommandLine(new CommandLineUtility()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public Integer call() throws Exception { // your business logic goes here...
//        System.out.println("CALL GET WITH GIVEN PATH");
        return 0;
    }

}   // class CommandLineUtility


@Command(name = "getEmbeddedAnnotations", description = "Extracts and returns embedded annotations from an asset’s path for the feature in lpq, and exports the output to a file if the flag export is set. If lpq is not specified, it extracts all annotations from path.")
class Get implements Callable<Integer> {

    @Parameters(index = "0", description = "Asset's path (file|folder) to extract and return embedded annotations from.")
    private File path;

    @Option(names = {"-l", "--lpq"}, description = "Feature in lpq.")
    private String featureLPQ = "";

    @Option(names = {"-e", "--export"}, description = "Exports the output to a file if the flag export is set.")
    private boolean export = false;

    @Override
    public Integer call() throws Exception {
        List<EmbeddedAnnotation> eaList = null;

        if(path.isDirectory()){
            System.out.println("UC1 - Return all embedded annotations from the whole project");
            System.out.printf("Directory name: " + path.toString());

            eaList = FAXE.getEmbeddedAnnotations(path);

        } else if(path.isFile()){

            if(path.getName().endsWith(".feature-folder")){
                System.out.println("UC2 - Return all embedded annotations from one feature-to-folder mapping file");
                System.out.println("File name: " + path.toString());
            } else if(path.getName().endsWith(".feature-file")){
                System.out.println("UC3 - Return all embedded annotations from one feature-to-file mapping file");
                System.out.println("File name: " + path.toString());
            } else if(path.getName().endsWith(".cfr")){
                System.out.println("UC5 - Return feature model");
                System.out.println("File name: " + path.toString());
            } else {
                //System.out.println("UC4 - Return all embedded annotations from one textual asset (file)");
                //System.out.println("File name: " +file.toString());

                eaList = FAXE.getEmbeddedAnnotations(path);
            }

        }

        if(featureLPQ.compareTo("")!=0){
            //System.out.println("UC7 - Return all embedded annotations for one specific feature");
            System.out.println("Search for LPQ \"" +featureLPQ.toString() +"\" in " + path.toString());

            eaList.stream()
                  .filter(ea -> ea.getFeature().equals(featureLPQ.toString()))
                  .forEach(System.out::println);
        } else {
            // As no filtering happens, show whole list
            System.out.println(eaList.toString());
        }

        return 0;
    }
}

@Command(name = "calculateMetric", description = "Calculates and returns required metric (enum) for the feature referred to in the lpq from the given path. It also exports the output to a file if the flag export is set. If metric is not specified, all metrics are calculated and exported.")
class CLIMetrics implements Callable<Integer> {
    /* Metrics derived from FeatureDashboard - Sina Entekhabi, Anton Solback, Jan-Philipp Steghöfer, and Thorsten Berger. 2019. Visualization of Feature Locations with the Tool FeatureDashboard. In Proceedings of the 23rd International Systems and Software Product Line Conference - Volume B (SPLC ’19). Association for Computing Machinery, New York, NY, USA, 1–4. DOI:https://doi.org/10.1145/3307630.3342392
     * and FLORIDA - Berima Andam, Andreas Burger, Thorsten Berger, and Michel R. V. Chaudron. 2017. FLOrIDA: Feature LOcatIon DAshboard for extracting and visualizing feature traces. In Proceedings of the Eleventh International Workshop on Variability Modelling of Software-intensive Systems (VAMOS ’17). Association for Computing Machinery, New York, NY, USA, 100–107. DOI:https://doi.org/10.1145/3023956.3023967
     */
    enum eMetrics {
        ALL,
        /* FEATURE METRICS */
        SD,     // Scattering Degree: total number of all annotations directly referencing the feature (i.e., in-file, folder, and file annotations referencing it)
        NoFiA,  // Number of File Annotations: total number of file annotations directly referencing the feature
        NoFoA,  // Number of Folder Annotations: total number of folder annotations directly referencing the feature.
        TD,     // Tangling Degree: number of other features that share the same artifacts (or parts of such) with the feature. Two features share (parts of) artifacts when the latter is annotated with both features.
        LoFC,   // Lines of Feature Code: lines of code belonging to artifacts, either directly annotated, or indirectly (when a folder is annotated, all descendants are taken into account)
        AvgND,  /* Nesting depths of annotations: Maximum (MaxND), Minimum (MinND), and Average (AvgND) nesting depth the annotations directly referencing the feature. The project’s root folder has depth 0 (and so has any file contained in it). */
        MaxND,  /* Each sub-folder increases the depth by one, a file inherits the depth of its containing folder. The depth of a (top-level, i.e., non-nested) in-file annotation is the depth of the file increased by one. Since in-file annotations */
        MinND,  /* can be nested, each nesting increases the depth by one. All nesting-depth metrics are calculated relative to the project root folder. */
        NoAu,   // Number of Authors who contributed to a feature’s artifact. Author information is automatically extracted from author tags (format: “Author: firstname lastname”) in comments wrapped by “/**” and “*/” in the source code if they exist.
        /* FOLDER METRICS */
        NoF,    // Number of Features: total number of features directly referenced in annotations (folder, file, in-file) of the folder and any of its descendants
        LoFoC,  // Lines of Folder Code: total lines in any descendant file of the folder
        NoFi,   //Number of Files: number of all descendant files of the folder
        /* PROJECT METRICS */
        // NoF      // Number of features in project => With FAXE implicit given with path to root folder
        // Total LoFC   // Total Lines of Feature Code: sum of LoFC (all features) => With FAXE implicit given with path to root folder
        AvgLoFC,    // Average Feature Lines of Code: sum of LoFC (all features) / NoF
        //AvgND,    // Average Feature Nesting Depth: sum of ND (all features) / NoF
        AvgSD       // Average Feature Scattering Degree: sum of SD (all features) / NoF

    }

    @Parameters(index = "0", description = "Asset's path (file|folder) to calculates and returns required metric from.")
    private File path;

    @Option(names = {"-m", "--metric"}, description = "Provide Scattering degree of the given parameter source. Valid values: ${COMPLETION-CANDIDATES}.")
    private eMetrics metric = eMetrics.ALL;

    @Option(names = {"-l", "--lpq"}, description = "Feature in lpq.")
    private String featureLPQ = "";

    @Option(names = {"-e", "--export"}, description = "Exports the output to a file if the flag export is set.")
    private boolean export = false;

    @Override
    public Integer call() throws Exception {
        System.out.println("UC14 - Metrics such as scattering and tangling degree shall be provided");

        return 0;
    }
}


@Command(name = "checkConsistency", description = "Checks and prints inconsistencies in annotations in the given path.")
class CheckConsistency implements Callable<Integer> {
    @Parameters(index = "0", description = "Asset's path (file|folder) to check and print inconsistencies in annotations.")
    private File path;

    @Override
    public Integer call() throws Exception {
        System.out.println("UC11 - Verify consistency with embedded annotation specification");

        if(path.isDirectory()){
            System.out.println("... for the (whole) project folder");
            System.out.printf("Directory name: " + path.toString());
        } else if(path.isFile()){

            if(path.getName().endsWith(".feature-folder")){
                System.out.println("... feature-to-folder mapping");
                System.out.println("File name: " + path.toString());
            } else if(path.getName().endsWith(".feature-file")){
                System.out.println("... feature-to-file mapping");
                System.out.println("File name: " + path.toString());
            } else if(path.getName().endsWith(".cfr")){
                System.out.println("... the feature file");
                System.out.println("File name: " + path.toString());
            } else {
                System.out.println("... textual asset");
                System.out.println("File name: " + path.toString());
            }

        }

        return 0;
    }
}


@Command(name = "rename", description = "Renames the feature referred to in lpq to newname in the feature model and all annotations.")
class Rename implements Callable<Integer> {

    @Parameters(index = "0", description = "Asset's path (file|folder) to rename the lpq.")
    private File path;

    @Parameters(index = "1", description = "LPQ to be renamed.")
    private String lpqFrom;

    @Parameters(index = "2", description = "New name of LPQ.")
    private String lpqTo;

//    @Option(names = {"-f", "--lpqFrom"}, description = "LPQ to be renamed.")
//    private String lpqFrom;
//
//    @Option(names = {"-t", "--lpqTo"}, description = "LPQ to be renamed.")
//    private String lpqTo;

    @Override
    public Integer call() throws Exception {
        System.out.println("File: " +path);
        System.out.println("From: " +lpqFrom);
        System.out.println("To:   " +lpqTo);
        return 0;
    }
}