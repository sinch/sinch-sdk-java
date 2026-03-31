package com.mycompany.app;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.core.utils.StringUtil;
import com.sinch.sdk.models.Configuration;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Config {

  private static final Logger LOGGER = Logger.getLogger(Config.class.getName());

  @Value("${credentials.application-api-key: }")
  String applicationKey;

  @Value("${credentials.application-api-secret: }")
  String applicationSecret;

  @Bean
  public SinchClient sinchClient() {

    Configuration.Builder builder = Configuration.builder();

    if (!StringUtil.isEmpty(applicationKey)) {
      builder.setApplicationKey(applicationKey);
    }

    if (!StringUtil.isEmpty(applicationSecret)) {
      builder.setApplicationSecret(applicationSecret);
    }

    return new SinchClient(builder.build());
  }
}
