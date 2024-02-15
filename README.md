# Sinch Java SDK

Here you'll find documentation related to the Sinch Java SDK, including how to install it, initialize it, and start developing <language> code using Sinch services.

To use Sinch services, you'll need a Sinch account and access keys. You can sign up for an account and create access keys at [dashboard.sinch.com](https://dashboard.sinch.com).

For more information on the Sinch APIs on which this SDK is based, refer to the official [developer documentation portal](https://developers.sinch.com).

**This SDK is currently available for preview purposes only. It should not be used in production environments.**

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

Sinch client provides access to the following Sinch products:

- Numbers [(javadoc)](https://developers.sinch.com/java-sdk/apidocs/com/sinch/sdk/domains/numbers/package-summary.html)
- SMS [(javadoc)](https://developers.sinch.com/java-sdk/apidocs/com/sinch/sdk/domains/sms/package-summary.html)
- Verification [(javadoc)](https://developers.sinch.com/java-sdk/apidocs/com/sinch/sdk/domains/verification/package-summary.html)
- Voice [(javadoc)](https://developers.sinch.com/java-sdk/apidocs/com/sinch/sdk/domains/voice/package-summary.html)
- additional products coming soon!

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

## Sample apps

The following sections detail how to build the SDK locally and how to use the included sample apps.

#### Numbers product usage sample
Usage example of the `numbers` product:

```java
AvailableNumberListResponse response = client
                                        .numbers()
                                        .available()
                                        .list(AvailableNumberListAllRequestParameters.builder()
                                                                                    .setRegionCode("US")
                                                                                    .setType(NumberType.LOCAL)
                                                                                    .build());
```

#### Onboarding/Examples
A dedicated [sample-app](sample-app/README.md) directory contains ready to use samples and can be used to start your own applications based onto Sinch SDK.


## License

This project is licensed under the Apache License. See the [LICENSE](LICENSE) file for the license text.
