package com.sinch.demo;

import com.sinch.sdk.core.exceptions.ApiException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Utils {

  public static Logger initializeLogger(String className) {
    try (InputStream logConfigInputStream = NumbersSampleFlow.class.getClassLoader().getResourceAsStream("logging.properties")) {
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

    try (InputStream input = NumbersSampleFlow.class.getClassLoader().getResourceAsStream("config.properties")) {
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

}
