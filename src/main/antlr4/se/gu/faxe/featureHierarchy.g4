grammar featureHierarchy;
SPACE: ' '* -> skip ;
KEYWORDS: ('or'|'xor'|'?') -> skip ;   // Skip Clafer Keywords

projectHierarchy: FEATURENAME (subfeature)*;       // Level 0

subfeature: ('\n' '\t' FEATURENAME) subsubfeature* #SubLevel1 ;

subsubfeature: ('\n' '\t\t' FEATURENAME) subsubsubfeature* #SubLevel2 ;

subsubsubfeature: ('\n' '\t\t\t' FEATURENAME) subsubsubsubfeature* #SubLevel3 ;

subsubsubsubfeature: ('\n' '\t\t\t\t' FEATURENAME) subsubsubsubsubfeature* #SubLevel4 ;

subsubsubsubsubfeature: ('\n' '\t\t\t\t\t' FEATURENAME) subsubsubsubsubsubfeature* #SubLevel5 ;

subsubsubsubsubsubfeature: ('\n' '\t\t\t\t\t\t' FEATURENAME) subsubsubsubsubsubsubfeature* #SubLevel6 ;

subsubsubsubsubsubsubfeature: ('\n' '\t\t\t\t\t\t\t' FEATURENAME) #SubLevel7 ;

FEATURENAME: ([A-Z]+|[a-z]+|[0-9]+|'_'+|'\''+)+;

/* Future more flexible approach potentially via
- https://stackoverflow.com/questions/52037501/bnf-example-for-language-grammar-where-indenting-level-defines-a-block
- https://stackoverflow.com/questions/8642154/antlr-what-is-simpliest-way-to-realize-python-like-indent-depending-grammar
*/