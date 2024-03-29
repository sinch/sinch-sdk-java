/*
 * API Overview | Sinch
 * Sinch SMS API is one of the easiest APIs we offer and enables you to add fast and reliable global SMS to your applications. Send single messages, scheduled batch messages, use available message templates and more.
 *
 * The version of the OpenAPI document: v1
 * Contact: Support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.sms.models.dto.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.sinch.sdk.core.utils.databind.JSONNavigator;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/** The page of inbounds matching the given filters. */
@JsonPropertyOrder({
  ApiMoMessageDto.JSON_PROPERTY_FROM,
  ApiMoMessageDto.JSON_PROPERTY_ID,
  ApiMoMessageDto.JSON_PROPERTY_RECEIVED_AT,
  ApiMoMessageDto.JSON_PROPERTY_TO,
  ApiMoMessageDto.JSON_PROPERTY_TYPE,
  ApiMoMessageDto.JSON_PROPERTY_BODY,
  ApiMoMessageDto.JSON_PROPERTY_CLIENT_REFERENCE,
  ApiMoMessageDto.JSON_PROPERTY_OPERATOR_ID,
  ApiMoMessageDto.JSON_PROPERTY_SENT_AT
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)

/*@JsonIgnoreProperties(
  value = "type", // ignore manually set type, it will be automatically generated by Jackson during serialization
  allowSetters = true // allows the type to be set during deserialization
)*/
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NONE,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    property = "type",
    visible = true)
@JsonSubTypes({
  @JsonSubTypes.Type(value = MOBinaryDto.class, name = "MOBinary"),
  @JsonSubTypes.Type(value = MOTextDto.class, name = "MOText"),
})
public class ApiMoMessageDto {
  private static final long serialVersionUID = 1L;
  public static final String JSON_PROPERTY_FROM = "from";
  private String from;
  private boolean fromDefined = false;

  public static final String JSON_PROPERTY_ID = "id";
  private String id;
  private boolean idDefined = false;

  public static final String JSON_PROPERTY_RECEIVED_AT = "received_at";
  private OffsetDateTime receivedAt;
  private boolean receivedAtDefined = false;

  public static final String JSON_PROPERTY_TO = "to";
  private String to;
  private boolean toDefined = false;

  public static final String JSON_PROPERTY_TYPE = "type";
  private String type;
  private boolean typeDefined = false;

  public static final String JSON_PROPERTY_BODY = "body";
  private String body;
  private boolean bodyDefined = false;

  public static final String JSON_PROPERTY_CLIENT_REFERENCE = "client_reference";
  private String clientReference;
  private boolean clientReferenceDefined = false;

  public static final String JSON_PROPERTY_OPERATOR_ID = "operator_id";
  private String operatorId;
  private boolean operatorIdDefined = false;

  public static final String JSON_PROPERTY_SENT_AT = "sent_at";
  private OffsetDateTime sentAt;
  private boolean sentAtDefined = false;

  public ApiMoMessageDto() {}

  @JsonCreator
  public ApiMoMessageDto(@JsonProperty(JSON_PROPERTY_TYPE) String type) {
    this();
    this.type = type;
    this.typeDefined = true;
  }

  public ApiMoMessageDto from(String from) {
    this.from = from;
    this.fromDefined = true;
    return this;
  }

  /**
   * The phone number that sent the message. &lt;a
   * href&#x3D;\&quot;https://community.sinch.com/t5/Glossary/MSISDN/ta-p/7628\&quot;
   * target&#x3D;\&quot;_blank\&quot;&gt;More info&lt;/a&gt;
   *
   * @return from
   */
  @JsonProperty(JSON_PROPERTY_FROM)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public String getFrom() {
    return from;
  }

  @JsonIgnore
  public boolean getFromDefined() {
    return fromDefined;
  }

  @JsonProperty(JSON_PROPERTY_FROM)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setFrom(String from) {
    this.from = from;
    this.fromDefined = true;
  }

  public ApiMoMessageDto id(String id) {
    this.id = id;
    this.idDefined = true;
    return this;
  }

  /**
   * The ID of this inbound message.
   *
   * @return id
   */
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public String getId() {
    return id;
  }

  @JsonIgnore
  public boolean getIdDefined() {
    return idDefined;
  }

  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setId(String id) {
    this.id = id;
    this.idDefined = true;
  }

  public ApiMoMessageDto receivedAt(OffsetDateTime receivedAt) {
    this.receivedAt = receivedAt;
    this.receivedAtDefined = true;
    return this;
  }

  /**
   * When the system received the message. Formatted as &lt;a
   * href&#x3D;\&quot;https://en.wikipedia.org/wiki/ISO_8601\&quot;
   * target&#x3D;\&quot;_blank\&quot;&gt;ISO-8601&lt;/a&gt;: &#x60;YYYY-MM-DDThh:mm:ss.SSSZ&#x60;.
   *
   * @return receivedAt
   */
  @JsonProperty(JSON_PROPERTY_RECEIVED_AT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OffsetDateTime getReceivedAt() {
    return receivedAt;
  }

  @JsonIgnore
  public boolean getReceivedAtDefined() {
    return receivedAtDefined;
  }

  @JsonProperty(JSON_PROPERTY_RECEIVED_AT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setReceivedAt(OffsetDateTime receivedAt) {
    this.receivedAt = receivedAt;
    this.receivedAtDefined = true;
  }

  public ApiMoMessageDto to(String to) {
    this.to = to;
    this.toDefined = true;
    return this;
  }

  /**
   * The Sinch phone number or short code to which the message was sent.
   *
   * @return to
   */
  @JsonProperty(JSON_PROPERTY_TO)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public String getTo() {
    return to;
  }

  @JsonIgnore
  public boolean getToDefined() {
    return toDefined;
  }

  @JsonProperty(JSON_PROPERTY_TO)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setTo(String to) {
    this.to = to;
    this.toDefined = true;
  }

  /**
   * Get type
   *
   * @return type
   */
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public String getType() {
    return type;
  }

  @JsonIgnore
  public boolean getTypeDefined() {
    return typeDefined;
  }

  public ApiMoMessageDto body(String body) {
    this.body = body;
    this.bodyDefined = true;
    return this;
  }

  /**
   * Get body
   *
   * @return body
   */
  @JsonProperty(JSON_PROPERTY_BODY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getBody() {
    return body;
  }

  @JsonIgnore
  public boolean getBodyDefined() {
    return bodyDefined;
  }

  @JsonProperty(JSON_PROPERTY_BODY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setBody(String body) {
    this.body = body;
    this.bodyDefined = true;
  }

  public ApiMoMessageDto clientReference(String clientReference) {
    this.clientReference = clientReference;
    this.clientReferenceDefined = true;
    return this;
  }

  /**
   * If this inbound message is in response to a previously sent message that contained a client
   * reference, then this field contains *that* client reference. Utilizing this feature requires
   * additional setup on your account. Contact your &lt;a
   * href&#x3D;\&quot;https://dashboard.sinch.com/settings/account-details\&quot;
   * target&#x3D;\&quot;_blank\&quot;&gt;account manager&lt;/a&gt; to enable this feature.
   *
   * @return clientReference
   */
  @JsonProperty(JSON_PROPERTY_CLIENT_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getClientReference() {
    return clientReference;
  }

  @JsonIgnore
  public boolean getClientReferenceDefined() {
    return clientReferenceDefined;
  }

  @JsonProperty(JSON_PROPERTY_CLIENT_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setClientReference(String clientReference) {
    this.clientReference = clientReference;
    this.clientReferenceDefined = true;
  }

  public ApiMoMessageDto operatorId(String operatorId) {
    this.operatorId = operatorId;
    this.operatorIdDefined = true;
    return this;
  }

  /**
   * The MCC/MNC of the sender&#39;s operator if known.
   *
   * @return operatorId
   */
  @JsonProperty(JSON_PROPERTY_OPERATOR_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getOperatorId() {
    return operatorId;
  }

  @JsonIgnore
  public boolean getOperatorIdDefined() {
    return operatorIdDefined;
  }

  @JsonProperty(JSON_PROPERTY_OPERATOR_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setOperatorId(String operatorId) {
    this.operatorId = operatorId;
    this.operatorIdDefined = true;
  }

  public ApiMoMessageDto sentAt(OffsetDateTime sentAt) {
    this.sentAt = sentAt;
    this.sentAtDefined = true;
    return this;
  }

  /**
   * When the message left the originating device. Only available if provided by operator. Formatted
   * as &lt;a href&#x3D;\&quot;https://en.wikipedia.org/wiki/ISO_8601\&quot;
   * target&#x3D;\&quot;_blank\&quot;&gt;ISO-8601&lt;/a&gt;: &#x60;YYYY-MM-DDThh:mm:ss.SSSZ&#x60;.
   *
   * @return sentAt
   */
  @JsonProperty(JSON_PROPERTY_SENT_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OffsetDateTime getSentAt() {
    return sentAt;
  }

  @JsonIgnore
  public boolean getSentAtDefined() {
    return sentAtDefined;
  }

  @JsonProperty(JSON_PROPERTY_SENT_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSentAt(OffsetDateTime sentAt) {
    this.sentAt = sentAt;
    this.sentAtDefined = true;
  }

  /** Return true if this ApiMoMessage object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiMoMessageDto apiMoMessage = (ApiMoMessageDto) o;
    return Objects.equals(this.from, apiMoMessage.from)
        && Objects.equals(this.id, apiMoMessage.id)
        && Objects.equals(this.receivedAt, apiMoMessage.receivedAt)
        && Objects.equals(this.to, apiMoMessage.to)
        && Objects.equals(this.type, apiMoMessage.type)
        && Objects.equals(this.body, apiMoMessage.body)
        && Objects.equals(this.clientReference, apiMoMessage.clientReference)
        && Objects.equals(this.operatorId, apiMoMessage.operatorId)
        && Objects.equals(this.sentAt, apiMoMessage.sentAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(from, id, receivedAt, to, type, body, clientReference, operatorId, sentAt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiMoMessageDto {\n");
    sb.append("    from: ").append(toIndentedString(from)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    receivedAt: ").append(toIndentedString(receivedAt)).append("\n");
    sb.append("    to: ").append(toIndentedString(to)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    body: ").append(toIndentedString(body)).append("\n");
    sb.append("    clientReference: ").append(toIndentedString(clientReference)).append("\n");
    sb.append("    operatorId: ").append(toIndentedString(operatorId)).append("\n");
    sb.append("    sentAt: ").append(toIndentedString(sentAt)).append("\n");
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

  static {
    // Initialize and register the discriminator mappings.
    Map<String, Class<?>> mappings = new HashMap<String, Class<?>>();
    mappings.put("MOBinary", MOBinaryDto.class);
    mappings.put("MOText", MOTextDto.class);
    mappings.put("ApiMoMessage", ApiMoMessageDto.class);
    JSONNavigator.registerDiscriminator(ApiMoMessageDto.class, "type", mappings);
  }
}
