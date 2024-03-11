package com.sinch.sdk.domains.conversation.models.v1.credentials;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({TelegramCredentialsFieldImpl.JSON_PROPERTY_TELEGRAM_CREDENTIALS})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class TelegramCredentialsFieldImpl implements TelegramCredentialsField {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TELEGRAM_CREDENTIALS = "telegram_credentials";

  private OptionalValue<TelegramCredentials> telegramCredentials;

  public TelegramCredentialsFieldImpl() {}

  protected TelegramCredentialsFieldImpl(OptionalValue<TelegramCredentials> telegramCredentials) {
    this.telegramCredentials = telegramCredentials;
  }

  @JsonIgnore
  public TelegramCredentials getTelegramCredentials() {
    return telegramCredentials.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TELEGRAM_CREDENTIALS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<TelegramCredentials> telegramCredentials() {
    return telegramCredentials;
  }

  /** Return true if this TelegramCredentialsField object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TelegramCredentialsFieldImpl telegramCredentialsField = (TelegramCredentialsFieldImpl) o;
    return Objects.equals(this.telegramCredentials, telegramCredentialsField.telegramCredentials);
  }

  @Override
  public int hashCode() {
    return Objects.hash(telegramCredentials);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TelegramCredentialsFieldImpl {\n");
    sb.append("    telegramCredentials: ")
        .append(toIndentedString(telegramCredentials))
        .append("\n");
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
  static class Builder implements TelegramCredentialsField.Builder {
    OptionalValue<TelegramCredentials> telegramCredentials = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_TELEGRAM_CREDENTIALS)
    public Builder setTelegramCredentials(TelegramCredentials telegramCredentials) {
      this.telegramCredentials = OptionalValue.of(telegramCredentials);
      return this;
    }

    public TelegramCredentialsField build() {
      return new TelegramCredentialsFieldImpl(telegramCredentials);
    }
  }
}
