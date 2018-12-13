package databaseManager;

import input.checkstyle.CheckstyleFile;
import output.entities.CheckstyleErrorDescription;
import java.util.List;

public interface CheckstyleDatabaseManager {

    void addFiles(List<CheckstyleFile> files);

    List<CheckstyleErrorDescription> loadCheckstyleErrorDescriptions(String queryString);

    void cleanTables();
}
