#!/bin/bash

wget https://dev.mysql.com/get/Downloads/Connector-J/mysql-connector-java-8.0.13.tar.gz
var=`realpath mysql-connector-java-8.0.13.tar.gz`
tar -zxvf $var
var2=`realpath mysql-connector-java-8.0.13/mysql-connector-java-8.0.13.jar`
$JBOSS_HOME/bin/jboss-cli.sh -c --command="module add --name=com.mysql --resources=$var2  --dependencies='javax.api,javax.transaction.api'"
$JBOSS_HOME/bin/jboss-cli.sh -c --command="/subsystem=datasources/jdbc-driver=mysql:add(driver-name="mysql",driver-module-name="com.mysql",driver-class-name=com.mysql.jdbc.Driver)"
$JBOSS_HOME/bin/jboss-cli.sh -c --command="data-source add --jndi-name=java:/MySqlDS --name=MySqlDS --connection-url=jdbc:mysql://localhost:3306/reports --driver-name=mysql --user-name=databaseUser --password=12*ab*34"
$JBOSS_HOME/bin/jboss-cli.sh -c --command="reload"