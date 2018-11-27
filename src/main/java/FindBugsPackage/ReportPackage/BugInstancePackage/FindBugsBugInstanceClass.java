package FindBugsPackage.ReportPackage.BugInstancePackage;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.util.Collections;
import java.util.List;

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

    /*@XmlAttribute(name = "role")
    private String role;*/

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

    /*public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }*/

    public FindBugsBugInstanceSourceLine getSourceLine() {
        return sourceLine;
    }

    public void setSourceLine(FindBugsBugInstanceSourceLine sourceLine) {
        this.sourceLine = sourceLine;
    }
}
