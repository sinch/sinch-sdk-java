# Getting Started: Detect Voicemail & Beeps (AMD) (Voice API v2)

This code is related to [Detect Voicemail & Beeps (AMD)](https://developers.sinch.com/docs/voice-2.0/tutorials/amd).

It uses Answering Machine Detection (AMD) through the Voice API v2, using the
[Sinch Java SDK](https://github.com/sinch/sinch-sdk-java). The `amd` command analyses the call audio once it is
answered and runs a different branch of SVAML commands depending on the verdict:

- `onHuman`: a live person picked up. Plays a greeting, then hangs up.
- `onMachine`: a machine answered and is playing its greeting (beep not yet detected). Hangs up silently.
- `onBeep`: a voicemail beep was detected. Leaves a voicemail message, then hangs up.
- `onUnknown`: detection was inconclusive. Hangs up.

There are two ways to run it:

- [AmdCallout.java](src/main/java/AmdCallout.java) places an outbound call to `DESTINATION_NUMBER` with `amd` as the
  first command of the dial's `onAnswer` event. No webhook server is needed: the matching branch runs on the call
  itself.
- The [server](src/main/java/com/mycompany/app/voice) is a Spring Boot webhook server that, on `call.incoming`, answers
  the call and runs `amd`. It also logs the `call.amd.*` verdict events Sinch posts back, so you can see which branch
  fired.

## Requirements

- [JDK 21 or later](https://www.oracle.com/java/technologies/downloads/)
- [Maven](https://maven.apache.org/)
- [Sinch account](https://dashboard.sinch.com/)
- A Sinch virtual number assigned to a Voice service
- [ngrok](https://ngrok.com/docs) (or similar) to expose your local server (for the server)

## Configuration

Set the following values in [config.properties](src/main/resources/config.properties) (or `export` them as
environment variables, which win over the file):

- `SINCH_PROJECT_ID`: your Sinch Project ID
- `SINCH_KEY_ID`: your Sinch Access Key ID
- `SINCH_KEY_SECRET`: your Sinch Key Secret associated to your Sinch Access Key
- `SINCH_NUMBER`: your Sinch number, in E.164 format (e.g. `+14045001000`)
- `DESTINATION_NUMBER`: the number to call with `AmdCallout`, in E.164 format (e.g. `+14155551234`)
- `PORT` (optional, default `3000`): the local server port
- `SINCH_SERVICE_ID` / `SINCH_SERVICE_SECRET` (optional): the service that owns your Sinch number and its secret.
  When set, the server rejects (`401`) any request not signed with that secret

## Usage

1. Navigate to this directory:
   ```bash
   cd examples/getting-started/voice/v2/answering-machine-detection
   ```

### Inline AMD callout (fastest path)

2. Place the call:
   ```bash
   mvn compile exec:java -Dexec.mainClass=AmdCallout
   ```
   The script only confirms the call was created; it does not print which AMD branch fired. Answer the phone to hear
   it: a person answering hears the greeting, and a voicemail gets the message right after the beep. To see the
   verdict server-side, use the callback server below.

### Dynamic AMD via a callback server

2. Start the server:
   ```bash
   mvn spring-boot:run
   ```
   The server listens on `PORT` (default `3000`) at `POST /webhook`.

3. Expose the server with ngrok:
   ```bash
   ngrok http 3000
   ```

4. Set the HTTPS URL ngrok prints plus the `/webhook` path (e.g. `https://<id>.ngrok-free.app/webhook`) as your
   service's webhook in the Sinch dashboard. See the
   [Handle Inbound PSTN Call](../handle-inbound-pstn-call) example to do it with the SDK.

5. Call `SINCH_NUMBER` from any phone. The server logs the AMD verdict:

   | Scenario         | On the answering phone                   | In the server log                    |
   |------------------|------------------------------------------|--------------------------------------|
   | Human answers    | Hears the greeting                       | `call.amd.human`                     |
   | Voicemail        | Beep, then hears the voicemail message   | `call.amd.machine`, `call.amd.beep`  |
   | Machine, no beep | Silence, then hangup                     | `call.amd.machine`                   |
   | Inconclusive     | Hangup                                   | `call.amd.unknown`                   |
