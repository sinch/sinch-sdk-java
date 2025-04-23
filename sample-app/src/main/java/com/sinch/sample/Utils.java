package com.sinch.sample;

import com.sinch.sdk.models.Configuration;
import com.sinch.sdk.models.MailgunContext;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Utils {

  private static final String SINCH_KEY_ID = "SINCH_KEY_ID";
  private static final String SINCH_KEY_SECRET = "SINCH_KEY_SECRET";
  private static final String SINCH_PROJECT_ID = "SINCH_PROJECT_ID";

  // can super sed unified Sinch credentials if defined
  private static final String APPLICATION_API_KEY = "APPLICATION_API_KEY";
  private static final String APPLICATION_API_SECRET = "APPLICATION_API_SECRET";

  // can super sed unified Sinch credentials if SMS service plan ID defined
  private static final String SMS_SERVICE_PLAN_ID = "SMS_SERVICE_PLAN_ID";
  private static final String SMS_SERVICE_PLAN_TOKEN = "SMS_SERVICE_PLAN_TOKEN";

  private static final String MAILGUN_API_KEY = "MAILGUN_SERVICE_API_KEY";
  private static final String MAILGUN_SERVER = "MAILGUN_SERVER";

  public static Logger initializeLogger(String className) {
    try (InputStream logConfigInputStream =
        Utils.class.getClassLoader().getResourceAsStream("logging.properties")) {
      if (logConfigInputStream != null) {
        LogManager.getLogManager().readConfiguration(logConfigInputStream);
      } else {
        throw new RuntimeException("The file 'logging.properties' couldn't be loaded.");
      }
    } catch (IOException e) {
      throw new RuntimeException(e.getMessage());
    }
    return Logger.getLogger(className);
  }

  public static Properties loadProperties(Logger logger) {
    Properties properties = new Properties();

    try (InputStream input =
        Utils.class.getClassLoader().getResourceAsStream("config.properties")) {
      if (input != null) {
        properties.load(input);
      } else {
        logger.severe("'config.properties' file could not be loaded");
      }
    } catch (IOException e) {
      logger.severe("Error loading properties from 'config.properties'");
    }
    return properties;
  }

  public static Configuration loadConfiguration(Logger logger) {
    Properties properties = loadProperties(logger);
    Configuration.Builder builder = Configuration.builder();

    manageUnifiedCredentials(properties, builder);
    manageApplicationCredentials(properties, builder);
    manageSmsServicePlanCredentials(properties, builder);
    manageMailgun(properties, builder);

    return builder.build();
  }

  private static void manageUnifiedCredentials(
      Properties properties, Configuration.Builder builder) {
    String keyId =
        null != System.getenv(SINCH_KEY_ID)
            ? System.getenv(SINCH_KEY_ID)
            : properties.getProperty(SINCH_KEY_ID);
    String keySecret =
        null != System.getenv(SINCH_KEY_SECRET)
            ? System.getenv(SINCH_KEY_SECRET)
            : properties.getProperty(SINCH_KEY_SECRET);
    String projectId =
        null != System.getenv(SINCH_PROJECT_ID)
            ? System.getenv(SINCH_PROJECT_ID)
            : properties.getProperty(SINCH_PROJECT_ID);

    if (null != keyId || null != keySecret || null != projectId) {
      builder.setKeyId(keyId).setKeySecret(keySecret).setProjectId(projectId);
    }
  }

  private static void manageApplicationCredentials(
      Properties properties, Configuration.Builder builder) {

    String verificationApiKey =
        null != System.getenv(APPLICATION_API_KEY)
            ? System.getenv(APPLICATION_API_KEY)
            : properties.getProperty(APPLICATION_API_KEY);

    if (null != verificationApiKey) {
      builder.setApplicationKey(verificationApiKey);
    }

    String verificationApiSecret =
        null != System.getenv(APPLICATION_API_SECRET)
            ? System.getenv(APPLICATION_API_SECRET)
            : properties.getProperty(APPLICATION_API_SECRET);

    if (null != verificationApiSecret) {
      builder.setApplicationSecret(verificationApiSecret);
    }
  }

  private static void manageSmsServicePlanCredentials(
      Properties properties, Configuration.Builder builder) {

    String smsServicePlanId =
        null != System.getenv(SMS_SERVICE_PLAN_ID)
            ? System.getenv(SMS_SERVICE_PLAN_ID)
            : properties.getProperty(SMS_SERVICE_PLAN_ID);

    if (null != smsServicePlanId) {
      builder.setSmsServicePlanId(smsServicePlanId);
    }

    String smsServicePlanToken =
        null != System.getenv(SMS_SERVICE_PLAN_TOKEN)
            ? System.getenv(SMS_SERVICE_PLAN_TOKEN)
            : properties.getProperty(SMS_SERVICE_PLAN_TOKEN);

    if (null != smsServicePlanToken) {
      builder.setSmsApiToken(smsServicePlanToken);
    }
  }

  private static void manageMailgun(Properties properties, Configuration.Builder builder) {

    String mailgunApiKey =
        null != System.getenv(MAILGUN_API_KEY)
            ? System.getenv(MAILGUN_API_KEY)
            : properties.getProperty(MAILGUN_API_KEY);

    if (null != mailgunApiKey) {
      builder.setMailgunApiKey(mailgunApiKey);
    }

    String mailgunServer =
        null != System.getenv(MAILGUN_SERVER)
            ? System.getenv(MAILGUN_SERVER)
            : properties.getProperty(MAILGUN_SERVER);

    if (null != mailgunServer) {
      builder.setMailgunContext(MailgunContext.builder().setUrl(mailgunServer).build());
    }
  }

  public static void echoStep(int step, String text) {
    String formatted = "| Step " + step + ": " + text + " |";
    String separator = String.format("+%0" + (formatted.length() - 2) + "d+", 0).replace('0', '-');

    System.out.println(separator);
    System.out.println(formatted);
    System.out.println(separator);
  }

  public static void echo(String text) {
    System.out.println("  " + text);
  }
}
