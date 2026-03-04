package com.mycompany.app;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.core.utils.StringUtil;
import com.sinch.sdk.domains.conversation.api.v1.MessagesService;
import com.sinch.sdk.models.Configuration;
import com.sinch.sdk.models.ConversationRegion;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Config {

  @Value("${credentials.project-id: }")
  private String projectId;

  @Value("${credentials.key-id: }")
  private String keyId;

  @Value("${credentials.key-secret: }")
  private String keySecret;

  @Value("${conversation.region: }")
  private String conversationRegion;

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

    if (!StringUtil.isEmpty(conversationRegion)) {
      builder.setConversationRegion(ConversationRegion.from(conversationRegion));
    }

    return new SinchClient(builder.build());
  }

  @Bean
  public MessagesService messagesService(SinchClient sinchClient) {
    return sinchClient.conversation().v1().messages();
  }
}
