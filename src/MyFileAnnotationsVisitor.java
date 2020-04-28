import java.util.List;

public class MyFileAnnotationsVisitor extends fileAnnotationsBaseVisitor<Object> {
    private static final int POSITION_UNKNOWN = -1;
    private static final String NAME_UNKNOWN = null;

    @Override
    public List<EmbeddedAnnotation> visitFileAnnotation(fileAnnotationsParser.FileAnnotationContext ctx) {
        List<EmbeddedAnnotation> eaList = (List<EmbeddedAnnotation>) visitChildren(ctx);
        System.out.println("visitFileAnnotation");
        return eaList;
    }

//    @Override
//    public List<EmbeddedAnnotation> visitFile(fileAnnotationsParser.FileContext ctx) {
//        List<EmbeddedAnnotation> eaList = new ArrayList();
//        eaList.addAll((Collection<? extends EmbeddedAnnotation>) visitChildren(ctx));
//
//        eaList.add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.eaType_FILE, POSITION_UNKNOWN, POSITION_UNKNOWN, NAME_UNKNOWN));
//        System.out.println("visitFile");
//
//        return eaList;
//    }
//
//    @Override
//    public EmbeddedAnnotation visitFeature(fileAnnotationsParser.FeatureContext ctx) {
//        System.out.println("visitLpq");
//        visitChildren(ctx);
//        return new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.eaType_FILE, POSITION_UNKNOWN, POSITION_UNKNOWN, ctx.getText());
//    }
//
//    @Override
//    protected Object aggregateResult(Object aggregate, Object nextResult) {
//        System.out.println("aggregateResult");
//
//        if(aggregate==null && nextResult==null){
//            // TODO - hopefully only called for List of EmbeddedAnnotations
//            return new ArrayList<EmbeddedAnnotation>();
//        }
//
//        if(nextResult instanceof List){
//            if(aggregate instanceof List) {
//                return ((List) aggregate).addAll((List) nextResult);
//            } else {
//                return nextResult;
//            }
//
//        }
//
//        if(aggregate instanceof List){
//            return aggregate;
//        } else {
//            return new ArrayList<EmbeddedAnnotation>();
//        }
//
////        System.out.println("UNCOVERED SITUATION.");
////        return null;
//    }
}
