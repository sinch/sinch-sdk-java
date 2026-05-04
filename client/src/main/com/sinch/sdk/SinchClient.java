package com.sinch.sdk;

import com.sinch.sdk.core.utils.StringUtil;
import com.sinch.sdk.domains.conversation.ConversationService;
import com.sinch.sdk.domains.numbers.NumbersService;
import com.sinch.sdk.domains.sms.SMSService;
import com.sinch.sdk.domains.verification.VerificationService;
import com.sinch.sdk.domains.voice.VoiceService;
import com.sinch.sdk.http.HttpClientApache;
import com.sinch.sdk.models.Configuration;
import com.sinch.sdk.models.ConversationContext;
import com.sinch.sdk.models.ConversationRegion;
import com.sinch.sdk.models.NumbersContext;
import com.sinch.sdk.models.SMSRegion;
import com.sinch.sdk.models.SmsContext;
import com.sinch.sdk.models.VerificationContext;
import com.sinch.sdk.models.VoiceContext;
import com.sinch.sdk.models.VoiceRegion;
import com.sinch.sdk.models.adapters.DualToneMultiFrequencyMapper;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
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

  // sinch-sdk/{sdk_version} ({language}/{language_version}; {implementation_type};
  // {auxiliary_flag})
  private static final String SDK_USER_AGENT_HEADER = "User-Agent";
  private static final String SDK_USER_AGENT_FORMAT = "sinch-sdk/%s (%s/%s; %s; %s)";
  private static final Logger LOGGER = Logger.getLogger(SinchClient.class.getName());

  private final Configuration configuration;

  private volatile NumbersService numbers;
  private volatile SMSService sms;
  private volatile VerificationService verification;
  private volatile VoiceService voice;
  private volatile ConversationService conversation;
  private volatile HttpClientApache httpClient;

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

    SmsContext.Builder contextBuilder =
        SmsContext.builder(configuration.getSmsContext().orElse(null));

    // service plan ID activated: use dedicated server
    String serverKey =
        configuration
            .getSmsServicePlanCredentials()
            .map(unused -> SMS_SERVER_SERVICE_PLAN_KEY)
            .orElse(SMS_SERVER_KEY);
    if (null == contextBuilder.getSmsUrl() && props.containsKey(serverKey)) {
      contextBuilder.setSmsUrl(props.getProperty(serverKey));
    }

    SMSRegion smsRegion = contextBuilder.getSmsRegion();
    if (null == smsRegion && !StringUtil.isEmpty(props.getProperty(SMS_REGION_KEY))) {
      smsRegion = SMSRegion.from(props.getProperty(SMS_REGION_KEY).trim());
      contextBuilder.setSmsRegion(smsRegion);
    }

    builder.setSmsContext(contextBuilder.build());
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

    ConversationContext.Builder contextBuilder =
        ConversationContext.builder(configuration.getConversationContext().orElse(null));

    if (null == contextBuilder.getRegion()
        && !StringUtil.isEmpty(props.getProperty(CONVERSATION_REGION_KEY))) {
      contextBuilder.setRegion(
          ConversationRegion.from(props.getProperty(CONVERSATION_REGION_KEY).trim()));
    }

    if (StringUtil.isEmpty(contextBuilder.getUrl()) && null != contextBuilder.getRegion()) {
      contextBuilder.setUrl(
          String.format(props.getProperty(CONVERSATION_SERVER_KEY), contextBuilder.getRegion()));
    }

    if (StringUtil.isEmpty(contextBuilder.getTemplateManagementUrl())
        && null != contextBuilder.getRegion()) {
      contextBuilder.setTemplateManagementUrl(
          String.format(
              props.getProperty(CONVERSATION_TEMPLATE_SERVER_KEY), contextBuilder.getRegion()));
    }
    builder.setConversationContext(contextBuilder.build());
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
      synchronized (this) {
        if (null == numbers) {
          numbers = numbersInit();
        }
      }
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
      synchronized (this) {
        if (null == sms) {
          sms = smsInit();
        }
      }
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
      synchronized (this) {
        if (null == verification) {
          verification = verificationInit();
        }
      }
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
      synchronized (this) {
        if (null == voice) {
          voice = voiceInit();
        }
      }
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
      synchronized (this) {
        if (null == conversation) {
          conversation = conversationInit();
        }
      }
    }
    return conversation;
  }

  private void checkConfiguration(Configuration configuration) throws NullPointerException {
    Objects.requireNonNull(configuration.getOAuthUrl(), "'oauthUrl' cannot be null");
  }

  private NumbersService numbersInit() {
    return new com.sinch.sdk.domains.numbers.adapters.NumbersService(
        getConfiguration().getUnifiedCredentials().orElse(null),
        configuration.getNumbersContext().orElse(null),
        configuration.getOAuthServer(),
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
    HttpClientApache local = httpClient;
    if (null == local || local.isClosed()) {
      synchronized (this) {
        local = httpClient;
        if (null == local || local.isClosed()) {
          local = new HttpClientApache();

          // set SDK User-Agent
          String userAgent = formatSdkUserAgentHeader();
          local.setRequestHeaders(
              Stream.of(new String[][] {{SDK_USER_AGENT_HEADER, userAgent}})
                  .collect(Collectors.toMap(data -> data[0], data -> data[1])));

          LOGGER.finest(
              String.format("HTTP client loaded (%s='%s'", SDK_USER_AGENT_HEADER, userAgent));
          this.httpClient = local;
        }
      }
    }
    return local;
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
    return formatAuxiliaryFlag(SDK.AUXILIARY_FLAG);
  }

  // Package-private to allow unit-testing with an arbitrary flag value
  String formatAuxiliaryFlag(String auxiliaryFlag) {
    Collection<String> values = new ArrayList<>();
    String vendor = System.getProperty("java.vendor");
    values.add(StringUtil.isEmpty(vendor) ? "" : vendor);
    if (!StringUtil.isEmpty(auxiliaryFlag)) {
      values.add(auxiliaryFlag);
    }
    return String.join(",", values);
  }

  /**
   * Releases the underlying HTTP client and its connection pool, and resets all lazily-initialized
   * domain services.
   *
   * <p>After this call, in-flight requests may be affected by shutdown of the underlying HTTP
   * client and are not guaranteed to complete normally. The next API call on any domain service
   * will transparently re-initialize both the service and the HTTP client. Idempotent: safe to call
   * more than once.
   *
   * <p>Any exception thrown by the underlying HTTP client during close is caught and logged at
   * WARNING level.
   *
   * @since 2.1
   */
  public void close() {
    synchronized (this) {
      HttpClientApache local = httpClient;
      httpClient = null;
      numbers = null;
      sms = null;
      verification = null;
      voice = null;
      conversation = null;
      if (local != null) {
        try {
          local.close();
        } catch (Exception e) {
          LOGGER.warning("Exception while closing HTTP client: " + e.getMessage());
        }
      }
    }
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
