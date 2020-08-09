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
        subcommands = {CheckConsistency.class, Get.class, CLIMetrics.class, Rename.class})
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


@Command(name = "get", description = "Get embedded annotation from the given parameter source")
class Get implements Callable<Integer> {

    @Parameters(index = "0", description = "The file/folder to be analyzed. Files might be any text asset as well as feature-to-folder/-file mapping files.")
    private File file;

    @Option(names = {"-f", "--feature"}, description = "Extract annotations for <feature> specified in LPQ format")
    private String featureLPQ = "";

    @Override
    public Integer call() throws Exception {
        List<EmbeddedAnnotation> eaList = null;

        if(file.isDirectory()){
            System.out.println("UC1 - Return all embedded annotations from the whole project");
            System.out.printf("Directory name: " +file.toString());

            eaList = FAXE.getEmbeddedAnnotations(file);

        } else if(file.isFile()){

            if(file.getName().endsWith(".feature-folder")){
                System.out.println("UC2 - Return all embedded annotations from one feature-to-folder mapping file");
                System.out.println("File name: " +file.toString());
            } else if(file.getName().endsWith(".feature-file")){
                System.out.println("UC3 - Return all embedded annotations from one feature-to-file mapping file");
                System.out.println("File name: " +file.toString());
            } else if(file.getName().endsWith(".cfr")){
                System.out.println("UC5 - Return feature model");
                System.out.println("File name: " +file.toString());
            } else {
                //System.out.println("UC4 - Return all embedded annotations from one textual asset (file)");
                //System.out.println("File name: " +file.toString());

                eaList = FAXE.getEmbeddedAnnotations(file);
            }

        }

        if(featureLPQ.compareTo("")!=0){
            //System.out.println("UC7 - Return all embedded annotations for one specific feature");
            System.out.println("Search for LPQ \"" +featureLPQ.toString() +"\" in " +file.toString());

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

@Command(name = "metric", description = "Get metrics of embedded annotation in given parameter source")
class CLIMetrics implements Callable<Integer> {
    @Parameters(index = "0", description = "The file/folder to be checked.")
    private File file;

    @Option(names = {"-s", "--scattering-degree"}, description = "Provide Scattering degree of the given parameter source")
    private boolean getMetricsScattering = false;

    @Option(names = {"-t", "--tangling-degree"}, description = "Provide Scattering degree and tangling degree of the given parameter source")
    private boolean getMetricsTangling = false;

    @Override
    public Integer call() throws Exception {
        System.out.println("UC14 - Metrics such as scattering and tangling degree shall be provided");

        return 0;
    }
}


@Command(name = "checkConsistency", description = "Checks the consistency of embedded annotation definition from the given parameter source")
class CheckConsistency implements Callable<Integer> {
    @Parameters(index = "0", description = "The file/folder to be checked.")
    private File file;

    @Override
    public Integer call() throws Exception {
        System.out.println("UC11 - Verify consistency with embedded annotation specification");

        if(file.isDirectory()){
            System.out.println("... for the (whole) project folder");
            System.out.printf("Directory name: " +file.toString());
        } else if(file.isFile()){

            if(file.getName().endsWith(".feature-folder")){
                System.out.println("... feature-to-folder mapping");
                System.out.println("File name: " +file.toString());
            } else if(file.getName().endsWith(".feature-file")){
                System.out.println("... feature-to-file mapping");
                System.out.println("File name: " +file.toString());
            } else if(file.getName().endsWith(".cfr")){
                System.out.println("... the feature file");
                System.out.println("File name: " +file.toString());
            } else {
                System.out.println("... textual asset");
                System.out.println("File name: " +file.toString());
            }

        }

        return 0;
    }
}


@Command(name = "rename", description = "Renames all LPQ feature names.")
class Rename implements Callable<Integer> {

    @Parameters(index = "0", description = "The file/folder to be checked.")
    private File file;

    @Parameters(index = "1", description = "LPQ to be renamed.")
    private String lpqFrom;

    @Parameters(index = "2", description = "New LPQ name.")
    private String lpqTo;

    @Override
    public Integer call() throws Exception {
        System.out.println("File: " +file);
        System.out.println("From: " +lpqFrom);
        System.out.println("To:   " +lpqTo);
        return 0;
    }
}