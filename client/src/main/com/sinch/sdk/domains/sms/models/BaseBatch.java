package com.sinch.sdk.domains.sms.models;

import com.sinch.sdk.core.models.OptionalValue;
import java.time.Instant;
import java.util.Collection;
import java.util.Objects;

/**
 * Base class for Batch types
 *
 * @param <T> Type of batch
 * @since 1.0
 */
public class BaseBatch<T> {

  private final T body;

  private final Collection<String> to;

  private final OptionalValue<String> from;

  private final OptionalValue<DeliveryReportType> deliveryReport;

  private final OptionalValue<Instant> sendAt;

  private final OptionalValue<Instant> expireAt;

  private final OptionalValue<String> callbackUrl;

  private final OptionalValue<String> clientReference;

  private final OptionalValue<Boolean> feedbackEnabled;

  protected BaseBatch(
      Collection<String> to,
      OptionalValue<String> from,
      T body,
      OptionalValue<DeliveryReportType> deliveryReport,
      OptionalValue<Instant> sendAt,
      OptionalValue<Instant> expireAt,
      OptionalValue<String> callbackUrl,
      OptionalValue<String> clientReference,
      OptionalValue<Boolean> feedbackEnabled) {
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

  public OptionalValue<String> getClientReference() {
    return clientReference;
  }

  public OptionalValue<Boolean> isFeedbackEnabled() {
    return feedbackEnabled;
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

    public OptionalValue<String> from = OptionalValue.empty();

    public T body;

    public OptionalValue<DeliveryReportType> deliveryReport = OptionalValue.empty();

    public OptionalValue<Instant> sendAt = OptionalValue.empty();

    public OptionalValue<Instant> expireAt = OptionalValue.empty();

    public OptionalValue<String> callbackUrl = OptionalValue.empty();

    public OptionalValue<String> clientReference = OptionalValue.empty();

    public OptionalValue<Boolean> feedbackEnabled = OptionalValue.empty();

    /**
     * @param to List of Phone numbers and group IDs that will receive the batch
     * @return current builder
     */
    public B setTo(Collection<String> to) {
      this.to = to;
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
      this.body = body;
      return self();
    }

    /**
     * @param deliveryReport Request delivery report callback. Note that delivery reports can be
     *     fetched from the API regardless of this setting
     * @return current builder
     */
    public B setDeliveryReport(DeliveryReportType deliveryReport) {
      this.deliveryReport = OptionalValue.of(deliveryReport);
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

    /**
     * @param clientReference The client identifier of a batch message. If set, the identifier will
     *     be added in the delivery report/callback of this batch
     * @return current builder
     */
    public B setClientReference(String clientReference) {
      this.clientReference = OptionalValue.of(clientReference);
      return self();
    }

    /**
     * @param feedbackEnabled If set to true, then feedback is expected after successful delivery.
     * @return current builder
     */
    public B setFeedbackEnabled(Boolean feedbackEnabled) {
      this.feedbackEnabled = OptionalValue.of(feedbackEnabled);
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
