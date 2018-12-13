# RepositoryReport_433511

GitHub Java content repository source code analyzer

## Running

1. Make sure you have
    - 1.1. Linux
    - 1.2. FindBugs 3.0.1 in /opt
         - download - command -- `wget https://sourceforge.net/projects/findbugs/files/findbugs/3.0.1/findbugs-3.0.1.zip`
         - unzip file in /opt -command -- `sudo unzip findbugs-3.0.1.zip -d /opt`
    - 1.3. jar format of Checkstyle 8.13 in /opt
         - download checkstyle-8.13-all.jar
         - command -- `wget https://github.com/checkstyle/checkstyle/releases/download/checkstyle-8.13/checkstyle-8.13-all.jar`
         - move it to /opt - command -- `sudo mv checkstyle-8.13-all.jar /opt`
    - 1.4. Git - on command line or download from https://git-scm.com/downloads
         - command -- Fedora `sudo dnf install git-all` or Ubuntu `sudo apt install git-all`
    - 1.5. Maven
         - https://www.javahelps.com/2017/10/install-apache-maven-on-linux.html
    - 1.6. WildFly
         - download from http://wildfly.org/downloads/
2. Set the JBOSS_HOME variable
    - command -- `export JBOSS_HOME=/path/to/wfly`
3. Start WildFly - command -- `$JBOSS_HOME/bin/standalone.sh`
4. Set up database and dataSource
    - Install mysql, create user and database:
        ```bash
        sudo dnf -y install mysql-server mysql
        sudo systemctl start mariadb.service
        mysql // Run mysql and create user and database
        CREATE USER 'databaseUser'@'localhost' IDENTIFIED BY '12*ab*34';
        CREATE DATABASE reports;
        GRANT ALL PRIVILEGES ON  reports.* TO 'databaseUser'@'localhost';
        ```
    - you can use a script databaseSetUp.sh located in RepositoryReport_433511/src/main/webapp/scripts/
    - but you have to change the path in the last row of the file to /yourPathToProject/RepositoryReport_433511/src/main/webapp/scripts/addDriverAndCreateDatasource.cli
    - commands -- `chmod +x /pathToFile/databaseSetUp.sh`, `/yourPathToProject/RepositoryReport_433511/src/main/webapp/scripts/databaseSetUp.sh`
5. Compile this project - command -- `mvn clean install`
6. Deploy it to WildFly
    - one way is copy it to the deployments - commmand -- `cp /yourPathToProject/RepositoryReport_433511/target/RepositoryReport_433511.war $JBOSS_HOME/standalone/deployments`
7. Execute application in your web browser with url http://localhost:8080/RepositoryReport_433511/faces/home.xhtml

