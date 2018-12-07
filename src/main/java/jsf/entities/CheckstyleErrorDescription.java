package jsf.entities;

import java.math.BigInteger;

public class CheckstyleErrorDescription {
    private BigInteger errorId;
    private byte classLine;
    private byte classColumn;
    private String errorMessage;
    private String errorSeverity;
    private String checkSource;
    private String fileName;

    public BigInteger getErrorId() {
        return errorId;
    }

    public void setErrorId(BigInteger errorId) {
        this.errorId = errorId;
    }

    public byte getClassLine() {
        return classLine;
    }

    public void setClassLine(byte classLine) {
        this.classLine = classLine;
    }

    public byte getClassColumn() {
        return classColumn;
    }

    public void setClassColumn(byte classColumn) {
        this.classColumn = classColumn;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorSeverity() {
        return errorSeverity;
    }

    public void setErrorSeverity(String errorSeverity) {
        this.errorSeverity = errorSeverity;
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
