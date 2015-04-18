#!/bin/bash
printf "\n\n ~> mvn clean install\n\n" &&
mvn clean install && sleep 1 &&
printf "\n\n ~> mvn exec:java -Dexec.mainClass=org.apache.camel.main.Main -Dexec.args='-r com.github.sonenko.hellojavacamelwebsockets.MyBuilder'\n\n" &&
mvn exec:java -Dexec.mainClass=org.apache.camel.main.Main -Dexec.args='-r com.github.sonenko.hellojavacamelwebsockets.MyBuilder'