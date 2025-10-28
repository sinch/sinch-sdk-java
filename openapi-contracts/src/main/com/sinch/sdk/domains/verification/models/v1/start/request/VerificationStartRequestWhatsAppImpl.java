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
import com.sinch.sdk.domains.verification.models.v1.WhatsAppCodeType;
import com.sinch.sdk.domains.verification.models.v1.start.internal.VerificationMethodStart;
import com.sinch.sdk.domains.verification.models.v1.start.request.internal.VerificationStartWhatsAppOptions;
import com.sinch.sdk.domains.verification.models.v1.start.request.internal.VerificationStartWhatsAppOptionsImpl;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

@JsonPropertyOrder({
  VerificationStartRequestWhatsAppImpl.JSON_PROPERTY_IDENTITY,
  VerificationStartRequestWhatsAppImpl.JSON_PROPERTY_METHOD,
  VerificationStartRequestWhatsAppImpl.JSON_PROPERTY_REFERENCE,
  VerificationStartRequestWhatsAppImpl.JSON_PROPERTY_CUSTOM,
  VerificationStartRequestWhatsAppImpl.JSON_PROPERTY_WHATSAPP_OPTIONS
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class VerificationStartRequestWhatsAppImpl
    implements VerificationStartRequestWhatsApp,
        com.sinch.sdk.domains.verification.models.v1.start.request.VerificationStartRequest {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_IDENTITY = "identity";

  private OptionalValue<Identity> identity;

  public static final String JSON_PROPERTY_METHOD = "method";

  private OptionalValue<VerificationMethodStart> method;

  public static final String JSON_PROPERTY_REFERENCE = "reference";

  private OptionalValue<String> reference;

  public static final String JSON_PROPERTY_CUSTOM = "custom";

  private OptionalValue<String> custom;

  public static final String JSON_PROPERTY_WHATSAPP_OPTIONS = "whatsappOptions";

  private OptionalValue<VerificationStartWhatsAppOptions> whatsappOptions;

  public VerificationStartRequestWhatsAppImpl() {}

  protected VerificationStartRequestWhatsAppImpl(
      OptionalValue<Identity> identity,
      OptionalValue<VerificationMethodStart> method,
      OptionalValue<String> reference,
      OptionalValue<String> custom,
      OptionalValue<VerificationStartWhatsAppOptions> whatsappOptions) {
    this.identity = identity;
    this.method = method;
    this.reference = reference;
    this.custom = custom;
    this.whatsappOptions = whatsappOptions;
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
  public VerificationMethodStart getMethod() {
    return method.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_METHOD)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<VerificationMethodStart> method() {
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
  public VerificationStartWhatsAppOptions getWhatsappOptions() {
    return whatsappOptions.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_WHATSAPP_OPTIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<VerificationStartWhatsAppOptions> whatsappOptions() {
    return whatsappOptions;
  }

  @JsonIgnore
  public WhatsAppCodeType getCodeType() {
    if (null == whatsappOptions
        || !whatsappOptions.isPresent()
        || null == whatsappOptions.get().getCodeType()) {
      return null;
    }
    return whatsappOptions.get().getCodeType();
  }

  public OptionalValue<WhatsAppCodeType> codeType() {
    return null != whatsappOptions && whatsappOptions.isPresent()
        ? whatsappOptions
            .map(f -> ((VerificationStartWhatsAppOptionsImpl) f).codeType())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public Object getExtraOption(String key) {
    return null != whatsappOptions && whatsappOptions.isPresent()
        ? whatsappOptions.get().get(key)
        : null;
  }

  /** Return true if this VerificationStartRequestWhatsApp object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VerificationStartRequestWhatsAppImpl verificationStartRequestWhatsApp =
        (VerificationStartRequestWhatsAppImpl) o;
    return Objects.equals(this.identity, verificationStartRequestWhatsApp.identity)
        && Objects.equals(this.method, verificationStartRequestWhatsApp.method)
        && Objects.equals(this.reference, verificationStartRequestWhatsApp.reference)
        && Objects.equals(this.custom, verificationStartRequestWhatsApp.custom)
        && Objects.equals(this.whatsappOptions, verificationStartRequestWhatsApp.whatsappOptions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(identity, method, reference, custom, whatsappOptions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VerificationStartRequestWhatsAppImpl {\n");
    sb.append("    identity: ").append(toIndentedString(identity)).append("\n");
    sb.append("    method: ").append(toIndentedString(method)).append("\n");
    sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
    sb.append("    custom: ").append(toIndentedString(custom)).append("\n");
    sb.append("    whatsappOptions: ").append(toIndentedString(whatsappOptions)).append("\n");
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
  static class Builder implements VerificationStartRequestWhatsApp.Builder {
    OptionalValue<Identity> identity = OptionalValue.empty();
    OptionalValue<VerificationMethodStart> method =
        OptionalValue.of(VerificationMethodStart.WHATSAPP);
    OptionalValue<String> reference = OptionalValue.empty();
    OptionalValue<String> custom = OptionalValue.empty();
    OptionalValue<VerificationStartWhatsAppOptions> whatsappOptions = OptionalValue.empty();

    VerificationStartWhatsAppOptions.Builder _delegatedBuilder = null;

    @JsonProperty(value = JSON_PROPERTY_IDENTITY, required = true)
    public Builder setIdentity(Identity identity) {
      this.identity = OptionalValue.of(identity);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_METHOD, required = true)
    Builder setMethod(VerificationMethodStart method) {
      if (!Objects.equals(method, VerificationMethodStart.WHATSAPP)) {
        throw new IllegalArgumentException(
            String.format(
                "'method' must be '%s' (is '%s')", VerificationMethodStart.WHATSAPP, method));
      }
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

    @JsonProperty(JSON_PROPERTY_WHATSAPP_OPTIONS)
    public Builder setWhatsappOptions(VerificationStartWhatsAppOptions whatsappOptions) {
      this.whatsappOptions = OptionalValue.of(whatsappOptions);
      return this;
    }

    @JsonIgnore
    public Builder setCodeType(WhatsAppCodeType codeType) {
      getDelegatedBuilder().setCodeType(codeType);
      return this;
    }

    public Builder putExtraOption(String key, Object value) {
      getDelegatedBuilder().put(key, value);
      return this;
    }

    private VerificationStartWhatsAppOptions.Builder getDelegatedBuilder() {
      if (null == _delegatedBuilder) {
        this._delegatedBuilder = VerificationStartWhatsAppOptions.builder();
      }
      return this._delegatedBuilder;
    }

    public VerificationStartRequestWhatsApp build() {
      // delegated builder was used: filling the related source of delegation field
      if (null != this._delegatedBuilder) {
        this.whatsappOptions = OptionalValue.of(this._delegatedBuilder.build());
      }
      return new VerificationStartRequestWhatsAppImpl(
          identity, method, reference, custom, whatsappOptions);
    }
  }

  public static class DelegatedSerializer
      extends JsonSerializer<OptionalValue<VerificationStartRequestWhatsApp>> {
    @Override
    public void serialize(
        OptionalValue<VerificationStartRequestWhatsApp> value,
        JsonGenerator jgen,
        SerializerProvider provider)
        throws IOException {

      if (!value.isPresent()) {
        return;
      }
      VerificationStartRequestWhatsAppImpl impl =
          (VerificationStartRequestWhatsAppImpl) value.get();
      jgen.writeObject(null != impl ? impl.getWhatsappOptions() : null);
    }
  }

  public static class DelegatedDeSerializer
      extends JsonDeserializer<VerificationStartRequestWhatsApp> {
    @Override
    public VerificationStartRequestWhatsApp deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException {

      VerificationStartRequestWhatsAppImpl.Builder builder =
          new VerificationStartRequestWhatsAppImpl.Builder();
      VerificationStartWhatsAppOptionsImpl deserialized =
          jp.readValueAs(VerificationStartWhatsAppOptionsImpl.class);
      builder.setWhatsappOptions(deserialized);
      return builder.build();
    }
  }

  public static Optional<VerificationStartRequestWhatsApp> delegatedConverter(
      VerificationStartWhatsAppOptions internal) {
    if (null == internal) {
      return Optional.empty();
    }
    return Optional.of(new Builder().setWhatsappOptions(internal).build());
  }
}
