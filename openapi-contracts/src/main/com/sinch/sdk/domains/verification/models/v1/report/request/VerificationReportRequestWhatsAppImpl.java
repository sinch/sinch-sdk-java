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
import com.sinch.sdk.domains.verification.models.v1.report.request.internal.VerificationReportRequestWhatsAppOptions;
import com.sinch.sdk.domains.verification.models.v1.report.request.internal.VerificationReportRequestWhatsAppOptionsImpl;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

@JsonPropertyOrder({
  VerificationReportRequestWhatsAppImpl.JSON_PROPERTY_METHOD,
  VerificationReportRequestWhatsAppImpl.JSON_PROPERTY_WHATSAPP
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class VerificationReportRequestWhatsAppImpl
    implements VerificationReportRequestWhatsApp,
        com.sinch.sdk.domains.verification.models.v1.report.request.VerificationReportRequest {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_METHOD = "method";

  private OptionalValue<MethodEnum> method;

  public static final String JSON_PROPERTY_WHATSAPP = "whatsapp";

  private OptionalValue<VerificationReportRequestWhatsAppOptions> whatsapp;

  public VerificationReportRequestWhatsAppImpl() {}

  protected VerificationReportRequestWhatsAppImpl(
      OptionalValue<MethodEnum> method,
      OptionalValue<VerificationReportRequestWhatsAppOptions> whatsapp) {
    this.method = method;
    this.whatsapp = whatsapp;
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
  public VerificationReportRequestWhatsAppOptions getWhatsapp() {
    return whatsapp.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_WHATSAPP)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<VerificationReportRequestWhatsAppOptions> whatsapp() {
    return whatsapp;
  }

  @JsonIgnore
  public String getCode() {
    if (null == whatsapp || !whatsapp.isPresent() || null == whatsapp.get().getCode()) {
      return null;
    }
    return whatsapp.get().getCode();
  }

  public OptionalValue<String> code() {
    return null != whatsapp && whatsapp.isPresent()
        ? whatsapp
            .map(f -> ((VerificationReportRequestWhatsAppOptionsImpl) f).code())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  /** Return true if this VerificationReportRequestWhatsApp object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VerificationReportRequestWhatsAppImpl verificationReportRequestWhatsApp =
        (VerificationReportRequestWhatsAppImpl) o;
    return Objects.equals(this.method, verificationReportRequestWhatsApp.method)
        && Objects.equals(this.whatsapp, verificationReportRequestWhatsApp.whatsapp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(method, whatsapp);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VerificationReportRequestWhatsAppImpl {\n");
    sb.append("    method: ").append(toIndentedString(method)).append("\n");
    sb.append("    whatsapp: ").append(toIndentedString(whatsapp)).append("\n");
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
  static class Builder implements VerificationReportRequestWhatsApp.Builder {
    OptionalValue<MethodEnum> method = OptionalValue.of(MethodEnum.WHATSAPP);
    OptionalValue<VerificationReportRequestWhatsAppOptions> whatsapp = OptionalValue.empty();

    VerificationReportRequestWhatsAppOptions.Builder _delegatedBuilder = null;

    @JsonProperty(value = JSON_PROPERTY_WHATSAPP, required = true)
    public Builder setWhatsapp(VerificationReportRequestWhatsAppOptions whatsapp) {
      this.whatsapp = OptionalValue.of(whatsapp);
      return this;
    }

    @JsonIgnore
    public Builder setCode(String code) {
      getDelegatedBuilder().setCode(code);
      return this;
    }

    private VerificationReportRequestWhatsAppOptions.Builder getDelegatedBuilder() {
      if (null == _delegatedBuilder) {
        this._delegatedBuilder = VerificationReportRequestWhatsAppOptions.builder();
      }
      return this._delegatedBuilder;
    }

    public VerificationReportRequestWhatsApp build() {
      // delegated builder was used: filling the related source of delegation field
      if (null != this._delegatedBuilder) {
        this.whatsapp = OptionalValue.of(this._delegatedBuilder.build());
      }
      return new VerificationReportRequestWhatsAppImpl(method, whatsapp);
    }
  }

  public static class DelegatedSerializer
      extends JsonSerializer<OptionalValue<VerificationReportRequestWhatsApp>> {
    @Override
    public void serialize(
        OptionalValue<VerificationReportRequestWhatsApp> value,
        JsonGenerator jgen,
        SerializerProvider provider)
        throws IOException {

      if (!value.isPresent()) {
        return;
      }
      VerificationReportRequestWhatsAppImpl impl =
          (VerificationReportRequestWhatsAppImpl) value.get();
      jgen.writeObject(null != impl ? impl.getWhatsapp() : null);
    }
  }

  public static class DelegatedDeSerializer
      extends JsonDeserializer<VerificationReportRequestWhatsApp> {
    @Override
    public VerificationReportRequestWhatsApp deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException {

      VerificationReportRequestWhatsAppImpl.Builder builder =
          new VerificationReportRequestWhatsAppImpl.Builder();
      VerificationReportRequestWhatsAppOptionsImpl deserialized =
          jp.readValueAs(VerificationReportRequestWhatsAppOptionsImpl.class);
      builder.setWhatsapp(deserialized);
      return builder.build();
    }
  }

  public static Optional<VerificationReportRequestWhatsApp> delegatedConverter(
      VerificationReportRequestWhatsAppOptions internal) {
    if (null == internal) {
      return Optional.empty();
    }
    return Optional.of(new Builder().setWhatsapp(internal).build());
  }
}
