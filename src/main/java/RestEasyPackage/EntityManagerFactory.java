package RestEasyPackage;

import CheckstylePackage.CheckstyleError;
import CheckstylePackage.CheckstyleFile;
import FindBugsPackage.FindBugsReport;
import FindBugsPackage.ReportPackage.BugInstancePackage.*;
import FindBugsPackage.ReportPackage.FindBugsBugInstance;
//import FindBugsPackage.ReportPackage.BugInstancePackage.FindBugsBugInstanceSourceLinePackage.SourceLine;
//import FindBugsPackage.ReportPackage.FindBugsSummary;

import javax.ejb.Local;
import java.util.List;

@Local
public interface EntityManagerFactory {

    void addError(CheckstyleError error);

    void addFile(CheckstyleFile file);

    void addFiles(List<CheckstyleFile> files);

    /*void addFindBugsSummary(FindBugsSummary findBugsSummary);

    void addFindBugsSourceLine(SourceLine sourceLine);*/

    //void addFindBugsReport(FindBugsReport report);

    void addBugInstance(FindBugsBugInstance bugInstance);

    void addBugInstances(List<FindBugsBugInstance> bugInstances);

    /*void addBugInstanceClass(FindBugsBugInstanceClass bugInstanceClass);

    void addBugInstanceMethod(FindBugsBugInstanceMethod bugInstanceMethod);

    void addBugInstanceType(FindBugsBugInstanceType bugInstanceType);

    void addBugInstanceField(FindBugsBugInstanceField bugInstanceField);*/

    void addBugInstanceSourceLine(FindBugsBugInstanceSourceLine bugInstanceSourceLine);

    /*void addBugInstanceString(FindBugsBugInstanceString bugInstanceString);

    void addBugInstanceLocalVariable(FindBugsBugInstanceLocalVariable bugInstanceLocalVariable);

    void addBugInstanceProperty(FindBugsBugInstanceProperty bugInstanceProperty);

    void addBugInstanceInt(FindBugsBugInstanceInt bugInstanceInt);*/

    CheckstyleError getError(Long id);

    CheckstyleFile getFile(Long id);

    List<ErrorDescription> loadUserDescriptions();

}
