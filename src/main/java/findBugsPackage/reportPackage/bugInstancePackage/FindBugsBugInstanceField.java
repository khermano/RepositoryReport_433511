package findBugsPackage.reportPackage.bugInstancePackage;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.util.List;

@Entity
@Table(name = "BUG_INSTANCE_FIELD")
@XmlRootElement(name = "Field")
@XmlAccessorType(XmlAccessType.FIELD)
public class FindBugsBugInstanceField {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, updatable = false, nullable = false)
    @XmlTransient
    private Long bugInstanceFieldId;

    @Column
    @XmlAttribute(name = "classname")
    private String className;

    @Column
    @XmlAttribute(name = "name")
    private String fieldName;

    @Column
    @XmlAttribute(name = "signature")
    private String signature;

    @Column
    @XmlAttribute(name = "isStatic")
    private boolean isStatic;

    @JoinColumn(name = "bugInstanceFieldId")
    @OneToMany(cascade = CascadeType.ALL)
    @XmlElement(name = "SourceLine")
    private List<FindBugsBugInstanceSourceLine> sourceLineList;

    public Long getBugInstanceFieldId() {
        return bugInstanceFieldId;
    }

    public void setBugInstanceFieldId(Long bugInstanceFieldId) {
        this.bugInstanceFieldId = bugInstanceFieldId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public boolean getIsStatic() {
        return isStatic;
    }

    public void setIsStatic(boolean isStatic) {
        this.isStatic = isStatic;
    }

    public List<FindBugsBugInstanceSourceLine> getSourceLineList() {
        return sourceLineList;
    }

    public void setSourceLineList(List<FindBugsBugInstanceSourceLine> sourceLineList) {
        this.sourceLineList = sourceLineList;
    }
}
