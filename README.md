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

| API Category           | API Name                                                                                                                            | Status |
|------------------------|-------------------------------------------------------------------------------------------------------------------------------------|:------:|
| Conversation           | Conversation API [(javadoc)](https://developers.sinch.com/java-sdk/apidocs/com/sinch/sdk/domains/conversation/package-summary.html) |   ✅   |
| Messaging              | SMS API [(javadoc)](https://developers.sinch.com/java-sdk/apidocs/com/sinch/sdk/domains/sms/package-summary.html)                   |   ✅   |
| Numbers & Connectivity | Numbers API [(javadoc)](https://developers.sinch.com/java-sdk/apidocs/com/sinch/sdk/domains/numbers/package-summary.html)           |   ✅   |
| Verification           | Verification API [(javadoc)](https://developers.sinch.com/java-sdk/apidocs/com/sinch/sdk/domains/verification/package-summary.html) |   ✅   |
| Voice and Video        | Voice API [(javadoc)](https://developers.sinch.com/java-sdk/apidocs/com/sinch/sdk/domains/voice/package-summary.html)               |   ✅   |


## Logging

The SDK uses the Java 8 logging feature ([java.util.logging](https://docs.oracle.com/javase/8/docs/api/java/util/logging/package-summary.html))
Loggers and severity can be configured by using a `logging.properties` file like (see sample-app/src/main/resources/:
```
handlers = java.util.logging.ConsoleHandler
java.util.logging.ConsoleHandler.level = INFO
com.sinch.sdk.level = INFO

java.util.logging.ConsoleHandler.formatter = java.util.logging.SimpleFormatter
java.util.logging.SimpleFormatter.format=[%1$tF %1$tT] [%4$-7s %2$s] %5$s %n
```

## Onboarding

To improve onboarding experience, following resources are available:
- Sinch developpers online doucmentation: https://developers.sinch.com 
- A dedicated Java SDK quickstart repository with tutorials and templates enabling to start quickly a new project: https://github.com/sinch/sinch-sdk-java-quickstart
- A dedicated Java SDK sippets repository with basic code snippets: https://github.com/sinch/sinch-sdk-java-snippets
- Java SDK online javdoc: https://developers.sinch.com/java-sdk/apidocs


## License

This project is licensed under the Apache License. See the [LICENSE](LICENSE) file for the license text.
