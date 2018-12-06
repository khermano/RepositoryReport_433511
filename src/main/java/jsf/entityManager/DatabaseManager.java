package jsf.entityManager;

import checkstylePackage.CheckstyleError;
import checkstylePackage.CheckstyleFile;
import findBugsPackage.reportPackage.bugInstancePackage.*;
import findBugsPackage.reportPackage.FindBugsBugInstance;
import jsf.entities.*;

import javax.ejb.Local;
import java.math.BigInteger;
import java.util.List;

@Local
public interface DatabaseManager {

    void addError(CheckstyleError error);

    void addFile(CheckstyleFile file);

    void addFiles(List<CheckstyleFile> files);

    void addBugInstance(FindBugsBugInstance bugInstance);

    void addBugInstances(List<FindBugsBugInstance> bugInstances);

    //void addBugInstanceSourceLine(FindBugsBugInstanceSourceLine bugInstanceSourceLine);

    CheckstyleError getError(Long id);

    CheckstyleFile getFile(Long id);

    List<CheckstyleErrorDescription> loadCheckstyleErrorDescriptions();

    List<CheckstyleErrorDescription> loadCheckstyleLocalVariableNameErrors();

    List<CheckstyleErrorDescription> loadCheckstyleMemberNameErrors();

    List<CheckstyleErrorDescription> loadCheckstyleAbstractClassNameErrors();

    List<CheckstyleErrorDescription> loadCheckstyleConstantNameErrors();

    List<CheckstyleErrorDescription> loadCheckstyleStaticVariableNameErrors();

    List<CheckstyleErrorDescription> loadCheckstyleJavadocTypeErrors();

    List<CheckstyleErrorDescription> loadCheckstyleJavadocVariableErrors();

    List<CheckstyleErrorDescription> loadCheckstyleEmptyLineSeparatorErrors();

    List<CheckstyleErrorDescription> loadCheckstyleMethodParamPadErrors();

    List<CheckstyleErrorDescription> loadCheckstyleNoLineWrapErrors();

    List<CheckstyleErrorDescription> loadCheckstyleSingleSpaceSeparatorErrors();

    List<CheckstyleErrorDescription> loadCheckstyleGenericWhitespaceErrors();

    List<CheckstyleErrorDescription> loadCheckstyleOperatorWrapErrors();

    List<CheckstyleErrorDescription> loadCheckstyleWhitespaceAroundErrors();

    List<CheckstyleErrorDescription> loadCheckstyleJavadocMethodErrors();

    List<BugInstanceDescription> loadBugInstances();

    List<BugInstanceDescription> loadBugInstanceWithPriority1();

    List<BugInstanceDescription> loadBugInstanceWithRankScariest();

    List<BugInstanceDescription> loadBugInstanceWithCategoryCorrectness();

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
