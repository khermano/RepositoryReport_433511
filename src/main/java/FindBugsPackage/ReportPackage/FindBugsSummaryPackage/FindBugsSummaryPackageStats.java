package FindBugsPackage.ReportPackage.FindBugsSummaryPackage;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "PackageStats")
@XmlAccessorType(XmlAccessType.FIELD)
public class FindBugsSummaryPackageStats {

    @XmlAttribute(name = "package")
    private String findBugsPackage;

    @XmlAttribute(name = "total_bugs")
    private byte total_bugs;

    @XmlAttribute(name = "total_types")
    private byte total_types;

    @XmlAttribute(name = "total_size")
    private short total_size;

    @XmlAttribute(name = "priority_3")
    private byte priority_3;

    @XmlAttribute(name = "priority_2")
    private byte priority_2;

    @XmlAttribute(name = "priority_1")
    private byte priority_1;

    @XmlElement(name = "ClassStats")
    private List<FindBugsSummaryClassStats> classStatsList;

    public String getFindBugsPackage() {
        return findBugsPackage;
    }

    public void setFindBugsPackage(String findBugsPackage) {
        this.findBugsPackage = findBugsPackage;
    }

    public byte getTotal_bugs() {
        return total_bugs;
    }

    public void setTotal_bugs(byte total_bugs) {
        this.total_bugs = total_bugs;
    }

    public byte getTotal_types() {
        return total_types;
    }

    public void setTotal_types(byte total_types) {
        this.total_types = total_types;
    }

    public short getTotal_size() {
        return total_size;
    }

    public void setTotal_size(short total_size) {
        this.total_size = total_size;
    }

    public byte getPriority_3() {
        return priority_3;
    }

    public void setPriority_3(byte priority_3) {
        this.priority_3 = priority_3;
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

    public List<FindBugsSummaryClassStats> getClassStatsList() {
        return classStatsList;
    }

    public void setClassStatsList(List<FindBugsSummaryClassStats> classStatsList) {
        this.classStatsList = classStatsList;
    }
}
