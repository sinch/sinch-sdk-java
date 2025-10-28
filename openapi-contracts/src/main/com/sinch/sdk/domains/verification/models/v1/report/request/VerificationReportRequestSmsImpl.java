package com.sinch.sdk.domains.verification.models.v1.report.request;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.verification.models.v1.report.request.internal.VerificationReportRequestSmsOptions;
import com.sinch.sdk.domains.verification.models.v1.report.request.internal.VerificationReportRequestSmsOptionsImpl;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

@JsonPropertyOrder({
  VerificationReportRequestSmsImpl.JSON_PROPERTY_METHOD,
  VerificationReportRequestSmsImpl.JSON_PROPERTY_SMS
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class VerificationReportRequestSmsImpl
    implements VerificationReportRequestSms,
        com.sinch.sdk.domains.verification.models.v1.report.request.VerificationReportRequest {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_METHOD = "method";

  private OptionalValue<MethodEnum> method;

  public static final String JSON_PROPERTY_SMS = "sms";

  private OptionalValue<VerificationReportRequestSmsOptions> sms;

  public VerificationReportRequestSmsImpl() {}

  protected VerificationReportRequestSmsImpl(
      OptionalValue<MethodEnum> method, OptionalValue<VerificationReportRequestSmsOptions> sms) {
    this.method = method;
    this.sms = sms;
  }

  @JsonIgnore
  public MethodEnum getMethod() {
    return method.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_METHOD)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<MethodEnum> method() {
    return method;
  }

  @JsonIgnore
  public VerificationReportRequestSmsOptions getSms() {
    return sms.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SMS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<VerificationReportRequestSmsOptions> sms() {
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
    return null != sms && sms.isPresent()
        ? sms.map(f -> ((VerificationReportRequestSmsOptionsImpl) f).code())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  /** Return true if this VerificationReportRequestSms object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VerificationReportRequestSmsImpl verificationReportRequestSms =
        (VerificationReportRequestSmsImpl) o;
    return Objects.equals(this.method, verificationReportRequestSms.method)
        && Objects.equals(this.sms, verificationReportRequestSms.sms);
  }

  @Override
  public int hashCode() {
    return Objects.hash(method, sms);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VerificationReportRequestSmsImpl {\n");
    sb.append("    method: ").append(toIndentedString(method)).append("\n");
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
  static class Builder implements VerificationReportRequestSms.Builder {
    OptionalValue<MethodEnum> method = OptionalValue.of(MethodEnum.SMS);
    OptionalValue<VerificationReportRequestSmsOptions> sms = OptionalValue.empty();

    VerificationReportRequestSmsOptions.Builder _delegatedBuilder = null;

    @JsonProperty(value = JSON_PROPERTY_METHOD, required = true)
    Builder setMethod(MethodEnum method) {
      if (!Objects.equals(method, MethodEnum.SMS)) {
        throw new IllegalArgumentException(
            String.format("'method' must be '%s' (is '%s')", MethodEnum.SMS, method));
      }
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_SMS, required = true)
    public Builder setSms(VerificationReportRequestSmsOptions sms) {
      this.sms = OptionalValue.of(sms);
      return this;
    }

    @JsonIgnore
    public Builder setCode(String code) {
      getDelegatedBuilder().setCode(code);
      return this;
    }

    private VerificationReportRequestSmsOptions.Builder getDelegatedBuilder() {
      if (null == _delegatedBuilder) {
        this._delegatedBuilder = VerificationReportRequestSmsOptions.builder();
      }
      return this._delegatedBuilder;
    }

    public VerificationReportRequestSms build() {
      // delegated builder was used: filling the related source of delegation field
      if (null != this._delegatedBuilder) {
        this.sms = OptionalValue.of(this._delegatedBuilder.build());
      }
      return new VerificationReportRequestSmsImpl(method, sms);
    }
  }

  public static class DelegatedSerializer
      extends JsonSerializer<OptionalValue<VerificationReportRequestSms>> {
    @Override
    public void serialize(
        OptionalValue<VerificationReportRequestSms> value,
        JsonGenerator jgen,
        SerializerProvider provider)
        throws IOException {

      if (!value.isPresent()) {
        return;
      }
      VerificationReportRequestSmsImpl impl = (VerificationReportRequestSmsImpl) value.get();
      jgen.writeObject(null != impl ? impl.getSms() : null);
    }
  }

  public static class DelegatedDeSerializer extends JsonDeserializer<VerificationReportRequestSms> {
    @Override
    public VerificationReportRequestSms deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException {

      VerificationReportRequestSmsImpl.Builder builder =
          new VerificationReportRequestSmsImpl.Builder();
      VerificationReportRequestSmsOptionsImpl deserialized =
          jp.readValueAs(VerificationReportRequestSmsOptionsImpl.class);
      builder.setSms(deserialized);
      return builder.build();
    }
  }

  public static Optional<VerificationReportRequestSms> delegatedConverter(
      VerificationReportRequestSmsOptions internal) {
    if (null == internal) {
      return Optional.empty();
    }
    return Optional.of(new Builder().setSms(internal).build());
  }
}
