package CheckstylePackage;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CheckstyleFile.class)
public abstract class CheckstyleFile_ {

	public static volatile SingularAttribute<CheckstyleFile, String> fileName;
	public static volatile ListAttribute<CheckstyleFile, CheckstyleError> errorList;
	public static volatile SingularAttribute<CheckstyleFile, Long> fileId;

}

