package CheckstylePackage;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CheckstyleError.class)
public abstract class CheckstyleError_ {

	public static volatile SingularAttribute<CheckstyleError, String> severity;
	public static volatile SingularAttribute<CheckstyleError, Byte> line;
	public static volatile SingularAttribute<CheckstyleError, Byte> column;
	public static volatile SingularAttribute<CheckstyleError, CheckstyleFile> checkstyleFile;
	public static volatile SingularAttribute<CheckstyleError, Long> errorId;
	public static volatile SingularAttribute<CheckstyleError, String> source;
	public static volatile SingularAttribute<CheckstyleError, String> message;

}

