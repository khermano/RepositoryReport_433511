package input.findbugs.report.bugInstance;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FindBugsBugInstanceField.class)
public abstract class FindBugsBugInstanceField_ {

	public static volatile SingularAttribute<FindBugsBugInstanceField, Boolean> isStatic;
	public static volatile SingularAttribute<FindBugsBugInstanceField, String> fieldName;
	public static volatile SingularAttribute<FindBugsBugInstanceField, String> signature;
	public static volatile SingularAttribute<FindBugsBugInstanceField, Long> bugInstanceFieldId;
	public static volatile SingularAttribute<FindBugsBugInstanceField, String> className;
	public static volatile ListAttribute<FindBugsBugInstanceField, FindBugsBugInstanceSourceLine> sourceLineList;

}

