package Checkstyle;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@XmlRootElement(name = "checkstyle")
@XmlAccessorType(XmlAccessType.FIELD)
public class CheckstyleReport {

    @XmlAttribute(name = "version")
    private float version;

    @XmlElement(name = "file")
    private List<CheckstyleFile> fileList;

    public float getVersion() {
        return version;
    }

    public void setVersion(float version) {
        this.version = version;
    }

    public List<CheckstyleFile> getFileList() {
        return Collections.unmodifiableList(fileList);
    }

    public void setFileList(List<CheckstyleFile> fileList) {
        this.fileList = fileList;
    }

    public CheckstyleReport(float version, List<CheckstyleFile> fileList) {
        this.version = version;
        this.fileList = new ArrayList<CheckstyleFile>(fileList);
    }
}
