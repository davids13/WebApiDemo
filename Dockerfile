FROM payara/micro:5.2022.3-jdk11

LABEL key="https://github.com/davids13"

USER root

RUN mkdir ${PAYARA_HOME}/config
#COPY ./myPetFinderApp-application/src/main/ope/payara/domain.xml ${PAYARA_HOME}/config/domain.xml
## Set the Payara user and working directory owned by Payara
##RUN chown -R payara:payara ${PAYARA_HOME}/config
RUN chgrp -R 0 /opt/payara && \
chmod -R g+rw /opt/payara && \
find /opt/payara -type d -exec chmod g+x {} +
RUN chown -R payara:payara ${PAYARA_HOME}/config

USER payara

WORKDIR ${PAYARA_HOME}/config

COPY ./target/Web-Demo-1.0-SNAPSHOT.war $DEPLOY_DIR

EXPOSE 8080

#ENTRYPOINT ["java", "-jar", "payara-micro.jar", "--deploy", "/opt/payara/deployments/myPetFinderApp.war"]
ENTRYPOINT ["java", "-agentlib:jdwp=transport=dt_socket,address=*:9009,server=y,suspend=n", "-jar", "/opt/payara/payara-micro.jar", "--deploy", "/opt/payara/deployments/Web-Demo-1.0-SNAPSHOT.war"]

CMD ["--deploymentDir", "/opt/payara/deployments", "--rootDir", "/opt/payara/config"]