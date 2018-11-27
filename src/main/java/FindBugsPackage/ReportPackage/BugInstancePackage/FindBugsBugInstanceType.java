package FindBugsPackage.ReportPackage.BugInstancePackage;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "BUG_INSTANCE_TYPE")
@XmlRootElement(name = "Type")
@XmlAccessorType(XmlAccessType.FIELD)
public class FindBugsBugInstanceType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, updatable = false, nullable = false)
    @XmlTransient
    private Long bugInstanceTypeId;

    @Column
    @XmlAttribute(name = "descriptor")
    private String descriptor;

    @Column
    @XmlAttribute(name = "role")
    private String role;

    @Column
    @XmlAttribute(name = "typeParameters")
    private String typeParameters;

    /*@XmlAttribute(name = "classname")
    private String classname;

    @XmlAttribute(name = "name")
    private String typeName;

    @XmlAttribute(name = "signature")
    private String signature;

    @XmlAttribute(name = "isStatic")
    private String isStatic;*/

    @JoinColumn(name = "bugInstanceTypeId")
    @OneToMany(cascade = CascadeType.ALL)
    @XmlElement(name = "SourceLine")
    private List<FindBugsBugInstanceSourceLine> sourceLines;

    public Long getBugInstanceTypeId() {
        return bugInstanceTypeId;
    }

    public void setBugInstanceTypeId(Long bugInstanceTypeId) {
        this.bugInstanceTypeId = bugInstanceTypeId;
    }

    public String getDescriptor() {
        return descriptor;
    }

    public void setDescriptor(String descriptor) {
        this.descriptor = descriptor;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getTypeParameters() {
        return typeParameters;
    }

    public void setTypeParameters(String typeParameters) {
        this.typeParameters = typeParameters;
    }

    /*public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
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
    }*/

    public List<FindBugsBugInstanceSourceLine> getSourceLines() {
        return Collections.unmodifiableList(sourceLines);
    }

    public void setSourceLines(List<FindBugsBugInstanceSourceLine> sourceLines) {
        this.sourceLines = sourceLines;
    }
}
