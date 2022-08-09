FROM openjdk:17.0.2-slim-buster
# ARG PORT
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar
COPY run.sh run.sh
# ENTRYPOINT ["java","-jar","/app.jar","--server.port","${PORT}"]
# ENTRYPOINT ["sh", "-c", "java -jar /app.jar ${0} ${@}"]
ENTRYPOINT ["sh","run.sh"]
