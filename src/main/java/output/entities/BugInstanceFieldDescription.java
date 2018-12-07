package output.entities;

public class BugInstanceFieldDescription {
    private String className;
    private String fieldName;
    private String signature;
    private boolean isStatic;
    private BugInstanceSourceLineDescription fieldSourceLine;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
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

    public BugInstanceSourceLineDescription getFieldSourceLine() {
        return fieldSourceLine;
    }

    public void setFieldSourceLine(BugInstanceSourceLineDescription fieldSourceLine) {
        this.fieldSourceLine = fieldSourceLine;
    }
}
