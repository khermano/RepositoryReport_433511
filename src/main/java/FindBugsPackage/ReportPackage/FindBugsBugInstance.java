package FindBugsPackage.ReportPackage;

import FindBugsPackage.ReportPackage.BugInstancePackage.*;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.util.Collections;
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

    @Column(name = "bugInstanceType")
    @XmlAttribute(name = "type")
    private String type;

    @Column(name = "bugInstancePriority")
    @XmlAttribute(name = "priority")
    private byte priority;

    @Column(name = "bugInstanceRank")
    @XmlAttribute(name = "rank")
    private int rank;

    @Column(name = "bugInstanceAbbrev")
    @XmlAttribute(name = "abbrev")
    private String abbrev;

    @Column(name = "bugInstanceCategory")
    @XmlAttribute(name = "category")
    private String category;

    @JoinColumn(name = "bugInstanceId")
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @XmlElement(name = "Class")
    private FindBugsBugInstanceClass bugInstanceClass;

    @JoinColumn(name = "bugInstanceId")
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @XmlElement(name = "Method")
    private FindBugsBugInstanceMethod bugInstanceMethod;

    @JoinColumn(name = "bugInstanceId")
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @XmlElement(name = "Type")
    private FindBugsBugInstanceType bugInstanceType;

    @JoinColumn(name = "bugInstanceId")
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @XmlElement(name = "Field")
    private FindBugsBugInstanceField bugInstanceField;

    @JoinColumn(name = "bugInstanceId")
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @XmlElement(name = "SourceLine")
    private FindBugsBugInstanceSourceLine bugInstanceSourceLine;

    @JoinColumn(name = "bugInstanceId")
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @XmlElement(name = "String")
    private FindBugsBugInstanceString bugInstanceString;

    @JoinColumn(name = "bugInstanceId")
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @XmlElement(name = "LocalVariable")
    private FindBugsBugInstanceLocalVariable bugInstanceLocalVariable;

    @JoinColumn(name = "bugInstanceId")
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @XmlElement(name = "Property")
    private FindBugsBugInstanceProperty bugInstanceProperty;

    @JoinColumn(name = "bugInstanceId")
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @XmlElement(name = "Int")
    private FindBugsBugInstanceInt bugInstanceInt;

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

    public FindBugsBugInstanceClass getBugInstanceClass() {
        return bugInstanceClass;
    }

    public void setBugInstanceClass(FindBugsBugInstanceClass bugInstanceClass) {
        this.bugInstanceClass = bugInstanceClass;
    }

    public FindBugsBugInstanceMethod getBugInstanceMethod() {
        return bugInstanceMethod;
    }

    public void setBugInstanceMethod(FindBugsBugInstanceMethod bugInstanceMethod) {
        this.bugInstanceMethod = bugInstanceMethod;
    }

    public FindBugsBugInstanceType getBugInstanceType() {
        return bugInstanceType;
    }

    public void setBugInstanceType(FindBugsBugInstanceType bugInstanceType) {
        this.bugInstanceType = bugInstanceType;
    }

    public FindBugsBugInstanceField getBugInstanceField() {
        return bugInstanceField;
    }

    public void setBugInstanceField(FindBugsBugInstanceField bugInstanceField) {
        this.bugInstanceField = bugInstanceField;
    }

    public FindBugsBugInstanceSourceLine getBugInstanceSourceLine() {
        return bugInstanceSourceLine;
    }

    public void setBugInstanceSourceLine(FindBugsBugInstanceSourceLine bugInstanceSourceLine) {
        this.bugInstanceSourceLine = bugInstanceSourceLine;
    }

    public FindBugsBugInstanceString getBugInstanceString() {
        return bugInstanceString;
    }

    public void setBugInstanceString(FindBugsBugInstanceString bugInstanceString) {
        this.bugInstanceString = bugInstanceString;
    }

    public FindBugsBugInstanceLocalVariable getBugInstanceLocalVariable() {
        return bugInstanceLocalVariable;
    }

    public void setBugInstanceLocalVariable(FindBugsBugInstanceLocalVariable bugInstanceLocalVariable) {
        this.bugInstanceLocalVariable = bugInstanceLocalVariable;
    }

    public FindBugsBugInstanceProperty getBugInstanceProperty() {
        return bugInstanceProperty;
    }

    public void setBugInstanceProperty(FindBugsBugInstanceProperty bugInstanceProperty) {
        this.bugInstanceProperty = bugInstanceProperty;
    }

    public FindBugsBugInstanceInt getBugInstanceInt() {
        return bugInstanceInt;
    }

    public void setBugInstanceInt(FindBugsBugInstanceInt bugInstanceInt) {
        this.bugInstanceInt = bugInstanceInt;
    }
}
