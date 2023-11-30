package com.sinch.sdk.domains.sms.models;

import java.time.Instant;
import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

/**
 * Base class for Batch types
 *
 * @param <T> Type of batch
 * @since 1.0
 */
public class BaseBatch<T> {

  private final T body;

  private final Collection<String> to;

  private final String from;

  private final DeliveryReportType deliveryReport;

  private final Instant sendAt;

  private final Instant expireAt;

  private final String callbackUrl;

  private final String clientReference;

  private final Boolean feedbackEnabled;

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
   */
  public BaseBatch(
      Collection<String> to,
      String from,
      T body,
      DeliveryReportType deliveryReport,
      Instant sendAt,
      Instant expireAt,
      String callbackUrl,
      String clientReference,
      Boolean feedbackEnabled) {
    Objects.requireNonNull(to);
    Objects.requireNonNull(body);
    this.to = to;
    this.from = from;
    this.body = body;
    this.deliveryReport = deliveryReport;
    this.sendAt = sendAt;
    this.expireAt = expireAt;
    this.callbackUrl = callbackUrl;
    this.clientReference = clientReference;
    this.feedbackEnabled = feedbackEnabled;
  }

  public Collection<String> getTo() {
    return to;
  }

  public T getBody() {
    return body;
  }

  public Optional<String> getFrom() {
    return Optional.ofNullable(from);
  }

  public Optional<DeliveryReportType> getDeliveryReport() {
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

  public Optional<String> getClientReference() {
    return Optional.ofNullable(clientReference);
  }

  public Optional<Boolean> isFeedbackEnabled() {
    return Optional.ofNullable(feedbackEnabled);
  }

  @Override
  public String toString() {
    return "BaseBatch{"
        + "body="
        + body
        + ", to="
        + to
        + ", from='"
        + from
        + '\''
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

    public Collection<String> to;

    public String from;

    public T body;

    public DeliveryReportType deliveryReport;

    public Instant sendAt;

    public Instant expireAt;

    public String callbackUrl;

    public String clientReference;

    public Boolean feedbackEnabled;

    public B setTo(Collection<String> to) {
      this.to = to;
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

    public BaseBatch<T> build() {
      return new BaseBatch<>(
          to,
          from,
          body,
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

  public static class BatchBuilder<T> extends BaseBatch.Builder<T, BatchBuilder<T>> {
    @Override
    protected BatchBuilder<T> self() {
      return this;
    }
  }
}
