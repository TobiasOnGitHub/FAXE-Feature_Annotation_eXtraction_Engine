grammar fileAnnotations;
fileAnnotation: (file (FILESEPARATOR file)*) ':'? '\n'+ (lpq (FILESEPARATOR lpq)*) ;

file: STRING ('.' STRING)* ;

FILESEPARATOR: ',' | ' '+ ;

lpq: STRING ('::'STRING)*;
STRING: ([A-Z]+|[a-z]+|[0-9]+)+;