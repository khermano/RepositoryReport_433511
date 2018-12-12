# RepositoryReport_433511

GitHub Java content repository source code analyzer

## Running

1. Make sure you have
    - 1.1. Linux
    - 1.2. FindBugs 3.0.1 in /opt
         - download zip from https://sourceforge.net/projects/findbugs/files/findbugs/3.0.1/findbugs-3.0.1.zip/download?use_mirror=kent&download=
         - unzip file in /opt -command -- `unzip findbugs-3.0.1.zip /opt`
    - 1.3. jar format of Checkstyle 8.13 in /opt
         - download checkstyle-8.13-all.jar from https://github.com/checkstyle/checkstyle/releases/download/checkstyle-8.13/checkstyle-8.13-all.jar
         - move it to /opt - command -- `mv checkstyle-8.13-all.jar /opt`
    - 1.4. Git - on command line or download from https://git-scm.com/downloads
         - command -- Fedora `sudo dnf install git-all` or Ubuntu `sudo apt install git-all`
    - 1.5. Maven
         - https://www.javahelps.com/2017/10/install-apache-maven-on-linux.html
    - 1.6. WildFly
         - download from http://wildfly.org/downloads/
2. Set the JBOSS_HOME variable
    - command -- `export JBOSS_HOME=/path/to/wfly`
3. Execute WildFly - command -- $JBOSS_HOME/bin/standalone.sh`
4. Set up database and dataSource
    - you can use a script databaseSetUp.sh located in RepositoryReport_433511/src/main/webapp/scripts/
    - but you have to change the path in the last row of the file to /yourPathToProject/RepositoryReport_433511/src/main/webapp/scripts/addDriverAndCreateDatasource.cli
    - commands -- `chmod +x /pathToFile/databaseSetUp.sh`, `/yourPathToProject/RepositoryReport_433511/src/main/webapp/scripts/databaseSetUp.sh`
5. Execute application in your web browser with url http://localhost:8080/RepositoryReport_433511/faces/home.xhtml

