## Open Feign

Declarative REST Client: Feign creates a dynamic implementation of an interface decorated with JAX-RS or Spring MVC annotations

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
	<artifactId>spring-cloud-starter-openfeign</artifactId>
</dependency>
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
```

### Auto-configuration annotation 

```java
@EnableFeignClients
```

### Application Properties

```yaml
spring:
  application:
    name: feign-eureka-client

server:
  port: 8090
  
feign:
  client:
    refresh-enabled: true
  compression:
    request:
      enabled: true
      mime-types:
      - text/xml
      - application/xml
      - application/json
      min-request-size: 2048
    response:
      enabled: true
      useGzipDecoder: true
```

### Test Endpoint

```
http://localhost:8090/
```