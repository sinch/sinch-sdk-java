package com.sinch.sdk.domains.sms.models.requests;

import com.sinch.sdk.domains.sms.models.DeliveryReport;
import java.time.Instant;
import java.util.Collection;
import java.util.Optional;

/**
 * Base class for Batch types
 *
 * @param <T> Type of batch
 * @since 1.0
 */
public class UpdateBaseBatchRequest<T> {

  private final String from;

  private final T body;

  private final Collection<String> toAdd;

  private final Collection<String> toRemove;

  private final DeliveryReport deliveryReport;

  private final Instant sendAt;

  private final Instant expireAt;

  private final String callbackUrl;

  /**
   * @param toAdd List of phone numbers and group IDs to add to the batch.
   * @param toRemove List of phone numbers and group IDs to remove from the batch.
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
   */
  public UpdateBaseBatchRequest(
      Collection<String> toAdd,
      Collection<String> toRemove,
      String from,
      T body,
      DeliveryReport deliveryReport,
      Instant sendAt,
      Instant expireAt,
      String callbackUrl) {
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

  public Optional<Collection<String>> getToAdd() {
    return Optional.ofNullable(toAdd);
  }

  public Optional<Collection<String>> getToRemove() {
    return Optional.ofNullable(toRemove);
  }

  public Optional<T> getBody() {
    return Optional.ofNullable(body);
  }

  public Optional<String> getFrom() {
    return Optional.ofNullable(from);
  }

  public Optional<DeliveryReport> getDeliveryReport() {
    return Optional.ofNullable(deliveryReport);
  }

  public Optional<Instant> getSendAt() {
    return Optional.ofNullable(sendAt);
  }

  public Optional<Instant> getExpireAt() {
    return Optional.ofNullable(expireAt);
  }

  public Optional<String> getCallbackUrl() {
    return Optional.ofNullable(callbackUrl);
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
        + ", deliveryReport="
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

    public Collection<String> toAdd;

    public Collection<String> toRemove;

    public String from;

    public T body;

    public DeliveryReport deliveryReport;

    public Instant sendAt;

    public Instant expireAt;

    public String callbackUrl;

    public B setToAdd(Collection<String> toAdd) {
      this.toAdd = toAdd;
      return self();
    }

    public B setToRemove(Collection<String> toRemove) {
      this.toRemove = toRemove;
      return self();
    }

    public B setFrom(String from) {
      this.from = from;
      return self();
    }

    public B setBody(T body) {
      this.body = body;
      return self();
    }

    public B setDeliveryReport(DeliveryReport deliveryReport) {
      this.deliveryReport = deliveryReport;
      return self();
    }

    public B setSendAt(Instant sendAt) {
      this.sendAt = sendAt;
      return self();
    }

    public B setExpireAt(Instant expireAt) {
      this.expireAt = expireAt;
      return self();
    }

    public B setCallbackUrl(String callbackUrl) {
      this.callbackUrl = callbackUrl;
      return self();
    }

    public UpdateBaseBatchRequest<T> build() {
      return new UpdateBaseBatchRequest<>(
          toAdd, toRemove, from, body, deliveryReport, sendAt, expireAt, callbackUrl);
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
