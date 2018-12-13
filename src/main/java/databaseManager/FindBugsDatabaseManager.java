package databaseManager;

import input.findbugs.report.FindBugsBugInstance;
import output.entities.*;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.Local;

@Local
public interface FindBugsDatabaseManager {

    void addBugInstances(List<FindBugsBugInstance> bugInstances);

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

    void cleanTables();
}
