FROM ubuntu:20.04
LABEL description="Demo Prime Number API for Docker session"
LABEL maintainer="nishikant.ajay.patil@gmail.com"
LABEL version = "0.1"

ENV JAVA_HOME=/apps/jdk-14.0.2/

ARG DEBIAN_FRONTEND=noninteractive

RUN apt-get update && \
    apt-get install -y wget && \
    mkdir /apps && \
    cd /apps && \
    wget https://download.java.net/java/GA/jdk14.0.2/205943a0976c4ed48cb16f1043c5c647/12/GPL/openjdk-14.0.2_linux-x64_bin.tar.gz && \
    tar -xf openjdk-14.0.2_linux-x64_bin.tar.gz && \
    rm openjdk-14.0.2_linux-x64_bin.tar.gz && \
    apt-get purge && \
    apt-get autoclean

COPY ./build/libs/prime-number-api-0.1.jar /apps/

EXPOSE 8080

ENTRYPOINT [ "/apps/jdk-14.0.2/bin/java", "-jar", "/apps/prime-number-api-0.1.jar" ]