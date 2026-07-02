package com.sinch.sdk.e2e;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.models.Configuration;
import com.sinch.sdk.models.ConversationContext;
import com.sinch.sdk.models.ConversationRegion;
import com.sinch.sdk.models.HttpProxyConfiguration;
import com.sinch.sdk.models.NumberLookupContext;
import com.sinch.sdk.models.NumbersContext;
import com.sinch.sdk.models.SMSRegion;
import com.sinch.sdk.models.SmsContext;
import com.sinch.sdk.models.VerificationContext;
import com.sinch.sdk.models.VoiceContext;

public class Config {

  public static final String PROJECT_ID = "tinyfrog-jump-high-over-lilypadbasin";
  public static final String KEY_ID = "'keyId";
  public static final String KEY_SECRET = "keySecret";
  public static final String AUTH_URL = "http://localhost:3011/oauth2/token";
  public static final String NUMBERS_HOST_NAME = "http://localhost:3013";
  public static final String CONVERSATION_HOST_NAME = "http://localhost:3014";
  public static final String CONVERSATION_TEMPLATE_HOST_NAME = "http://localhost:3015";
  public static final ConversationRegion CONVERSATION_REGION = ConversationRegion.US;

  public static final String APPLICATION_KEY = "appKey";
  public static final String APPLICATION_SECRET = "YXBwU2VjcmV0";
  public static final String VOICE_HOST_NAME = "http://localhost:3019";
  public static final String VOICE_MANAGEMENT_HOST_NAME = "http://localhost:3020";

  public static final String MAILGUN_HOST_NAME = "http://localhost:3021";
  public static final String MAILGUN_API_KEY = "apiKey";
  public static final String MAILGUN_STORAGE = "http://localhost:3021";

  public static final String SMS_HOST_NAME = "http://localhost:3017";

  public static final String VERIFICATION_HOST_NAME = "http://localhost:3018";

  public static final String NUMBER_LOOKUP_HOST_NAME = "http://localhost:3022";

  public static final int PROXY_UNAUTHENTICATED_PORT = 3128;
  public static final int PROXY_AUTHENTICATED_PORT = 3129;
  public static final String PROXY_HOST = "localhost";
  public static final String PROXY_USERNAME = "user";
  public static final String PROXY_PASSWORD = "password";

  public static final String PROXY_VISIBLE_AUTH_URL =
      "http://authentication-server:1080/oauth2/token";
  public static final String PROXY_VISIBLE_NUMBER_LOOKUP_URL = "http://proxy-reachable-server:1080";

  private final SinchClient client;
  private final SinchClient clientServicePlanId;
  private final SinchClient clientProxyUnauthenticated;
  private final SinchClient clientProxyAuthenticated;

  private Config() {

    Configuration configuration =
        Configuration.builder()
            .setOAuthUrl(Config.AUTH_URL)
            .setProjectId(Config.PROJECT_ID)
            .setKeyId(Config.KEY_ID)
            .setKeySecret(Config.KEY_SECRET)
            .setNumbersContext(NumbersContext.builder().setNumbersUrl(NUMBERS_HOST_NAME).build())
            .setConversationContext(
                ConversationContext.builder()
                    .setUrl(Config.CONVERSATION_HOST_NAME)
                    .setRegion(Config.CONVERSATION_REGION)
                    .setTemplateManagementUrl(CONVERSATION_TEMPLATE_HOST_NAME)
                    .build())
            .setApplicationKey(APPLICATION_KEY)
            .setApplicationSecret(APPLICATION_SECRET)
            .setVoiceContext(
                VoiceContext.builder()
                    .setVoiceApplicationMngmtUrl(VOICE_MANAGEMENT_HOST_NAME)
                    .setVoiceUrl(VOICE_HOST_NAME)
                    .build())
            .setSmsContext(
                SmsContext.builder().setSmsUrl(SMS_HOST_NAME).setSmsRegion(SMSRegion.EU).build())
            .setVerificationContext(
                VerificationContext.builder().setVerificationUrl(VERIFICATION_HOST_NAME).build())
            .setNumberLookupContext(
                NumberLookupContext.builder().setNumberLookupUrl(NUMBER_LOOKUP_HOST_NAME).build())
            .build();

    client = new SinchClient(configuration);

    Configuration configurationServicePlanId =
        Configuration.builder()
            .setSmsServicePlanId("CappyPremiumPlan")
            .setSmsApiToken("HappyCappyToken")
            .setSmsContext(
                SmsContext.builder().setSmsUrl(SMS_HOST_NAME).setSmsRegion(SMSRegion.EU).build())
            .build();

    clientServicePlanId = new SinchClient(configurationServicePlanId);

    clientProxyUnauthenticated =
        new SinchClient(
            createConfigurationWithProxyUsage(
                HttpProxyConfiguration.builder()
                    .setHostname(PROXY_HOST)
                    .setPort(Config.PROXY_UNAUTHENTICATED_PORT)
                    .build()));

    clientProxyAuthenticated =
        new SinchClient(
            createConfigurationWithProxyUsage(
                HttpProxyConfiguration.builder()
                    .setHostname(PROXY_HOST)
                    .setPort(Config.PROXY_AUTHENTICATED_PORT)
                    .setUsername(PROXY_USERNAME)
                    .setPassword(PROXY_PASSWORD)
                    .build()));
  }

  private static class LazyHolder {
    private static final Config INSTANCE = new Config();
  }

  public static SinchClient getSinchClient() {
    return LazyHolder.INSTANCE.client;
  }

  public static SinchClient getSinchClientServicePlanId() {
    return LazyHolder.INSTANCE.clientServicePlanId;
  }

  public static SinchClient getSinchClientProxyUnauthenticated() {
    return LazyHolder.INSTANCE.clientProxyUnauthenticated;
  }

  public static SinchClient getSinchClientProxyAuthenticated() {
    return LazyHolder.INSTANCE.clientProxyAuthenticated;
  }

  private static Configuration createConfigurationWithProxyUsage(HttpProxyConfiguration proxy) {
    return Configuration.builder()
        .setOAuthUrl(PROXY_VISIBLE_AUTH_URL)
        .setProjectId(Config.PROJECT_ID)
        .setKeyId(Config.KEY_ID)
        .setKeySecret(Config.KEY_SECRET)
        .setNumberLookupContext(
            NumberLookupContext.builder()
                .setNumberLookupUrl(PROXY_VISIBLE_NUMBER_LOOKUP_URL)
                .build())
        .setHttpProxyConfiguration(proxy)
        .build();
  }
}
