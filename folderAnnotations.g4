grammar folderAnnotations;

SPACE: ' '* -> skip ;   // ignores all more than one-time space characters

folderAnnotation: (' '* lpq (' '* lpq)* ' '*)
                | (' '* lpq (' '* ',' ' '* lpq)* ' '*)
                | (' '* lpq ('\n' lpq)* ' '*);

lpq: FEATURENAME ('::'FEATURENAME)*  # Feature;
FEATURENAME: ([A-Z]+|[a-z]+|[0-9]+|'_'+|'\''+)+;    // -> restriction from Clafer and follow their definition