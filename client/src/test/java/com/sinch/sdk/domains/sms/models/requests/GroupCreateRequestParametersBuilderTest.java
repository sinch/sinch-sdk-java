package com.sinch.sdk.domains.sms.models.requests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;
import java.util.Collections;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class GroupCreateRequestParametersBuilderTest {

  final String name = "my name";
  final String member = "a member";
  final String childGroupId = "a group id";

  Collection<String> members = Collections.singletonList(member);
  Collection<String> childGroupIds = Collections.singletonList(childGroupId);
  GroupAutoUpdateRequestParameters autoUpdate = GroupAutoUpdateRequestParameters.builder().build();
  final GroupCreateRequestParameters value =
      GroupCreateRequestParameters.builder()
          .setName(name)
          .setMembers(members)
          .setChildGroupIds(childGroupIds)
          .setAutoUpdate(autoUpdate)
          .build();

  @Test
  void getName() {
    Assertions.assertThat(value.getName().get()).isEqualTo(name);
  }

  @Test
  void getMembers() {
    Assertions.assertThat(value.getMembers().get()).isEqualTo(members);
  }

  @Test
  void getChildGroupIds() {
    Assertions.assertThat(value.getChildGroupIds().get()).isEqualTo(childGroupIds);
  }

  @Test
  void getAutoUpdate() {
    Assertions.assertThat(value.getAutoUpdate().get()).isEqualTo(autoUpdate);
  }
}
