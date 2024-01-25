package com.sinch.sdk;

import com.sinch.sdk.core.utils.StringUtil;
import com.sinch.sdk.domains.numbers.NumbersService;
import com.sinch.sdk.domains.sms.SMSService;
import com.sinch.sdk.domains.verification.VerificationService;
import com.sinch.sdk.http.HttpClientApache;
import com.sinch.sdk.models.Configuration;
import com.sinch.sdk.models.SMSRegion;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.Properties;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/** Sinch Sdk Client implementation */
public class SinchClient {

  private static final String DEFAULT_PROPERTIES_FILE_NAME = "/config-default.properties";
  private static final String VERSION_PROPERTIES_FILE_NAME = "/version.properties";

  private static final String OAUTH_URL_KEY = "oauth-url";
  private static final String NUMBERS_SERVER_KEY = "numbers-server";
  private static final String SMS_REGION_KEY = "sms-region";
  private static final String SMS_SERVER_KEY = "sms-server";
  private static final String VERIFICATION_SERVER_KEY = "verification-server";

  private static final String PROJECT_NAME_KEY = "project.name";
  private static final String PROJECT_VERSION_KEY = "project.version";
  private static final String PROJECT_AUXILIARY_FLAG = "project.auxiliary_flag";

  // sinch-sdk/{sdk_version} ({language}/{language_version}; {implementation_type};
  // {auxiliary_flag})
  private static final String SDK_USER_AGENT_HEADER = "User-Agent";
  private static final String SDK_USER_AGENT_FORMAT = "sinch-sdk/%s (%s/%s; %s; %s)";
  private static final Logger LOGGER = Logger.getLogger(SinchClient.class.getName());

  private final Configuration configuration;
  private final Properties versionProperties;

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

    Properties props = handlePropertiesFile(DEFAULT_PROPERTIES_FILE_NAME);
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

    versionProperties = handlePropertiesFile(VERSION_PROPERTIES_FILE_NAME);
    LOGGER.fine(
        String.format(
            "%s (%s) started with projectId '%s'",
            versionProperties.getProperty(PROJECT_NAME_KEY),
            versionProperties.getProperty(PROJECT_VERSION_KEY),
            configuration.getProjectId()));
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

  private Properties handlePropertiesFile(String fileName) {

    Properties prop = new Properties();
    try (InputStream is = this.getClass().getResourceAsStream(fileName)) {
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

      // set SDK User-Agent
      String userAgent = formatSdkUserAgentHeader(versionProperties);
      this.httpClient.setRequestHeaders(
          Stream.of(new String[][] {{SDK_USER_AGENT_HEADER, userAgent}})
              .collect(Collectors.toMap(data -> data[0], data -> data[1])));

      LOGGER.fine("HTTP client loaded");
    }
    return this.httpClient;
  }

  private String formatSdkUserAgentHeader(Properties versionProperties) {
    return String.format(
        SDK_USER_AGENT_FORMAT,
        versionProperties.get(PROJECT_VERSION_KEY),
        "Java",
        System.getProperty("java.version"),
        "Apache",
        formatAuxiliaryFlag((String) versionProperties.get(PROJECT_AUXILIARY_FLAG)));
  }

  private String formatAuxiliaryFlag(String auxiliaryFlag) {

    Collection<String> values = Arrays.asList(System.getProperty("java.vendor"));

    if (!StringUtil.isEmpty(auxiliaryFlag)) {
      values.add(auxiliaryFlag);
    }
    return String.join(",", values);
  }
}
