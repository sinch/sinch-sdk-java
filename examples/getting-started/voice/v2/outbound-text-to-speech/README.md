# Getting Started: Make an Outbound Text-to-Speech Call (Voice API v2)

This code is related to [Make an outbound call with text-to-speech](https://developers.sinch.com/docs/voice-2.0/tutorials/outbound-tts).

It places a call to a recipient phone number through the Voice API v2, using
the [Sinch Java SDK](https://github.com/sinch/sinch-sdk-java). When the call is answered, it plays an audio file
followed by a text-to-speech message, then hangs up.

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
- `SINCH_NUMBER`: the Sinch number used as caller ID, in E.164 format (e.g. `+14045001000`)
- `DESTINATION_NUMBER`: the phone number to call, in E.164 format (e.g. `+14155551234`)

## Usage

1. Navigate to this directory:
   ```bash
   cd examples/getting-started/voice/v2/outbound-text-to-speech
   ```

2. Run the code ([Callout.java](src/main/java/Callout.java)):
   ```bash
   mvn compile exec:java
   ```
