

//&begin(FeatureA, FeatureC)
source code

//&begin(FeatureB)
source code
aaa //&line(FeatureB1)

//&end(FeatureB)

bbb //&line(FeatureA1)
--> Order of closing features changes. This should have no effect on the feature order as this one depends on the starting sequence. <--
//&end(FeatureC, FeatureA)