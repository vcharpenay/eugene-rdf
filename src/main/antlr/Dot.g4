/**
 * See https://graphviz.org/doc/info/lang.html
 */
grammar Dot;

@header {
package fr.emse.dot.parser;
}

graph : 'strict'? graphType ID? '{' stmtList '}' ;

graphType : 'graph' | 'digraph' ;

stmtList : (stmt ';'? stmtList)? ;

stmt : nodeStmt | edgeStmt | attrStmt ;

attrStmt : entityType attrList ;

entityType : 'graph' | 'node' | 'edge' ;

attrList : '[' aList? ']' attrList? ;

aList : ID '=' ID (';' | ',')? aList? ;

edgeStmt : nodeID edgeRHS attrList? ;

edgeRHS : edgeOp nodeID edgeRHS? ;

edgeOp : '->' | '--' ;

nodeStmt : nodeID attrList? ;

nodeID : ID ;

ID : '"' ~["]* '"'
   | [.0-9A-Za-z]+ ;

WS : [ \t\r\n]+ -> skip ;