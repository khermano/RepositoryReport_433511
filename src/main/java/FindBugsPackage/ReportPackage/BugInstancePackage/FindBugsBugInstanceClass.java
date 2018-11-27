package FindBugsPackage.ReportPackage.BugInstancePackage;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

@Entity
@Table(name = "BUG_INSTANCE_CLASS")
@XmlRootElement(name = "Class")
@XmlAccessorType(XmlAccessType.FIELD)
public class FindBugsBugInstanceClass {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, updatable = false, nullable = false)
    @XmlTransient
    private Long bugInstanceClassId;

    @Column
    @XmlAttribute(name = "classname")
    private String className;

    @JoinColumn(name = "bugInstanceClassId")
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @XmlElement(name = "SourceLine")
    private FindBugsBugInstanceSourceLine sourceLine;

    public Long getBugInstanceClassId() {
        return bugInstanceClassId;
    }

    public void setBugInstanceClassId(Long bugInstanceClassId) {
        this.bugInstanceClassId = bugInstanceClassId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public FindBugsBugInstanceSourceLine getSourceLine() {
        return sourceLine;
    }

    public void setSourceLine(FindBugsBugInstanceSourceLine sourceLine) {
        this.sourceLine = sourceLine;
    }
}
