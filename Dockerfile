FROM adoptopenjdk:11-jre-hotspot
# ARG JAR_FILE=target/payment-service-0.0.1-SNAPSHOT.jar
# COPY ${JAR_FILE} payment-service-0.0.1-SNAPSHOT.jar
# EXPOSE 9090
RUN echo "$PWD"

COPY target/payment-service-0.0.1-SNAPSHOT.jar payment-service-1.0.0.jar
RUN echo "$PWD"

ENTRYPOINT ["java","-jar","/payment-service-1.0.0.jar"]

#
# # Add Maintainer Info
# LABEL maintainer="shayizak88@gmail.com"
#
# # Add a volume pointing to /tmp
# VOLUME /tmp

# Make port 9090 available to the world outside this container
# EXPOSE 9090

# # The application's jar file
# ARG JAR_FILE=target/*.jar

# # Add the application's jar to the container
# ADD ${JAR_FILE} payment-service-0.0.1-SNAPSHOT.jar
#
# # Run the jar file
# ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/payment-service-0.0.1-SNAPSHOT.jar"]