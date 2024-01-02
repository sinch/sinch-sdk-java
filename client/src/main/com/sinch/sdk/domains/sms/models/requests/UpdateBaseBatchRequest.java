package com.sinch.sdk.domains.sms.models.requests;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.sms.models.DeliveryReportType;
import java.time.Instant;
import java.util.Collection;

/**
 * Base class for Batch types
 *
 * @param <T> Type of batch
 * @since 1.0
 */
public class UpdateBaseBatchRequest<T> {

  private final OptionalValue<String> from;

  private final OptionalValue<T> body;

  private final OptionalValue<Collection<String>> toAdd;

  private final OptionalValue<Collection<String>> toRemove;

  private final OptionalValue<DeliveryReportType> deliveryReport;

  private final OptionalValue<Instant> sendAt;

  private final OptionalValue<Instant> expireAt;

  private final OptionalValue<String> callbackUrl;

  protected UpdateBaseBatchRequest(
      OptionalValue<Collection<String>> toAdd,
      OptionalValue<Collection<String>> toRemove,
      OptionalValue<String> from,
      OptionalValue<T> body,
      OptionalValue<DeliveryReportType> deliveryReport,
      OptionalValue<Instant> sendAt,
      OptionalValue<Instant> expireAt,
      OptionalValue<String> callbackUrl) {
    this.toAdd = toAdd;
    this.toRemove = toRemove;
    this.from = from;
    this.body = body;
    this.deliveryReport = deliveryReport;
    this.sendAt = sendAt;
    this.expireAt = expireAt;
    this.callbackUrl = callbackUrl;
  }

  public static <T> BatchBuilder<T> batchBuilder() {
    return new BatchBuilder<>();
  }

  public OptionalValue<Collection<String>> getToAdd() {
    return toAdd;
  }

  public OptionalValue<Collection<String>> getToRemove() {
    return toRemove;
  }

  public OptionalValue<T> getBody() {
    return body;
  }

  public OptionalValue<String> getFrom() {
    return from;
  }

  public OptionalValue<DeliveryReportType> getDeliveryReport() {
    return deliveryReport;
  }

  public OptionalValue<Instant> getSendAt() {
    return sendAt;
  }

  public OptionalValue<Instant> getExpireAt() {
    return expireAt;
  }

  public OptionalValue<String> getCallbackUrl() {
    return callbackUrl;
  }

  @Override
  public String toString() {
    return "UpdateBaseBatchRequest{"
        + "from='"
        + from
        + '\''
        + ", body="
        + body
        + ", toAdd="
        + toAdd
        + ", toRemove="
        + toRemove
        + ", deliveryReportType="
        + deliveryReport
        + ", sendAt="
        + sendAt
        + ", expireAt="
        + expireAt
        + ", callbackUrl='"
        + callbackUrl
        + '\''
        + '}';
  }

  protected static class Builder<T, B extends Builder<T, B>> {

    public OptionalValue<Collection<String>> toAdd = OptionalValue.empty();

    public OptionalValue<Collection<String>> toRemove = OptionalValue.empty();

    public OptionalValue<String> from = OptionalValue.empty();

    public OptionalValue<T> body = OptionalValue.empty();

    public OptionalValue<DeliveryReportType> deliveryReportType = OptionalValue.empty();

    public OptionalValue<Instant> sendAt = OptionalValue.empty();

    public OptionalValue<Instant> expireAt = OptionalValue.empty();

    public OptionalValue<String> callbackUrl = OptionalValue.empty();

    /**
     * @param toAdd List of phone numbers and group IDs to add to the batch.
     * @return current builder
     */
    public B setToAdd(Collection<String> toAdd) {
      this.toAdd = OptionalValue.of(toAdd);
      return self();
    }

    /**
     * @param toRemove List of phone numbers and group IDs to remove from the batch.
     * @return current builder
     */
    public B setToRemove(Collection<String> toRemove) {
      this.toRemove = OptionalValue.of(toRemove);
      return self();
    }

    /**
     * @param from Sender number. Must be valid phone number, short code or alphanumeric. Required
     *     if Automatic Default Originator not configured.
     * @return current builder
     */
    public B setFrom(String from) {
      this.from = OptionalValue.of(from);
      return self();
    }

    /**
     * @param body The message content
     * @return current builder
     */
    public B setBody(T body) {
      this.body = OptionalValue.of(body);
      return self();
    }

    /**
     * @param deliveryReportType Request delivery report callback. Note that delivery reports can be
     *     fetched from the API regardless of this setting
     * @return current builder
     */
    public B setDeliveryReport(DeliveryReportType deliveryReportType) {
      this.deliveryReportType = OptionalValue.of(deliveryReportType);
      return self();
    }

    /**
     * @param sendAt If set in the future, the message will be delayed until send_at occurs. Must be
     *     before expire_at. If set in the past, messages will be sent immediately
     * @return current builder
     */
    public B setSendAt(Instant sendAt) {
      this.sendAt = OptionalValue.of(sendAt);
      return self();
    }

    /**
     * @param expireAt If set, the system will stop trying to deliver the message at this point.
     *     Must be after send_at. Default and max is 3 days after send_at
     * @return current builder
     */
    public B setExpireAt(Instant expireAt) {
      this.expireAt = OptionalValue.of(expireAt);
      return self();
    }

    /**
     * @param callbackUrl Override the default callback URL for this batch. Must be valid URL.
     * @return current builder
     */
    public B setCallbackUrl(String callbackUrl) {
      this.callbackUrl = OptionalValue.of(callbackUrl);
      return self();
    }

    public UpdateBaseBatchRequest<T> build() {
      return new UpdateBaseBatchRequest<>(
          toAdd, toRemove, from, body, deliveryReportType, sendAt, expireAt, callbackUrl);
    }

    @SuppressWarnings("unchecked")
    protected B self() {
      return (B) this;
    }
  }

  public static class BatchBuilder<T> extends UpdateBaseBatchRequest.Builder<T, BatchBuilder<T>> {
    @Override
    protected BatchBuilder<T> self() {
      return this;
    }
  }
}
