package utils;

import com.sinch.sdk.core.utils.StringUtil;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Settings {

  private static final Logger LOGGER = Logger.getLogger(Settings.class.getName());

  private static final String CONFIG_FILE = "config.properties";
  private static final String LOGGING_CONFIG_FILE = "logging.properties";

  private static final Properties properties;

  static {
    initializeLogger();
    properties = new Properties();
    try (
    // load a properties file from class path, inside static method
    InputStream configInputStream =
        Settings.class.getClassLoader().getResourceAsStream(CONFIG_FILE)) {

      if (configInputStream != null) {
        properties.load(configInputStream);
      } else {
        LOGGER.severe(String.format("Error reading '%s' configuration file", CONFIG_FILE));
      }
    } catch (Exception ioe) {
      LOGGER.severe(
          String.format(
              "Error reading '%s' configuration file: %s", CONFIG_FILE, ioe.getMessage()));
    }
  }

  public static Optional<String> get(String key) {

    String value = properties.getProperty(key);
    if (StringUtil.isEmpty(value)) {
      return Optional.empty();
    }
    return Optional.of(value.trim());
  }

  public static Optional<String> getProjectId() {
    return get("SINCH_PROJECT_ID");
  }

  public static Optional<String> getKeyId() {
    return get("SINCH_KEY_ID");
  }

  public static Optional<String> getKeySecret() {
    return get("SINCH_KEY_SECRET");
  }

  public static Optional<String> getServicePlanId() {
    return get("SINCH_SERVICE_PLAN_ID");
  }

  public static Optional<String> getSMSRegion() {
    return get("SINCH_SMS_REGION");
  }

  public static Optional<String> getApplicationKey() {
    return get("SINCH_APPLICATION_API_KEY");
  }

  public static Optional<String> getApplicationSecret() {
    return get("SINCH_APPLICATION_API_SECRET");
  }

  public static Optional<String> getMailgunApiKey() {
    return get("SINCH_MAILGUN_SERVICE_API_KEY");
  }

  public static Optional<String> getMailgunRegion() {
    return get("SINCH_MAILGUN_REGION");
  }

  public static Optional<String> getConversationRegion() {
    return get("SINCH_CONVERSATION_REGION");
  }

  public static Optional<String> getPhoneNumber() {
    return get("SINCH_PHONE_NUMBER");
  }

  private static void initializeLogger() {
    try (InputStream logConfigInputStream =
        Settings.class.getClassLoader().getResourceAsStream(LOGGING_CONFIG_FILE)) {
      if (logConfigInputStream != null) {
        LogManager.getLogManager().readConfiguration(logConfigInputStream);
      } else {
        LOGGER.warning(String.format("Error reading '%s' configuration file", LOGGING_CONFIG_FILE));
      }
    } catch (IOException ioe) {
      LOGGER.warning(
          String.format(
              "Error reading '%s' configuration file: %s", LOGGING_CONFIG_FILE, ioe.getMessage()));
    }
  }
}
