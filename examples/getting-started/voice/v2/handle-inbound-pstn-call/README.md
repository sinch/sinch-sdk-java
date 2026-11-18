# Getting Started: Handle Inbound PSTN Calls (Voice API v2)

This code is related to [Handle Inbound PSTN Calls](https://developers.sinch.com/docs/voice-2.0/tutorials/inbound-pstn).

It uses the Voice API v2 through the [Sinch Java SDK](https://github.com/sinch/sinch-sdk-java):

- [Validate.java](src/main/java/Validate.java) checks the SVAML you intend to return with `POST /svaml/validate`,
  using the same rules as a live call (no phone needed).
- The [server](src/main/java/com/mycompany/app/voice) is a Spring Boot webhook server that, on `call.incoming`, answers
  the call, plays a greeting, and bridges the caller to an agent phone number (`DESTINATION_NUMBER`).
- [SmokeTest.java](src/main/java/SmokeTest.java) sends a simulated `call.incoming` event to the local server.
- [ConfigureService.java](src/main/java/ConfigureService.java) points your Voice service's call events at the server.

## Requirements

- [JDK 21 or later](https://www.oracle.com/java/technologies/downloads/)
- [Maven](https://maven.apache.org/)
- [Sinch account](https://dashboard.sinch.com/)
- A Voice API v2 service with a Sinch number associated to it
- [ngrok](https://ngrok.com/docs) (or similar) to expose your local server

## Configuration

Set the following values in [config.properties](src/main/resources/config.properties) (or `export` them as
environment variables, which win over the file). The server and the scripts read the same settings:

- `SINCH_PROJECT_ID`: your Sinch Project ID
- `SINCH_KEY_ID`: your Sinch Access Key ID
- `SINCH_KEY_SECRET`: your Sinch Key Secret associated to your Sinch Access Key
- `SINCH_SERVICE_ID`: the ID of the Voice service that owns your Sinch number (Dashboard → Voice → Services),
  used by `ConfigureService` and to validate the request signature
- `SINCH_SERVICE_SECRET` (optional): the secret of that service. When set, the server rejects (`401`) any request not
  signed with it. Leave it empty to run the smoke test, which sends unsigned requests
- `SINCH_NUMBER`: your Sinch number, in E.164 format (e.g. `+14045001000`)
- `DESTINATION_NUMBER`: the agent number the call bridges to, in E.164 format (e.g. `+14155559876`)
- `PORT` (optional, default `3000`): the local server port
- `WEBHOOK_URL`: the public URL of the server, set in step 5 below

## Usage

1. Navigate to this directory:
   ```bash
   cd examples/getting-started/voice/v2/handle-inbound-pstn-call
   ```

2. Smoke-test your SVAML (no phone needed):
   ```bash
   mvn compile exec:java -Dexec.mainClass=Validate
   ```
   Expected: `isValid=true`. A successful request means validation ran, not that the payload passed; always read
   `isValid`.

3. Start the server:
   ```bash
   mvn spring-boot:run
   ```
   The server listens on `PORT` (default `3000`) at `POST /voice/events`.

4. In another terminal, smoke-test the server locally. You should get back the SVAML JSON and see a log line on the
   server:
   ```bash
   mvn compile exec:java -Dexec.mainClass=SmokeTest
   ```

5. Expose the server with ngrok:
   ```bash
   ngrok http 3000
   ```
   Set `WEBHOOK_URL` to the HTTPS URL ngrok prints plus the `/voice/events` path
   (e.g. `https://<id>.ngrok-free.app/voice/events`).

6. Point the service at your server:
   ```bash
   mvn compile exec:java -Dexec.mainClass=ConfigureService
   ```
   The same URL is set as `fallbackUrl`: once the primary URL starts returning errors, Sinch switches future requests
   to the fallback.

7. Call `SINCH_NUMBER` from any phone. You should hear the greeting, then `DESTINATION_NUMBER` rings. Answer it and the
   two legs are bridged. If the agent doesn't answer within 30 seconds the call hangs up.
