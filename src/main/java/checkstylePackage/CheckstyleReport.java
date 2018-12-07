package checkstylePackage;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "checkstyle")
@XmlAccessorType(XmlAccessType.FIELD)
public class CheckstyleReport {

    @XmlElement(name = "file")
    private List<CheckstyleFile> fileList;

    public List<CheckstyleFile> getFileList() {
        return fileList;
    }

    public void setFileList(List<CheckstyleFile> fileList) {
        this.fileList = fileList;
    }
}
