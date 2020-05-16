

Documentation is exclusive created for GrammarLaunch.java and EmbeddedAnnotation.java as these ones represent the public accessible classes.
Intellij how to: https://www.jetbrains.com/help/idea/working-with-code-documentation.html#

Export of JAR library for further usage into out/artifacts/FAXE-Feature_Annotation_eXtraction_Engine_jar
Intellij how to: https://stackoverflow.com/questions/1082580/how-to-build-jars-from-intellij-properly

Working with two repositories at the same time (GitHub + Bitbucket)
- General howTo: https://community.atlassian.com/t5/Bitbucket-questions/Sync-up-Bitbucket-with-Git-Hub/qaq-p/712834
Commands for this project:
Remotes
git remote add github git@github.com:TobiasOnGitHub/FAXE-Feature_Annotation_eXtraction_Engine.git
git remote add bb git@bitbucket.org:easelab/faxe.git

Remote Push URLs
git remote set-url --add --push origin git@github.com:TobiasOnGitHub/FAXE-Feature_Annotation_eXtraction_Engine.git
git remote set-url --add --push origin git@bitbucket.org:easelab/faxe.git