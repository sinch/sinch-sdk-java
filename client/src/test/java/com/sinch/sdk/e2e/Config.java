package com.sinch.sdk.e2e;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.models.Configuration;
import com.sinch.sdk.models.ConversationContext;
import com.sinch.sdk.models.ConversationRegion;

public class Config {

  public static final String PROJECT_ID = "tinyfrog-jump-high-over-lilypadbasin";
  public static final String KEY_ID = "'keyId";
  public static final String KEY_SECRET = "keySecret";
  public static final String AUTH_URL = "http://localhost:3011/oauth2/token";
  public static final String CONVERSATION_HOST_NAME = "http://localhost:3014";
  public static final String CONVERSATION_TEMPLATE_HOST_NAME = "http://localhost:3015";
  public static final ConversationRegion CONVERSATION_REGION = ConversationRegion.US;

  private final SinchClient client;

  private Config() {

    Configuration configuration =
        Configuration.builder()
            .setOAuthUrl(Config.AUTH_URL)
            .setProjectId(Config.PROJECT_ID)
            .setKeyId(Config.KEY_ID)
            .setKeySecret(Config.KEY_SECRET)
            .setConversationContext(
                ConversationContext.builder()
                    .setUrl(Config.CONVERSATION_HOST_NAME)
                    .setRegion(Config.CONVERSATION_REGION)
                    .setTemplateManagementUrl(CONVERSATION_TEMPLATE_HOST_NAME)
                    .build())
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
