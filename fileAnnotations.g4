grammar fileAnnotations;

SPACE: ' '* -> skip ;   // ignores all more than one-time space characters
//WS: [ \n\t\r]+ -> skip;
WS: [\r]+ -> skip;

fileAnnotations: (fileAnnotation)* ;

fileAnnotation: fileReferences ':'? '\n'+ lpqReferences ;

fileReferences: (fileReference (' '* fileReference)* ' '*) | (fileReference (' '* ',' ' '* fileReference)* ' '*) ;

fileReference: ('"' fileName '"') | (fileName) ;

fileName: STRING | (STRING'.'STRING);

lpqReferences: (lpq (' '* lpq)* ' '*) | (lpq (' '* ',' ' '* lpq)* ' '*);

lpq: STRING ('::'STRING)*  # Feature;

STRING: ([A-Z]+|[a-z]+|[0-9]+|'_'+|'\''+)+;    // -> restriction from Clafer and follow their definition