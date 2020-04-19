// Generated from C:/Users/Tobias/IdeaProjects/ANTLR4_EmbeddedAnnotations\fileAnnotations.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link fileAnnotationsParser}.
 */
public interface fileAnnotationsListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link fileAnnotationsParser#fileAnnotation}.
	 * @param ctx the parse tree
	 */
	void enterFileAnnotation(fileAnnotationsParser.FileAnnotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link fileAnnotationsParser#fileAnnotation}.
	 * @param ctx the parse tree
	 */
	void exitFileAnnotation(fileAnnotationsParser.FileAnnotationContext ctx);
}