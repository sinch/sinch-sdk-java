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

  /**
   * The identifier of the channel
   *
   * @return Channel type
   * @since 1.0
   */
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

  /**
   * @return
   * @since 1.0
   */
  public CredentialState getState() {
    return state;
  }

  /**
   * The secret used to verify the channel callbacks for channels which support callback
   * verification.
   *
   * <p>The callback verification is not needed for Sinch-managed channels because the callbacks are
   * not leaving Sinch internal networks.
   *
   * <p>Max length is 256 characters. <b>Note</b>: leaving callback secret empty for channels with
   * callback verification will disable the verification.
   *
   * @return secret value
   * @since 1.0
   */
  public String getCallbackSecret() {
    return callbackSecret;
  }

  /**
   * @return
   * @since 1.0
   */
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

    protected Builder() {}

    /**
     * see getter
     *
     * @param callbackSecret see getter
     * @return Current builder
     * @see #getCallbackSecret()
     * @since 1.0
     */
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

    /**
     * see getter
     *
     * @param state see getter
     * @return Current builder
     * @see #getState()
     * @since 1.0
     */
    public B setState(CredentialState state) {
      this.state = state;
      return self();
    }

    /**
     * see getter
     *
     * @param channelKnownId see getter
     * @return Current builder
     * @see #getChannelKnownId()
     * @since 1.0
     */
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
