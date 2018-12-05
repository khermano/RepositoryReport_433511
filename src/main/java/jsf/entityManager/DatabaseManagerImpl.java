package jsf.entityManager;

import checkstylePackage.CheckstyleError;
import checkstylePackage.CheckstyleFile;
import findBugsPackage.reportPackage.bugInstancePackage.*;
import findBugsPackage.reportPackage.FindBugsBugInstance;
import jsf.entities.*;
import org.hibernate.transform.Transformers;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Stateless
public class DatabaseManagerImpl implements DatabaseManager {

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

        if (bugInstance.getBugInstanceClassList()!= null) {
            for (Iterator<FindBugsBugInstanceClass> it = bugInstance.getBugInstanceClassList().iterator(); it.hasNext();) {
                FindBugsBugInstanceClass bugInstanceClass = it.next();
                addBugInstanceClass(bugInstanceClass);
            }
        }

        if (bugInstance.getBugInstanceFieldList()!= null) {
            for (Iterator<FindBugsBugInstanceField> it = bugInstance.getBugInstanceFieldList().iterator(); it.hasNext();) {
                FindBugsBugInstanceField bugInstanceField = it.next();
                addBugInstanceField(bugInstanceField);
            }
        }

        if (bugInstance.getBugInstanceIntList()!= null) {
            for (Iterator<FindBugsBugInstanceInt> it = bugInstance.getBugInstanceIntList().iterator(); it.hasNext();) {
                FindBugsBugInstanceInt bugInstanceInt = it.next();
                em.persist(bugInstanceInt);
            }
        }

        if (bugInstance.getBugInstanceLocalVariableList()!= null) {
            for (Iterator<FindBugsBugInstanceLocalVariable> it = bugInstance.getBugInstanceLocalVariableList().iterator(); it.hasNext();) {
                FindBugsBugInstanceLocalVariable bugInstanceLocalVariable = it.next();
                em.persist(bugInstanceLocalVariable);
            }
        }

        if (bugInstance.getBugInstanceMethodList()!= null) {
            for (Iterator<FindBugsBugInstanceMethod> it = bugInstance.getBugInstanceMethodList().iterator(); it.hasNext();) {
                FindBugsBugInstanceMethod bugInstanceMethod = it.next();
                addBugInstanceMethod(bugInstanceMethod);
            }
        }

        if (bugInstance.getBugInstancePropertyList()!= null) {
            for (Iterator<FindBugsBugInstanceProperty> it = bugInstance.getBugInstancePropertyList().iterator(); it.hasNext();) {
                FindBugsBugInstanceProperty bugInstanceProperty = it.next();
                em.persist(bugInstanceProperty);
            }
        }

        if (bugInstance.getBugInstanceSourceLineList()!= null) {
            for (Iterator<FindBugsBugInstanceSourceLine> it = bugInstance.getBugInstanceSourceLineList().iterator(); it.hasNext();) {
                FindBugsBugInstanceSourceLine bugInstanceSourceLine = it.next();
                em.persist(bugInstanceSourceLine);
            }
        }

        if (bugInstance.getBugInstanceStringList()!= null) {
            for (Iterator<FindBugsBugInstanceString> it = bugInstance.getBugInstanceStringList().iterator(); it.hasNext();) {
                FindBugsBugInstanceString bugInstanceString = it.next();
                em.persist(bugInstanceString);
            }
        }

        if (bugInstance.getBugInstanceTypeList()!= null) {
            for (Iterator<FindBugsBugInstanceType> it = bugInstance.getBugInstanceTypeList().iterator(); it.hasNext();) {
                FindBugsBugInstanceType bugInstanceType = it.next();
                addBugInstanceType(bugInstanceType);
            }
        }
    }

    private void addBugInstanceClass(FindBugsBugInstanceClass bugInstanceClass) {
        em.persist(bugInstanceClass);

        if (bugInstanceClass.getSourceLineList()!=null) {
            for (Iterator<FindBugsBugInstanceSourceLine> it = bugInstanceClass.getSourceLineList().iterator(); it.hasNext();) {

                FindBugsBugInstanceSourceLine bugInstanceSourceLine = it.next();
                em.persist(bugInstanceSourceLine);
            }
        }
    }

    private void addBugInstanceField(FindBugsBugInstanceField bugInstanceField) {
        em.persist(bugInstanceField);

        if (bugInstanceField.getSourceLineList()!=null) {
            for (Iterator<FindBugsBugInstanceSourceLine> it = bugInstanceField.getSourceLineList().iterator(); it.hasNext();) {

                FindBugsBugInstanceSourceLine bugInstanceSourceLine = it.next();
                em.persist(bugInstanceSourceLine);
            }
        }
    }

    private void addBugInstanceMethod(FindBugsBugInstanceMethod bugInstanceMethod) {
        em.persist(bugInstanceMethod);

        if (bugInstanceMethod.getSourceLineList()!=null) {
            for (Iterator<FindBugsBugInstanceSourceLine> it = bugInstanceMethod.getSourceLineList().iterator(); it.hasNext();) {

                FindBugsBugInstanceSourceLine bugInstanceSourceLine = it.next();
                em.persist(bugInstanceSourceLine);
            }
        }
    }

    private void addBugInstanceType(FindBugsBugInstanceType bugInstanceType) {
        em.persist(bugInstanceType);

        if (bugInstanceType.getSourceLineList()!=null) {
            for (Iterator<FindBugsBugInstanceSourceLine> it = bugInstanceType.getSourceLineList().iterator(); it.hasNext();) {

                FindBugsBugInstanceSourceLine bugInstanceSourceLine = it.next();
                em.persist(bugInstanceSourceLine);
            }
        }
    }

    public CheckstyleError getError(Long id){
        return em.find(CheckstyleError.class, id);
    }

    public CheckstyleFile getFile(Long id) {
        return em.find(CheckstyleFile.class, id);
    }

    public List<CheckstyleErrorDescription> loadCheckstyleErrorDescriptions() {
        String queryString = "SELECT e.errorId, e.classLine, e.classColumn, e.errorMessage, e.errorSeverity, e.checkSource, f.fileName FROM CHECKSTYLE_ERRORS e JOIN CHECKSTYLE_FILES f ON e.fileId = f.fileId";
        Query query = em.createNativeQuery(queryString);
        return query.unwrap(org.hibernate.Query.class ).setResultTransformer(Transformers.aliasToBean(CheckstyleErrorDescription.class)).list();
    }

    public List<CheckstyleErrorDescription> loadUserDescriptionsFromJavadocMethodCheck() {
        String queryString = "SELECT e.classLine, e.classColumn, e.errorMessage, e.errorSeverity, e.checkSource, f.fileName FROM CHECKSTYLE_ERRORS e JOIN CHECKSTYLE_FILES f ON e.fileId = f.fileId WHERE checkSource LIKE '%JavadocMethodCheck'";
        Query query = em.createNativeQuery(queryString);
        return query.unwrap(org.hibernate.Query.class ).setResultTransformer(Transformers.aliasToBean(CheckstyleErrorDescription.class)).list();
    }

    public List<BugInstanceDescription> loadBugInstances() {
        String queryString = "SELECT bugInstanceId, type, priority, rank, abbrev, category FROM BUG_INSTANCE";
        Query query = em.createNativeQuery(queryString);
        return query.unwrap(org.hibernate.Query.class ).setResultTransformer(Transformers.aliasToBean(BugInstanceDescription.class)).list();
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

    public BugInstanceClassDescription loadBugInstanceClassDescription(BigInteger id) {
        String queryString = "SELECT b.className FROM BUG_INSTANCE a JOIN BUG_INSTANCE_CLASS b ON a.bugInstanceId = b.bugInstanceId WHERE a.bugInstanceId = '" + id + "'";
        Query query = em.createNativeQuery(queryString);
        try {
            return (BugInstanceClassDescription)query.unwrap(org.hibernate.Query.class ).setResultTransformer(Transformers.aliasToBean(BugInstanceClassDescription.class)).list().get(0);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public BugInstanceSourceLineDescription loadBugInstanceClassSourceLineDescription(BigInteger id) {
        String queryString = "SELECT c.className, c.start, c.end, c.sourceFile, c.sourcePath FROM BUG_INSTANCE a JOIN BUG_INSTANCE_CLASS b ON a.bugInstanceId = b.bugInstanceId JOIN SOURCE_LINE c ON b.bugInstanceClassId = c.bugInstanceClassId WHERE a.bugInstanceId = '" + id + "'";
        Query query = em.createNativeQuery(queryString);
        try {
            return (BugInstanceSourceLineDescription)query.unwrap(org.hibernate.Query.class ).setResultTransformer(Transformers.aliasToBean(BugInstanceSourceLineDescription.class)).list().get(0);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public BugInstanceFieldDescription loadBugInstanceFieldDescription(BigInteger id) {
        String queryString = "SELECT b.className, b.fieldName, b.signature, b.isStatic FROM BUG_INSTANCE a JOIN BUG_INSTANCE_FIELD b ON a.bugInstanceId = b.bugInstanceId WHERE a.bugInstanceId = '" + id + "'";
        Query query = em.createNativeQuery(queryString);
        try {
            return (BugInstanceFieldDescription) query.unwrap(org.hibernate.Query.class ).setResultTransformer(Transformers.aliasToBean(BugInstanceFieldDescription.class)).list().get(0);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public BugInstanceSourceLineDescription loadBugInstanceFieldSourceLineDescription(BigInteger id) {
        String queryString = "SELECT c.className, c.start, c.end, c.sourceFile, c.sourcePath FROM BUG_INSTANCE a JOIN BUG_INSTANCE_FIELD b ON a.bugInstanceId = b.bugInstanceId JOIN SOURCE_LINE c ON b.bugInstanceFieldId = c.bugInstanceFieldId WHERE a.bugInstanceId = '" + id + "'";
        Query query = em.createNativeQuery(queryString);
        try {
            return (BugInstanceSourceLineDescription) query.unwrap(org.hibernate.Query.class ).setResultTransformer(Transformers.aliasToBean(BugInstanceSourceLineDescription.class)).list().get(0);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public BugInstanceIntDescription loadBugInstanceIntDescription(BigInteger id) {
        String queryString = "SELECT b.intValue, b.intRole FROM BUG_INSTANCE a JOIN BUG_INSTANCE_INT b ON a.bugInstanceId = b.bugInstanceId WHERE a.bugInstanceId = '" + id + "'";
        Query query = em.createNativeQuery(queryString);
        try {
            return (BugInstanceIntDescription) query.unwrap(org.hibernate.Query.class ).setResultTransformer(Transformers.aliasToBean(BugInstanceIntDescription.class)).list().get(0);
        }catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public BugInstanceLocalVariableDescription loadBugInstanceLocalVariableDescription(BigInteger id) {
        String queryString = "SELECT b.localVariableName, b.register, b.pc, b.localVariableRole FROM BUG_INSTANCE a JOIN BUG_INSTANCE_LOCAL_VARIABLE b ON a.bugInstanceId = b.bugInstanceId WHERE a.bugInstanceId = '" + id + "'";
        Query query = em.createNativeQuery(queryString);
        try {
            return (BugInstanceLocalVariableDescription) query.unwrap(org.hibernate.Query.class ).setResultTransformer(Transformers.aliasToBean(BugInstanceLocalVariableDescription.class)).list().get(0);
        }catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public BugInstanceMethodDescription loadBugInstanceMethodDescription(BigInteger id) {
        String queryString = "SELECT b.className, b.methodName, b.signature, b.isStatic FROM BUG_INSTANCE a JOIN BUG_INSTANCE_METHOD b ON a.bugInstanceId = b.bugInstanceId WHERE a.bugInstanceId = '" + id + "'";
        Query query = em.createNativeQuery(queryString);
        try {
            return (BugInstanceMethodDescription) query.unwrap(org.hibernate.Query.class ).setResultTransformer(Transformers.aliasToBean(BugInstanceMethodDescription.class)).list().get(0);
        }catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public BugInstanceSourceLineDescription loadBugInstanceMethodSourceLineDescription(BigInteger id) {
        String queryString = "SELECT c.className, c.start, c.end, c.sourceFile, c.sourcePath FROM BUG_INSTANCE a JOIN BUG_INSTANCE_METHOD b ON a.bugInstanceId = b.bugInstanceId JOIN SOURCE_LINE c ON b.bugInstanceMethodId = c.bugInstanceMethodId WHERE a.bugInstanceId = '" + id + "'";
        Query query = em.createNativeQuery(queryString);
        try {
            return (BugInstanceSourceLineDescription) query.unwrap(org.hibernate.Query.class ).setResultTransformer(Transformers.aliasToBean(BugInstanceSourceLineDescription.class)).list().get(0);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public BugInstancePropertyDescripiton loadBugInstancePropertyDescription(BigInteger id) {
        String queryString = "SELECT b.propertyName, b.propertyValue FROM BUG_INSTANCE a JOIN BUG_INSTANCE_PROPERTY b ON a.bugInstanceId = b.bugInstanceId WHERE a.bugInstanceId = '" + id + "'";
        Query query = em.createNativeQuery(queryString);
        try {
            return (BugInstancePropertyDescripiton) query.unwrap(org.hibernate.Query.class ).setResultTransformer(Transformers.aliasToBean(BugInstancePropertyDescripiton.class)).list().get(0);
        }catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public BugInstanceSourceLineDescription loadBugInstanceSourceLineDescription(BigInteger id) {
        String queryString = "SELECT b.className, b.start, b.end, b.sourceFile, b.sourcePath FROM BUG_INSTANCE a JOIN SOURCE_LINE b ON a.bugInstanceId = b.bugInstanceId WHERE a.bugInstanceId = '" + id + "'";
        Query query = em.createNativeQuery(queryString);
        try {
            return (BugInstanceSourceLineDescription) query.unwrap(org.hibernate.Query.class ).setResultTransformer(Transformers.aliasToBean(BugInstanceSourceLineDescription.class)).list().get(0);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public BugInstanceStringDescription loadBugInstanceStringDescription(BigInteger id) {
        String queryString = "SELECT b.stringValue, b.stringRole FROM BUG_INSTANCE a JOIN BUG_INSTANCE_STRING b ON a.bugInstanceId = b.bugInstanceId WHERE a.bugInstanceId = '" + id + "'";
        Query query = em.createNativeQuery(queryString);
        try {
            return (BugInstanceStringDescription) query.unwrap(org.hibernate.Query.class ).setResultTransformer(Transformers.aliasToBean(BugInstanceStringDescription.class)).list().get(0);
        }catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public BugInstanceTypeDescription loadBugInstanceTypeDescription(BigInteger id) {
        String queryString = "SELECT b.descriptor, b.role, b.typeParameters FROM BUG_INSTANCE a JOIN BUG_INSTANCE_TYPE b ON a.bugInstanceId = b.bugInstanceId WHERE a.bugInstanceId = '" + id + "'";
        Query query = em.createNativeQuery(queryString);
        try {
            return (BugInstanceTypeDescription) query.unwrap(org.hibernate.Query.class ).setResultTransformer(Transformers.aliasToBean(BugInstanceTypeDescription.class)).list().get(0);
        }catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public BugInstanceSourceLineDescription loadBugInstanceTypeSourceLineDescription(BigInteger id) {
        String queryString = "SELECT c.className, c.start, c.end, c.sourceFile, c.sourcePath FROM BUG_INSTANCE a JOIN BUG_INSTANCE_TYPE b ON a.bugInstanceId = b.bugInstanceId JOIN SOURCE_LINE c ON b.bugInstanceTypeId = c.bugInstanceTypeId WHERE a.bugInstanceId = '" + id + "'";
        Query query = em.createNativeQuery(queryString);
        try {
            return (BugInstanceSourceLineDescription) query.unwrap(org.hibernate.Query.class ).setResultTransformer(Transformers.aliasToBean(BugInstanceSourceLineDescription.class)).list().get(0);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }
}
