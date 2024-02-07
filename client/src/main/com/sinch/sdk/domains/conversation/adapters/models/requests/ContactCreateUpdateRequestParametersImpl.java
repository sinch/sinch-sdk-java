package com.sinch.sdk.domains.conversation.adapters.models.requests;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.adapters.models.BaseContactImpl;
import com.sinch.sdk.domains.conversation.adapters.models.ChannelIdentityImpl;
import com.sinch.sdk.domains.conversation.models.ChannelType;
import com.sinch.sdk.domains.conversation.models.LanguageType;
import java.util.Collection;

public class ContactCreateUpdateRequestParametersImpl extends BaseContactImpl {

  protected ContactCreateUpdateRequestParametersImpl(
      OptionalValue<Collection<ChannelIdentityImpl>> channelIdentities,
      OptionalValue<Collection<ChannelType>> channelPriority,
      OptionalValue<String> displayName,
      OptionalValue<String> email,
      OptionalValue<String> externalId,
      OptionalValue<String> metadata,
      OptionalValue<LanguageType> language) {
    super(channelIdentities, channelPriority, displayName, email, externalId, metadata, language);
  }
}
