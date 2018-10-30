package Checkstyle;

import java.util.ArrayList;
import java.util.List;

public class CheckstyleReport {
    private List<CheckstyleFile> fileList;

    public CheckstyleReport(List<CheckstyleFile> fileList) {
        this.fileList = new ArrayList<CheckstyleFile>(fileList);
    }

    public List<CheckstyleFile> getFileList() {
        return fileList;
    }

    public void setFileList(List<CheckstyleFile> fileList) {
        this.fileList = fileList;
    }
}
