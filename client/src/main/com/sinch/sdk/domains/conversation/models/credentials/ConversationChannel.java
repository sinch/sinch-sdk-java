package com.sinch.sdk.domains.conversation.models.credentials;

import com.sinch.sdk.domains.conversation.models.ChannelType;

public class ConversationChannel {

  private final ChannelType channel;
  private final Credentials credentials;
  private final String callbackSecret;
  private final CredentialState state;
  private final String channelKnownId;

  protected ConversationChannel(
      ChannelType channel,
      Credentials credentials,
      String callbackSecret,
      CredentialState state,
      String channelKnownId) {
    this.callbackSecret = callbackSecret;
    this.channel = channel;
    this.credentials = credentials;
    this.state = state;
    this.channelKnownId = channelKnownId;
  }

  public ChannelType getChannel() {
    return channel;
  }

  public Credentials getCredentials() {
    return credentials;
  }

  public CredentialState getState() {
    return state;
  }

  public String getCallbackSecret() {
    return callbackSecret;
  }

  public String getChannelKnownId() {
    return channelKnownId;
  }

  @Override
  public String toString() {
    return "ConversationChannel{"
        + "channel="
        + channel
        + ", credentials="
        + credentials
        + ", callbackSecret='***'"
        + ", state="
        + state
        + ", channelKnownId='"
        + channelKnownId
        + '\''
        + '}';
  }

  public abstract static class Builder<T extends Builder<?>> {

    String callbackSecret;
    Credentials credentials;
    CredentialState state;
    String channelKnownId;

    public T setCallbackSecret(String callbackSecret) {
      this.callbackSecret = callbackSecret;
      return self();
    }

    protected T setCredentials(Credentials credentials) {
      this.credentials = credentials;
      return self();
    }

    public T setState(CredentialState state) {
      this.state = state;
      return self();
    }

    public Builder<T> setChannelKnownId(String channelKnownId) {
      this.channelKnownId = channelKnownId;
      return this;
    }

    public abstract ConversationChannel build();

    @SuppressWarnings("unchecked")
    protected T self() {
      return (T) this;
    }
  }
}
