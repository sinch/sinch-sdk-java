import com.sinch.sdk.SinchClient;
import com.sinch.sdk.models.Configuration;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.LogManager;

/**
 * Reads the settings of this example: an environment variable wins over the same key in {@code
 * config.properties}
 */
public final class Settings {

  private static final String CONFIG_FILE = "config.properties";
  private static final String LOGGING_CONFIG_FILE = "logging.properties";

  private static final Properties PROPERTIES = new Properties();

  static {
    load(LOGGING_CONFIG_FILE, LogManager.getLogManager()::readConfiguration);
    load(CONFIG_FILE, PROPERTIES::load);
  }

  private Settings() {}

  /**
   * Get a setting value
   *
   * @param key The setting name, e.g. {@code SINCH_NUMBER}
   * @param defaultValue The value to use when the setting is not set
   * @return The environment variable value, else the {@code config.properties} value, else the
   *     default value
   */
  public static String get(String key, String defaultValue) {
    String value = System.getenv(key);
    if (isEmpty(value)) {
      value = PROPERTIES.getProperty(key);
    }
    return isEmpty(value) ? defaultValue : value.trim();
  }

  /**
   * Create a Sinch client from the {@code SINCH_PROJECT_ID}, {@code SINCH_KEY_ID} and {@code
   * SINCH_KEY_SECRET} settings
   *
   * @return The Sinch client
   */
  public static SinchClient sinchClient() {
    return new SinchClient(
        Configuration.builder()
            .setProjectId(get("SINCH_PROJECT_ID", "MY_PROJECT_ID"))
            .setKeyId(get("SINCH_KEY_ID", "MY_KEY_ID"))
            .setKeySecret(get("SINCH_KEY_SECRET", "MY_KEY_SECRET"))
            .build());
  }

  private static boolean isEmpty(String value) {
    return null == value || value.trim().isEmpty();
  }

  private interface Loader {
    void load(InputStream inputStream) throws IOException;
  }

  private static void load(String file, Loader loader) {
    try (InputStream inputStream = Settings.class.getClassLoader().getResourceAsStream(file)) {
      if (null == inputStream) {
        throw new IllegalStateException(String.format("'%s' file could not be found", file));
      }
      loader.load(inputStream);
    } catch (IOException e) {
      throw new IllegalStateException(String.format("'%s' file could not be read", file), e);
    }
  }
}
