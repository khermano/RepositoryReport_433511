package jsf.controller;

import jsf.entities.CheckstyleErrorDescription;
import jsf.entityManager.DatabaseManager;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "checkstyleErrorController")
@SessionScoped
public class CheckstyleErrorController {

    @EJB
    private DatabaseManager databaseManager;
    private CheckstyleErrorDescription checkstyleErrorDescription = new CheckstyleErrorDescription();
    private List<CheckstyleErrorDescription> errorDescriptionList;

    public CheckstyleErrorDescription getCheckstyleErrorDescription() {
        return checkstyleErrorDescription;
    }

    public void setCheckstyleErrorDescription(CheckstyleErrorDescription checkstyleErrorDescription) {
        this.checkstyleErrorDescription = checkstyleErrorDescription;
    }

    public List<CheckstyleErrorDescription> getErrorDescriptionList() {
        return errorDescriptionList;
    }

    public void setErrorDescriptionList(List<CheckstyleErrorDescription> errorDescriptionList) {
        this.errorDescriptionList = errorDescriptionList;
    }

    /*public List<CheckstyleErrorDescription> findAll() {
        return databaseManager.loadCheckstyleErrorDescriptions();
    }

    public List<CheckstyleErrorDescription> findLocalVariableNameErrors() {
        return databaseManager.loadCheckstyleLocalVariableNameErrors();
    }

    public List<CheckstyleErrorDescription> findMemberNameErrors() {
        return databaseManager.loadCheckstyleMemberNameErrors();
    }

    public List<CheckstyleErrorDescription> findAbstractClassNameErrors() {
        return databaseManager.loadCheckstyleAbstractClassNameErrors();
    }

    public List<CheckstyleErrorDescription> findConstantNameErrors() {
        return databaseManager.loadCheckstyleConstantNameErrors();
    }

    public List<CheckstyleErrorDescription> findStaticVariableNameErrors() {
        return databaseManager.loadCheckstyleStaticVariableNameErrors();
    }

    public List<CheckstyleErrorDescription> findJavadocMethodErrors() {
        return databaseManager.loadCheckstyleJavadocMethodErrors();
    }

    public List<CheckstyleErrorDescription> findJavadocTypeErrors() {
        return databaseManager.loadCheckstyleJavadocTypeErrors();
    }

    public List<CheckstyleErrorDescription> findJavadocVariableErrors() {
        return databaseManager.loadCheckstyleJavadocVariableErrors();
    }

    public List<CheckstyleErrorDescription> findEmptyLineSeparatorErrors() {
        return databaseManager.loadCheckstyleEmptyLineSeparatorErrors();
    }

    public List<CheckstyleErrorDescription> findMethodParamPadErrors() {
        return databaseManager.loadCheckstyleMethodParamPadErrors();
    }

    public List<CheckstyleErrorDescription> findNoLineWrapErrors() {
        return databaseManager.loadCheckstyleNoLineWrapErrors();
    }

    public List<CheckstyleErrorDescription> findSingleSpaceSeparatorErrors() {
        return databaseManager.loadCheckstyleSingleSpaceSeparatorErrors();
    }

    public List<CheckstyleErrorDescription> findGenericWhitespaceErrors() {
        return databaseManager.loadCheckstyleGenericWhitespaceErrors();
    }

    public List<CheckstyleErrorDescription> findOperatorWrapErrors() {
        return databaseManager.loadCheckstyleOperatorWrapErrors();
    }

    public List<CheckstyleErrorDescription> findWhitespaceAroundErrors() {
        return databaseManager.loadCheckstyleWhitespaceAroundErrors();
    }*/

    public String returnAll() {
        errorDescriptionList = new ArrayList<CheckstyleErrorDescription>(databaseManager.loadCheckstyleErrorDescriptions());
        return "checkstyle_errors";
    }

    public String returnLocalVariableNameErrors() {
        errorDescriptionList = new ArrayList<CheckstyleErrorDescription>(databaseManager.loadCheckstyleLocalVariableNameErrors());
        return "checkstyle_errors";
    }

    public String returnMemberNameErrors() {
        errorDescriptionList = new ArrayList<CheckstyleErrorDescription>(databaseManager.loadCheckstyleMemberNameErrors());
        return "checkstyle_errors";
    }

    public String returnAbstractClassNameErrors() {
        errorDescriptionList = new ArrayList<CheckstyleErrorDescription>(databaseManager.loadCheckstyleAbstractClassNameErrors());
        return "checkstyle_errors";
    }

    public String returnConstantNameErrors() {
        errorDescriptionList = new ArrayList<CheckstyleErrorDescription>(databaseManager.loadCheckstyleConstantNameErrors());
        return "checkstyle_errors";
    }

    public String returnStaticVariableNameErrors() {
        errorDescriptionList = new ArrayList<CheckstyleErrorDescription>(databaseManager.loadCheckstyleStaticVariableNameErrors());
        return "checkstyle_errors";
    }

    public String returnJavadocMethodErrors() {
        errorDescriptionList = new ArrayList<CheckstyleErrorDescription>(databaseManager.loadCheckstyleJavadocMethodErrors());
        return "checkstyle_errors";
    }

    public String returnJavadocTypeErrors() {
        errorDescriptionList = new ArrayList<CheckstyleErrorDescription>(databaseManager.loadCheckstyleJavadocTypeErrors());
        return "checkstyle_errors";
    }

    public String returnJavadocVariableErrors() {
        errorDescriptionList = new ArrayList<CheckstyleErrorDescription>(databaseManager.loadCheckstyleJavadocVariableErrors());
        return "checkstyle_errors";
    }

    public String returnEmptyLineSeparatorErrors() {
        errorDescriptionList = new ArrayList<CheckstyleErrorDescription>(databaseManager.loadCheckstyleEmptyLineSeparatorErrors());
        return "checkstyle_errors";
    }

    public String returnMethodParamPadErrors() {
        errorDescriptionList = new ArrayList<CheckstyleErrorDescription>(databaseManager.loadCheckstyleMethodParamPadErrors());
        return "checkstyle_errors";
    }

    public String returnNoLineWrapErrors() {
        errorDescriptionList = new ArrayList<CheckstyleErrorDescription>(databaseManager.loadCheckstyleNoLineWrapErrors());
        return "checkstyle_errors";
    }

    public String returnSingleSpaceSeparatorErrors() {
        errorDescriptionList = new ArrayList<CheckstyleErrorDescription>(databaseManager.loadCheckstyleSingleSpaceSeparatorErrors());
        return "checkstyle_errors";
    }

    public String returnGenericWhitespaceErrors() {
        errorDescriptionList = new ArrayList<CheckstyleErrorDescription>(databaseManager.loadCheckstyleGenericWhitespaceErrors());
        return "checkstyle_errors";
    }

    public String returnOperatorWrapErrors() {
        errorDescriptionList = new ArrayList<CheckstyleErrorDescription>(databaseManager.loadCheckstyleOperatorWrapErrors());
        return "checkstyle_errors";
    }

    public String returnWhitespaceAroundErrors() {
        errorDescriptionList = new ArrayList<CheckstyleErrorDescription>(databaseManager.loadCheckstyleWhitespaceAroundErrors());
        return "checkstyle_errors";
    }
}
