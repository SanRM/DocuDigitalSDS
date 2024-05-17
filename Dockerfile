FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/docudigitalsds.war app.war
EXPOSE 8080
