# Backend application using Sinch Java SDK to handle incoming Sinch Events

This directory contains a Spring Boot server example built with the [Sinch SDK Java](https://github.com/sinch/sinch-sdk-java).

## Requirements

- JDK 21 or later
- A [Sinch account](https://dashboard.sinch.com)
- [ngrok](https://ngrok.com/docs) (or equivalent tunnel) for local callback testing

> This example is started with the Maven wrapper (`./mvnw`), so a separate Maven installation is optional.

## Configuration

Application settings are defined in [`src/main/resources/application.yaml`](src/main/resources/application.yaml).

This skeleton focuses on receiving and validating incoming Sinch events. 

If you only handle (parse and or validate) Sinch Events, you usually only need secret values.

Credentials to call Sinch APIs are optional and already shown as commented entries in the config file.

### Sinch Events secret settings

Use these keys when request authentication is enabled in each controller (`ensureValidAuthentication = true`):

- `conversation.sinchevents.secret` for Conversation callbacks
- `numbers.sinchevents.secret` for Numbers callbacks
- `sms.sinchevents.secret` for SMS callbacks

### Voice and Verification authentication

Voice and Verification callback validation uses application credentials:

- `credentials.application-api-key`
- `credentials.application-api-secret`

### Server port

Default port is `8090`.

In `application.yaml`:

- `server.port`: port used by the local server

## Usage

### Start the server

1. Update [`src/main/resources/application.yaml`](src/main/resources/application.yaml) with your values.
2. Run the app:

```bash
./mvnw clean spring-boot:run
```

### Sinch Event endpoints

When the server is running, controllers listen on:

| Service | Endpoint |
|---|---|
| [Conversation](https://developers.sinch.com/docs/conversation/callbacks) | `/ConversationEvent` |
| [Numbers](https://developers.sinch.com/docs/numbers/api-reference/numbers/tag/Numbers-Callbacks/#tag/Numbers-Callbacks/operation/ImportedNumberService_EventsCallback) | `/NumbersEvent` |
| [SMS](https://developers.sinch.com/docs/sms/api-reference/sms/tag/Webhooks/#tag/Webhooks/section/Callbacks) | `/SmsEvent` |
| [Verification](https://developers.sinch.com/docs/verification/api-reference/verification/tag/Verification-callbacks/) | `/VerificationEvent` |
| [Voice](https://developers.sinch.com/docs/voice/api-reference/voice/tag/Callbacks/) | `/VoiceEvent` |

## Expose local server with ngrok

Forward traffic to local port `8090` (or your configured `server.port`):

```bash
ngrok http 8090
```

You should see output like:

```text
Forwarding  https://0e64-78-117-86-140.ngrok-free.app -> http://localhost:8090
```

Use the public URL (`https://0e64-78-117-86-140.ngrok-free.app` in this example) as the base URL for callbacks in the Sinch Dashboard.

Example callback URLs:

- `https://<your-ngrok-domain>/ConversationEvent`
- `https://<your-ngrok-domain>/NumbersEvent`
- `https://<your-ngrok-domain>/SmsEvent`
- `https://<your-ngrok-domain>/VerificationEvent`
- `https://<your-ngrok-domain>/VoiceEvent`

Dashboard: [Sinch Dashboard](https://dashboard.sinch.com)
