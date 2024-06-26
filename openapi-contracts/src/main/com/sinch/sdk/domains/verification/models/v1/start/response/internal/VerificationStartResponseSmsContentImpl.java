package com.sinch.sdk.domains.verification.models.v1.start.response.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  VerificationStartResponseSmsContentImpl.JSON_PROPERTY_TEMPLATE,
  VerificationStartResponseSmsContentImpl.JSON_PROPERTY_INTERCEPTION_TIMEOUT
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class VerificationStartResponseSmsContentImpl
    implements VerificationStartResponseSmsContent {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TEMPLATE = "template";

  private OptionalValue<String> template;

  public static final String JSON_PROPERTY_INTERCEPTION_TIMEOUT = "interceptionTimeout";

  private OptionalValue<Integer> interceptionTimeout;

  public VerificationStartResponseSmsContentImpl() {}

  protected VerificationStartResponseSmsContentImpl(
      OptionalValue<String> template, OptionalValue<Integer> interceptionTimeout) {
    this.template = template;
    this.interceptionTimeout = interceptionTimeout;
  }

  @JsonIgnore
  public String getTemplate() {
    return template.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TEMPLATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> template() {
    return template;
  }

  @JsonIgnore
  public Integer getInterceptionTimeout() {
    return interceptionTimeout.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_INTERCEPTION_TIMEOUT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Integer> interceptionTimeout() {
    return interceptionTimeout;
  }

  /** Return true if this VerificationStartResponseSms_allOf_sms object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VerificationStartResponseSmsContentImpl verificationStartResponseSmsAllOfSms =
        (VerificationStartResponseSmsContentImpl) o;
    return Objects.equals(this.template, verificationStartResponseSmsAllOfSms.template)
        && Objects.equals(
            this.interceptionTimeout, verificationStartResponseSmsAllOfSms.interceptionTimeout);
  }

  @Override
  public int hashCode() {
    return Objects.hash(template, interceptionTimeout);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VerificationStartResponseSmsContentImpl {\n");
    sb.append("    template: ").append(toIndentedString(template)).append("\n");
    sb.append("    interceptionTimeout: ")
        .append(toIndentedString(interceptionTimeout))
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
  static class Builder implements VerificationStartResponseSmsContent.Builder {
    OptionalValue<String> template = OptionalValue.empty();
    OptionalValue<Integer> interceptionTimeout = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_TEMPLATE)
    public Builder setTemplate(String template) {
      this.template = OptionalValue.of(template);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_INTERCEPTION_TIMEOUT)
    public Builder setInterceptionTimeout(Integer interceptionTimeout) {
      this.interceptionTimeout = OptionalValue.of(interceptionTimeout);
      return this;
    }

    public VerificationStartResponseSmsContent build() {
      return new VerificationStartResponseSmsContentImpl(template, interceptionTimeout);
    }
  }
}
