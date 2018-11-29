package RestEasyPackage;

import CheckstylePackage.CheckstyleError;
import CheckstylePackage.CheckstyleFile;
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
    }

    public void addFiles(List<CheckstyleFile> files) {
        for (Iterator<CheckstyleFile> it = files.iterator(); it.hasNext();) {

            CheckstyleFile file = it.next();
            addFile(file);
        }
    }

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
    }

    public void addBugInstanceSourceLine(FindBugsBugInstanceSourceLine bugInstanceSourceLine) {
        em.persist(bugInstanceSourceLine);
    }

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

    public List<ErrorDescription> loadUserDescriptionsFromJavadocMethodCheck() {
        String queryString = "SELECT e.classLine, e.classColumn, e.errorMessage, e.errorSeverity, e.checkSource, f.fileName FROM CHECKSTYLE_ERRORS e JOIN CHECKSTYLE_FILES f ON e.fileId = f.fileId WHERE checkSource LIKE '%JavadocMethodCheck'";
        Query query = em.createNativeQuery(queryString);
        return query.unwrap(org.hibernate.Query.class ).setResultTransformer(Transformers.aliasToBean(ErrorDescription.class)).list();
    }

    public List<BugInstanceDescription> loadBugInstanceWithPriority1() {
        String queryString = "SELECT type, priority, rank, abbrev, category FROM BUG_INSTANCE WHERE priority = '1'";
        Query query = em.createNativeQuery(queryString);
        return query.unwrap(org.hibernate.Query.class ).setResultTransformer(Transformers.aliasToBean(BugInstanceDescription.class)).list();
    }

    public List<BugInstanceDescription> loadBugInstanceWithRankScariest() {
        String queryString = "SELECT type, priority, rank, abbrev, category FROM BUG_INSTANCE WHERE rank BETWEEN '1' AND '4'";
        Query query = em.createNativeQuery(queryString);
        return query.unwrap(org.hibernate.Query.class ).setResultTransformer(Transformers.aliasToBean(BugInstanceDescription.class)).list();
    }

    public List<BugInstanceDescription> loadBugInstanceWithCategoryCorrectness() {
        String queryString = "SELECT type, priority, rank, abbrev, category FROM BUG_INSTANCE WHERE category = 'CORRECTNESS'";
        Query query = em.createNativeQuery(queryString);
        return query.unwrap(org.hibernate.Query.class ).setResultTransformer(Transformers.aliasToBean(BugInstanceDescription.class)).list();
    }
}
