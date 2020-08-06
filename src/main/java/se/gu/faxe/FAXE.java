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
package se.gu.faxe;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTree;
import org.json.CDL;
import org.json.JSONArray;
import se.gu.faxe.Grammar.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * This class offers the access to the library functions to extract embedded annotations of your project/source code.
 */
public class FAXE {

    /**
     * Method to extract embedded annotations from given root directory. The root directory and all sub-directories are
     * checked for EA in source code, files and folders. In addition the hierarchy file is analysed.
     * @param rootDirectory String of root directory.
     * @return List of found embedded annotations.
     */
    public static List<EmbeddedAnnotation> extractEAfromRootDirectory(String rootDirectory){
        List<EmbeddedAnnotation> eaList = new ArrayList<>();
        System.out.println(">>> FAXE: EA extraction from " +rootDirectory +" started ...");

        /* Create a re-usable object for "Stream<Path> paths = Files.walk(Paths.get("C:\\\\EA_Examples\\\\ClaferMooVisualizer\\\\Server\\\\Client\\\\")) " */
        Supplier<Stream<Path>> streamSupplier = () -> {
            try {
                return Files.walk(Paths.get(rootDirectory));
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        };

        /**********************************/
        /** ANALYSIS OF SOURCE CODE      **/
        /**********************************/
        /* From root directory go through all individual files */
        /* Check for EA in each file */
        streamSupplier.get().filter(Files::isRegularFile).forEach(s -> eaList.addAll(extractEAfromSourceCode(s.toString())));

        /**********************************/
        /** ANALYSIS OF FEATURE-TO-FILE  **/
        /**********************************/
//        streamSupplier.get().map(x -> x.toString()).filter(f -> f.endsWith(".feature-file")).forEach(System.out::println);
        streamSupplier.get().map(x -> x.toString()).filter(f -> f.endsWith(".feature-file")).forEach(s -> eaList.addAll(extractEAfromFeatureFile(s.toString())));

        /***********************************/
        /** ANALYSIS OF FEATURE-TO-FOLDER **/
        /***********************************/
        streamSupplier.get().map(x -> x.toString()).filter(f -> f.endsWith(".feature-folder")).forEach(s -> eaList.addAll(extractEAfromFeatureFolder(s.toString())));

        /******************************************/
        /** ANALYSIS OF CLAFER FEATURE HIERARCHY **/
        /******************************************/
        //TODO - Implement CLAFER hierarchy file interpretation according to given Grammar


        System.out.println("<<< FAXE: EA extraction completed. Found " +eaList.size() +" embedded annotations.");
        return eaList;
    }


    /**
     * Method to extract embedded annotations on source code level of given file.
     * @param fileToAnalyze String of to be analyzed file.
     * @return List of found embedded annotations.
     */
    public static List<EmbeddedAnnotation> extractEAfromSourceCode(String fileToAnalyze){
        CharStream in = null;
        try {
            in = CharStreams.fromFileName(fileToAnalyze);
        } catch (IOException e) {
            try {
                System.out.println("No file found: " +(new File(".").getCanonicalPath()) + "\\" +fileToAnalyze);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            e.printStackTrace();
        }
        codeAnnotationLexer lexer = new codeAnnotationLexer(in);
        lexer.addErrorListener(ThrowingErrorListener.INSTANCE);
        CommonTokenStream token = new CommonTokenStream(lexer);
        codeAnnotationParser parser = new codeAnnotationParser(token);
        parser.removeErrorListeners();
        parser.addErrorListener(ThrowingErrorListener.INSTANCE);

        List<EmbeddedAnnotation> eaList = new ArrayList<>();
        try {
            ParseTree tree = parser.marker();

            MyCodeAnnotationsVisitor visitor = new MyCodeAnnotationsVisitor();
            eaList = (List<EmbeddedAnnotation>) visitor.visit(tree);
        } catch (ParseCancellationException e) {
            // Catch if given string is not fitting the grammar
            System.out.println("ERROR DETECTED :)");
        }
        return eaList;
    }


    /**
     * Method to extract embedded annotations on file level of given file.
     * @param fileUnderTest String of to be analyzed file.
     * @return List of found embedded annotations.
     */
    public static List<EmbeddedAnnotation> extractEAfromFeatureFile(String fileUnderTest){
        CharStream in = null;
        try {
            in = CharStreams.fromFileName(fileUnderTest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        fileAnnotationsLexer lexer = new fileAnnotationsLexer(in);
        lexer.addErrorListener(ThrowingErrorListener.INSTANCE);
        CommonTokenStream token = new CommonTokenStream(lexer);
        fileAnnotationsParser parser = new fileAnnotationsParser(token);
        parser.removeErrorListeners();
        parser.addErrorListener(ThrowingErrorListener.INSTANCE);

        List<EmbeddedAnnotation> eaList = new ArrayList<>();
        try {
            ParseTree tree = parser.fileAnnotations();

            MyFileAnnotationsVisitor visitor = new MyFileAnnotationsVisitor();
            eaList = (List<EmbeddedAnnotation>) visitor.visit(tree);
            //if(eaList!=null) System.out.println("EA:" +eaList.toString());
        } catch (ParseCancellationException e) {
            // Catch if given string is not fitting the grammar
            System.out.println("ERROR DETECTED :)");
            return null;
        }
        return eaList;
    }


    /**
     * Method to extract embedded annotations on folder level of given folder.
     * @param folderUnderTest String of to be analyzed folder.
     * @return List of found embedded annotations.
     */
    public static List<EmbeddedAnnotation> extractEAfromFeatureFolder(String folderUnderTest){
        CharStream in = null;
        try {
            in = CharStreams.fromFileName(folderUnderTest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        folderAnnotationsLexer lexer = new folderAnnotationsLexer(in);
        lexer.addErrorListener(ThrowingErrorListener.INSTANCE);
        CommonTokenStream token = new CommonTokenStream(lexer);
        folderAnnotationsParser parser = new folderAnnotationsParser(token);
        parser.removeErrorListeners();
        parser.addErrorListener(ThrowingErrorListener.INSTANCE);

        List<EmbeddedAnnotation> eaList;
        try {
            ParseTree tree = parser.folderAnnotation();

            MyFolderAnnotationVisitor visitor = new MyFolderAnnotationVisitor();
            eaList = (List<EmbeddedAnnotation>) visitor.visit(tree);
//            if(eaList!=null) System.out.println("EA:" +eaList.toString());
        } catch (ParseCancellationException e) {
            // Catch if given string is not fitting the grammar
            System.out.println("ERROR DETECTED :)");
            return null;
        }
        return eaList;
    }



    /**
     * Takes input String and checks if valid according to code annotation grammar.
     * @param line source code line under verification
     * @return true when valid ; false when invalid
     */
    static boolean parseCodeAnnotationLine(String line) {
        CharStream in = CharStreams.fromString(line);
        codeAnnotationLexer lexer = new codeAnnotationLexer(in);
        lexer.addErrorListener(ThrowingErrorListener.INSTANCE);
        CommonTokenStream token = new CommonTokenStream(lexer);
        codeAnnotationParser parser = new codeAnnotationParser(token);
        parser.removeErrorListeners();
        parser.addErrorListener(ThrowingErrorListener.INSTANCE);

        try {
            ParseTree tree = parser.marker();

            MyCodeAnnotationsVisitor visitor = new MyCodeAnnotationsVisitor();
            List<EmbeddedAnnotation> eaList = (List<EmbeddedAnnotation>) visitor.visit(tree);
            System.out.println("EA:" +eaList.toString());
        } catch (ParseCancellationException e) {
            // Catch if given string is not fitting the grammar
            System.out.println("ERROR DETECTED :)");
            return false;
        }
        return true;
    }


    /**
     * Takes input String and checks if valid according to file annotation grammar.
     * @param line source code line under verification
     * @return true when valid ; false when invalid
     */
    static boolean parseFileAnnotationLine(String line) {
        CharStream in = CharStreams.fromString(line);
        fileAnnotationsLexer lexer = new fileAnnotationsLexer(in);
        lexer.addErrorListener(ThrowingErrorListener.INSTANCE);
        CommonTokenStream token = new CommonTokenStream(lexer);
        fileAnnotationsParser parser = new fileAnnotationsParser(token);
        parser.removeErrorListeners();
        parser.addErrorListener(ThrowingErrorListener.INSTANCE);

        try {
            ParseTree tree = parser.fileAnnotation();

            MyFileAnnotationsVisitor visitor = new MyFileAnnotationsVisitor();
            List<EmbeddedAnnotation> eaList = (List<EmbeddedAnnotation>) visitor.visit(tree);
            if (eaList != null) System.out.println("EA:" + eaList.toString());
        } catch (ParseCancellationException e) {
            // Catch if given string is not fitting the grammar
            System.out.println("ERROR DETECTED :)");
            return false;
        }
        return true;
    }


    /**
     * Takes input String and checks if valid according to folder annotation grammar.
     * @param line source code line under verification
     * @return true when valid ; false when invalid
     */
    static boolean parseFolderAnnotationLine(String line) {
        CharStream in = CharStreams.fromString(line);
        folderAnnotationsLexer lexer = new folderAnnotationsLexer(in);
        lexer.addErrorListener(ThrowingErrorListener.INSTANCE);
        CommonTokenStream token = new CommonTokenStream(lexer);
        folderAnnotationsParser parser = new folderAnnotationsParser(token);
        parser.removeErrorListeners();
        parser.addErrorListener(ThrowingErrorListener.INSTANCE);

        try {
            ParseTree tree = parser.folderAnnotation();

            MyFolderAnnotationVisitor visitor = new MyFolderAnnotationVisitor();
            List<EmbeddedAnnotation> eaList = (List<EmbeddedAnnotation>) visitor.visit(tree);
            if(eaList!=null) System.out.println("EA:" +eaList.toString());
        } catch (ParseCancellationException e) {
            // Catch if given string is not fitting the grammar
            System.out.println("ERROR DETECTED :)");
            return false;
        }
        return true;
    }


    /**
     * Transforms list of {@link EmbeddedAnnotation} to JSON object.
     * @param eaList List of {@link EmbeddedAnnotation}
     * @return JSON object out of parameter.
     */
    public static JSONArray serializeEAList2JSON(List<EmbeddedAnnotation> eaList){
        JSONArray ja = new JSONArray();
        ja.put("eaType");
        ja.put("File");
        ja.put("OpeningLine");
        ja.put("ClosingLine");
        ja.put("Feature");

        String serialList = "";
        for(int i=0; i<eaList.size(); i++){
            serialList += eaList.get(i).serialize()+'\n';
        }

        JSONArray result = CDL.toJSONArray(ja, serialList);

        return result;
    }


//    TODO - NOT SUPPORTED AS USE CASE MISSING
//    /**
//     * Transforms JSON object to list of {@link EmbeddedAnnotation}
//     * @param jsonArray JSON object
//     * @return List of {@link EmbeddedAnnotation} out of parameter.
//     */
//    public static List<EmbeddedAnnotation> deserializeEAList2JSON(JSONArray jsonArray){
//        ArrayList<EmbeddedAnnotation> list = new ArrayList<>();
//
//        if (jsonArray != null) {
//            for (int i=0;i<jsonArray.length();i++){
//                list.add(EmbeddedAnnotation.deserialize(jsonArray.get(i).toString()));
//            }
//        } else {
//            System.out.println("WARNING: deserializeEAList2JSON - empty JSONArray file (null)!");
//        }
//
//        return list;
//    }

    /**
     * Stream function to identify unique elements in Object with help of given method.
     */
    private static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        // https://www.baeldung.com/java-streams-distinct-by
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

    /**
     * Extracts list of individual features from given {@link EmbeddedAnnotation} list.
     * @param eaList List with {@link EmbeddedAnnotation} to be proceeded.
     * @return List of feature names - uniquely listed.
     */
    public static List<String> extractUniqueFeatures(List<EmbeddedAnnotation> eaList){
        List<EmbeddedAnnotation> eaListFiltered = eaList.stream()
                .filter(distinctByKey(p -> p.getFeature()))
                .collect(Collectors.toList());

        List<String> eaString = eaListFiltered.stream().map(e -> e.getFeature()).collect(Collectors.toList());
        Collections.sort(eaString);
        return eaString;
    }

    /**
     * Extracts specific feature from List of {@link EmbeddedAnnotation}.
     * @param eaList List to extract feature from.
     * @param searchFeature To be searched feature.
     * @return List of {@link EmbeddedAnnotation} for only the given feature.
     */
    public static List<EmbeddedAnnotation> extractSpecificFeature(List<EmbeddedAnnotation> eaList, String searchFeature){
        List<EmbeddedAnnotation> eaListFiltered = eaList.stream()
                .filter(ea -> ea.getFeature().equals(searchFeature))
                .collect(Collectors.toList());

        return eaListFiltered;
    }
}
