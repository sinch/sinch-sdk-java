package com.mycompany.app;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.core.utils.StringUtil;
import com.sinch.sdk.models.Configuration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Config {

  @Value("${SINCH_PROJECT_ID:}")
  String projectId;

  @Value("${SINCH_KEY_ID:}")
  String keyId;

  @Value("${SINCH_KEY_SECRET:}")
  String keySecret;

  @Bean
  public SinchClient sinchClient() {

    // Sinch Events do not need any credentials: they are only required to call the Voice API
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

    return new SinchClient(builder.build());
  }
}
