package input.findbugs.report;

import input.findbugs.report.bugInstance.FindBugsBugInstanceClass;
import input.findbugs.report.bugInstance.FindBugsBugInstanceField;
import input.findbugs.report.bugInstance.FindBugsBugInstanceInt;
import input.findbugs.report.bugInstance.FindBugsBugInstanceLocalVariable;
import input.findbugs.report.bugInstance.FindBugsBugInstanceMethod;
import input.findbugs.report.bugInstance.FindBugsBugInstanceProperty;
import input.findbugs.report.bugInstance.FindBugsBugInstanceSourceLine;
import input.findbugs.report.bugInstance.FindBugsBugInstanceString;
import input.findbugs.report.bugInstance.FindBugsBugInstanceType;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FindBugsBugInstance.class)
public abstract class FindBugsBugInstance_ {

	public static volatile ListAttribute<FindBugsBugInstance, FindBugsBugInstanceField> bugInstanceFieldList;
	public static volatile ListAttribute<FindBugsBugInstance, FindBugsBugInstanceType> bugInstanceTypeList;
	public static volatile SingularAttribute<FindBugsBugInstance, String> type;
	public static volatile SingularAttribute<FindBugsBugInstance, Byte> priority;
	public static volatile ListAttribute<FindBugsBugInstance, FindBugsBugInstanceInt> bugInstanceIntList;
	public static volatile ListAttribute<FindBugsBugInstance, FindBugsBugInstanceString> bugInstanceStringList;
	public static volatile SingularAttribute<FindBugsBugInstance, Long> bugInstanceId;
	public static volatile ListAttribute<FindBugsBugInstance, FindBugsBugInstanceSourceLine> bugInstanceSourceLineList;
	public static volatile ListAttribute<FindBugsBugInstance, FindBugsBugInstanceLocalVariable> bugInstanceLocalVariableList;
	public static volatile SingularAttribute<FindBugsBugInstance, Integer> rank;
	public static volatile ListAttribute<FindBugsBugInstance, FindBugsBugInstanceProperty> bugInstancePropertyList;
	public static volatile SingularAttribute<FindBugsBugInstance, String> abbrev;
	public static volatile SingularAttribute<FindBugsBugInstance, String> category;
	public static volatile ListAttribute<FindBugsBugInstance, FindBugsBugInstanceMethod> bugInstanceMethodList;
	public static volatile ListAttribute<FindBugsBugInstance, FindBugsBugInstanceClass> bugInstanceClassList;

}

