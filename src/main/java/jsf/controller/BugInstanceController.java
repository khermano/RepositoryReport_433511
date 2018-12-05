package jsf.controller;

import jsf.entities.*;
import jsf.entityManager.DatabaseManager;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

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

    public List<BugInstanceDescription> findAll() {
        return databaseManager.loadBugInstances();
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
