package FindBugsPackage.ReportPackage;

import FindBugsPackage.ReportPackage.FindBugsSummaryPackage.FindBugsSummaryFindBugsProfile;
import FindBugsPackage.ReportPackage.FindBugsSummaryPackage.FindBugsSummaryPackageStats;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "FindBugsSummaryPackage")
@XmlAccessorType(XmlAccessType.FIELD)
public class FindBugsSummary {

    @XmlAttribute(name = "timestamp")
    private String timestamp;

    @XmlAttribute(name = "total_classes")
    private short total_classes;

    @XmlAttribute(name = "referenced_classes")
    private short referenced_classes;

    @XmlAttribute(name = "total_bugs")
    private short total_bugs;

    @XmlAttribute(name = "total_size")
    private int total_size;

    @XmlAttribute(name = "num_packages")
    private byte num_packages;

    @XmlAttribute(name = "java_version")
    private String java_version;

    @XmlAttribute(name = "vm_version")
    private String vm_version;

    @XmlAttribute(name = "cpu_seconds")
    private float cpu_seconds;

    @XmlAttribute(name = "clock_seconds")
    private float clock_seconds;

    @XmlAttribute(name = "peak_mbytes")
    private float peak_mbytes;

    @XmlAttribute(name = "alloc_mbytes")
    private float alloc_mbytes;

    @XmlAttribute(name = "gc_seconds")
    private float gc_seconds;

    @XmlAttribute(name = "priority_3")
    private short priority_3;

    @XmlAttribute(name = "priority_2")
    private short priority_2;

    @XmlAttribute(name = "priority_1")
    private byte priority_1;

    @XmlElement(name = "PackageStats")
    private List<FindBugsSummaryPackageStats> packageStats;

    @XmlElement(name = "FindBugsProfile")
    private FindBugsSummaryFindBugsProfile findBugsProfile;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public short getTotal_classes() {
        return total_classes;
    }

    public void setTotal_classes(short total_classes) {
        this.total_classes = total_classes;
    }

    public short getReferenced_classes() {
        return referenced_classes;
    }

    public void setReferenced_classes(short referenced_classes) {
        this.referenced_classes = referenced_classes;
    }

    public short getTotal_bugs() {
        return total_bugs;
    }

    public void setTotal_bugs(short total_bugs) {
        this.total_bugs = total_bugs;
    }

    public int getTotal_size() {
        return total_size;
    }

    public void setTotal_size(int total_size) {
        this.total_size = total_size;
    }

    public byte getNum_packages() {
        return num_packages;
    }

    public void setNum_packages(byte num_packages) {
        this.num_packages = num_packages;
    }

    public String getJava_version() {
        return java_version;
    }

    public void setJava_version(String java_version) {
        this.java_version = java_version;
    }

    public String getVm_version() {
        return vm_version;
    }

    public void setVm_version(String vm_version) {
        this.vm_version = vm_version;
    }

    public float getCpu_seconds() {
        return cpu_seconds;
    }

    public void setCpu_seconds(float cpu_seconds) {
        this.cpu_seconds = cpu_seconds;
    }

    public float getClock_seconds() {
        return clock_seconds;
    }

    public void setClock_seconds(float clock_seconds) {
        this.clock_seconds = clock_seconds;
    }

    public float getPeak_mbytes() {
        return peak_mbytes;
    }

    public void setPeak_mbytes(float peak_mbytes) {
        this.peak_mbytes = peak_mbytes;
    }

    public float getAlloc_mbytes() {
        return alloc_mbytes;
    }

    public void setAlloc_mbytes(float alloc_mbytes) {
        this.alloc_mbytes = alloc_mbytes;
    }

    public float getGc_seconds() {
        return gc_seconds;
    }

    public void setGc_seconds(float gc_seconds) {
        this.gc_seconds = gc_seconds;
    }

    public short getPriority_3() {
        return priority_3;
    }

    public void setPriority_3(short priority_3) {
        this.priority_3 = priority_3;
    }

    public short getPriority_2() {
        return priority_2;
    }

    public void setPriority_2(short priority_2) {
        this.priority_2 = priority_2;
    }

    public byte getPriority_1() {
        return priority_1;
    }

    public void setPriority_1(byte priority_1) {
        this.priority_1 = priority_1;
    }

    public List<FindBugsSummaryPackageStats> getPackageStats() {
        return packageStats;
    }

    public void setPackageStats(List<FindBugsSummaryPackageStats> packageStats) {
        this.packageStats = packageStats;
    }

    public FindBugsSummaryFindBugsProfile getFindBugsProfile() {
        return findBugsProfile;
    }

    public void setFindBugsProfile(FindBugsSummaryFindBugsProfile findBugsProfile) {
        this.findBugsProfile = findBugsProfile;
    }
}
