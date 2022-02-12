Spring Cloud Sleuth with Zipkin
===============================

Spring Cloud Sleuth:
	It is used to generate the trace id, span id and add this information to the service calls in the headers and MDC, so that It can be used by tools like Zipkin and ELK etc. to store, index and process log files.
	
Zipkin:
	Zipkin is a distributed tracing system. It helps gather timing data needed to troubleshoot latency problems in service architectures. Features include both the collection and lookup of this data.

1. Download and start Zipkin server:

If you have Java 8 or higher installed, the quickest way to get started is to fetch the latest release as a self-contained executable jar:

curl -sSL https://zipkin.io/quickstart.sh | bash -s
java -jar zipkin.jar

Browse to http://your_host:9411 to find traces!

2. Add below dependency to your project and spring.application.name to your project in bootstrarp.properties or application.properties. This will take care of Sleuth job to generate the trace id, span id and add this information to the service calls in the headers and MDC and sends it to Zipkin server running on http://your_host:9411
	<dependency>
				<groupId>org.springframework.cloud</groupId>
				<artifactId>spring-cloud-starter-zipkin</artifactId>
	</dependency>

	
3. You can also check your application logs which will contain below information:

	2022-02-12 10:00:00.000 INFO [cloud-sleuth,44462edc42f2ae73,44462edc42f2ae73,true] ...
	
	The portion of the log statement that Sleuth adds is [cloud-sleuth,44462edc42f2ae73,44462edc42f2ae73,true]. What do all these values mean? The first part is the application name (whatever you set spring.application.name to in bootstrap.yml). The second value is the trace id. The third value is the span id. Finally the last value indicates whether the span should be exported to Zipkin.
