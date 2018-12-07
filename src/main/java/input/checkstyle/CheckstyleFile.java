package input.checkstyle;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.util.List;

@Entity
@Table(name = "CHECKSTYLE_FILES")
@XmlRootElement(name = "file")
@XmlAccessorType(XmlAccessType.FIELD)
public class CheckstyleFile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, updatable = false, nullable = false)
    @XmlTransient
    private Long fileId;

    @Column
    @XmlAttribute(name = "name")
    private String fileName;

    @JoinColumn(name = "fileId", nullable = false)
    @OneToMany(cascade = CascadeType.ALL)
    @XmlElement(name = "error")
    private List<CheckstyleError> errorList;

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public List<CheckstyleError> getErrorList() {
        return errorList;
    }

    public void setErrorList(List<CheckstyleError> errorList) {
        this.errorList = errorList;
    }
}
