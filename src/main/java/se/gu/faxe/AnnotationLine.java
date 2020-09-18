package se.gu.faxe;

public class AnnotationLine extends Annotation {
    private int line = ANNOTATION_POSITION_UNDEFINED;

    public AnnotationLine() {
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

}
