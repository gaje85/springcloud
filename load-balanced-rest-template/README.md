## Spring Cloud LoadBalancer - LoadBalanced RestTemplate

The @LoadBalanced annotation on RestTemplate will make an instance of created RestTemplate load-balanced. There is no code you need to write to make RestTemplate load-balance HTTP request it sends to an internal microservice. The RestTemplate bean will be intercepted and auto-configured by Spring Cloud.

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
	<artifactId>spring-cloud-starter-loadbalancer</artifactId>
</dependency>
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

### Application Properties

```yaml
spring:
  application:
    name: load-balanced-rest-template

server:
  port: 8081
```

### Test Endpoint

```
http://localhost:8081/
```