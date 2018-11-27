package FindBugsPackage.ReportPackage;

import FindBugsPackage.ReportPackage.BugInstancePackage.FindBugsBugInstanceClass;
import FindBugsPackage.ReportPackage.BugInstancePackage.FindBugsBugInstanceField;
import FindBugsPackage.ReportPackage.BugInstancePackage.FindBugsBugInstanceInt;
import FindBugsPackage.ReportPackage.BugInstancePackage.FindBugsBugInstanceLocalVariable;
import FindBugsPackage.ReportPackage.BugInstancePackage.FindBugsBugInstanceMethod;
import FindBugsPackage.ReportPackage.BugInstancePackage.FindBugsBugInstanceProperty;
import FindBugsPackage.ReportPackage.BugInstancePackage.FindBugsBugInstanceSourceLine;
import FindBugsPackage.ReportPackage.BugInstancePackage.FindBugsBugInstanceString;
import FindBugsPackage.ReportPackage.BugInstancePackage.FindBugsBugInstanceType;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FindBugsBugInstance.class)
public abstract class FindBugsBugInstance_ {

	public static volatile SingularAttribute<FindBugsBugInstance, FindBugsBugInstanceType> bugInstanceType;
	public static volatile SingularAttribute<FindBugsBugInstance, FindBugsBugInstanceInt> bugInstanceInt;
	public static volatile SingularAttribute<FindBugsBugInstance, FindBugsBugInstanceMethod> bugInstanceMethod;
	public static volatile SingularAttribute<FindBugsBugInstance, FindBugsBugInstanceString> bugInstanceString;
	public static volatile SingularAttribute<FindBugsBugInstance, FindBugsBugInstanceClass> bugInstanceClass;
	public static volatile SingularAttribute<FindBugsBugInstance, String> type;
	public static volatile SingularAttribute<FindBugsBugInstance, Byte> priority;
	public static volatile SingularAttribute<FindBugsBugInstance, FindBugsBugInstanceLocalVariable> bugInstanceLocalVariable;
	public static volatile SingularAttribute<FindBugsBugInstance, Long> bugInstanceId;
	public static volatile SingularAttribute<FindBugsBugInstance, FindBugsBugInstanceSourceLine> bugInstanceSourceLine;
	public static volatile SingularAttribute<FindBugsBugInstance, Integer> rank;
	public static volatile SingularAttribute<FindBugsBugInstance, String> abbrev;
	public static volatile SingularAttribute<FindBugsBugInstance, String> category;
	public static volatile SingularAttribute<FindBugsBugInstance, FindBugsBugInstanceField> bugInstanceField;
	public static volatile SingularAttribute<FindBugsBugInstance, FindBugsBugInstanceProperty> bugInstanceProperty;

}

