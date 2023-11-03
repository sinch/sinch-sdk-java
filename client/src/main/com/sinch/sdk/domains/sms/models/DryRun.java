package com.sinch.sdk.domains.sms.models;

import java.util.Collection;

/**
 * Information related to a dryRun request
 *
 * @since 1.0
 */
public class DryRun {

  private final Integer numberOfRecipients;
  private final Integer numberOfMessages;
  private final Collection<DryRunPerRecipientDetails> perRecipient;

  /**
   * @param numberOfRecipients The number of recipients in the batch
   * @param numberOfMessages The total number of SMS message parts to be sent in the batch
   * @param perRecipient The recipient, the number of message parts to this recipient, the body of
   *     the message, and the encoding type of each message
   */
  public DryRun(
      Integer numberOfRecipients,
      Integer numberOfMessages,
      Collection<DryRunPerRecipientDetails> perRecipient) {
    this.numberOfRecipients = numberOfRecipients;
    this.numberOfMessages = numberOfMessages;
    this.perRecipient = perRecipient;
  }

  public Integer getNumberOfRecipients() {
    return numberOfRecipients;
  }

  public Integer getNumberOfMessages() {
    return numberOfMessages;
  }

  public Collection<DryRunPerRecipientDetails> getPerRecipient() {
    return perRecipient;
  }

  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "DryRun{"
        + "numberOfRecipients="
        + numberOfRecipients
        + ", numberOfMessages="
        + numberOfMessages
        + ", perRecipient="
        + perRecipient
        + '}';
  }

  public static class Builder {

    private Integer numberOfRecipients;
    private Integer numberOfMessages;
    private Collection<DryRunPerRecipientDetails> perRecipient;

    public Builder setNumberOfRecipients(Integer numberOfRecipients) {
      this.numberOfRecipients = numberOfRecipients;
      return this;
    }

    public Builder setNumberOfMessages(Integer numberOfMessages) {
      this.numberOfMessages = numberOfMessages;
      return this;
    }

    public Builder setPerRecipient(Collection<DryRunPerRecipientDetails> perRecipient) {
      this.perRecipient = perRecipient;
      return this;
    }

    public DryRun build() {
      return new DryRun(numberOfRecipients, numberOfMessages, perRecipient);
    }
  }
}
