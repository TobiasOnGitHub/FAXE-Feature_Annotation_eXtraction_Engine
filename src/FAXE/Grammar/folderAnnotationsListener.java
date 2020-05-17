// Generated from C:/Users/Tobias/IdeaProjects/FAXE-Feature_Annotation_eXtraction_Engine\folderAnnotations.g4 by ANTLR 4.8
package FAXE.Grammar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link folderAnnotationsParser}.
 */
public interface folderAnnotationsListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link folderAnnotationsParser#folderAnnotation}.
	 * @param ctx the parse tree
	 */
	void enterFolderAnnotation(folderAnnotationsParser.FolderAnnotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link folderAnnotationsParser#folderAnnotation}.
	 * @param ctx the parse tree
	 */
	void exitFolderAnnotation(folderAnnotationsParser.FolderAnnotationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Feature}
	 * labeled alternative in {@link folderAnnotationsParser#lpq}.
	 * @param ctx the parse tree
	 */
	void enterFeature(folderAnnotationsParser.FeatureContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Feature}
	 * labeled alternative in {@link folderAnnotationsParser#lpq}.
	 * @param ctx the parse tree
	 */
	void exitFeature(folderAnnotationsParser.FeatureContext ctx);
}