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
import com.sinch.sdk.domains.verification.models.v1.report.request.internal.VerificationReportRequestPhoneCallOptions;
import com.sinch.sdk.domains.verification.models.v1.report.request.internal.VerificationReportRequestPhoneCallOptionsImpl;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

@JsonPropertyOrder({
  VerificationReportRequestPhoneCallImpl.JSON_PROPERTY_METHOD,
  VerificationReportRequestPhoneCallImpl.JSON_PROPERTY_CALLOUT
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class VerificationReportRequestPhoneCallImpl
    implements VerificationReportRequestPhoneCall,
        com.sinch.sdk.domains.verification.models.v1.report.request.VerificationReportRequest {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_METHOD = "method";

  private OptionalValue<MethodEnum> method;

  public static final String JSON_PROPERTY_CALLOUT = "callout";

  private OptionalValue<VerificationReportRequestPhoneCallOptions> callout;

  public VerificationReportRequestPhoneCallImpl() {}

  protected VerificationReportRequestPhoneCallImpl(
      OptionalValue<MethodEnum> method,
      OptionalValue<VerificationReportRequestPhoneCallOptions> callout) {
    this.method = method;
    this.callout = callout;
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
  public VerificationReportRequestPhoneCallOptions getCallout() {
    return callout.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CALLOUT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<VerificationReportRequestPhoneCallOptions> callout() {
    return callout;
  }

  @JsonIgnore
  public String getCode() {
    if (null == callout || !callout.isPresent() || null == callout.get().getCode()) {
      return null;
    }
    return callout.get().getCode();
  }

  public OptionalValue<String> code() {
    return null != callout && callout.isPresent()
        ? callout
            .map(f -> ((VerificationReportRequestPhoneCallOptionsImpl) f).code())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  /** Return true if this VerificationReportRequestPhoneCall object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VerificationReportRequestPhoneCallImpl verificationReportRequestPhoneCall =
        (VerificationReportRequestPhoneCallImpl) o;
    return Objects.equals(this.method, verificationReportRequestPhoneCall.method)
        && Objects.equals(this.callout, verificationReportRequestPhoneCall.callout);
  }

  @Override
  public int hashCode() {
    return Objects.hash(method, callout);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VerificationReportRequestPhoneCallImpl {\n");
    sb.append("    method: ").append(toIndentedString(method)).append("\n");
    sb.append("    callout: ").append(toIndentedString(callout)).append("\n");
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
  static class Builder implements VerificationReportRequestPhoneCall.Builder {
    OptionalValue<MethodEnum> method = OptionalValue.of(MethodEnum.PHONE_CALL);
    OptionalValue<VerificationReportRequestPhoneCallOptions> callout = OptionalValue.empty();

    VerificationReportRequestPhoneCallOptions.Builder _delegatedBuilder = null;

    @JsonProperty(value = JSON_PROPERTY_CALLOUT, required = true)
    public Builder setCallout(VerificationReportRequestPhoneCallOptions callout) {
      this.callout = OptionalValue.of(callout);
      return this;
    }

    @JsonIgnore
    public Builder setCode(String code) {
      getDelegatedBuilder().setCode(code);
      return this;
    }

    private VerificationReportRequestPhoneCallOptions.Builder getDelegatedBuilder() {
      if (null == _delegatedBuilder) {
        this._delegatedBuilder = VerificationReportRequestPhoneCallOptions.builder();
      }
      return this._delegatedBuilder;
    }

    public VerificationReportRequestPhoneCall build() {
      // delegated builder was used: filling the related source of delegation field
      if (null != this._delegatedBuilder) {
        this.callout = OptionalValue.of(this._delegatedBuilder.build());
      }
      return new VerificationReportRequestPhoneCallImpl(method, callout);
    }
  }

  public static class DelegatedSerializer
      extends JsonSerializer<OptionalValue<VerificationReportRequestPhoneCall>> {
    @Override
    public void serialize(
        OptionalValue<VerificationReportRequestPhoneCall> value,
        JsonGenerator jgen,
        SerializerProvider provider)
        throws IOException {

      if (!value.isPresent()) {
        return;
      }
      VerificationReportRequestPhoneCallImpl impl =
          (VerificationReportRequestPhoneCallImpl) value.get();
      jgen.writeObject(null != impl ? impl.getCallout() : null);
    }
  }

  public static class DelegatedDeSerializer
      extends JsonDeserializer<VerificationReportRequestPhoneCall> {
    @Override
    public VerificationReportRequestPhoneCall deserialize(
        JsonParser jp, DeserializationContext ctxt) throws IOException {

      VerificationReportRequestPhoneCallImpl.Builder builder =
          new VerificationReportRequestPhoneCallImpl.Builder();
      VerificationReportRequestPhoneCallOptionsImpl deserialized =
          jp.readValueAs(VerificationReportRequestPhoneCallOptionsImpl.class);
      builder.setCallout(deserialized);
      return builder.build();
    }
  }

  public static Optional<VerificationReportRequestPhoneCall> delegatedConverter(
      VerificationReportRequestPhoneCallOptions internal) {
    if (null == internal) {
      return Optional.empty();
    }
    return Optional.of(new Builder().setCallout(internal).build());
  }
}
