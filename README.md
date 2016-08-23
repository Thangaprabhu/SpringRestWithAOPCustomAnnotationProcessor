This projects Hosts Spring 4.2.0 Rest WebService with Custom annotation for recording
the execution time of the request. 

The project has jetty embedded plugin with the port 8081. Run the project with "clean install jetty:run" 

In the "HelloWorldRestController.java" "getUser( long id)" annotation is placed.
This "@LogDuration("Get User Api")" annotation will be processed "LoggingAspect.java"

"@EnableAspectJAutoProxy" placed in "HelloWorldConfiguration.java" makes the proxy which 
surrounds the method getUser.

So when the request comes to this getUser Method of controller, "LoggingAspect.java" 
Around around annotation is executed. 