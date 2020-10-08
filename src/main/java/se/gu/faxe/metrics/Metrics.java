/*************************************************************
 Licensed to the Apache Software Foundation (ASF) under one
 or more contributor license agreements.  See the NOTICE file
 distributed with this work for additional information
 regarding copyright ownership.  The ASF licenses this file
 to you under the Apache License, Version 2.0 (the
 "License"); you may not use this file except in compliance
 with the License.  You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing,
 software distributed under the License is distributed on an
 "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 KIND, either express or implied.  See the License for the
 specific language governing permissions and limitations
 under the License.
 *************************************************************/
package se.gu.faxe.metrics;

public enum Metrics {
    ALL     ("ALL"),
    /* FEATURE METRICS */
    SD      ("SD"),     // Scattering Degree: total number of all annotations directly referencing the feature (i.e., in-file, folder, and file annotations referencing it)
    NoFiA   ("NoFiA"),  // Number of File Annotations: total number of file annotations directly referencing the feature
    NoFoA   ("NoFoA"),  // Number of Folder Annotations: total number of folder annotations directly referencing the feature.
    TD      ("TD"),     // Tangling Degree: number of other features that share the same artifacts (or parts of such) with the feature. Two features share (parts of) artifacts when the latter is annotated with both features.
    LoFC    ("LoFC"),   // Lines of Feature Code: lines of code belonging to artifacts, either directly annotated, or indirectly (when a folder is annotated, all descendants are taken into account)
    AvgND   ("AvgND"),  /* Nesting depths of annotations: Maximum (MaxND), Minimum (MinND), and Average (AvgND) nesting depth the annotations directly referencing the feature. The project’s root folder has depth 0 (and so has any file contained in it). */
    MaxND   ("MaxND"),  /* Each sub-folder increases the depth by one, a file inherits the depth of its containing folder. The depth of a (top-level, i.e., non-nested) in-file annotation is the depth of the file increased by one. Since in-file annotations */
    MinND   ("MinND"),  /* can be nested, each nesting increases the depth by one. All nesting-depth metrics are calculated relative to the project root folder. */
    NoAu    ("NoAu"),   // Number of Authors who contributed to a feature’s artifact. Author information is automatically extracted from author tags (format: “Author: firstname lastname”) in comments wrapped by “/**” and “*/” in the source code if they exist.
    NoAF    ("NoAF"),   // Number of annotated files: counts the individual feature to file mappings in the mapping files feature-to-file.
    /* FOLDER METRICS */
    NoF     ("NoF"),    // Number of Features: total number of features directly referenced in annotations (folder, file, in-file) of the folder and any of its descendants
    LoFoC   ("LoFoC"),  // Lines of Folder Code: total lines in any descendant file of the folder
    NoFi    ("NoFi"),   //Number of Files: number of all descendant files of the folder
    /* PROJECT METRICS */
    // NoF  ("NoF")     // Number of features in project => With FAXE implicit given with path to root folder
    // Total LoFC ("Total LoFC")   // Total Lines of Feature Code: sum of LoFC (all features) => With FAXE implicit given with path to root folder
    AvgLoFC ("AvgLoFC"),// Average Feature Lines of Code: sum of LoFC (all features) / NoF
    //AvgND ("AvgND"),     // Average Feature Nesting Depth: sum of ND (all features) / NoF
    AvgSD   ("AvgSD"),  // Average Feature Scattering Degree: sum of SD (all features) / NoF
    COUNT   ("COUNT");  // Internal enum for going through all of them.

    private final String s;
    Metrics(String s) {
        this.s = s;
    }

    @Override
    public String toString() { return s; }
}

