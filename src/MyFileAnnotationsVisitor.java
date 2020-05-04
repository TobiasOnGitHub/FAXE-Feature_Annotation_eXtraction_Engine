import java.util.ArrayList;
import java.util.List;

public class MyFileAnnotationsVisitor extends fileAnnotationsBaseVisitor<Object> {
    private static final int POSITION_UNKNOWN = -1;
    private static final String NAME_UNKNOWN = null;
    private List<String> fileReferences = new ArrayList<>();
    private List<String> featureReferences = new ArrayList<>();

    @Override
    public Object visitFileAnnotation(fileAnnotationsParser.FileAnnotationContext ctx) {
        System.out.println("visitFileAnnotation");
        visitChildren(ctx);

        // Merge all found files with their annotations
        List<EmbeddedAnnotation> eaList = new ArrayList<>();
        for(String file : fileReferences){
            for(String feature : featureReferences){
                eaList.add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.eaType_FILE, file, POSITION_UNKNOWN, POSITION_UNKNOWN, feature));
            }
        }

        System.out.println("Completed visitFileAnnotation, found " +eaList.size() +" elements.");
        System.out.println( eaList.toString() );

        System.out.println("visitFileAnnotation - FINAL");
        return null;
    }

//    @Override
//    public Object visitFileReferences(fileAnnotationsParser.FileReferencesContext ctx) {
//        System.out.println("visitFileReferences");
//        return visitChildren(ctx);
//    }
//
//    @Override
//    public Object visitFileReference(fileAnnotationsParser.FileReferenceContext ctx) {
//        System.out.println("visitFileReference");
//        return visitChildren(ctx);
//    }

    @Override
    public Object visitFileName(fileAnnotationsParser.FileNameContext ctx) {
        System.out.println("visitFileName");
        fileReferences.add(ctx.getText());
        return visitChildren(ctx);
    }

//    @Override
//    public Object visitLpqReferences(fileAnnotationsParser.LpqReferencesContext ctx) {
//        System.out.println("visitLpqReferences");
//        return visitChildren(ctx);
//    }

    @Override
    public Object visitFeature(fileAnnotationsParser.FeatureContext ctx) {
        System.out.println("visitFeature");
        featureReferences.add(ctx.getText());
        return visitChildren(ctx);
    }

//    @Override
//    protected Object aggregateResult(Object aggregate, Object nextResult) {
//        System.out.println("aggregateResult");
//        if(aggregate==null && nextResult==null){
//            return null;
//        }
//        return null;
//    }
}
