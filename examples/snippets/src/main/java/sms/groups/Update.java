/**
 * Sinch Java Snippet
 *
 * <p>This snippet is available at https://github.com/sinch/sinch-sdk-java
 *
 * <p>See https://github.com/sinch/sinch-sdk-java/blob/main/examples/snippets/README.md for details
 */
package sms.groups;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.sms.api.v1.GroupsService;
import com.sinch.sdk.domains.sms.models.v1.groups.Group;
import com.sinch.sdk.domains.sms.models.v1.groups.request.GroupUpdateRequest;
import com.sinch.sdk.models.Configuration;
import com.sinch.sdk.models.SMSRegion;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import utils.Settings;

public class Update {

  private static final Logger LOGGER = Logger.getLogger(Update.class.getName());

  public static void main(String[] args) {

    String projectId = Settings.getProjectId().orElse("MY_PROJECT_ID");
    String keyId = Settings.getKeyId().orElse("MY_KEY_ID");
    String keySecret = Settings.getKeySecret().orElse("MY_KEY_SECRET");
    String smsRegion = Settings.getSMSRegion().orElse("MY_SMS_REGION");

    // The ID of the group to update
    String groupId = "GROUP_ID";
    // New name for the group
    String groupName = "Updated Group Name from Java SDK";
    // Members to remove from the group
    List<String> toRemove = Arrays.asList("+11111111111", "+29999999999");
    // Members to add to the group
    List<String> toAdd = Arrays.asList("+123456789", "+987654321");

    Configuration configuration =
        Configuration.builder()
            .setProjectId(projectId)
            .setKeyId(keyId)
            .setKeySecret(keySecret)
            .setSmsRegion(SMSRegion.from(smsRegion))
            .build();

    SinchClient client = new SinchClient(configuration);

    GroupsService groupsService = client.sms().v1().groups();

    GroupUpdateRequest request =
        GroupUpdateRequest.builder().setName(groupName).setAdd(toAdd).setRemove(toRemove).build();

    LOGGER.info(String.format("Update group with ID '%s'", groupId));

    Group response = groupsService.update(groupId, request);

    LOGGER.info("Response: " + response);
  }
}
