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

* Steps to Run using Spring Boot maven commands  :
    > mvn spring-boot:run -Dspring.profiles.active=replicas1

    > mvn spring-boot:run -Dspring.profiles.active=replicas2

    > mvn spring-boot:run -Dspring.profiles.active=replicas3

### Eureka’s Peer Awareness: Concepts
1. For now, we aim to have two Eureka Service Registry instances that can share the registry information: a Eureka Cluster (a.k.a. the Replica mode in Eureka). To achieve this, we need to take into account some very important concepts about how the Eureka Replica mode works:
2. The Replica mode will NOT work if you use the same hostname in both instances. That means that you need to give your host two different aliases if you want to test this within the same host.
3. The Replica mode will NOT work if you use different application names in both instances. It makes sense since the application itself is the same, it’s just that we’re replicating it.
  The magic behind the Replica mode is as simple as configuring each instance to register in another one. You can extend this to as many instances as you like, as long as you keep connecting all the edges (A registers in B, B registers in C, C registers in A). In our case, it’s just crossing both of them.
  
* Preparing your system to test it

    * Before you execute this application you need an extra step though. As pointed out before, the Peer Awareness feature won’t work if you use the same hostname. We set them to eureka-peer1 and eureka-peer2 in our configuration, but we need to redirect those aliases to our real local host for that to work on our machine.
    
    * In windows, you need to modify your hosts file and add a couple of lines like these (note that you usually need administrator privileges and save the file without adding an extension:
    
    * In Linux or Mac, you need to add the same lines, but this time in your /etc/hosts file.
    
    > 127.0.0.1 replicas1
    
    > 127.0.0.1 replicas2

    > 127.0.0.1 replicas3