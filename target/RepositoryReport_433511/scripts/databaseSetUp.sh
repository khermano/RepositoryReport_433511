#!/bin/bash

wget https://dev.mysql.com/get/Downloads/Connector-J/mysql-connector-java-8.0.13.tar.gz
connectorTarPath=`realpath mysql-connector-java-8.0.13.tar.gz`
tar -zxvf $connectorTarPath
export connectorPath=`realpath mysql-connector-java-8.0.13/mysql-connector-java-8.0.13.jar`
printenv > env.properties
$JBOSS_HOME/bin/jboss-cli.sh --file=/yourPathToProject/RepositoryReport_433511/src/main/webapp/scripts/addDriverAndCreateDatasource.cli --properties=env.properties