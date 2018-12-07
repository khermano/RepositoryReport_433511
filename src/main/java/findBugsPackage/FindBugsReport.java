package findBugsPackage;

import findBugsPackage.reportPackage.FindBugsBugInstance;

import javax.xml.bind.annotation.*;
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