package RestEasy;

import Checkstyle.CheckstyleError;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EntityManagerFactoryImpl implements EntityManagerFactory{

    @PersistenceContext(unitName = "testPersistenceUnit")
    private EntityManager em;

    public void add(CheckstyleError error){
        em.persist(error);
    }

    public CheckstyleError get(Long id){
        return em.find(CheckstyleError.class, id);
    }
}
