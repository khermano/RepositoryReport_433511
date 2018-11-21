package FindBugsPackage.ReportPackage.BugInstancePackage;

import FindBugsPackage.ReportPackage.BugInstancePackage.FindBugsBugInstanceSourceLinePackage.SourceLine;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Method")
@XmlAccessorType(XmlAccessType.FIELD)
public class FindBugsBugInstanceMethod {

    @XmlAttribute(name = "classname")
    private String classname;

    @XmlAttribute(name = "name")
    private String name;

    @XmlAttribute(name = "signature")
    private String signature;

    @XmlAttribute(name = "isStatic")
    private String isStatic;

    @XmlAttribute(name = "role")
    private String role;

    @XmlElement(name = "SourceLine")
    private SourceLine sourceLine;

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public SourceLine getSourceLine() {
        return sourceLine;
    }

    public void setSourceLine(SourceLine sourceLine) {
        this.sourceLine = sourceLine;
    }
}
