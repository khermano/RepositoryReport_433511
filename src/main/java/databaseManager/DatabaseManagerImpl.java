package databaseManager;

import input.checkstyle.CheckstyleFile;
import input.findbugs.report.bugInstance.*;
import input.findbugs.report.FindBugsBugInstance;
import output.entities.*;
import org.hibernate.transform.Transformers;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigInteger;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.List;

@Stateless
public class DatabaseManagerImpl implements DatabaseManager {

    @PersistenceContext(unitName = "testPersistenceUnit")
    private EntityManager em;

    public static final String ALL_CHECKSTYLE_ERRORS_QUERY = "SELECT e.errorId, e.classLine, e.classColumn, e.errorMessage, e.errorSeverity, e.checkSource, f.fileName FROM CHECKSTYLE_ERRORS e JOIN CHECKSTYLE_FILES f ON e.fileId = f.fileId";
    public static final String LOCAL_VARIABLE_NAME_CHECKSTYLE_ERRORS_QUERY = ALL_CHECKSTYLE_ERRORS_QUERY + " WHERE e.checkSource LIKE '%LocalVariableNameCheck'";
    public static final String MEMBER_NAME_CHECKSTYLE_ERRORS_QUERY = ALL_CHECKSTYLE_ERRORS_QUERY + " WHERE e.checkSource LIKE '%MemberNameCheck'";
    public static final String ABSTRACT_CLASS_NAME_CHECKSTYLE_ERRORS_QUERY = ALL_CHECKSTYLE_ERRORS_QUERY + " WHERE e.checkSource LIKE '%AbstractClassNameCheck'";
    public static final String CONSTANT_NAME_CHECKSTYLE_ERRORS_QUERY = ALL_CHECKSTYLE_ERRORS_QUERY + " WHERE e.checkSource LIKE '%ConstantNameCheck'";
    public static final String STATIC_VARIABLE_NAME_CHECKSTYLE_ERRORS_QUERY = ALL_CHECKSTYLE_ERRORS_QUERY + " WHERE e.checkSource LIKE '%StaticVariableNameCheck'";
    public static final String JAVADOC_METHOD_CHECKSTYLE_ERRORS_QUERY = ALL_CHECKSTYLE_ERRORS_QUERY + " WHERE e.checkSource LIKE '%JavadocMethodCheck'";
    public static final String JAVADOC_TYPE_CHECKSTYLE_ERRORS_QUERY = ALL_CHECKSTYLE_ERRORS_QUERY + " WHERE e.checkSource LIKE '%JavadocTypeCheck'";
    public static final String JAVADOC_VARIABLE_CHECKSTYLE_ERRORS_QUERY = ALL_CHECKSTYLE_ERRORS_QUERY + " WHERE e.checkSource LIKE '%JavadocVariableCheck'";
    public static final String EMPTY_LINE_SEPARATOR_CHECKSTYLE_ERRORS_QUERY = ALL_CHECKSTYLE_ERRORS_QUERY + " WHERE e.checkSource LIKE '%EmptyLineSeparatorCheck'";
    public static final String METHOD_PARAM_PAD_CHECKSTYLE_ERRORS_QUERY = ALL_CHECKSTYLE_ERRORS_QUERY + " WHERE e.checkSource LIKE '%MethodParamPadCheck'";
    public static final String NO_LINE_WRAP_CHECKSTYLE_ERRORS_QUERY = ALL_CHECKSTYLE_ERRORS_QUERY + " WHERE e.checkSource LIKE '%NoLineWrapCheck'";
    public static final String SINGLE_SPACE_SEPARATOR_CHECKSTYLE_ERRORS_QUERY = ALL_CHECKSTYLE_ERRORS_QUERY + " WHERE e.checkSource LIKE '%SingleSpaceSeparatorCheck'";
    public static final String GENERIC_WHITESPACE_CHECKSTYLE_ERRORS_QUERY = ALL_CHECKSTYLE_ERRORS_QUERY + " WHERE e.checkSource LIKE '%GenericWhitespaceCheck'";
    public static final String OPERATOR_WRAP_CHECKSTYLE_ERRORS_QUERY = ALL_CHECKSTYLE_ERRORS_QUERY + " WHERE e.checkSource LIKE '%OperatorWrapCheck'";
    public static final String WHITESPACE_AROUND_CHECKSTYLE_ERRORS_QUERY = ALL_CHECKSTYLE_ERRORS_QUERY + " WHERE e.checkSource LIKE '%WhitespaceAroundCheck'";

    public static final String ALL_FINDBUGS_ERRORS_QUERY = "SELECT bugInstanceId, type, priority, rank, abbrev, category FROM BUG_INSTANCE";
    public static final String PRIORITY_1_FINDBUGS_ERRORS_QUERY = ALL_FINDBUGS_ERRORS_QUERY + " WHERE priority = '1'";
    public static final String PRIORITY_2_FINDBUGS_ERRORS_QUERY = ALL_FINDBUGS_ERRORS_QUERY + " WHERE priority = '2'";
    public static final String PRIORITY_3_FINDBUGS_ERRORS_QUERY = ALL_FINDBUGS_ERRORS_QUERY + " WHERE priority = '3'";
    public static final String RANK_SCARIEST_FINDBUGS_ERRORS_QUERY = ALL_FINDBUGS_ERRORS_QUERY + " WHERE rank BETWEEN '1' AND '4'";
    public static final String RANK_SCARY_FINDBUGS_ERRORS_QUERY = ALL_FINDBUGS_ERRORS_QUERY + " WHERE rank BETWEEN '5' AND '9'";
    public static final String RANK_TROUBLING_FINDBUGS_ERRORS_QUERY = ALL_FINDBUGS_ERRORS_QUERY + " WHERE rank BETWEEN '10' AND '14'";
    public static final String RANK_CONCERN_BUGS_FINDBUGS_ERRORS_QUERY = ALL_FINDBUGS_ERRORS_QUERY + " WHERE rank BETWEEN '15' AND '20'";
    public static final String CATEGORY_CORRECTNESS_FINDBUGS_ERRORS_QUERY = ALL_FINDBUGS_ERRORS_QUERY + " WHERE category = 'CORRECTNESS'";
    public static final String CATEGORY_BAD_PRACTICE_FINDBUGS_ERRORS_QUERY = ALL_FINDBUGS_ERRORS_QUERY + " WHERE category = 'BAD_PRACTICE'";
    public static final String CATEGORY_STYLE_FINDBUGS_ERRORS_QUERY = ALL_FINDBUGS_ERRORS_QUERY + " WHERE category = 'STYLE'";
    public static final String CATEGORY_MT_CORRECTNESS_FINDBUGS_ERRORS_QUERY = ALL_FINDBUGS_ERRORS_QUERY + " WHERE category = 'MT_CORRECTNESS'";
    public static final String CATEGORY_MALICIOUS_CODE_FINDBUGS_ERRORS_QUERY = ALL_FINDBUGS_ERRORS_QUERY + " WHERE category = 'MALICIOUS_CODE'";
    public static final String CATEGORY_PERFORMANCE_FINDBUGS_ERRORS_QUERY = ALL_FINDBUGS_ERRORS_QUERY + " WHERE category = 'PERFORMANCE'";
    public static final String CATEGORY_I18N_FINDBUGS_ERRORS_QUERY = ALL_FINDBUGS_ERRORS_QUERY + " WHERE category = 'I18N'";


    public void addFiles(List<CheckstyleFile> files) {
        if (files!=null) {
            for (Iterator<CheckstyleFile> it = files.iterator(); it.hasNext(); ) {

                CheckstyleFile file = it.next();
                em.persist(file);
            }
        }
    }

    public void addBugInstances(List<FindBugsBugInstance> bugInstances) {
        if (bugInstances!=null) {
            for (Iterator<FindBugsBugInstance> it = bugInstances.iterator(); it.hasNext(); ) {

                FindBugsBugInstance bugInstance = it.next();
                addBugInstance(bugInstance);
            }
        }
    }

    private void addBugInstance(FindBugsBugInstance bugInstance) {
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

    public List<CheckstyleErrorDescription> loadCheckstyleErrorDescriptions(String queryString) {
        Query query = em.createNativeQuery(queryString);
        return query.unwrap(org.hibernate.Query.class ).setResultTransformer(Transformers.aliasToBean(CheckstyleErrorDescription.class)).list();
    }

    public List<BugInstanceDescription> loadBugInstances(String queryString) {
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

    public void cleanTables() {
        Query checkstyleCountQuery = em.createNativeQuery("SELECT COUNT(fileId) FROM CHECKSTYLE_FILES");
        Query findbugsCountQuery = em.createNativeQuery("SELECT COUNT(bugInstanceId) FROM BUG_INSTANCE");

        if (BigInteger.valueOf(0).compareTo((BigInteger)checkstyleCountQuery.unwrap(org.hibernate.Query.class).list().get(0)) == -1) {
            Query deleteCheckstyleErrorsData = em.createNativeQuery("DELETE FROM CHECKSTYLE_ERRORS");
            deleteCheckstyleErrorsData.unwrap(org.hibernate.Query.class).executeUpdate();

            Query deleteCheckstyleFilesData = em.createNativeQuery("DELETE FROM CHECKSTYLE_FILES");
            deleteCheckstyleFilesData.unwrap(org.hibernate.Query.class).executeUpdate();
        }
        if (BigInteger.valueOf(0).compareTo((BigInteger)findbugsCountQuery.unwrap(org.hibernate.Query.class).list().get(0)) == -1) {
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
