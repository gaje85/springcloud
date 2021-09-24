## Spring Cloud Config Server

Spring Cloud Config Server app stores and serves distributed configurations across multiple applications and environments.

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
	<artifactId>spring-cloud-config-server</artifactId>
</dependency>
```

### Auto-configuration annotation

```java
@EnableConfigServer
```

### Application Properties

```properties
server.port=8888
encrypt.key="My Secret Key"
spring.cloud.config.server.git.uri=C:\\chandra\\spring-cloud\\git\\config-repo\\config-client
spring.cloud.config.server.git.clone-on-start=true
spring.cloud.config.server.git.basedir=C://temp
spring.cloud.config.server.git.default-label=master
```

### Querying the configurations

#### Path pattern

```
/{application}/{profile}[/{label}]
/{application}-{profile}.yml
/{label}/{application}-{profile}.yml
```

#### Sample config query endpoints

```
http://localhost:8888/config-client/default
http://localhost:8888/config-client/default/master
http://localhost:8888/config-client-dev.yml
http://localhost:8888/master/config-client-test.yml

http://localhost:8888/config-client/default/feature1
http://localhost:8888/feature1/config-client-dev.yml
```

### Encrypt endpoint

```curl
curl --location --request POST 'http://localhost:8888/encrypt' \
--header 'Content-Type: text/plain' \
--data-raw 'bar'
```

### Decrypt endpoint

```curl
curl --location --request POST 'http://localhost:8888/decrypt' \
--header 'Content-Type: text/plain' \
--data-raw 'b88bdfc35d3f436523aaacc7321d7e7d5cae3987c00ff16df358c668cfbb9c8a'
```

###Assignment:
* Remote git
* Asymmetric key