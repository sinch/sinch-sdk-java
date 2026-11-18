# Getting Started: Call Forwarding (Voice API v2)

This code is related to [Call Forwarding](https://developers.sinch.com/docs/voice-2.0/tutorials/call-forwarding).

It places an outbound call to your own phone through the Voice API v2, using
the [Sinch Java SDK](https://github.com/sinch/sinch-sdk-java). When you answer, it plays a hold prompt and tries a
primary number. If nobody picks up within 20 seconds, it tries a fallback number instead. Whichever destination answers
is bridged with you. No webhook server is needed.

## Requirements

- [JDK 8 or later](https://www.oracle.com/java/technologies/downloads/)
- [Maven](https://maven.apache.org/)
- [Sinch account](https://dashboard.sinch.com/)
- A Sinch virtual number assigned to a Voice service

## Configuration

Set the following values in [config.properties](src/main/resources/config.properties) (or `export` them as
environment variables, which win over the file):

- `SINCH_PROJECT_ID`: your Sinch Project ID
- `SINCH_KEY_ID`: your Sinch Access Key ID
- `SINCH_KEY_SECRET`: your Sinch Key Secret associated to your Sinch Access Key
- `SINCH_NUMBER`: the Sinch number used as caller ID, in E.164 format (e.g. `+15551234567`)
- `CALLER_NUMBER`: your mobile, in E.164 format (answer this one)
- `PRIMARY_NUMBER`: the primary number, in E.164 format (let this ring out)
- `FALLBACK_NUMBER`: the fallback number, in E.164 format (should ring after the primary times out)

## Usage

1. Navigate to this directory:
   ```bash
   cd examples/getting-started/voice/v2/call-forwarding
   ```

2. Run the code ([ForwardCall.java](src/main/java/ForwardCall.java)):
   ```bash
   mvn compile exec:java
   ```
