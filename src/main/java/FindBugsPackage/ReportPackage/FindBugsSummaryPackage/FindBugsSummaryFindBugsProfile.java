package FindBugsPackage.ReportPackage.FindBugsSummaryPackage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "FindBugsProfile")
@XmlAccessorType(XmlAccessType.FIELD)
public class FindBugsSummaryFindBugsProfile {

    @XmlElement(name = "ClassProfile")
    private List<FindBugsSummaryClassProfile> classProfileList;

    public List<FindBugsSummaryClassProfile> getClassProfileList() {
        return classProfileList;
    }

    public void setClassProfileList(List<FindBugsSummaryClassProfile> classProfileList) {
        this.classProfileList = classProfileList;
    }
}
