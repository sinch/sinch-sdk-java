import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.voice.models.v2.Call;
import com.sinch.sdk.domains.voice.models.v2.SessionState;
import com.sinch.sdk.domains.voice.models.v2.calls.request.StartCallRequest;
import com.sinch.sdk.domains.voice.models.v2.calls.response.StartCallResponse;
import com.sinch.sdk.domains.voice.models.v2.helpers.Calls;
import com.sinch.sdk.domains.voice.models.v2.helpers.CommandsSequenceCreator;
import com.sinch.sdk.domains.voice.models.v2.sessions.response.Session;
import java.util.logging.Logger;

public class TrackSession {

  private static final Logger LOGGER = Logger.getLogger(TrackSession.class.getName());

  public static void main(String[] args) throws InterruptedException {

    String sinchNumber = Settings.get("SINCH_NUMBER", "MY_SINCH_NUMBER");
    String destinationNumber = Settings.get("DESTINATION_NUMBER", "MY_DESTINATION_NUMBER");

    SinchClient sinchClient = Settings.sinchClient();

    StartCallRequest request =
        StartCallRequest.builder()
            .setCommands(
                CommandsSequenceCreator.create()
                    .dial(
                        destinationNumber,
                        dial ->
                            dial.from(sinchNumber)
                                .name("tracked")
                                .timeoutDurationSeconds(30)
                                .onAnswer(
                                    answered ->
                                        answered.text(
                                            "This call is being tracked. Goodbye.",
                                            "Emma",
                                            goodbye -> goodbye.onFinish(Calls.hangup())))
                                .onHangup(Calls.hangup()))
                    .build())
            .build();

    // 1. Start the call. Inline events play a short message and hang up.
    StartCallResponse start = sinchClient.voice().v2().calls().start(request);
    String sessionId = start.getSessionId();
    LOGGER.info("Started sessionId=" + sessionId);

    // 2. Poll until COMPLETED (the final state of a session started this way), bounded with
    // backoff.
    long delayMillis = 2_000;
    long maxDelayMillis = 15_000;
    int maxAttempts = 40;
    boolean completed = false;
    for (int attempt = 0; attempt < maxAttempts; attempt++) {
      SessionState state = sinchClient.voice().v2().sessions().get(sessionId).getState();
      LOGGER.info("state=" + state);
      if (SessionState.COMPLETED.equals(state)) {
        completed = true;
        break;
      }
      Thread.sleep(delayMillis);
      delayMillis = Math.min(delayMillis * 2, maxDelayMillis);
    }

    if (!completed) {
      LOGGER.severe(
          String.format(
              "Session %s did not reach COMPLETED after %d attempts", sessionId, maxAttempts));
      System.exit(1);
    }

    // 3. Print per-leg results (callName is NOT returned by the API).
    Session session = sinchClient.voice().v2().sessions().get(sessionId);
    for (Call call : session.getCalls()) {
      LOGGER.info(
          String.format(
              "callId=%s callResult=%s callReason=%s callDurationSeconds=%s answerTime=%s",
              call.getCallId(),
              call.getCallResult(),
              call.getCallReason(),
              call.getCallDurationSeconds(),
              call.getAnswerTime()));
    }
  }
}
