package output.controller;

import databaseManager.CheckstyleDatabaseManager;
import input.checkstyle.CheckstyleReport;
import input.findbugs.FindBugsReport;
import databaseManager.FindBugsDatabaseManager;
import org.apache.commons.io.FileUtils;

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
    private static final String REPOSITORY_SSH_LINK = "git@github\\.com:.+/.+\\.git";
    private String tmpDirectory = System.getProperty("java.io.tmpdir");

    @EJB
    private FindBugsDatabaseManager findBugsDatabaseManager;
    @EJB
    private CheckstyleDatabaseManager checkstyleDatabaseManager;
    private String repositoryLink;
    private String repositoryName;

    public String getRepositoryLink() {
        return repositoryLink;
    }

    public void setRepositoryLink(String repositoryLink) {
        this.repositoryLink = repositoryLink;
    }

    public String analyseRepository() throws IOException, InterruptedException, JAXBException {
        if (repositoryLink != null) {
            String[] repositoryLinkParts = repositoryLink.split("\\.")[1].split("/");

            if (repositoryLink.matches(REPOSITORY_WEB_URL)) {
                repositoryName = repositoryLinkParts[2];
            } else if (repositoryLink.matches(REPOSITORY_SSH_LINK)) {
                repositoryName = repositoryLinkParts[1];
            } else {
                return "fail";
            }

            checkstyleDatabaseManager.cleanTables();
            findBugsDatabaseManager.cleanTables();
            File deployedWarFile = new File(tmpDirectory + "/deployedWar");
            if (deployedWarFile.exists()) {
                FileUtils.deleteDirectory(deployedWarFile);
            }
            File reportsFile = new File(tmpDirectory + "/Reports");
            if (reportsFile.exists()) {
                FileUtils.deleteDirectory(reportsFile);
            }
            unzipDeployedFiles();
            generateReports();
            persistCheckstyleData();
            persistFindBugsData();
            
            return "possible_outputs";
        } else {
            return "fail";
        }
    }

    private void unzipDeployedFiles() throws InterruptedException, IOException {
        String deployDirectory = System.getProperty("jboss.home.dir") + "/standalone/deployments";
        String command = "unzip RepositoryReport_433511.war scripts/* -d " + tmpDirectory + "/deployedWar";

        ProcessBuilder processBuilder = new ProcessBuilder(command.split("\\s+"));
        processBuilder.directory(new File(deployDirectory));
        
        Process process = processBuilder.start();
        process.waitFor();
    }

    private void generateReports() throws InterruptedException, IOException {
        String command = "sh " + tmpDirectory + "/deployedWar/scripts/GenerateFindBugsAndCheckstyleReports.sh";
        ProcessBuilder processBuilder = new ProcessBuilder(command.split("\\s+"));
        
        Map<String, String> environment = processBuilder.environment();
        
        environment.put("repositoryLink", repositoryLink);
        environment.put("repositoryName", repositoryName);
        environment.put("tmpDirectory", tmpDirectory);
        
        Process process = processBuilder.start();
        process.waitFor();
    }

    private void persistCheckstyleData() throws JAXBException {
        JAXBContext checkstyleContext = JAXBContext.newInstance(CheckstyleReport.class);

        Unmarshaller unmarshaller = checkstyleContext.createUnmarshaller();
        String checkstyleReportPath = tmpDirectory + "/Reports/CheckstyleReport.xml";
        CheckstyleReport report = (CheckstyleReport) unmarshaller.unmarshal(new File(checkstyleReportPath));

        checkstyleDatabaseManager.addFiles(report.getFileList());
    }

    private void persistFindBugsData() throws JAXBException {
        JAXBContext findbugsContext = JAXBContext.newInstance(FindBugsReport.class);

        Unmarshaller unmarshaller = findbugsContext.createUnmarshaller();
        String findbugsReportPath = tmpDirectory + "/Reports/FindBugsReport.xml";
        FindBugsReport report = (FindBugsReport) unmarshaller.unmarshal(new File(findbugsReportPath));

        findBugsDatabaseManager.addBugInstances(report.getFindBugsBugInstanceList());
    }

}
