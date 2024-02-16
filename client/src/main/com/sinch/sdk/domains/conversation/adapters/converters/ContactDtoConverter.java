package com.sinch.sdk.domains.conversation.adapters.converters;

import com.sinch.sdk.core.models.pagination.TokenPageNavigator;
import com.sinch.sdk.core.utils.Pair;
import com.sinch.sdk.domains.common.adapters.converters.EnumDynamicConverter;
import com.sinch.sdk.domains.conversation.adapters.models.BaseChannelIdentityImpl;
import com.sinch.sdk.domains.conversation.adapters.models.BaseContactImpl;
import com.sinch.sdk.domains.conversation.adapters.models.ChannelIdentityImpl;
import com.sinch.sdk.domains.conversation.adapters.models.ContactImpl;
import com.sinch.sdk.domains.conversation.adapters.models.requests.BaseGetChannelProfileRequestParametersImpl;
import com.sinch.sdk.domains.conversation.adapters.models.requests.GetChannelProfileByChannelRequestParametersImpl;
import com.sinch.sdk.domains.conversation.adapters.models.requests.GetChannelProfileByContactRequestParametersImpl;
import com.sinch.sdk.domains.conversation.models.ChannelIdentityRecipient;
import com.sinch.sdk.domains.conversation.models.ChannelType;
import com.sinch.sdk.domains.conversation.models.Contact;
import com.sinch.sdk.domains.conversation.models.LanguageType;
import com.sinch.sdk.domains.conversation.models.dto.v1.ChannelIdentitiesDto;
import com.sinch.sdk.domains.conversation.models.dto.v1.ChannelIdentityDto;
import com.sinch.sdk.domains.conversation.models.dto.v1.ChannelRecipientIdentityDto;
import com.sinch.sdk.domains.conversation.models.dto.v1.ContactCreateRequestDto;
import com.sinch.sdk.domains.conversation.models.dto.v1.ContactDto;
import com.sinch.sdk.domains.conversation.models.dto.v1.ContactIdDto;
import com.sinch.sdk.domains.conversation.models.dto.v1.ConversationChannelDto;
import com.sinch.sdk.domains.conversation.models.dto.v1.GetChannelProfileConversationChannelDto;
import com.sinch.sdk.domains.conversation.models.dto.v1.GetChannelProfileRequestDto;
import com.sinch.sdk.domains.conversation.models.dto.v1.GetChannelProfileRequestRecipientDto;
import com.sinch.sdk.domains.conversation.models.dto.v1.GetChannelProfileResponseDto;
import com.sinch.sdk.domains.conversation.models.dto.v1.IdentifiedByDto;
import com.sinch.sdk.domains.conversation.models.dto.v1.ListContactsResponseDto;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ContactDtoConverter {

  public static Pair<Collection<Contact>, TokenPageNavigator> convert(ListContactsResponseDto dto) {
    if (null == dto) {
      return null;
    }

    String nextPageToken = dto.getNextPageToken();
    List<ContactDto> list = dto.getContacts();
    Collection<Contact> pageContent = Collections.emptyList();
    if (null != list) {
      pageContent = list.stream().map(ContactDtoConverter::convert).collect(Collectors.toList());
    }
    return new Pair<>(pageContent, TokenPageNavigator.valueOf(nextPageToken));
  }

  public static ContactImpl convert(ContactDto dto) {
    if (null == dto) {
      return null;
    }
    return ContactImpl.builder()
        .setId(dto.getId())
        .setChannelIdentities(convertListChannelIdentityDto(dto.getChannelIdentities()))
        .setChannelPriority(convertConversationChannelDto(dto.getChannelPriority()))
        .setDisplayName(dto.getDisplayName())
        .setEmail(dto.getEmail())
        .setExternalId(dto.getExternalId())
        .setMetadata(dto.getMetadata())
        .setLanguage(LanguageType.from(dto.getLanguage()))
        .build();
  }

  public static ContactCreateRequestDto convertForCreate(BaseContactImpl client) {
    if (null == client) {
      return null;
    }
    ContactCreateRequestDto dto = new ContactCreateRequestDto();

    client
        .channelIdentities()
        .ifPresent(f -> dto.setChannelIdentities(convertListChannelIdentity(f)));
    client.channelPriority().ifPresent(f -> dto.channelPriority(convertChannelType(f)));
    client.displayName().ifPresent(dto::displayName);
    client.email().ifPresent(dto::email);
    client.externalId().ifPresent(dto::externalId);
    client.metadata().ifPresent(dto::metadata);
    client.language().ifPresent(f -> dto.language(EnumDynamicConverter.convert(f)));
    return dto;
  }

  public static ContactDto convert(BaseContactImpl client) {
    if (null == client) {
      return null;
    }
    ContactDto dto = new ContactDto();

    client
        .channelIdentities()
        .ifPresent(f -> dto.setChannelIdentities(convertListChannelIdentity(f)));
    client.channelPriority().ifPresent(f -> dto.channelPriority(convertChannelType(f)));
    client.displayName().ifPresent(dto::displayName);
    client.email().ifPresent(dto::email);
    client.externalId().ifPresent(dto::externalId);
    client.metadata().ifPresent(dto::metadata);
    client.language().ifPresent(f -> dto.language(EnumDynamicConverter.convert(f)));
    return dto;
  }

  public static GetChannelProfileRequestDto convert(
      GetChannelProfileByContactRequestParametersImpl client) {
    if (null == client) {
      return null;
    }

    return convert(client, new GetChannelProfileRequestDto())
        .recipient(
            new GetChannelProfileRequestRecipientDto(
                new ContactIdDto().contactId(client.getContactId())));
  }

  public static GetChannelProfileRequestDto convert(
      GetChannelProfileByChannelRequestParametersImpl client) {
    if (null == client) {
      return null;
    }

    return convert(client, new GetChannelProfileRequestDto())
        .recipient(
            new GetChannelProfileRequestRecipientDto(
                new IdentifiedByDto()
                    .identifiedBy(
                        new ChannelIdentitiesDto()
                            .channelIdentities(convert(client.getChannelIdentities())))));
  }

  public static GetChannelProfileRequestDto convert(
      BaseGetChannelProfileRequestParametersImpl client, GetChannelProfileRequestDto dto) {
    if (null == client) {
      return dto;
    }

    if (null != client.getChannel()) {
      dto.channel(GetChannelProfileConversationChannelDto.fromValue(client.getChannel().value()));
    }
    return dto.appId(client.getAppId());
  }

  public static String convert(GetChannelProfileResponseDto dto) {
    if (null == dto) {
      return null;
    }
    return dto.getProfileName();
  }

  private static List<ChannelRecipientIdentityDto> convert(
      Collection<ChannelIdentityRecipient> client) {
    if (null == client) {
      return null;
    }
    return client.stream().map(ContactDtoConverter::convert).collect(Collectors.toList());
  }

  private static ChannelRecipientIdentityDto convert(ChannelIdentityRecipient client) {
    if (null == client) {
      return null;
    }
    return new ChannelRecipientIdentityDto()
        .channel(ConversationChannelDto.fromValue(client.getChannel().value()))
        .identity(client.getIdentity());
  }

  private static Collection<ChannelIdentityImpl> convertListChannelIdentityDto(
      List<ChannelIdentityDto> dto) {
    if (null == dto) {
      return null;
    }
    return dto.stream().map(ContactDtoConverter::convert).collect(Collectors.toList());
  }

  private static List<ChannelIdentityDto> convertListChannelIdentity(
      Collection<ChannelIdentityImpl> client) {
    if (null == client) {
      return null;
    }
    return client.stream().map(ContactDtoConverter::convert).collect(Collectors.toList());
  }

  private static ChannelIdentityImpl convert(ChannelIdentityDto dto) {
    if (null == dto) {
      return null;
    }
    return ChannelIdentityImpl.builder()
        .setChannel(convert(dto.getChannel()))
        .setIdentity(dto.getIdentity())
        .setAppId(dto.getAppId())
        .build();
  }

  private static ChannelIdentityDto convertBaseChannelIdentity(BaseChannelIdentityImpl client) {
    if (null == client) {
      return null;
    }
    ChannelIdentityDto dto = new ChannelIdentityDto();
    client.channel().ifPresent(f -> dto.channel(ConversationChannelDto.fromValue(f.value())));
    client.identity().ifPresent(dto::identity);
    return dto;
  }

  private static ChannelIdentityDto convert(ChannelIdentityImpl client) {
    if (null == client) {
      return null;
    }

    ChannelIdentityDto dto = convertBaseChannelIdentity(client);
    client.appId().ifPresent(dto::appId);
    return dto;
  }

  private static Collection<ChannelType> convertConversationChannelDto(
      Collection<ConversationChannelDto> dto) {
    if (null == dto) {
      return null;
    }
    return dto.stream().map(ContactDtoConverter::convert).collect(Collectors.toList());
  }

  private static List<ConversationChannelDto> convertChannelType(Collection<ChannelType> client) {
    if (null == client) {
      return null;
    }
    return client.stream()
        .map(f -> ConversationChannelDto.fromValue(f.value()))
        .collect(Collectors.toList());
  }

  private static ChannelType convert(ConversationChannelDto dto) {
    if (null == dto) {
      return null;
    }
    return ChannelType.from(dto.getValue());
  }
}
