package Checkstyle;

import java.util.ArrayList;
import java.util.List;

public class CheckstyleFile {
    private String fileName;
    private List<CheckstyleError> errorList;

    public  CheckstyleFile(String fileName, List<CheckstyleError> errorList) {
        this.fileName = fileName;
        this.errorList = new ArrayList<>(errorList);
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
