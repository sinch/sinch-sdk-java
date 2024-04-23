package com.mycompany.app;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.voice.VoiceService;
import com.sinch.sdk.models.Configuration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Config {

  @Value("${credentials.application.api-key}")
  String applicationApiKey;

  @Value("${credentials.application.api-secret}")
  String applicationApiSecret;

  @Value("${voice.controller-path}")
  private String controllerPath;

  @Bean
  public VoiceService voiceService() {

    var configuration =
        Configuration.builder()
            .setApplicationKey(applicationApiKey)
            .setApplicationSecret(applicationApiSecret)
            .build();

    return new SinchClient(configuration).voice();
  }

  @Bean
  String controllerPath() {
    return controllerPath;
  }
}
