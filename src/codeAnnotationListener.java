// Generated from C:/Users/Tobias/IdeaProjects/ANTLR4_EmbeddedAnnotations\codeAnnotation.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link codeAnnotationParser}.
 */
public interface codeAnnotationListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link codeAnnotationParser#marker}.
	 * @param ctx the parse tree
	 */
	void enterMarker(codeAnnotationParser.MarkerContext ctx);
	/**
	 * Exit a parse tree produced by {@link codeAnnotationParser#marker}.
	 * @param ctx the parse tree
	 */
	void exitMarker(codeAnnotationParser.MarkerContext ctx);
}