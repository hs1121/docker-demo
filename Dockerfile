FROM tomcat:9

WORKDIR /usr/local/tomcat/webapps/
COPY /target/*.war /usr/local/tomcat/webapps/library.war
COPY ./docker/application.properties /usr/local/tomcat/webapps/

EXPOSE 8080

CMD ["catalina.sh", "run"]

