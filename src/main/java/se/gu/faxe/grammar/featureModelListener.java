// Generated from .../FAXE-Feature_Annotation_eXtraction_Engine/src/main/antlr4/se/gu/faxe\featureModel.g4 by ANTLR 4.8
package se.gu.faxe.grammar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link featureModelParser}.
 */
public interface featureModelListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link featureModelParser#featureModel}.
	 * @param ctx the parse tree
	 */
	void enterFeatureModel(featureModelParser.FeatureModelContext ctx);
	/**
	 * Exit a parse tree produced by {@link featureModelParser#featureModel}.
	 * @param ctx the parse tree
	 */
	void exitFeatureModel(featureModelParser.FeatureModelContext ctx);
	/**
	 * Enter a parse tree produced by {@link featureModelParser#projectname}.
	 * @param ctx the parse tree
	 */
	void enterProjectname(featureModelParser.ProjectnameContext ctx);
	/**
	 * Exit a parse tree produced by {@link featureModelParser#projectname}.
	 * @param ctx the parse tree
	 */
	void exitProjectname(featureModelParser.ProjectnameContext ctx);
	/**
	 * Enter a parse tree produced by {@link featureModelParser#feature}.
	 * @param ctx the parse tree
	 */
	void enterFeature(featureModelParser.FeatureContext ctx);
	/**
	 * Exit a parse tree produced by {@link featureModelParser#feature}.
	 * @param ctx the parse tree
	 */
	void exitFeature(featureModelParser.FeatureContext ctx);
}