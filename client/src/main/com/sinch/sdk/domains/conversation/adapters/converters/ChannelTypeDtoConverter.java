package com.sinch.sdk.domains.conversation.adapters.converters;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.ChannelType;
import com.sinch.sdk.domains.conversation.models.dto.v1.ConversationChannelDto;

public class ChannelTypeDtoConverter {

  public static ConversationChannelDto convert(OptionalValue<ChannelType> client) {
    ConversationChannelDto dto = null;

    if (client.isPresent() && null != client.get()) {
      dto = ConversationChannelDto.valueOf(client.get().value());
    }
    return dto;
  }
}
