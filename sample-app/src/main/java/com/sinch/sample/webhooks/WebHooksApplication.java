package com.sinch.sample.webhooks;

import com.sinch.sample.Utils;
import com.sinch.sdk.SinchClient;
import com.sinch.sdk.models.Configuration;
import java.util.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WebHooksApplication {
  private static final Logger LOGGER = Logger.getLogger(WebHooksApplication.class.getName());

  public static void main(String[] args) {

    SpringApplication.run(WebHooksApplication.class, args);
  }

  @Bean
  public SinchClient sinchClient() {
    Configuration configuration = Utils.loadConfiguration(LOGGER);
    return new SinchClient(configuration);
  }
}
