/**
 * Sinch Java Snippet
 *
 * <p>This snippet is available at https://github.com/sinch/sinch-sdk-java-snippets
 *
 * <p>See https://github.com/sinch/sinch-sdk-java-snippets/blob/main/README.md for details
 */
package sms.groups;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.sms.api.v1.GroupsService;
import com.sinch.sdk.domains.sms.models.v1.groups.Group;
import com.sinch.sdk.domains.sms.models.v1.groups.request.GroupRequest;
import com.sinch.sdk.models.Configuration;
import com.sinch.sdk.models.SMSRegion;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;
import utils.Settings;

public class Replace {

  private static final Logger LOGGER = Logger.getLogger(Replace.class.getName());

  public static void main(String[] args) {

    String projectId = Settings.getProjectId().orElse("MY_PROJECT_ID");
    String keyId = Settings.getKeyId().orElse("MY_KEY_ID");
    String keySecret = Settings.getKeySecret().orElse("MY_KEY_SECRET");
    String smsRegion = Settings.getSMSRegion().orElse("MY_SMS_REGION");

    // The ID of the group to replace members for
    String groupId = "GROUP_ID";
    // The new members to set for the group (Phone numbers in E.164 format)
    Set<String> members = new HashSet<>(Arrays.asList("RECIPIENT_PHONE_NUMBER"));

    Configuration configuration =
        Configuration.builder()
            .setProjectId(projectId)
            .setKeyId(keyId)
            .setKeySecret(keySecret)
            .setSmsRegion(SMSRegion.from(smsRegion))
            .build();

    SinchClient client = new SinchClient(configuration);

    GroupsService groupsService = client.sms().v1().groups();

    GroupRequest request = GroupRequest.builder().setMembers(members).build();

    LOGGER.info(String.format("Replace group with ID '%s'", groupId));

    Group response = groupsService.replace(groupId, request);

    LOGGER.info("Response :" + response);
  }
}
