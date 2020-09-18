package se.gu.faxe;

public class AnnotationFragment extends Annotation {
    private int startline = ANNOTATION_POSITION_UNDEFINED;
    private int endline = ANNOTATION_POSITION_UNDEFINED;

    AnnotationFragment(int startline, int endline){
        this.startline = startline;
        this.endline   = endline;
    }

    public int getStartline() {
        return startline;
    }

    public void setStartline(int startline) {
        this.startline = startline;
    }

    public int getEndline() {
        return endline;
    }

    public void setEndline(int endline) {
        this.endline = endline;
    }

}
