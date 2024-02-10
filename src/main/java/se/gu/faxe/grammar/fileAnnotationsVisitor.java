// Generated from .../FAXE-Feature_Annotation_eXtraction_Engine/src/main/antlr4/se/gu/faxe\fileAnnotations.g4 by ANTLR 4.8
package se.gu.faxe.grammar;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link fileAnnotationsParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface fileAnnotationsVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link fileAnnotationsParser#fileAnnotations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFileAnnotations(fileAnnotationsParser.FileAnnotationsContext ctx);
	/**
	 * Visit a parse tree produced by {@link fileAnnotationsParser#fileAnnotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFileAnnotation(fileAnnotationsParser.FileAnnotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link fileAnnotationsParser#fileReferences}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFileReferences(fileAnnotationsParser.FileReferencesContext ctx);
	/**
	 * Visit a parse tree produced by {@link fileAnnotationsParser#fileReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFileReference(fileAnnotationsParser.FileReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link fileAnnotationsParser#fileName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFileName(fileAnnotationsParser.FileNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link fileAnnotationsParser#lpqReferences}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLpqReferences(fileAnnotationsParser.LpqReferencesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Feature}
	 * labeled alternative in {@link fileAnnotationsParser#lpq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFeature(fileAnnotationsParser.FeatureContext ctx);
}