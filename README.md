FAXE - Feature Annotation eXtraction Engine
===========================================
Welcome to FAXE!

FAXE is an open source library (Apache 2.0) for parsing and receiving embedded annotations from software projects.


1) Definition of embedded annotations
-------------------------------------------
Specification:	https://bitbucket.org/easelab/faxe/src/master/specification/

2) Embedded Annotation Data Sets
-------------------------------------------
Example projects, annotated with embedded annotations: 
https://bitbucket.org/easelab/embeddedannotationdatasetmain/

3) Installation and setup
-------------------------------------------
FAXE is designed as independent library and includes all dependencies in its JAR file.
1. Clone/Download this repository
2. Go to main folder 
3. Build JAR with "mvn install"
4. Copy genrated JAR target/faxe-0.1.jar to your project and include it

4) Tool usage
-------------------------------------------
4.1) API-Usage
-------------------------------------------
1.) Import library to your project:

    import se.gu.faxe.FAXE;

Instantiate FAXE 

    File rootFolder = new File("C:\\path-to-project-root");
    FAXE faxe = new FAXE(rootFolder);

Generate feature model. This is required when the feature model is not in the given root folder.

    File pathFeatureModel = new File("C:\\path-to-feature-model");
    faxe.getEmbeddedAnnotationsFeatureModel(new Asset(pathFeatureModel));

2.) Export embedded annotations to JSON

    faxe.serializeToJSON();

This generates two files in the FAXE project root: assets.json and featureModel.json

4.2) CMD-Usage
-------------------------------------------
Build in command line tooling allows you to access FAXE's API via the command line interface.
Call on your command line "java -jar faxe-0.1.jar [COMMAND] [-hV]"
The FAXE tool provides a help function (-h, --help) for all COMMANDs and respective parameters.


5) FAXE Tool
-------------------------------------------
All tools can be found in this repository in:	https://bitbucket.org/easelab/faxe/src/master/src/main/java/se/gu/faxe/commands/

5.1)  Feature-Base Partial Commit with Git
-------------------------------------------
Tool "Feature-base partial commit" is an extended use case of FAXE to perform partial commits, based on features, 
which are documented with embedded annotations. The functionality is available via the API and command line. But, 
it becomes most effective when using it as a regular git sub-command.

The current implementation is in Alpha testing phase!

INSTALLATION
------------
Copy both files
- FAXE-Feature_Annotation_eXtraction_Engine\src\main\bash\git-pfc
- FAXE-Feature_Annotation_eXtraction_Engine\target\faxe-0.1.jar (generated)
To your local Git directory for custom Git commands, e.g. C:\Users\User-Name\bin

USAGE
------------
0) Restart your Git console
1) Go to your repository main directory (optional to shorten to be provided paths)
2) Call "git-pfc" with your git working directory path (or .) and the folder name of your source directory
   The tool will check your changes features and provide you a selection. (Unless you provide this information via the option -f|--feature)
   The tool will ask for a commit message (optional). (Unless you provide this information via the option -m|--message)
   A partial commit on the selected feature has to be performed.
3) After committing all features, a git-push is required.

===========================================