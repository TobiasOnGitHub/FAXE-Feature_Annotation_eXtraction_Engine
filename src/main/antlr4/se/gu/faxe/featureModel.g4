// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.
grammar featureModel;
SPACE: ' '* -> skip ;
KEYWORDS: ('or'|'xor'|'?') -> skip ;   // Skip Clafer Keywords

featureModel: projectname (('\n'|'\r\n') feature)*; // Consider ('\n'|'\r\n') for Windows and Linux OS

projectname: FEATURENAME ;

feature: '\t' (FEATURENAME | feature) ;

FEATURENAME: ([A-Z]+|[a-z]+|[0-9]+|'_'+|'\''+)+;    // -> restriction from Clafer and follow their definition

/* Future more flexible approach potentially via
- https://stackoverflow.com/questions/52037501/bnf-example-for-language-grammar-where-indenting-level-defines-a-block
- https://stackoverflow.com/questions/8642154/antlr-what-is-simpliest-way-to-realize-python-like-indent-depending-grammar
*/