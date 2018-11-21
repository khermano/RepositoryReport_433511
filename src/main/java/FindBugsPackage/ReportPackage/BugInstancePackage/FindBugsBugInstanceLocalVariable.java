package FindBugsPackage.ReportPackage.BugInstancePackage;

import FindBugsPackage.ReportPackage.BugInstancePackage.FindBugsBugInstanceSourceLinePackage.SourceLine;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "LocalVariable")
@XmlAccessorType(XmlAccessType.FIELD)
public class FindBugsBugInstanceLocalVariable {

    @XmlAttribute(name = "name")
    private String name;

    @XmlAttribute(name = "register")
    private byte register;

    @XmlAttribute(name = "pc")
    private short pc;

    @XmlAttribute(name = "role")
    private String role;

    @XmlAttribute(name = "classname")
    private String classname;

    @XmlAttribute(name = "signature")
    private String signature;

    @XmlAttribute(name = "isStatic")
    private String isStatic;

    @XmlElement(name = "SourceLine")
    private List<SourceLine> sourceLineList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getRegister() {
        return register;
    }

    public void setRegister(byte register) {
        this.register = register;
    }

    public short getPc() {
        return pc;
    }

    public void setPc(short pc) {
        this.pc = pc;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
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

    public List<SourceLine> getSourceLineList() {
        return sourceLineList;
    }

    public void setSourceLineList(List<SourceLine> sourceLineList) {
        this.sourceLineList = sourceLineList;
    }
}
