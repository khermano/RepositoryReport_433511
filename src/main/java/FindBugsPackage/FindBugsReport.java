package FindBugsPackage;

import FindBugsPackage.ReportPackage.FindBugsBugInstance;
import FindBugsPackage.ReportPackage.FindBugsErrors;
import FindBugsPackage.ReportPackage.FindBugsProject;
import FindBugsPackage.ReportPackage.FindBugsSummary;

import javax.xml.bind.annotation.*;
import java.util.Collections;
import java.util.List;

@XmlRootElement(name = "BugCollection")
@XmlAccessorType(XmlAccessType.FIELD)
public class FindBugsReport {

    @XmlAttribute(name = "version")
    private String version;

    @XmlAttribute(name = "sequence")
    private byte sequence;

    @XmlAttribute(name = "timestamp")
    private Long timeStamp;

    @XmlAttribute(name = "analysisTimestamp")
    private Long analysisTimeStamp;

    @XmlAttribute(name = "release")
    private String release;

    @XmlElement(name = "Project")
    private FindBugsProject project;

    @XmlElement(name = "BugInstancePackage")
    private List<FindBugsBugInstance> findBugsBugInstanceList;

    @XmlElement(name = "ErrorsPackage")
    private FindBugsErrors findBugsErrors;

    @XmlElement(name = "FindBugsSummaryPackage")
    private FindBugsSummary findBugsSummary;

    @XmlElement(name = "ClassFeatures")
    private String classFeatures;

    @XmlElement(name = "History")
    private String history;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public byte getSequence() {
        return sequence;
    }

    public void setSequence(byte sequence) {
        this.sequence = sequence;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Long getAnalysisTimeStamp() {
        return analysisTimeStamp;
    }

    public void setAnalysisTimeStamp(Long analysisTimeStamp) {
        this.analysisTimeStamp = analysisTimeStamp;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public FindBugsProject getProject() {
        return project;
    }

    public void setProject(FindBugsProject project) {
        this.project = project;
    }

    public List<FindBugsBugInstance> getFindBugsBugInstanceList() {
        return Collections.unmodifiableList(findBugsBugInstanceList);
    }

    public void setFindBugsBugInstanceList(List<FindBugsBugInstance> findBugsBugInstanceList) {
        this.findBugsBugInstanceList = findBugsBugInstanceList;
    }

    public FindBugsErrors getFindBugsErrors() {
        return findBugsErrors;
    }

    public void setFindBugsErrors(FindBugsErrors findBugsErrors) {
        this.findBugsErrors = findBugsErrors;
    }

    public FindBugsSummary getFindBugsSummary() {
        return findBugsSummary;
    }

    public void setFindBugsSummary(FindBugsSummary findBugsSummary) {
        this.findBugsSummary = findBugsSummary;
    }

    public String getClassFeatures() {
        return classFeatures;
    }

    public void setClassFeatures(String classFeatures) {
        this.classFeatures = classFeatures;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }
}
