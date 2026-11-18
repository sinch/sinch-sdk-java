import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.voice.models.v2.batches.request.BatchOptions;
import com.sinch.sdk.domains.voice.models.v2.batches.request.StartBatchRequest;
import com.sinch.sdk.domains.voice.models.v2.batches.response.StartBatchResponse;
import com.sinch.sdk.domains.voice.models.v2.helpers.Calls;
import com.sinch.sdk.domains.voice.models.v2.helpers.CommandsSequenceCreator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class CreateBatch {

  private static final Logger LOGGER = Logger.getLogger(CreateBatch.class.getName());

  public static void main(String[] args) {

    String sinchNumber = Settings.get("SINCH_NUMBER", "MY_SINCH_NUMBER");
    List<String> recipients =
        Arrays.asList(Settings.get("DEST_1", "MY_DEST_1"), Settings.get("DEST_2", "MY_DEST_2"));
    int maxCps = Integer.parseInt(Settings.get("MAX_CPS", "5"));
    int ttlSeconds = Integer.parseInt(Settings.get("TTL_SECONDS", "1800"));

    SinchClient sinchClient = Settings.sinchClient();

    // `parameters` is a list; each entry queues one call using that entry's placeholder values.
    // One request, however many destinations.
    List<Map<String, String>> parameters = new ArrayList<>();
    for (String recipient : recipients) {
      parameters.add(Collections.singletonMap("toNumber", recipient));
    }

    // SVAML commands: dial @toNumber -> on answer TTS -> hangup
    StartBatchRequest request =
        StartBatchRequest.builder()
            .setCommands(
                CommandsSequenceCreator.create()
                    .dial(
                        "@toNumber",
                        dial ->
                            dial.from(sinchNumber)
                                .name("batch-reminder")
                                .timeoutDurationSeconds(30)
                                .maxDurationSeconds(120)
                                .onAnswer(
                                    answered ->
                                        answered.text(
                                            "Hello, this is an automated reminder from Sinch."
                                                + " Goodbye.",
                                            "Emma",
                                            reminder -> reminder.onFinish(Calls.hangup())))
                                .onHangup(Calls.hangup()))
                    .build())
            .setParameters(parameters)
            .setBatchOptions(
                BatchOptions.builder().setMaxCps(maxCps).setTtlSeconds(ttlSeconds).build())
            .build();

    LOGGER.info(
        String.format(
            "Submitting batch to %s (maxCps=%d, ttlSeconds=%d) ...",
            String.join(", ", recipients), maxCps, ttlSeconds));

    StartBatchResponse response = sinchClient.voice().v2().batches().start(request);

    LOGGER.info("Batch created: " + response);
  }
}
