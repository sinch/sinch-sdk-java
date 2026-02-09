# Sinch Tutorial: Qualify Leads (Java)

This directory contains samples related to Java SDK tutorials: [qualify leads](https://developers.sinch.com/docs/voice/tutorials/qualify-leads/java)

## DISCLAIMER

This tutorial is based on mixing a command-line function with a server-side backend service.

It is not a correct use of the CLI outside an educational purpose.

## Requirements

- JDK 21 or later
- [Maven](https://maven.apache.org/)
- [ngrok](https://ngrok.com/docs)
- [Sinch account](https://dashboard.sinch.com)

## Usage

### Configure application settings

Application settings are using the SpringBoot configuration file: [`application.yaml`](src/main/resources/application.yaml) file and enable to configure:

#### Required Sinch credentials

Located in `credentials` section (*you can find all the credentials you need on your [Sinch dashboard](https://dashboard.sinch.com)*):

- `application-api-key`: YOUR_application_key
- `application-api-secret`: YOUR_application_secret

#### Other required values

This tutorial uses other values that you should also assign:

- `sinch-number`: This is the Sinch number assigned to your [Voice app](https://dashboard.sinch.com/voice/apps).
- `sip-address`: If you are performing this tutorial with a SIP infrastructure, this is where you would enter your SIP address.

#### Server port

Located in `server` section:

- port: The port to be used to listen to incoming requests. <em>Default: 8090</em>

### Starting server locally

Compile and run the application as server locally.

```bash
mvn spring-boot:run
```

### Use ngrok to forward request to local server

Forwarding request to same `8090` port used above:

*Note: The `8090` value is coming from default config and can be changed (see [Server port](#Server-port) configuration section)*

```bash
ngrok http 8090
```

ngrok output will contains output like:

```shell
ngrok                                                                                                                                                                                                                          (Ctrl+C to quit)

...
Forwarding                    https://0e64-78-117-86-140.ngrok-free.app -> http://localhost:8090

```

The line

```shell
Forwarding                    https://0e64-78-117-86-140.ngrok-free.app -> http://localhost:8090
```

Contains `https://0e64-78-117-86-140.ngrok-free.app` value.

This value must be used to configure the callback URL on your [Sinch dashboard](https://dashboard.sinch.com/voice/apps)