package com.sinch.sdk.domains.sms.models.requests;

import com.sinch.sdk.domains.sms.models.BaseBatch;
import com.sinch.sdk.domains.sms.models.DeliveryReportType;
import com.sinch.sdk.domains.sms.models.MediaBody;
import com.sinch.sdk.domains.sms.models.Parameters;
import java.time.Instant;
import java.util.Collection;
import java.util.Optional;

public class SendSmsBatchMediaRequest extends BaseBatch<MediaBody> {
  private final Parameters parameters;
  private final Boolean strictValidation;

  /**
   * @param to List of Phone numbers and group IDs that will receive the batch
   * @param from Sender number. Must be valid phone number, short code or alphanumeric. Required if
   *     Automatic Default Originator not configured.
   * @param body The message content
   * @param deliveryReport Request delivery report callback. Note that delivery reports can be
   *     fetched from the API regardless of this setting
   * @param sendAt If set in the future, the message will be delayed until send_at occurs. Must be
   *     before expire_at. If set in the past, messages will be sent immediately
   * @param expireAt If set, the system will stop trying to deliver the message at this point. Must
   *     be after send_at. Default and max is 3 days after send_at
   * @param callbackUrl Override the default callback URL for this batch. Must be valid URL.
   * @param clientReference The client identifier of a batch message. If set, the identifier will be
   *     added in the delivery report/callback of this batch
   * @param feedbackEnabled If set to true, then feedback is expected after successful delivery.
   * @param parameters Contains the parameters that will be used for customizing the message for
   *     each recipient.
   * @param strictValidation Whether or not you want the media included in your message to be
   *     checked against Sinch MMS channel best practices. If set to true, your message will be
   *     rejected if it doesn't conform to the listed recommendations, otherwise no validation will
   *     be performed.
   */
  public SendSmsBatchMediaRequest(
      Collection<String> to,
      String from,
      MediaBody body,
      DeliveryReportType deliveryReport,
      Instant sendAt,
      Instant expireAt,
      String callbackUrl,
      String clientReference,
      Boolean feedbackEnabled,
      Parameters parameters,
      Boolean strictValidation) {
    super(
        to,
        from,
        body,
        deliveryReport,
        sendAt,
        expireAt,
        callbackUrl,
        clientReference,
        feedbackEnabled);
    this.parameters = parameters;
    this.strictValidation = strictValidation;
  }

  public Optional<Parameters> getParameters() {
    return Optional.ofNullable(parameters);
  }

  public Optional<Boolean> isStrictValidation() {
    return Optional.ofNullable(strictValidation);
  }

  @Override
  public String toString() {
    return "SendSmsBatchMediaRequest{"
        + "parameters="
        + parameters
        + ", strictValidation="
        + strictValidation
        + ", base='"
        + "} "
        + super.toString();
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder extends BaseBatch.Builder<MediaBody, Builder> {
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

    public SendSmsBatchMediaRequest build() {
      return new SendSmsBatchMediaRequest(
          to,
          from,
          body,
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
