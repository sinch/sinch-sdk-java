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

  // can super sed unified Sinch credentials if defined
  private static final String VERIFICATION_API_KEY = "VERIFICATION_API_KEY";
  private static final String VERIFICATION_API_SECRET = "VERIFICATION_API_SECRET";

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

    handleVerificationCredentials(client, properties);
  }

  void handleVerificationCredentials(SinchClient client, Properties props) {

    String verificationApiKey =
        null != System.getenv(VERIFICATION_API_KEY)
            ? System.getenv(VERIFICATION_API_KEY)
            : props.getProperty(VERIFICATION_API_KEY);
    String verificationApiSecret =
        null != System.getenv(VERIFICATION_API_SECRET)
            ? System.getenv(VERIFICATION_API_SECRET)
            : props.getProperty(VERIFICATION_API_SECRET);

    // super-sed unified key/secret for verification API
    if (null != verificationApiKey && null != verificationApiSecret) {
      client.verification().useSecrets(verificationApiKey, verificationApiSecret);
    }
  }

  public abstract void run();
}
