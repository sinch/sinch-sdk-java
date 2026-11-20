import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.voice.models.v2.batches.response.BatchSummary;
import java.util.logging.Logger;

public class PollBatch {

  private static final Logger LOGGER = Logger.getLogger(PollBatch.class.getName());

  public static void main(String[] args) throws InterruptedException {

    String batchId = Settings.get("BATCH_ID", "MY_BATCH_ID");

    SinchClient sinchClient = Settings.sinchClient();

    // Poll the batch summary every 5s until all call sessions reach a final state,
    // giving up after 60 checks (about 5 minutes)
    int maxAttempts = 60;
    for (int attempt = 1; attempt <= maxAttempts; attempt++) {
      BatchSummary response = sinchClient.voice().v2().batches().get(batchId);

      LOGGER.info(response.toString());

      if (response.getQueued() == 0 && response.getInProgress() == 0) {
        LOGGER.info("All call sessions finished.");
        return;
      }

      Thread.sleep(5_000);
    }

    LOGGER.severe(
        String.format(
            "Batch %s still has call sessions running after %d attempts", batchId, maxAttempts));
    System.exit(1);
  }
}
