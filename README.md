# Sinch Java SDK

[![Java](https://img.shields.io/badge/Java-8+-orange.svg)](https://www.java.com)
[![Latest Release](https://img.shields.io/maven-central/v/com.sinch.sdk/sinch-sdk-java?label=sinch&labelColor=FFC658)](https://central.sonatype.com/artifact/com.sinch.sdk/sinch-sdk-java)
[![License](https://img.shields.io/badge/License-Apache_2.0-blue.svg)](https://github.com/sinch/sinch-sdk-java/blob/main/LICENSE)

Here you'll find documentation related to the Sinch Java SDK, including how to install it, initialize it, and start developing Java code using Sinch services.

To use Sinch services, you'll need a Sinch account and access keys. You can sign up for an account and create access keys at [dashboard.sinch.com](https://dashboard.sinch.com).

For more information on the SDK, refer to the dedicated [Java SDK documentation section](https://developers.sinch.com/docs/sdks/java) and the [Javadoc](https://www.javadoc.io/doc/com.sinch.sdk/sinch-sdk-java/latest/index.html). For the Sinch APIs on which this SDK is based, refer to the official [developer documentation portal](https://developers.sinch.com).


## Table of contents:

- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Getting started](#getting-started)
  - [Client initialization](#client-initialization)
  - [Client lifecycle](#client-lifecycle)
  - [Proxy configuration](#proxy-configuration)
- [Supported APIs](#supported-apis)
- [Getting started](#getting-started)
- [Logging](#logging)
- [Handling Exceptions](#handling-exceptions)
- [Third-party dependencies](#third-party-dependencies)
- [Examples](#examples)
- [Changelog and Migration](#changelog--migration)
- [License](#license)
- [Contact](#contact)

## Prerequisites

- [JDK 8 or later](https://www.java.com)
- [Maven](https://maven.apache.org/)
- [Sinch account](https://dashboard.sinch.com/)

> **Warning**:
> This SDK is intended for server-side (backend) use only. Do not use it in front-end or client-side applications (web, mobile, or desktop), regardless of language or framework. Doing so can expose your Sinch credentials to end-users.


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


## Supported APIs


| API Category    | API Name                                                            |
|-----------------|---------------------------------------------------------------------|
| Messaging       | [Conversation API](https://developers.sinch.com/docs/conversation/) |
|                 | [SMS API](https://developers.sinch.com/docs/sms/)                   |
| Voice and Video | [Voice API](https://developers.sinch.com/docs/voice/)               |
| Numbers         | [Numbers API](https://developers.sinch.com/docs/numbers/)           |
| Verification    | [Verification API](https://developers.sinch.com/docs/verification/) |
|                 | [Number Lookup API](https://developers.sinch.com/docs/number-lookup/) |

> **Note:** The SMS API is end-of-sale. New integrations should use the [Conversation API](https://developers.sinch.com/docs/conversation/) instead, which supports SMS and many other channels.


## Getting started

### Client initialization

To start using the SDK, initialize the main client class. This client gives you access to all the SDK services:

```java
import com.sinch.sdk.SinchClient;
import com.sinch.sdk.models.Configuration;

// Warning: not all APIs support project authentication. Check the section for each API before using this snippet.

Configuration configuration =
    Configuration.builder()
        .setProjectId(PROJECT_ID)
        .setKeyId(KEY_ID)
        .setKeySecret(KEY_SECRET)
        .build();

SinchClient client = new SinchClient(configuration);
```

Get `projectId`, `keyId` and `keySecret` from the [Access keys](https://dashboard.sinch.com/settings/access-keys) page in your Sinch dashboard (`keySecret` is shown only once, at creation time). It's highly recommended to not hardcode these credentials: load them from environment variables for local development, and from a secret manager in production.

This snippet is the common starting point for project-based API. Some APIs need a different initialization or extra parameters (for example, a region or application credentials), see the section for each API below.


### Conversation API

The Conversation API is regionalized. To use this API, the `conversationRegion` parameter is required:

```java
import com.sinch.sdk.SinchClient;
import com.sinch.sdk.models.Configuration;
import com.sinch.sdk.models.ConversationRegion;

Configuration configuration =
    Configuration.builder()
        .setProjectId(PROJECT_ID)
        .setKeyId(KEY_ID)
        .setKeySecret(KEY_SECRET)
        .setConversationRegion(ConversationRegion.EU)
        .build();

SinchClient client = new SinchClient(configuration);
```


#### Sinch Events

The Conversation API delivers asynchronous Sinch Events to the Event Destination URL you configure for your app in the [Conversation dashboard](https://dashboard.sinch.com/convapi/apps). `validateAuthenticationHeader` confirms a request comes from Sinch and `parseEvent` turns its payload into an event object. `headers` and `body` are the incoming request's headers and raw body:

```java
import com.sinch.sdk.domains.conversation.api.v1.SinchEventsService;
import com.sinch.sdk.domains.conversation.models.v1.sinchevents.ConversationSinchEvent;

SinchEventsService sinchEvents = sinchClient.conversation().v1().sinchEvents();

boolean validAuth = sinchEvents.validateAuthenticationHeader(sinchEventsSecret, headers, body);

ConversationSinchEvent event = sinchEvents.parseEvent(body);
```

`sinchEventsSecret` is set per app in the [Conversation dashboard](https://dashboard.sinch.com/convapi/apps). `parseEvent` works without validating the request, but then its origin can't be verified, so validating is recommended in production.

You can find a complete example in [examples/sinch-events](examples/sinch-events).

### SMS API

> **Warning:** the SMS API is end-of-sale. For new integrations, prefer the [Conversation API](#conversation-api).

The SMS API is regionalized: set `smsRegion` to the region where your SMS account is hosted. The accepted values are `US`, `EU`, `AU`, `BR` and `CA`, and the region also determines which credentials you can use:

- **Project access keys** — available only in the `US` and `EU` regions. Use the same `projectId`, `keyId` and `keySecret` as the common client, plus `smsRegion`:

```java
import com.sinch.sdk.SinchClient;
import com.sinch.sdk.models.Configuration;
import com.sinch.sdk.models.SMSRegion;

Configuration configuration =
    Configuration.builder()
        .setProjectId(PROJECT_ID)
        .setKeyId(KEY_ID)
        .setKeySecret(KEY_SECRET)
        .setSmsRegion(SMSRegion.US)
        .build();

SinchClient client = new SinchClient(configuration);
```

> **SMS authentication for new projects**
>
> Projects created after the SMS API end-of-sale (`15/04/26`) cannot use
> project access keys — the SMS API requests return `401 Unauthorized`.
>
> If you encounter this issue, consider the following options:
>
> 1. Use service plan credentials (`smsServicePlanId` + `smsApiToken`)
> 2. Use the Conversation API, which works with project access keys.
> 3. Contact your account manager

### Proxy configuration

If your network environment routes outbound traffic through an HTTP proxy, provide proxy configuration via `HttpProxyConfiguration` on the `Configuration` builder.

**Unauthenticated proxy:**

```java
import com.sinch.sdk.SinchClient;
import com.sinch.sdk.models.Configuration;
import com.sinch.sdk.models.HttpProxyConfiguration;

...
Configuration configuration = Configuration.builder()
        .setKeyId(PARAM_KEY_ID)
        .setKeySecret(PARAM_KEY_SECRET)
        .setProjectId(PARAM_PROJECT_ID)
        .setHttpProxyConfiguration(
                HttpProxyConfiguration.builder()
                        .setHostname(PARAM_PROXY_HOSTNAME)
                        .setPort(PARAM_PROXY_PORT)
                        .build())
        .build();
SinchClient client = new SinchClient(configuration);
```

**Authenticated proxy:**

```java
Configuration configuration = Configuration.builder()
        .setKeyId(PARAM_KEY_ID)
        .setKeySecret(PARAM_KEY_SECRET)
        .setProjectId(PARAM_PROJECT_ID)
        .setHttpProxyConfiguration(
              HttpProxyConfiguration.builder()
                  .setHostname(PARAM_PROXY_HOSTNAME)
                  .setPort(PARAM_PROXY_PORT)
                  .setUsername(PARAM_PROXY_USERNAME)
                  .setPassword(PARAM_PROXY_PASSWORD)
                  .build())
        .build();
SinchClient client = new SinchClient(configuration);
```

## Supported APIs
- **Service plan** — available in all regions (`US`, `EU`, `AU`, `BR`, `CA`). Use a `smsServicePlanId` and `smsApiToken`, both available on the [Service APIs dashboard](https://dashboard.sinch.com/sms/api/services):

```java
import com.sinch.sdk.SinchClient;
import com.sinch.sdk.models.Configuration;
import com.sinch.sdk.models.SMSRegion;

Configuration configuration =
    Configuration.builder()
        .setSmsServicePlanId(SERVICE_PLAN_ID)
        .setSmsApiToken(API_TOKEN)
        .setSmsRegion(SMSRegion.US)
        .build();

SinchClient client = new SinchClient(configuration);
```

#### Sinch Events

The SMS API delivers asynchronous Sinch Events to an Event Destination, whose URL is set per batch with the `eventDestinationTarget` parameter on the send, update and replace operations. `validateAuthenticationHeader` confirms a request comes from Sinch and `parseEvent` turns its payload into an event object. `headers` and `body` are the incoming request's headers and raw body:

```java
import com.sinch.sdk.domains.sms.api.v1.SinchEventsService;
import com.sinch.sdk.domains.sms.models.v1.sinchevents.SmsSinchEvent;

SinchEventsService sinchEvents = client.sms().v1().sinchEvents();

boolean validAuth = sinchEvents.validateAuthenticationHeader(sinchEventsSecret, headers, body);

SmsSinchEvent event = sinchEvents.parseEvent(body);
```

Signature authentication for SMS events must be enabled for your account by your account manager. Until it is activated, signature headers will not be present and `parseEvent` can be called directly without signature validation. See the [SMS events documentation](https://developers.sinch.com/docs/sms/api-reference/sms/tag/Webhooks/#tag/Webhooks/section/Callbacks).

You can find a complete example in [examples/sinch-events](examples/sinch-events).

### Numbers API

The Numbers API needs no extra parameters, use the [common client](#client-initialization) shown above.

#### Sinch Events

The Numbers API delivers asynchronous Sinch Events to the Event Destination URL you configure for your project through `sinchClient.numbers().v1().eventDestinations()`. `validateAuthenticationHeader` confirms a request comes from Sinch and `parseEvent` turns its payload into an event object. `headers` and `body` are the incoming request's headers and raw body:

```java
import com.sinch.sdk.domains.numbers.api.v1.SinchEventsService;
import com.sinch.sdk.domains.numbers.models.v1.sinchevents.NumberSinchEvent;

SinchEventsService sinchEvents = client.numbers().v1().sinchEvents();

boolean validAuth = sinchEvents.validateAuthenticationHeader(sinchEventsSecret, headers, body);

NumberSinchEvent event = sinchEvents.parseEvent(body);
```

`sinchEventsSecret` is the `HmacSecret` value configured on the Event Destination. `parseEvent` works without validating the request, but then its origin can't be verified, so validating is recommended in production.

You can find a complete example in [examples/sinch-events](examples/sinch-events).

### Number Lookup API

The Number Lookup API needs no extra parameters, use the [common client](#client-initialization) shown above.

### Verification API

The Verification API uses application credentials. Set `applicationKey` and `applicationSecret`, both available on the [Apps dashboard](https://dashboard.sinch.com/verification/apps):

```java
import com.sinch.sdk.SinchClient;
import com.sinch.sdk.models.Configuration;

Configuration configuration =
    Configuration.builder()
        .setApplicationKey(APPLICATION_KEY)
        .setApplicationSecret(APPLICATION_SECRET)
        .build();

SinchClient client = new SinchClient(configuration);
```

#### Sinch Events

The Verification API delivers synchronous Sinch Events to the Event Destination URL configured for your app. Requests are signed with your application credentials, so validation requires the HTTP verb and URI of the controller handling the request, in addition to the `headers` and raw `body`:

```java
import com.sinch.sdk.domains.verification.api.v1.SinchEventsService;

SinchEventsService sinchEvents = client.verification().v1().sinchEvents();

boolean validAuth = sinchEvents.validateAuthenticationHeader("POST", "/VerificationEvent", headers, body);

var event = sinchEvents.parseEvent(body);
```

Some events expect a response: build it from the business layer and serialize it with `sinchEvents.serializeResponse(response)` before returning it to Sinch.

You can find a complete example in [examples/sinch-events](examples/sinch-events).

### Voice API

The Voice API uses application credentials. Set `applicationKey` and `applicationSecret` (both available on the [Apps dashboard](https://dashboard.sinch.com/voice/apps)); `voiceRegion` is optional and defaults to a global region:

```java
import com.sinch.sdk.SinchClient;
import com.sinch.sdk.models.Configuration;
import com.sinch.sdk.models.VoiceRegion;

Configuration configuration =
    Configuration.builder()
        .setApplicationKey(APPLICATION_KEY)
        .setApplicationSecret(APPLICATION_SECRET)
        .setVoiceRegion(VoiceRegion.GLOBAL)
        .build();

SinchClient client = new SinchClient(configuration);
```

#### Sinch Events

The Voice API delivers synchronous Sinch Events to the Event Destination URL configured for your app. Requests are signed with your application credentials, so validation requires the HTTP verb and URI of the controller handling the request, in addition to the `headers` and raw `body`:

```java
import com.sinch.sdk.domains.voice.api.v1.SinchEventsService;

SinchEventsService sinchEvents = client.voice().v1().sinchEvents();

boolean validAuth = sinchEvents.validateAuthenticationHeader("POST", "/VoiceEvent", headers, body);

var event = sinchEvents.parseEvent(body);
```

Some events (for example an incoming call) expect a SVAML response: build it from the business layer and serialize it with `sinchEvents.serializeResponse(response)` before returning it to Sinch.

You can find a complete example in [examples/sinch-events](examples/sinch-events).


### Your first request

Once your client is configured, you can send your first message. The example below uses the Conversation API to send a simple text message over SMS. Replace `CONVERSATION_APP_ID` with your app ID, `SINCH_VIRTUAL_PHONE_NUMBER` with your Sinch number and `RECIPIENT_PHONE_NUMBER` with the recipient's phone number:

```java
import com.sinch.sdk.domains.conversation.models.v1.ChannelRecipientIdentities;
import com.sinch.sdk.domains.conversation.models.v1.ChannelRecipientIdentity;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.messages.AppMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.request.SendMessageRequest;
import com.sinch.sdk.domains.conversation.models.v1.messages.response.SendMessageResponse;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.text.TextMessage;
import java.util.Collections;

SendMessageRequest<TextMessage> request =
    SendMessageRequest.<TextMessage>builder()
        .setAppId("CONVERSATION_APP_ID")
        .setRecipient(
            ChannelRecipientIdentities.of(
                ChannelRecipientIdentity.builder()
                    .setChannel(ConversationChannel.SMS)
                    .setIdentity("RECIPIENT_PHONE_NUMBER")
                    .build()))
        .setMessage(
            AppMessage.<TextMessage>builder()
                .setBody(TextMessage.builder().setText("Hello from the Sinch Java SDK!").build())
                .build())
        .setChannelProperties(Collections.singletonMap("SMS_SENDER", "SINCH_VIRTUAL_PHONE_NUMBER"))
        .build();

SendMessageResponse response = client.conversation().messages().sendMessage(request);
```


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


## Handling exceptions

When a backend call is unsuccessful, the SDK throws an `ApiException` (from `com.sinch.sdk.core.exceptions`). It is the base class for all Sinch API exceptions and exposes the HTTP status code through `getCode()`.


```java
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.numbers.api.v1.NumbersService;

NumbersService numbersService = sinchClient.numbers().v1();

try {
    AvailableNumbersListResponse response =
        numbersService.searchForAvailableNumbers(
            AvailableNumbersListQueryParameters.builder()
                .setRegionCode("US")
                .setType(NumberType.LOCAL)
                .build());
} catch (ApiException e) {
    // e.getCode() holds the HTTP status code, e.getMessage() the error detail
}
```

`ApiException` is an unchecked exception, so wrapping calls in a `try/catch` is optional but recommended. Catching `ApiException` handles every error raised by an API call, including its more specific subclasses:

- `ApiAuthException`: authentication/authorization failures.
- `ApiMappingException`: the response payload could not be deserialized into the expected type.


## Third-party dependencies
The SDK relies on the following third-party dependencies:
- [Jackson](https://github.com/FasterXML/jackson-jakarta-rs-providers): provides JSON serialization/deserialization functionality.
- [Apache HTTP client](https://hc.apache.org/httpcomponents-client-ga/): manages communication with Sinch products' REST APIs.

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

## Examples

You can find:
 - self-contained code snippets covering every API operation in the [examples/snippets](./examples/snippets) folder.
 - getting started guides for specific use cases in the [examples/getting-started](./examples/getting-started) folder.
 - a Spring Boot server template to process received Sinch Events in the [examples/sinch-events](./examples/sinch-events) folder.
 - an SDK client template application in the [examples/client](./examples/client) folder.
 - step-by-step tutorials combining multiple SDK features in the [examples/tutorials](./examples/tutorials) folder.


## Changelog & Migration
For information about the latest changes in the SDK, please refer to the [CHANGELOG](CHANGELOG.md) file
and the [MIGRATION-GUIDE](MIGRATION-GUIDE.md) for instructions on how to update your code when upgrading to a new major version of the SDK.

## License

This project is licensed under the Apache License. See the [LICENSE](LICENSE) file for the license text.

## Contact

Developer Experience engineering team: [team-developer-experience@sinch.com](mailto:team-developer-experience@sinch.com)
