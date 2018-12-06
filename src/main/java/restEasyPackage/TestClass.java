package restEasyPackage;

import checkstylePackage.CheckstyleError;
import checkstylePackage.CheckstyleReport;
import findBugsPackage.FindBugsReport;
import jsf.entities.BugInstanceDescription;
import jsf.entities.CheckstyleErrorDescription;
import jsf.entityManager.DatabaseManager;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

@Stateless
@Path("test")
public class TestClass {

    @EJB
    private DatabaseManager emf;

    private CheckstyleError error;


    /*@GET
    @Path("/testError")
    public String returnError() {
        error = new CheckstyleError((byte)0, (byte)0, "testMessage", "ignore", "testSource"/*, "testFile"*///);
       /* emf.addError(error);
        Long id = error.getErrorId();
        CheckstyleError error2 = emf.getError(id);
        return error2.toString();
    }

    @GET
    @Path("/testErrorFromXml2")
    public String returnErrorFromXml2() throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(CheckstyleReport.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        CheckstyleReport report = (CheckstyleReport) unmarshaller.unmarshal(new File("/home/khermano/BachelorThesis4/CheckstyleReport.xml")); //nezabudni zmenit cestu na /tmp

        emf.addFiles(report.getFileList());
        List<CheckstyleErrorDescription> checkstyleErrorDescriptions = emf.loadCheckstyleErrorDescriptions();
        List<CheckstyleErrorDescription> checkstyleErrorDescriptionsFromTitleCheck = emf.loadCheckstyleJavadocMethodErrors();
        return "<html>" + Integer.toString(checkstyleErrorDescriptions.size())
                + "<br /> ******first error****** <br /> " + (checkstyleErrorDescriptions.size()!=0? checkstyleErrorDescriptions.get(0).toString() : "Empty set") +
                "<br /> ******first error from TitleCheck****** <br /> " +
                (checkstyleErrorDescriptionsFromTitleCheck.size()!=0 ? checkstyleErrorDescriptionsFromTitleCheck.get(0).toString() : "Empty set") + "</html>";
    }*/

   /* @GET
    @Path("/testFindBugs")
    public String testFindBugs() throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(FindBugsReport.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        FindBugsReport report = (FindBugsReport) unmarshaller.unmarshal(new File("/home/khermano/BachelorThesis4/FindBugsReport.xml"));

        emf.addBugInstances(report.getFindBugsBugInstanceList());
        return "Done";
    }

    @GET
    @Path("/testBugInstance")
    public String getBugInstanceWithPriority1() throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(FindBugsReport.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        FindBugsReport report = (FindBugsReport) unmarshaller.unmarshal(new File("/home/khermano/BachelorThesis4/FindBugsReport.xml"));

        emf.addBugInstances(report.getFindBugsBugInstanceList());
        List<BugInstanceDescription> bugInstanceDescriptionsPriority1 = emf.loadBugInstanceWithPriority1();
        List<BugInstanceDescription> bugInstanceDescriptionsRankScariest = emf.loadBugInstanceWithRankScariest();
        List<BugInstanceDescription> bugInstanceDescriptionsCategoryCorrectness = emf.loadBugInstanceWithCategoryCorrectness();
        String priority1 = "******Number of instances****** <br /> " + Integer.toString(bugInstanceDescriptionsPriority1.size()) + "<br /> ******First bug instance with priority 1****** <br /> "
                + (bugInstanceDescriptionsPriority1.size()!=0 ? bugInstanceDescriptionsPriority1.get(0).toString() : "Empty set");
        String rankScariest = "<br /> ******First bug instance with scariest rank******<br /> "
                + (bugInstanceDescriptionsRankScariest.size()!=0 ? bugInstanceDescriptionsRankScariest.get(0).toString() : "Empty set");
        String categoryCorrectness = "<br /> ******First bug instance with category correctness******<br /> "
                + (bugInstanceDescriptionsCategoryCorrectness.size()!=0 ? bugInstanceDescriptionsCategoryCorrectness.get(0).toString() : "Empty set");
        return "<html>" + priority1 + rankScariest + categoryCorrectness + "</html>";
    }

    @GET
    @Path("/home")
    public Response viewHome() {
        File f = new File("/home/khermano/Devel/RepositoryReport_433511/src/main/webapp/home.xhtml");  //zmen na relativnu cestu
        return Response.status(200).entity(f).build();
    }

   /* @GET
    @Path("/results")
    public void viewResults(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        String title = "Using GET Method to Read Form Data";
        String docType =
                "<!doctype html public \"-//w3c//dtd html 4.0 " +
                        "transitional//en\">\n";

        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor = \"#f0f0f0\">\n" +
                "<h1 align = \"center\">" + title + "</h1>\n" +
                "<ul>\n" +
                "  <li><b>Repository URL</b>: "
                + request.getParameter("repositoryURL") + "\n" +
                "</ul>\n" +
                "</body>" +
                "</html>"
        );
    }*/


//    public void main(String[] args) throws IOException {
//        System.out.println("Insert url of Git repository:");
//        String url = Integer.toString(System.in.read());
//        String script = "/home/khermano/BackUp/MyNewScript.sh"; //do not forget change name and path to your new script
//        Runtime.getRuntime().exec(script); //check checkstyle report !!!
//    }
}
