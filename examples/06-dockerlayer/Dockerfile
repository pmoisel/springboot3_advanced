FROM docker.io/eclipse-temurin:17.0.8_7-jre-alpine as builder

WORKDIR app
COPY target/*.jar app.jar
RUN java -Djarmode=layertools -jar app.jar extract

FROM docker.io/eclipse-temurin:17.0.8_7-jre-alpine
WORKDIR app
COPY --from=builder app/dependencies/ ./
COPY --from=builder app/spring-boot-loader/ ./
COPY --from=builder app/snapshot-dependencies/ ./
COPY --from=builder app/application/ ./

EXPOSE 8080

ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]
