# Getting Started: Track Call Status (Voice API v2)

This code is related to [Track Call Status](https://developers.sinch.com/docs/voice-2.0/tutorials/track-call-status).

It shows the two ways to know what is happening with a call in the Voice API v2, using the
[Sinch Java SDK](https://github.com/sinch/sinch-sdk-java):

- **Events (recommended for real-time).** Sinch pushes lifecycle events (`call.incoming`, `call.answered`,
  `call.hangup`, ...) to your server as they happen:
  - The [server](src/main/java/com/mycompany/app/voice) is a minimal Spring Boot event receiver that logs every event
    with its CloudEvents headers. It answers `call.incoming` with a short goodbye and acknowledges every other event
    with no commands.
- **Polling (fallback / on-demand).** Read the platform's authoritative state when you cannot run a public endpoint, for
  reconciliation and reporting, or to recover events you may have missed:
  - [TrackSession.java](src/main/java/TrackSession.java) starts an outbound call, then polls its session until it
    reaches `COMPLETED`, with a bounded number of attempts and backoff, and logs the result of each call leg.

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
- `DESTINATION_NUMBER`: the number to call with `TrackSession`, in E.164 format (e.g. `+14155551234`)
- `PORT` (optional, default `3000`): the local server port

## Usage

1. Navigate to this directory:
   ```bash
   cd examples/getting-started/voice/v2/track-call-status
   ```

### Track a call in real time with events

2. Start the receiver:
   ```bash
   mvn spring-boot:run
   ```
   The server listens on `PORT` (default `3000`) at `POST /voice/events`.

3. Expose the server with ngrok:
   ```bash
   ngrok http 3000
   ```

4. Set the HTTPS URL ngrok prints plus the `/voice/events` path (e.g. `https://<id>.ngrok-free.app/voice/events`) as
   your service's webhook in the Sinch dashboard. See the [Handle Inbound PSTN Call](../handle-inbound-pstn-call)
   example to do it with the SDK.

5. Start an outbound call (e.g. with `TrackSession`), or call `SINCH_NUMBER` from any phone. The server logs each
   event as it arrives. When `call.hangup` arrives with a final `callResult`, the call is done.

### Poll call state

2. Start a call and poll it to completion:
   ```bash
   mvn compile exec:java -Dexec.mainClass=TrackSession
   ```
   A healthy outbound call walks the session through `QUEUED` → `IN_PROGRESS` → `COMPLETED`, then the script logs
   each call leg, e.g. `callResult=COMPLETED callReason=CALLEE_HANGUP`. If nobody answers, the leg shows
   `callResult=NO_ANSWER` and the session still reaches `COMPLETED`.
