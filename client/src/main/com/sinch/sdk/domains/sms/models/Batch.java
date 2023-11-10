package com.sinch.sdk.domains.sms.models;

import java.time.Instant;
import java.util.Collection;

/**
 * Base class for Batch types
 *
 * @param <T> Type of batch
 * @since 1.0
 */
public class Batch<T> {

  private final String id;

  private final Collection<String> to;

  private final String from;

  private final Boolean canceled;

  private final T body;

  private final Instant createdAt;

  private final Instant modifiedAt;

  private final DeliveryReportType deliveryReport;

  private final Instant sendAt;

  private final Instant expireAt;

  private final String callbackUrl;

  private final String clientReference;

  private final Boolean feedbackEnabled;

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
   * @param feedbackEnabled If set to true, then feedback is expected after successful delivery.
   */
  public Batch(
      String id,
      Collection<String> to,
      String from,
      Boolean canceled,
      T body,
      Instant createdAt,
      Instant modifiedAt,
      DeliveryReportType deliveryReport,
      Instant sendAt,
      Instant expireAt,
      String callbackUrl,
      String clientReference,
      Boolean feedbackEnabled) {
    this.id = id;
    this.to = to;
    this.from = from;
    this.canceled = canceled;
    this.body = body;
    this.createdAt = createdAt;
    this.modifiedAt = modifiedAt;
    this.deliveryReport = deliveryReport;
    this.sendAt = sendAt;
    this.expireAt = expireAt;
    this.callbackUrl = callbackUrl;
    this.clientReference = clientReference;
    this.feedbackEnabled = feedbackEnabled;
  }

  public static <T> BatchBuilder<T> batchBuilder() {
    return new BatchBuilder<>();
  }

  public String getId() {
    return id;
  }

  public Collection<String> getTo() {
    return to;
  }

  public String getFrom() {
    return from;
  }

  public Boolean isCanceled() {
    return canceled;
  }

  public T getBody() {
    return body;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public Instant getModifiedAt() {
    return modifiedAt;
  }

  public DeliveryReportType getDeliveryReport() {
    return deliveryReport;
  }

  public Instant getSendAt() {
    return sendAt;
  }

  public Instant getExpireAt() {
    return expireAt;
  }

  public String getCallbackUrl() {
    return callbackUrl;
  }

  public String getClientReference() {
    return clientReference;
  }

  public Boolean isFeedbackEnabled() {
    return feedbackEnabled;
  }

  @Override
  public String toString() {
    return "Batch{"
        + "id='"
        + id
        + '\''
        + ", to="
        + to
        + ", from='"
        + from
        + '\''
        + ", canceled="
        + canceled
        + ", body="
        + body
        + ", createdAt="
        + createdAt
        + ", modifiedAt="
        + modifiedAt
        + ", deliveryReportType="
        + deliveryReport
        + ", sendAt="
        + sendAt
        + ", expireAt="
        + expireAt
        + ", callbackUrl='"
        + callbackUrl
        + '\''
        + ", clientReference='"
        + clientReference
        + '\''
        + ", feedbackEnabled="
        + feedbackEnabled
        + '}';
  }

  protected static class Builder<T, B extends Builder<T, B>> {

    String id;

    Collection<String> to;

    String from;

    Boolean canceled;

    T body;

    Instant createdAt;

    Instant modifiedAt;

    DeliveryReportType deliveryReport;

    Instant sendAt;

    Instant expireAt;

    String callbackUrl;

    String clientReference;

    Boolean feedbackEnabled;

    public B setId(String id) {
      this.id = id;
      return self();
    }

    public B setTo(Collection<String> to) {
      this.to = to;
      return self();
    }

    public B setFrom(String from) {
      this.from = from;
      return self();
    }

    public B setCanceled(Boolean canceled) {
      this.canceled = canceled;
      return self();
    }

    public B setBody(T body) {
      this.body = body;
      return self();
    }

    public B setCreatedAt(Instant createdAt) {
      this.createdAt = createdAt;
      return self();
    }

    public B setModifiedAt(Instant modifiedAt) {
      this.modifiedAt = modifiedAt;
      return self();
    }

    public B setDeliveryReport(DeliveryReportType deliveryReport) {
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

    public B setClientReference(String clientReference) {
      this.clientReference = clientReference;
      return self();
    }

    public B setFeedbackEnabled(Boolean feedbackEnabled) {
      this.feedbackEnabled = feedbackEnabled;
      return self();
    }

    public Batch<T> build() {
      return new Batch<>(
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
    }

    @SuppressWarnings("unchecked")
    protected B self() {
      return (B) this;
    }
  }

  public static class BatchBuilder<T> extends Batch.Builder<T, BatchBuilder<T>> {
    @Override
    protected BatchBuilder<T> self() {
      return this;
    }
  }
}
