package com.mycompany.app;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.conversation.api.v1.MessagesService;
import com.sinch.sdk.models.Configuration;
import com.sinch.sdk.models.ConversationRegion;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Config {

  @Value("${credentials.project-id}")
  private String projectId;

  @Value("${credentials.key-id}")
  private String keyId;

  @Value("${credentials.key-secret}")
  private String keySecret;

  @Value("${conversation.region}")
  private String conversationRegion;

  @Bean
  public SinchClient sinchClient() {

    Configuration configuration =
        Configuration.builder()
            .setProjectId(projectId)
            .setKeyId(keyId)
            .setKeySecret(keySecret)
            .setConversationRegion(ConversationRegion.from(conversationRegion))
            .build();

    return new SinchClient(configuration);
  }

  @Bean
  public MessagesService messagesService(SinchClient sinchClient) {
    return sinchClient.conversation().v1().messages();
  }
}
