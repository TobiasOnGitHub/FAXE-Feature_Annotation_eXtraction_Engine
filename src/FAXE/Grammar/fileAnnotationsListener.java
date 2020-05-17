// Generated from C:/Users/Tobias/IdeaProjects/FAXE-Feature_Annotation_eXtraction_Engine\fileAnnotations.g4 by ANTLR 4.8
package FAXE.Grammar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link fileAnnotationsParser}.
 */
public interface fileAnnotationsListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link fileAnnotationsParser#fileAnnotations}.
	 * @param ctx the parse tree
	 */
	void enterFileAnnotations(fileAnnotationsParser.FileAnnotationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link fileAnnotationsParser#fileAnnotations}.
	 * @param ctx the parse tree
	 */
	void exitFileAnnotations(fileAnnotationsParser.FileAnnotationsContext ctx);
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
	/**
	 * Enter a parse tree produced by {@link fileAnnotationsParser#fileReferences}.
	 * @param ctx the parse tree
	 */
	void enterFileReferences(fileAnnotationsParser.FileReferencesContext ctx);
	/**
	 * Exit a parse tree produced by {@link fileAnnotationsParser#fileReferences}.
	 * @param ctx the parse tree
	 */
	void exitFileReferences(fileAnnotationsParser.FileReferencesContext ctx);
	/**
	 * Enter a parse tree produced by {@link fileAnnotationsParser#fileReference}.
	 * @param ctx the parse tree
	 */
	void enterFileReference(fileAnnotationsParser.FileReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link fileAnnotationsParser#fileReference}.
	 * @param ctx the parse tree
	 */
	void exitFileReference(fileAnnotationsParser.FileReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link fileAnnotationsParser#fileName}.
	 * @param ctx the parse tree
	 */
	void enterFileName(fileAnnotationsParser.FileNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link fileAnnotationsParser#fileName}.
	 * @param ctx the parse tree
	 */
	void exitFileName(fileAnnotationsParser.FileNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link fileAnnotationsParser#lpqReferences}.
	 * @param ctx the parse tree
	 */
	void enterLpqReferences(fileAnnotationsParser.LpqReferencesContext ctx);
	/**
	 * Exit a parse tree produced by {@link fileAnnotationsParser#lpqReferences}.
	 * @param ctx the parse tree
	 */
	void exitLpqReferences(fileAnnotationsParser.LpqReferencesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Feature}
	 * labeled alternative in {@link fileAnnotationsParser#lpq}.
	 * @param ctx the parse tree
	 */
	void enterFeature(fileAnnotationsParser.FeatureContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Feature}
	 * labeled alternative in {@link fileAnnotationsParser#lpq}.
	 * @param ctx the parse tree
	 */
	void exitFeature(fileAnnotationsParser.FeatureContext ctx);
}