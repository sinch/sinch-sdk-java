package com.mycompany.app;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.core.utils.StringUtil;
import com.sinch.sdk.models.Configuration;
import com.sinch.sdk.models.ConversationRegion;
import com.sinch.sdk.models.SMSRegion;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Config {

  private static final Logger LOGGER = Logger.getLogger(Config.class.getName());

  @Value("${credentials.project-id: }")
  String projectId;

  @Value("${credentials.key-id: }")
  String keyId;

  @Value("${credentials.key-secret: }")
  String keySecret;

  @Value("${credentials.application-api-key: }")
  String applicationKey;

  @Value("${credentials.application-api-secret: }")
  String applicationSecret;

  @Value("${conversation.region: }")
  String conversationRegion;

  @Value("${sms.region: }")
  String smsRegion;

  @Bean
  public SinchClient sinchClient() {

    Configuration.Builder builder = Configuration.builder();

    if (!StringUtil.isEmpty(projectId)) {
      builder.setProjectId(projectId);
    }

    if (!StringUtil.isEmpty(keyId)) {
      builder.setKeyId(keyId);
    }
    if (!StringUtil.isEmpty(keySecret)) {
      builder.setKeySecret(keySecret);
    }

    if (!StringUtil.isEmpty(applicationKey)) {
      builder.setApplicationKey(applicationKey);
    }

    if (!StringUtil.isEmpty(applicationSecret)) {
      builder.setApplicationSecret(applicationSecret);
    }

    if (!StringUtil.isEmpty(conversationRegion)) {
      builder.setConversationRegion(ConversationRegion.from(conversationRegion));
      LOGGER.info(String.format("Conversation region: '%s'", conversationRegion));
    }

    if (!StringUtil.isEmpty(smsRegion)) {
      builder.setSmsRegion(SMSRegion.from(smsRegion));
      LOGGER.info(String.format("SMS region: '%s'", smsRegion));
    }

    return new SinchClient(builder.build());
  }
}
