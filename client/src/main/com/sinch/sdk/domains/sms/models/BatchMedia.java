package com.sinch.sdk.domains.sms.models;

import java.time.Instant;
import java.util.Collection;

/**
 * BatchMedia type
 *
 * @since 1.0
 */
public class BatchMedia extends Batch<MediaBody> {
  private final Parameters parameters;
  private final Boolean strictValidation;

  /**
   * @param id Unique identifier for batch
   * @param to List of Phone numbers and group IDs that will receive the batch
   * @param from Sender number. Must be valid phone number, short code or alphanumeric. Required if
   *     Automatic Default Originator not configured.
   * @param canceled Indicates if the batch has been canceled or not.
   * @param body The message content
   * @param createdAt when batch was created
   * @param modifiedAt when batch was last updated
   * @param deliveryReport Request delivery report callback. Note that delivery reports can be
   *     fetched from the API regardless of this setting
   * @param sendAt If set in the future, the message will be delayed until send_at occurs. Must be
   *     before expire_at. If set in the past, messages will be sent immediately
   * @param expireAt If set, the system will stop trying to deliver the message at this point. Must
   *     be after send_at. Default and max is 3 days after send_at
   * @param callbackUrl Override the default callback URL for this batch. Must be valid URL.
   * @param clientReference The client identifier of a batch message. If set, the identifier will be
   *     added in the delivery report/callback of this batch
   * @param feedbackEnabled If set to true, then feedback is expected after successful delivery. *
   * @param parameters Contains the parameters that will be used for customizing the message for
   *     each recipient.
   * @param strictValidation Whether or not you want the media included in your message to be
   *     checked against Sinch MMS channel best practices. If set to true, your message will be
   *     rejected if it doesn't conform to the listed recommendations, otherwise no validation will
   *     be performed.
   */
  public BatchMedia(
      String id,
      Collection<String> to,
      String from,
      Boolean canceled,
      MediaBody body,
      Instant createdAt,
      Instant modifiedAt,
      DeliveryReport deliveryReport,
      Instant sendAt,
      Instant expireAt,
      String callbackUrl,
      String clientReference,
      Boolean feedbackEnabled,
      Parameters parameters,
      Boolean strictValidation) {
    super(
        id,
        to,
        from,
        canceled,
        body,
        createdAt,
        modifiedAt,
        deliveryReport,
        sendAt,
        expireAt,
        callbackUrl,
        clientReference,
        feedbackEnabled);
    this.parameters = parameters;
    this.strictValidation = strictValidation;
  }

  public Parameters getParameters() {
    return parameters;
  }

  public Boolean isStrictValidation() {
    return strictValidation;
  }

  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "BatchMedia{"
        + "parameters="
        + parameters
        + ", strictValidation="
        + strictValidation
        + "} "
        + super.toString();
  }

  public static class Builder extends Batch.Builder<MediaBody, Builder> {
    private Parameters parameters;
    private Boolean strictValidation;

    private Builder() {}

    public Builder setParameters(Parameters parameters) {
      this.parameters = parameters;
      return this;
    }

    public Builder setStrictValidation(Boolean strictValidation) {
      this.strictValidation = strictValidation;
      return this;
    }

    public BatchMedia build() {
      return new BatchMedia(
          id,
          to,
          from,
          canceled,
          body,
          createdAt,
          modifiedAt,
          deliveryReport,
          sendAt,
          expireAt,
          callbackUrl,
          clientReference,
          feedbackEnabled,
          parameters,
          strictValidation);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }
}
