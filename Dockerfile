FROM openjdk:11
RUN echo "Africa/Harare" > /etc/timezone
COPY "./target/daily-read.jar" .
# Run the jar
ENTRYPOINT ["java", "-jar", "daily-read.jar"]
