package input.checkstyle;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "CHECKSTYLE_ERRORS")
@XmlRootElement(name= "error")
@XmlAccessorType(XmlAccessType.FIELD)
public class CheckstyleError {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, updatable = false, nullable = false)
    @XmlTransient
    private Long errorId;

    @Column(name = "classLine")
    @XmlAttribute()
    private byte line;

    @Column(name = "classColumn")
    @XmlAttribute()
    private byte column;

    @Column(name = "errorMessage")
    @XmlAttribute()
    private String message;

    @Column(name = "errorSeverity")
    @XmlAttribute()
    private String severity;

    @Column(name = "checkSource")
    @XmlAttribute()
    private String source;

    public Long getErrorId() {
        return errorId;
    }

    public void setErrorId(Long errorId) {
        this.errorId = errorId;
    }

    public byte getLine() {
        return line;
    }

    public void setLine(byte line) {
        this.line = line;
    }

    public byte getColumn() {
        return column;
    }

    public void setColumn(byte column) {
        this.column = column;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
