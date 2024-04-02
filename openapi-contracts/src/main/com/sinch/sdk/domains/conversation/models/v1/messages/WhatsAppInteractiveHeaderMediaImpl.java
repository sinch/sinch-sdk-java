package com.sinch.sdk.domains.conversation.models.v1.messages;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({WhatsAppInteractiveHeaderMediaImpl.JSON_PROPERTY_LINK})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class WhatsAppInteractiveHeaderMediaImpl implements WhatsAppInteractiveHeaderMedia {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_LINK = "link";

  private OptionalValue<String> link;

  public WhatsAppInteractiveHeaderMediaImpl() {}

  protected WhatsAppInteractiveHeaderMediaImpl(OptionalValue<String> link) {
    this.link = link;
  }

  @JsonIgnore
  public String getLink() {
    return link.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_LINK)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> link() {
    return link;
  }

  /** Return true if this WhatsAppInteractiveHeaderMedia object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WhatsAppInteractiveHeaderMediaImpl whatsAppInteractiveHeaderMedia =
        (WhatsAppInteractiveHeaderMediaImpl) o;
    return Objects.equals(this.link, whatsAppInteractiveHeaderMedia.link);
  }

  @Override
  public int hashCode() {
    return Objects.hash(link);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WhatsAppInteractiveHeaderMediaImpl {\n");
    sb.append("    link: ").append(toIndentedString(link)).append("\n");
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
  static class Builder implements WhatsAppInteractiveHeaderMedia.Builder {
    OptionalValue<String> link = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_LINK)
    public Builder setLink(String link) {
      this.link = OptionalValue.of(link);
      return this;
    }

    public WhatsAppInteractiveHeaderMedia build() {
      return new WhatsAppInteractiveHeaderMediaImpl(link);
    }
  }
}
