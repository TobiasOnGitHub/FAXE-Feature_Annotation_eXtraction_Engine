FAXE - Feature Annotation eXtraction Engine
===========================================
Welcome to FAXE!

FAXE is an open source library (Apache 2.0) for parsing and receiving embedded annotations from software projects.


1) Definition of embedded annotations
-------------------------------------------
Specification:	https://bitbucket.org/easelab/faxe/src/master/specification/


2) Installation and setup
-------------------------------------------
FAXE is designed as independent library and includes all dependencies in its JAR file.
1. Clone/Download this repository
2. Go to main folder 
3. Build JAR with "mvn install"
4. Copy genrated JAR target/faxe-0.1.jar to your project and include it


3) Usage
-------------------------------------------
import se.gu.faxe.EmbeddedAnnotation;
import se.gu.faxe.FAXE;
...
File file = new File("folder or filename.txt");
List<EmbeddedAnnotation> FAXE.getEmbeddedAnnotations(file);


4) FAXE Tools
-------------------------------------------
Build in command line tooling allows you to access FAXE's API via the command line interface.
API command line tooling:
---> TODO - Add after general update

Tool "Feature-base partial commit" is an extended use case of FAXE to perform partial commits, based on features, which are documented with embedded 
annotations. 
API command line tooling:
---> TODO - Add after general update

All tools can be found in this repository in:	https://bitbucket.org/easelab/faxe/src/master/src/main/java/se/gu/faxe/commands/

===========================================