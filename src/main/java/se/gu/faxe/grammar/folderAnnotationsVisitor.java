// Generated from .../FAXE-Feature_Annotation_eXtraction_Engine/src/main/antlr4/se/gu/faxe\folderAnnotations.g4 by ANTLR 4.8
package se.gu.faxe.grammar;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link folderAnnotationsParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface folderAnnotationsVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link folderAnnotationsParser#folderAnnotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFolderAnnotation(folderAnnotationsParser.FolderAnnotationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Feature}
	 * labeled alternative in {@link folderAnnotationsParser#lpq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFeature(folderAnnotationsParser.FeatureContext ctx);
}