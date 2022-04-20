FROM openjdk:11
RUN echo "Africa/Harare" > /etc/timezone
ADD target/daily-read.jar app.jar
# Run the jar
ENTRYPOINT ["java", "-jar", "app.jar"]
