package output.controller;

import input.checkstyle.CheckstyleReport;
import input.findbugs.FindBugsReport;
import databaseManager.DatabaseManager;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.util.Map;

@ManagedBean(name = "homeController")
@SessionScoped
public class HomeController {
    private static final String REPOSITORY_WEB_URL = "https://github\\.com/.+/.+\\.git";
    private static final String REPOSITORY_SSH_KEY = "git@github\\.com:.+/.+\\.git";

    @EJB
    private DatabaseManager databaseManager;
    private String repositoryLink;
    private String repositoryName;

    public String getRepositoryLink() {
        return repositoryLink;
    }

    public void setRepositoryLink(String repositoryLink) {
        this.repositoryLink = repositoryLink;
    }

    public String analyseRepository() throws IOException, InterruptedException, JAXBException {
        if (repositoryLink != null && ((repositoryLink.matches(REPOSITORY_WEB_URL)) || (repositoryLink.matches(REPOSITORY_SSH_KEY)))) {
            if (repositoryLink.matches(REPOSITORY_WEB_URL)) {
                repositoryName = repositoryLink.split("\\.")[1].split("/")[2];
            } 
            else {
                repositoryName = repositoryLink.split("\\.")[1].split("/")[1];
            }

            setUpEnvironment();
            unzipDeployedFiles();
            generateReports();
            persistCheckstyleData();
            persistFindBugsData();
            
            return "possible_outputs";
        }
        return "fail";
    }

    private void setUpEnvironment() throws InterruptedException, IOException {
        String tmpDirectory = System.getProperty("java.io.tmpdir");

        ProcessBuilder processBuilder = new ProcessBuilder("rm -rf deployedWar/".split("\\s+"));
        processBuilder.directory(new File(tmpDirectory));

        Process process = processBuilder.start();
        process.waitFor();
    }

    private void unzipDeployedFiles() throws InterruptedException, IOException {
        String deployDirectory = System.getProperty("jboss.home.dir") + "/standalone/deployments";
        
        ProcessBuilder processBuilder = new ProcessBuilder("unzip RepositoryReport_433511.war -d /tmp/deployedWar".split("\\s+"));
        processBuilder.directory(new File(deployDirectory));
        
        Process process = processBuilder.start();
        process.waitFor();
    }

    private void generateReports() throws InterruptedException, IOException {
        ProcessBuilder processBuilder = new ProcessBuilder("sh /tmp/deployedWar/scripts/GenerateFindBugsAndCheckstyleReports.sh".split("\\s+"));
        
        Map<String, String> environment = processBuilder.environment();
        
        environment.put("repositoryLink", repositoryLink);
        environment.put("repositoryName", repositoryName);
        
        Process process = processBuilder.start();
        process.waitFor();
    }

    private void persistCheckstyleData() throws JAXBException {
        JAXBContext checkstyleContext = JAXBContext.newInstance(CheckstyleReport.class);

        Unmarshaller unmarshaller = checkstyleContext.createUnmarshaller();
        CheckstyleReport report = (CheckstyleReport) unmarshaller.unmarshal(new File("/tmp/Reports/CheckstyleReport.xml"));

        databaseManager.addFiles(report.getFileList());
    }

    private void persistFindBugsData() throws JAXBException {
        JAXBContext findbugsContext = JAXBContext.newInstance(FindBugsReport.class);

        Unmarshaller unmarshaller = findbugsContext.createUnmarshaller();
        FindBugsReport report = (FindBugsReport) unmarshaller.unmarshal(new File("/tmp/Reports/FindBugsReport.xml"));

        databaseManager.addBugInstances(report.getFindBugsBugInstanceList());
    }

}
