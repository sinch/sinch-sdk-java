package com.sinch.sdk.domains.verification.models.v1.start.request;

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
import com.sinch.sdk.domains.verification.models.v1.Identity;
import com.sinch.sdk.domains.verification.models.v1.VerificationMethod;
import com.sinch.sdk.domains.verification.models.v1.start.request.internal.VerificationStartSmsOptions;
import com.sinch.sdk.domains.verification.models.v1.start.request.internal.VerificationStartSmsOptionsImpl;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

@JsonPropertyOrder({
  VerificationStartRequestSmsImpl.JSON_PROPERTY_IDENTITY,
  VerificationStartRequestSmsImpl.JSON_PROPERTY_METHOD,
  VerificationStartRequestSmsImpl.JSON_PROPERTY_REFERENCE,
  VerificationStartRequestSmsImpl.JSON_PROPERTY_CUSTOM,
  VerificationStartRequestSmsImpl.JSON_PROPERTY_SMS_OPTIONS
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class VerificationStartRequestSmsImpl
    implements VerificationStartRequestSms,
        com.sinch.sdk.domains.verification.models.v1.start.request.VerificationStartRequest {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_IDENTITY = "identity";

  private OptionalValue<Identity> identity;

  public static final String JSON_PROPERTY_METHOD = "method";

  private OptionalValue<VerificationMethod> method;

  public static final String JSON_PROPERTY_REFERENCE = "reference";

  private OptionalValue<String> reference;

  public static final String JSON_PROPERTY_CUSTOM = "custom";

  private OptionalValue<String> custom;

  public static final String JSON_PROPERTY_SMS_OPTIONS = "smsOptions";

  private OptionalValue<VerificationStartSmsOptions> smsOptions;

  public VerificationStartRequestSmsImpl() {}

  protected VerificationStartRequestSmsImpl(
      OptionalValue<Identity> identity,
      OptionalValue<VerificationMethod> method,
      OptionalValue<String> reference,
      OptionalValue<String> custom,
      OptionalValue<VerificationStartSmsOptions> smsOptions) {
    this.identity = identity;
    this.method = method;
    this.reference = reference;
    this.custom = custom;
    this.smsOptions = smsOptions;
  }

  @JsonIgnore
  public Identity getIdentity() {
    return identity.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_IDENTITY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<Identity> identity() {
    return identity;
  }

  @JsonIgnore
  public VerificationMethod getMethod() {
    return method.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_METHOD)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<VerificationMethod> method() {
    return method;
  }

  @JsonIgnore
  public String getReference() {
    return reference.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> reference() {
    return reference;
  }

  @JsonIgnore
  public String getCustom() {
    return custom.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CUSTOM)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> custom() {
    return custom;
  }

  @JsonIgnore
  public VerificationStartSmsOptions getSmsOptions() {
    return smsOptions.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SMS_OPTIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<VerificationStartSmsOptions> smsOptions() {
    return smsOptions;
  }

  @JsonIgnore
  public String getExpiry() {
    if (null == smsOptions || !smsOptions.isPresent() || null == smsOptions.get().getExpiry()) {
      return null;
    }
    return smsOptions.get().getExpiry();
  }

  public OptionalValue<String> expiry() {
    return null != smsOptions && smsOptions.isPresent()
        ? smsOptions
            .map(f -> ((VerificationStartSmsOptionsImpl) f).expiry())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public CodeTypeEnum getCodeType() {
    if (null == smsOptions || !smsOptions.isPresent() || null == smsOptions.get().getCodeType()) {
      return null;
    }
    return CodeTypeEnum.from(smsOptions.get().getCodeType().value());
  }

  public OptionalValue<CodeTypeEnum> codeType() {
    return null != smsOptions && smsOptions.isPresent()
        ? smsOptions.map(f -> CodeTypeEnum.from(smsOptions.get().getCodeType().value()))
        : OptionalValue.empty();
  }

  @JsonIgnore
  public String getTemplate() {
    if (null == smsOptions || !smsOptions.isPresent() || null == smsOptions.get().getTemplate()) {
      return null;
    }
    return smsOptions.get().getTemplate();
  }

  public OptionalValue<String> template() {
    return null != smsOptions && smsOptions.isPresent()
        ? smsOptions
            .map(f -> ((VerificationStartSmsOptionsImpl) f).template())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public String getAcceptLanguage() {
    if (null == smsOptions
        || !smsOptions.isPresent()
        || null == smsOptions.get().getAcceptLanguage()) {
      return null;
    }
    return smsOptions.get().getAcceptLanguage();
  }

  public OptionalValue<String> acceptLanguage() {
    return null != smsOptions && smsOptions.isPresent()
        ? smsOptions
            .map(f -> ((VerificationStartSmsOptionsImpl) f).acceptLanguage())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public Object getExtraOption(String key) {
    return null != smsOptions && smsOptions.isPresent() ? smsOptions.get().get(key) : null;
  }

  /** Return true if this VerificationStartRequestSms object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VerificationStartRequestSmsImpl verificationStartRequestSms =
        (VerificationStartRequestSmsImpl) o;
    return Objects.equals(this.identity, verificationStartRequestSms.identity)
        && Objects.equals(this.method, verificationStartRequestSms.method)
        && Objects.equals(this.reference, verificationStartRequestSms.reference)
        && Objects.equals(this.custom, verificationStartRequestSms.custom)
        && Objects.equals(this.smsOptions, verificationStartRequestSms.smsOptions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(identity, method, reference, custom, smsOptions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VerificationStartRequestSmsImpl {\n");
    sb.append("    identity: ").append(toIndentedString(identity)).append("\n");
    sb.append("    method: ").append(toIndentedString(method)).append("\n");
    sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
    sb.append("    custom: ").append(toIndentedString(custom)).append("\n");
    sb.append("    smsOptions: ").append(toIndentedString(smsOptions)).append("\n");
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
  static class Builder implements VerificationStartRequestSms.Builder {
    OptionalValue<Identity> identity = OptionalValue.empty();
    OptionalValue<VerificationMethod> method = OptionalValue.of(VerificationMethod.SMS);
    OptionalValue<String> reference = OptionalValue.empty();
    OptionalValue<String> custom = OptionalValue.empty();
    OptionalValue<VerificationStartSmsOptions> smsOptions = OptionalValue.empty();

    VerificationStartSmsOptions.Builder _delegatedBuilder = null;

    @JsonProperty(JSON_PROPERTY_IDENTITY)
    public Builder setIdentity(Identity identity) {
      this.identity = OptionalValue.of(identity);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_REFERENCE)
    public Builder setReference(String reference) {
      this.reference = OptionalValue.of(reference);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CUSTOM)
    public Builder setCustom(String custom) {
      this.custom = OptionalValue.of(custom);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_SMS_OPTIONS)
    public Builder setSmsOptions(VerificationStartSmsOptions smsOptions) {
      this.smsOptions = OptionalValue.of(smsOptions);
      return this;
    }

    @JsonIgnore
    public Builder setExpiry(String expiry) {
      getDelegatedBuilder().setExpiry(expiry);
      return this;
    }

    @JsonIgnore
    public Builder setCodeType(CodeTypeEnum codeType) {
      getDelegatedBuilder()
          .setCodeType(
              null != codeType
                  ? VerificationStartSmsOptionsImpl.CodeTypeEnum.from(codeType.value())
                  : null);
      return this;
    }

    @JsonIgnore
    public Builder setTemplate(String template) {
      getDelegatedBuilder().setTemplate(template);
      return this;
    }

    @JsonIgnore
    public Builder setAcceptLanguage(String acceptLanguage) {
      getDelegatedBuilder().setAcceptLanguage(acceptLanguage);
      return this;
    }

    public Builder putExtraOption(String key, Object value) {
      getDelegatedBuilder().put(key, value);
      return this;
    }

    private VerificationStartSmsOptions.Builder getDelegatedBuilder() {
      if (null == _delegatedBuilder) {
        this._delegatedBuilder = VerificationStartSmsOptions.builder();
      }
      return this._delegatedBuilder;
    }

    public VerificationStartRequestSms build() {
      // delegated builder was used: filling the related source of delegation field
      if (null != this._delegatedBuilder) {
        this.smsOptions = OptionalValue.of(this._delegatedBuilder.build());
      }
      return new VerificationStartRequestSmsImpl(identity, method, reference, custom, smsOptions);
    }
  }

  public static class DelegatedSerializer
      extends JsonSerializer<OptionalValue<VerificationStartRequestSms>> {
    @Override
    public void serialize(
        OptionalValue<VerificationStartRequestSms> value,
        JsonGenerator jgen,
        SerializerProvider provider)
        throws IOException {

      if (!value.isPresent()) {
        return;
      }
      VerificationStartRequestSmsImpl impl = (VerificationStartRequestSmsImpl) value.get();
      jgen.writeObject(null != impl ? impl.getSmsOptions() : null);
    }
  }

  public static class DelegatedDeSerializer extends JsonDeserializer<VerificationStartRequestSms> {
    @Override
    public VerificationStartRequestSms deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException {

      VerificationStartRequestSmsImpl.Builder builder =
          new VerificationStartRequestSmsImpl.Builder();
      VerificationStartSmsOptionsImpl deserialized =
          jp.readValueAs(VerificationStartSmsOptionsImpl.class);
      builder.setSmsOptions(deserialized);
      return builder.build();
    }
  }

  public static Optional<VerificationStartRequestSms> delegatedConverter(
      VerificationStartSmsOptions internal) {
    if (null == internal) {
      return Optional.empty();
    }
    return Optional.of(new Builder().setSmsOptions(internal).build());
  }
}
