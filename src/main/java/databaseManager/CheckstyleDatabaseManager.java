package databaseManager;

import input.checkstyle.CheckstyleFile;
import output.entities.CheckstyleErrorDescription;
import javax.ejb.Local;

import java.util.List;

@Local
public interface CheckstyleDatabaseManager {

    void addFiles(List<CheckstyleFile> files);

    List<CheckstyleErrorDescription> loadCheckstyleErrorDescriptions(String queryString);

    void cleanTables();
}
