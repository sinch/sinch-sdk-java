package com.sinch.sdk.domains.sms.adapters.converters;

import com.sinch.sdk.core.utils.DateUtil;
import com.sinch.sdk.domains.sms.models.Group;
import com.sinch.sdk.domains.sms.models.GroupAutoUpdate;
import com.sinch.sdk.domains.sms.models.GroupAutoUpdateKeyword;
import com.sinch.sdk.domains.sms.models.dto.v1.AddKeywordDto;
import com.sinch.sdk.domains.sms.models.dto.v1.ApiGroupAutoUpdateDto;
import com.sinch.sdk.domains.sms.models.dto.v1.ApiGroupDto;
import com.sinch.sdk.domains.sms.models.dto.v1.ApiGroupListDto;
import com.sinch.sdk.domains.sms.models.dto.v1.CreateGroupResponseDto;
import com.sinch.sdk.domains.sms.models.dto.v1.GroupAutoUpdateDto;
import com.sinch.sdk.domains.sms.models.dto.v1.GroupObjectAutoUpdateDto;
import com.sinch.sdk.domains.sms.models.dto.v1.GroupObjectAutoUpdateRemoveDto;
import com.sinch.sdk.domains.sms.models.dto.v1.GroupObjectDto;
import com.sinch.sdk.domains.sms.models.dto.v1.RemoveKeywordDto;
import com.sinch.sdk.domains.sms.models.dto.v1.ReplaceGroupRequestDto;
import com.sinch.sdk.domains.sms.models.dto.v1.UpdateGroupRequestAutoUpdateAddDto;
import com.sinch.sdk.domains.sms.models.dto.v1.UpdateGroupRequestAutoUpdateDto;
import com.sinch.sdk.domains.sms.models.dto.v1.UpdateGroupRequestAutoUpdateRemoveDto;
import com.sinch.sdk.domains.sms.models.dto.v1.UpdateGroupRequestDto;
import com.sinch.sdk.domains.sms.models.requests.GroupAutoUpdateKeywordRequestParameters;
import com.sinch.sdk.domains.sms.models.requests.GroupAutoUpdateRequestParameters;
import com.sinch.sdk.domains.sms.models.requests.GroupCreateRequestParameters;
import com.sinch.sdk.domains.sms.models.requests.GroupReplaceRequestParameters;
import com.sinch.sdk.domains.sms.models.requests.GroupUpdateRequestParameters;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class GroupsDtoConverter {

  public static Group convert(CreateGroupResponseDto dto) {
    return Group.builder()
        .setId(dto.getId())
        .setName(dto.getName())
        .setSize(dto.getSize())
        .setCreatedAt(DateUtil.toInstant(dto.getCreatedAt()))
        .setModifiedAt(DateUtil.toInstant(dto.getModifiedAt()))
        .setChildGroupIds(convertChildGroups(dto.getChildGroups()))
        .setAutoUpdate(convert(dto.getAutoUpdate()))
        .build();
  }

  public static GroupObjectDto convert(GroupCreateRequestParameters client) {
    GroupObjectDto dto = new GroupObjectDto();
    client.getName().ifPresent(dto::name);
    client.getMembers().ifPresent(f -> dto.members(new ArrayList<>(f)));
    client.getChildGroupIds().ifPresent(f -> dto.childGroups(new ArrayList<>(f)));
    client.getAutoUpdate().ifPresent(f -> dto.autoUpdate(GroupsDtoConverter.convert(f)));
    return dto;
  }

  public static Collection<Group> convert(ApiGroupListDto dto) {

    Collection<ApiGroupDto> collection = dto.getGroups();
    Collection<Group> pageContent = new ArrayList<>();
    if (null != collection) {
      for (ApiGroupDto innerDto : collection) {
        Group convert = convert(innerDto);
        pageContent.add(convert);
      }
    }
    return pageContent;
  }

  public static ReplaceGroupRequestDto convert(GroupReplaceRequestParameters client) {
    ReplaceGroupRequestDto dto = new ReplaceGroupRequestDto();
    client.getName().ifPresent(dto::name);
    client.getMembers().ifPresent(f -> dto.members(new ArrayList<>(f)));
    return dto;
  }

  public static UpdateGroupRequestDto convert(GroupUpdateRequestParameters client) {
    UpdateGroupRequestDto dto = new UpdateGroupRequestDto();
    client.getName().ifPresent(dto::name);
    client.getAdd().ifPresent(f -> dto.add(new ArrayList<>(f)));
    client.getRemove().ifPresent(f -> dto.remove(new ArrayList<>(f)));
    client.getAddFromGroup().ifPresent(dto::addFromGroup);
    client.getRemoveFromGroup().ifPresent(dto::removeFromGroup);
    client.getAutoUpdate().ifPresent(f -> dto.autoUpdate(GroupsDtoConverter.convertForUpdate(f)));
    return dto;
  }

  private static Group convert(ApiGroupDto dto) {
    return Group.builder()
        .setId(dto.getId())
        .setName(dto.getName())
        .setSize(dto.getSize())
        .setCreatedAt(DateUtil.toInstant(dto.getCreatedAt()))
        .setModifiedAt(DateUtil.toInstant(dto.getModifiedAt()))
        .setChildGroupIds(convertChildGroups(dto.getChildGroups()))
        .setAutoUpdate(convert(dto.getAutoUpdate()))
        .build();
  }

  private static Collection<String> convertChildGroups(Set<Object> dto) {
    if (null == dto) {
      return null;
    }
    return dto.stream().map(f -> (String) f).collect(Collectors.toList());
  }

  private static GroupAutoUpdate convert(GroupAutoUpdateDto dto) {
    if (null == dto) {
      return null;
    }
    return GroupAutoUpdate.builder()
        .setTo(dto.getTo())
        .setAdd(convert(dto.getAdd()))
        .setRemove(convert(dto.getRemove()))
        .build();
  }

  private static GroupAutoUpdate convert(ApiGroupAutoUpdateDto dto) {
    if (null == dto) {
      return null;
    }
    return GroupAutoUpdate.builder()
        .setTo(dto.getTo())
        .setAdd(convert(dto.getAdd()))
        .setRemove(convert(dto.getRemove()))
        .build();
  }

  private static GroupObjectAutoUpdateDto convert(GroupAutoUpdateRequestParameters client) {
    if (null == client) {
      return null;
    }
    GroupObjectAutoUpdateDto dto = new GroupObjectAutoUpdateDto();
    client.getTo().ifPresent(dto::to);
    client.getAdd().ifPresent(f -> dto.add(convertAdd(f)));
    client.getRemove().ifPresent(f -> dto.remove(convertRemove(f)));
    return dto;
  }

  private static UpdateGroupRequestAutoUpdateDto convertForUpdate(
      GroupAutoUpdateRequestParameters client) {
    if (null == client) {
      return null;
    }
    UpdateGroupRequestAutoUpdateDto dto = new UpdateGroupRequestAutoUpdateDto();

    client.getTo().ifPresent(dto::to);
    client.getAdd().ifPresent(f -> dto.add(convertAdd(f)));
    client.getRemove().ifPresent(f -> dto.remove(convertRemoveForUpdate(f)));
    return dto;
  }

  private static GroupAutoUpdateKeyword convert(AddKeywordDto dto) {
    if (null == dto) {
      return null;
    }

    GroupAutoUpdateKeyword.Builder builder = GroupAutoUpdateKeyword.builder();
    if (dto.getFirstWordDefined()) {
      builder.setFirstWord(dto.getFirstWord());
    }
    if (dto.getSecondWordDefined()) {
      builder.setSecondWord(dto.getSecondWord());
    }
    return builder.build();
  }

  private static UpdateGroupRequestAutoUpdateAddDto convertAdd(
      GroupAutoUpdateKeywordRequestParameters client) {
    if (null == client) {
      return null;
    }

    UpdateGroupRequestAutoUpdateAddDto dto = new UpdateGroupRequestAutoUpdateAddDto();
    client.getFirstWord().ifPresent(dto::firstWord);
    client.getSecondWord().ifPresent(dto::secondWord);
    return dto;
  }

  private static GroupAutoUpdateKeyword convert(RemoveKeywordDto dto) {
    if (null == dto) {
      return null;
    }
    GroupAutoUpdateKeyword.Builder builder = GroupAutoUpdateKeyword.builder();
    if (dto.getFirstWordDefined()) {
      builder.setFirstWord(dto.getFirstWord());
    }
    if (dto.getSecondWordDefined()) {
      builder.setSecondWord(dto.getSecondWord());
    }
    return builder.build();
  }

  private static GroupObjectAutoUpdateRemoveDto convertRemove(
      GroupAutoUpdateKeywordRequestParameters client) {
    if (null == client) {
      return null;
    }

    GroupObjectAutoUpdateRemoveDto dto = new GroupObjectAutoUpdateRemoveDto();
    client.getFirstWord().ifPresent(dto::firstWord);
    client.getSecondWord().ifPresent(dto::secondWord);
    return dto;
  }

  private static UpdateGroupRequestAutoUpdateRemoveDto convertRemoveForUpdate(
      GroupAutoUpdateKeywordRequestParameters client) {
    if (null == client) {
      return null;
    }

    UpdateGroupRequestAutoUpdateRemoveDto dto = new UpdateGroupRequestAutoUpdateRemoveDto();
    client.getFirstWord().ifPresent(dto::firstWord);
    client.getSecondWord().ifPresent(dto::secondWord);
    return dto;
  }
}
