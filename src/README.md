# RepositoryReport_433511

GitHub Java content repository source code analyzer

## Running

1. Make sure you have
    1.1. Linux
    1.2. FindBugs 3.0.1 in /opt
        - download zip from https://sourceforge.net/projects/findbugs/files/findbugs/3.0.1/findbugs-3.0.1.zip/download?use_mirror=kent&download=
        - unzip file in /opt - unzip findbugs-3.0.1.zip /opt
    1.3. jar format of Checkstyle 8.13 in /opt
        - download checkstyle-8.13-all.jar from https://github.com/checkstyle/checkstyle/releases/download/checkstyle-8.13/checkstyle-8.13-all.jar
        - move it to /opt - mv checkstyle-8.13-all.jar /opt
    1.4. Git
        - sudo dnf install git-all
    1.5. Maven
        - https://www.javahelps.com/2017/10/install-apache-maven-on-linux.html
    1.6. WildFly
        - download - git clone https://github.com/wildfly/wildfly.git
        - in wildfly/wildfly - mvn clean install
        - cp /wildfly/dist/target/wildfly-15.0.0.Alpha1-SNAPSHOT /opt
2. Set the JBOSS_HOME variable - https://docs.jboss.org/jbossas/docs/Installation_And_Getting_Started_Guide/5/html/setting_JBOSS_HOME.html
3. Execute WildFly -  $JBOSS_HOME/bin/standalone.sh
4. Set up database and dataSource
    - you can use a script databaseSetUp.sh located in RepositoryReport_433511/src/main/webapp/scripts/ with using your own path to
    the file /yourPathToProject/RepositoryReport_433511/src/main/webapp/scripts/addDriverAndCreateDatasource.cli in last row of the script
5. Execute application in your web browser with url http://localhost:8080/RepositoryReport_433511/faces/home.xhtml

