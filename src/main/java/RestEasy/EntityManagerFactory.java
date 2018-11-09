package RestEasy;

import Checkstyle.CheckstyleError;

import javax.ejb.Local;

@Local
public interface EntityManagerFactory {

    void add(CheckstyleError error);

    CheckstyleError get(Long id);
}
