FROM openjdk:8u212-jdk
ENV CLASSPATH .:/app/WEB-INF/lib/*:/app/WEB-INF/classes:/app/*:/app/*
ENV HOME /app
COPY start.sh /app/
RUN  chmod 777 /app/start.sh