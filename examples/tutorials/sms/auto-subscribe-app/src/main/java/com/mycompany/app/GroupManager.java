package com.mycompany.app;

import com.sinch.sdk.domains.sms.GroupsService;
import com.sinch.sdk.domains.sms.SMSService;
import com.sinch.sdk.domains.sms.models.Group;
import com.sinch.sdk.domains.sms.models.requests.GroupCreateRequestParameters;
import java.util.Optional;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GroupManager {

  private static final Logger LOGGER = Logger.getLogger(GroupManager.class.getName());

  private final String GROUP_NAME = "Sinch Pirates";

  private final SMSService smsService;

  @Autowired
  public GroupManager(SMSService smsService) {
    this.smsService = smsService;
  }

  public Group getGroup() {

    GroupsService service = smsService.groups();

    // ensure we do not create a new group if already existing with same name
    Optional<Group> group = retrieveGroup(service);
    return group.orElseGet(() -> createGroup(service));
  }

  /*
   * Retrieve group ID if group is existing
   */
  private Optional<Group> retrieveGroup(GroupsService service) {

    Optional<Group> found =
        service.list().stream().filter(group -> group.getName().equals(GROUP_NAME)).findFirst();

    found.ifPresent(
        group ->
            LOGGER.info("Group '%s' find with id '%s'".formatted(group.getName(), group.getId())));
    return found;
  }

  /*`
   * Create a new group
   */
  private Group createGroup(GroupsService service) {

    var request = GroupCreateRequestParameters.builder().setName(GROUP_NAME).build();

    var group = service.create(request);

    LOGGER.info("Group '%s' created with id '%s'".formatted(group.getName(), group.getId()));
    return group;
  }
}
