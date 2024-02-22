package com.sinch.sdk;

import com.sinch.sdk.core.utils.StringUtil;
import com.sinch.sdk.domains.numbers.NumbersService;
import com.sinch.sdk.domains.sms.SMSService;
import com.sinch.sdk.domains.verification.VerificationService;
import com.sinch.sdk.domains.voice.VoiceService;
import com.sinch.sdk.http.HttpClientApache;
import com.sinch.sdk.models.Configuration;
import com.sinch.sdk.models.NumbersContext;
import com.sinch.sdk.models.SMSRegion;
import com.sinch.sdk.models.SmsContext;
import com.sinch.sdk.models.VerificationContext;
import com.sinch.sdk.models.VoiceContext;
import com.sinch.sdk.models.VoiceRegion;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;
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

  private static final String VOICE_REGION_KEY = "voice-region";
  private static final String VOICE_APPLICATION_MANAGEMENT_SERVER_KEY =
      "voice-application-management-server";

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
  private VoiceService voice;

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

    handleDefaultNumbersSettings(configuration, props, builder);
    handleDefaultSmsSettings(configuration, props, builder);
    handleDefaultVerificationSettings(configuration, props, builder);
    handleDefaultVoiceSettings(configuration, props, builder);

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

  private void handleDefaultNumbersSettings(
      Configuration configuration, Properties props, Configuration.Builder builder) {

    String url = configuration.getNumbersContext().map(NumbersContext::getNumbersUrl).orElse(null);

    if (null == url && props.containsKey(NUMBERS_SERVER_KEY)) {
      builder.setNumbersContext(
          NumbersContext.builder().setNumbersUrl(props.getProperty(NUMBERS_SERVER_KEY)).build());
    }
  }

  private void handleDefaultSmsSettings(
      Configuration configuration, Properties props, Configuration.Builder builder) {

    String smsUrl = configuration.getSmsContext().map(SmsContext::getSmsUrl).orElse(null);

    SMSRegion smsRegion = configuration.getSmsContext().map(SmsContext::getSmsRegion).orElse(null);

    if (null == smsUrl && props.containsKey(SMS_SERVER_KEY)) {
      smsUrl = props.getProperty(SMS_SERVER_KEY);
    }
    if (null == smsRegion && props.containsKey(SMS_REGION_KEY)) {
      smsRegion = SMSRegion.from(props.getProperty(SMS_REGION_KEY));
    }

    if (null != smsUrl || null != smsRegion) {
      builder.setSmsContext(SmsContext.builder().setSmsRegion(smsRegion).setSmsUrl(smsUrl).build());
    }
  }

  private void handleDefaultVerificationSettings(
      Configuration configuration, Properties props, Configuration.Builder builder) {

    String url =
        configuration
            .getVerificationContext()
            .map(VerificationContext::getVerificationUrl)
            .orElse(null);

    if (null == url && props.containsKey(VERIFICATION_SERVER_KEY)) {
      builder.setVerificationContext(
          VerificationContext.builder()
              .setVerificationUrl(props.getProperty(VERIFICATION_SERVER_KEY))
              .build());
    }
  }

  private void handleDefaultVoiceSettings(
      Configuration configuration, Properties props, Configuration.Builder builder) {

    VoiceRegion region =
        configuration.getVoiceContext().map(VoiceContext::getVoiceRegion).orElse(null);

    String voiceUrl = configuration.getVoiceContext().map(VoiceContext::getVoiceUrl).orElse(null);

    String voiceApplicationManagementUrl =
        configuration
            .getVoiceContext()
            .map(VoiceContext::getVoiceApplicationManagementUrl)
            .orElse(null);

    // default region to be used ?
    if (null == region && props.containsKey(VOICE_REGION_KEY)) {
      region = VoiceRegion.from(props.getProperty(VOICE_REGION_KEY));
    }

    // server is not defined: use the region to set to an existing one and use "global" as a default
    // fallback
    if (StringUtil.isEmpty(voiceUrl)) {
      VoiceRegion regionForFormat = null == region ? VoiceRegion.GLOBAL : region;
      voiceUrl = props.getProperty(String.format("voice-server-%s", regionForFormat.value()));
    }

    // application management server
    if (StringUtil.isEmpty(voiceApplicationManagementUrl)
        && props.containsKey(VOICE_APPLICATION_MANAGEMENT_SERVER_KEY)) {
      voiceApplicationManagementUrl = props.getProperty(VOICE_APPLICATION_MANAGEMENT_SERVER_KEY);
    }

    if (null != region || null != voiceUrl || null != voiceApplicationManagementUrl) {
      builder.setVoiceContext(
          VoiceContext.builder()
              .setVoiceRegion(region)
              .setVoiceUrl(voiceUrl)
              .setVoiceApplicationMngmtUrl(voiceApplicationManagementUrl)
              .build());
    }
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

  /**
   * Get voice domain service
   *
   * @return Return instance onto Voice API service
   * @see <a
   *     href="https://developers.sinch.com/docs/voice/api-reference">https://developers.sinch.com/docs/voice/api-reference</a>
   * @since 1.0
   */
  public VoiceService voice() {
    if (null == voice) {
      voice = voiceInit();
    }
    return voice;
  }

  private void checkConfiguration(Configuration configuration) throws NullPointerException {
    Objects.requireNonNull(configuration.getOAuthUrl(), "'oauthUrl' cannot be null");
  }

  private NumbersService numbersInit() {
    return new com.sinch.sdk.domains.numbers.adapters.NumbersService(
        getConfiguration(), getHttpClient());
  }

  private SMSService smsInit() {

    return new com.sinch.sdk.domains.sms.adapters.SMSService(getConfiguration(), getHttpClient());
  }

  private VerificationService verificationInit() {
    return new com.sinch.sdk.domains.verification.adapters.VerificationService(
        getConfiguration(), getHttpClient());
  }

  private VoiceService voiceInit() {
    return new com.sinch.sdk.domains.voice.adapters.VoiceService(
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

    Collection<String> values = Collections.singletonList(System.getProperty("java.vendor"));

    if (!StringUtil.isEmpty(auxiliaryFlag)) {
      values.add(auxiliaryFlag);
    }
    return String.join(",", values);
  }
}
