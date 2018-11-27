package RestEasyPackage;

import CheckstylePackage.CheckstyleError;
import CheckstylePackage.CheckstyleFile;
//import FindBugsPackage.ReportPackage.BugInstancePackage.FindBugsBugInstanceSourceLinePackage.SourceLine;
//import FindBugsPackage.ReportPackage.FindBugsSummary;
import FindBugsPackage.FindBugsReport;
import FindBugsPackage.ReportPackage.BugInstancePackage.*;
import FindBugsPackage.ReportPackage.FindBugsBugInstance;
import org.hibernate.transform.Transformers;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Iterator;
import java.util.List;

@Stateless
public class EntityManagerFactoryImpl implements EntityManagerFactory{

    @PersistenceContext(unitName = "testPersistenceUnit")
    private EntityManager em;

    public void addError(CheckstyleError error){
        em.persist(error);
    }

    public void addFile(CheckstyleFile file) {
        em.persist(file);
        /*em.flush();
        em.clear();*/
    }

    public void addFiles(List<CheckstyleFile> files) {
        for (Iterator<CheckstyleFile> it = files.iterator(); it.hasNext();) {

            CheckstyleFile file = it.next();
            addFile(file);
        }
    }

    /*public void addFindBugsSummary(FindBugsSummary findBugsSummary) {
        em.persist(findBugsSummary);
        em.flush();
        em.clear();
    }

    public void addFindBugsSourceLine(SourceLine sourceLine) {
        em.persist(sourceLine);
        em.flush();
        em.clear();
    }*/

    /*public void addFindBugsReport(FindBugsReport report) {
        em.persist(report);
        em.flush();
        em.clear();
    }*/

    public void addBugInstances(List<FindBugsBugInstance> bugInstances) {
        for (Iterator<FindBugsBugInstance> it = bugInstances.iterator(); it.hasNext();) {

            FindBugsBugInstance bugInstance = it.next();
            addBugInstance(bugInstance);
        }
    }

    public void addBugInstance(FindBugsBugInstance bugInstance) {
        em.persist(bugInstance);

        if (bugInstance.getBugInstanceType()!= null && bugInstance.getBugInstanceType().getSourceLines()!=null) {
            for (Iterator<FindBugsBugInstanceSourceLine> it = bugInstance.getBugInstanceType().getSourceLines().iterator(); it.hasNext();) {

                FindBugsBugInstanceSourceLine bugInstanceSourceLine = it.next();
                addBugInstanceSourceLine(bugInstanceSourceLine);
            }
        }

        if (bugInstance.getBugInstanceMethod()!=null && bugInstance.getBugInstanceMethod().getSourceLines()!=null) {
            for (Iterator<FindBugsBugInstanceSourceLine> it = bugInstance.getBugInstanceMethod().getSourceLines().iterator(); it.hasNext();) {

                FindBugsBugInstanceSourceLine bugInstanceSourceLine = it.next();
                addBugInstanceSourceLine(bugInstanceSourceLine);
            }
        }




        /*if (bugInstance.getBugInstanceClass()!=null) {
            addBugInstanceClass(bugInstance.getBugInstanceClass());
        }
        if (bugInstance.getBugInstanceMethod()!=null) {
            addBugInstanceMethod(bugInstance.getBugInstanceMethod());
        }
        if (bugInstance.getBugInstanceType()!=null) {
            addBugInstanceType(bugInstance.getBugInstanceType());
        }
        if (bugInstance.getBugInstanceField()!=null) {
            addBugInstanceField(bugInstance.getBugInstanceField());
        }
        if (bugInstance.getBugInstanceSourceLine()!=null) {
            addBugInstanceSourceLine(bugInstance.getBugInstanceSourceLine());
        }
        if (bugInstance.getBugInstanceString()!=null) {
            addBugInstanceString(bugInstance.getBugInstanceString());
        }
        if (bugInstance.getBugInstanceLocalVariable()!=null) {
            addBugInstanceLocalVariable(bugInstance.getBugInstanceLocalVariable());
        }
        if (bugInstance.getBugInstanceProperty()!=null) {
            addBugInstanceProperty(bugInstance.getBugInstanceProperty());
        }
        if (bugInstance.getBugInstanceInt()!=null) {
            addBugInstanceInt(bugInstance.getBugInstanceInt());
        }*/
        /*em.flush();
        em.clear();*/
    }

    /*public void addBugInstanceClass(FindBugsBugInstanceClass bugInstanceClass) {
        em.persist(bugInstanceClass);
        if (bugInstanceClass.getSourceLine()!=null) {
            addBugInstanceSourceLine(bugInstanceClass.getSourceLine());
        }
        em.flush();
        em.clear();
    }

    public void addBugInstanceMethod(FindBugsBugInstanceMethod bugInstanceMethod) {
        em.persist(bugInstanceMethod);
        if (bugInstanceMethod.getSourceLines()!=null) {
            for (Iterator<FindBugsBugInstanceSourceLine> it = bugInstanceMethod.getSourceLines().iterator(); it.hasNext();) {

                FindBugsBugInstanceSourceLine bugInstanceSourceLine = it.next();
                addBugInstanceSourceLine(bugInstanceSourceLine);
            }
        }
        em.flush();
        em.clear();
    }

    public void addBugInstanceType(FindBugsBugInstanceType bugInstanceType) {
        em.persist(bugInstanceType);
        if (bugInstanceType.getSourceLines()!=null) {
            for (Iterator<FindBugsBugInstanceSourceLine> it = bugInstanceType.getSourceLines().iterator(); it.hasNext();) {

                FindBugsBugInstanceSourceLine bugInstanceSourceLine = it.next();
                addBugInstanceSourceLine(bugInstanceSourceLine);
            }
        }
        em.flush();
        em.clear();
    }

    public void addBugInstanceField(FindBugsBugInstanceField bugInstanceField) {
        em.persist(bugInstanceField);
        if (bugInstanceField.getSourceLine()!=null) {
            addBugInstanceSourceLine(bugInstanceField.getSourceLine());
        }
        em.flush();
        em.clear();
    }*/

    public void addBugInstanceSourceLine(FindBugsBugInstanceSourceLine bugInstanceSourceLine) {
        em.persist(bugInstanceSourceLine);
        /*em.flush();
        em.clear();*/
    }

    /*public void addBugInstanceString(FindBugsBugInstanceString bugInstanceString) {
        em.persist(bugInstanceString);
        em.flush();
        em.clear();
    }

    public void addBugInstanceLocalVariable(FindBugsBugInstanceLocalVariable bugInstanceLocalVariable) {
        em.persist(bugInstanceLocalVariable);
        em.flush();
        em.clear();
    }

    public void addBugInstanceProperty(FindBugsBugInstanceProperty bugInstanceProperty) {
        em.persist(bugInstanceProperty);
        em.flush();
        em.clear();
    }

    public void addBugInstanceInt(FindBugsBugInstanceInt bugInstanceInt) {
        em.persist(bugInstanceInt);
        em.flush();
        em.clear();
    }*/

    public CheckstyleError getError(Long id){
        return em.find(CheckstyleError.class, id);
    }

    public CheckstyleFile getFile(Long id) {
        return em.find(CheckstyleFile.class, id);
    }

    public List<ErrorDescription> loadUserDescriptions() {
        String queryString = "SELECT e.classLine, e.classColumn, e.errorMessage, e.errorSeverity, e.checkSource, f.fileName FROM CHECKSTYLE_ERRORS e JOIN CHECKSTYLE_FILES f ON e.fileId = f.fileId";
        Query query = em.createNativeQuery(queryString);
        return query.unwrap(org.hibernate.Query.class ).setResultTransformer(Transformers.aliasToBean(ErrorDescription.class)).list();
    }
}
