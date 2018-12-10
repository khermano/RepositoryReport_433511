package input.findbugs;

import input.findbugs.report.FindBugsBugInstance;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@XmlRootElement(name = "BugCollection")
@XmlAccessorType(XmlAccessType.FIELD)
public class FindBugsReport {

    @XmlElement(name = "BugInstance")
    private List<FindBugsBugInstance> findBugsBugInstances;

    public List<FindBugsBugInstance> getFindBugsBugInstanceList() {
        return findBugsBugInstances;
    }

    public void setFindBugsBugInstanceList(List<FindBugsBugInstance> findBugsBugInstances) {
        this.findBugsBugInstances = findBugsBugInstances;
    }
}