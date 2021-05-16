/**
 * See https://graphviz.org/doc/info/lang.html
 */
grammar Dot;

@header {
package fr.emse.dot.parser;
}

graph : 'strict'? ('graph' | 'digraph') '{' stmtList '}' ;

stmtList : (stmt ';'? stmtList)? ;

stmt : nodeStmt | edgeStmt | attrStmt ;

attrStmt : ('graph' | 'node' | 'edge') attrList ;

attrList : '[' aList? ']' attrList? ;

aList : ID '=' ID (';' | ',')? aList? ;

edgeStmt : nodeID edgeRHS attrList? ;

edgeRHS : edgeOp nodeID edgeRHS? ;

edgeOp : '->' | '--' ;

nodeStmt : nodeID attrList? ;

nodeID : ID ;

ID : '"' ~["]* '"'
   | [0-9A-Za-z]+ ;

WS : [ \t\r\n]+ -> skip ;