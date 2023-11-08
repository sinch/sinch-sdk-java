package com.sinch.sdk.domains.sms.models.webhooks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.Optional;

/**
 * Base class for Incoming SMS Webhook
 *
 * @param <T> Type of SMS body
 * @since 1.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    property = "type",
    visible = true)
@JsonSubTypes({
  @JsonSubTypes.Type(value = IncomingSMSBinary.class, name = "mo_binary"),
  @JsonSubTypes.Type(value = IncomingSMSText.class, name = "mo_text")
})
public abstract class BaseIncomingSMS<T> {

  static final String JSON_PROPERTY_BODY = "body";
  private final T body;
  static final String JSON_PROPERTY_FROM = "from";
  private final String from;
  static final String JSON_PROPERTY_ID = "id";
  private final String id;
  static final String JSON_PROPERTY_RECEIVED_AT = "received_at";
  private final Instant receivedAt;
  static final String JSON_PROPERTY_TO = "to";
  private final String to;
  static final String JSON_PROPERTY_CLIENT_REFERENCE = "client_reference";
  private final String clientReference;
  static final String JSON_PROPERTY_OPERATOR_ID = "operator_id";
  private final String operatorId;
  static final String JSON_PROPERTY_SENT_AT = "sent_at";
  private final Instant sentAt;

  @JsonCreator
  public BaseIncomingSMS(
      @JsonProperty(JSON_PROPERTY_BODY) T body,
      @JsonProperty(JSON_PROPERTY_FROM) String from,
      @JsonProperty(JSON_PROPERTY_ID) String id,
      @JsonProperty(JSON_PROPERTY_RECEIVED_AT) OffsetDateTime receivedAt,
      @JsonProperty(JSON_PROPERTY_TO) String to,
      @JsonProperty(JSON_PROPERTY_CLIENT_REFERENCE) String clientReference,
      @JsonProperty(JSON_PROPERTY_OPERATOR_ID) String operatorId,
      @JsonProperty(JSON_PROPERTY_SENT_AT) OffsetDateTime sentAt) {
    this.body = body;
    this.from = from;
    this.id = id;
    this.receivedAt = receivedAt.toInstant();
    this.to = to;
    this.clientReference = clientReference;
    this.operatorId = operatorId;
    this.sentAt = null != sentAt ? sentAt.toInstant() : null;
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
}
