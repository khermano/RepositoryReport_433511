package jsf.entities;

public class BugInstanceMethodDescription {
    private String className;
    private String methodName;
    private String signature;
    private boolean isStatic;
    private BugInstanceSourceLineDescription methodSourceLine;

    public BugInstanceMethodDescription() {
    }

    /*public BugInstanceMethodDescription(String className, String methodName, String signature, boolean isStatic, int start, int end, String sourceFile, String sourcePath) {
        this.className = className;
        this.methodName = methodName;
        this.signature = signature;
        this.isStatic = isStatic;
        this.start = start;
        this.end = end;
        this.sourceFile = sourceFile;
        this.sourcePath = sourcePath;
    }*/

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public boolean getIsStatic() {
        return isStatic;
    }

    public void setIsStatic(boolean isStatic) {
        this.isStatic = isStatic;
    }

    public BugInstanceSourceLineDescription getMethodSourceLine() {
        return methodSourceLine;
    }

    public void setMethodSourceLine(BugInstanceSourceLineDescription methodSourceLine) {
        this.methodSourceLine = methodSourceLine;
    }
}
