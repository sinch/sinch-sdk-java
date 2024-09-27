package com.sinch.sdk.domains.conversation.models.v1.messages.types.contactinfo;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({EmailInfoImpl.JSON_PROPERTY_EMAIL_ADDRESS, EmailInfoImpl.JSON_PROPERTY_TYPE})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class EmailInfoImpl implements EmailInfo {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_EMAIL_ADDRESS = "email_address";

  private OptionalValue<String> emailAddress;

  public static final String JSON_PROPERTY_TYPE = "type";

  private OptionalValue<String> type;

  public EmailInfoImpl() {}

  protected EmailInfoImpl(OptionalValue<String> emailAddress, OptionalValue<String> type) {
    this.emailAddress = emailAddress;
    this.type = type;
  }

  @JsonIgnore
  public String getEmailAddress() {
    return emailAddress.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_EMAIL_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> emailAddress() {
    return emailAddress;
  }

  @JsonIgnore
  public String getType() {
    return type.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> type() {
    return type;
  }

  /** Return true if this EmailInfo object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EmailInfoImpl emailInfo = (EmailInfoImpl) o;
    return Objects.equals(this.emailAddress, emailInfo.emailAddress)
        && Objects.equals(this.type, emailInfo.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(emailAddress, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EmailInfoImpl {\n");
    sb.append("    emailAddress: ").append(toIndentedString(emailAddress)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
  static class Builder implements EmailInfo.Builder {
    OptionalValue<String> emailAddress = OptionalValue.empty();
    OptionalValue<String> type = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_EMAIL_ADDRESS)
    public Builder setEmailAddress(String emailAddress) {
      this.emailAddress = OptionalValue.of(emailAddress);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_TYPE)
    public Builder setType(String type) {
      this.type = OptionalValue.of(type);
      return this;
    }

    public EmailInfo build() {
      return new EmailInfoImpl(emailAddress, type);
    }
  }
}
