package output.entities;


public class BugInstanceClassDescription {
    private String className;
    private BugInstanceSourceLineDescription classSourceLine;

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
