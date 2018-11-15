package RestEasy;

import Checkstyle.CheckstyleError;
import Checkstyle.CheckstyleReport;
import org.jboss.logging.Logger;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

@Stateless
@Path("test")
public class TestClass {

    private static final Logger log = Logger.getLogger(TestClass.class);

    @EJB
    private EntityManagerFactory emf;

    private CheckstyleError error;


    @GET
    @Path("/testError")
    public String returnError() {
        error = new CheckstyleError((byte)0, (byte)0, "testMessage", "ignore", "testSource"/*, "testFile"*/);
        emf.add(error);
        Long id = error.getId();
        CheckstyleError error2 = emf.get(id);
        return error2.toString();
    }

    @GET
    @Path("/testErrorFromXml")
    public String returnErrorFromXml() throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(CheckstyleReport.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        CheckstyleReport report = (CheckstyleReport) unmarshaller.unmarshal(new File("/home/khermano/Devel/RepositoryReport_433511/src/main/resources/input.xml"));

        //log.info("**************MY ERROR IS: " + report.getFileList().get(0).getErrorList().get(0).toString());

        emf.add(report.getFileList().get(0).getErrorList().get(0));
        emf.add(report.getFileList().get(0).getErrorList().get(1));
        CheckstyleError error = emf.get(report.getFileList().get(0).getErrorList().get(0).getId());
        CheckstyleError error2 = emf.get(report.getFileList().get(0).getErrorList().get(1).getId());
        return error.toString() + "    *******    " + error2.toString();
    }


//    public void main(String[] args) throws IOException {
//        System.out.println("Insert url of Git repository:");
//        String url = Integer.toString(System.in.read());
//        String script = "/home/khermano/BackUp/MyNewScript.sh"; //do not forget change name and path to your new script
//        Runtime.getRuntime().exec(script); //check checkstyle report !!!
//    }
}
