package se.gu.faxe;

public class AnnotationFragment extends Annotation {
    private int startline = ANNOTATION_POSITION_UNDEFINED;
    private int endline = ANNOTATION_POSITION_UNDEFINED;

    AnnotationFragment(Feature f, int startline, int endline){
        this.linkedFeatures.add(f);
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
            ret += "{ \"name\": \"" +feature.getName() +"\", \"start\":" +getStartline() +", \"end\": " +getEndline() +"}";
        }


        return ret;
    }

}
