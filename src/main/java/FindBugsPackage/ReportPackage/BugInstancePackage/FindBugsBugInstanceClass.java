package FindBugsPackage.ReportPackage.BugInstancePackage;

import FindBugsPackage.ReportPackage.BugInstancePackage.FindBugsBugInstanceSourceLinePackage.SourceLine;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Class")
@XmlAccessorType(XmlAccessType.FIELD)
public class FindBugsBugInstanceClass {

    @XmlAttribute(name = "classname")
    private String className;

    @XmlAttribute(name = "role")
    private String role;

    @XmlElement(name = "SourceLine")
    private SourceLine sourceLine;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
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
