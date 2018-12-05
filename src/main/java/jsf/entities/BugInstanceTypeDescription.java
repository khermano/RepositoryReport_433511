package jsf.entities;

public class BugInstanceTypeDescription {
    private String descriptor;
    private String role;
    private String typeParameters;
    private BugInstanceSourceLineDescription typeSourceLine;

    public BugInstanceTypeDescription() {
    }

    /*public BugInstanceTypeDescription(String descriptor, String role, String typeParameters, String className, int start, int end, String sourceFile, String sourcePath) {
        this.descriptor = descriptor;
        this.role = role;
        this.typeParameters = typeParameters;
        this.className = className;
        this.start = start;
        this.end = end;
        this.sourceFile = sourceFile;
        this.sourcePath = sourcePath;
    }*/

    public String getDescriptor() {
        return descriptor;
    }

    public void setDescriptor(String descriptor) {
        this.descriptor = descriptor;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getTypeParameters() {
        return typeParameters;
    }

    public void setTypeParameters(String typeParameters) {
        this.typeParameters = typeParameters;
    }

    public BugInstanceSourceLineDescription getTypeSourceLine() {
        return typeSourceLine;
    }

    public void setTypeSourceLine(BugInstanceSourceLineDescription typeSourceLine) {
        this.typeSourceLine = typeSourceLine;
    }
}
