package com.sinch.sdk.domains.numbers.models.v1.eventdestinations.request;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({EventDestinationUpdateRequestImpl.JSON_PROPERTY_HMAC_SECRET})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class EventDestinationUpdateRequestImpl implements EventDestinationUpdateRequest {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_HMAC_SECRET = "hmacSecret";

  private OptionalValue<String> hmacSecret;

  public EventDestinationUpdateRequestImpl() {}

  protected EventDestinationUpdateRequestImpl(OptionalValue<String> hmacSecret) {
    this.hmacSecret = hmacSecret;
  }

  @JsonIgnore
  public String getHmacSecret() {
    return hmacSecret.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_HMAC_SECRET)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> hmacSecret() {
    return hmacSecret;
  }

  /** Return true if this CallbackConfigurationUpdate object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EventDestinationUpdateRequestImpl callbackConfigurationUpdate =
        (EventDestinationUpdateRequestImpl) o;
    return Objects.equals(this.hmacSecret, callbackConfigurationUpdate.hmacSecret);
  }

  @Override
  public int hashCode() {
    return Objects.hash(hmacSecret);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EventDestinationUpdateRequestImpl {\n");
    sb.append("    hmacSecret: ").append(toIndentedString(hmacSecret)).append("\n");
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
  static class Builder implements EventDestinationUpdateRequest.Builder {
    OptionalValue<String> hmacSecret = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_HMAC_SECRET)
    public Builder setHmacSecret(String hmacSecret) {
      this.hmacSecret = OptionalValue.of(hmacSecret);
      return this;
    }

    public EventDestinationUpdateRequest build() {
      return new EventDestinationUpdateRequestImpl(hmacSecret);
    }
  }
}
