package com.sinch.sample;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.models.ApplicationCredentials;
import com.sinch.sdk.models.Configuration;
import com.sinch.sdk.models.SmsServicePlanCredentials;
import java.io.IOException;
import java.util.Optional;
import java.util.Properties;
import java.util.logging.Logger;

public abstract class BaseApplication {

  private static final String BATCH_ID_KEY = "BATCH_ID";
  private static final String SMS_GROUP_ID_KEY = "SMS_GROUP_ID";

  public static final String PHONE_NUMBER_KEY = "PHONE_NUMBER";
  private static final String VIRTUAL_PHONE_NUMBER_KEY = "VIRTUAL_PHONE_NUMBER";
  public static final String CONFERENCE_ID_KEY = "CONFERENCE_ID";
  private static final String CALL_ID_KEY = "CALL_ID";
  private static final String VERIFICATION_ID_KEY = "VERIFICATION_ID";
  private static final String CONVERSATION_ID_KEY = "CONVERSATION_ID";
  private static final String CONVERSATION_APP_ID_KEY = "CONVERSATION_APP_ID";
  private static final String CONVERSATION_CONTACT_ID_KEY = "CONVERSATION_CONTACT_ID";
  private static final String CONVERSATION_MESSAGE_ID_KEY = "CONVERSATION_MESSAGE_ID";
  private static final String CONVERSATION_EVENT_ID_KEY = "CONVERSATION_EVENT_ID";
  private static final String CONVERSATION_WEBHOOK_ID_KEY = "CONVERSATION_WEBHOOK_ID";
  private static final String CONVERSATION_TEMPLATE_ID_KEY = "CONVERSATION_TEMPLATE_ID";

  public static final String WEBHOOKS_URL_KEY = "WEBHOOKS_URL";
  public static final String WEBHOOKS_NUMBERS_PATH_KEY = "WEBHOOKS_NUMBERS_PATH";
  public static final String WEBHOOKS_VOICE_PATH_KEY = "WEBHOOKS_VOICE_PATH";
  public static final String WEBHOOKS_SMS_PATH_KEY = "WEBHOOKS_SMS_PATH";
  public static final String WEBHOOKS_CONVERSATION_PATH_KEY = "WEBHOOKS_CONVERSATION_PATH";

  protected static final Logger LOGGER = Utils.initializeLogger(BaseApplication.class.getName());

  protected SinchClient client;

  protected String phoneNumber;
  protected String virtualPhoneNumber;
  protected String batchId;
  protected String smsGroupId;
  protected String conferenceId;
  protected String callId;
  protected String verificationId;
  protected String conversationId;
  protected String conversationAppId;
  protected String conversationContactId;
  protected String conversationMessageId;
  protected String conversationEventId;
  protected String conversationWebhookId;
  protected String conversationTemplateId;
  protected String smsServicePlanId;
  protected String smsApiToken;
  protected String applicationKey;
  protected Optional<String> webhooksConversationPath = Optional.empty();
  protected Optional<String> webhooksNumbersPath = Optional.empty();
  protected Optional<String> webhooksSmsPath = Optional.empty();
  protected Optional<String> webhooksVoicePath = Optional.empty();

  Properties properties;

  protected BaseApplication() throws IOException {

    LOGGER.info("Starting application");

    Configuration configuration = Utils.loadConfiguration(LOGGER);

    properties = Utils.loadProperties(LOGGER);

    phoneNumber = getConfigValue(PHONE_NUMBER_KEY);
    virtualPhoneNumber = getConfigValue(VIRTUAL_PHONE_NUMBER_KEY);

    batchId = getConfigValue(BATCH_ID_KEY);
    smsGroupId = getConfigValue(SMS_GROUP_ID_KEY);

    conferenceId = getConfigValue(CONFERENCE_ID_KEY);
    callId = getConfigValue(CALL_ID_KEY);

    // Verification related settings
    verificationId = getConfigValue(VERIFICATION_ID_KEY);
    virtualPhoneNumber = getConfigValue(VIRTUAL_PHONE_NUMBER_KEY);

    // Conversation related settings
    conversationId = getConfigValue(CONVERSATION_ID_KEY);
    conversationAppId = getConfigValue(CONVERSATION_APP_ID_KEY);
    conversationContactId = getConfigValue(CONVERSATION_CONTACT_ID_KEY);
    conversationMessageId = getConfigValue(CONVERSATION_MESSAGE_ID_KEY);
    conversationEventId = getConfigValue(CONVERSATION_EVENT_ID_KEY);
    conversationWebhookId = getConfigValue(CONVERSATION_WEBHOOK_ID_KEY);
    conversationTemplateId = getConfigValue(CONVERSATION_TEMPLATE_ID_KEY);

    String webhooksUrl = getConfigValue(WEBHOOKS_URL_KEY);
    if (null != webhooksUrl) {
      webhooksConversationPath =
          Optional.of(
              String.format("%s%s", webhooksUrl, getConfigValue(WEBHOOKS_CONVERSATION_PATH_KEY)));
      webhooksNumbersPath =
          Optional.of(
              String.format("%s%s", webhooksUrl, getConfigValue(WEBHOOKS_NUMBERS_PATH_KEY)));
      webhooksSmsPath =
          Optional.of(String.format("%s%s", webhooksUrl, getConfigValue(WEBHOOKS_SMS_PATH_KEY)));
      webhooksVoicePath =
          Optional.of(String.format("%s%s", webhooksUrl, getConfigValue(WEBHOOKS_VOICE_PATH_KEY)));
    }

    applicationKey =
        configuration
            .getApplicationCredentials()
            .map(ApplicationCredentials::getApplicationKey)
            .orElse(null);

    smsServicePlanId =
        configuration
            .getSmsServicePlanCredentials()
            .map(SmsServicePlanCredentials::getServicePlanId)
            .orElse(null);

    smsApiToken =
        configuration
            .getSmsServicePlanCredentials()
            .map(SmsServicePlanCredentials::getApiToken)
            .orElse(null);

    client = new SinchClient(configuration);
  }

  private String getConfigValue(String key) {
    return null != System.getenv(key) ? System.getenv(key) : properties.getProperty(key);
  }

  public abstract void run() throws InterruptedException;
}
