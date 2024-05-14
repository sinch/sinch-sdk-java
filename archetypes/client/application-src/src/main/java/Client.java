import com.sinch.sdk.SinchClient;
import com.sinch.sdk.models.Configuration;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

public class Client {

  private static final Logger LOGGER = Logger.getLogger(Client.class.getName());

  private static final String SINCH_KEY_ID_KEY = "SINCH_KEY_ID";
  private static final String SINCH_KEY_SECRET_KEY = "SINCH_KEY_SECRET";
  private static final String SINCH_PROJECT_ID_KEY = "SINCH_PROJECT_ID";

  private static final String CONFIG_FILE = "config.properties";

  public static SinchClient initSinchClient() {

    LOGGER.info("Initializing client");

    Configuration configuration = getConfiguration();

    return new SinchClient(configuration);
  }

  static Configuration getConfiguration() {

    Properties properties = loadProperties();

    Configuration.Builder builder = Configuration.builder();

    manageUnifiedCredentials(properties, builder);

    return builder.build();
  }

  static Properties loadProperties() {

    Properties properties = new Properties();

    try (InputStream input = Client.class.getClassLoader().getResourceAsStream(CONFIG_FILE)) {
      if (input != null) {
        properties.load(input);
      } else {
        LOGGER.severe("'%s' file could not be loaded".formatted(CONFIG_FILE));
      }
    } catch (IOException e) {
      LOGGER.severe("Error loading properties from '%s'".formatted(CONFIG_FILE));
    }

    return properties;
  }

  static void manageUnifiedCredentials(Properties properties, Configuration.Builder builder) {

    String keyId = getConfigValue(properties, SINCH_KEY_ID_KEY);
    String keySecret = getConfigValue(properties, SINCH_KEY_SECRET_KEY);
    String projectId = getConfigValue(properties, SINCH_PROJECT_ID_KEY);

    builder.setKeyId(keyId).setKeySecret(keySecret).setProjectId(projectId);
  }

  static String getConfigValue(Properties properties, String key) {
    return null != System.getenv(key) ? System.getenv(key) : properties.getProperty(key);
  }
}
