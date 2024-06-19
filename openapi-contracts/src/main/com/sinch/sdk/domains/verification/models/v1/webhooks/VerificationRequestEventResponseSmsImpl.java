package com.sinch.sdk.domains.verification.models.v1.webhooks;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.verification.models.v1.webhooks.internal.VerificationRequestEventResponseSmsContent;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  VerificationRequestEventResponseSmsImpl.JSON_PROPERTY_ACTION,
  VerificationRequestEventResponseSmsImpl.JSON_PROPERTY_SMS
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class VerificationRequestEventResponseSmsImpl
    implements VerificationRequestEventResponseSms,
        com.sinch.sdk.domains.verification.models.v1.webhooks.VerificationRequestEventResponse {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_ACTION = "action";

  private OptionalValue<VerificationEventResponseAction> action;

  public static final String JSON_PROPERTY_SMS = "sms";

  private OptionalValue<VerificationRequestEventResponseSmsContent> sms;

  public VerificationRequestEventResponseSmsImpl() {}

  protected VerificationRequestEventResponseSmsImpl(
      OptionalValue<VerificationEventResponseAction> action,
      OptionalValue<VerificationRequestEventResponseSmsContent> sms) {
    this.action = action;
    this.sms = sms;
  }

  @JsonIgnore
  public VerificationEventResponseAction getAction() {
    return action.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ACTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<VerificationEventResponseAction> action() {
    return action;
  }

  @JsonIgnore
  public VerificationRequestEventResponseSmsContent getSms() {
    return sms.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SMS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<VerificationRequestEventResponseSmsContent> sms() {
    return sms;
  }

  @JsonIgnore
  public String getCode() {
    if (null == sms || !sms.isPresent() || null == sms.get().getCode()) {
      return null;
    }
    return sms.get().getCode();
  }

  public OptionalValue<String> code() {
    return null != sms
        ? sms.map(VerificationRequestEventResponseSmsContent::getCode)
        : OptionalValue.empty();
  }

  @JsonIgnore
  public List<String> getAcceptLanguage() {
    if (null == sms || !sms.isPresent() || null == sms.get().getAcceptLanguage()) {
      return null;
    }
    return sms.get().getAcceptLanguage();
  }

  public OptionalValue<List<String>> acceptLanguage() {
    return null != sms
        ? sms.map(VerificationRequestEventResponseSmsContent::getAcceptLanguage)
        : OptionalValue.empty();
  }

  /** Return true if this VerificationRequestEventResponseSms object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VerificationRequestEventResponseSmsImpl verificationRequestEventResponseSms =
        (VerificationRequestEventResponseSmsImpl) o;
    return Objects.equals(this.action, verificationRequestEventResponseSms.action)
        && Objects.equals(this.sms, verificationRequestEventResponseSms.sms);
  }

  @Override
  public int hashCode() {
    return Objects.hash(action, sms);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VerificationRequestEventResponseSmsImpl {\n");
    sb.append("    action: ").append(toIndentedString(action)).append("\n");
    sb.append("    sms: ").append(toIndentedString(sms)).append("\n");
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
  static class Builder implements VerificationRequestEventResponseSms.Builder {
    OptionalValue<VerificationEventResponseAction> action = OptionalValue.empty();
    OptionalValue<VerificationRequestEventResponseSmsContent> sms = OptionalValue.empty();

    VerificationRequestEventResponseSmsContent.Builder _delegatedBuilder = null;

    @JsonProperty(JSON_PROPERTY_ACTION)
    public Builder setAction(VerificationEventResponseAction action) {
      this.action = OptionalValue.of(action);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_SMS)
    public Builder setSms(VerificationRequestEventResponseSmsContent sms) {
      this.sms = OptionalValue.of(sms);
      return this;
    }

    @JsonIgnore
    public Builder setCode(String code) {
      getDelegatedBuilder().setCode(code);
      return this;
    }

    @JsonIgnore
    public Builder setAcceptLanguage(List<String> acceptLanguage) {
      getDelegatedBuilder().setAcceptLanguage(acceptLanguage);
      return this;
    }

    private VerificationRequestEventResponseSmsContent.Builder getDelegatedBuilder() {
      if (null == _delegatedBuilder) {
        this._delegatedBuilder = VerificationRequestEventResponseSmsContent.builder();
      }
      return this._delegatedBuilder;
    }

    public VerificationRequestEventResponseSms build() {
      // delegated builder was used: filling the related source of delegation field
      if (null != this._delegatedBuilder) {
        this.sms = OptionalValue.of(this._delegatedBuilder.build());
      }
      return new VerificationRequestEventResponseSmsImpl(action, sms);
    }
  }
}
