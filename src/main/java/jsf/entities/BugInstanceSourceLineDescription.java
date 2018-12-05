package jsf.entities;

public class BugInstanceSourceLineDescription {
    private String className;
    private int start;
    private int end;
    private String sourceFile;
    private String sourcePath;

    public BugInstanceSourceLineDescription() {
    }

    public BugInstanceSourceLineDescription(String className, int start, int end, String sourceFile, String sourcePath) {
        this.className = className;
        this.start = start;
        this.end = end;
        this.sourceFile = sourceFile;
        this.sourcePath = sourcePath;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public String getSourceFile() {
        return sourceFile;
    }

    public void setSourceFile(String sourceFile) {
        this.sourceFile = sourceFile;
    }

    public String getSourcePath() {
        return sourcePath;
    }

    public void setSourcePath(String sourcePath) {
        this.sourcePath = sourcePath;
    }
}
