// Generated from C:/Users/Tobias/IdeaProjects/FAXE-Feature_Annotation_eXtraction_Engine\codeAnnotation.g4 by ANTLR 4.8
package se.gu.faxe.Grammar;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link codeAnnotationParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface codeAnnotationVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link codeAnnotationParser#marker}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMarker(codeAnnotationParser.MarkerContext ctx);
	/**
	 * Visit a parse tree produced by {@link codeAnnotationParser#beginmarker}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBeginmarker(codeAnnotationParser.BeginmarkerContext ctx);
	/**
	 * Visit a parse tree produced by {@link codeAnnotationParser#endmarker}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEndmarker(codeAnnotationParser.EndmarkerContext ctx);
	/**
	 * Visit a parse tree produced by {@link codeAnnotationParser#linemarker}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLinemarker(codeAnnotationParser.LinemarkerContext ctx);
	/**
	 * Visit a parse tree produced by {@link codeAnnotationParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(codeAnnotationParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Feature}
	 * labeled alternative in {@link codeAnnotationParser#lpq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFeature(codeAnnotationParser.FeatureContext ctx);
}