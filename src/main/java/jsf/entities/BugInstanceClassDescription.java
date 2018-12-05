package jsf.entities;


public class BugInstanceClassDescription {
    private String className;
    private BugInstanceSourceLineDescription classSourceLine;

    public BugInstanceClassDescription() {
    }

    /*public BugInstanceClassDescription(String className, BugInstanceSourceLineDescription classSourceLine) {
        this.className = className;
        this.classSourceLine = classSourceLine;
    }*/

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public BugInstanceSourceLineDescription getClassSourceLine() {
        return classSourceLine;
    }

    public void setClassSourceLine(BugInstanceSourceLineDescription classSourceLine) {
        this.classSourceLine = classSourceLine;
    }
}
