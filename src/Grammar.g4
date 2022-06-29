grammar Grammar;
//By Yang Cheng 15/02/2022
program: statement* EOF;
statement: declaration | assignment | print | ifStatement | loop | method |method_call |scope;
declaration: type=(INT_TYPE | STRING_TYPE | DOUBLE_TYPE | BOOLEAN_TYPE) IDENTIFIER ('=' expression)? ';' ;
assignment:  IDENTIFIER '=' expression ';';
scanner: 'Enter<<';
print: 'Show>>' expression ';';
ifStatement: 'if' '(' expression ')' '{' statement* '}' ('else' '{' falseStatement'}')? ';' ;
falseStatement: statement*;
loop:'Loop' '{'statement* '}' 'Times' '(' INT ')' ';' ;
method: '#Construct' name=IDENTIFIER '<'(methodDeclaration (',' methodDeclaration)*)?'>' '{' statement*  '}' 'return' '('return_value=expression')'';' ;
methodDeclaration: type=(INT_TYPE | STRING_TYPE | DOUBLE_TYPE | BOOLEAN_TYPE) IDENTIFIER;
method_call:name=IDENTIFIER '(' expression_list?')';

scope:'{'statement*'}';
expression_list: expression (',' expression)*;
//expression
expression: '(' expression ')'                                                      # ExpParentheses
          | '-' expression                                                          # ExpNegate
          | left=expression op=( '*'| '/') right=expression                         # ExpMul
          | left=expression op=('+' | '-') right=expression                         # ExpAdd
          | '(' left=expression ')' op=('&&'| '||') '(' right=expression ')'        # ExpLogic
          | left=expression 'eq' right=expression                                   # ExpEqual
          | left=expression op =('>'|'<'|'>='|'<='|'==' | '!=') right=expression    # ExpCompare
          | IDENTIFIER                                                              # ExpIdentifier
          | INT                                                                     # ExpInt
          | DOUBLE                                                                  # ExpDou
          | STRING                                                                  # ExpStr
          | BOOLEAN                                                                 # ExpBool
          | scanner                                                                 # ExpScanner
          | method_call                                                             # Expmethod_call
          ;

INT_TYPE: 'Floor';
DOUBLE_TYPE: 'Room';
STRING_TYPE: 'Name';
BOOLEAN_TYPE : 'Finish';
INT: '0' | [1-9][0-9]*;
DOUBLE: INT '.' INT;
STRING: '"' ~["]*  '"';
BOOLEAN: 'yes' | 'no';
IDENTIFIER: [A-Za-z][A-Za-z0-9_]*;
WS: [\r\n\t ]+ -> skip;
COMMENT: '//'.*? [\n\r]+ -> skip;
