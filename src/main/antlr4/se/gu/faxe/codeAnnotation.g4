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
grammar codeAnnotation;
marker: .*? (beginmarker | endmarker | linemarker)*;

SPACE: ' '* -> skip ;   // ignores all more than one-time space characters

beginmarker: '&begin' ' '* parameter;
endmarker: '&end' ' '* parameter;
linemarker: '&line' ' '* parameter;
parameter: '(' ' '* lpq (' '+ lpq)* ' '* ')' .*? | '(' ' '* lpq (' '* ',' ' '* lpq)* ' '* ')' .*?
         | '[' ' '* lpq (' '+ lpq)* ' '* ']' .*? | '[' ' '* lpq (' '* ',' ' '* lpq)* ' '* ']' .*?
         | '{' ' '* lpq (' '+ lpq)* ' '* '}' .*? | '{' ' '* lpq (' '* ',' ' '* lpq)* ' '* '}' .*?
         |     ' '* lpq (' '+ lpq)*              |     ' '* lpq (' '* ',' ' '* lpq)* ' '*
         ;

//ANNOSEPARATOR: (' '* ',' ' '*) | ' '+;
lpq: FEATURENAME ('::'FEATURENAME)*   # Feature;
FEATURENAME: ([A-Z]+|[a-z]+|[0-9]+|'_'+|'\''+)+;    // -> restriction from Clafer and follow their definition

OTHER : . -> skip ;   // fuzzy parsing


//"+" can be used to mean "one or more of the previous."
//"*" can be used to mean "zero or more of the previous."
//"?" can be used to mean "zero or one occurances of the previous."
// .*? as wildcard to ignore data (Fuzzy parsing)