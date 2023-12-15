package com.sinch.sample;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.models.Configuration;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

public abstract class BaseApplication {
  private static final String BATCH_ID_KEY = "BATCH_ID";
  private static final String PHONE_NUMBER_KEY = "PHONE_NUMBER";

  protected static final Logger LOGGER = Utils.initializeLogger(BaseApplication.class.getName());

  protected SinchClient client;

  protected String phoneNumber;
  protected String batchId;

  protected BaseApplication() throws IOException {

    LOGGER.info("Starting application");

    Configuration configuration = Utils.loadConfiguration(LOGGER);

    Properties properties = Utils.loadProperties(LOGGER);
    phoneNumber =
        null != System.getenv(PHONE_NUMBER_KEY)
            ? System.getenv(PHONE_NUMBER_KEY)
            : properties.getProperty(PHONE_NUMBER_KEY);
    batchId =
        null != System.getenv(BATCH_ID_KEY)
            ? System.getenv(BATCH_ID_KEY)
            : properties.getProperty(BATCH_ID_KEY);

    client = new SinchClient(configuration);
  }

  public abstract void run();
}
