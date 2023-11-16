package com.sinch.sdk.domains.sms.models;

import java.time.Instant;
import java.util.Optional;

/**
 * Base class for Incoming message
 *
 * @param <T> Type of body
 * @since 1.0
 */
public abstract class Inbound<T> {

  private final T body;
  private final String from;
  private final String id;
  private final Instant receivedAt;
  private final String to;
  private final String clientReference;
  private final String operatorId;
  private final Instant sentAt;

  public Inbound(
      T body,
      String from,
      String id,
      Instant receivedAt,
      String to,
      String clientReference,
      String operatorId,
      Instant sentAt) {
    this.body = body;
    this.from = from;
    this.id = id;
    this.receivedAt = receivedAt;
    this.to = to;
    this.clientReference = clientReference;
    this.operatorId = operatorId;
    this.sentAt = sentAt;
  }

  public T getBody() {
    return body;
  }

  public String getFrom() {
    return from;
  }

  public String getId() {
    return id;
  }

  public Instant getReceivedAt() {
    return receivedAt;
  }

  public String getTo() {
    return to;
  }

  public Optional<String> getClientReference() {
    return Optional.ofNullable(clientReference);
  }

  public Optional<String> getOperatorId() {
    return Optional.ofNullable(operatorId);
  }

  public Optional<Instant> getSentAt() {
    return Optional.ofNullable(sentAt);
  }

  @Override
  public String toString() {
    return "Inbound{"
        + "body="
        + body
        + ", from='"
        + from
        + '\''
        + ", id='"
        + id
        + '\''
        + ", receivedAt="
        + receivedAt
        + ", to='"
        + to
        + '\''
        + ", clientReference='"
        + clientReference
        + '\''
        + ", operatorId='"
        + operatorId
        + '\''
        + ", sentAt="
        + sentAt
        + '}';
  }

  public abstract static class Builder<T, B extends Builder<T, B>> {

    T body;
    String from;
    String id;
    Instant receivedAt;
    String to;
    String clientReference;
    String operatorId;
    Instant sentAt;

    public B setBody(T body) {
      this.body = body;
      return self();
    }

    public B setFrom(String from) {
      this.from = from;
      return self();
    }

    public B setId(String id) {
      this.id = id;
      return self();
    }

    public B setReceivedAt(Instant receivedAt) {
      this.receivedAt = receivedAt;
      return self();
    }

    public B setTo(String to) {
      this.to = to;
      return self();
    }

    public B setClientReference(String clientReference) {
      this.clientReference = clientReference;
      return self();
    }

    public B setOperatorId(String operatorId) {
      this.operatorId = operatorId;
      return self();
    }

    public B setSentAt(Instant sentAt) {
      this.sentAt = sentAt;
      return self();
    }

    @SuppressWarnings("unchecked")
    protected B self() {
      return (B) this;
    }

    public abstract Inbound<?> build();
  }
}
