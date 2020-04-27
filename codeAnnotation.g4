grammar codeAnnotation;
marker: .*? (beginmarker | endmarker | linemarker)*;

beginmarker: '&begin' ' '* parameter;
endmarker: '&end' ' '* parameter;
linemarker: '&line' ' '* parameter;
parameter: '(' lpq (ANNOSEPARATOR lpq)* ' '* ')' .*?
         | '[' lpq (ANNOSEPARATOR lpq)* ' '* ']' .*?
         | '{' lpq (ANNOSEPARATOR lpq)* ' '* '}' .*?
         |  lpq (ANNOSEPARATOR lpq)*
         ;

ANNOSEPARATOR: (' '* ',' ' '*) | ' '+;
lpq: STRING ('::'STRING)*   # Feature;
STRING: ([A-Z]+|[a-z]+|[0-9]+)+;

OTHER : . -> skip ;   // allows line break

//"+" can be used to mean "one or more of the previous."
//"*" can be used to mean "zero or more of the previous."
//"?" can be used to mean "zero or one occurances of the previous."
// .*? as wildcard to ignore data (Fuzzy parsing)