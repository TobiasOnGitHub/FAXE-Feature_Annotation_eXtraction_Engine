package FAXE;

import FAXE.Grammar.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyFileAnnotationsVisitor extends fileAnnotationsBaseVisitor<Object> {
    private static final int POSITION_UNKNOWN = -1;
    private static final String NAME_UNKNOWN = null;
    private List<String> fileReferences = new ArrayList<>();
    private List<String> featureReferences = new ArrayList<>();

    @Override
    public Object visitFileAnnotations(fileAnnotationsParser.FileAnnotationsContext ctx) {
        List<EmbeddedAnnotation> eaList = new ArrayList<>();
        eaList.addAll((Collection<? extends EmbeddedAnnotation>) visitChildren(ctx));
        return eaList;
    }

    @Override
    public List<EmbeddedAnnotation> visitFileAnnotation(fileAnnotationsParser.FileAnnotationContext ctx) {
//        System.out.println("visitFileAnnotation");
        visitChildren(ctx);

        // Merge all found files with their annotations
        List<EmbeddedAnnotation> eaList = new ArrayList<>();
        for(String file : fileReferences){
            // "file" is provided in feature-file with relative path -> adjust this path to its project root
            String annotationFilePath = ctx.start.getInputStream().getSourceName();
            int endIndex = annotationFilePath.lastIndexOf("\\");
            if (endIndex != -1) {
                annotationFilePath = annotationFilePath.substring(0, endIndex);
            }
            file = annotationFilePath+"\\"+file;

            //file = "src/FAXE.MyFileAnnotationsVisitor.java";

            // Verify that file actually exist, if not print warning
            if(new File(file).exists()==false){
                System.out.println("WARNING: Referred file \"" +file +"\" does not exist in file system!");
            }

            for(String feature : featureReferences){
                eaList.add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.FILE, file, POSITION_UNKNOWN, POSITION_UNKNOWN, feature));
            }
        }

//        System.out.println("Completed visitFileAnnotation, found " +eaList.size() +" elements.");
//        System.out.println( eaList.toString() );
        return eaList;
    }

    @Override
    public Object visitFileName(fileAnnotationsParser.FileNameContext ctx) {
//        System.out.println("visitFileName");
        fileReferences.add(ctx.getText());
        return visitChildren(ctx);
    }

    @Override
    public Object visitFeature(fileAnnotationsParser.FeatureContext ctx) {
//        System.out.println("visitFeature");
        featureReferences.add(ctx.getText());
        return visitChildren(ctx);
    }

}
