# sinch-sdk-java


<h1 style="text-align:center">

[![Sinch Logo](https://developers.sinch.com/static/logo-07afe977d6d9dcd21b066d1612978e5c.svg)](https://www.sinch.com)

Java SDK

[![License](https://img.shields.io/badge/License-Apache_2.0-blue.svg)](https://github.com/sinch/sinch-sdk-python/blob/main/LICENSE)


[![Python 3.8](https://img.shields.io/badge/Java-8-blue.svg)](https://docs.oracle.com/javase/8)


</h1>

## Welcome to Sinch's Java SDK.

Here you'll find documentation to start developing Java code using Sinch services.

To use this SDK you'll need a Sinch account and API keys. Please sign up at [sinch.com](https://sinch.com)

For more in depth version of the Sinch APIs, please refer to the official developer portal - [developers.sinch.com](https://developers.sinch.com/)

**This SDK is currently available to selected developers for preview use only. It is being provided for the purpose of collecting feedback, and should not be used in production environments.**

* [Installation](#installation)
* [Getting started](#getting-started)
* [Logging](#logging)
***

# Prerequisites

- JDK 8 or later
- [Maven](https://maven.apache.org/)
- [Maven Central](https://mvnrepository.com/artifact/com.sinch.sdk/sinch-java-sdk)
- [Sinch account](https://dashboard.sinch.com)

## Installation

### Maven setup
Add to your `pom.xml` file the dependency to SDK:
```xml  
<dependencies>
    <dependency>
      <groupId>com.sinch.sdk</groupId>
      <artifactId>sinch-java-sdk</artifactId>
      <version>${sdk.version}</version>
    </dependency>
    ...
</dependencies>
```

## Getting started

### Client initialization

To initialize communication with Sinch backed, credentials obtained from Sinch portal have to be provided to the main client class of this SDK.
It's highly advised to not hardcode those credentials, but to fetch them from environment variables:

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
- [Numbers](https://developers.sinch.com/docs/numbers)
- [SMS](https://developers.sinch.com/docs/sms) (WIP)

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

## Onboarding/Examples
The [sample-app](sample-app/README.md) directory contains ready to use samples and can be used to start your own applications based onto Sinch SDK.

## HTTP Client
See [HTTP-CLIENT](HTTP-CLIENT.md) file

## Architecture
See [ARCHITECTURE](ARCHITECTURE.md) file

## License

This project is licensed under the Apache License. See the [LICENSE](LICENSE) file for the license text.