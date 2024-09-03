package com.sinch.sdk.domains.sms.models;

/**
 * Details related to a dryRun recipient
 *
 * @since 1.0
 */
public class DryRunPerRecipientDetails {

  private final String recipient;
  private final Integer numberOfParts;
  private final String body;
  private final String encoding;

  /**
   * Due to unused <code>messagePart</code> field, prefer the <code>numberOfParts</code> version
   * usage.
   *
   * <p>This constructor will be removed in a next major release
   *
   * @deprecated
   */
  @Deprecated
  public DryRunPerRecipientDetails(
      String recipient, String messagePart, String body, String encoding) {
    this.recipient = recipient;
    this.numberOfParts = null;
    this.body = body;
    this.encoding = encoding;
  }

  public DryRunPerRecipientDetails(
      String recipient, Integer numberOfParts, String body, String encoding) {
    this.recipient = recipient;
    this.numberOfParts = numberOfParts;
    this.body = body;
    this.encoding = encoding;
  }

  /**
   * Get recipient
   *
   * @return recipient
   */
  public String getRecipient() {
    return recipient;
  }

  /**
   * Due to unused <code>messagePart</code> field, prefer the {@link #getNumberOfParts()} usage.
   *
   * <p>This function will be removed in a next major release
   *
   * @deprecated
   */
  @Deprecated
  public String getMessagePart() {
    return null;
  }

  /**
   * Get number of parts
   *
   * @return number of parts
   */
  public Integer getNumberOfParts() {
    return numberOfParts;
  }

  /**
   * Get body
   *
   * @return body
   */
  public String getBody() {
    return body;
  }

  /**
   * Get encoding
   *
   * @return encoding
   */
  public String getEncoding() {
    return encoding;
  }

  @Override
  public String toString() {
    return "DryRunPerRecipientDetails{"
        + "recipient='"
        + recipient
        + '\''
        + ", numberOfParts='"
        + numberOfParts
        + '\''
        + ", body='"
        + body
        + '\''
        + ", encoding='"
        + encoding
        + '\''
        + '}';
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {

    private String recipient;
    private Integer numberOfParts;
    private String body;
    private String encoding;

    public Builder setRecipient(String recipient) {
      this.recipient = recipient;
      return this;
    }

    /**
     * Due to unused <code>messagePart</code> field, prefer the {@link #setNumberOfParts(Integer)}
     * usage.
     *
     * <p>This function will be removed in a next major release
     *
     * @deprecated
     */
    @Deprecated
    public Builder setMessagePart(String messageParts) {
      // Do nothing
      return this;
    }

    public Builder setNumberOfParts(Integer numberOfParts) {
      this.numberOfParts = numberOfParts;
      return this;
    }

    public Builder setBody(String body) {
      this.body = body;
      return this;
    }

    public Builder setEncoding(String encoding) {
      this.encoding = encoding;
      return this;
    }

    private Builder() {}

    public DryRunPerRecipientDetails build() {
      return new DryRunPerRecipientDetails(recipient, numberOfParts, body, encoding);
    }
  }
}
