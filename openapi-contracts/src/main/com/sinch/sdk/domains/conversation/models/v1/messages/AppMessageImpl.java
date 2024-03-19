package com.sinch.sdk.domains.conversation.models.v1.messages;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({AppMessageImpl.JSON_PROPERTY_APP_MESSAGE})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class AppMessageImpl implements AppMessage {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_APP_MESSAGE = "app_message";

  private OptionalValue<AppMessage> appMessage;

  public AppMessageImpl() {}

  protected AppMessageImpl(OptionalValue<AppMessage> appMessage) {
    this.appMessage = appMessage;
  }

  @JsonIgnore
  public AppMessage getAppMessage() {
    return appMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_APP_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<AppMessage> appMessage() {
    return appMessage;
  }

  /** Return true if this app_message object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AppMessageImpl appMessage = (AppMessageImpl) o;
    return Objects.equals(this.appMessage, appMessage.appMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(appMessage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AppMessageImpl {\n");
    sb.append("    appMessage: ").append(toIndentedString(appMessage)).append("\n");
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
  static class Builder implements AppMessage.Builder {
    OptionalValue<AppMessage> appMessage = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_APP_MESSAGE)
    public Builder setAppMessage(AppMessage appMessage) {
      this.appMessage = OptionalValue.of(appMessage);
      return this;
    }

    public AppMessage build() {
      return new AppMessageImpl(appMessage);
    }
  }
}
