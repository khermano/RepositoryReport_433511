package Checkstyle;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.util.Collections;
import java.util.List;

//@Entity(name = "ent")
@XmlRootElement(name = "file")
@XmlAccessorType(XmlAccessType.FIELD) //@XmlType(name = "file")
public class CheckstyleFile {

    @XmlAttribute(name = "name")
    private String fileName;

    //@OneToMany(mappedBy = "file", cascade = CascadeType.ALL)
    @XmlElement(name = "error")
    private List<CheckstyleError> errorList;

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
