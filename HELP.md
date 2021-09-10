# String boot project with log on aws cloudwatch using logback appender
Based on this [post](https://dzone.com/articles/announcing-log4j-aws-appenders)  

Simple spring boot web application that logs to aws-cloudwatch, via a CloudWatchAppender configured on logback.  


### logback appender
Library from Keith Gregory's project [log4j-aws-appenders](https://github.com/kdgregory/log4j-aws-appenders)  

### maven dependencies

logback-aws-appenders:

	<!-- https://mvnrepository.com/artifact/com.kdgregory.logging/logback-aws-appenders -->
	<dependency>
		<groupId>com.kdgregory.logging</groupId>
		<artifactId>logback-aws-appenders</artifactId>
		<version>3.0.1</version>
	</dependency>

aws-facade-v2 (linked with aws-sdk v2):

	<!-- https://mvnrepository.com/artifact/com.kdgregory.logging/aws-facade-v2 (linked with aws-sdk v2) -->
	<dependency>
		<groupId>com.kdgregory.logging</groupId>
		<artifactId>aws-facade-v2</artifactId>
		<version>3.0.1</version>
	</dependency>

cloudwatchlogs (aws-sdk v2)

	<!-- https://mvnrepository.com/artifact/software.amazon.awssdk/cloudwatchlogs (aws-sdk v2) -->
	<dependency>
		<groupId>software.amazon.awssdk</groupId>
		<artifactId>cloudwatchlogs</artifactId>
		<version>2.17.36</version>
	</dependency>

	
### run the application
The application assumes there's an environment variable: "env = local"  
At startup:
* loads from ${env}.properties aws's credentials
* uses as logback file: logback-${env}.xml
* writes into a logGroup [test-log-group] and logStream [test-stream]

### CloudWatchAppender's properties
See Keith Gregory's cloudwatch [guide](https://github.com/kdgregory/log4j-aws-appenders/blob/trunk/docs/cloudwatch.md)  
  