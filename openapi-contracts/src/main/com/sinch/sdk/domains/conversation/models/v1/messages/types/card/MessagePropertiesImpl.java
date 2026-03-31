package com.sinch.sdk.domains.conversation.models.v1.messages.types.card;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({MessagePropertiesImpl.JSON_PROPERTY_WHATSAPP_HEADER})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class MessagePropertiesImpl implements MessageProperties {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_WHATSAPP_HEADER = "whatsapp_header";

  private OptionalValue<String> whatsappHeader;

  public MessagePropertiesImpl() {}

  protected MessagePropertiesImpl(OptionalValue<String> whatsappHeader) {
    this.whatsappHeader = whatsappHeader;
  }

  @JsonIgnore
  public String getWhatsappHeader() {
    return whatsappHeader.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_WHATSAPP_HEADER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> whatsappHeader() {
    return whatsappHeader;
  }

  /** Return true if this CardMessage_message_properties object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MessagePropertiesImpl cardMessageMessageProperties = (MessagePropertiesImpl) o;
    return Objects.equals(this.whatsappHeader, cardMessageMessageProperties.whatsappHeader);
  }

  @Override
  public int hashCode() {
    return Objects.hash(whatsappHeader);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MessagePropertiesImpl {\n");
    sb.append("    whatsappHeader: ").append(toIndentedString(whatsappHeader)).append("\n");
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
  static class Builder implements MessageProperties.Builder {
    OptionalValue<String> whatsappHeader = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_WHATSAPP_HEADER)
    public Builder setWhatsappHeader(String whatsappHeader) {
      this.whatsappHeader = OptionalValue.of(whatsappHeader);
      return this;
    }

    public MessageProperties build() {
      return new MessagePropertiesImpl(whatsappHeader);
    }
  }
}
