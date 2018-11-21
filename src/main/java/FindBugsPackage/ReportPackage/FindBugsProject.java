package FindBugsPackage.ReportPackage;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "Project")
@XmlAccessorType(XmlAccessType.FIELD)
public class FindBugsProject {

    @XmlAttribute(name = "projectName")
    private String projectName;

    @XmlElement(name = "Jar")
    private List<String> jarList;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<String> getJarList() {
        return jarList;
    }

    public void setJarList(List<String> jarList) {
        this.jarList = jarList;
    }
}
