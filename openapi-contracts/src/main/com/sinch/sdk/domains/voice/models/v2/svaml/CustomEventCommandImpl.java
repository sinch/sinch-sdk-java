package com.sinch.sdk.domains.voice.models.v2.svaml;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  CustomEventCommandImpl.JSON_PROPERTY_COMMAND,
  CustomEventCommandImpl.JSON_PROPERTY_WEBHOOK_NAME,
  CustomEventCommandImpl.JSON_PROPERTY_URL,
  CustomEventCommandImpl.JSON_PROPERTY_FALLBACK_URL
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class CustomEventCommandImpl implements CustomEventCommand, SvamlCommand {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_COMMAND = "command";

  private OptionalValue<CommandEnum> command;

  public static final String JSON_PROPERTY_WEBHOOK_NAME = "webhookName";

  private OptionalValue<String> customEventName;

  public static final String JSON_PROPERTY_URL = "url";

  private OptionalValue<String> url;

  public static final String JSON_PROPERTY_FALLBACK_URL = "fallbackUrl";

  private OptionalValue<String> fallbackUrl;

  public CustomEventCommandImpl() {}

  protected CustomEventCommandImpl(
      OptionalValue<CommandEnum> command,
      OptionalValue<String> customEventName,
      OptionalValue<String> url,
      OptionalValue<String> fallbackUrl) {
    this.command = command;
    this.customEventName = customEventName;
    this.url = url;
    this.fallbackUrl = fallbackUrl;
  }

  @JsonIgnore
  public CommandEnum getCommand() {
    return command.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_COMMAND)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<CommandEnum> command() {
    return command;
  }

  @JsonIgnore
  public String getCustomEventName() {
    return customEventName.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_WEBHOOK_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> customEventName() {
    return customEventName;
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

  @JsonIgnore
  public String getFallbackUrl() {
    return fallbackUrl.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_FALLBACK_URL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> fallbackUrl() {
    return fallbackUrl;
  }

  /** Return true if this CustomEventCommand object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomEventCommandImpl customEventCommand = (CustomEventCommandImpl) o;
    return Objects.equals(this.command, customEventCommand.command)
        && Objects.equals(this.customEventName, customEventCommand.customEventName)
        && Objects.equals(this.url, customEventCommand.url)
        && Objects.equals(this.fallbackUrl, customEventCommand.fallbackUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(command, customEventName, url, fallbackUrl);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomEventCommandImpl {\n");
    sb.append("    command: ").append(toIndentedString(command)).append("\n");
    sb.append("    customEventName: ").append(toIndentedString(customEventName)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    fallbackUrl: ").append(toIndentedString(fallbackUrl)).append("\n");
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
  static class Builder implements CustomEventCommand.Builder {
    OptionalValue<CommandEnum> command = OptionalValue.of(CommandEnum.WEBHOOK);
    OptionalValue<String> customEventName = OptionalValue.empty();
    OptionalValue<String> url = OptionalValue.empty();
    OptionalValue<String> fallbackUrl = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_COMMAND, required = true)
    Builder setCommand(CommandEnum command) {
      if (!Objects.equals(command, CommandEnum.WEBHOOK)) {
        throw new IllegalArgumentException(
            String.format("'command' must be '%s' (is '%s')", CommandEnum.WEBHOOK, command));
      }
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_WEBHOOK_NAME, required = true)
    public Builder setCustomEventName(String customEventName) {
      this.customEventName = OptionalValue.of(customEventName);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_URL, required = true)
    public Builder setUrl(String url) {
      this.url = OptionalValue.of(url);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_FALLBACK_URL)
    public Builder setFallbackUrl(String fallbackUrl) {
      this.fallbackUrl = OptionalValue.of(fallbackUrl);
      return this;
    }

    public CustomEventCommand build() {
      return new CustomEventCommandImpl(command, customEventName, url, fallbackUrl);
    }
  }
}
