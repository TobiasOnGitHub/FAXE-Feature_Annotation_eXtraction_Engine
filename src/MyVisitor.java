import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class MyVisitor extends codeAnnotationBaseVisitor<Object> {
    private static int POSITION_UNKNOWN = -1;

    @Override public List<EmbeddedAnnotation> visitMarker(codeAnnotationParser.MarkerContext ctx) {
        List<EmbeddedAnnotation> eaList = (List<EmbeddedAnnotation>) visitChildren(ctx);
        System.out.println("Individual");

        // BEGIN and END markers have been discovered independently and need to be merged to FRAGMENTS now:
        ListIterator<EmbeddedAnnotation> searchBeginItr = eaList.listIterator(eaList.size());
        int index = eaList.size();
        while(searchBeginItr.hasPrevious()) {
            EmbeddedAnnotation eaBEGIN = searchBeginItr.previous();
            if (eaBEGIN.getEaType() == EmbeddedAnnotation.eEAType.eaType_BEGIN) {
                ListIterator<EmbeddedAnnotation> searchEndItr = eaList.listIterator(index);
                while(searchEndItr.hasNext()) {
                    EmbeddedAnnotation eaEND = searchEndItr.next();
                    if (eaEND.getEaType() == EmbeddedAnnotation.eEAType.eaType_END) {
                        if(eaBEGIN.getFeature().equals(eaEND.getFeature())){
                            if(eaBEGIN.getClosingLine()==POSITION_UNKNOWN && eaEND.getOpeningLine()==POSITION_UNKNOWN){
                                System.out.println("MERGING: " +eaBEGIN.toString());
                                System.out.println("WITH   : " +eaEND.toString());
                                // Match confirmed - replace two entries with one "FRAGMENT"
                                eaBEGIN.setClosingLine(eaEND.getClosingLine());
                                eaBEGIN.setEaType(EmbeddedAnnotation.eEAType.eaType_FRAGMENT);
                                System.out.println("TO     : " +eaBEGIN.toString());
                                searchEndItr.remove();
                                searchBeginItr = eaList.listIterator(index-1);    // set outer iterator again. Otherwise it gets confused in its iterating positions. Set to position of new created FRAGMENT
                            }
                        }
                    }
                } // while(searchEndItr.hasNext())
            }
            index--;
        } // while(searchBeginItr.hasPrevious())

        // TODO - Try with function which returns when change done

        System.out.println("Individual");
        return eaList;
    }

    @Override public List<EmbeddedAnnotation> visitBeginmarker(codeAnnotationParser.BeginmarkerContext ctx) {
        List<EmbeddedAnnotation> eaList = (List<EmbeddedAnnotation>) visitChildren(ctx);
        // Add for new created feature entries that they are found in BEGIN
        eaList.forEach(
                ea -> {
                    ea.setEaType(EmbeddedAnnotation.eEAType.eaType_BEGIN);
                    ea.setOpeningLine(ctx.getStart().getLine());
                }
        );
        return eaList;
    }

    @Override public List<EmbeddedAnnotation> visitEndmarker(codeAnnotationParser.EndmarkerContext ctx) {
        System.out.println("Found END");
        List<EmbeddedAnnotation> eaList = (List<EmbeddedAnnotation>) visitChildren(ctx);
        // Add for new created feature entries that they are found in END
        eaList.forEach(
                ea -> {
                    ea.setEaType(EmbeddedAnnotation.eEAType.eaType_END);
                    ea.setClosingLine(ctx.getStart().getLine());
                }
        );
        return eaList;
    }

    @Override public String visitLinemarker(codeAnnotationParser.LinemarkerContext ctx) {
        visitChildren(ctx);
        return "LINE";
    }

    @Override public EmbeddedAnnotation visitFeature(codeAnnotationParser.FeatureContext ctx) {
        visitChildren(ctx);
        String str = ctx.getText();
        EmbeddedAnnotation ea = new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.eaType_UNKNOWN, POSITION_UNKNOWN, POSITION_UNKNOWN, str);
        System.out.println("Found ea=" +ea.toString());
        return ea;
    }

    @Override
    protected Object aggregateResult(Object aggregate, Object nextResult) {

        if(aggregate==null && nextResult==null){
            return null;
        }

        System.out.println("aggregate=" +aggregate +" nextResult=" +nextResult);

        // Build return list with new found features
        if(aggregate == null || aggregate instanceof List) {
            if (nextResult instanceof EmbeddedAnnotation) {
                // Add new element to existing list
                List<EmbeddedAnnotation> eaList = new ArrayList<EmbeddedAnnotation>();;
                if(aggregate instanceof List){
                    eaList.addAll((List<EmbeddedAnnotation>) aggregate);
                }
                eaList.add((EmbeddedAnnotation) nextResult);
                return eaList;
            } else {
                // Combining results of markers
                if(aggregate instanceof List && nextResult instanceof List){
                    List<EmbeddedAnnotation> eaList = new ArrayList<EmbeddedAnnotation>();;
                    eaList.addAll((List<EmbeddedAnnotation>) aggregate);
                    eaList.addAll((List<EmbeddedAnnotation>) nextResult);
                    return eaList;
                }
                // No new result - returning existing aggretation (unchanged) or null
                if(aggregate instanceof List){
                    return aggregate;
                }
                if(aggregate == null){
                    if(nextResult instanceof List){
                        return nextResult;
                    }
                    return null;
                }
            }
        }

        System.out.println("MyVisitor::aggregateResult - Unknown SITUATION!");
        return null;


//        if(aggregate==null){
//            System.out.println("return=" +nextResult);
//            return nextResult;
//        }
//        if(nextResult==null){
//            System.out.println("return=" +aggregate);
//            return aggregate;
//        }
//        System.out.println("return=" +aggregate+" "+nextResult);
//
//        return aggregate+" "+nextResult;

    }
}
