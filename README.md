# Sinch Java SDK

Here you'll find documentation related to the Sinch Java SDK, including how to install it, initialize it, and start developing <language> code using Sinch services.

To use Sinch services, you'll need a Sinch account and access keys. You can sign up for an account and create access keys at [dashboard.sinch.com](https://dashboard.sinch.com).

For more information on the Sinch APIs on which this SDK is based, refer to the official [developer documentation portal](https://developers.sinch.com).


- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Getting started](#getting-started)
- [Logging]()

## Prerequisites

- JDK 8 or later
- [Maven](https://maven.apache.org/)
- [Maven Repository for this SDK](https://central.sonatype.com/artifact/com.sinch.sdk/sinch-sdk-java)
- [Sinch account](https://dashboard.sinch.com)

## Installation

Add to your `pom.xml` file the dependency to SDK:
```xml  
<dependencies>
    <dependency>
      <groupId>com.sinch.sdk</groupId>
      <artifactId>sinch-sdk-java</artifactId>
      <version>${sdk.version}</version>
    </dependency>
    ...
</dependencies>
```
Note the `${sdk.version}` need to be set according to released version to be used (see available versions from [Maven Repository](https://central.sonatype.com/artifact/com.sinch.sdk/sinch-sdk-java))

## Getting started

Once the SDK is installed, you must start by initializing the main client class.

### Client initialization

To initialize communication with the Sinch servers, credentials obtained from the Sinch dashboard must be provided to the main client class of this SDK. It's highly recommended to not hardcode these credentials and to load them from environment variables instead.

Sample:

```java
import com.sinch.sdk.SinchClient;
import com.sinch.sdk.models.Configuration;

...
Configuration configuration = Configuration.builder().setKeyId(PARAM_KEY_ID)
                                                     .setKeySecret(PARAM_KEY_SECRET)
                                                     .setProjectId(PARAM_PROJECT_ID)
                                                     .build();
...
SinchClient client = new SinchClient(configuration);
```

## Products

Here is the list of the Sinch products and their level of support by the Java SDK:

| API Category           | API Name                                                                                                                             | Status |
|------------------------|--------------------------------------------------------------------------------------------------------------------------------------|:------:|
| Conversation           | Conversation API [(javadoc)](https://developers.sinch.com/java-sdk/apidocs/com/sinch/sdk/domains/conversation/package-summary.html)  |   ✅    |
| Messaging              | SMS API [(javadoc)](https://developers.sinch.com/java-sdk/apidocs/com/sinch/sdk/domains/sms/package-summary.html)                    |   ✅    |
| Numbers & Connectivity | Numbers API [(javadoc)](https://developers.sinch.com/java-sdk/apidocs/com/sinch/sdk/domains/numbers/package-summary.html)            |   ✅    |
| Verification           | Verification API [(javadoc)](https://developers.sinch.com/java-sdk/apidocs/com/sinch/sdk/domains/verification/package-summary.html)  |   ✅    |
| Voice and Video        | Voice API [(javadoc)](https://developers.sinch.com/java-sdk/apidocs/com/sinch/sdk/domains/voice/package-summary.html)                |   ✅    |


## Logging

The SDK uses the Java 8 logging feature ([java.util.logging](https://docs.oracle.com/javase/8/docs/api/java/util/logging/package-summary.html#package.description))

When using java logging, Loggers and severity can be configured by using a `logging.properties` file like:
```
# java.util.logging configuration sample
# See https://docs.oracle.com/javase/8/docs/api/java/util/logging/package-summary.html#package.description

#
# Layers logging severity configuration
#

# Sinch SDK 
com.sinch.level = INFO

# Apache HTTP Client
# org.apache.hc.level = 


#
# console output handler sample
#
handlers = java.util.logging.ConsoleHandler
java.util.logging.ConsoleHandler.formatter = java.util.logging.SimpleFormatter
java.util.logging.SimpleFormatter.format=[%1$tF %1$tT] [%4$-7s %2$s] %5$s %n
java.util.logging.ConsoleHandler.level = FINEST
```
If using another logging framework (SL4F, Spring) see your framework documentation

## Onboarding

To improve onboarding experience, following resources are available:
- Sinch's developers online documentation: https://developers.sinch.com 
- A dedicated Java SDK quickstart repository with tutorials and templates enabling to start quickly a new project: https://github.com/sinch/sinch-sdk-java-quickstart
- A dedicated Java SDK snippets repository with basic code snippets: https://github.com/sinch/sinch-sdk-java-snippets
- Java SDK online javadoc: https://developers.sinch.com/java-sdk/apidocs

## 3rd party dependencies
SDK's third party dependencies are:
- [Jackson's library](https://github.com/FasterXML/jackson-jakarta-rs-providers) for JSON serialization/deserialization features
- [Apache HTTP client](https://hc.apache.org/httpcomponents-client-5.4.x/5.4.1/httpclient5/project-info.html) to handle communication with Sinch products/REST APIs 

### Jackson/JavaEE/jaxrs/jakarta conflict consideration
<code>jakarta</code> namespace used by Jackson could cause issue following migration from <code>javax</code> with Java EE transition (see [Oracle site note about transition](https://blogs.oracle.com/javamagazine/post/transition-from-java-ee-to-jakarta-ee) for details)

Following notes for Jackson maintainers, there is 2 Jackson available versions.
> (*) NOTE: Jakarta-RS is the package under jakarta.ws.rs, replacing older JAX-RS which lived under javax.ws.rs. For JAX-RS variant, see repo jackson-jaxrs-providers

By default, Sinch SDK Java is using "new" [jackson-jakarta-rs-providers](https://github.com/FasterXML/jackson-jakarta-rs-providers) but you could switch to "old" [jackson-jaxrs-providers](https://github.com/FasterXML/jackson-jaxrs-providers) if required.

#### Switching to <code>jackson-jaxrs-providers</code>
According to your use case, dependencies could have to be tuned if you need <code>jaxrs</code> usage.

Add following to your dependency list:
Note: Replace <code>VERSION-YOU-WANT-TO-BE-USED</code> by a Jackson minimal version of `2.15.2`
```xml
...
    <dependency>
      <groupId>com.sinch.sdk</groupId>
      <artifactId>sinch-sdk-java</artifactId>
      <version>${sinch.sdk.java.version}</version>
      <exclusions>
        <exclusion>
          <groupId>com.fasterxml.jackson.jaxrs</groupId>
          <artifactId>jackson-jakarta-rs-json-provider</artifactId>
        </exclusion>
      </exclusions>
    </dependency>
    <dependency>
        <groupId>com.fasterxml.jackson.jakarta.rs</groupId>
        <artifactId>jackson-jaxrs-json-provider</artifactId>
        <version>VERSION-YOU-WANT-TO-BE-USED</version>
    </dependency>
...
```
## License

This project is licensed under the Apache License. 

See the [LICENSE](LICENSE) file for the license text.
