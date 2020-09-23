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

}
