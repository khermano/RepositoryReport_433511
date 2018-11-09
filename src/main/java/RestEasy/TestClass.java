package RestEasy;

import Checkstyle.CheckstyleError;
import Checkstyle.CheckstyleSeverity;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Stateless
@Path("test")
public class TestClass {

    @EJB
    private EntityManagerFactory emf;

    private CheckstyleError error;


    @GET
    @Path("/testError")
    public String returnError() {
        error = new CheckstyleError(0, 0, "testMessage", CheckstyleSeverity.ignore, "testSource", "testFile");
        error.setId((long)1);
        emf.add(error);
        CheckstyleError error2 = emf.get((long)1);
        return error2.toString();
    }



//    public void main(String[] args) throws IOException {
//        System.out.println("Insert url of Git repository:");
//        String url = Integer.toString(System.in.read());
//        String script = "/home/khermano/BackUp/MyNewScript.sh"; //do not forget change name and path to your new script
//        Runtime.getRuntime().exec(script); //check checkstyle report !!!
//    }
}
