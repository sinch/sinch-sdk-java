import com.sinch.sdk.SinchClient;
import com.sinch.sdk.models.Configuration;
import com.sinch.sdk.models.ConversationRegion;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;
import java.util.logging.Logger;

public class SinchClientHelper {

  private static final Logger LOGGER = Logger.getLogger(SinchClientHelper.class.getName());

  private static final String SINCH_PROJECT_ID = "SINCH_PROJECT_ID";
  private static final String SINCH_KEY_ID = "SINCH_KEY_ID";
  private static final String SINCH_KEY_SECRET = "SINCH_KEY_SECRET";

  private static final String CONVERSATION_REGION = "CONVERSATION_REGION";

  private static final String CONFIG_FILE = "config.properties";

  public static SinchClient initSinchClient() {

    LOGGER.info("Initializing client");

    Configuration configuration = getConfiguration();

    return new SinchClient(configuration);
  }

  private static Configuration getConfiguration() {

    Properties properties = loadProperties();

    Configuration.Builder builder = Configuration.builder();

    manageUnifiedCredentials(properties, builder);
    manageConversationConfiguration(properties, builder);

    return builder.build();
  }

  private static Properties loadProperties() {

    Properties properties = new Properties();

    try (InputStream input =
        SinchClientHelper.class.getClassLoader().getResourceAsStream(CONFIG_FILE)) {
      if (input != null) {
        properties.load(input);
      } else {
        LOGGER.severe(String.format("'%s' file could not be loaded", CONFIG_FILE));
      }
    } catch (IOException e) {
      LOGGER.severe(String.format("Error loading properties from '%s'", CONFIG_FILE));
    }

    return properties;
  }

  static void manageUnifiedCredentials(Properties properties, Configuration.Builder builder) {

    Optional<String> projectId = getConfigValue(properties, SINCH_PROJECT_ID);
    Optional<String> keyId = getConfigValue(properties, SINCH_KEY_ID);
    Optional<String> keySecret = getConfigValue(properties, SINCH_KEY_SECRET);

    projectId.ifPresent(builder::setProjectId);
    keyId.ifPresent(builder::setKeyId);
    keySecret.ifPresent(builder::setKeySecret);
  }

  private static void manageConversationConfiguration(
      Properties properties, Configuration.Builder builder) {

    Optional<String> region = getConfigValue(properties, CONVERSATION_REGION);

    region.ifPresent(value -> builder.setConversationRegion(ConversationRegion.from(value)));
  }

  private static Optional<String> getConfigValue(Properties properties, String key) {
    String value = null != System.getenv(key) ? System.getenv(key) : properties.getProperty(key);

    // empty value means setting not set
    if (null != value && value.trim().isEmpty()) {
      return Optional.empty();
    }

    return Optional.ofNullable(value);
  }
}
