package FindBugsPackage.ReportPackage.FindBugsSummaryPackage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ClassStats")
@XmlAccessorType(XmlAccessType.FIELD)
public class FindBugsSummaryClassStats {

    @XmlAttribute(name = "class")
    private String findBugsClass;

    @XmlAttribute(name = "sourceFile")
    private String sourceFile;

    @XmlAttribute(name = "interface")
    private String findBugsInterface;

    @XmlAttribute(name = "size")
    private short size;

    @XmlAttribute(name = "bugs")
    private byte bugs;

    @XmlAttribute(name = "priority_2")
    private byte priority_2;

    @XmlAttribute(name = "priority_1")
    private byte priority_1;

    @XmlAttribute(name = "priority_3")
    private byte priority_3;

    public String getFindBugsClass() {
        return findBugsClass;
    }

    public void setFindBugsClass(String findBugsClass) {
        this.findBugsClass = findBugsClass;
    }

    public String getSourceFile() {
        return sourceFile;
    }

    public void setSourceFile(String sourceFile) {
        this.sourceFile = sourceFile;
    }

    public String getFindBugsInterface() {
        return findBugsInterface;
    }

    public void setFindBugsInterface(String findBugsInterface) {
        this.findBugsInterface = findBugsInterface;
    }

    public short getSize() {
        return size;
    }

    public void setSize(short size) {
        this.size = size;
    }

    public byte getBugs() {
        return bugs;
    }

    public void setBugs(byte bugs) {
        this.bugs = bugs;
    }

    public byte getPriority_2() {
        return priority_2;
    }

    public void setPriority_2(byte priority_2) {
        this.priority_2 = priority_2;
    }

    public byte getPriority_1() {
        return priority_1;
    }

    public void setPriority_1(byte priority_1) {
        this.priority_1 = priority_1;
    }

    public byte getPriority_3() {
        return priority_3;
    }

    public void setPriority_3(byte priority_3) {
        this.priority_3 = priority_3;
    }
}
