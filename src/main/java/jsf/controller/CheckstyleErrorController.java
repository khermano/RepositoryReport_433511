package jsf.controller;

import jsf.entities.CheckstyleErrorDescription;
import jsf.entityManager.DatabaseManager;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
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

    public List<CheckstyleErrorDescription> findAll() {
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
    }

    public String returnAll() {
        return "checkstyle_all_errors";
    }

    public String returnLocalVariableNameErrors() {
        return "checkstyle_localVariableName_errors";
    }

    public String returnMemberNameErrors() {
        return "checkstyle_memberName_errors";
    }

    public String returnAbstractClassNameErrors() {
        return "checkstyle_abstractClassName_errors";
    }

    public String returnConstantNameErrors() {
        return "checkstyle_constantName_errors";
    }

    public String returnStaticVariableNameErrors() {
        return "checkstyle_staticVariableName_errors";
    }

    public String returnJavadocMethodErrors() {
        return "checkstyle_javadocMethod_errors";
    }

    public String returnJavadocTypeErrors() {
        return "checkstyle_javadocType_errors";
    }

    public String returnJavadocVariableErrors() {
        return "checkstyle_javadocVariable_errors";
    }

    public String returnEmptyLineSeparatorErrors() {
        return "checkstyle_emptyLineSeparator_errors";
    }

    public String returnMethodParamPadErrors() {
        return "checkstyle_methodParamPad_errors";
    }

    public String returnNoLineWrapErrors() {
        return "checkstyle_noLineWrap_errors";
    }

    public String returnSingleSpaceSeparatorErrors() {
        return "checkstyle_singleSpaceSeparator_errors";
    }

    public String returnGenericWhitespaceErrors() {
        return "checkstyle_genericWhitespace_errors";
    }

    public String returnOperatorWrapErrors() {
        return "checkstyle_operatorWrap_errors";
    }

    public String returnWhitespaceAroundErrors() {
        return "checkstyle_whitespaceAround_errors";
    }
}
