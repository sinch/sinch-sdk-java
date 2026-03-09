package com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.line.buttons;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  LineNotificationMessageTemplateButtonImpl.JSON_PROPERTY_BUTTON_KEY,
  LineNotificationMessageTemplateButtonImpl.JSON_PROPERTY_URL
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class LineNotificationMessageTemplateButtonImpl
    implements LineNotificationMessageTemplateButton {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_BUTTON_KEY = "button_key";

  private OptionalValue<String> buttonKey;

  public static final String JSON_PROPERTY_URL = "url";

  private OptionalValue<String> url;

  public LineNotificationMessageTemplateButtonImpl() {}

  protected LineNotificationMessageTemplateButtonImpl(
      OptionalValue<String> buttonKey, OptionalValue<String> url) {
    this.buttonKey = buttonKey;
    this.url = url;
  }

  @JsonIgnore
  public String getButtonKey() {
    return buttonKey.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_BUTTON_KEY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> buttonKey() {
    return buttonKey;
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

  /** Return true if this LineNotificationMessageTemplateButton object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LineNotificationMessageTemplateButtonImpl lineNotificationMessageTemplateButton =
        (LineNotificationMessageTemplateButtonImpl) o;
    return Objects.equals(this.buttonKey, lineNotificationMessageTemplateButton.buttonKey)
        && Objects.equals(this.url, lineNotificationMessageTemplateButton.url);
  }

  @Override
  public int hashCode() {
    return Objects.hash(buttonKey, url);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LineNotificationMessageTemplateButtonImpl {\n");
    sb.append("    buttonKey: ").append(toIndentedString(buttonKey)).append("\n");
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
  static class Builder implements LineNotificationMessageTemplateButton.Builder {
    OptionalValue<String> buttonKey = OptionalValue.empty();
    OptionalValue<String> url = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_BUTTON_KEY, required = true)
    public Builder setButtonKey(String buttonKey) {
      this.buttonKey = OptionalValue.of(buttonKey);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_URL, required = true)
    public Builder setUrl(String url) {
      this.url = OptionalValue.of(url);
      return this;
    }

    public LineNotificationMessageTemplateButton build() {
      return new LineNotificationMessageTemplateButtonImpl(buttonKey, url);
    }
  }
}
