package com.sinch.sample.conversation.projectsettings;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.conversation.api.v1.ProjectSettingsService;
import java.io.IOException;
import java.util.logging.Logger;

public class Get extends BaseApplication {

  private static final Logger LOGGER = Logger.getLogger(Get.class.getName());

  public Get() throws IOException {}

  public static void main(String[] args) {
    try {
      new Get().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    ProjectSettingsService service = client.conversation().v1().projectSettings();

    LOGGER.info("Get conversation project settings");

    var result = service.get();

    LOGGER.info("Response: " + result);
  }
}
