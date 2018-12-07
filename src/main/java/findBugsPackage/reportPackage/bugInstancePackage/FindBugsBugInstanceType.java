package findBugsPackage.reportPackage.bugInstancePackage;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
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

    @JoinColumn(name = "bugInstanceTypeId")
    @OneToMany(cascade = CascadeType.ALL)
    @XmlElement(name = "SourceLine")
    private List<FindBugsBugInstanceSourceLine> sourceLineList;

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

    public List<FindBugsBugInstanceSourceLine> getSourceLineList() {
        return sourceLineList;
    }

    public void setSourceLineList(List<FindBugsBugInstanceSourceLine> sourceLineList) {
        this.sourceLineList = sourceLineList;
    }
}
