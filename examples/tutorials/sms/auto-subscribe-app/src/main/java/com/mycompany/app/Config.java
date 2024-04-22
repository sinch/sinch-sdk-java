package com.mycompany.app;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.sms.SMSService;
import com.sinch.sdk.models.Configuration;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Config {

  @Bean
  public SMSService smsService() {

    var keyId = "YOUR_access_key";
    var keySecret = "YOUR_access_secret";
    var projectId = "YOUR_project_id";

    var configuration =
        Configuration.builder()
            .setKeyId(keyId)
            .setKeySecret(keySecret)
            .setProjectId(projectId)
            .build();

    return new SinchClient(configuration).sms();
  }
}
