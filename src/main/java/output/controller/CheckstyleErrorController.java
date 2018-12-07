package output.controller;

import output.entities.CheckstyleErrorDescription;
import databaseManager.DatabaseManager;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

import static databaseManager.DatabaseManagerImpl.*;

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

    public String returnAllErrors() {
        errorDescriptionList = new ArrayList<CheckstyleErrorDescription>(databaseManager.loadCheckstyleErrorDescriptions(ALL_CHECKSTYLE_ERRORS_QUERY));
        return "checkstyle_errors";
    }

    public String returnLocalVariableNameErrors() {
        errorDescriptionList = new ArrayList<CheckstyleErrorDescription>(databaseManager.loadCheckstyleErrorDescriptions(LOCAL_VARIABLE_NAME_CHECKSTYLE_ERRORS_QUERY));
        return "checkstyle_errors";
    }

    public String returnMemberNameErrors() {
        errorDescriptionList = new ArrayList<CheckstyleErrorDescription>(databaseManager.loadCheckstyleErrorDescriptions(MEMBER_NAME_CHECKSTYLE_ERRORS_QUERY));
        return "checkstyle_errors";
    }

    public String returnAbstractClassNameErrors() {
        errorDescriptionList = new ArrayList<CheckstyleErrorDescription>(databaseManager.loadCheckstyleErrorDescriptions(ABSTRACT_CLASS_NAME_CHECKSTYLE_ERRORS_QUERY));
        return "checkstyle_errors";
    }

    public String returnConstantNameErrors() {
        errorDescriptionList = new ArrayList<CheckstyleErrorDescription>(databaseManager.loadCheckstyleErrorDescriptions(CONSTANT_NAME_CHECKSTYLE_ERRORS_QUERY));
        return "checkstyle_errors";
    }

    public String returnStaticVariableNameErrors() {
        errorDescriptionList = new ArrayList<CheckstyleErrorDescription>(databaseManager.loadCheckstyleErrorDescriptions(STATIC_VARIABLE_NAME_CHECKSTYLE_ERRORS_QUERY));
        return "checkstyle_errors";
    }

    public String returnJavadocMethodErrors() {
        errorDescriptionList = new ArrayList<CheckstyleErrorDescription>(databaseManager.loadCheckstyleErrorDescriptions(JAVADOC_METHOD_CHECKSTYLE_ERRORS_QUERY));
        return "checkstyle_errors";
    }

    public String returnJavadocTypeErrors() {
        errorDescriptionList = new ArrayList<CheckstyleErrorDescription>(databaseManager.loadCheckstyleErrorDescriptions(JAVADOC_TYPE_CHECKSTYLE_ERRORS_QUERY));
        return "checkstyle_errors";
    }

    public String returnJavadocVariableErrors() {
        errorDescriptionList = new ArrayList<CheckstyleErrorDescription>(databaseManager.loadCheckstyleErrorDescriptions(JAVADOC_VARIABLE_CHECKSTYLE_ERRORS_QUERY));
        return "checkstyle_errors";
    }

    public String returnEmptyLineSeparatorErrors() {
        errorDescriptionList = new ArrayList<CheckstyleErrorDescription>(databaseManager.loadCheckstyleErrorDescriptions(EMPTY_LINE_SEPARATOR_CHECKSTYLE_ERRORS_QUERY));
        return "checkstyle_errors";
    }

    public String returnMethodParamPadErrors() {
        errorDescriptionList = new ArrayList<CheckstyleErrorDescription>(databaseManager.loadCheckstyleErrorDescriptions(METHOD_PARAM_PAD_CHECKSTYLE_ERRORS_QUERY));
        return "checkstyle_errors";
    }

    public String returnNoLineWrapErrors() {
        errorDescriptionList = new ArrayList<CheckstyleErrorDescription>(databaseManager.loadCheckstyleErrorDescriptions(NO_LINE_WRAP_CHECKSTYLE_ERRORS_QUERY));
        return "checkstyle_errors";
    }

    public String returnSingleSpaceSeparatorErrors() {
        errorDescriptionList = new ArrayList<CheckstyleErrorDescription>(databaseManager.loadCheckstyleErrorDescriptions(SINGLE_SPACE_SEPARATOR_CHECKSTYLE_ERRORS_QUERY));
        return "checkstyle_errors";
    }

    public String returnGenericWhitespaceErrors() {
        errorDescriptionList = new ArrayList<CheckstyleErrorDescription>(databaseManager.loadCheckstyleErrorDescriptions(GENERIC_WHITESPACE_CHECKSTYLE_ERRORS_QUERY));
        return "checkstyle_errors";
    }

    public String returnOperatorWrapErrors() {
        errorDescriptionList = new ArrayList<CheckstyleErrorDescription>(databaseManager.loadCheckstyleErrorDescriptions(OPERATOR_WRAP_CHECKSTYLE_ERRORS_QUERY));
        return "checkstyle_errors";
    }

    public String returnWhitespaceAroundErrors() {
        errorDescriptionList = new ArrayList<CheckstyleErrorDescription>(databaseManager.loadCheckstyleErrorDescriptions(WHITESPACE_AROUND_CHECKSTYLE_ERRORS_QUERY));
        return "checkstyle_errors";
    }
}
