package com.sinch.sdk.domains.conversation.models.v1.messages.types.contactinfo;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  PhoneNumberInfoImpl.JSON_PROPERTY_PHONE_NUMBER,
  PhoneNumberInfoImpl.JSON_PROPERTY_TYPE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class PhoneNumberInfoImpl implements PhoneNumberInfo {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_PHONE_NUMBER = "phone_number";

  private OptionalValue<String> phoneNumber;

  public static final String JSON_PROPERTY_TYPE = "type";

  private OptionalValue<String> type;

  public PhoneNumberInfoImpl() {}

  protected PhoneNumberInfoImpl(OptionalValue<String> phoneNumber, OptionalValue<String> type) {
    this.phoneNumber = phoneNumber;
    this.type = type;
  }

  @JsonIgnore
  public String getPhoneNumber() {
    return phoneNumber.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PHONE_NUMBER)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> phoneNumber() {
    return phoneNumber;
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

  /** Return true if this PhoneNumberInfo object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PhoneNumberInfoImpl phoneNumberInfo = (PhoneNumberInfoImpl) o;
    return Objects.equals(this.phoneNumber, phoneNumberInfo.phoneNumber)
        && Objects.equals(this.type, phoneNumberInfo.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(phoneNumber, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PhoneNumberInfoImpl {\n");
    sb.append("    phoneNumber: ").append(toIndentedString(phoneNumber)).append("\n");
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
  static class Builder implements PhoneNumberInfo.Builder {
    OptionalValue<String> phoneNumber = OptionalValue.empty();
    OptionalValue<String> type = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_PHONE_NUMBER, required = true)
    public Builder setPhoneNumber(String phoneNumber) {
      this.phoneNumber = OptionalValue.of(phoneNumber);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_TYPE)
    public Builder setType(String type) {
      this.type = OptionalValue.of(type);
      return this;
    }

    public PhoneNumberInfo build() {
      return new PhoneNumberInfoImpl(phoneNumber, type);
    }
  }
}
