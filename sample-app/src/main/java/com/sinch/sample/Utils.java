package com.sinch.sample;

import com.sinch.sdk.models.Configuration;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Utils {

  private static final String SINCH_KEY_ID = "SINCH_KEY_ID";
  private static final String SINCH_KEY_SECRET = "SINCH_KEY_SECRET";
  private static final String SINCH_PROJECT_ID = "SINCH_PROJECT_ID";

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

    return Configuration.builder()
        .setKeyId(keyId)
        .setKeySecret(keySecret)
        .setProjectId(projectId)
        .build();
  }
}
