#!/bin/bash

cd $tmpDirectory
mkdir Reports
cd Reports/
git clone $repositoryLink
cd $repositoryName/
mvn clean install -DskipTests
java -jar /opt/findbugs-3.0.1/lib/findbugs.jar -output $tmpDirectory/Reports/FindBugsReport.xml -low $tmpDirectory/Reports/$repositoryName/ -xml
java -jar /opt/checkstyle-8.13-all.jar -c $tmpDirectory/deployedWar/scripts/checkstyle_config.xml -f xml -o $tmpDirectory/Reports/CheckstyleReport.xml $tmpDirectory/Reports/$repositoryName/