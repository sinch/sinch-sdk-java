# Getting Started: Mask a Phone Call (Number Masking) (Voice API v2)

This code is related to [Mask a Phone Call (Number Masking)](https://developers.sinch.com/docs/voice-2.0/tutorials/number-masking).

It connects two parties through your Sinch number so neither sees the other's real phone number, using the Voice API
v2 through the [Sinch Java SDK](https://github.com/sinch/sinch-sdk-java):

- [Validate.java](src/main/java/Validate.java) checks the masking SVAML that the server returns with
  `POST /svaml/validate` in `STRICT` mode, using the same rules as a live call (no phone needed).
- The [server](src/main/java/com/mycompany/app/voice) is a Spring Boot webhook server that, on `call.incoming`, answers
  Party A, plays a hold greeting, adds Party A to a bridge and dials `DESTINATION_NUMBER` (Party B) from the Sinch
  number.
- [ConfigureService.java](src/main/java/ConfigureService.java) points your Voice service's call events at the server.
- [MaskedBridgeCall.java](src/main/java/MaskedBridgeCall.java) triggers a fully outbound masked bridge: it dials
  Party A and, once answered, dials Party B and bridges them. No webhook server is needed.

## Requirements

- [JDK 21 or later](https://www.oracle.com/java/technologies/downloads/)
- [Maven](https://maven.apache.org/)
- [Sinch account](https://dashboard.sinch.com/)
- A Voice API v2 service with a Sinch number associated to it
- [ngrok](https://ngrok.com/docs) (or similar) to expose your local server (for the server)

## Configuration

Set the following values in [config.properties](src/main/resources/config.properties) (or `export` them as
environment variables, which win over the file). The server and the scripts read the same settings:

- `SINCH_PROJECT_ID`: your Sinch Project ID
- `SINCH_KEY_ID`: your Sinch Access Key ID
- `SINCH_KEY_SECRET`: your Sinch Key Secret associated to your Sinch Access Key
- `SINCH_SERVICE_ID`: the ID of the Voice service that owns your Sinch number (Dashboard → Voice → Services),
  used by `ConfigureService`
- `SINCH_NUMBER`: your Sinch number, in E.164 format (e.g. `+14045001000`). This is the masking number both
  parties see
- `DESTINATION_NUMBER`: Party B, the number the inbound caller gets bridged to, in E.164 format
  (e.g. `+15551234567`)
- `PORT` (optional, default `3000`): the local server port
- `WEBHOOK_URL`: the public URL of the server, set in step 4 below
- `PARTY_A_NUMBER` / `PARTY_B_NUMBER` (optional): the two parties `MaskedBridgeCall` bridges, in E.164 format.
  They default to `DESTINATION_NUMBER` and `SINCH_NUMBER`, so out of the box one leg dials your Sinch number
  itself. For a real two-party test, set both to phones you can answer

## Usage

1. Navigate to this directory:
   ```bash
   cd examples/getting-started/voice/v2/number-masking
   ```

2. Smoke-test the SVAML (no phone needed):
   ```bash
   mvn compile exec:java -Dexec.mainClass=Validate
   ```
   Expected: `isValid=true`. A successful request means validation ran, not that the payload passed; always read
   `isValid`.

3. Start the server:
   ```bash
   mvn spring-boot:run
   ```
   The server listens on `PORT` (default `3000`) at `POST /webhook`.

4. Expose the server with ngrok:
   ```bash
   ngrok http 3000
   ```
   Set `WEBHOOK_URL` to the HTTPS URL ngrok prints plus the `/webhook` path
   (e.g. `https://<id>.ngrok-free.app/webhook`).

5. Point the service at your server:
   ```bash
   mvn compile exec:java -Dexec.mainClass=ConfigureService
   ```
   The same URL is set as `fallbackUrl`: once the primary URL starts returning errors, Sinch switches future requests
   to the fallback.

6. Call `SINCH_NUMBER` from a phone (this is Party A). Party A hears the hold greeting, then `DESTINATION_NUMBER`
   (Party B) rings and sees the Sinch number as the caller ID. Once Party B answers, both parties are bridged. When
   either party hangs up, the other leg drops.

### Trigger a fully outbound masked bridge

To have your platform initiate the call to both parties instead:

```bash
mvn compile exec:java -Dexec.mainClass=MaskedBridgeCall
```

Party A is dialed first; once answered, Party A hears a hold message and Party B is dialed. Both parties see the
Sinch number as the caller ID.
