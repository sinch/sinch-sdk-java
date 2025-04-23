package com.sinch.sdk;

import com.sinch.sdk.core.utils.StringUtil;
import com.sinch.sdk.domains.conversation.ConversationService;
import com.sinch.sdk.domains.mailgun.MailgunService;
import com.sinch.sdk.domains.numbers.NumbersService;
import com.sinch.sdk.domains.sms.SMSService;
import com.sinch.sdk.domains.verification.VerificationService;
import com.sinch.sdk.domains.voice.VoiceService;
import com.sinch.sdk.http.HttpClientApache;
import com.sinch.sdk.models.Configuration;
import com.sinch.sdk.models.ConversationContext;
import com.sinch.sdk.models.ConversationRegion;
import com.sinch.sdk.models.MailgunContext;
import com.sinch.sdk.models.MailgunRegion;
import com.sinch.sdk.models.NumbersContext;
import com.sinch.sdk.models.SMSRegion;
import com.sinch.sdk.models.SmsContext;
import com.sinch.sdk.models.VerificationContext;
import com.sinch.sdk.models.VoiceContext;
import com.sinch.sdk.models.VoiceRegion;
import com.sinch.sdk.models.adapters.DualToneMultiFrequencyMapper;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.Optional;
import java.util.Properties;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/** Sinch Sdk Client implementation */
public class SinchClient {

  private static final String DEFAULT_PROPERTIES_FILE_NAME = "/config-default.properties";

  private static final String OAUTH_URL_KEY = "oauth-url";
  private static final String NUMBERS_SERVER_KEY = "numbers-server";
  private static final String SMS_REGION_KEY = "sms-region";
  private static final String SMS_SERVER_KEY = "sms-server";
  private static final String SMS_SERVER_SERVICE_PLAN_KEY = "sms-server-service-plan";

  private static final String VOICE_REGION_KEY = "voice-region";
  private static final String VOICE_APPLICATION_MANAGEMENT_SERVER_KEY =
      "voice-application-management-server";

  private static final String VERIFICATION_SERVER_KEY = "verification-server";

  private static final String CONVERSATION_REGION_KEY = "conversation-region";
  private static final String CONVERSATION_SERVER_KEY = "conversation-server";
  private static final String CONVERSATION_TEMPLATE_SERVER_KEY =
      "template-management-conversation-server";

  private static final String MAILGUN_REGION_KEY = "mailgun-region";
  private static final String MAILGUN_DEFAULT_SERVER_KEY = "mailgun-default-server";
  private static final String MAILGUN_REGION_SERVER_KEY = "mailgun-region-server";
  private static final String MAILGUN_STORAGE_BY_REGION_SERVER_KEY = "mailgun-%s-storage";

  // sinch-sdk/{sdk_version} ({language}/{language_version}; {implementation_type};
  // {auxiliary_flag})
  private static final String SDK_USER_AGENT_HEADER = "User-Agent";
  private static final String SDK_USER_AGENT_FORMAT = "sinch-sdk/%s (%s/%s; %s; %s)";
  private static final Logger LOGGER = Logger.getLogger(SinchClient.class.getName());

  private final Configuration configuration;

  private NumbersService numbers;
  private SMSService sms;
  private VerificationService verification;
  private VoiceService voice;
  private ConversationService conversation;
  private MailgunService mailgun;
  private HttpClientApache httpClient;

  /**
   * Create a Sinch Client instance based onto configuration
   *
   * @param configuration Configuration to be used
   * @since 1.0
   */
  public SinchClient(Configuration configuration) {

    Configuration configurationGuard =
        null != configuration ? configuration : Configuration.builder().build();

    Configuration.Builder builder = Configuration.builder(configurationGuard);
    Properties props = handlePropertiesFile(DEFAULT_PROPERTIES_FILE_NAME);

    if (null == configurationGuard.getOAuthUrl() && props.containsKey(OAUTH_URL_KEY)) {
      builder.setOAuthUrl(props.getProperty(OAUTH_URL_KEY));
    }

    handleDefaultNumbersSettings(configurationGuard, props, builder);
    handleDefaultSmsSettings(configurationGuard, props, builder);
    handleDefaultVerificationSettings(configurationGuard, props, builder);
    handleDefaultVoiceSettings(configurationGuard, props, builder);
    handleDefaultConversationSettings(configurationGuard, props, builder);
    handleDefaultMailgunSettings(configurationGuard, props, builder);

    Configuration newConfiguration = builder.build();
    checkConfiguration(newConfiguration);
    this.configuration = newConfiguration;

    LOGGER.fine(String.format("%s (%s) started", SDK.NAME, SDK.VERSION));
  }

  /**
   * Create a Sinch Client instance without any dedicated configuration
   *
   * <p>Can be used to address webhooks feature not requiring credentials
   *
   * @since 1.6
   */
  public SinchClient() {
    this(null);
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

    // service plan ID activated: use dedicated server
    String serverKey =
        configuration
            .getSmsServicePlanCredentials()
            .map(unused -> SMS_SERVER_SERVICE_PLAN_KEY)
            .orElse(SMS_SERVER_KEY);
    if (null == smsUrl && props.containsKey(serverKey)) {
      smsUrl = props.getProperty(serverKey);
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

  private void handleDefaultConversationSettings(
      Configuration configuration, Properties props, Configuration.Builder builder) {

    ConversationRegion region =
        configuration.getConversationContext().map(ConversationContext::getRegion).orElse(null);

    String url =
        configuration.getConversationContext().map(ConversationContext::getUrl).orElse(null);

    String templateManagementUrl =
        configuration
            .getConversationContext()
            .map(ConversationContext::getTemplateManagementUrl)
            .orElse(null);

    if (null == region && props.containsKey(CONVERSATION_REGION_KEY)) {
      String value = props.getProperty(CONVERSATION_REGION_KEY);
      if (!StringUtil.isEmpty(value)) {
        region = ConversationRegion.from(value);
      }
    }

    // region is not defined: use the region to set to an existing one and use "us" as a default
    // fallback
    region = null == region ? ConversationRegion.US : region;

    builder.setConversationRegion(region);

    if (StringUtil.isEmpty(url)) {
      builder.setConversationUrl(
          String.format(props.getProperty(CONVERSATION_SERVER_KEY), region.value()));
    }

    if (StringUtil.isEmpty(templateManagementUrl)) {
      builder.setConversationTemplateManagementUrl(
          String.format(props.getProperty(CONVERSATION_TEMPLATE_SERVER_KEY), region.value()));
    }
  }

  private void handleDefaultMailgunSettings(
      Configuration configuration, Properties props, Configuration.Builder builder) {

    MailgunRegion defaultRegion = MailgunRegion.US;

    Optional<MailgunContext> previousContext = configuration.getMailgunContext();
    MailgunContext.Builder contextBuilder = MailgunContext.builder();

    MailgunRegion region = previousContext.map(MailgunContext::getRegion).orElse(null);
    // default region to be used ?
    if (null == region && props.containsKey(MAILGUN_REGION_KEY)) {
      String value = props.getProperty(MAILGUN_REGION_KEY);
      if (!StringUtil.isEmpty(value)) {
        region = MailgunRegion.from(value);
      }
    }

    // url is not defined: use the region to set to an existing one and use "global" as a default
    // fallback
    String url = previousContext.map(MailgunContext::getUrl).orElse(null);
    if (StringUtil.isEmpty(url)) {
      if (null == region || defaultRegion.value().equals(region.value().toLowerCase())) {
        url = props.getProperty(MAILGUN_DEFAULT_SERVER_KEY);
      } else {
        url = String.format(props.getProperty(MAILGUN_REGION_SERVER_KEY), region.value());
      }
    }

    // storage URls are not defined: set a default set related to region in use
    Collection<String> storageUrls =
        previousContext.map(MailgunContext::getStorageUrls).orElse(null);
    if (null == storageUrls || storageUrls.isEmpty()) {
      MailgunRegion storageKeyRegion = null == region ? defaultRegion : region;
      String storageKey =
          String.format(
              MAILGUN_STORAGE_BY_REGION_SERVER_KEY, storageKeyRegion.value().toLowerCase());
      String value = props.getProperty(storageKey);
      if (!StringUtil.isEmpty(value)) {
        storageUrls =
            Arrays.stream(value.split(",")).map(String::trim).collect(Collectors.toList());
        contextBuilder.setStorageUrls(storageUrls);
      }
    }

    builder.setMailgunContext(contextBuilder.setUrl(url).setStorageUrls(storageUrls).build());
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

  /**
   * Get Mailgun domain service
   *
   * @return Return instance onto Mailgun API service
   * @see <a href="https://documentation.mailgun.com/">https://documentation.mailgun.com/</a>
   * @since 1.6
   */
  public MailgunService mailgun() {
    if (null == mailgun) {
      mailgun = mailgunInit();
    }
    return mailgun;
  }

  private void checkConfiguration(Configuration configuration) throws NullPointerException {
    Objects.requireNonNull(configuration.getOAuthUrl(), "'oauthUrl' cannot be null");
  }

  private NumbersService numbersInit() {
    return new com.sinch.sdk.domains.numbers.adapters.NumbersService(
        getConfiguration().getUnifiedCredentials().orElse(null),
        configuration.getNumbersContext().orElse(null),
        this::getHttpClient);
  }

  private SMSService smsInit() {

    return getConfiguration()
        .getSmsServicePlanCredentials()
        .map(
            f ->
                new com.sinch.sdk.domains.sms.adapters.SMSService(
                    f, getConfiguration().getSmsContext().orElse(null), this::getHttpClient))
        .orElseGet(
            () ->
                new com.sinch.sdk.domains.sms.adapters.SMSService(
                    getConfiguration().getUnifiedCredentials().orElse(null),
                    getConfiguration().getSmsContext().orElse(null),
                    configuration.getOAuthServer(),
                    this::getHttpClient));
  }

  private VerificationService verificationInit() {
    return new com.sinch.sdk.domains.verification.adapters.VerificationService(
        getConfiguration().getApplicationCredentials().orElse(null),
        getConfiguration().getVerificationContext().orElse(null),
        this::getHttpClient);
  }

  private VoiceService voiceInit() {
    return new com.sinch.sdk.domains.voice.adapters.VoiceService(
        getConfiguration().getApplicationCredentials().orElse(null),
        getConfiguration().getVoiceContext().orElse(null),
        this::getHttpClient);
  }

  private ConversationService conversationInit() {
    return new com.sinch.sdk.domains.conversation.adapters.ConversationService(
        getConfiguration().getUnifiedCredentials().orElse(null),
        getConfiguration().getConversationContext().orElse(null),
        getConfiguration().getOAuthServer(),
        this::getHttpClient);
  }

  private MailgunService mailgunInit() {
    return new com.sinch.sdk.domains.mailgun.adapters.MailgunService(
        getConfiguration().getMailgunCredentials().orElse(null),
        getConfiguration().getMailgunContext().orElse(null),
        getHttpClient());
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
      String userAgent = formatSdkUserAgentHeader();
      this.httpClient.setRequestHeaders(
          Stream.of(new String[][] {{SDK_USER_AGENT_HEADER, userAgent}})
              .collect(Collectors.toMap(data -> data[0], data -> data[1])));

      LOGGER.finest(String.format("HTTP client loaded (%s='%s'", SDK_USER_AGENT_HEADER, userAgent));
    }
    return this.httpClient;
  }

  private String formatSdkUserAgentHeader() {
    return String.format(
        SDK_USER_AGENT_FORMAT,
        SDK.VERSION,
        "Java",
        System.getProperty("java.version"),
        "Apache",
        formatAuxiliaryFlag());
  }

  private String formatAuxiliaryFlag() {

    Collection<String> values = Collections.singletonList(System.getProperty("java.vendor"));

    if (!StringUtil.isEmpty(SDK.AUXILIARY_FLAG)) {
      values.add(SDK.AUXILIARY_FLAG);
    }
    return String.join(",", values);
  }

  static {
    LocalLazyInit.init();
  }

  static final class LocalLazyInit {

    private LocalLazyInit() {
      DualToneMultiFrequencyMapper.initMapper();
    }

    public static LocalLazyInit init() {
      return LocalLazyInit.LazyHolder.INSTANCE;
    }

    private static class LazyHolder {

      public static final LocalLazyInit INSTANCE = new LocalLazyInit();
    }
  }
}
