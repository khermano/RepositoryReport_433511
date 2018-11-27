package FindBugsPackage.ReportPackage.BugInstancePackage;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FindBugsBugInstanceMethod.class)
public abstract class FindBugsBugInstanceMethod_ {

	public static volatile SingularAttribute<FindBugsBugInstanceMethod, Boolean> isStatic;
	public static volatile SingularAttribute<FindBugsBugInstanceMethod, String> signature;
	public static volatile ListAttribute<FindBugsBugInstanceMethod, FindBugsBugInstanceSourceLine> sourceLines;
	public static volatile SingularAttribute<FindBugsBugInstanceMethod, String> methodName;
	public static volatile SingularAttribute<FindBugsBugInstanceMethod, String> className;
	public static volatile SingularAttribute<FindBugsBugInstanceMethod, Long> bugInstanceMethodId;

}

