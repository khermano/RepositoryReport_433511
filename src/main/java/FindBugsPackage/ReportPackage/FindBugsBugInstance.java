package FindBugsPackage.ReportPackage;

import FindBugsPackage.ReportPackage.BugInstancePackage.*;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "BugInstancePackage")
@XmlAccessorType(XmlAccessType.FIELD)
public class FindBugsBugInstance {

    @XmlAttribute(name = "type")
    private String type;

    @XmlAttribute(name = "priority")
    private byte priority;

    @XmlAttribute(name = "rank")
    private byte rank;

    @XmlAttribute(name = "abbrev")
    private String abbrev;

    @XmlAttribute(name = "category")
    private String category;

    @XmlElement(name = "Class")
    private FindBugsBugInstanceClass findBugsBugInstanceClass;

    @XmlElement(name = "Method")
    private FindBugsBugInstanceMethod findBugsBugInstanceMethod;

    @XmlElement(name = "Type")
    private FindBugsBugInstanceType findBugsBugInstanceType;

    @XmlElement(name = "Field")
    private FindBugsBugInstanceField findBugsBugInstanceField;

    @XmlElement(name = "SourceLine")
    private FindBugsBugInstanceSourceLine findBugsBugInstanceSourceLine;

    @XmlElement(name = "String")
    private FindBugsBugInstanceString findBugsBugInstanceString;

    @XmlElement(name = "LocalVariable")
    private FindBugsBugInstanceLocalVariable findBugsBugInstanceLocalVariable;

    @XmlElement(name = "Property")
    private FindBugsBugInstanceProperty findBugsBugInstanceProperty;

    @XmlElement(name = "Int")
    private FindBugsBugInstanceInt findBugsBugInstanceInt;

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

    public byte getRank() {
        return rank;
    }

    public void setRank(byte rank) {
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

    public FindBugsBugInstanceClass getFindBugsBugInstanceClass() {
        return findBugsBugInstanceClass;
    }

    public void setFindBugsBugInstanceClass(FindBugsBugInstanceClass findBugsBugInstanceClass) {
        this.findBugsBugInstanceClass = findBugsBugInstanceClass;
    }

    public FindBugsBugInstanceMethod getFindBugsBugInstanceMethod() {
        return findBugsBugInstanceMethod;
    }

    public void setFindBugsBugInstanceMethod(FindBugsBugInstanceMethod findBugsBugInstanceMethod) {
        this.findBugsBugInstanceMethod = findBugsBugInstanceMethod;
    }

    public FindBugsBugInstanceType getFindBugsBugInstanceType() {
        return findBugsBugInstanceType;
    }

    public void setFindBugsBugInstanceType(FindBugsBugInstanceType findBugsBugInstanceType) {
        this.findBugsBugInstanceType = findBugsBugInstanceType;
    }

    public FindBugsBugInstanceField getFindBugsBugInstanceField() {
        return findBugsBugInstanceField;
    }

    public void setFindBugsBugInstanceField(FindBugsBugInstanceField findBugsBugInstanceField) {
        this.findBugsBugInstanceField = findBugsBugInstanceField;
    }

    public FindBugsBugInstanceSourceLine getFindBugsBugInstanceSourceLine() {
        return findBugsBugInstanceSourceLine;
    }

    public void setFindBugsBugInstanceSourceLine(FindBugsBugInstanceSourceLine findBugsBugInstanceSourceLine) {
        this.findBugsBugInstanceSourceLine = findBugsBugInstanceSourceLine;
    }

    public FindBugsBugInstanceString getFindBugsBugInstanceString() {
        return findBugsBugInstanceString;
    }

    public void setFindBugsBugInstanceString(FindBugsBugInstanceString findBugsBugInstanceString) {
        this.findBugsBugInstanceString = findBugsBugInstanceString;
    }

    public FindBugsBugInstanceLocalVariable getFindBugsBugInstanceLocalVariable() {
        return findBugsBugInstanceLocalVariable;
    }

    public void setFindBugsBugInstanceLocalVariable(FindBugsBugInstanceLocalVariable findBugsBugInstanceLocalVariable) {
        this.findBugsBugInstanceLocalVariable = findBugsBugInstanceLocalVariable;
    }

    public FindBugsBugInstanceProperty getFindBugsBugInstanceProperty() {
        return findBugsBugInstanceProperty;
    }

    public void setFindBugsBugInstanceProperty(FindBugsBugInstanceProperty findBugsBugInstanceProperty) {
        this.findBugsBugInstanceProperty = findBugsBugInstanceProperty;
    }

    public FindBugsBugInstanceInt getFindBugsBugInstanceInt() {
        return findBugsBugInstanceInt;
    }

    public void setFindBugsBugInstanceInt(FindBugsBugInstanceInt findBugsBugInstanceInt) {
        this.findBugsBugInstanceInt = findBugsBugInstanceInt;
    }
}
