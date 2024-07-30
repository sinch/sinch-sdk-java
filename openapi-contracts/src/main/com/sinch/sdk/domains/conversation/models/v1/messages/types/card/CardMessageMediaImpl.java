package com.sinch.sdk.domains.conversation.models.v1.messages.types.card;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({CardMessageMediaImpl.JSON_PROPERTY_URL})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class CardMessageMediaImpl implements CardMessageMedia {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_URL = "url";

  private OptionalValue<String> url;

  public CardMessageMediaImpl() {}

  protected CardMessageMediaImpl(OptionalValue<String> url) {
    this.url = url;
  }

  @JsonIgnore
  public String getUrl() {
    return url.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_URL)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> url() {
    return url;
  }

  /** Return true if this CardMessageMediaMessage object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CardMessageMediaImpl cardMessageMediaMessage = (CardMessageMediaImpl) o;
    return Objects.equals(this.url, cardMessageMediaMessage.url);
  }

  @Override
  public int hashCode() {
    return Objects.hash(url);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CardMessageMediaImpl {\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
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
  static class Builder implements CardMessageMedia.Builder {
    OptionalValue<String> url = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_URL)
    public Builder setUrl(String url) {
      this.url = OptionalValue.of(url);
      return this;
    }

    public CardMessageMedia build() {
      return new CardMessageMediaImpl(url);
    }
  }
}
