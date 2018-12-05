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

    public CheckstyleErrorDescription getCheckstyleErrorDescription() {
        return checkstyleErrorDescription;
    }

    public void setCheckstyleErrorDescription(CheckstyleErrorDescription checkstyleErrorDescription) {
        this.checkstyleErrorDescription = checkstyleErrorDescription;
    }

    public List<CheckstyleErrorDescription> findAll() {
        return databaseManager.loadCheckstyleErrorDescriptions();
    }
}
