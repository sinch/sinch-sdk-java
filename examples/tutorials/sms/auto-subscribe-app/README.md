# auto-subscribe application sample

This directory contains sample related to Java SDK tutorials: [](https://developers.sinch.com/docs/sms/tutorials/sms/tutorials/java-sdk/auto-subscribe)

## Requirements
-
- JDK 21 or later
- [Maven](https://maven.apache.org/)
- [ngrok](https://ngrok.com/docs)
- [Sinch account](https://dashboard.sinch.com)
- 
## Usage

### Starting server locally

Compile and run the application as server onto you localhost.
Server will be run to listen `8090` port:
```bash
mvn spring-boot:run -Dspring-boot.run.arguments=--server.port=8090
```

### Use ngrok to forward request to local server

Forwarding request to same `8090` port used above:
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