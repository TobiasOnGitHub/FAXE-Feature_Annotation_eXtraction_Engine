grammar fileAnnotations;
fileAnnotation: fileReferences ':'? '\n'+ lpqReferences ;

fileReferences: (fileReference (' ' fileReference)*) | (fileReference (',' fileReference)*);

fileReference: ('"' fileName '"') | (fileName) ;

//fileName: .*? | ' ' | '%';

fileName: ~('<' | '>' | ':' | '"' | '/' | '\\' | '|' | '?' | '*')*; // TODO - Unclear why not used...
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

lpqReferences: (lpq (' ' lpq)*) | (lpq (',' lpq)*);


FILESEPARATOR: (' '* ',' ' '*) | ' '+ ;

lpq: STRING ('::'STRING)*  # Feature;
STRING: ([A-Z]+|[a-z]+|[0-9]+)+;