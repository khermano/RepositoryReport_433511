package RestEasyPackage;

import CheckstylePackage.CheckstyleError;
import CheckstylePackage.CheckstyleFile;
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
        em.flush();
        em.clear();
    }

    public void addFiles(List<CheckstyleFile> files) {
        for (Iterator<CheckstyleFile> it = files.iterator(); it.hasNext();) {

            CheckstyleFile file = it.next();
            addFile(file);
        }
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
}
