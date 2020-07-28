package FAXE;

import org.apache.commons.cli.*;

import java.util.List;

public class CommandLineUtility {

    /**
     * Main method for command line usage
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        /***************************************************/
        /** PARAMETER DEFINITION                          **/
        /***************************************************/
        Options options = new Options();

        Option projectScope = new Option("ps", "project-scope", true, "Print embedded annotations in project scope");
        projectScope.setRequired(false);
        options.addOption(projectScope);

        Option sourceFile = new Option("sf", "source-file", true, "Print embedded annotations from given source file");
        sourceFile.setRequired(false);
        options.addOption(sourceFile);

        Option f2File = new Option("f2fi", "feature-to-file", true, "Print embedded annotations from feature-to-file mapping");
        f2File.setRequired(false);
        options.addOption(f2File);

        Option f2Folder = new Option("f2fo", "feature-to-folder", true, "Print embedded annotations from feature-to-folder mapping");
        f2Folder.setRequired(false);
        options.addOption(f2Folder);

        Option uniqueFeatures = new Option("u", "unique", false, "Reduce print of embedded annotations to unique features");
        uniqueFeatures.setRequired(false);
        options.addOption(uniqueFeatures);

        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine cmd = null;

        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("utility-name", options);

            System.exit(1);
        }

        /***************************************************/
        /** PARAMETER INTERPRETATION                      **/
        /***************************************************/
        if(cmd.hasOption("project-scope")) {
            String inputParameter = cmd.getOptionValue("project-scope");
            System.out.println("Search EA in project scope: " +inputParameter);

            List<EmbeddedAnnotation> eaList = FAXE.extractEAfromRootDirectory(inputParameter);

            if(eaList!=null) {
                if(cmd.hasOption("unique")) {
                    System.out.println("EA unique:" +FAXE.extractUniqueFeatures(eaList));
                } else {
                    System.out.println("EA:" +eaList.toString());
                }
            }
        }

        if(cmd.hasOption("source-file")) {
            String inputParameter = cmd.getOptionValue("source-file");
            System.out.println("Search EA in source file: " +inputParameter);

            List<EmbeddedAnnotation> eaList = FAXE.extractEAfromSourceCode(inputParameter);

            if(eaList!=null) {
                if(cmd.hasOption("unique")) {
                    System.out.println("EA unique:" +FAXE.extractUniqueFeatures(eaList));
                } else {
                    System.out.println("EA:" +eaList.toString());
                }
            }
        }

        if(cmd.hasOption("feature-to-file")) {
            String inputParameter = cmd.getOptionValue("feature-to-file");
            System.out.println("Search EA in source file: " +inputParameter);

            List<EmbeddedAnnotation> eaList = FAXE.extractEAfromFeatureFile(inputParameter);

            if(eaList!=null) {
                if(cmd.hasOption("unique")) {
                    System.out.println("EA unique:" +FAXE.extractUniqueFeatures(eaList));
                } else {
                    System.out.println("EA:" +eaList.toString());
                }
            }
        }

        if(cmd.hasOption("feature-to-folder")) {
            String inputParameter = cmd.getOptionValue("feature-to-folder");
            System.out.println("Search EA in source file: " +inputParameter);

            List<EmbeddedAnnotation> eaList = FAXE.extractEAfromFeatureFolder(inputParameter);

            if(eaList!=null) {
                if(cmd.hasOption("unique")) {
                    System.out.println("EA unique:" +FAXE.extractUniqueFeatures(eaList));
                } else {
                    System.out.println("EA:" +eaList.toString());
                }
            }
        }

    }   // public main(...)

}   // class CommandLineUtility
