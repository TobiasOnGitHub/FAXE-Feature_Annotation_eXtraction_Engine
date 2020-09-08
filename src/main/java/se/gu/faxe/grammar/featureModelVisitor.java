// Generated from C:/Users/Tobias/IdeaProjects/FAXE-Feature_Annotation_eXtraction_Engine/src/main/antlr4/se/gu/faxe\featureModel.g4 by ANTLR 4.8
package se.gu.faxe.grammar;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link featureModelParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface featureModelVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link featureModelParser#featuretree}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFeaturetree(featureModelParser.FeaturetreeContext ctx);
	/**
	 * Visit a parse tree produced by {@link featureModelParser#projectname}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProjectname(featureModelParser.ProjectnameContext ctx);
	/**
	 * Visit a parse tree produced by {@link featureModelParser#feature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFeature(featureModelParser.FeatureContext ctx);
}