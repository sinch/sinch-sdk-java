# Backend application built using Sinch Java SDK to handle incoming webhooks

This directory contains a server application based onto [Sinch SDK java](https://github.com/sinch/sinch-sdk-java)

## Requirements

- JDK 21 or later (Sinch SDK Java is requiring java 8 only but client application can use latest available version)
- [Maven](https://maven.apache.org/)
- [SpringBoot](https://spring.io/projects/spring-boot)
- [Sinch account](https://dashboard.sinch.com)
- [ngrok](https://ngrok.com/docs)

## Configuration

### Configure application settings

com.mycompany.app.Application settings are using the `SpringBoot` configuration file: [`application.yaml`](src/main/resources/application.yaml) file and enable to configure:

#### Sinch credentials
Located in `credentials` section (*you can find all of the credentials you need on your [Sinch dashboard](https://dashboard.sinch.com)*):
- `project-id`: YOUR_project_id
- `key-id`: YOUR_access_key_id
- `key-secret`: YOUR_access_key_secret

#### Server port
<em>Default: 8090</em>

Located in `server` section:
- port: The port to be used to listen to incoming requests. <em>Default: 8090</em>

## Usage

### Start server
1. Edit configuration file

   See above for Configuration paragraph

2. Start server locally.

   Compile and run the application as server locally.
   ```bash
   ./mvnw clean spring-boot:run
   ```
### EndPoints
When server is online, declared controllers will respond to following endpoints

| Service                                                                                                                                                                | Endpoint          | 
|------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-------------------|
| [Conversation](https://developers.sinch.com/docs/conversation/callbacks)                                                                                               | /ConversationEvent |
| [Numbers](https://developers.sinch.com/docs/numbers/api-reference/numbers/tag/Numbers-Callbacks/#tag/Numbers-Callbacks/operation/ImportedNumberService_EventsCallback) | /NumbersEvent     |
| [SMS](https://developers.sinch.com/docs/sms/api-reference/sms/tag/Webhooks/#tag/Webhooks/section/Callbacks)                                                            | /SmsEvent         |
| [Verification](https://developers.sinch.com/docs/verification/api-reference/verification/tag/Verification-callbacks/)                                                  | /VerificationEvent |
| [Voice](https://developers.sinch.com/docs/voice/api-reference/voice/tag/Callbacks/)                                                                                                                                                              | /VoiceEvent       |

## Use ngrok to forward request to local server

Forwarding request to same `8090` port used above:

*Note: The `8090` value is coming from default config and can be changed (see [Server port](#Server port) configuration section)*

```bash
ngrok http 8090
```

ngrok output will contains output like:
```
ngrok                                                                                                                                                                                                                          (Ctrl+C to quit)

...
Forwarding                    https://0e64-78-117-86-140.ngrok-free.app -> http://localhost:8090

```
The line
```
Forwarding                    https://0e64-78-117-86-140.ngrok-free.app -> http://localhost:8090
```
Contains `https://0e64-78-117-86-140.ngrok-free.app` value.

This value must be used to configure callback's URL from your [Sinch dashboard](https://dashboard.sinch.com/sms/api/services)