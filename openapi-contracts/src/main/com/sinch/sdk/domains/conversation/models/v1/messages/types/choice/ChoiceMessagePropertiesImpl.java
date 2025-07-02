package com.sinch.sdk.domains.conversation.models.v1.messages.types.choice;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({ChoiceMessagePropertiesImpl.JSON_PROPERTY_WHATSAPP_FOOTER})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ChoiceMessagePropertiesImpl implements ChoiceMessageProperties {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_WHATSAPP_FOOTER = "whatsapp_footer";

  private OptionalValue<String> whatsappFooter;

  public ChoiceMessagePropertiesImpl() {}

  protected ChoiceMessagePropertiesImpl(OptionalValue<String> whatsappFooter) {
    this.whatsappFooter = whatsappFooter;
  }

  @JsonIgnore
  public String getWhatsappFooter() {
    return whatsappFooter.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_WHATSAPP_FOOTER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> whatsappFooter() {
    return whatsappFooter;
  }

  /** Return true if this ChoiceMessagePropertiesField_message_properties object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChoiceMessagePropertiesImpl choiceMessagePropertiesFieldMessageProperties =
        (ChoiceMessagePropertiesImpl) o;
    return Objects.equals(
        this.whatsappFooter, choiceMessagePropertiesFieldMessageProperties.whatsappFooter);
  }

  @Override
  public int hashCode() {
    return Objects.hash(whatsappFooter);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChoiceMessagePropertiesImpl {\n");
    sb.append("    whatsappFooter: ").append(toIndentedString(whatsappFooter)).append("\n");
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
  static class Builder implements ChoiceMessageProperties.Builder {
    OptionalValue<String> whatsappFooter = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_WHATSAPP_FOOTER)
    public Builder setWhatsappFooter(String whatsappFooter) {
      this.whatsappFooter = OptionalValue.of(whatsappFooter);
      return this;
    }

    public ChoiceMessageProperties build() {
      return new ChoiceMessagePropertiesImpl(whatsappFooter);
    }
  }
}
