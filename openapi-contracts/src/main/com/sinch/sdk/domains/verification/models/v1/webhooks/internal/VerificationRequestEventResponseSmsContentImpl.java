package com.sinch.sdk.domains.verification.models.v1.webhooks.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  VerificationRequestEventResponseSmsContentImpl.JSON_PROPERTY_CODE,
  VerificationRequestEventResponseSmsContentImpl.JSON_PROPERTY_ACCEPT_LANGUAGE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class VerificationRequestEventResponseSmsContentImpl
    implements VerificationRequestEventResponseSmsContent {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CODE = "code";

  private OptionalValue<String> code;

  public static final String JSON_PROPERTY_ACCEPT_LANGUAGE = "acceptLanguage";

  private OptionalValue<List<String>> acceptLanguage;

  public VerificationRequestEventResponseSmsContentImpl() {}

  protected VerificationRequestEventResponseSmsContentImpl(
      OptionalValue<String> code, OptionalValue<List<String>> acceptLanguage) {
    this.code = code;
    this.acceptLanguage = acceptLanguage;
  }

  @JsonIgnore
  public String getCode() {
    return code.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> code() {
    return code;
  }

  @JsonIgnore
  public List<String> getAcceptLanguage() {
    return acceptLanguage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ACCEPT_LANGUAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<String>> acceptLanguage() {
    return acceptLanguage;
  }

  /** Return true if this VerificationRequestEventResponseSms_allOf_sms object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VerificationRequestEventResponseSmsContentImpl verificationRequestEventResponseSmsAllOfSms =
        (VerificationRequestEventResponseSmsContentImpl) o;
    return Objects.equals(this.code, verificationRequestEventResponseSmsAllOfSms.code)
        && Objects.equals(
            this.acceptLanguage, verificationRequestEventResponseSmsAllOfSms.acceptLanguage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, acceptLanguage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VerificationRequestEventResponseSmsContentImpl {\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    acceptLanguage: ").append(toIndentedString(acceptLanguage)).append("\n");
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
  static class Builder implements VerificationRequestEventResponseSmsContent.Builder {
    OptionalValue<String> code = OptionalValue.empty();
    OptionalValue<List<String>> acceptLanguage = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_CODE)
    public Builder setCode(String code) {
      this.code = OptionalValue.of(code);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_ACCEPT_LANGUAGE)
    public Builder setAcceptLanguage(List<String> acceptLanguage) {
      this.acceptLanguage = OptionalValue.of(acceptLanguage);
      return this;
    }

    public VerificationRequestEventResponseSmsContent build() {
      return new VerificationRequestEventResponseSmsContentImpl(code, acceptLanguage);
    }
  }
}
