grammar folderAnnotations;
folderAnnotation: (lpq (' ' lpq)*)
                | (lpq (' '* ',' ' '* lpq)*)
                | (lpq ('\n' lpq)*);

lpq: STRING ('::'STRING)*  # Feature;
STRING: ([A-Z]+|[a-z]+|[0-9]+)+;