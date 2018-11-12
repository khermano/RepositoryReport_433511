package Checkstyle;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

@Entity
@Table
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "error")
public class CheckstyleError {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, updatable = false, nullable = false)
    private Long id;

    @Column(name = "classColumn")
    @XmlAttribute()
    private byte column;

    @Column(name = "classLine")
    @XmlAttribute()
    private byte line;

    @Column(name = "errorMessage", nullable = false)
    @XmlAttribute()
    private String message;

    @Column(name = "errorSeverity", nullable = false)
    @XmlAttribute()
    private String severity;

    @Column(nullable = false)
    @XmlAttribute(name = "source")
    private String checkSource;

    /*@Column(nullable = false)
    private String fileName;*/

    public CheckstyleError(byte column, byte line, String message, String severity, String checkSource/*, String fileName*/) {
        this.column = column;
        this.line = line;
        this.message = message;
        this.severity = severity;
        this.checkSource = checkSource;
        //this.fileName = fileName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte getColumn() {
        return column;
    }

    public void setColumn(byte column) {
        this.column = column;
    }

    public byte getLine() {
        return line;
    }

    public void setLine(byte line) {
        this.line = line;
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

    public String getCheckSource() {
        return checkSource;
    }

    public void setCheckSource(String checkSource) {
        this.checkSource = checkSource;
    }

    /*public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }*/

    @Override
    public String toString() {
        return "Error id: " + id + ", classColumn: " + column + ", classLine: " + line + ", errorMessage: " + message +
                ", errorSeverity: " + severity + ", checkSource: " + checkSource /*+ ", fileName: " + fileName*/;
    }
}
