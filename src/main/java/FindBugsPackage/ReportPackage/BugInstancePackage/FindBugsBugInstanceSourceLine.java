package FindBugsPackage.ReportPackage.BugInstancePackage;

import FindBugsPackage.ReportPackage.BugInstancePackage.FindBugsBugInstanceSourceLinePackage.SourceLine;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "SourceLine")
@XmlAccessorType(XmlAccessType.FIELD)
public class FindBugsBugInstanceSourceLine {

    @XmlAttribute(name = "classname")
    private String classname;

    @XmlAttribute(name = "start")
    private short start;

    @XmlAttribute(name = "end")
    private short end;

    @XmlAttribute(name = "startBytecode")
    private short startBytecode;

    @XmlAttribute(name = "endBytecode")
    private short endBytecode;

    @XmlAttribute(name = "sourcefile")
    private String sourcefile;

    @XmlAttribute(name = "sourcepath")
    private String sourcepath;

    @XmlAttribute(name = "role")
    private String role;

    @XmlAttribute(name = "name")
    private String name;

    @XmlAttribute(name = "signature")
    private String signature;

    @XmlAttribute(name = "isStatic")
    private String isStatic;

    @XmlElement(name = "SourceLine")
    private List<SourceLine> sourceLineList;

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public short getStart() {
        return start;
    }

    public void setStart(short start) {
        this.start = start;
    }

    public short getEnd() {
        return end;
    }

    public void setEnd(short end) {
        this.end = end;
    }

    public short getStartBytecode() {
        return startBytecode;
    }

    public void setStartBytecode(short startBytecode) {
        this.startBytecode = startBytecode;
    }

    public short getEndBytecode() {
        return endBytecode;
    }

    public void setEndBytecode(short endBytecode) {
        this.endBytecode = endBytecode;
    }

    public String getSourcefile() {
        return sourcefile;
    }

    public void setSourcefile(String sourcefile) {
        this.sourcefile = sourcefile;
    }

    public String getSourcepath() {
        return sourcepath;
    }

    public void setSourcepath(String sourcepath) {
        this.sourcepath = sourcepath;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    public List<SourceLine> getSourceLineList() {
        return sourceLineList;
    }

    public void setSourceLineList(List<SourceLine> sourceLineList) {
        this.sourceLineList = sourceLineList;
    }
}
