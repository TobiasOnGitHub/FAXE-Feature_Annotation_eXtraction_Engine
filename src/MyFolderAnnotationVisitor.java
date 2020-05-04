import java.util.ArrayList;
import java.util.List;

public class MyFolderAnnotationVisitor extends folderAnnotationsBaseVisitor<Object> {
    private static final int POSITION_UNKNOWN = -1;

    @Override
    public List<EmbeddedAnnotation> visitFolderAnnotation(folderAnnotationsParser.FolderAnnotationContext ctx) {
        System.out.println("visitFolderAnnotation");
        List<EmbeddedAnnotation> eaList = (List<EmbeddedAnnotation>) visitChildren(ctx);
        return eaList;
    }

    @Override
    public EmbeddedAnnotation visitFeature(folderAnnotationsParser.FeatureContext ctx) {
        System.out.println("visitFeature \"" +ctx.getText() +"\"");
        visitChildren(ctx);
        return new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.eaType_FOLDER, null, POSITION_UNKNOWN, POSITION_UNKNOWN, ctx.getText());
    }

    protected Object aggregateResult(Object aggregate, Object nextResult) {

        if(aggregate==null && nextResult==null){
            return null;
        }

        System.out.println("aggregateResult");

        if(aggregate == null && nextResult instanceof EmbeddedAnnotation){
            List<EmbeddedAnnotation> eaList = new ArrayList<>();
            eaList.add((EmbeddedAnnotation) nextResult);
            return eaList;
        }

        if(aggregate instanceof List && nextResult==null){
            return aggregate;
        }

        if(aggregate instanceof List && nextResult instanceof EmbeddedAnnotation){
            ((List) aggregate).add(nextResult);
            return aggregate;
        }

        System.out.println("aggregateResult - Uncovered case.");
        return null;
    }
}
