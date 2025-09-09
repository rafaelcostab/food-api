FROM maven:3.6-jdk-11

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline -B

COPY src ./src

EXPOSE 8080

CMD ["mvn", "spring-boot:run"]
