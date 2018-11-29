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

    @Column
    @XmlAttribute(name = "sourcefile")
    private String sourceFile;

    @Column
    @XmlAttribute(name = "sourcepath")
    private String sourcePath;

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
}
