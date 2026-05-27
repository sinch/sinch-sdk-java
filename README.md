# Sinch Java SDK

Here you'll find documentation related to the Sinch Java SDK, including how to install it, initialize it, and start developing Java code using Sinch services.

To use Sinch services, you'll need a Sinch account and access keys. You can sign up for an account and create access keys at [dashboard.sinch.com](https://dashboard.sinch.com).

For more information on the SDK, refer to the dedicated [Java SDK documentation section](https://developers.sinch.com/docs/sdks/java) and for the Sinch APIs on which this SDK is based, refer to the official [developer documentation portal](https://developers.sinch.com).

## Table of contents:
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Getting started](#getting-started)
  - [Client initialization](#client-initialization)
  - [Client lifecycle](#client-lifecycle)
- [Supported APIs](#supported-apis)
- [Logging](#logging)
- [Onboarding](#onboarding)
- [Third-party dependencies](#third-party-dependencies)
- [Changelog and Migration guides](#changelog--migration)

## Prerequisites

- JDK 8 or later
- [Maven](https://maven.apache.org/)
- [Maven Repository for this SDK](https://central.sonatype.com/artifact/com.sinch.sdk/sinch-sdk-java)
- [Sinch account](https://dashboard.sinch.com)

## Installation

Add the SDK dependency to your `pom.xml` file:
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
Note: The `${sdk.version}` needs to be set according to the released version to be used (see available versions from [Maven Repository](https://central.sonatype.com/artifact/com.sinch.sdk/sinch-sdk-java))

## Getting started

Once the SDK is installed, you must start by initializing the main client class.

### Client initialization

To initialize communication with the Sinch servers, credentials obtained from the Sinch dashboard must be provided to the main client class of this SDK.

It's highly recommended to not hardcode these credentials and to load them from environment variables instead.

Sample:

```java
import com.sinch.sdk.SinchClient;
import com.sinch.sdk.models.Configuration;

...
Configuration configuration = Configuration.builder()
                                .setKeyId(PARAM_KEY_ID)
                                .setKeySecret(PARAM_KEY_SECRET)
                                .setProjectId(PARAM_PROJECT_ID)
                                .build();
...
SinchClient client = new SinchClient(configuration);
```

### Client lifecycle

`SinchClient` exposes a `close()` method to shut down the underlying HTTP connection pool and release all associated resources.

**Explicit close at shutdown:**

```java
// Create once at startup (e.g. as a Spring bean)
SinchClient client = new SinchClient(configuration);

// ... use throughout the application lifetime ...

// Release resources at shutdown
client.close();
```

Failing to close a `SinchClient` that has made at least one request will leave the HTTP connection pool open until the object is garbage-collected, which may delay JVM shutdown and exhaust file descriptors in long-running processes.

## Supported APIs

Here is the list of the Sinch products and their level of support by the Java SDK:

| API Category           | API Name                                                                                                                                               | Status |
|------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------|:------:|
| Messaging              | Conversation API [(javadoc)](https://www.javadoc.io/doc/com.sinch.sdk/sinch-sdk-java/latest/com/sinch/sdk/domains/conversation/package-summary.html)   |   ✅    |
|                        | SMS API [(javadoc)](https://www.javadoc.io/doc/com.sinch.sdk/sinch-sdk-java/latest/com/sinch/sdk/domains/sms/package-summary.html)                     |   ✅    |
| Numbers & Connectivity | Numbers API [(javadoc)](https://www.javadoc.io/doc/com.sinch.sdk/sinch-sdk-java/latest/com/sinch/sdk/domains/numbers/package-summary.html)             |   ✅    |
| Verification           | Verification API [(javadoc)](https://www.javadoc.io/doc/com.sinch.sdk/sinch-sdk-java/latest/com/sinch/sdk/domains/verification/package-summary.html)   |   ✅    |
| Voice and Video        | Voice API [(javadoc)](https://www.javadoc.io/doc/com.sinch.sdk/sinch-sdk-java/latest/com/sinch/sdk/domains/voice/package-summary.html)                 |   ✅    |


## Logging

The SDK uses the Java 8 logging feature ([java.util.logging](https://docs.oracle.com/javase/8/docs/api/java/util/logging/package-summary.html#package.description))

When using Java logging, Loggers and severity can be configured by using a `logging.properties` file like:
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
If you are using a different logging framework (such as SLF4J or Spring), please refer to the documentation for your specific framework.

## Onboarding

To enhance the onboarding experience, the following resources are available:
- Sinch Online Developers Documentation: https://developers.sinch.com 
- Java SDK Online Javadoc: https://www.javadoc.io/doc/com.sinch.sdk/sinch-sdk-java
- Java SDK examples: A collection of basic code snippets, tutorials and getting started for reference: [examples](examples/README.md)

## Third-party dependencies
The SDK relies on the following third-party dependencies:
- [Jackson's library](https://github.com/FasterXML/jackson-jakarta-rs-providers): Provides JSON serialization/deserialization functionality.
- [Apache HTTP client](https://hc.apache.org/httpcomponents-client-ga/): Manages communication with Sinch products' REST APIs

### Jackson/Java EE/jaxrs/Jakarta Compatibility Consideration
The transition from `javax` to `jakarta` namespaces with the Java EE to Jakarta EE migration may cause compatibility issues. Refer to [Oracle's note about the transition](https://docslib.org/doc/1185955/transition-from-java-ee-to-jakarta-ee-ee-conclusion-what-happened-and-what-you-need-to-know) for additional details.

Jackson maintainers provide two variants of the library:
> (*) NOTE: Jakarta-RS is the package under jakarta.ws.rs, replacing older JAX-RS which lived under javax.ws.rs. For JAX-RS variant, see repo jackson-jaxrs-providers

By default, the Sinch Java SDK uses the "new" [jackson-jakarta-rs-providers](https://github.com/FasterXML/jackson-jakarta-rs-providers). However, you can switch to the "older" [jackson-jaxrs-providers](https://github.com/FasterXML/jackson-jaxrs-providers) if required.

#### Switching to `jackson-jaxrs-providers`
Depending on your use case, you may need to adjust dependencies to enable `jaxrs` usage.

Add the following dependency to your configuration:
Note: Replace `VERSION-YOU-WANT-TO-BE-USED` with a Jackson version of at least `2.15.2`.
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

## Changelog & Migration
For information about the latest changes in the SDK, please refer to the [CHANGELOG](CHANGELOG.md) file
and the [MIGRATION-GUIDE](MIGRATION-GUIDE.md) for instructions on how to update your code when upgrading to a new major version of the SDK.

## Contact

Developer Experience engineering team: [team-developer-experience@sinch.com](mailto:team-developer-experience@sinch.com)

## License

This project is licensed under the Apache License. 

See the [LICENSE](LICENSE) file for the license text.
