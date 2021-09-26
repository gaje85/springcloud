## Eureka Server

Eureka server has the registry of clients and its instances registers to it. It receives heartbeat messages from each instance belonging to a service. If the heartbeat fails over a configurable timetable, the instance is normally removed from the registry. It helps in configuring the high availability of the services.

By default, every Eureka server is also a Eureka client and requires (at least one) service URL to locate a peer. If you do not provide it, the service runs and works, but it fills your logs with a lot of noise about not being able to register with the peer.

### Instructions to configure the project in Eclipse

1. Open Eclipse and select *File > Import*.
2. In the import wizard, choose *Maven > Existing Maven Projects*, then click *Next*.
3. Select the config-client as the project root directory.
4. Click *Finish* to complete the import.
5. Select *Project > Properties* . In *Java Build Path*, ensure that under the Libraries tab, *Modulepath* is set to JRE System Library (JavaSE-11). In *Java Compiler*, ensure that the *Use compliance from execution environment 'JavaSE-11' on the 'Java Build Path'* checkbox is selected.
6. To package: Right-click the project in the Project Explorer or Package Explorer and choose *Run As > Maven Build...*. In the *Edit Configuration* dialog, in the *Goals* field, enter `clean package` and check 'Skip Tests' checkbox. Click *Run* to run the goal. This will clean your target directory, compiles your sources and packages it.
7. To run: Right-click the project in the Project Explorer or Package Explorer and choose *Run As > Spring Boot App*.

### Dependency

```xml
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
</dependency>
```

### Auto-configuration annotation 

```java
@EnableEurekaServer
```

### Application Properties

```properties
spring.application.name=eureka-server
server.port=8761

eureka.client.register-with-eureka=false
eureka.client.fetch-registry=false
eureka.client.serviceUrl.defaultZone=http://localhost:${server.port}/

logging.level.com.netflix.eureka=OFF
logging.level.com.netflix.discovery=OFF
```

### Test Endpoint

```
http://localhost:8761/
```