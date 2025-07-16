package com.sinch.sdk.e2e;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.models.Configuration;
import com.sinch.sdk.models.ConversationContext;
import com.sinch.sdk.models.ConversationRegion;
import com.sinch.sdk.models.MailgunContext;
import com.sinch.sdk.models.NumbersContext;
import com.sinch.sdk.models.SmsContext;
import com.sinch.sdk.models.VerificationContext;
import com.sinch.sdk.models.VoiceContext;
import java.util.Arrays;

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

  private final SinchClient client;

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
            .setMailgunContext(
                MailgunContext.builder().setStorageUrls(Arrays.asList(MAILGUN_STORAGE)).build())
            .setMailgunApiKey(MAILGUN_API_KEY)
            .setMailgunUrl(MAILGUN_HOST_NAME)
            .setSmsContext(SmsContext.builder().setSmsUrl(SMS_HOST_NAME).build())
            .setVerificationContext(
                VerificationContext.builder().setVerificationUrl(VERIFICATION_HOST_NAME).build())
            .build();

    client = new SinchClient(configuration);
  }

  private static class LazyHolder {
    private static final Config INSTANCE = new Config();
  }

  public static SinchClient getSinchClient() {
    return LazyHolder.INSTANCE.client;
  }
}
