FROM openjdk:17-alpine
COPY . .
RUN ./mvnw clean install -DskipTests

EXPOSE 8080

COPY ./target/fifa-cups-*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]