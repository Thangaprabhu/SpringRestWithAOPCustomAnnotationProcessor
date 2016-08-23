This projects Hosts Spring 4.2.0 Rest WebService with Custom annotation for recording
the execution time of the request. 

The project has jetty embedded plugin with the port 8081. Run the project with "clean install jetty:run" 

In the "HelloWorldRestController.java" "getUser( long id)" annotation is placed.
This "@LogDuration("Get User Api")" annotation will be processed by "LoggingAspect.java"

"@EnableAspectJAutoProxy" placed in "HelloWorldConfiguration.java" makes the proxy which 
surrounds the method getUser.

So when the request comes to this getUser Method of controller, "LoggingAspect.java" 
Around around annotation is executed. 

Dependency required for AOP are below...
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-aop</artifactId>
			<version>${springframework.version}</version>
		</dependency>
		<dependency>
			<groupId>org.aspectj</groupId>
			<artifactId>aspectjrt</artifactId>
			<version>1.8.2</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/org.aspectj/aspectjweaver -->
		<dependency>
			<groupId>org.aspectj</groupId>
			<artifactId>aspectjweaver</artifactId>
			<version>1.8.2</version>
		</dependency>
