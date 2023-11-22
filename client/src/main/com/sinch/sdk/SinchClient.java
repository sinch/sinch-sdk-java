package com.sinch.sdk;

import com.sinch.sdk.domains.numbers.NumbersService;
import com.sinch.sdk.domains.sms.SMSService;
import com.sinch.sdk.domains.verification.VerificationService;
import com.sinch.sdk.http.HttpClientApache;
import com.sinch.sdk.models.Configuration;
import com.sinch.sdk.models.SMSRegion;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;
import java.util.logging.Logger;

/** Sinch Sdk Client implementation */
public class SinchClient {

  private static final String OAUTH_URL_KEY = "oauth-url";
  private static final String NUMBERS_SERVER_KEY = "numbers-server";
  private static final String SMS_REGION_KEY = "sms-region";
  private static final String SMS_SERVER_KEY = "sms-server";
  private static final String VERIFICATION_SERVER_KEY = "verification-server";

  private static final Logger LOGGER = Logger.getLogger(SinchClient.class.getName());

  private final Configuration configuration;
  private NumbersService numbers;
  private SMSService sms;
  private VerificationService verification;

  private HttpClientApache httpClient;

  /**
   * Create a Sinch Client instance based onto configuration
   *
   * @param configuration Configuration to be used
   * @since 1.0
   */
  public SinchClient(Configuration configuration) {

    Configuration.Builder builder = Configuration.builder(configuration);

    Properties props = handleDefaultConfigurationFile();
    if (null == configuration.getOAuthUrl() && props.containsKey(OAUTH_URL_KEY)) {
      builder.setOAuthUrl(props.getProperty(OAUTH_URL_KEY));
    }
    if (null == configuration.getNumbersUrl() && props.containsKey(NUMBERS_SERVER_KEY)) {
      builder.setNumbersUrl(props.getProperty(NUMBERS_SERVER_KEY));
    }
    if (null == configuration.getSmsUrl() && props.containsKey(SMS_SERVER_KEY)) {
      builder.setSmsUrl(props.getProperty(SMS_SERVER_KEY));
    }
    if (null == configuration.getSmsRegion() && props.containsKey(SMS_REGION_KEY)) {
      builder.setSmsRegion(SMSRegion.from(props.getProperty(SMS_REGION_KEY)));
    }
    if (null == configuration.getVerificationUrl() && props.containsKey(VERIFICATION_SERVER_KEY)) {
      builder.setVerificationUrl(props.getProperty(VERIFICATION_SERVER_KEY));
    }
    Configuration newConfiguration = builder.build();
    checkConfiguration(newConfiguration);
    this.configuration = newConfiguration;

    LOGGER.fine("SinchClient started with projectId='" + configuration.getProjectId() + "'");
  }

  /**
   * Get current configuration
   *
   * @return Current configuration in use by client
   * @since 1.0
   */
  public Configuration getConfiguration() {
    return this.configuration;
  }

  /**
   * Get Numbers domain service
   *
   * @return Return instance onto Numbers API service
   * @see <a
   *     href="https://developers.sinch.com/docs/numbers/api-reference">https://developers.sinch.com/docs/numbers/api-reference</a>
   * @since 1.0
   */
  public NumbersService numbers() {
    if (null == numbers) {
      numbers = numbersInit();
    }
    return numbers;
  }

  /**
   * Get SMS domain service
   *
   * @return Return instance onto SMS API service
   * @see <a
   *     href="https://developers.sinch.com/docs/sms/api-reference/">https://developers.sinch.com/docs/sms/api-reference/</a>
   * @since 1.0
   */
  public SMSService sms() {
    if (null == sms) {
      sms = smsInit();
    }
    return sms;
  }

  /**
   * Get verification domain service
   *
   * @return Return instance onto verification API service
   * @see <a
   *     href="https://developers.sinch.com/docs/verification/api-reference//">https://developers.sinch.com/docs/verification/api-reference//</a>
   * @since 1.0
   */
  public VerificationService verification() {
    if (null == verification) {
      verification = verificationInit();
    }
    return verification;
  }

  private void checkConfiguration(Configuration configuration) throws NullPointerException {
    Objects.requireNonNull(configuration.getKeyId(), "'keyId' cannot be null");
    Objects.requireNonNull(configuration.getKeySecret(), "'keySecret' cannot be null");
    Objects.requireNonNull(configuration.getProjectId(), "'projectId' cannot be null");
    Objects.requireNonNull(configuration.getOAuthUrl(), "'oauthUrl' cannot be null");
    Objects.requireNonNull(configuration.getNumbersUrl(), "'numbersUrl' cannot be null");
    Objects.requireNonNull(configuration.getSmsUrl(), "'smsUrl' cannot be null");
    Objects.requireNonNull(configuration.getVerificationUrl(), "'verificationUrl' cannot be null");
  }

  private NumbersService numbersInit() {
    LOGGER.fine(
        "Activate numbers API with server='"
            + getConfiguration().getNumbersServer().getUrl()
            + "'");
    return new com.sinch.sdk.domains.numbers.adapters.NumbersService(
        getConfiguration(), getHttpClient());
  }

  private SMSService smsInit() {
    LOGGER.fine(
        "Activate SMS API with server='" + getConfiguration().getSmsServer().getUrl() + "'");
    return new com.sinch.sdk.domains.sms.adapters.SMSService(getConfiguration(), getHttpClient());
  }

  private VerificationService verificationInit() {
    LOGGER.fine(
        "Activate verification API with server='"
            + getConfiguration().getVerificationServer().getUrl()
            + "'");
    return new com.sinch.sdk.domains.verification.adapters.VerificationService(
        getConfiguration(), getHttpClient());
  }

  private Properties handleDefaultConfigurationFile() {

    Properties prop = new Properties();
    try (InputStream is = this.getClass().getResourceAsStream("/config-default.properties")) {
      prop.load(is);
    } catch (IOException e) {
      // NOOP
    }
    return prop;
  }

  private HttpClientApache getHttpClient() {
    if (null == httpClient || httpClient.isClosed()) {
      // TODO: by adding a setter, we could imagine having another HTTP client provided
      // programmatically or use
      //  configuration file referencing another class by name
      this.httpClient = new HttpClientApache();
      LOGGER.fine("HTTP client loaded");
    }
    return this.httpClient;
  }
}
