#!/bin/bash

cd /tmp
mkdir Reports
cd Reports/
git clone $repositoryLink
cd $repositoryName/
mvn clean install -DskipTests
java -jar /opt/findbugs-3.0.1/lib/findbugs.jar -output /tmp/Reports/FindBugsReport.xml -low /tmp/Reports/$repositoryName/ -xml
java -jar /opt/checkstyle-8.13-all.jar -c /tmp/deployedWar/scripts/checkstyle_config.xml -f xml -o /tmp/Reports/CheckstyleReport.xml /tmp/Reports/$repositoryName/