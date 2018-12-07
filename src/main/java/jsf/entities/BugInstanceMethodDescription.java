package jsf.entities;

public class BugInstanceMethodDescription {
    private String className;
    private String methodName;
    private String signature;
    private boolean isStatic;
    private BugInstanceSourceLineDescription methodSourceLine;

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
