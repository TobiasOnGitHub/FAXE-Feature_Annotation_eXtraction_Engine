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
grammar fileAnnotations;

SPACE: ' '* -> skip ;   // ignores all more than one-time space characters
//WS: [ \n\t\r]+ -> skip;
WS: [\r]+ -> skip;

fileAnnotations: ((fileAnnotation) '\n'*)* ;

fileAnnotation: fileReferences ':'? '\n'+ lpqReferences ;

fileReferences: (fileReference (' '* fileReference)* ' '*) | (fileReference (' '* ',' ' '* fileReference)* ' '*) ;

fileReference: ('"' fileName '"') | (fileName) ;

fileName: STRING | (STRING'.'STRING);

lpqReferences: (lpq (' '* lpq)* ' '*) | (lpq (' '* ',' ' '* lpq)* ' '*);

lpq: STRING ('::'STRING)*  # Feature;

STRING: ([A-Z]+|[a-z]+|[0-9]+|'_'+|'\''+)+;    // -> restriction from Clafer and follow their definition