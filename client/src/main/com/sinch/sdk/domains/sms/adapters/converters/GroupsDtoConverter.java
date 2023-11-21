package com.sinch.sdk.domains.sms.adapters.converters;

import com.sinch.sdk.core.models.pagination.CursorPageNavigator;
import com.sinch.sdk.core.utils.DateUtil;
import com.sinch.sdk.core.utils.Pair;
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
    return new GroupObjectDto()
        .name(client.getName().orElse(null))
        .members(client.getMembers().map(ArrayList::new).orElse(null))
        .childGroups(client.getChildGroupIds().map(ArrayList::new).orElse(null))
        .autoUpdate(client.getAutoUpdate().map(GroupsDtoConverter::convert).orElse(null));
  }

  public static Pair<Collection<Group>, CursorPageNavigator> convert(ApiGroupListDto dto) {
    CursorPageNavigator navigator =
        new CursorPageNavigator(dto.getPage(), dto.getPageSize(), dto.getCount());
    Collection<ApiGroupDto> collection = dto.getGroups();
    Collection<Group> pageContent = new ArrayList<>();
    if (null != collection) {
      for (ApiGroupDto innerDto : collection) {
        Group convert = convert(innerDto);
        pageContent.add(convert);
      }
    }
    return new Pair<>(pageContent, navigator);
  }

  public static ReplaceGroupRequestDto convert(GroupReplaceRequestParameters client) {
    return new ReplaceGroupRequestDto()
        .name(client.getName().orElse(null))
        .members(client.getMembers().map(ArrayList::new).orElse(null));
  }

  public static UpdateGroupRequestDto convert(GroupUpdateRequestParameters client) {
    return new UpdateGroupRequestDto()
        .name(client.getName().orElse(null))
        .add(client.getAdd().map(ArrayList::new).orElse(null))
        .remove(client.getRemove().map(ArrayList::new).orElse(null))
        .addFromGroup(client.getAddFromGroup().orElse(null))
        .removeFromGroup(client.getRemoveFromGroup().orElse(null))
        .autoUpdate(client.getAutoUpdate().map(GroupsDtoConverter::convertForUpdate).orElse(null));
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

  private static GroupObjectAutoUpdateDto convert(GroupAutoUpdate client) {
    if (null == client) {
      return null;
    }
    return new GroupObjectAutoUpdateDto()
        .to(client.getTo())
        .add(convertAdd(client.getAdd()))
        .remove(convertRemove(client.getRemove()));
  }

  private static UpdateGroupRequestAutoUpdateDto convertForUpdate(GroupAutoUpdate client) {
    if (null == client) {
      return null;
    }
    return new UpdateGroupRequestAutoUpdateDto()
        .to(client.getTo())
        .add(convertAdd(client.getAdd()))
        .remove(convertRemoveForUpdate(client.getRemove()));
  }

  private static GroupAutoUpdateKeyword convert(AddKeywordDto dto) {
    if (null == dto) {
      return null;
    }
    return GroupAutoUpdateKeyword.builder()
        .setFirstWord(dto.getFirstWord())
        .setSecondWord(dto.getSecondWord())
        .build();
  }

  private static UpdateGroupRequestAutoUpdateAddDto convertAdd(GroupAutoUpdateKeyword client) {
    if (null == client) {
      return null;
    }
    return new UpdateGroupRequestAutoUpdateAddDto()
        .firstWord(client.getFirstWord())
        .secondWord(client.getSecondWord());
  }

  private static GroupAutoUpdateKeyword convert(RemoveKeywordDto dto) {
    if (null == dto) {
      return null;
    }
    return GroupAutoUpdateKeyword.builder()
        .setFirstWord(dto.getFirstWord())
        .setSecondWord(dto.getSecondWord())
        .build();
  }

  private static GroupObjectAutoUpdateRemoveDto convertRemove(GroupAutoUpdateKeyword client) {
    if (null == client) {
      return null;
    }
    return new GroupObjectAutoUpdateRemoveDto()
        .firstWord(client.getFirstWord())
        .secondWord(client.getSecondWord());
  }

  private static UpdateGroupRequestAutoUpdateRemoveDto convertRemoveForUpdate(
      GroupAutoUpdateKeyword client) {
    if (null == client) {
      return null;
    }
    return new UpdateGroupRequestAutoUpdateRemoveDto()
        .firstWord(client.getFirstWord())
        .secondWord(client.getSecondWord());
  }
}
