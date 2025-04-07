ARG BASE_IMAGE

FROM --platform=$BUILDPLATFORM ${BASE_IMAGE}
RUN microdnf update -y && \
    microdnf install -y telnet iputils && \
    microdnf clean all

ENV JAVA_OPTS="-XX:+UseContainerSupport -XX:MinRAMPercentage=20.0 -XX:MaxRAMPercentage=80.0"
  
ADD demo-java.jar /app/app.jar

WORKDIR "/app"

EXPOSE 8080
CMD  java ${JAVA_OPTS} \
                 -Djava.security.egd=file:/dev/./urandom \
                 -jar /app/app.jar