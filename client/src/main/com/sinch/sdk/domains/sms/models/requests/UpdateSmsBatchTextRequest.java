package com.sinch.sdk.domains.sms.models.requests;

import com.sinch.sdk.domains.sms.models.DeliveryReport;
import com.sinch.sdk.domains.sms.models.Parameters;
import java.time.Instant;
import java.util.Collection;
import java.util.Optional;

public class UpdateSmsBatchTextRequest extends UpdateBaseBatchRequest<String> {
  private final Parameters parameters;
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
   */
  public UpdateSmsBatchTextRequest(
      Collection<String> toAdd,
      Collection<String> toRemove,
      String from,
      String body,
      DeliveryReport deliveryReport,
      Instant sendAt,
      Instant expireAt,
      String callbackUrl,
      Parameters parameters) {
    super(toAdd, toRemove, from, body, deliveryReport, sendAt, expireAt, callbackUrl);
    this.parameters = parameters;
  }

  public Optional<Parameters> getParameters() {
    return Optional.ofNullable(parameters);
  }

  @Override
  public String toString() {
    return "UpdateSmsBatchTextRequest{" + "parameters=" + parameters + "} " + super.toString();
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder extends UpdateBaseBatchRequest.Builder<String, Builder> {
    private Parameters parameters;

    private Builder() {}

    public Builder setParameters(Parameters parameters) {
      this.parameters = parameters;
      return this;
    }

    public UpdateSmsBatchTextRequest build() {
      return new UpdateSmsBatchTextRequest(
          toAdd, toRemove, from, body, deliveryReport, sendAt, expireAt, callbackUrl, parameters);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }
}
