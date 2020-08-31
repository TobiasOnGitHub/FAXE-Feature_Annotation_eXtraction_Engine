package se.gu.faxe.commands;

import java.io.File;

public class CommonMethods {

    /**
     * Verifies the provided File and in case of non-existens to rework the given File path to find the file
     * @param gitWorkingDirectory File under analysis
     * @return inputFile if this one is existing
     *         File object with successfully reworked path
     *         NULL if rework did not succeed
     */
    static File verifyReceivedFilePath(File gitWorkingDirectory){
        // Refactor received path (if necessary) and return it for further proceeding
        if(!gitWorkingDirectory.exists()){
            System.out.println("Received path not found. Try to rework.");
            String newPath = gitWorkingDirectory.getPath();
            // remove leading "/"
            newPath = newPath.substring(1);

            // Switch "\" to "\\"
            newPath = newPath.replace("\\", "\\\\");

            // Individual drive letter? -> Add ":"
            String[] strArr = newPath.split("\\\\", 2);
            newPath = strArr[0].toUpperCase() +":" +strArr[1];

            File newFilePath = new File(newPath);
            if(newFilePath.exists()){
                System.out.println("Reworked worked out, new path = " +newPath);
                return newFilePath;
            } else {
                System.out.println("ERROR: Rework not possible. User to fix given path.");
                return null;
            }
        } else {
            return gitWorkingDirectory;
        }
    }

}
