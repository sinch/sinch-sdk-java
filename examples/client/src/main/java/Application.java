import com.sinch.sdk.SinchClient;
import conversation.ConversationQuickStart;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import numbers.NumbersQuickStart;
import sms.SmsQuickStart;
import verification.VerificationQuickStart;
import voice.VoiceQuickStart;

public abstract class Application {

  private static final String LOGGING_PROPERTIES_FILE = "logging.properties";
  private static final Logger LOGGER = initializeLogger();

  public static void main(String[] args) {
    try {

      SinchClient client = SinchClientHelper.initSinchClient();
      LOGGER.info("Application initiated. SinchClient ready.");

      // Conversation service dedicated business logic processing
      // (see https://developers.sinch.com/docs/conversation)
      // comment if unused
      if (client.getConfiguration().getUnifiedCredentials().isPresent()) {
        ConversationQuickStart conversation =
            new ConversationQuickStart(client.conversation().v1());
      }

      // Numbers service dedicated business logic processing
      // (see https://developers.sinch.com/categories/numbersandconnectivity)
      // comment if unused
      if (client.getConfiguration().getUnifiedCredentials().isPresent()) {
        NumbersQuickStart numbers = new NumbersQuickStart(client.numbers().v1());
      }

      // SMS service dedicated business logic processing
      // (see https://developers.sinch.com/docs/sms)
      // comment if unused
      if (client.getConfiguration().getSmsServicePlanCredentials().isPresent()
          || client.getConfiguration().getUnifiedCredentials().isPresent()) {
        SmsQuickStart sms = new SmsQuickStart(client.sms().v1());
      }

      // Verification service dedicated business logic processing
      // (see https://developers.sinch.com/docs/verification)
      // comment if unused
      if (client.getConfiguration().getApplicationCredentials().isPresent()) {
        VerificationQuickStart verification =
            new VerificationQuickStart(client.verification().v1());
      }

      // Voice service dedicated business logic processing
      // (see https://developers.sinch.com/docs/voice)
      // comment if unused
      if (client.getConfiguration().getApplicationCredentials().isPresent()) {
        VoiceQuickStart voice = new VoiceQuickStart(client.voice().v1());
      }

    } catch (Exception e) {
      LOGGER.severe(String.format("Application failure: %s", e.getMessage()));
    }
  }

  static Logger initializeLogger() {
    try (InputStream logConfigInputStream =
        Application.class.getClassLoader().getResourceAsStream(LOGGING_PROPERTIES_FILE)) {

      if (logConfigInputStream != null) {
        LogManager.getLogManager().readConfiguration(logConfigInputStream);
      } else {
        throw new RuntimeException(
            String.format("The file '%s' couldn't be loaded.", LOGGING_PROPERTIES_FILE));
      }

    } catch (IOException e) {
      throw new RuntimeException(e.getMessage());
    }
    return Logger.getLogger(Application.class.getName());
  }
}
