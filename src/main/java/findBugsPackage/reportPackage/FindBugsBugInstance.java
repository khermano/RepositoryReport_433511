package findBugsPackage.reportPackage;

import findBugsPackage.reportPackage.bugInstancePackage.*;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.util.List;

@Entity
@Table(name = "BUG_INSTANCE")
@XmlRootElement(name = "BugInstance")
@XmlAccessorType(XmlAccessType.FIELD)
public class FindBugsBugInstance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, updatable = false, nullable = false)
    @XmlTransient
    private Long bugInstanceId;

    @Column
    @XmlAttribute(name = "type")
    private String type;

    @Column
    @XmlAttribute(name = "priority")
    private byte priority;

    @Column
    @XmlAttribute(name = "rank")
    private int rank;

    @Column
    @XmlAttribute(name = "abbrev")
    private String abbrev;

    @Column
    @XmlAttribute(name = "category")
    private String category;

    @JoinColumn(name = "bugInstanceId", nullable = false)
    @OneToMany(cascade = CascadeType.ALL)
    @XmlElement(name = "Class")
    private List<FindBugsBugInstanceClass> bugInstanceClassList;

    @JoinColumn(name = "bugInstanceId", nullable = false)
    @OneToMany(cascade = CascadeType.ALL)
    @XmlElement(name = "Method")
    private List<FindBugsBugInstanceMethod> bugInstanceMethodList;

    @JoinColumn(name = "bugInstanceId", nullable = false)
    @OneToMany(cascade = CascadeType.ALL)
    @XmlElement(name = "Type")
    private List<FindBugsBugInstanceType> bugInstanceTypeList;

    @JoinColumn(name = "bugInstanceId", nullable = false)
    @OneToMany(cascade = CascadeType.ALL)
    @XmlElement(name = "Field")
    private List<FindBugsBugInstanceField> bugInstanceFieldList;

    @JoinColumn(name = "bugInstanceId")
    @OneToMany(cascade = CascadeType.ALL)
    @XmlElement(name = "SourceLine")
    private List<FindBugsBugInstanceSourceLine> bugInstanceSourceLineList;

    @JoinColumn(name = "bugInstanceId", nullable = false)
    @OneToMany(cascade = CascadeType.ALL)
    @XmlElement(name = "String")
    private List<FindBugsBugInstanceString> bugInstanceStringList;

    @JoinColumn(name = "bugInstanceId", nullable = false)
    @OneToMany(cascade = CascadeType.ALL)
    @XmlElement(name = "LocalVariable")
    private List<FindBugsBugInstanceLocalVariable> bugInstanceLocalVariableList;

    @JoinColumn(name = "bugInstanceId", nullable = false)
    @OneToMany(cascade = CascadeType.ALL)
    @XmlElement(name = "Property")
    private List<FindBugsBugInstanceProperty> bugInstancePropertyList;

    @JoinColumn(name = "bugInstanceId", nullable = false)
    @OneToMany(cascade = CascadeType.ALL)
    @XmlElement(name = "Int")
    private List<FindBugsBugInstanceInt> bugInstanceIntList;

    public Long getBugInstanceId() {
        return bugInstanceId;
    }

    public void setBugInstanceId(Long bugInstanceId) {
        this.bugInstanceId = bugInstanceId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte getPriority() {
        return priority;
    }

    public void setPriority(byte priority) {
        this.priority = priority;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getAbbrev() {
        return abbrev;
    }

    public void setAbbrev(String abbrev) {
        this.abbrev = abbrev;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<FindBugsBugInstanceClass> getBugInstanceClassList() {
        return bugInstanceClassList;
    }

    public void setBugInstanceClassList(List<FindBugsBugInstanceClass> bugInstanceClassList) {
        this.bugInstanceClassList = bugInstanceClassList;
    }

    public List<FindBugsBugInstanceMethod> getBugInstanceMethodList() {
        return bugInstanceMethodList;
    }

    public void setBugInstanceMethodList(List<FindBugsBugInstanceMethod> bugInstanceMethodList) {
        this.bugInstanceMethodList = bugInstanceMethodList;
    }

    public List<FindBugsBugInstanceType> getBugInstanceTypeList() {
        return bugInstanceTypeList;
    }

    public void setBugInstanceTypeList(List<FindBugsBugInstanceType> bugInstanceTypeList) {
        this.bugInstanceTypeList = bugInstanceTypeList;
    }

    public List<FindBugsBugInstanceField> getBugInstanceFieldList() {
        return bugInstanceFieldList;
    }

    public void setBugInstanceFieldList(List<FindBugsBugInstanceField> bugInstanceFieldList) {
        this.bugInstanceFieldList = bugInstanceFieldList;
    }

    public List<FindBugsBugInstanceSourceLine> getBugInstanceSourceLineList() {
        return bugInstanceSourceLineList;
    }

    public void setBugInstanceSourceLineList(List<FindBugsBugInstanceSourceLine> bugInstanceSourceLineList) {
        this.bugInstanceSourceLineList = bugInstanceSourceLineList;
    }

    public List<FindBugsBugInstanceString> getBugInstanceStringList() {
        return bugInstanceStringList;
    }

    public void setBugInstanceStringList(List<FindBugsBugInstanceString> bugInstanceStringList) {
        this.bugInstanceStringList = bugInstanceStringList;
    }

    public List<FindBugsBugInstanceLocalVariable> getBugInstanceLocalVariableList() {
        return bugInstanceLocalVariableList;
    }

    public void setBugInstanceLocalVariableList(List<FindBugsBugInstanceLocalVariable> bugInstanceLocalVariableList) {
        this.bugInstanceLocalVariableList = bugInstanceLocalVariableList;
    }

    public List<FindBugsBugInstanceProperty> getBugInstancePropertyList() {
        return bugInstancePropertyList;
    }

    public void setBugInstancePropertyList(List<FindBugsBugInstanceProperty> bugInstancePropertyList) {
        this.bugInstancePropertyList = bugInstancePropertyList;
    }

    public List<FindBugsBugInstanceInt> getBugInstanceIntList() {
        return bugInstanceIntList;
    }

    public void setBugInstanceIntList(List<FindBugsBugInstanceInt> bugInstanceIntList) {
        this.bugInstanceIntList = bugInstanceIntList;
    }
}
