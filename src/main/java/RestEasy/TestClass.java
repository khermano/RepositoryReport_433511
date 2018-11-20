package RestEasy;

import Checkstyle.CheckstyleError;
import Checkstyle.CheckstyleReport;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

@Stateless
@Path("test")
public class TestClass {

    @EJB
    private EntityManagerFactory emf;

    private CheckstyleError error;


    @GET
    @Path("/testError")
    public String returnError() {
        error = new CheckstyleError((byte)0, (byte)0, "testMessage", "ignore", "testSource"/*, "testFile"*/);
        emf.addError(error);
        Long id = error.getErrorId();
        CheckstyleError error2 = emf.getError(id);
        return error2.toString();
    }

    @GET
    @Path("/testErrorFromXml")
    public String returnErrorFromXml() throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(CheckstyleReport.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        CheckstyleReport report = (CheckstyleReport) unmarshaller.unmarshal(new File("/home/khermano/Devel/RepositoryReport_433511/src/main/resources/input.xml"));

        emf.addFile(report.getFileList().get(0));
        emf.addError(report.getFileList().get(0).getErrorList().get(0));
        emf.addError(report.getFileList().get(0).getErrorList().get(1));
        CheckstyleError error = emf.getError(report.getFileList().get(0).getErrorList().get(0).getErrorId());
        CheckstyleError error2 = emf.getError(report.getFileList().get(0).getErrorList().get(1).getErrorId());
        return error.toString() + "    *******    " + error2.toString();
    }

    @GET
    @Path("/testErrorFromXml2")
    public String returnErrorFromXml2() throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(CheckstyleReport.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        CheckstyleReport report = (CheckstyleReport) unmarshaller.unmarshal(new File("/home/khermano/BachelorThesis4/CheckstyleReport.xml")); //nezabudni zmenit cestu na /tmp

        emf.addFiles(report.getFileList());
        List<ErrorDescription> errorDescriptions = emf.loadUserDescriptions();
        return errorDescriptions.get(0).toString();
    }


//    public void main(String[] args) throws IOException {
//        System.out.println("Insert url of Git repository:");
//        String url = Integer.toString(System.in.read());
//        String script = "/home/khermano/BackUp/MyNewScript.sh"; //do not forget change name and path to your new script
//        Runtime.getRuntime().exec(script); //check checkstyle report !!!
//    }
}
