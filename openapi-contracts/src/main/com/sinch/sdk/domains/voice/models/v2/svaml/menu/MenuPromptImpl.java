package com.sinch.sdk.domains.voice.models.v2.svaml.menu;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.voice.models.v2.svaml.playback.Message;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  MenuPromptImpl.JSON_PROPERTY_ALLOW_BARGE_IN,
  MenuPromptImpl.JSON_PROPERTY_MESSAGES
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class MenuPromptImpl implements MenuPrompt {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_ALLOW_BARGE_IN = "allowBargeIn";

  private OptionalValue<Boolean> allowBargeIn;

  public static final String JSON_PROPERTY_MESSAGES = "messages";

  private OptionalValue<List<Message>> messages;

  public MenuPromptImpl() {}

  protected MenuPromptImpl(
      OptionalValue<Boolean> allowBargeIn, OptionalValue<List<Message>> messages) {
    this.allowBargeIn = allowBargeIn;
    this.messages = messages;
  }

  @JsonIgnore
  public Boolean getAllowBargeIn() {
    return allowBargeIn.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ALLOW_BARGE_IN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Boolean> allowBargeIn() {
    return allowBargeIn;
  }

  @JsonIgnore
  public List<Message> getMessages() {
    return messages.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MESSAGES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<List<Message>> messages() {
    return messages;
  }

  /** Return true if this MenuPrompt object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MenuPromptImpl menuPrompt = (MenuPromptImpl) o;
    return Objects.equals(this.allowBargeIn, menuPrompt.allowBargeIn)
        && Objects.equals(this.messages, menuPrompt.messages);
  }

  @Override
  public int hashCode() {
    return Objects.hash(allowBargeIn, messages);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MenuPromptImpl {\n");
    sb.append("    allowBargeIn: ").append(toIndentedString(allowBargeIn)).append("\n");
    sb.append("    messages: ").append(toIndentedString(messages)).append("\n");
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
  static class Builder implements MenuPrompt.Builder {
    OptionalValue<Boolean> allowBargeIn = OptionalValue.empty();
    OptionalValue<List<Message>> messages = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_ALLOW_BARGE_IN)
    public Builder setAllowBargeIn(Boolean allowBargeIn) {
      this.allowBargeIn = OptionalValue.of(allowBargeIn);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_MESSAGES, required = true)
    public Builder setMessages(List<Message> messages) {
      this.messages = OptionalValue.of(messages);
      return this;
    }

    public MenuPrompt build() {
      return new MenuPromptImpl(allowBargeIn, messages);
    }
  }
}
