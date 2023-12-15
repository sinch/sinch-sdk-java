package com.sinch.sdk.domains.sms.models.requests;

import com.sinch.sdk.domains.sms.models.DeliveryReportType;
import java.time.Instant;
import java.util.Collection;
import java.util.Optional;

public class UpdateSmsBatchBinaryRequest extends UpdateBaseBatchRequest<String> {
  private final String udh;

  /**
   * @param toAdd List of phone numbers and group IDs to add to the batch.List of Phone numbers and
   *     group IDs that will receive the batch
   * @param toRemove List of phone numbers and group IDs to remove from the batch
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
   * @param udh The UDH header of a binary message HEX encoded. Max 140 bytes including the body.
   */
  public UpdateSmsBatchBinaryRequest(
      Collection<String> toAdd,
      Collection<String> toRemove,
      String from,
      String body,
      DeliveryReportType deliveryReport,
      Instant sendAt,
      Instant expireAt,
      String callbackUrl,
      String udh) {
    super(toAdd, toRemove, from, body, deliveryReport, sendAt, expireAt, callbackUrl);
    this.udh = udh;
  }

  public Optional<String> getUdh() {
    return Optional.ofNullable(udh);
  }

  @Override
  public String toString() {
    return "UpdateSmsBatchBinaryRequest{" + "udh='" + udh + '\'' + "} " + super.toString();
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder extends UpdateBaseBatchRequest.Builder<String, Builder> {

    private String udh;

    private Builder() {}

    public Builder setUdh(String udh) {
      this.udh = udh;
      return this;
    }

    public UpdateSmsBatchBinaryRequest build() {
      return new UpdateSmsBatchBinaryRequest(
          toAdd, toRemove, from, body, deliveryReportType, sendAt, expireAt, callbackUrl, udh);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }
}
