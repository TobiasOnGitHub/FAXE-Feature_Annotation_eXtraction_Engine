grammar folderAnnotations;
folderAnnotation: LPQ (ANNOSEPARATOR LPQ)*;

ANNOSEPARATOR: ' '* ',' ' '* | ' '+;

LPQ: STRING ('::'STRING)*;

STRING: ([A-Z]+|[a-z]+|[0-9]+)+;


