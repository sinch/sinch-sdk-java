package com.sinch.sdk.domains.sms.models;

/**
 * Details related to a dryRun recipient
 *
 * @since 1.0
 */
public class DryRunPerRecipientDetails {

  private final String recipient;
  private final String messagePart;
  private final String body;
  private final String encoding;

  public DryRunPerRecipientDetails(
      String recipient, String messagePart, String body, String encoding) {
    this.recipient = recipient;
    this.messagePart = messagePart;
    this.body = body;
    this.encoding = encoding;
  }

  public String getRecipient() {
    return recipient;
  }

  public String getMessagePart() {
    return messagePart;
  }

  public String getBody() {
    return body;
  }

  public String getEncoding() {
    return encoding;
  }

  @Override
  public String toString() {
    return "DryRunPerRecipientDetails{"
        + "recipient='"
        + recipient
        + '\''
        + ", messagePart='"
        + messagePart
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
    private String messagePart;
    private String body;
    private String encoding;

    public Builder setRecipient(String recipient) {
      this.recipient = recipient;
      return this;
    }

    public Builder setMessagePart(String messagePart) {
      this.messagePart = messagePart;
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
      return new DryRunPerRecipientDetails(recipient, messagePart, body, encoding);
    }
  }
}
