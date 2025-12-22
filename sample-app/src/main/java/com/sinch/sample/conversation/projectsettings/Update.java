package com.sinch.sample.conversation.projectsettings;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.conversation.api.v1.ProjectSettingsService;
import com.sinch.sdk.domains.conversation.models.v1.projectsettings.ContactSettings;
import com.sinch.sdk.domains.conversation.models.v1.projectsettings.request.ProjectSettingsRequest;
import java.io.IOException;
import java.util.logging.Logger;

public class Update extends BaseApplication {

  private static final Logger LOGGER = Logger.getLogger(Update.class.getName());

  public Update() throws IOException {}

  public static void main(String[] args) {
    try {
      new Update().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    ProjectSettingsService service = client.conversation().v1().projectSettings();

    LOGGER.info("conversation project settings");

    var contactSettings = ContactSettings.builder().setUnifiedContactIdEnabled(false).build();

    var parameters = ProjectSettingsRequest.builder().setContactSettings(contactSettings).build();

    var result = service.update(parameters);

    LOGGER.info("Response: " + result);
  }
}
