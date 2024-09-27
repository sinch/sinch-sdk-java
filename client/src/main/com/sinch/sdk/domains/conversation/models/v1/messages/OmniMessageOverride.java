package com.sinch.sdk.domains.conversation.models.v1.messages;

import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;

/** Base class for all classes supported by OmniMessageOverride */
public interface OmniMessageOverride {

  enum ChannelSpecificTemplate {
    WHATSAPP(ConversationChannel.WHATSAPP),
    KAKAOTALK(ConversationChannel.KAKAOTALK),
    WECHAT(ConversationChannel.WECHAT);

    private final ConversationChannel channel;

    ChannelSpecificTemplate(ConversationChannel channel) {
      this.channel = channel;
    }

    public ConversationChannel getChannel() {
      return channel;
    }
  }
}
