package JSF.EntityManager;

import CheckstylePackage.CheckstyleError;
import CheckstylePackage.CheckstyleFile;
import FindBugsPackage.ReportPackage.BugInstancePackage.*;
import FindBugsPackage.ReportPackage.FindBugsBugInstance;
import JSF.CheckstyleErrorDescription;
import RestEasyPackage.BugInstanceDescription;

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

    List<CheckstyleErrorDescription> loadUserDescriptions();

    List<CheckstyleErrorDescription> loadUserDescriptionsFromJavadocMethodCheck();

    List<BugInstanceDescription> loadBugInstanceWithPriority1();

    List<BugInstanceDescription> loadBugInstanceWithRankScariest();

    List<BugInstanceDescription> loadBugInstanceWithCategoryCorrectness();

}
