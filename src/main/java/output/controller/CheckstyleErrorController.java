package output.controller;

import databaseManager.CheckstyleDatabaseManager;
import output.entities.CheckstyleErrorDescription;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "checkstyleErrorController")
@SessionScoped
public class CheckstyleErrorController {
    @EJB
    private CheckstyleDatabaseManager checkstyleDatabaseManager;
    private CheckstyleErrorDescription checkstyleErrorDescription = new CheckstyleErrorDescription();
    private List<CheckstyleErrorDescription> errorDescriptionList;
    public static final String CHECKSTYLE_ERRORS_XHTML = "checkstyle_errors";
    public static final String ALL_CHECKSTYLE_ERRORS_QUERY = "SELECT e.errorId, e.classLine, e.classColumn, e.errorMessage, e.errorSeverity, e.checkSource, f.fileName FROM CHECKSTYLE_ERRORS e JOIN CHECKSTYLE_FILES f ON e.fileId = f.fileId";

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

    public String findAllCheckstyleErrors() {
        errorDescriptionList = new ArrayList<>(
                checkstyleDatabaseManager.loadCheckstyleErrorDescriptions(
                        ALL_CHECKSTYLE_ERRORS_QUERY));
        return CHECKSTYLE_ERRORS_XHTML;
    }

    public String findLocalVariableNameCheckstyleErrors() {
        errorDescriptionList = new ArrayList<>(
                checkstyleDatabaseManager.loadCheckstyleErrorDescriptions(
                        ALL_CHECKSTYLE_ERRORS_QUERY + " WHERE e.checkSource LIKE '%LocalVariableNameCheck'"));
        return CHECKSTYLE_ERRORS_XHTML;
    }

    public String findMemberNameCheckstyleErrors() {
        errorDescriptionList = new ArrayList<>(
                checkstyleDatabaseManager.loadCheckstyleErrorDescriptions(
                        ALL_CHECKSTYLE_ERRORS_QUERY + " WHERE e.checkSource LIKE '%MemberNameCheck'"));
        return CHECKSTYLE_ERRORS_XHTML;
    }

    public String findAbstractClassNameCheckstyleErrors() {
        errorDescriptionList = new ArrayList<>(
                checkstyleDatabaseManager.loadCheckstyleErrorDescriptions(
                        ALL_CHECKSTYLE_ERRORS_QUERY + " WHERE e.checkSource LIKE '%AbstractClassNameCheck'"));
        return CHECKSTYLE_ERRORS_XHTML;
    }

    public String findConstantNameCheckstyleErrors() {
        errorDescriptionList = new ArrayList<>(
                checkstyleDatabaseManager.loadCheckstyleErrorDescriptions(
                        ALL_CHECKSTYLE_ERRORS_QUERY + " WHERE e.checkSource LIKE '%ConstantNameCheck'"));
        return CHECKSTYLE_ERRORS_XHTML;
    }

    public String findStaticVariableNameCheckstyleErrors() {
        errorDescriptionList = new ArrayList<>(
                checkstyleDatabaseManager.loadCheckstyleErrorDescriptions(
                        ALL_CHECKSTYLE_ERRORS_QUERY + " WHERE e.checkSource LIKE '%StaticVariableNameCheck'"));
        return CHECKSTYLE_ERRORS_XHTML;
    }

    public String findJavadocMethodCheckstyleErrors() {
        errorDescriptionList = new ArrayList<>(
                checkstyleDatabaseManager.loadCheckstyleErrorDescriptions(
                        ALL_CHECKSTYLE_ERRORS_QUERY + " WHERE e.checkSource LIKE '%JavadocMethodCheck'"));
        return CHECKSTYLE_ERRORS_XHTML;
    }

    public String findJavadocTypeCheckstyleErrors() {
        errorDescriptionList = new ArrayList<>(
                checkstyleDatabaseManager.loadCheckstyleErrorDescriptions(
                        ALL_CHECKSTYLE_ERRORS_QUERY + " WHERE e.checkSource LIKE '%JavadocTypeCheck'"));
        return CHECKSTYLE_ERRORS_XHTML;
    }

    public String findJavadocVariableCheckstyleErrors() {
        errorDescriptionList = new ArrayList<>(
                checkstyleDatabaseManager.loadCheckstyleErrorDescriptions(
                        ALL_CHECKSTYLE_ERRORS_QUERY + " WHERE e.checkSource LIKE '%JavadocVariableCheck'"));
        return CHECKSTYLE_ERRORS_XHTML;
    }

    public String findEmptyLineSeparatorCheckstyleErrors() {
        errorDescriptionList = new ArrayList<>(
                checkstyleDatabaseManager.loadCheckstyleErrorDescriptions(
                        ALL_CHECKSTYLE_ERRORS_QUERY + " WHERE e.checkSource LIKE '%EmptyLineSeparatorCheck'"));
        return CHECKSTYLE_ERRORS_XHTML;
    }

    public String findMethodParamPadCheckstyleErrors() {
        errorDescriptionList = new ArrayList<>(
                checkstyleDatabaseManager.loadCheckstyleErrorDescriptions(
                        ALL_CHECKSTYLE_ERRORS_QUERY + " WHERE e.checkSource LIKE '%MethodParamPadCheck'"));
        return CHECKSTYLE_ERRORS_XHTML;
    }

    public String findNoLineWrapCheckstyleErrors() {
        errorDescriptionList = new ArrayList<>(
                checkstyleDatabaseManager.loadCheckstyleErrorDescriptions(
                        ALL_CHECKSTYLE_ERRORS_QUERY + " WHERE e.checkSource LIKE '%NoLineWrapCheck'"));
        return CHECKSTYLE_ERRORS_XHTML;
    }

    public String findSingleSpaceSeparatorCheckstyleErrors() {
        errorDescriptionList = new ArrayList<>(
                checkstyleDatabaseManager.loadCheckstyleErrorDescriptions(
                        ALL_CHECKSTYLE_ERRORS_QUERY + " WHERE e.checkSource LIKE '%SingleSpaceSeparatorCheck'"));
        return CHECKSTYLE_ERRORS_XHTML;
    }

    public String findGenericWhitespaceCheckstyleErrors() {
        errorDescriptionList = new ArrayList<>(
                checkstyleDatabaseManager.loadCheckstyleErrorDescriptions(
                        ALL_CHECKSTYLE_ERRORS_QUERY + " WHERE e.checkSource LIKE '%GenericWhitespaceCheck'"));
        return CHECKSTYLE_ERRORS_XHTML;
    }

    public String findOperatorWrapCheckstyleErrors() {
        errorDescriptionList = new ArrayList<>(
                checkstyleDatabaseManager.loadCheckstyleErrorDescriptions(
                        ALL_CHECKSTYLE_ERRORS_QUERY + " WHERE e.checkSource LIKE '%OperatorWrapCheck'"));
        return CHECKSTYLE_ERRORS_XHTML;
    }

    public String findWhitespaceAroundCheckstyleErrors() {
        errorDescriptionList = new ArrayList<>(
                checkstyleDatabaseManager.loadCheckstyleErrorDescriptions(
                        ALL_CHECKSTYLE_ERRORS_QUERY + " WHERE e.checkSource LIKE '%WhitespaceAroundCheck'"));
        return CHECKSTYLE_ERRORS_XHTML;
    }
}
