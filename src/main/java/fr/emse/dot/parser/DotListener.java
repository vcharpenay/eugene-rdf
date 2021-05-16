// Generated from Dot.g4 by ANTLR 4.9.2

package fr.emse.dot.parser;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link DotParser}.
 */
public interface DotListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link DotParser#graph}.
	 * @param ctx the parse tree
	 */
	void enterGraph(DotParser.GraphContext ctx);
	/**
	 * Exit a parse tree produced by {@link DotParser#graph}.
	 * @param ctx the parse tree
	 */
	void exitGraph(DotParser.GraphContext ctx);
	/**
	 * Enter a parse tree produced by {@link DotParser#graphType}.
	 * @param ctx the parse tree
	 */
	void enterGraphType(DotParser.GraphTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DotParser#graphType}.
	 * @param ctx the parse tree
	 */
	void exitGraphType(DotParser.GraphTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link DotParser#stmtList}.
	 * @param ctx the parse tree
	 */
	void enterStmtList(DotParser.StmtListContext ctx);
	/**
	 * Exit a parse tree produced by {@link DotParser#stmtList}.
	 * @param ctx the parse tree
	 */
	void exitStmtList(DotParser.StmtListContext ctx);
	/**
	 * Enter a parse tree produced by {@link DotParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(DotParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link DotParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(DotParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link DotParser#attrStmt}.
	 * @param ctx the parse tree
	 */
	void enterAttrStmt(DotParser.AttrStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link DotParser#attrStmt}.
	 * @param ctx the parse tree
	 */
	void exitAttrStmt(DotParser.AttrStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link DotParser#entityType}.
	 * @param ctx the parse tree
	 */
	void enterEntityType(DotParser.EntityTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DotParser#entityType}.
	 * @param ctx the parse tree
	 */
	void exitEntityType(DotParser.EntityTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link DotParser#attrList}.
	 * @param ctx the parse tree
	 */
	void enterAttrList(DotParser.AttrListContext ctx);
	/**
	 * Exit a parse tree produced by {@link DotParser#attrList}.
	 * @param ctx the parse tree
	 */
	void exitAttrList(DotParser.AttrListContext ctx);
	/**
	 * Enter a parse tree produced by {@link DotParser#aList}.
	 * @param ctx the parse tree
	 */
	void enterAList(DotParser.AListContext ctx);
	/**
	 * Exit a parse tree produced by {@link DotParser#aList}.
	 * @param ctx the parse tree
	 */
	void exitAList(DotParser.AListContext ctx);
	/**
	 * Enter a parse tree produced by {@link DotParser#edgeStmt}.
	 * @param ctx the parse tree
	 */
	void enterEdgeStmt(DotParser.EdgeStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link DotParser#edgeStmt}.
	 * @param ctx the parse tree
	 */
	void exitEdgeStmt(DotParser.EdgeStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link DotParser#edgeRHS}.
	 * @param ctx the parse tree
	 */
	void enterEdgeRHS(DotParser.EdgeRHSContext ctx);
	/**
	 * Exit a parse tree produced by {@link DotParser#edgeRHS}.
	 * @param ctx the parse tree
	 */
	void exitEdgeRHS(DotParser.EdgeRHSContext ctx);
	/**
	 * Enter a parse tree produced by {@link DotParser#edgeOp}.
	 * @param ctx the parse tree
	 */
	void enterEdgeOp(DotParser.EdgeOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link DotParser#edgeOp}.
	 * @param ctx the parse tree
	 */
	void exitEdgeOp(DotParser.EdgeOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link DotParser#nodeStmt}.
	 * @param ctx the parse tree
	 */
	void enterNodeStmt(DotParser.NodeStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link DotParser#nodeStmt}.
	 * @param ctx the parse tree
	 */
	void exitNodeStmt(DotParser.NodeStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link DotParser#nodeID}.
	 * @param ctx the parse tree
	 */
	void enterNodeID(DotParser.NodeIDContext ctx);
	/**
	 * Exit a parse tree produced by {@link DotParser#nodeID}.
	 * @param ctx the parse tree
	 */
	void exitNodeID(DotParser.NodeIDContext ctx);
}