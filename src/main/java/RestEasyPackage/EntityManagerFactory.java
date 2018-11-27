package RestEasyPackage;

import CheckstylePackage.CheckstyleError;
import CheckstylePackage.CheckstyleFile;
import FindBugsPackage.ReportPackage.BugInstancePackage.*;
import FindBugsPackage.ReportPackage.FindBugsBugInstance;

import javax.ejb.Local;
import java.util.List;

@Local
public interface EntityManagerFactory {

    void addError(CheckstyleError error);

    void addFile(CheckstyleFile file);

    void addFiles(List<CheckstyleFile> files);

    void addBugInstance(FindBugsBugInstance bugInstance);

    void addBugInstances(List<FindBugsBugInstance> bugInstances);

    void addBugInstanceSourceLine(FindBugsBugInstanceSourceLine bugInstanceSourceLine);

    CheckstyleError getError(Long id);

    CheckstyleFile getFile(Long id);

    List<ErrorDescription> loadUserDescriptions();

}
