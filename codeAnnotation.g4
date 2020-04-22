grammar codeAnnotation;
marker: ' '* comment* (beginmarker | endmarker | linemarker);

beginmarker: '&begin' ' '* parameter;
endmarker: '&end' ' '* parameter;
linemarker: '&line' ' '* parameter;
parameter: '(' lpq (ANNOSEPARATOR lpq)* ' '* ')' ' '* comment*
         | '[' lpq (ANNOSEPARATOR lpq)* ' '* ']' ' '* comment*
         | '{' lpq (ANNOSEPARATOR lpq)* ' '* '}' ' '* comment*
         |  lpq (ANNOSEPARATOR lpq)*
         ;

ANNOSEPARATOR: (' '* ',' ' '*) | ' '+;
comment: STRING (' '+ STRING)* ' '*;
lpq: STRING ('::'STRING)*   # Feature
            ;
STRING: ([A-Z]+|[a-z]+|[0-9]+)+;


//"+" can be used to mean "one or more of the previous."
//"*" can be used to mean "zero or more of the previous."
//"?" can be used to mean "zero or one occurances of the previous."