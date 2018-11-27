package FindBugsPackage.ReportPackage.BugInstancePackage;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

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

    @Column(name = "fieldSignature")
    @XmlAttribute(name = "signature")
    private String signature;

    @Column
    @XmlAttribute(name = "isStatic")
    private boolean isStatic;

    /*@XmlAttribute(name = "role")
    private String role;*/

    @JoinColumn(name = "bugInstanceFieldId")
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @XmlElement(name = "SourceLine")
    private FindBugsBugInstanceSourceLine sourceLine;

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
