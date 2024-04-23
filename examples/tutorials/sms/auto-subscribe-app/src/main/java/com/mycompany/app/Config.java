package com.mycompany.app;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.sms.SMSService;
import com.sinch.sdk.models.Configuration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Config {

  @Value("${credentials.project-id}")
  String projectId;

  @Value("${credentials.key-id}")
  String keyId;

  @Value("${credentials.key-secret}")
  String keySecret;

  @Bean
  public SMSService smsService() {

    var configuration =
        Configuration.builder()
            .setKeyId(keyId)
            .setKeySecret(keySecret)
            .setProjectId(projectId)
            .build();

    return new SinchClient(configuration).sms();
  }
}
