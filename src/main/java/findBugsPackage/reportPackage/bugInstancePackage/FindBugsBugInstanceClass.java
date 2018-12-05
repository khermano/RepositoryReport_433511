package findBugsPackage.reportPackage.bugInstancePackage;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
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

    @JoinColumn(name = "bugInstanceClassId")
    @OneToMany(cascade = CascadeType.ALL)
    @XmlElement(name = "SourceLine")
    private List<FindBugsBugInstanceSourceLine> sourceLineList;

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

    public List<FindBugsBugInstanceSourceLine> getSourceLineList() {
        return sourceLineList;
    }

    public void setSourceLineList(List<FindBugsBugInstanceSourceLine> sourceLineList) {
        this.sourceLineList = sourceLineList;
    }
}
