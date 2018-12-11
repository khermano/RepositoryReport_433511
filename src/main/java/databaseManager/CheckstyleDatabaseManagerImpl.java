package databaseManager;

import input.checkstyle.CheckstyleFile;
import org.hibernate.transform.Transformers;
import output.entities.CheckstyleErrorDescription;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.List;

@Stateless
public class CheckstyleDatabaseManagerImpl implements CheckstyleDatabaseManager{

    @PersistenceContext(unitName = "reportPersistenceUnit")
    private EntityManager em;

    public void addFiles(List<CheckstyleFile> files) {
        cleanTables();
        if (files!=null) {
            for (CheckstyleFile file: files) {
                em.persist(file);
            }
        }
    }

    @SuppressWarnings(value = "unchecked")
    public List<CheckstyleErrorDescription> loadCheckstyleErrorDescriptions(String queryString) {
        Query query = em.createNativeQuery(queryString);
        return query.unwrap(org.hibernate.Query.class ).setResultTransformer(
                Transformers.aliasToBean(CheckstyleErrorDescription.class)).list();
    }

    public void cleanTables() {
        Query checkstyleCountQuery = em.createNativeQuery("SELECT COUNT(fileId) FROM CHECKSTYLE_FILES");

        if (BigInteger.valueOf(0).compareTo((BigInteger) checkstyleCountQuery.unwrap(org.hibernate.Query.class).list().get(0)) < 0) {
            Query deleteCheckstyleErrorsData = em.createNativeQuery("DELETE FROM CHECKSTYLE_ERRORS");
            deleteCheckstyleErrorsData.unwrap(org.hibernate.Query.class).executeUpdate();

            Query deleteCheckstyleFilesData = em.createNativeQuery("DELETE FROM CHECKSTYLE_FILES");
            deleteCheckstyleFilesData.unwrap(org.hibernate.Query.class).executeUpdate();
        }
    }
}
