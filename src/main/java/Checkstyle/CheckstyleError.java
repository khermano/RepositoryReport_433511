package Checkstyle;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

@Entity
@Table(name = "CHECKSTYLE_ERRORS")
@XmlRootElement(name= "error")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"line", "column", "message", "severity", "source"})
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

    @ManyToOne(cascade = CascadeType.ALL)
    @XmlTransient
    private CheckstyleFile checkstyleFile;

    public CheckstyleError(byte column, byte line, String message, String severity, String source) {
        this.line = line;
        this.column = column;
        this.message = message;
        this.severity = severity;
        this.source = source;
    }

    public CheckstyleError() {

    }

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

    @Override
    public String toString() {
        return "Error errorId: " + errorId + ", classLine: " + line + ", classColumn: " + column + ", errorMessage: " + message +
                ", errorSeverity: " + severity + ", checkSource: " + source;
    }
}
