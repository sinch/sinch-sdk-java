package com.mycompany.app;

import com.sinch.sdk.domains.sms.SMSService;
import com.sinch.sdk.domains.sms.models.Group;
import com.sinch.sdk.domains.sms.models.InboundText;
import com.sinch.sdk.domains.sms.models.requests.GroupUpdateRequestParameters;
import com.sinch.sdk.domains.sms.models.requests.SendSmsBatchTextRequest;
import java.util.Collection;
import java.util.Collections;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutoSubscribeService {

  private static final Logger LOGGER = Logger.getLogger(AutoSubscribeService.class.getName());

  private final SMSService smsService;
  private final Group group;

  @Autowired
  public AutoSubscribeService(SMSService smsService) {
    this.smsService = smsService;
    this.group = new GroupManager(smsService).getGroup();
  }

  public void processInboundEvent(InboundText event) {

    LOGGER.info("Received event:" + event);

    var from = event.getFrom();
    var to = event.getTo();
    var body = event.getBody().trim();

    var membersList = getMembersList(group);
    var isMemberInGroup = isMemberInGroup(membersList, from);

    String response;

    if (body.equals("SUBSCRIBE")) {
      response = subscribe(group, isMemberInGroup, to, from);
    } else if (body.equals("STOP")) {
      response = unsubscribe(group, isMemberInGroup, to, from);
    } else {
      response =
          "Thanks for your interest. If you want to subscribe to this group, text \"SUBSCRIBE\"  to +%s"
              .formatted(to);
    }

    sendResponse(to, from, response);
  }

  private Collection<String> getMembersList(Group group) {
    return smsService.groups().listMembers(group.getId());
  }

  private boolean isMemberInGroup(Collection<String> membersList, String member) {
    return membersList.contains(member);
  }

  private String subscribe(
      Group group, boolean isMemberInGroup, String groupPhoneNumber, String member) {

    if (isMemberInGroup) {
      return "You already subscribed to '%s'. Text \"STOP\" to +%s to leave this group."
          .formatted(group.getName(), groupPhoneNumber);
    }

    var request =
        GroupUpdateRequestParameters.builder().setAdd(Collections.singletonList(member)).build();

    smsService.groups().update(group.getId(), request);
    return "Congratulations! You are now subscribed to '%s'. Text \"STOP\" to +%s to leave this group."
        .formatted(group.getName(), groupPhoneNumber);
  }

  private String unsubscribe(
      Group group, boolean isMemberInGroup, String groupPhoneNumber, String member) {

    if (!isMemberInGroup) {
      return "You did not subscribed to '%s'. Text \"SUBSCRIBE\" to +%s to join this group."
          .formatted(group.getName(), groupPhoneNumber);
    }

    var request =
        GroupUpdateRequestParameters.builder().setRemove(Collections.singletonList(member)).build();

    smsService.groups().update(group.getId(), request);
    return "We're sorry to see you go. You can always rejoin '%s' by texting \"SUBSCRIBE\" to +%s."
        .formatted(group.getName(), groupPhoneNumber);
  }

  private void sendResponse(String from, String to, String response) {

    var request =
        SendSmsBatchTextRequest.builder()
            .setTo(Collections.singletonList(to))
            .setBody(response)
            .setFrom(from)
            .build();

    smsService.batches().send(request);

    LOGGER.info("Replied: '%s'".formatted(response));
  }
}
