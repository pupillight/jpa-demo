FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

# mvn clean package -Dmaven.test.skip=true
# docker build --build-arg JAR_FILE=target/jpa-demo-0.0.1-SNAPSHOT.jar -t jpa-demo.jar .
