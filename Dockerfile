FROM amazoncorretto:17
RUN mkdir -p /db
ENV SPRING_DATASOURCE_URL=jdbc:h2:/db/database
WORKDIR /
COPY target/crypto-api-0.0.1-SNAPSHOT.jar /crypto-api.jar
CMD java -jar crypto-api.jar
