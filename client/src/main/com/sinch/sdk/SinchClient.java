package com.sinch.sdk;

import com.sinch.sdk.core.utils.StringUtil;
import com.sinch.sdk.domains.conversation.ConversationService;
import com.sinch.sdk.domains.numbers.NumbersService;
import com.sinch.sdk.domains.sms.SMSService;
import com.sinch.sdk.domains.verification.VerificationService;
import com.sinch.sdk.domains.voice.VoiceService;
import com.sinch.sdk.http.HttpClientApache;
import com.sinch.sdk.models.Configuration;
import com.sinch.sdk.models.ConversationRegion;
import com.sinch.sdk.models.SMSRegion;
import com.sinch.sdk.models.VoiceRegion;
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

  private static final String VOICE_REGION_KEY = "voice-region";
  private static final String VOICE_APPLICATION_MANAGEMENT_SERVER_KEY =
      "voice-application-management-server";

  private static final String VERIFICATION_SERVER_KEY = "verification-server";

  private static final String CONVERSATION_REGION_KEY = "conversation-region";
  private static final String CONVERSATION_SERVER_KEY = "conversation-server";
  private static final String CONVERSATION_TEMPLATE_SERVER_KEY =
      "template-management-conversation-server";

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
  private ConversationService conversation;

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
    handleDefaultConversationSettings(configuration, props, builder);

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

    if (null == configuration.getNumbersUrl() && props.containsKey(NUMBERS_SERVER_KEY)) {
      builder.setNumbersUrl(props.getProperty(NUMBERS_SERVER_KEY));
    }
  }

  private void handleDefaultSmsSettings(
      Configuration configuration, Properties props, Configuration.Builder builder) {

    if (null == configuration.getSmsUrl() && props.containsKey(SMS_SERVER_KEY)) {
      builder.setSmsUrl(props.getProperty(SMS_SERVER_KEY));
    }
    if (null == configuration.getSmsRegion() && props.containsKey(SMS_REGION_KEY)) {
      builder.setSmsRegion(SMSRegion.from(props.getProperty(SMS_REGION_KEY)));
    }
  }

  private void handleDefaultVerificationSettings(
      Configuration configuration, Properties props, Configuration.Builder builder) {

    if (null == configuration.getVerificationUrl() && props.containsKey(VERIFICATION_SERVER_KEY)) {
      builder.setVerificationUrl(props.getProperty(VERIFICATION_SERVER_KEY));
    }
  }

  private void handleDefaultVoiceSettings(
      Configuration configuration, Properties props, Configuration.Builder builder) {
    if (null == configuration.getVoiceRegion() && props.containsKey(VOICE_REGION_KEY)) {
      builder.setVoiceRegion(VoiceRegion.from(props.getProperty(VOICE_REGION_KEY)));
    }

    // server is not defined: use the region to set to an existing one and use "global" as a default
    // fallback
    if (StringUtil.isEmpty(builder.getVoiceUrl())) {
      VoiceRegion region =
          StringUtil.isEmpty(builder.getVoiceRegion().value())
              ? VoiceRegion.GLOBAL
              : builder.getVoiceRegion();
      builder.setVoiceUrl(props.getProperty(String.format("voice-server-%s", region.value())));
    }

    // application management server
    if (null == configuration.getVoiceApplicationManagementUrl()
        && props.containsKey(VOICE_APPLICATION_MANAGEMENT_SERVER_KEY)) {
      builder.setVoiceApplicationMngmtUrl(
          props.getProperty(VOICE_APPLICATION_MANAGEMENT_SERVER_KEY));
    }
  }

  private void handleDefaultConversationSettings(
      Configuration configuration, Properties props, Configuration.Builder builder) {
    if (null == configuration.getConversationRegion()
        && props.containsKey(CONVERSATION_REGION_KEY)) {
      builder.setConversationRegion(
          ConversationRegion.from(props.getProperty(CONVERSATION_REGION_KEY)));
    }

    // server is not defined: use the region to set to an existing one and use "us" as a default
    // fallback
    ConversationRegion region =
        (null == builder.conversationRegion
                || StringUtil.isEmpty(builder.conversationRegion.value()))
            ? ConversationRegion.US
            : builder.conversationRegion;

    if (StringUtil.isEmpty(builder.conversationUrl)) {
      builder.setConversationUrl(
          String.format(props.getProperty(CONVERSATION_SERVER_KEY), region.value()));
    }

    if (StringUtil.isEmpty(builder.conversationTemplateManagementUrl)) {
      builder.setConversationTemplateManagementUrl(
          String.format(props.getProperty(CONVERSATION_TEMPLATE_SERVER_KEY), region.value()));
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

  /**
   * Get Conversation domain service
   *
   * @return Return instance onto Conversation API service
   * @see <a
   *     href="https://developers.sinch.com/docs/conversation/">https://developers.sinch.com/docs/conversation/</a>
   * @since 1.0
   */
  public ConversationService conversation() {
    if (null == conversation) {
      conversation = conversationInit();
    }
    return conversation;
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

  private VoiceService voiceInit() {
    LOGGER.fine(
        "Activate voice API with server='" + getConfiguration().getVoiceServer().getUrl() + "'");
    return new com.sinch.sdk.domains.voice.adapters.VoiceService(
        getConfiguration(), getHttpClient());
  }

  private ConversationService conversationInit() {
    return new com.sinch.sdk.domains.conversation.adapters.ConversationService(
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
