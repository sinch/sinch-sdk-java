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
import com.sinch.sdk.domains.verification.models.v1.start.internal.VerificationMethodStart;
import com.sinch.sdk.domains.verification.models.v1.start.request.internal.VerificationStartPhoneCallOptions;
import com.sinch.sdk.domains.verification.models.v1.start.request.internal.VerificationStartPhoneCallOptionsImpl;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

@JsonPropertyOrder({
  VerificationStartRequestPhoneCallImpl.JSON_PROPERTY_IDENTITY,
  VerificationStartRequestPhoneCallImpl.JSON_PROPERTY_METHOD,
  VerificationStartRequestPhoneCallImpl.JSON_PROPERTY_REFERENCE,
  VerificationStartRequestPhoneCallImpl.JSON_PROPERTY_CUSTOM,
  VerificationStartRequestPhoneCallImpl.JSON_PROPERTY_CALLOUT_OPTIONS
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class VerificationStartRequestPhoneCallImpl
    implements VerificationStartRequestPhoneCall,
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

  public static final String JSON_PROPERTY_CALLOUT_OPTIONS = "calloutOptions";

  private OptionalValue<VerificationStartPhoneCallOptions> calloutOptions;

  public VerificationStartRequestPhoneCallImpl() {}

  protected VerificationStartRequestPhoneCallImpl(
      OptionalValue<Identity> identity,
      OptionalValue<VerificationMethodStart> method,
      OptionalValue<String> reference,
      OptionalValue<String> custom,
      OptionalValue<VerificationStartPhoneCallOptions> calloutOptions) {
    this.identity = identity;
    this.method = method;
    this.reference = reference;
    this.custom = custom;
    this.calloutOptions = calloutOptions;
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
  public VerificationStartPhoneCallOptions getCalloutOptions() {
    return calloutOptions.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CALLOUT_OPTIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<VerificationStartPhoneCallOptions> calloutOptions() {
    return calloutOptions;
  }

  @JsonIgnore
  public PhoneCallSpeech getSpeech() {
    if (null == calloutOptions
        || !calloutOptions.isPresent()
        || null == calloutOptions.get().getSpeech()) {
      return null;
    }
    return calloutOptions.get().getSpeech();
  }

  public OptionalValue<PhoneCallSpeech> speech() {
    return null != calloutOptions && calloutOptions.isPresent()
        ? calloutOptions
            .map(f -> ((VerificationStartPhoneCallOptionsImpl) f).speech())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public Object getExtraOption(String key) {
    return null != calloutOptions && calloutOptions.isPresent()
        ? calloutOptions.get().get(key)
        : null;
  }

  /** Return true if this VerificationStartRequestPhoneCall object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VerificationStartRequestPhoneCallImpl verificationStartRequestPhoneCall =
        (VerificationStartRequestPhoneCallImpl) o;
    return Objects.equals(this.identity, verificationStartRequestPhoneCall.identity)
        && Objects.equals(this.method, verificationStartRequestPhoneCall.method)
        && Objects.equals(this.reference, verificationStartRequestPhoneCall.reference)
        && Objects.equals(this.custom, verificationStartRequestPhoneCall.custom)
        && Objects.equals(this.calloutOptions, verificationStartRequestPhoneCall.calloutOptions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(identity, method, reference, custom, calloutOptions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VerificationStartRequestPhoneCallImpl {\n");
    sb.append("    identity: ").append(toIndentedString(identity)).append("\n");
    sb.append("    method: ").append(toIndentedString(method)).append("\n");
    sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
    sb.append("    custom: ").append(toIndentedString(custom)).append("\n");
    sb.append("    calloutOptions: ").append(toIndentedString(calloutOptions)).append("\n");
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
  static class Builder implements VerificationStartRequestPhoneCall.Builder {
    OptionalValue<Identity> identity = OptionalValue.empty();
    OptionalValue<VerificationMethodStart> method =
        OptionalValue.of(VerificationMethodStart.PHONE_CALL);
    OptionalValue<String> reference = OptionalValue.empty();
    OptionalValue<String> custom = OptionalValue.empty();
    OptionalValue<VerificationStartPhoneCallOptions> calloutOptions = OptionalValue.empty();

    VerificationStartPhoneCallOptions.Builder _delegatedBuilder = null;

    @JsonProperty(value = JSON_PROPERTY_IDENTITY, required = true)
    public Builder setIdentity(Identity identity) {
      this.identity = OptionalValue.of(identity);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_METHOD, required = true)
    Builder setMethod(VerificationMethodStart method) {
      if (!Objects.equals(method, VerificationMethodStart.PHONE_CALL)) {
        throw new IllegalArgumentException(
            String.format(
                "'method' must be '%s' (is '%s')", VerificationMethodStart.PHONE_CALL, method));
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

    @JsonProperty(JSON_PROPERTY_CALLOUT_OPTIONS)
    public Builder setCalloutOptions(VerificationStartPhoneCallOptions calloutOptions) {
      this.calloutOptions = OptionalValue.of(calloutOptions);
      return this;
    }

    @JsonIgnore
    public Builder setSpeech(PhoneCallSpeech speech) {
      getDelegatedBuilder().setSpeech(speech);
      return this;
    }

    public Builder putExtraOption(String key, Object value) {
      getDelegatedBuilder().put(key, value);
      return this;
    }

    private VerificationStartPhoneCallOptions.Builder getDelegatedBuilder() {
      if (null == _delegatedBuilder) {
        this._delegatedBuilder = VerificationStartPhoneCallOptions.builder();
      }
      return this._delegatedBuilder;
    }

    public VerificationStartRequestPhoneCall build() {
      // delegated builder was used: filling the related source of delegation field
      if (null != this._delegatedBuilder) {
        this.calloutOptions = OptionalValue.of(this._delegatedBuilder.build());
      }
      return new VerificationStartRequestPhoneCallImpl(
          identity, method, reference, custom, calloutOptions);
    }
  }

  public static class DelegatedSerializer
      extends JsonSerializer<OptionalValue<VerificationStartRequestPhoneCall>> {
    @Override
    public void serialize(
        OptionalValue<VerificationStartRequestPhoneCall> value,
        JsonGenerator jgen,
        SerializerProvider provider)
        throws IOException {

      if (!value.isPresent()) {
        return;
      }
      VerificationStartRequestPhoneCallImpl impl =
          (VerificationStartRequestPhoneCallImpl) value.get();
      jgen.writeObject(null != impl ? impl.getCalloutOptions() : null);
    }
  }

  public static class DelegatedDeSerializer
      extends JsonDeserializer<VerificationStartRequestPhoneCall> {
    @Override
    public VerificationStartRequestPhoneCall deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException {

      VerificationStartRequestPhoneCallImpl.Builder builder =
          new VerificationStartRequestPhoneCallImpl.Builder();
      VerificationStartPhoneCallOptionsImpl deserialized =
          jp.readValueAs(VerificationStartPhoneCallOptionsImpl.class);
      builder.setCalloutOptions(deserialized);
      return builder.build();
    }
  }

  public static Optional<VerificationStartRequestPhoneCall> delegatedConverter(
      VerificationStartPhoneCallOptions internal) {
    if (null == internal) {
      return Optional.empty();
    }
    return Optional.of(new Builder().setCalloutOptions(internal).build());
  }
}
