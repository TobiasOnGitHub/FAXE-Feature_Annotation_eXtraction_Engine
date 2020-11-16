FAXE - Feature Annotation eXtraction Engine
===========================================
FAXE is an open source library (Apache 2.0) for parsing and receiving embedded annotations from software projects.
Video introduction process and tooling: [SPLC2020: A Common Notation and Tool Support for Embedded Feature Annotations](https://www.youtube.com/watch?v=vprhZdSJogs)

Requirements
-------------------------------------------
The Library requires [Java SE Development Kit 8](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html) or higher.
As well as the [Maven](https://maven.apache.org/) build system.

**Hint:** Current version FAXE 0.1 developed and tested in Windows.

Maven dependency
-------------------------------------------
To include FAXE to your project use the following dependency:

- Available with the upcoming versions. 

Development
-------------------------------------------
The development happens on the master branch. New features might be introduced irregularly. 

Description
-------------------------------------------
The tool FAXE automatically extracts and processes embedded an-notations specified in the 
proposed syntax from a given asset. It is a lightweight tool which requires no installation 
by the developer. FAXE is implemented as a Java library under the APACHE 2.0 license. 
To facilitate integration with IDEs and other tools (e.g,for visualization), we provide the 
implementation as a single jar file, with all dependencies contained inside. At the core of 
the engine is the annotation parser built with the ANTLR4 parser generator. It relies on 
syntax of our annotation system specified as an ANTLR4grammar. Given an asset (a project, 
folder or specific file), FAXE extracts annotations from all sub-assets recursively, down 
to the line annotations. It is language-independent; extracting annotations from textual 
assets written in any language.

Presently, users can interact with FAXE in two ways; integrate the library in the client project and use its API 
directly, or use its command line interface. FAXE builds on an object model; for each API request, FAXE extracts the 
location of features and returns an object list. The returned data includes asset type, 
asset name, index of begin and end, and the feature(s) referred to in the annotation.

Theory
-------------------------------------------
Background theory and motivation to embedded annotations and FAXE are presented in 
*Tobias Schwarz, Wardah Mahmood, Thorsten Berger, “A Common Notation and Tool Support 
for Embedded Feature Annotations,” in 24th ACM International Systems and Software Product 
Line Conference (SPLC), Tools Track, 2020.* [(link)](https://dl.acm.org/doi/abs/10.1145/3382026.3431253)

Definition of Embedded Annotations
-------------------------------------------
The embedded annotation system allows mapping features to many kinds of software assets 
(code and non-code)—at the granularity of whole folders and files, and textual assets 
at an arbitrary granularity (e.g., classes, methods, code blocks, lines). The exact 
specifications with grammars can be found online [https://bitbucket.org/easelab/faxe/src/master/specification/](https://bitbucket.org/easelab/faxe/src/master/specification/).

Embedded Annotation Data Sets
-------------------------------------------
A collection of project with embedded annotations can be found here [https://bitbucket.org/easelab/embeddedannotationdatasetmain/](https://bitbucket.org/easelab/embeddedannotationdatasetmain/)
as well as in the FAXE tool itself. The data sets are conform to the embedded annotation 
specification: [Link](https://bitbucket.org/easelab/faxe/src/master/specification/)

Embedded Annotation Metrics
-------------------------------------------
FAXE is supporting a set of metrics, e.g. scattering degree or tangling degree for a specific feature ; or how many features are used in the project and their average line count.
The individual metrics are described with their purpose and how they are calculated in this document: [Embedded Annotations Metrics](https://bitbucket.org/easelab/faxe/src/master/specification/embedded_annotation_metrics.pdf)  

Installation and setup
-------------------------------------------
FAXE is designed as independent library and includes all dependencies in a single JAR file.
1. Clone/Download this repository
2. Go to main folder 
3. Build JAR with "mvn install"
4. Copy generated JAR target/faxe-0.1.jar to your project and include it


Tool usage
-------------------------------------------

##API-Usage

A detailed description of the FAXE API can be found here: 
**Import library to your project**

    import se.gu.faxe.FAXE;

**Instantiate FAXE** 

    File rootFolder = new File("C:\\path-to-project-root");
    FAXE faxe = new FAXE(rootFolder);

**Generate feature model** 

This is required when the feature model is not in the given root folder.

    File pathFeatureModel = new File("C:\\path-to-feature-model");
    faxe.getEmbeddedAnnotationsFeatureModel(new Asset(pathFeatureModel));

**Extract embedded annotation information**

FAXE keeps track of all embedded annotations in the project. This overview is being stored in a tree structure and can 
be accessed by this command. The tree structure is implemented by the [Tree data structure library of Scalified](https://github.com/Scalified/tree).

    FAXE faxe = new FAXE(new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/data")));
    TreeNode<Asset> knownAssets = faxe.getKnownAssets();

In case a specific folder, text or mapping file shall be analyzed, FAXE offers a method to request embedded annotation 
information for given directory.

    FAXE faxe = new FAXE(new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/data")));

    File f = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/data"));
    TreeNode<Asset> assets = faxe.getEmbeddedAnnotations(f);




**Generate metrics**

FAXE supports a set of metrics which can be accessed via the same method. 
Depending on the metric, you have to add a feature of interest to the request.

    FAXE faxe = new FAXE(new File("C:\\path-to-project-root"));
    double metric_value = faxe.getMetrics(f, Metrics.SD, new Feature("Feature-of-intrest"));

Available metrics:

    /* FEATURE METRICS */
    SD       ("SD"),      // Scattering Degree: total number of all annotations directly referencing the feature (i.e., in-file, folder, and file annotations referencing it)
    NoFiA    ("NoFiA"),   // Number of File Annotations: total number of file annotations directly referencing the feature
    NoFoA    ("NoFoA"),   // Number of Folder Annotations: total number of folder annotations directly referencing the feature.
    TD       ("TD"),      // Tangling Degree: number of other features that share the same artifacts (or parts of such) with the feature. Two features share (parts of) artifacts when the latter is annotated with both features.
    LoFC     ("LoFC"),    // Lines of Feature Code: lines of code belonging to artifacts, either directly annotated, or indirectly (when a folder is annotated, all descendants are taken into account)
    AvgND    ("AvgND"),   /* Nesting depths of annotations: Maximum (MaxND), Minimum (MinND), and Average (AvgND) nesting depth the annotations directly referencing the feature. The project’s root folder has depth 0 (and so has any file contained in it). */
    MaxND    ("MaxND"),   /* Each sub-folder increases the depth by one, a file inherits the depth of its containing folder. The depth of a (top-level, i.e., non-nested) in-file annotation is the depth of the file increased by one. Since in-file annotations */
    MinND    ("MinND"),   /* can be nested, each nesting increases the depth by one. All nesting-depth metrics are calculated relative to the project root folder. */
    NoAF     ("NoAF"),    // Number of Annotated Files: counts the individual feature to file mappings in the mapping files feature-to-file.
    /* PROJECT METRICS */
    NoF      ("NoF"),     // Number of Features: total number of features directly referenced in annotations (folder, file, in-file) of the folder and any of its descendants

Supported in upcoming versions: 

    pAvgLoFC ("pAvgLoFC"),// Average Feature Lines of Feature Code: sum of LoFC (all features) / NoF
    pAvgND   ("pAvgND"),  // Average Feature Nesting Depth: sum of ND (all features) / NoF
    pAvgSD   ("pAvgSD"),  // Average Feature Scattering Degree: sum of SD (all features) / NoF


**Export embedded annotations to JSON**

This generates two files in the FAXE project root: assets.json and featureModel.json .

    faxe.serializeToJSON();





CMD-Usage
-------------------------------------------
Build in command line tooling allows you to access FAXE's API via the command line interface.

**Import library to your project**

Call on your command line "java -jar faxe-0.1.jar [COMMAND] [-hV]"
The FAXE tool provides a help function (-h, --help) for all commands and respective parameters.

**Extract embedded annotation information**

Extracts and returns embedded annotations from an asset's path for the feature in lpq, and exports the output to a file 
if the flag export is set. If lpq is not specified, it extracts all annotations from path. 

    Usage:  getEmbeddedAnnotations [-e] [-l=<featureLPQ>] <path> 
          <path>               Asset's path (file|folder) to extract and return embedded annotations from. 
      -e, --export             Exports the output to a file if the flag export is set. 
      -l, --lpq=<featureLPQ>   Feature in lpq. 

    java -jar faxe-0.1.jar getEmbeddedAnnotations --lpq=BitcoinBalance ./WalletBalanceFragment.java
    .\WalletBalanceFragment.java:BitcoinBalance 54:310




**Generate metrics**

Calculates and returns required metric (enum) for the feature referred to in
the lpq from the given path. It also exports the output to a file if the flag
export is set. If metric is not specified, all metrics are calculated and
exported.

    Usage:  calculateMetric [-e] [-l=<lPQ>] [-m=<metric>] <path> 
          <path>              Asset's path (file|folder) to calculates and returns required metric from. 
      -e, --export            Exports the output to a file if the flag export is set. 
      -l, --lpq=<lPQ>         Feature in lpq. 
      -m, --metric=<metric>   Metric. Valid values: ALL, SD, NoFiA, NoFoA, TD, LoFC, AvgND, MaxND, MinND, NoAF, NoF, pAvgLoFC,
                              pAvgND, pAvgSD, COUNT. 

    java -jar faxe-0.1.jar calculateMetric -l BitcoinBalance -m=SD ./WalletBalanceFragment.java
    Path    .\WalletBalanceFragment.java
    Metric  SD
    Feature BitcoinBalance
    Metric SD=1.0


**Find embedded annotation inconsistencies**

Checks and prints inconsistencies in annotations in the given path.

    Usage:  checkConsistency <path>
          <path>   Asset's path (file|folder) to check and print inconsistencies in annotations.

Functionality following in upcoming versions.


**Rename an existing feature**

Renames the feature referred to in lpq to a new name in the feature model and all annotations.

    Usage:  rename <path> <lpqFrom> <lpqTo>
          <path>      Asset's path (file|folder) to rename the lpq.
          <lpqFrom>   LPQ to be renamed.
          <lpqTo>     New name of LPQ.

Functionality following in upcoming versions.


**Feature-Based Partial Commit**

Perform Feature-Based Partial Commit.

Details about the process are given in the chapter "Feature-Base Partial Commit with Git".

    Usage:  fbpc [-nc] [-f=<featureLPQ>] [-m=<message>] <gitWorkingDirectory> <srcFolder>
          <gitWorkingDirectory> Path to git working directory (with .git) of project. (data provided by calling bash script).
          <srcFolder>           Source code folder inside working directory. (relative path from gitWorkingDirectory)
          -f, --feature=<featureLPQ> Feature to be commited via partial commit.
          -m, --message=<message>   Text for commit message.
              -nc, --no-commit      Create partial commit in staging area. Manual get-commit required afterwards.

Functionality following in upcoming versions.


FAXE Tool
-------------------------------------------
All tools can be found in this repository in:	[https://bitbucket.org/easelab/faxe/src/master/src/main/java/se/gu/faxe/commands/](https://bitbucket.org/easelab/faxe/src/master/src/main/java/se/gu/faxe/commands/)

Feature-Base Partial Commit with Git
-------------------------------------------
Tool "Feature-Base Partial Commit" is an extended use case of FAXE to perform partial commits, based on features, 
which are documented with embedded annotations. The functionality is available via the API and command line. But, 
it becomes most effective when using it as a regular git sub-command.

Functionality following in upcoming versions.


**INSTALLATION**

Copy both files

* FAXE-Feature_Annotation_eXtraction_Engine\src\main\bash\git-pfc
* FAXE-Feature_Annotation_eXtraction_Engine\target\faxe-0.1.jar (generated)
To your local Git directory for custom Git commands, e.g. C:\Users\User-Name\bin

**USAGE**

1. Restart your Git console. Try out if it worked by adding "git-pf" and by pressing "tab" the remaining "c" shall appear.
2. Go to your repository main directory (optional to shorten to be provided paths)
3. Call "git-pfc" with your git working directory path (or .) and the folder name of your source directory
   * The tool will check your changes features and provide you a selection. (Unless you provide this information via the option -f|--feature)
   * The tool will ask for a commit message (optional). (Unless you provide this information via the option -m|--message)
   * A partial commit on the selected feature has to be performed.
4. After committing all features, a git-push is required.

===========================================