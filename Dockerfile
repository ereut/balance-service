FROM tomcat:9.0-alpine
MAINTAINER ereut
ARG WAR_FILE=target/*.war
COPY ${WAR_FILE} /usr/local/tomcat/webapps/
