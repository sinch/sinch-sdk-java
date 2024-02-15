package com.sinch.sdk.domains.conversation.models.credentials;

import com.sinch.sdk.domains.conversation.models.ChannelType;

/** Conversation Channel Credential definition */
public class ConversationChannel<T extends Credentials> {

  private final ChannelType channel;
  private final T credentials;
  private final String callbackSecret;
  private final CredentialState state;
  private final String channelKnownId;

  protected ConversationChannel(
      ChannelType channel,
      T credentials,
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

  /**
   * Credentials related to channel
   *
   * @return credentials value
   * @since 1.0
   */
  public T getCredentials() {
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

  /**
   * Dedicated Builder
   *
   * @since 1.0
   */
  public abstract static class Builder<T extends Credentials, B extends Builder<?, ?>> {

    String callbackSecret;
    T credentials;
    CredentialState state;
    String channelKnownId;

    public B setCallbackSecret(String callbackSecret) {
      this.callbackSecret = callbackSecret;
      return self();
    }

    /**
     * see getter
     *
     * @param credentials see getter
     * @return Current builder
     * @see #getCredentials()
     * @since 1.0
     */
    public B setCredentials(T credentials) {
      this.credentials = credentials;
      return self();
    }

    public B setState(CredentialState state) {
      this.state = state;
      return self();
    }

    public B setChannelKnownId(String channelKnownId) {
      this.channelKnownId = channelKnownId;
      return self();
    }

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     * @since 1.0
     */
    public abstract ConversationChannel<T> build();

    @SuppressWarnings("unchecked")
    protected B self() {
      return (B) this;
    }
  }
}
