package Checkstyle;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@XmlRootElement(name = "checkstyle")
@XmlAccessorType(XmlAccessType.FIELD)
public class CheckstyleReport {

    @XmlElement(name = "file")
    private List<CheckstyleFile> fileList;

    public CheckstyleReport(List<CheckstyleFile> fileList) {
        this.fileList = new ArrayList<CheckstyleFile>(fileList);
    }

    public List<CheckstyleFile> getFileList() {
        return Collections.unmodifiableList(fileList);
    }

    public void setFileList(List<CheckstyleFile> fileList) {
        this.fileList = fileList;
    }
}
