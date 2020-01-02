# Spring Cloud Eureka Server (Service Registration)
Spring cloud eureka server which is act as eureka client discovery server.

### Run all Replicas 
* replicas1, replicas2, and replicas3 illustrate running 3 intercommunicating instances. This example has them running side-by-side on localhost
which is unrealistic in production
but does illustrate how multiple instances collaborate.
* Run by opening 3 separate command prompts:

    > java -jar -Dspring.profiles.active=replicas1 eureka-service-0.0.1-SNAPSHOT.jar
    
    > java -jar -Dspring.profiles.active=replicas2 eureka-service-0.0.1-SNAPSHOT.jar
    
    > java -jar -Dspring.profiles.active=replicas3 eureka-service-0.0.1-SNAPSHOT.jar