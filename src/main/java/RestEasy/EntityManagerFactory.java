package RestEasy;

import Checkstyle.CheckstyleError;
import Checkstyle.CheckstyleFile;

import javax.ejb.Local;
import java.util.List;

@Local
public interface EntityManagerFactory {

    void addError(CheckstyleError error);

    void addFile(CheckstyleFile file);

    void addFiles(List<CheckstyleFile> files);

    CheckstyleError getError(Long id);

    CheckstyleFile getFile(Long id);

    List<ErrorDescription> loadUserDescriptions();

}
