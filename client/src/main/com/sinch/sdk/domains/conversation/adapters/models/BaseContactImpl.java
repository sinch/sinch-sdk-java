package com.sinch.sdk.domains.conversation.adapters.models;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.BaseContact;
import com.sinch.sdk.domains.conversation.models.ChannelIdentity;
import com.sinch.sdk.domains.conversation.models.ChannelType;
import com.sinch.sdk.domains.conversation.models.LanguageType;
import java.util.Collection;

public class BaseContactImpl implements BaseContact {

  private final OptionalValue<Collection<ChannelIdentityImpl>> channelIdentities;
  private final OptionalValue<Collection<ChannelType>> channelPriority;
  private final OptionalValue<String> displayName;
  private final OptionalValue<String> email;
  private final OptionalValue<String> externalId;
  private final OptionalValue<String> metadata;
  private final OptionalValue<LanguageType> language;

  protected BaseContactImpl(
      OptionalValue<Collection<ChannelIdentityImpl>> channelIdentities,
      OptionalValue<Collection<ChannelType>> channelPriority,
      OptionalValue<String> displayName,
      OptionalValue<String> email,
      OptionalValue<String> externalId,
      OptionalValue<String> metadata,
      OptionalValue<LanguageType> language) {
    this.channelIdentities = channelIdentities;
    this.channelPriority = channelPriority;
    this.displayName = displayName;
    this.email = email;
    this.externalId = externalId;
    this.metadata = metadata;
    this.language = language;
  }

  @Override
  public Collection<ChannelIdentityImpl> getChannelIdentities() {
    return channelIdentities.orElse(null);
  }

  public OptionalValue<Collection<ChannelIdentityImpl>> channelIdentities() {
    return channelIdentities;
  }

  @Override
  public Collection<ChannelType> getChannelPriority() {
    return channelPriority.orElse(null);
  }

  public OptionalValue<Collection<ChannelType>> channelPriority() {
    return channelPriority;
  }

  @Override
  public String getDisplayName() {
    return displayName.orElse(null);
  }

  public OptionalValue<String> displayName() {
    return displayName;
  }

  @Override
  public String getEmail() {
    return email.orElse(null);
  }

  public OptionalValue<String> email() {
    return email;
  }

  @Override
  public String getExternalId() {
    return externalId.orElse(null);
  }

  public OptionalValue<String> externalId() {
    return externalId;
  }

  @Override
  public String getMetadata() {
    return metadata.orElse(null);
  }

  public OptionalValue<String> metadata() {
    return metadata;
  }

  @Override
  public LanguageType getLanguage() {
    return language.orElse(null);
  }

  public OptionalValue<LanguageType> language() {
    return language;
  }

  @Override
  public String toString() {
    return "ContactImpl{"
        + "channelIdentities="
        + channelIdentities
        + ", channelPriority="
        + channelPriority
        + ", displayName='"
        + displayName
        + '\''
        + ", email='"
        + email
        + '\''
        + ", externalId='"
        + externalId
        + '\''
        + ", metadata='"
        + metadata
        + '\''
        + ", language="
        + language
        + '}';
  }

  public abstract static class Builder<B extends Builder<B>> {

    protected OptionalValue<Collection<ChannelIdentityImpl>> channelIdentities =
        OptionalValue.empty();
    protected OptionalValue<Collection<ChannelType>> channelPriority = OptionalValue.empty();
    protected OptionalValue<String> displayName = OptionalValue.empty();
    protected OptionalValue<String> email = OptionalValue.empty();
    protected OptionalValue<String> externalId = OptionalValue.empty();
    protected OptionalValue<String> metadata = OptionalValue.empty();
    protected OptionalValue<LanguageType> language = OptionalValue.empty();

    public B setChannelIdentities(Collection<? extends ChannelIdentity> channelIdentities) {
      @SuppressWarnings("unchecked")
      Collection<ChannelIdentityImpl> casted = (Collection<ChannelIdentityImpl>) channelIdentities;
      this.channelIdentities = OptionalValue.of(casted);
      return self();
    }

    public B setChannelPriority(Collection<ChannelType> channelPriority) {
      this.channelPriority = OptionalValue.of(channelPriority);
      return self();
    }

    public B setDisplayName(String displayName) {
      this.displayName = OptionalValue.of(displayName);
      return self();
    }

    public B setEmail(String email) {
      this.email = OptionalValue.of(email);
      return self();
    }

    public B setExternalId(String externalId) {
      this.externalId = OptionalValue.of(externalId);
      return self();
    }

    public B setMetadata(String metadata) {
      this.metadata = OptionalValue.of(metadata);
      return self();
    }

    public B setLanguage(LanguageType language) {
      this.language = OptionalValue.of(language);
      return self();
    }

    @SuppressWarnings("unchecked")
    protected B self() {
      return (B) this;
    }
  }
}
