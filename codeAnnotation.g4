grammar codeAnnotation;
marker: COMMENT* (BEGINMARKER | ENDMARKER | LINEMARKER) ;

BEGINMARKER: '&begin' ' '* PARAMETER;
ENDMARKER: '&end' ' '* PARAMETER;
LINEMARKER: '&line' ' '* PARAMETER;
PARAMETER: '(' LPQ (ANNOSEPARATOR LPQ)* ' '* ')' COMMENT*
         | '[' LPQ (ANNOSEPARATOR LPQ)* ' '* ']' COMMENT*
         | '{' LPQ (ANNOSEPARATOR LPQ)* ' '* '}' COMMENT*
         |  LPQ (ANNOSEPARATOR LPQ)*;

ANNOSEPARATOR: ' '* ',' ' '* | ' '+;      // TODO - how to define that always same separator symbol is used?!
COMMENT: STRING (' '+ STRING)* ' '*;
LPQ: STRING ('::'STRING)*;
STRING: ([A-Z]+|[a-z]+|[0-9]+)+;


//"+" can be used to mean "one or more of the previous."
//"*" can be used to mean "zero or more of the previous."
//"?" can be used to mean "zero or one occurances of the previous."