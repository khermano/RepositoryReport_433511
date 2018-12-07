package input.findbugs.report.bugInstance;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.util.List;

@Entity
@Table(name = "BUG_INSTANCE_METHOD")
@XmlRootElement(name = "Method")
@XmlAccessorType(XmlAccessType.FIELD)
public class FindBugsBugInstanceMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, updatable = false, nullable = false)
    @XmlTransient
    private Long bugInstanceMethodId;

    @Column
    @XmlAttribute(name = "classname")
    private String className;

    @Column
    @XmlAttribute(name = "name")
    private String methodName;

    @Column(length = 1000)
    @XmlAttribute(name = "signature")
    private String signature;

    @Column
    @XmlAttribute(name = "isStatic")
    private boolean isStatic;

    @JoinColumn(name = "bugInstanceMethodId")
    @OneToMany(cascade = CascadeType.ALL)
    @XmlElement(name = "SourceLine")
    private List<FindBugsBugInstanceSourceLine> sourceLineList;

    public Long getBugInstanceMethodId() {
        return bugInstanceMethodId;
    }

    public void setBugInstanceMethodId(Long bugInstanceMethodId) {
        this.bugInstanceMethodId = bugInstanceMethodId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String name) {
        this.methodName = methodName;
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
