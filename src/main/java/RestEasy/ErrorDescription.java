package RestEasy;

public class ErrorDescription {
    private byte classLine;
    private byte classColumn;
    private String errorMessage;
    private String errorSeverity;
    private String checkSource;
    private String fileName;

    public ErrorDescription() {

    }

    public ErrorDescription(byte classLine, byte classColumn, String errorMessage, String errorSeverity, String checkSource, String fileName) {
        this.classLine = classLine;
        this.classColumn = classColumn;
        this.errorMessage = errorMessage;
        this.errorSeverity = errorSeverity;
        this.checkSource = checkSource;
        this.fileName = fileName;
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

    @Override
    public String toString() {
        return "Error: classLine: " + classLine + ", classColumn: " + classColumn + ", errorMessage: " + errorMessage +
                ", errorSeverity: " + errorSeverity + ", checkSource: " + checkSource + ", fileName: " + fileName;
    }
}
