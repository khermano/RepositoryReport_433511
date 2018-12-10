package databaseManager;

import input.findbugs.report.bugInstance.FindBugsBugInstanceClass;
import input.findbugs.report.bugInstance.FindBugsBugInstanceField;
import input.findbugs.report.bugInstance.FindBugsBugInstanceInt;
import input.findbugs.report.bugInstance.FindBugsBugInstanceLocalVariable;
import input.findbugs.report.bugInstance.FindBugsBugInstanceMethod;
import input.findbugs.report.bugInstance.FindBugsBugInstanceProperty;
import input.findbugs.report.bugInstance.FindBugsBugInstanceSourceLine;
import input.findbugs.report.bugInstance.FindBugsBugInstanceString;
import input.findbugs.report.bugInstance.FindBugsBugInstanceType;
import input.findbugs.report.FindBugsBugInstance;
import output.entities.BugInstanceDescription;
import output.entities.BugInstanceClassDescription;
import output.entities.BugInstanceSourceLineDescription;
import output.entities.BugInstanceFieldDescription;
import output.entities.BugInstanceIntDescription;
import output.entities.BugInstanceLocalVariableDescription;
import output.entities.BugInstanceMethodDescription;
import output.entities.BugInstancePropertyDescripiton;
import output.entities.BugInstanceStringDescription;
import output.entities.BugInstanceTypeDescription;
import org.hibernate.transform.Transformers;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.List;

@Stateless
public class FindBugsDatabaseManagerImpl implements FindBugsDatabaseManager {

    @PersistenceContext(unitName = "testPersistenceUnit")
    private EntityManager em;


    public void addBugInstances(List<FindBugsBugInstance> bugInstances) {
        cleanTables();
        if (bugInstances!=null) {
            for (FindBugsBugInstance bugInstance: bugInstances) {
                addBugInstance(bugInstance);
            }
        }
    }

    private void addBugInstance(FindBugsBugInstance bugInstance) {
        em.persist(bugInstance);

        if (bugInstance.getBugInstanceClassList()!= null) {
            for (FindBugsBugInstanceClass bugInstanceClass: bugInstance.getBugInstanceClassList()) {
                addBugInstanceClass(bugInstanceClass);
            }
        }

        if (bugInstance.getBugInstanceFieldList()!= null) {
            for (FindBugsBugInstanceField bugInstanceField: bugInstance.getBugInstanceFieldList()) {
                addBugInstanceField(bugInstanceField);
            }
        }

        if (bugInstance.getBugInstanceIntList()!= null) {
            for(FindBugsBugInstanceInt bugInstanceInt: bugInstance.getBugInstanceIntList()) {
                em.persist(bugInstanceInt);
            }
        }

        if (bugInstance.getBugInstanceLocalVariableList()!= null) {
            for (FindBugsBugInstanceLocalVariable bugInstanceLocalVariable: bugInstance.getBugInstanceLocalVariableList()) {
                em.persist(bugInstanceLocalVariable);
            }
        }

        if (bugInstance.getBugInstanceMethodList()!= null) {
            for (FindBugsBugInstanceMethod bugInstanceMethod:bugInstance.getBugInstanceMethodList()) {
                addBugInstanceMethod(bugInstanceMethod);
            }
        }

        if (bugInstance.getBugInstancePropertyList()!= null) {
            for (FindBugsBugInstanceProperty bugInstanceProperty: bugInstance.getBugInstancePropertyList()) {
                em.persist(bugInstanceProperty);
            }
        }

        if (bugInstance.getBugInstanceSourceLineList()!= null) {
            for (FindBugsBugInstanceSourceLine bugInstanceSourceLine: bugInstance.getBugInstanceSourceLineList()) {
                em.persist(bugInstanceSourceLine);
            }
        }

        if (bugInstance.getBugInstanceStringList()!= null) {
            for (FindBugsBugInstanceString bugInstanceString: bugInstance.getBugInstanceStringList()) {
                em.persist(bugInstanceString);
            }
        }

        if (bugInstance.getBugInstanceTypeList()!= null) {
            for (FindBugsBugInstanceType bugInstanceType: bugInstance.getBugInstanceTypeList()) {
                addBugInstanceType(bugInstanceType);
            }
        }
    }

    private void addBugInstanceClass(FindBugsBugInstanceClass bugInstanceClass) {
        em.persist(bugInstanceClass);

        if (bugInstanceClass.getSourceLineList()!=null) {
            for (FindBugsBugInstanceSourceLine bugInstanceSourceLine: bugInstanceClass.getSourceLineList()) {
                em.persist(bugInstanceSourceLine);
            }
        }
    }

    private void addBugInstanceField(FindBugsBugInstanceField bugInstanceField) {
        em.persist(bugInstanceField);

        if (bugInstanceField.getSourceLineList()!=null) {
            for (FindBugsBugInstanceSourceLine bugInstanceSourceLine : bugInstanceField.getSourceLineList()) {
                em.persist(bugInstanceSourceLine);
            }
        }
    }

    private void addBugInstanceMethod(FindBugsBugInstanceMethod bugInstanceMethod) {
        em.persist(bugInstanceMethod);

        if (bugInstanceMethod.getSourceLineList()!=null) {
            for (FindBugsBugInstanceSourceLine bugInstanceSourceLine: bugInstanceMethod.getSourceLineList()) {
                em.persist(bugInstanceSourceLine);
            }
        }
    }

    private void addBugInstanceType(FindBugsBugInstanceType bugInstanceType) {
        em.persist(bugInstanceType);

        if (bugInstanceType.getSourceLineList()!=null) {
            for (FindBugsBugInstanceSourceLine bugInstanceSourceLine: bugInstanceType.getSourceLineList()) {
                em.persist(bugInstanceSourceLine);
            }
        }
    }

    @SuppressWarnings(value = "unchecked")
    public List<BugInstanceDescription> loadBugInstances(String queryString) {
        Query query = em.createNativeQuery(queryString);
        return query.unwrap(org.hibernate.Query.class ).setResultTransformer(
                Transformers.aliasToBean(BugInstanceDescription.class)).list();
    }

    public BugInstanceClassDescription loadBugInstanceClassDescription(BigInteger id) {
        String queryString = "SELECT b.className FROM BUG_INSTANCE a JOIN BUG_INSTANCE_CLASS b ON "
                + "a.bugInstanceId = b.bugInstanceId WHERE a.bugInstanceId = '" + id + "'";
        Query query = em.createNativeQuery(queryString);
        try {
            return (BugInstanceClassDescription)query.unwrap(org.hibernate.Query.class).setResultTransformer(
                    Transformers.aliasToBean(BugInstanceClassDescription.class)).list().get(0);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public BugInstanceSourceLineDescription loadBugInstanceClassSourceLineDescription(BigInteger id) {
        String queryString = "SELECT c.className, c.start, c.end, c.sourceFile, c.sourcePath FROM BUG_INSTANCE a "
                + "JOIN BUG_INSTANCE_CLASS b ON a.bugInstanceId = b.bugInstanceId JOIN SOURCE_LINE c ON "
                + "b.bugInstanceClassId = c.bugInstanceClassId WHERE a.bugInstanceId = '" + id + "'";
        Query query = em.createNativeQuery(queryString);
        try {
            return (BugInstanceSourceLineDescription)query.unwrap(org.hibernate.Query.class).setResultTransformer(
                    Transformers.aliasToBean(BugInstanceSourceLineDescription.class)).list().get(0);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public BugInstanceFieldDescription loadBugInstanceFieldDescription(BigInteger id) {
        String queryString = "SELECT b.className, b.fieldName, b.signature, b.isStatic FROM BUG_INSTANCE a "
                + "JOIN BUG_INSTANCE_FIELD b ON a.bugInstanceId = b.bugInstanceId WHERE a.bugInstanceId = '" + id + "'";
        Query query = em.createNativeQuery(queryString);
        try {
            return (BugInstanceFieldDescription) query.unwrap(org.hibernate.Query.class).setResultTransformer(
                    Transformers.aliasToBean(BugInstanceFieldDescription.class)).list().get(0);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public BugInstanceSourceLineDescription loadBugInstanceFieldSourceLineDescription(BigInteger id) {
        String queryString = "SELECT c.className, c.start, c.end, c.sourceFile, c.sourcePath FROM BUG_INSTANCE a "
                + "JOIN BUG_INSTANCE_FIELD b ON a.bugInstanceId = b.bugInstanceId JOIN SOURCE_LINE c ON "
                + "b.bugInstanceFieldId = c.bugInstanceFieldId WHERE a.bugInstanceId = '" + id + "'";
        Query query = em.createNativeQuery(queryString);
        try {
            return (BugInstanceSourceLineDescription) query.unwrap(org.hibernate.Query.class).setResultTransformer(
                    Transformers.aliasToBean(BugInstanceSourceLineDescription.class)).list().get(0);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public BugInstanceIntDescription loadBugInstanceIntDescription(BigInteger id) {
        String queryString = "SELECT b.intValue, b.intRole FROM BUG_INSTANCE a JOIN BUG_INSTANCE_INT b "
                + "ON a.bugInstanceId = b.bugInstanceId WHERE a.bugInstanceId = '" + id + "'";
        Query query = em.createNativeQuery(queryString);
        try {
            return (BugInstanceIntDescription) query.unwrap(org.hibernate.Query.class).setResultTransformer(
                    Transformers.aliasToBean(BugInstanceIntDescription.class)).list().get(0);
        }catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public BugInstanceLocalVariableDescription loadBugInstanceLocalVariableDescription(BigInteger id) {
        String queryString = "SELECT b.localVariableName, b.register, b.pc, b.localVariableRole FROM BUG_INSTANCE a "
                + "JOIN BUG_INSTANCE_LOCAL_VARIABLE b ON a.bugInstanceId = b.bugInstanceId WHERE a.bugInstanceId = '" + id + "'";
        Query query = em.createNativeQuery(queryString);
        try {
            return (BugInstanceLocalVariableDescription) query.unwrap(org.hibernate.Query.class ).setResultTransformer(
                    Transformers.aliasToBean(BugInstanceLocalVariableDescription.class)).list().get(0);
        }catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public BugInstanceMethodDescription loadBugInstanceMethodDescription(BigInteger id) {
        String queryString = "SELECT b.className, b.methodName, b.signature, b.isStatic FROM BUG_INSTANCE a "
                + "JOIN BUG_INSTANCE_METHOD b ON a.bugInstanceId = b.bugInstanceId WHERE a.bugInstanceId = '" + id + "'";
        Query query = em.createNativeQuery(queryString);
        try {
            return (BugInstanceMethodDescription) query.unwrap(org.hibernate.Query.class ).setResultTransformer(
                    Transformers.aliasToBean(BugInstanceMethodDescription.class)).list().get(0);
        }catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public BugInstanceSourceLineDescription loadBugInstanceMethodSourceLineDescription(BigInteger id) {
        String queryString = "SELECT c.className, c.start, c.end, c.sourceFile, c.sourcePath FROM BUG_INSTANCE a "
                + "JOIN BUG_INSTANCE_METHOD b ON a.bugInstanceId = b.bugInstanceId JOIN SOURCE_LINE c "
                + "ON b.bugInstanceMethodId = c.bugInstanceMethodId WHERE a.bugInstanceId = '" + id + "'";
        Query query = em.createNativeQuery(queryString);
        try {
            return (BugInstanceSourceLineDescription) query.unwrap(org.hibernate.Query.class ).setResultTransformer(
                    Transformers.aliasToBean(BugInstanceSourceLineDescription.class)).list().get(0);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public BugInstancePropertyDescripiton loadBugInstancePropertyDescription(BigInteger id) {
        String queryString = "SELECT b.propertyName, b.propertyValue FROM BUG_INSTANCE a JOIN BUG_INSTANCE_PROPERTY b "
                + "ON a.bugInstanceId = b.bugInstanceId WHERE a.bugInstanceId = '" + id + "'";
        Query query = em.createNativeQuery(queryString);
        try {
            return (BugInstancePropertyDescripiton) query.unwrap(org.hibernate.Query.class ).setResultTransformer(
                    Transformers.aliasToBean(BugInstancePropertyDescripiton.class)).list().get(0);
        }catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public BugInstanceSourceLineDescription loadBugInstanceSourceLineDescription(BigInteger id) {
        String queryString = "SELECT b.className, b.start, b.end, b.sourceFile, b.sourcePath FROM BUG_INSTANCE a "
        + "JOIN SOURCE_LINE b ON a.bugInstanceId = b.bugInstanceId WHERE a.bugInstanceId = '" + id + "'";
        Query query = em.createNativeQuery(queryString);
        try {
            return (BugInstanceSourceLineDescription) query.unwrap(org.hibernate.Query.class ).setResultTransformer(
                    Transformers.aliasToBean(BugInstanceSourceLineDescription.class)).list().get(0);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public BugInstanceStringDescription loadBugInstanceStringDescription(BigInteger id) {
        String queryString = "SELECT b.stringValue, b.stringRole FROM BUG_INSTANCE a JOIN BUG_INSTANCE_STRING b "
        + "ON a.bugInstanceId = b.bugInstanceId WHERE a.bugInstanceId = '" + id + "'";
        Query query = em.createNativeQuery(queryString);
        try {
            return (BugInstanceStringDescription) query.unwrap(org.hibernate.Query.class ).setResultTransformer(
                    Transformers.aliasToBean(BugInstanceStringDescription.class)).list().get(0);
        }catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public BugInstanceTypeDescription loadBugInstanceTypeDescription(BigInteger id) {
        String queryString = "SELECT b.descriptor, b.role, b.typeParameters FROM BUG_INSTANCE a "
        + "JOIN BUG_INSTANCE_TYPE b ON a.bugInstanceId = b.bugInstanceId WHERE a.bugInstanceId = '" + id + "'";
        Query query = em.createNativeQuery(queryString);
        try {
            return (BugInstanceTypeDescription) query.unwrap(org.hibernate.Query.class ).setResultTransformer(
                    Transformers.aliasToBean(BugInstanceTypeDescription.class)).list().get(0);
        }catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public BugInstanceSourceLineDescription loadBugInstanceTypeSourceLineDescription(BigInteger id) {
        String queryString = "SELECT c.className, c.start, c.end, c.sourceFile, c.sourcePath FROM BUG_INSTANCE a "
        + "JOIN BUG_INSTANCE_TYPE b ON a.bugInstanceId = b.bugInstanceId JOIN SOURCE_LINE c "
        + "ON b.bugInstanceTypeId = c.bugInstanceTypeId WHERE a.bugInstanceId = '" + id + "'";
        Query query = em.createNativeQuery(queryString);
        try {
            return (BugInstanceSourceLineDescription) query.unwrap(org.hibernate.Query.class ).setResultTransformer(
                    Transformers.aliasToBean(BugInstanceSourceLineDescription.class)).list().get(0);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public void cleanTables() {
        Query findbugsCountQuery = em.createNativeQuery("SELECT COUNT(bugInstanceId) FROM BUG_INSTANCE");

        if (BigInteger.valueOf(0).compareTo((BigInteger) findbugsCountQuery.unwrap(org.hibernate.Query.class).list().get(0)) < 0) {
            Query deleteSourceLineData = em.createNativeQuery("DELETE FROM SOURCE_LINE");
            deleteSourceLineData.unwrap(org.hibernate.Query.class).executeUpdate();

            Query deleteBugInstanceTypeData = em.createNativeQuery("DELETE FROM BUG_INSTANCE_TYPE");
            deleteBugInstanceTypeData.unwrap(org.hibernate.Query.class).executeUpdate();

            Query deleteBugInstanceStringData = em.createNativeQuery("DELETE FROM BUG_INSTANCE_STRING");
            deleteBugInstanceStringData.unwrap(org.hibernate.Query.class).executeUpdate();

            Query deleteBugInstancePropertyData = em.createNativeQuery("DELETE FROM BUG_INSTANCE_PROPERTY");
            deleteBugInstancePropertyData.unwrap(org.hibernate.Query.class).executeUpdate();

            Query deleteBugInstanceMethodData = em.createNativeQuery("DELETE FROM BUG_INSTANCE_METHOD");
            deleteBugInstanceMethodData.unwrap(org.hibernate.Query.class).executeUpdate();

            Query deleteBugInstanceLocalVariableData = em.createNativeQuery("DELETE FROM BUG_INSTANCE_LOCAL_VARIABLE");
            deleteBugInstanceLocalVariableData.unwrap(org.hibernate.Query.class).executeUpdate();

            Query deleteBugInstanceIntData = em.createNativeQuery("DELETE FROM BUG_INSTANCE_INT");
            deleteBugInstanceIntData.unwrap(org.hibernate.Query.class).executeUpdate();

            Query deleteBugInstanceFieldData = em.createNativeQuery("DELETE FROM BUG_INSTANCE_FIELD");
            deleteBugInstanceFieldData.unwrap(org.hibernate.Query.class).executeUpdate();

            Query deleteBugInstanceClassData = em.createNativeQuery("DELETE FROM BUG_INSTANCE_CLASS");
            deleteBugInstanceClassData.unwrap(org.hibernate.Query.class).executeUpdate();

            Query deleteBugInstanceData = em.createNativeQuery("DELETE FROM BUG_INSTANCE");
            deleteBugInstanceData.unwrap(org.hibernate.Query.class).executeUpdate();
        }
    }
}
