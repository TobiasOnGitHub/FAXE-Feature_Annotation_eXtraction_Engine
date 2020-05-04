grammar fileAnnotations;

SPACE: ' '* -> skip ;   // ignores all more than one-time space characters

fileAnnotation: fileReferences ':'? '\n'+ lpqReferences ;

// TODO - necessary that comma and space rule is identical for file and feature?!

fileReferences: (fileReference (' '* fileReference)* ' '*) | (fileReference (' '* ',' ' '* fileReference)* ' '*) ;

fileReference: ('"' fileName '"') | (fileName) ;

fileName: STRING | (STRING'.'STRING);
//fileName: FILECHARS | (FILECHARS'.'FILECHARS);
//FILECHARS: ~('<' | '>' | ':' | '"' | '/' | '\\' | '|' | '?' | '*' )*; // TODO - Unclear why not used...
// fileName should allow everything except: https://docs.microsoft.com/en-us/windows/win32/fileio/naming-a-file
/*
    < (less than)
    > (greater than)
    : (colon)
    " (double quote)
    / (forward slash)
    \ (backslash)
    | (vertical bar or pipe)
    ? (question mark)
    * (asterisk)
*/

lpqReferences: (lpq (' '* lpq)* ' '*) | (lpq (' '* ',' ' '* lpq)* ' '*);

lpq: STRING ('::'STRING)*  # Feature;
STRING: ([A-Z]+|[a-z]+|[0-9]+)+;