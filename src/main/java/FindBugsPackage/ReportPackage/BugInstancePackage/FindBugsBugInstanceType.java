package FindBugsPackage.ReportPackage.BugInstancePackage;

import FindBugsPackage.ReportPackage.BugInstancePackage.FindBugsBugInstanceSourceLinePackage.SourceLine;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Type")
@XmlAccessorType(XmlAccessType.FIELD)
public class FindBugsBugInstanceType {

    @XmlAttribute(name = "descriptor")
    private String descriptor;

    @XmlAttribute(name = "role")
    private String role;

    @XmlAttribute(name = "typeParameters")
    private String typeParameters;

    @XmlAttribute(name = "classname")
    private String classname;

    @XmlAttribute(name = "name")
    private String name;

    @XmlAttribute(name = "signature")
    private String signature;

    @XmlAttribute(name = "isStatic")
    private String isStatic;

    @XmlElement(name = "SourceLine")
    private SourceLine sourceLine;

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

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getIsStatic() {
        return isStatic;
    }

    public void setIsStatic(String isStatic) {
        this.isStatic = isStatic;
    }

    public SourceLine getSourceLine() {
        return sourceLine;
    }

    public void setSourceLine(SourceLine sourceLine) {
        this.sourceLine = sourceLine;
    }
}
