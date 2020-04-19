grammar fileAnnotations;
fileAnnotation: (FILE (FILESEPARATOR FILE)*) ':'? '\n' (LPQ (FILESEPARATOR LPQ)*) ; // NEW - CHANGE that pair of lines ; tbc re-usage of Code: PARAMETER ?!

FILE: STRING '.' STRING ;

FILESEPARATOR: ',' | ' '+ ;

LPQ: STRING ('::'STRING)*;
STRING: ([A-Z]+|[a-z]+|[0-9]+)+;