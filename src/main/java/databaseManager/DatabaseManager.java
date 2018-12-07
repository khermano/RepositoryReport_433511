package databaseManager;

import input.checkstyle.CheckstyleFile;
import input.findbugs.report.FindBugsBugInstance;
import output.entities.*;

import javax.ejb.Local;
import java.math.BigInteger;
import java.util.List;

@Local
public interface DatabaseManager {

    void addFiles(List<CheckstyleFile> files);

    void addBugInstances(List<FindBugsBugInstance> bugInstances);

    List<CheckstyleErrorDescription> loadCheckstyleErrorDescriptions(String queryString);

    List<BugInstanceDescription> loadBugInstances(String queryString);

    BugInstanceClassDescription loadBugInstanceClassDescription(BigInteger id);

    BugInstanceSourceLineDescription loadBugInstanceClassSourceLineDescription(BigInteger id);

    BugInstanceFieldDescription loadBugInstanceFieldDescription(BigInteger id);

    BugInstanceSourceLineDescription loadBugInstanceFieldSourceLineDescription(BigInteger id);

    BugInstanceIntDescription loadBugInstanceIntDescription(BigInteger id);

    BugInstanceLocalVariableDescription loadBugInstanceLocalVariableDescription(BigInteger id);

    BugInstanceMethodDescription loadBugInstanceMethodDescription(BigInteger id);

    BugInstanceSourceLineDescription loadBugInstanceMethodSourceLineDescription(BigInteger id);

    BugInstancePropertyDescripiton loadBugInstancePropertyDescription(BigInteger id);

    BugInstanceSourceLineDescription loadBugInstanceSourceLineDescription(BigInteger id);

    BugInstanceStringDescription loadBugInstanceStringDescription(BigInteger id);

    BugInstanceTypeDescription loadBugInstanceTypeDescription(BigInteger id);

    BugInstanceSourceLineDescription loadBugInstanceTypeSourceLineDescription(BigInteger id);

}
