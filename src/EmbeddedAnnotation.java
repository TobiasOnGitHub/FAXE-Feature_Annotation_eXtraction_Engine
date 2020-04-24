public class EmbeddedAnnotation {
    public enum eEAType {
        eaType_UNKNOWN ("UNKNOWN"),
        eaType_FOLDER  ("FOLDER"),
        eaType_FILE    ("FILE"),
        eaType_BEGIN   ("BEGIN"),
        eaType_END     ("END"),
        eaType_FRAGMENT("FRAGMENT"),
        eaType_LINE    ("LINE"),
        eaType_COUNT   ("COUNT");

        private final String type;
        eEAType(String s) {
            this.type = s;
        }
        @Override
        public String toString() { return type; }
    }

    private eEAType eaType;
    private int openingLine;
    private int closingLine;
    private String feature;

    public EmbeddedAnnotation(eEAType eaType, int openingLine, int closingLine, String feature){
        this.eaType = eaType;
        this.openingLine = openingLine;
        this.closingLine = closingLine;
        this.feature = feature;
    }

    public EmbeddedAnnotation getEmbeddedAnnotation(){
        return this;
    }

    public String toString(){
        return eaType.toString() +" " +feature +" " +openingLine +" " +closingLine;
    }

    public eEAType getEaType() {
        return eaType;
    }
    public int getClosingLine() {
        return closingLine;
    }
    public int getOpeningLine() {
        return openingLine;
    }
    public String getFeature() {
        return feature;
    }

    public void setEaType(eEAType eaType){
        this.eaType = eaType;
    }
    public void setOpeningLine(int openingLine){
        this.openingLine = openingLine;
    }
    public void setClosingLine(int closingLine){
        this.closingLine = closingLine;
    }
}
