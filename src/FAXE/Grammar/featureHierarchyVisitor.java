// Generated from C:/Users/Tobias/IdeaProjects/FAXE-Feature_Annotation_eXtraction_Engine\featureHierarchy.g4 by ANTLR 4.8
package FAXE.Grammar;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link featureHierarchyParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface featureHierarchyVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link featureHierarchyParser#projectHierarchy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProjectHierarchy(featureHierarchyParser.ProjectHierarchyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SubLevel1}
	 * labeled alternative in {@link featureHierarchyParser#subfeature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubLevel1(featureHierarchyParser.SubLevel1Context ctx);
	/**
	 * Visit a parse tree produced by the {@code SubLevel2}
	 * labeled alternative in {@link featureHierarchyParser#subsubfeature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubLevel2(featureHierarchyParser.SubLevel2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code SubLevel3}
	 * labeled alternative in {@link featureHierarchyParser#subsubsubfeature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubLevel3(featureHierarchyParser.SubLevel3Context ctx);
	/**
	 * Visit a parse tree produced by the {@code SubLevel4}
	 * labeled alternative in {@link featureHierarchyParser#subsubsubsubfeature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubLevel4(featureHierarchyParser.SubLevel4Context ctx);
	/**
	 * Visit a parse tree produced by the {@code SubLevel5}
	 * labeled alternative in {@link featureHierarchyParser#subsubsubsubsubfeature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubLevel5(featureHierarchyParser.SubLevel5Context ctx);
	/**
	 * Visit a parse tree produced by the {@code SubLevel6}
	 * labeled alternative in {@link featureHierarchyParser#subsubsubsubsubsubfeature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubLevel6(featureHierarchyParser.SubLevel6Context ctx);
	/**
	 * Visit a parse tree produced by the {@code SubLevel7}
	 * labeled alternative in {@link featureHierarchyParser#subsubsubsubsubsubsubfeature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubLevel7(featureHierarchyParser.SubLevel7Context ctx);
}