package se.gu.faxe;

import java.util.List;

public class CommandLineUtility {

    /**
     * Main method for command line usage
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        System.out.println("FAXE startet.");

        List<EmbeddedAnnotation> eaList = FAXE.extractEAfromRootDirectory("C:\\Users\\Tobias\\git\\PartialCommitTestapplication6\\src");


//
//        long startTime = System.nanoTime();
//
//        /***************************************************/
//        /** PARAMETER DEFINITION                          **/
//        /***************************************************/
//        Options options = new Options();
//
//        Option projectScope = new Option("ps", "project-scope", true, "Print embedded annotations in project scope. (Extracting feature). Project path is provided as argument.");
//        projectScope.setRequired(false);
//        options.addOption(projectScope);
//
//        Option sourceFile = new Option("tf", "text-file", true, "Print embedded annotations from given source file. (Extracting feature). File path is provided as argument.");
//        sourceFile.setRequired(false);
//        options.addOption(sourceFile);
//
//        Option f2File = new Option("f2fi", "feature-to-file", true, "Print embedded annotations from feature-to-file mapping. (Extracting feature). File path is provided as argument.");
//        f2File.setRequired(false);
//        options.addOption(f2File);
//
//        Option f2Folder = new Option("f2fo", "feature-to-folder", true, "Print embedded annotations from feature-to-folder mapping. (Extracting feature). File path is provided as argument.");
//        f2Folder.setRequired(false);
//        options.addOption(f2Folder);
//
//        Option uniqueFeatures = new Option("u", "unique", false, "Reduce print of extracted data to unique features. (Filter function).");
//        uniqueFeatures.setRequired(false);
//        options.addOption(uniqueFeatures);
//
//        Option findFeature = new Option("f", "feature", true, "Reduce print of extracted data to given feature. (Filter function). Feature name is provided as argument.");
//        findFeature.setRequired(false);
//        options.addOption(findFeature);
//
//        CommandLineParser parser = new DefaultParser();
//        HelpFormatter formatter = new HelpFormatter();
//        CommandLine cmd = null;
//
//        try {
//            cmd = parser.parse(options, args);
//        } catch (ParseException e) {
//            System.out.println(e.getMessage());
//            formatter.printHelp("FAXE Command Line Utility", options);
//
//            System.exit(1);
//        }
//
//        /***************************************************/
//        /** PARAMETER INTERPRETATION                      **/
//        /***************************************************/
//        if(cmd.hasOption("project-scope")) {
//            String inputParameter = cmd.getOptionValue("project-scope");
//            System.out.println("Search EA in project scope: " +inputParameter);
//
//            List<EmbeddedAnnotation> eaList = FAXE.extractEAfromRootDirectory(inputParameter);
//
//            if(eaList!=null) {
//                if(cmd.hasOption("unique")) {
//                    System.out.println("EA unique:" +FAXE.extractUniqueFeatures(eaList));
//                } else {
//                    System.out.println("EA:" +eaList.toString());
//                    System.out.println("-------------------------------------------");
//                    if(cmd.hasOption("feature")) {
//                        String searchFeature = cmd.getOptionValue("feature");
//                        System.out.println("Search Feature: " +searchFeature);
//
//                        List<EmbeddedAnnotation> eaListFiltered = FAXE.extractSpecificFeature(eaList, searchFeature);
//
//                        if(!eaListFiltered.isEmpty()){
//                            System.out.println(eaListFiltered.toString());
//                        } else {
//                            System.out.println("Feature \"" +searchFeature +"\" not present in search.");
//                        }
//
//                    }
//
//                }
//            }
//        }
//
//        if(cmd.hasOption("text-file")) {
//            String inputParameter = cmd.getOptionValue("text-file");
//            System.out.println("Search EA in source file: " +inputParameter);
//
//            List<EmbeddedAnnotation> eaList = FAXE.extractEAfromSourceCode(inputParameter);
//
//            if(eaList!=null) {
//                if(cmd.hasOption("unique")) {
//                    System.out.println("EA unique:" +FAXE.extractUniqueFeatures(eaList));
//                } else {
//                    System.out.println("EA:" +eaList.toString());
//                }
//            }
//        }
//
//        if(cmd.hasOption("feature-to-file")) {
//            String inputParameter = cmd.getOptionValue("feature-to-file");
//            System.out.println("Search EA in source file: " +inputParameter);
//
//            List<EmbeddedAnnotation> eaList = FAXE.extractEAfromFeatureFile(inputParameter);
//
//            if(eaList!=null) {
//                if(cmd.hasOption("unique")) {
//                    System.out.println("EA unique:" +FAXE.extractUniqueFeatures(eaList));
//                } else {
//                    System.out.println("EA:" +eaList.toString());
//                }
//            }
//        }
//
//        if(cmd.hasOption("feature-to-folder")) {
//            String inputParameter = cmd.getOptionValue("feature-to-folder");
//            System.out.println("Search EA in source file: " +inputParameter);
//
//            List<EmbeddedAnnotation> eaList = FAXE.extractEAfromFeatureFolder(inputParameter);
//
//            if(eaList!=null) {
//                if(cmd.hasOption("unique")) {
//                    System.out.println("EA unique:" +FAXE.extractUniqueFeatures(eaList));
//                } else {
//                    System.out.println("EA:" +eaList.toString());
//                }
//            }
//        }

    }   // public main(...)

}   // class CommandLineUtility
