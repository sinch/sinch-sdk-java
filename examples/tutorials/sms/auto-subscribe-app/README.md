# auto-subscribe application sample

This directory contains sample related to Java SDK tutorials: [](https://developers.sinch.com/docs/sms/tutorials/sms/tutorials/java-sdk/auto-subscribe)

## Requirements
-
- JDK 21 or later
- [Maven](https://maven.apache.org/)
- [ngrok](https://ngrok.com/docs)
- [Sinch account](https://dashboard.sinch.com)

## Usage

### Configure application settings

Application settings is using the SpringBoot configuration file: [`application.yaml`](src/main/resources/application.yaml) file and set:

#### Sinch credentials
Located in `credentials` section:
- `key-id`: YOUR_access_key
- `key-secret`: YOUR_access_secret
- `project-id`: YOUR_project_id

#### Server port
Located in `server` section:
- port: The port to be used to listen incoming request. <em>Default: 8090</em>

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

This value is having to be used to configure your callback from [Sinch dashboard](https://dashboard.sinch.com/sms/api/services)