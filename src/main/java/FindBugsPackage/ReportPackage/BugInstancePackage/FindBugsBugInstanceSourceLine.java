package FindBugsPackage.ReportPackage.BugInstancePackage;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

@Entity
@Table(name = "SOURCE_LINE")
@XmlRootElement(name = "SourceLine")
@XmlAccessorType(XmlAccessType.FIELD)
public class FindBugsBugInstanceSourceLine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, updatable = false, nullable = false)
    @XmlTransient
    private Long sourceLineId;

    @Column
    @XmlAttribute(name = "classname")
    private String className;

    @Column
    @XmlAttribute(name = "start")
    private int start;

    @Column
    @XmlAttribute(name = "end")
    private int end;

    /*@XmlAttribute(name = "startBytecode")
    private short startBytecode;

    @XmlAttribute(name = "endBytecode")
    private short endBytecode;*/

    @Column
    @XmlAttribute(name = "sourcefile")
    private String sourceFile;

    @Column
    @XmlAttribute(name = "sourcepath")
    private String sourcePath;

    /*@XmlAttribute(name = "role")
    private String role;

    @XmlAttribute(name = "name")
    private String sourceLineName;

    @XmlAttribute(name = "signature")
    private String signature;

    @XmlAttribute(name = "isStatic")
    private String isStatic;*/

    public Long getSourceLineId() {
        return sourceLineId;
    }

    public void setSourceLineId(Long sourceLineId) {
        this.sourceLineId = sourceLineId;
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

    /*public short getStartBytecode() {
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
    }*/

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

    /*public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSourceLineName() {
        return sourceLineName;
    }

    public void setSourceLineName(String sourceLineName) {
        this.sourceLineName = sourceLineName;
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
    }*/
}
