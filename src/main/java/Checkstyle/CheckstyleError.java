package Checkstyle;

import javax.persistence.*;

@Entity
@Table
public class CheckstyleError {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, updatable = false, nullable = false)
    private Long id;
    @Column
    private int column;
    @Column
    private int line;
    @Column(nullable = false)
    private String message;
    @Column(nullable = false)
    private CheckstyleSeverity severity;
    @Column(nullable = false)
    private String checkSource;
    @Column(nullable = false)
    private String fileName;

    public CheckstyleError(int column, int line, String message, CheckstyleSeverity severity, String checkSource, String fileName) {
        this.column = column;
        this.line = line;
        this.message = message;
        this.severity = severity;
        this.checkSource = checkSource;
        this.fileName = fileName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public CheckstyleSeverity getSeverity() {
        return severity;
    }

    public void setSeverity(CheckstyleSeverity severity) {
        this.severity = severity;
    }

    public String getCheckSource() {
        return checkSource;
    }

    public void setCheckSource(String checkSource) {
        this.checkSource = checkSource;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
