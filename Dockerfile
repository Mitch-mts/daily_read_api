FROM openjdk:11
RUN echo "Africa/Harare" > /etc/timezone
ADD target/daily-read.jar app.jar
# Run the jar
ENTRYPOINT ["java", "-DCONFIG_SERVER_URI=http://127.0.0.1:5432", "-jar", "app.jar"]
