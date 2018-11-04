FROM java:8
COPY target/*SNAPSHOT.jar demo.jar
ENTRYPOINT ["/usr/bin/java", "-jar", "demo.jar"]