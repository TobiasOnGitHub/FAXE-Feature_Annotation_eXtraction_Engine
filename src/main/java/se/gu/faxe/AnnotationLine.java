package se.gu.faxe;

public class AnnotationLine extends Annotation {
    private int line = ANNOTATION_POSITION_UNDEFINED;

    public AnnotationLine(Feature f, int line) {
        this.linkedFeatures.add(f);     // TODO - Ask FeatureModel about Feature ; Create MESSAGE WHEN NOT EXISTING
        this.line = line;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    @Override
    public String toJSON() {
        // Build hard coded JSON String to simplify JSON handling
        String ret = "";
        boolean firstItem = true;

        for (Feature feature : linkedFeatures){
            // after first item add for all items a comma before writing the next one
            if(!firstItem){
                ret += ",";
                firstItem = false;
            }
            ret += "{ \"name\": \"" +feature.getName() +"\", \"line\":" +getLine() +"}";
        }


        return ret;
    }

}
