package com.sinch.sdk.domains.sms.models.requests;

import com.sinch.sdk.domains.sms.models.DeliveryReport;
import com.sinch.sdk.domains.sms.models.MediaBody;
import com.sinch.sdk.domains.sms.models.Parameters;
import java.time.Instant;
import java.util.Collection;
import java.util.Optional;

public class UpdateSmsBatchMediaRequest extends UpdateBaseBatchRequest<MediaBody> {
  private final Parameters parameters;
  private final Boolean strictValidation;
  /**
   * @param toAdd List of phone numbers and group IDs to add to the batch.
   * @param toRemove List of phone numbers and group IDs to remove from the batch.
   * @param body The message content
   * @param deliveryReport Request delivery report callback. Note that delivery reports can be
   *     fetched from the API regardless of this setting
   * @param sendAt If set in the future, the message will be delayed until send_at occurs. Must be
   *     before expire_at. If set in the past, messages will be sent immediately
   * @param expireAt If set, the system will stop trying to deliver the message at this point. Must
   *     be after send_at. Default and max is 3 days after send_at
   * @param callbackUrl Override the default callback URL for this batch. Must be valid URL.
   * @param parameters Contains the parameters that will be used for customizing the message for
   *     each recipient.
   * @param strictValidation Whether or not you want the media included in your message to be
   *     checked against Sinch MMS channel best practices. If set to true, your message will be
   *     rejected if it doesn't conform to the listed recommendations, otherwise no validation will
   *     be performed
   */
  public UpdateSmsBatchMediaRequest(
      Collection<String> toAdd,
      Collection<String> toRemove,
      String from,
      MediaBody body,
      DeliveryReport deliveryReport,
      Instant sendAt,
      Instant expireAt,
      String callbackUrl,
      Parameters parameters,
      Boolean strictValidation) {
    super(toAdd, toRemove, from, body, deliveryReport, sendAt, expireAt, callbackUrl);
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
    return "UpdateSmsBatchMediaRequest{"
        + "parameters="
        + parameters
        + ", strictValidation="
        + strictValidation
        + "} "
        + super.toString();
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder extends UpdateBaseBatchRequest.Builder<MediaBody, Builder> {
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

    public UpdateSmsBatchMediaRequest build() {
      return new UpdateSmsBatchMediaRequest(
          toAdd,
          toRemove,
          from,
          body,
          deliveryReport,
          sendAt,
          expireAt,
          callbackUrl,
          parameters,
          strictValidation);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }
}
