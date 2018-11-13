#!/bin/bash

cd ~
mkdir BachelorThesis4
cd BachelorThesis4/
git clone https://github.com/khermano/tyr.git
cd tyr/
mvn clean install
java -jar /opt/findbugs-3.0.1/lib/findbugs.jar -output ~/BachelorThesis4/FindBugsReport.xml -low ~/BachelorThesis4/tyr/ -xml
java -jar /opt/checkstyle-8.13-all.jar -c ~/BackUp/checkstyle_config.xml -f xml -o ~/BachelorThesis4/CheckstyleReport.xml ~/BachelorThesis4/tyr/
