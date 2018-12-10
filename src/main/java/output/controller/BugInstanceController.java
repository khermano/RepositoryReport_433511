package output.controller;

import databaseManager.FindBugsDatabaseManager;
import output.entities.BugInstanceClassDescription;
import output.entities.BugInstanceDescription;
import output.entities.BugInstanceFieldDescription;
import output.entities.BugInstanceIntDescription;
import output.entities.BugInstanceLocalVariableDescription;
import output.entities.BugInstanceMethodDescription;
import output.entities.BugInstancePropertyDescripiton;
import output.entities.BugInstanceSourceLineDescription;
import output.entities.BugInstanceStringDescription;
import output.entities.BugInstanceTypeDescription;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "bugInstanceController")
@SessionScoped
public class BugInstanceController {

    @EJB
    private FindBugsDatabaseManager findBugsDatabaseManager;
    private BugInstanceDescription bugInstanceDescription = new BugInstanceDescription();
    private BugInstanceClassDescription bugInstanceClassDescription;
    private BugInstanceFieldDescription bugInstanceFieldDescription;
    private BugInstanceIntDescription bugInstanceIntDescription;
    private BugInstanceLocalVariableDescription bugInstanceLocalVariableDescription;
    private BugInstanceMethodDescription bugInstanceMethodDescription;
    private BugInstancePropertyDescripiton bugInstancePropertyDescription;
    private BugInstanceSourceLineDescription bugInstanceSourceLineDescription;
    private BugInstanceStringDescription bugInstanceStringDescription;
    private BugInstanceTypeDescription bugInstanceTypeDescription;
    private List<BugInstanceDescription> bugInstanceDescriptionList;
    public static final String FINDBUGS_ERRORS_XHTML = "findbugs_errors";
    public static final String ALL_FINDBUGS_ERRORS_QUERY = "SELECT bugInstanceId, type, priority, rank, abbrev, category FROM BUG_INSTANCE";

    public BugInstanceDescription getBugInstanceDescription() {
        return bugInstanceDescription;
    }

    public void setBugInstanceDescription(BugInstanceDescription bugInstanceDescription) {
        this.bugInstanceDescription = bugInstanceDescription;
    }

    public BugInstanceClassDescription getBugInstanceClassDescription() {
        return bugInstanceClassDescription;
    }

    public void setBugInstanceClassDescription(BugInstanceClassDescription bugInstanceClassDescription) {
        this.bugInstanceClassDescription = bugInstanceClassDescription;
    }

    public BugInstanceFieldDescription getBugInstanceFieldDescription() {
        return bugInstanceFieldDescription;
    }

    public void setBugInstanceFieldDescription(BugInstanceFieldDescription bugInstanceFieldDescription) {
        this.bugInstanceFieldDescription = bugInstanceFieldDescription;
    }

    public BugInstanceIntDescription getBugInstanceIntDescription() {
        return bugInstanceIntDescription;
    }

    public void setBugInstanceIntDescription(BugInstanceIntDescription bugInstanceIntDescription) {
        this.bugInstanceIntDescription = bugInstanceIntDescription;
    }

    public BugInstanceLocalVariableDescription getBugInstanceLocalVariableDescription() {
        return bugInstanceLocalVariableDescription;
    }

    public void setBugInstanceLocalVariableDescription(BugInstanceLocalVariableDescription bugInstanceLocalVariableDescription) {
        this.bugInstanceLocalVariableDescription = bugInstanceLocalVariableDescription;
    }

    public BugInstanceMethodDescription getBugInstanceMethodDescription() {
        return bugInstanceMethodDescription;
    }

    public void setBugInstanceMethodDescription(BugInstanceMethodDescription bugInstanceMethodDescription) {
        this.bugInstanceMethodDescription = bugInstanceMethodDescription;
    }

    public BugInstancePropertyDescripiton getBugInstancePropertyDescription() {
        return bugInstancePropertyDescription;
    }

    public void setBugInstancePropertyDescription(BugInstancePropertyDescripiton bugInstancePropertyDescription) {
        this.bugInstancePropertyDescription = bugInstancePropertyDescription;
    }

    public BugInstanceSourceLineDescription getBugInstanceSourceLineDescription() {
        return bugInstanceSourceLineDescription;
    }

    public void setBugInstanceSourceLineDescription(BugInstanceSourceLineDescription bugInstanceSourceLineDescription) {
        this.bugInstanceSourceLineDescription = bugInstanceSourceLineDescription;
    }

    public BugInstanceStringDescription getBugInstanceStringDescription() {
        return bugInstanceStringDescription;
    }

    public void setBugInstanceStringDescription(BugInstanceStringDescription bugInstanceStringDescription) {
        this.bugInstanceStringDescription = bugInstanceStringDescription;
    }

    public BugInstanceTypeDescription getBugInstanceTypeDescription() {
        return bugInstanceTypeDescription;
    }

    public void setBugInstanceTypeDescription(BugInstanceTypeDescription bugInstanceTypeDescription) {
        this.bugInstanceTypeDescription = bugInstanceTypeDescription;
    }

    public List<BugInstanceDescription> getBugInstanceDescriptionList() {
        return bugInstanceDescriptionList;
    }

    public void setBugInstanceDescriptionList(List<BugInstanceDescription> bugInstanceDescriptionList) {
        this.bugInstanceDescriptionList = bugInstanceDescriptionList;
    }

    public String findAllFindBugsErrors() {
        bugInstanceDescriptionList = new ArrayList<>(
                findBugsDatabaseManager.loadBugInstances(
                        ALL_FINDBUGS_ERRORS_QUERY));
        return FINDBUGS_ERRORS_XHTML;
    }

    public String findPriority1FindBugsErrors() {
        bugInstanceDescriptionList = new ArrayList<>(
                findBugsDatabaseManager.loadBugInstances(
                        ALL_FINDBUGS_ERRORS_QUERY + " WHERE priority = '1'"));
        return FINDBUGS_ERRORS_XHTML;
    }

    public String findPriority2FindBugsErrors() {
        bugInstanceDescriptionList = new ArrayList<>(
                findBugsDatabaseManager.loadBugInstances(
                        ALL_FINDBUGS_ERRORS_QUERY + " WHERE priority = '2'"));
        return FINDBUGS_ERRORS_XHTML;
    }

    public String findPriority3FindBugsErrors() {
        bugInstanceDescriptionList = new ArrayList<>(
                findBugsDatabaseManager.loadBugInstances(
                        ALL_FINDBUGS_ERRORS_QUERY + " WHERE priority = '3'"));
        return FINDBUGS_ERRORS_XHTML;
    }

    public String findRankScariestFindBugsErrors() {
        bugInstanceDescriptionList = new ArrayList<>(
                findBugsDatabaseManager.loadBugInstances(
                        ALL_FINDBUGS_ERRORS_QUERY + " WHERE rank BETWEEN '1' AND '4'"));
        return FINDBUGS_ERRORS_XHTML;
    }

    public String findRankScaryFindBugsErrors() {
        bugInstanceDescriptionList = new ArrayList<>(
                findBugsDatabaseManager.loadBugInstances(
                        ALL_FINDBUGS_ERRORS_QUERY + " WHERE rank BETWEEN '5' AND '9'"));
        return FINDBUGS_ERRORS_XHTML;
    }

    public String findRankTroublingFindBugsErrors() {
        bugInstanceDescriptionList = new ArrayList<>(
                findBugsDatabaseManager.loadBugInstances(
                        ALL_FINDBUGS_ERRORS_QUERY + " WHERE rank BETWEEN '10' AND '14'"));
        return FINDBUGS_ERRORS_XHTML;
    }

    public String findRankConcernBugsFindBugsErrors() {
        bugInstanceDescriptionList = new ArrayList<>(
                findBugsDatabaseManager.loadBugInstances(
                        ALL_FINDBUGS_ERRORS_QUERY + " WHERE rank BETWEEN '15' AND '20'"));
        return FINDBUGS_ERRORS_XHTML;
    }

    public String findCategoryCorrectnessFindBugsErrors() {
        bugInstanceDescriptionList = new ArrayList<>(
                findBugsDatabaseManager.loadBugInstances(
                        ALL_FINDBUGS_ERRORS_QUERY + " WHERE category = 'CORRECTNESS'"));
        return FINDBUGS_ERRORS_XHTML;
    }

    public String findCategoryBadPracticeFindBugsErrors() {
        bugInstanceDescriptionList = new ArrayList<>(
                findBugsDatabaseManager.loadBugInstances(
                        ALL_FINDBUGS_ERRORS_QUERY + " WHERE category = 'BAD_PRACTICE'"));
        return FINDBUGS_ERRORS_XHTML;
    }

    public String findCategoryStyleFindBugsErrors() {
        bugInstanceDescriptionList = new ArrayList<>(
                findBugsDatabaseManager.loadBugInstances(
                        ALL_FINDBUGS_ERRORS_QUERY + " WHERE category = 'STYLE'"));
        return FINDBUGS_ERRORS_XHTML;
    }

    public String findCategoryMtCorrectnessFindBugsErrors() {
        bugInstanceDescriptionList = new ArrayList<>(
                findBugsDatabaseManager.loadBugInstances(
                        ALL_FINDBUGS_ERRORS_QUERY + " WHERE category = 'MT_CORRECTNESS'"));
        return FINDBUGS_ERRORS_XHTML;
    }

    public String findCategoryMaliciousCodeFindBugsErrors() {
        bugInstanceDescriptionList = new ArrayList<>(
                findBugsDatabaseManager.loadBugInstances(
                        ALL_FINDBUGS_ERRORS_QUERY + " WHERE category = 'MALICIOUS_CODE'"));
        return FINDBUGS_ERRORS_XHTML;
    }

    public String findCategoryPerformanceFindBugsErrors() {
        bugInstanceDescriptionList = new ArrayList<>(
                findBugsDatabaseManager.loadBugInstances(
                        ALL_FINDBUGS_ERRORS_QUERY + " WHERE category = 'PERFORMANCE'"));
        return FINDBUGS_ERRORS_XHTML;
    }

    public String findCategoryI18NFindBugsErrors() {
        bugInstanceDescriptionList = new ArrayList<>(
                findBugsDatabaseManager.loadBugInstances(
                        ALL_FINDBUGS_ERRORS_QUERY + " WHERE category = 'I18N'"));
        return FINDBUGS_ERRORS_XHTML;
    }

    public String detail(BugInstanceDescription bugInstanceDescription) {
        this.bugInstanceDescription = bugInstanceDescription;
        BigInteger bugInstanceId = bugInstanceDescription.getBugInstanceId();

        bugInstanceClassDescription = findBugsDatabaseManager.loadBugInstanceClassDescription(bugInstanceId);
        if (bugInstanceClassDescription!=null) {
            bugInstanceClassDescription.setClassSourceLine(
                    findBugsDatabaseManager.loadBugInstanceClassSourceLineDescription(bugInstanceId));
        }

        bugInstanceFieldDescription = findBugsDatabaseManager.loadBugInstanceFieldDescription(bugInstanceId);
        if (bugInstanceFieldDescription!=null){
            bugInstanceFieldDescription.setFieldSourceLine(
                    findBugsDatabaseManager.loadBugInstanceFieldSourceLineDescription(bugInstanceId));
        }

        bugInstanceIntDescription = findBugsDatabaseManager.loadBugInstanceIntDescription(bugInstanceId);

        bugInstanceLocalVariableDescription = findBugsDatabaseManager.loadBugInstanceLocalVariableDescription(bugInstanceId);

        bugInstanceMethodDescription = findBugsDatabaseManager.loadBugInstanceMethodDescription(bugInstanceId);
        if (bugInstanceMethodDescription!=null) {
            bugInstanceMethodDescription.setMethodSourceLine(
                    findBugsDatabaseManager.loadBugInstanceMethodSourceLineDescription(bugInstanceId));
        }

        bugInstancePropertyDescription = findBugsDatabaseManager.loadBugInstancePropertyDescription(bugInstanceId);

        bugInstanceSourceLineDescription = findBugsDatabaseManager.loadBugInstanceSourceLineDescription(bugInstanceId);

        bugInstanceStringDescription = findBugsDatabaseManager.loadBugInstanceStringDescription(bugInstanceId);

        bugInstanceTypeDescription = findBugsDatabaseManager.loadBugInstanceTypeDescription(bugInstanceId);
        if (bugInstanceTypeDescription!=null) {
            bugInstanceTypeDescription.setTypeSourceLine(
                    findBugsDatabaseManager.loadBugInstanceTypeSourceLineDescription(bugInstanceId));
        }

        return "detail";
    }
}
