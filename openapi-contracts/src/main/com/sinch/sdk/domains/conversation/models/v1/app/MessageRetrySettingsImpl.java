package com.sinch.sdk.domains.conversation.models.v1.app;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({MessageRetrySettingsImpl.JSON_PROPERTY_RETRY_DURATION})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class MessageRetrySettingsImpl implements MessageRetrySettings {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_RETRY_DURATION = "retry_duration";

  private OptionalValue<Integer> retryDuration;

  public MessageRetrySettingsImpl() {}

  protected MessageRetrySettingsImpl(OptionalValue<Integer> retryDuration) {
    this.retryDuration = retryDuration;
  }

  @JsonIgnore
  public Integer getRetryDuration() {
    return retryDuration.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_RETRY_DURATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Integer> retryDuration() {
    return retryDuration;
  }

  /** Return true if this MessageRetrySettings object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MessageRetrySettingsImpl messageRetrySettings = (MessageRetrySettingsImpl) o;
    return Objects.equals(this.retryDuration, messageRetrySettings.retryDuration);
  }

  @Override
  public int hashCode() {
    return Objects.hash(retryDuration);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MessageRetrySettingsImpl {\n");
    sb.append("    retryDuration: ").append(toIndentedString(retryDuration)).append("\n");
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
  static class Builder implements MessageRetrySettings.Builder {
    OptionalValue<Integer> retryDuration = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_RETRY_DURATION)
    public Builder setRetryDuration(Integer retryDuration) {
      this.retryDuration = OptionalValue.of(retryDuration);
      return this;
    }

    public MessageRetrySettings build() {
      return new MessageRetrySettingsImpl(retryDuration);
    }
  }
}
