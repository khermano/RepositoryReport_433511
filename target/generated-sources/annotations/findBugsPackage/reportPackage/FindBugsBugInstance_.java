package findBugsPackage.reportPackage;

import findBugsPackage.reportPackage.bugInstancePackage.FindBugsBugInstanceClass;
import findBugsPackage.reportPackage.bugInstancePackage.FindBugsBugInstanceField;
import findBugsPackage.reportPackage.bugInstancePackage.FindBugsBugInstanceInt;
import findBugsPackage.reportPackage.bugInstancePackage.FindBugsBugInstanceLocalVariable;
import findBugsPackage.reportPackage.bugInstancePackage.FindBugsBugInstanceMethod;
import findBugsPackage.reportPackage.bugInstancePackage.FindBugsBugInstanceProperty;
import findBugsPackage.reportPackage.bugInstancePackage.FindBugsBugInstanceSourceLine;
import findBugsPackage.reportPackage.bugInstancePackage.FindBugsBugInstanceString;
import findBugsPackage.reportPackage.bugInstancePackage.FindBugsBugInstanceType;
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

