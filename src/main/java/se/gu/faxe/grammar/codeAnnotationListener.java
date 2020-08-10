// Generated from C:/Users/Tobias/IdeaProjects/FAXE-Feature_Annotation_eXtraction_Engine/src/main/antlr4/se/gu/faxe\codeAnnotation.g4 by ANTLR 4.8
package se.gu.faxe.grammar;
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
	/**
	 * Enter a parse tree produced by {@link codeAnnotationParser#beginmarker}.
	 * @param ctx the parse tree
	 */
	void enterBeginmarker(codeAnnotationParser.BeginmarkerContext ctx);
	/**
	 * Exit a parse tree produced by {@link codeAnnotationParser#beginmarker}.
	 * @param ctx the parse tree
	 */
	void exitBeginmarker(codeAnnotationParser.BeginmarkerContext ctx);
	/**
	 * Enter a parse tree produced by {@link codeAnnotationParser#endmarker}.
	 * @param ctx the parse tree
	 */
	void enterEndmarker(codeAnnotationParser.EndmarkerContext ctx);
	/**
	 * Exit a parse tree produced by {@link codeAnnotationParser#endmarker}.
	 * @param ctx the parse tree
	 */
	void exitEndmarker(codeAnnotationParser.EndmarkerContext ctx);
	/**
	 * Enter a parse tree produced by {@link codeAnnotationParser#linemarker}.
	 * @param ctx the parse tree
	 */
	void enterLinemarker(codeAnnotationParser.LinemarkerContext ctx);
	/**
	 * Exit a parse tree produced by {@link codeAnnotationParser#linemarker}.
	 * @param ctx the parse tree
	 */
	void exitLinemarker(codeAnnotationParser.LinemarkerContext ctx);
	/**
	 * Enter a parse tree produced by {@link codeAnnotationParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(codeAnnotationParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link codeAnnotationParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(codeAnnotationParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Feature}
	 * labeled alternative in {@link codeAnnotationParser#lpq}.
	 * @param ctx the parse tree
	 */
	void enterFeature(codeAnnotationParser.FeatureContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Feature}
	 * labeled alternative in {@link codeAnnotationParser#lpq}.
	 * @param ctx the parse tree
	 */
	void exitFeature(codeAnnotationParser.FeatureContext ctx);
}