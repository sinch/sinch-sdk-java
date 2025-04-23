package com.sinch.sdk.domains.sms.models.v1.inbounds;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.time.Instant;
import java.util.Objects;

@JsonPropertyOrder({
  MediaMessageImpl.JSON_PROPERTY_CLIENT_REFERENCE,
  MediaMessageImpl.JSON_PROPERTY_FROM,
  MediaMessageImpl.JSON_PROPERTY_ID,
  MediaMessageImpl.JSON_PROPERTY_OPERATOR_ID,
  MediaMessageImpl.JSON_PROPERTY_RECEIVED_AT,
  MediaMessageImpl.JSON_PROPERTY_SENT_AT,
  MediaMessageImpl.JSON_PROPERTY_TO,
  MediaMessageImpl.JSON_PROPERTY_TYPE,
  MediaMessageImpl.JSON_PROPERTY_BODY
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class MediaMessageImpl implements MediaMessage, InboundMessage {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CLIENT_REFERENCE = "client_reference";

  private OptionalValue<String> clientReference;

  public static final String JSON_PROPERTY_FROM = "from";

  private OptionalValue<String> from;

  public static final String JSON_PROPERTY_ID = "id";

  private OptionalValue<String> id;

  public static final String JSON_PROPERTY_OPERATOR_ID = "operator_id";

  private OptionalValue<String> operatorId;

  public static final String JSON_PROPERTY_RECEIVED_AT = "received_at";

  private OptionalValue<Instant> receivedAt;

  public static final String JSON_PROPERTY_SENT_AT = "sent_at";

  private OptionalValue<Instant> sentAt;

  public static final String JSON_PROPERTY_TO = "to";

  private OptionalValue<String> to;

  public static final String JSON_PROPERTY_TYPE = "type";

  private OptionalValue<TypeEnum> type;

  public static final String JSON_PROPERTY_BODY = "body";

  private OptionalValue<MediaMessageBody> body;

  public MediaMessageImpl() {}

  protected MediaMessageImpl(
      OptionalValue<String> clientReference,
      OptionalValue<String> from,
      OptionalValue<String> id,
      OptionalValue<String> operatorId,
      OptionalValue<Instant> receivedAt,
      OptionalValue<Instant> sentAt,
      OptionalValue<String> to,
      OptionalValue<TypeEnum> type,
      OptionalValue<MediaMessageBody> body) {
    this.clientReference = clientReference;
    this.from = from;
    this.id = id;
    this.operatorId = operatorId;
    this.receivedAt = receivedAt;
    this.sentAt = sentAt;
    this.to = to;
    this.type = type;
    this.body = body;
  }

  @JsonIgnore
  public String getClientReference() {
    return clientReference.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CLIENT_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> clientReference() {
    return clientReference;
  }

  @JsonIgnore
  public String getFrom() {
    return from.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_FROM)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> from() {
    return from;
  }

  @JsonIgnore
  public String getId() {
    return id.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> id() {
    return id;
  }

  @JsonIgnore
  public String getOperatorId() {
    return operatorId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_OPERATOR_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> operatorId() {
    return operatorId;
  }

  @JsonIgnore
  public Instant getReceivedAt() {
    return receivedAt.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_RECEIVED_AT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<Instant> receivedAt() {
    return receivedAt;
  }

  @JsonIgnore
  public Instant getSentAt() {
    return sentAt.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SENT_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Instant> sentAt() {
    return sentAt;
  }

  @JsonIgnore
  public String getTo() {
    return to.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TO)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> to() {
    return to;
  }

  @JsonIgnore
  public TypeEnum getType() {
    return type.orElse(null);
  }

  @JsonIgnore
  public OptionalValue<TypeEnum> type() {
    return type;
  }

  @JsonIgnore
  public MediaMessageBody getBody() {
    return body.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_BODY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<MediaMessageBody> body() {
    return body;
  }

  /** Return true if this media_message object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MediaMessageImpl mediaMessage = (MediaMessageImpl) o;
    return Objects.equals(this.clientReference, mediaMessage.clientReference)
        && Objects.equals(this.from, mediaMessage.from)
        && Objects.equals(this.id, mediaMessage.id)
        && Objects.equals(this.operatorId, mediaMessage.operatorId)
        && Objects.equals(this.receivedAt, mediaMessage.receivedAt)
        && Objects.equals(this.sentAt, mediaMessage.sentAt)
        && Objects.equals(this.to, mediaMessage.to)
        && Objects.equals(this.type, mediaMessage.type)
        && Objects.equals(this.body, mediaMessage.body);
  }

  @Override
  public int hashCode() {
    return Objects.hash(clientReference, from, id, operatorId, receivedAt, sentAt, to, type, body);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MediaMessageImpl {\n");
    sb.append("    clientReference: ").append(toIndentedString(clientReference)).append("\n");
    sb.append("    from: ").append(toIndentedString(from)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    operatorId: ").append(toIndentedString(operatorId)).append("\n");
    sb.append("    receivedAt: ").append(toIndentedString(receivedAt)).append("\n");
    sb.append("    sentAt: ").append(toIndentedString(sentAt)).append("\n");
    sb.append("    to: ").append(toIndentedString(to)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    body: ").append(toIndentedString(body)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

  @JsonPOJOBuilder(withPrefix = "set")
  static class Builder implements MediaMessage.Builder {
    OptionalValue<String> clientReference = OptionalValue.empty();
    OptionalValue<String> from = OptionalValue.empty();
    OptionalValue<String> id = OptionalValue.empty();
    OptionalValue<String> operatorId = OptionalValue.empty();
    OptionalValue<Instant> receivedAt = OptionalValue.empty();
    OptionalValue<Instant> sentAt = OptionalValue.empty();
    OptionalValue<String> to = OptionalValue.empty();
    OptionalValue<TypeEnum> type = OptionalValue.of(TypeEnum.MO_MEDIA);
    OptionalValue<MediaMessageBody> body = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_CLIENT_REFERENCE)
    public Builder setClientReference(String clientReference) {
      this.clientReference = OptionalValue.of(clientReference);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_FROM, required = true)
    public Builder setFrom(String from) {
      this.from = OptionalValue.of(from);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_ID, required = true)
    public Builder setId(String id) {
      this.id = OptionalValue.of(id);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_OPERATOR_ID)
    public Builder setOperatorId(String operatorId) {
      this.operatorId = OptionalValue.of(operatorId);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_RECEIVED_AT, required = true)
    public Builder setReceivedAt(Instant receivedAt) {
      this.receivedAt = OptionalValue.of(receivedAt);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_SENT_AT)
    public Builder setSentAt(Instant sentAt) {
      this.sentAt = OptionalValue.of(sentAt);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_TO, required = true)
    public Builder setTo(String to) {
      this.to = OptionalValue.of(to);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_BODY, required = true)
    public Builder setBody(MediaMessageBody body) {
      this.body = OptionalValue.of(body);
      return this;
    }

    public MediaMessage build() {
      return new MediaMessageImpl(
          clientReference, from, id, operatorId, receivedAt, sentAt, to, type, body);
    }
  }
}
