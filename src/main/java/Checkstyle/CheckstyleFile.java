package Checkstyle;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "file")
public class CheckstyleFile {

    @XmlAttribute(name = "name")
    private String fileName;
    @XmlElement(name = "error")
    private List<CheckstyleError> errorList;

    public  CheckstyleFile(String fileName, List<CheckstyleError> errorList) {
        this.fileName = fileName;
        this.errorList = new ArrayList<CheckstyleError>(errorList);
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public List<CheckstyleError> getErrorList() {
        return Collections.unmodifiableList(errorList);
    }

    public void setErrorList(List<CheckstyleError> errorList) {
        this.errorList = errorList;
    }
}
