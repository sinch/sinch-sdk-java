# Handle Inconing Call webhook application sample

This directory contains sample related to Java SDK tutorial: [Handle incoming call](https://developers.sinch.com/docs/voice/getting-started/java/incoming-call)

## Requirements

- JDK 21 or later
- [Maven](https://maven.apache.org/)
- [ngrok](https://ngrok.com/docs)
- [Sinch account](https://dashboard.sinch.com)

## Usage

### Configure application settings

Application settings is using the SpringBoot configuration file: [`application.yaml`](src/main/resources/application.yaml) file and set:

#### Sinch credentials
Located in `credentials` section (*you can find Voice application credentials you need on your [Sinch dashboard](https://dashboard.sinch.com/voice/apps)*):
- `api-id`: YOUR_Voice_Application_Id
- `api-secret`: YOUR_Voice_Application_Secret

#### Webhook controller path
Located in `voice` section you can modify: 
- `controller-path`: path the server will respond to. <em>Default: /voice</em>

#### Server port
Located in `server` section:
- port: The port to be used for listening for incoming requests. <em>Default: 8090</em>

### Starting server locally

Compile and run the application as server onto you localhost.
```bash
mvn spring-boot:run
```

### Use ngrok to forward request to local server

Forwarding request to same `8090` port used above:

*Note: The `8090` value is coming from default config and can be changed (see [Server port](#Server port) configuration section)*

```bash
ngrok http 8090
```

ngrok output will contain output like the following:
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

## Configure Voice application callback

You have now a local web server responding to `/voice` path and `ngrok` instance running providing a bridge from `https://0e64-78-117-86-140.ngrok-free.app` onto local webserver.

Last step is now to configure your dashboard to set Voice application callback to point your local webserver.

The callback to be called by sinch will be in form of: `<bridge host>`/`<web server controller path>`

e.g. According to previous sample values: https://0e64-78-117-86-140.ngrok-free.app/voice

1. Go to your Voice application configuration: [Sinch Voice Apps dashboard](https://dashboard.sinch.com/voice/apps/)
2. Edit the application setting related to the Application ID set from config file (see [Sinch credentials](#configure-application-settings))
3. Fill `Callback URL` field with *https://0e64-78-117-86-140.ngrok-free.app/voice*

You can now perform a to your number, the webhook will be called and serve response to callee.
