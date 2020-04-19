public class MyVisitor extends codeAnnotationBaseVisitor<Object> {

    @Override public Object visitMarker(codeAnnotationParser.MarkerContext ctx) {

        return visitChildren(ctx);
    }

}
