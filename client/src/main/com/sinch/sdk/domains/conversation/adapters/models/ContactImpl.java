package com.sinch.sdk.domains.conversation.adapters.models;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.ChannelType;
import com.sinch.sdk.domains.conversation.models.Contact;
import com.sinch.sdk.domains.conversation.models.LanguageType;
import java.util.Collection;

public class ContactImpl extends BaseContactImpl implements Contact {

  private final OptionalValue<String> id;

  private ContactImpl(
      OptionalValue<String> id,
      OptionalValue<Collection<ChannelIdentityImpl>> channelIdentities,
      OptionalValue<Collection<ChannelType>> channelPriority,
      OptionalValue<String> displayName,
      OptionalValue<String> email,
      OptionalValue<String> externalId,
      OptionalValue<String> metadata,
      OptionalValue<LanguageType> language) {
    super(channelIdentities, channelPriority, displayName, email, externalId, metadata, language);
    this.id = id;
  }

  public String getId() {
    return id.orElse(null);
  }

  public OptionalValue<String> id() {
    return id;
  }

  @Override
  public String toString() {
    return "ContactImpl{" + "id='" + id + '\'' + "} " + super.toString();
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder extends BaseContactImpl.Builder<Builder> implements Contact.Builder {

    OptionalValue<String> id = OptionalValue.empty();

    public Builder setId(String id) {
      this.id = OptionalValue.of(id);
      return this;
    }

    @Override
    public ContactImpl build() {
      return new ContactImpl(
          id,
          channelIdentities,
          channelPriority,
          displayName,
          email,
          externalId,
          metadata,
          language);
    }
  }
}
