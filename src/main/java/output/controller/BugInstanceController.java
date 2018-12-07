package output.controller;

import output.entities.*;
import databaseManager.DatabaseManager;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

import static databaseManager.DatabaseManagerImpl.*;

@ManagedBean(name = "bugInstanceController")
@SessionScoped
public class BugInstanceController {

    @EJB
    private DatabaseManager databaseManager;
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

    public String returnAllErrors() {
        bugInstanceDescriptionList = new ArrayList<BugInstanceDescription>(databaseManager.loadBugInstances(ALL_FINDBUGS_ERRORS_QUERY));
        return "findbugs_errors";
    }

    public String returnPriority1Errors() {
        bugInstanceDescriptionList = new ArrayList<BugInstanceDescription>(databaseManager.loadBugInstances(PRIORITY_1_FINDBUGS_ERRORS_QUERY));
        return "findbugs_errors";
    }

    public String returnPriority2Errors() {
        bugInstanceDescriptionList = new ArrayList<BugInstanceDescription>(databaseManager.loadBugInstances(PRIORITY_2_FINDBUGS_ERRORS_QUERY));
        return "findbugs_errors";
    }

    public String returnPriority3Errors() {
        bugInstanceDescriptionList = new ArrayList<BugInstanceDescription>(databaseManager.loadBugInstances(PRIORITY_3_FINDBUGS_ERRORS_QUERY));
        return "findbugs_errors";
    }

    public String returnRankScariestErrors() {
        bugInstanceDescriptionList = new ArrayList<BugInstanceDescription>(databaseManager.loadBugInstances(RANK_SCARIEST_FINDBUGS_ERRORS_QUERY));
        return "findbugs_errors";
    }

    public String returnRankScaryErrors() {
        bugInstanceDescriptionList = new ArrayList<BugInstanceDescription>(databaseManager.loadBugInstances(RANK_SCARY_FINDBUGS_ERRORS_QUERY));
        return "findbugs_errors";
    }

    public String returnRankTroublingErrors() {
        bugInstanceDescriptionList = new ArrayList<BugInstanceDescription>(databaseManager.loadBugInstances(RANK_TROUBLING_FINDBUGS_ERRORS_QUERY));
        return "findbugs_errors";
    }

    public String returnRankConcernBugsErrors() {
        bugInstanceDescriptionList = new ArrayList<BugInstanceDescription>(databaseManager.loadBugInstances(RANK_CONCERN_BUGS_FINDBUGS_ERRORS_QUERY));
        return "findbugs_errors";
    }

    public String returnCategoryCorrectnessErrors() {
        bugInstanceDescriptionList = new ArrayList<BugInstanceDescription>(databaseManager.loadBugInstances(CATEGORY_CORRECTNESS_FINDBUGS_ERRORS_QUERY));
        return "findbugs_errors";
    }

    public String returnCategoryBadPracticeErrors() {
        bugInstanceDescriptionList = new ArrayList<BugInstanceDescription>(databaseManager.loadBugInstances(CATEGORY_BAD_PRACTICE_FINDBUGS_ERRORS_QUERY));
        return "findbugs_errors";
    }

    public String returnCategoryStyleErrors() {
        bugInstanceDescriptionList = new ArrayList<BugInstanceDescription>(databaseManager.loadBugInstances(CATEGORY_STYLE_FINDBUGS_ERRORS_QUERY));
        return "findbugs_errors";
    }

    public String returnCategoryMtCorrectnessErrors() {
        bugInstanceDescriptionList = new ArrayList<BugInstanceDescription>(databaseManager.loadBugInstances(CATEGORY_MT_CORRECTNESS_FINDBUGS_ERRORS_QUERY));
        return "findbugs_errors";
    }

    public String returnCategoryMaliciousCodeErrors() {
        bugInstanceDescriptionList = new ArrayList<BugInstanceDescription>(databaseManager.loadBugInstances(CATEGORY_MALICIOUS_CODE_FINDBUGS_ERRORS_QUERY));
        return "findbugs_errors";
    }

    public String returnCategoryPerformanceErrors() {
        bugInstanceDescriptionList = new ArrayList<BugInstanceDescription>(databaseManager.loadBugInstances(CATEGORY_PERFORMANCE_FINDBUGS_ERRORS_QUERY));
        return "findbugs_errors";
    }

    public String returnCategoryI18nErrors() {
        bugInstanceDescriptionList = new ArrayList<BugInstanceDescription>(databaseManager.loadBugInstances(CATEGORY_I18N_FINDBUGS_ERRORS_QUERY));
        return "findbugs_errors";
    }

    public String detail(BugInstanceDescription bugInstanceDescription) {
        this.bugInstanceDescription = bugInstanceDescription;

        bugInstanceClassDescription = databaseManager.loadBugInstanceClassDescription(bugInstanceDescription.getBugInstanceId());
        if (bugInstanceClassDescription!=null) {
            bugInstanceClassDescription.setClassSourceLine(databaseManager.loadBugInstanceClassSourceLineDescription(bugInstanceDescription.getBugInstanceId()));
        }

        bugInstanceFieldDescription = databaseManager.loadBugInstanceFieldDescription(bugInstanceDescription.getBugInstanceId());
        if (bugInstanceFieldDescription!=null){
            bugInstanceFieldDescription.setFieldSourceLine(databaseManager.loadBugInstanceFieldSourceLineDescription(bugInstanceDescription.getBugInstanceId()));
        }

        bugInstanceIntDescription = databaseManager.loadBugInstanceIntDescription(bugInstanceDescription.getBugInstanceId());

        bugInstanceLocalVariableDescription = databaseManager.loadBugInstanceLocalVariableDescription(bugInstanceDescription.getBugInstanceId());

        bugInstanceMethodDescription = databaseManager.loadBugInstanceMethodDescription(bugInstanceDescription.getBugInstanceId());
        if (bugInstanceMethodDescription!=null) {
            bugInstanceMethodDescription.setMethodSourceLine(databaseManager.loadBugInstanceMethodSourceLineDescription(bugInstanceDescription.getBugInstanceId()));
        }

        bugInstancePropertyDescription = databaseManager.loadBugInstancePropertyDescription(bugInstanceDescription.getBugInstanceId());

        bugInstanceSourceLineDescription = databaseManager.loadBugInstanceSourceLineDescription(bugInstanceDescription.getBugInstanceId());

        bugInstanceStringDescription = databaseManager.loadBugInstanceStringDescription(bugInstanceDescription.getBugInstanceId());

        bugInstanceTypeDescription = databaseManager.loadBugInstanceTypeDescription(bugInstanceDescription.getBugInstanceId());
        if (bugInstanceTypeDescription!=null) {
            bugInstanceTypeDescription.setTypeSourceLine(databaseManager.loadBugInstanceTypeSourceLineDescription(bugInstanceDescription.getBugInstanceId()));
        }

        return "detail";
    }
}
