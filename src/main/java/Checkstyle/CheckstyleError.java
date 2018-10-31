package Checkstyle;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class CheckstyleError {

    @Id
    private String id;
    private int column;
    private int line;
    private String message;
    private CheckstyleSeverity severity;
    private String checkSource;

    public CheckstyleError(int column, int line, String message, CheckstyleSeverity severity, String checkSource) {
        id = UUID.randomUUID().toString();
        this.column = column;
        this.line = line;
        this.message = message;
        this.severity = severity;
        this.checkSource = checkSource;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
}
