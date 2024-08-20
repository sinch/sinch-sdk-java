package com.sinch.sdk.domains.conversation.models.v1.capability.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.Recipient;
import java.util.Objects;

@JsonPropertyOrder({
  QueryCapabilityResponseImpl.JSON_PROPERTY_APP_ID,
  QueryCapabilityResponseImpl.JSON_PROPERTY_RECIPIENT,
  QueryCapabilityResponseImpl.JSON_PROPERTY_REQUEST_ID
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class QueryCapabilityResponseImpl implements QueryCapabilityResponse {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_APP_ID = "app_id";

  private OptionalValue<String> appId;

  public static final String JSON_PROPERTY_RECIPIENT = "recipient";

  private OptionalValue<Recipient> recipient;

  public static final String JSON_PROPERTY_REQUEST_ID = "request_id";

  private OptionalValue<String> requestId;

  public QueryCapabilityResponseImpl() {}

  protected QueryCapabilityResponseImpl(
      OptionalValue<String> appId,
      OptionalValue<Recipient> recipient,
      OptionalValue<String> requestId) {
    this.appId = appId;
    this.recipient = recipient;
    this.requestId = requestId;
  }

  @JsonIgnore
  public String getAppId() {
    return appId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_APP_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> appId() {
    return appId;
  }

  @JsonIgnore
  public Recipient getRecipient() {
    return recipient.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_RECIPIENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Recipient> recipient() {
    return recipient;
  }

  @JsonIgnore
  public String getRequestId() {
    return requestId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_REQUEST_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> requestId() {
    return requestId;
  }

  /** Return true if this QueryCapabilityResponse object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    QueryCapabilityResponseImpl queryCapabilityResponse = (QueryCapabilityResponseImpl) o;
    return Objects.equals(this.appId, queryCapabilityResponse.appId)
        && Objects.equals(this.recipient, queryCapabilityResponse.recipient)
        && Objects.equals(this.requestId, queryCapabilityResponse.requestId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(appId, recipient, requestId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class QueryCapabilityResponseImpl {\n");
    sb.append("    appId: ").append(toIndentedString(appId)).append("\n");
    sb.append("    recipient: ").append(toIndentedString(recipient)).append("\n");
    sb.append("    requestId: ").append(toIndentedString(requestId)).append("\n");
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
  static class Builder implements QueryCapabilityResponse.Builder {
    OptionalValue<String> appId = OptionalValue.empty();
    OptionalValue<Recipient> recipient = OptionalValue.empty();
    OptionalValue<String> requestId = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_APP_ID)
    public Builder setAppId(String appId) {
      this.appId = OptionalValue.of(appId);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_RECIPIENT)
    public Builder setRecipient(Recipient recipient) {
      this.recipient = OptionalValue.of(recipient);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_REQUEST_ID)
    public Builder setRequestId(String requestId) {
      this.requestId = OptionalValue.of(requestId);
      return this;
    }

    public QueryCapabilityResponse build() {
      return new QueryCapabilityResponseImpl(appId, recipient, requestId);
    }
  }
}
