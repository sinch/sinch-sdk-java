package com.mycompany.app;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.core.utils.StringUtil;
import com.sinch.sdk.models.Configuration;
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

    if (!StringUtil.isEmpty(smsRegion)) {
      builder.setSmsRegion(SMSRegion.from(smsRegion));
      LOGGER.info(String.format("SMS region: '%s'", smsRegion));
    }

    return new SinchClient(builder.build());
  }
}
