package findBugsPackage.reportPackage.bugInstancePackage;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FindBugsBugInstanceType.class)
public abstract class FindBugsBugInstanceType_ {

	public static volatile SingularAttribute<FindBugsBugInstanceType, Long> bugInstanceTypeId;
	public static volatile SingularAttribute<FindBugsBugInstanceType, String> role;
	public static volatile SingularAttribute<FindBugsBugInstanceType, String> descriptor;
	public static volatile SingularAttribute<FindBugsBugInstanceType, String> typeParameters;
	public static volatile ListAttribute<FindBugsBugInstanceType, FindBugsBugInstanceSourceLine> sourceLineList;

}

