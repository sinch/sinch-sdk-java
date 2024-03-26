package com.sinch.sdk.domains.conversation.models.v1.messages;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({OmniMessageOverrideImpl.JSON_PROPERTY_MESSAGE})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class OmniMessageOverrideImpl implements OmniMessageOverride {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_MESSAGE = "message";

  private OptionalValue<OmniMessageOverrideMessage> message;

  public OmniMessageOverrideImpl() {}

  protected OmniMessageOverrideImpl(OptionalValue<OmniMessageOverrideMessage> message) {
    this.message = message;
  }

  @JsonIgnore
  public OmniMessageOverrideMessage getMessage() {
    return message.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<OmniMessageOverrideMessage> message() {
    return message;
  }

  /** Return true if this OmniMessageOverride object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OmniMessageOverrideImpl omniMessageOverride = (OmniMessageOverrideImpl) o;
    return Objects.equals(this.message, omniMessageOverride.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OmniMessageOverrideImpl {\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
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
  static class Builder implements OmniMessageOverride.Builder {
    OptionalValue<OmniMessageOverrideMessage> message = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_MESSAGE)
    public Builder setMessage(OmniMessageOverrideMessage message) {
      this.message = OptionalValue.of(message);
      return this;
    }

    public OmniMessageOverride build() {
      return new OmniMessageOverrideImpl(message);
    }
  }
}
