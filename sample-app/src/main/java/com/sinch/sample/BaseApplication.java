package com.sinch.sample;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.models.Configuration;
import com.sinch.sdk.models.SMSRegion;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public abstract class BaseApplication {

  /** duplicate of SinchClient property files for lisibility facility but could be anything else */
  private static final String OAUTH_URL_KEY = "oauth-url";

  private static final String NUMBERS_SERVER_KEY = "numbers-server";
  private static final String SMS_REGION_KEY = "sms-region";
  private static final String SMS_SERVER_KEY = "sms-server";

  private static final String BATCH_ID_KEY = "BATCH_ID";
  private static final String PHONE_NUMBER_KEY = "PHONE_NUMBER";
  private static final String SINCH_KEY_ID = "SINCH_KEY_ID";
  private static final String SINCH_KEY_SECRET = "SINCH_KEY_SECRET";
  private static final String SINCH_PROJECT_ID = "SINCH_PROJECT_ID";

  protected static Logger LOGGER;

  protected SinchClient client;
  protected String phoneNumber;
  protected String batchId;

  protected BaseApplication() throws IOException {

    Properties properties = handleConfigurations();

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

    Configuration.Builder builder =
        Configuration.builder().setKeyId(keyId).setKeySecret(keySecret).setProjectId(projectId);

    LOGGER.info("Starting application");

    // override by local config
    if (properties.containsKey(NUMBERS_SERVER_KEY)) {
      builder.setNumbersUrl(properties.getProperty(NUMBERS_SERVER_KEY));
    }
    if (properties.containsKey(SMS_SERVER_KEY)) {
      builder.setSmsUrl(properties.getProperty(SMS_SERVER_KEY));
    }
    if (properties.containsKey(SMS_REGION_KEY)) {
      builder.setSmsRegion(SMSRegion.from(properties.getProperty(SMS_REGION_KEY)));
    }
    phoneNumber =
        null != System.getenv(PHONE_NUMBER_KEY)
            ? System.getenv(PHONE_NUMBER_KEY)
            : properties.getProperty(PHONE_NUMBER_KEY);
    batchId =
        null != System.getenv(BATCH_ID_KEY)
            ? System.getenv(BATCH_ID_KEY)
            : properties.getProperty(BATCH_ID_KEY);

    client = new SinchClient(builder.build());
  }

  private static Properties handleConfigurations() throws IOException {

    InputStream is = BaseApplication.class.getResourceAsStream("/resources/logging.properties");
    if (null != is) {
      LogManager.getLogManager().readConfiguration(is);
      is.close();
    }
    LOGGER = Logger.getLogger(BaseApplication.class.getName());

    Properties prop = new Properties();
    is = BaseApplication.class.getResourceAsStream("/config.properties");
    if (null != is) {
      prop.load(is);
      is.close();
    }
    return prop;
  }

  public abstract void run();
}
