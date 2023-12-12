package com.sinch.sample.webhooks;

import com.sinch.sample.Utils;
import com.sinch.sdk.SinchClient;
import com.sinch.sdk.models.Configuration;
import java.util.Properties;
import java.util.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VerificationApplication {
  private static final Logger LOGGER = Logger.getLogger(VerificationApplication.class.getName());

  public static void main(String[] args) {

    SpringApplication.run(VerificationApplication.class, args);
  }

  @Bean
  public SinchClient sinchClient() {
    Configuration configuration = Utils.loadConfiguration(LOGGER);
   return new SinchClient(configuration);
  }
}
