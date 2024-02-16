package com.sinch.sdk.domains.conversation.models;

import java.util.Collection;

public interface BaseContact {

  Collection<? extends ChannelIdentity> getChannelIdentities();

  Collection<ChannelType> getChannelPriority();

  String getDisplayName();

  String getEmail();

  String getExternalId();

  String getMetadata();

  LanguageType getLanguage();

  interface Builder<B extends Builder<B>> {

    B setChannelIdentities(Collection<? extends ChannelIdentity> channelIdentities);

    B setChannelPriority(Collection<ChannelType> channelPriority);

    B setDisplayName(String displayName);

    B setEmail(String email);

    B setExternalId(String externalId);

    B setMetadata(String metadata);

    B setLanguage(LanguageType language);
  }
}
