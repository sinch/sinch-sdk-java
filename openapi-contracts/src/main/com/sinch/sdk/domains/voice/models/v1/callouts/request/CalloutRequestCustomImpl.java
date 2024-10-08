package com.sinch.sdk.domains.voice.models.v1.callouts.request;

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
import com.sinch.sdk.domains.voice.models.v1.Destination;
import com.sinch.sdk.domains.voice.models.v1.callouts.request.internal.CustomCalloutInternal;
import com.sinch.sdk.domains.voice.models.v1.callouts.request.internal.CustomCalloutInternalImpl;
import com.sinch.sdk.models.DualToneMultiFrequency;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

@JsonPropertyOrder({
  CalloutRequestCustomImpl.JSON_PROPERTY_METHOD,
  CalloutRequestCustomImpl.JSON_PROPERTY_CUSTOM_CALLOUT
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class CalloutRequestCustomImpl
    implements CalloutRequestCustom, com.sinch.sdk.domains.voice.models.v1.callouts.CalloutRequest {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_METHOD = "method";

  private OptionalValue<MethodEnum> method;

  public static final String JSON_PROPERTY_CUSTOM_CALLOUT = "customCallout";

  private OptionalValue<CustomCalloutInternal> customCallout;

  public CalloutRequestCustomImpl() {}

  protected CalloutRequestCustomImpl(
      OptionalValue<MethodEnum> method, OptionalValue<CustomCalloutInternal> customCallout) {
    this.method = method;
    this.customCallout = customCallout;
  }

  @JsonIgnore
  public MethodEnum getMethod() {
    return method.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_METHOD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<MethodEnum> method() {
    return method;
  }

  @JsonIgnore
  public CustomCalloutInternal getCustomCallout() {
    return customCallout.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CUSTOM_CALLOUT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<CustomCalloutInternal> customCallout() {
    return customCallout;
  }

  @JsonIgnore
  public String getCli() {
    if (null == customCallout
        || !customCallout.isPresent()
        || null == customCallout.get().getCli()) {
      return null;
    }
    return customCallout.get().getCli();
  }

  public OptionalValue<String> cli() {
    return null != customCallout && customCallout.isPresent()
        ? customCallout
            .map(f -> ((CustomCalloutInternalImpl) f).cli())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public Destination getDestination() {
    if (null == customCallout
        || !customCallout.isPresent()
        || null == customCallout.get().getDestination()) {
      return null;
    }
    return customCallout.get().getDestination();
  }

  public OptionalValue<Destination> destination() {
    return null != customCallout && customCallout.isPresent()
        ? customCallout
            .map(f -> ((CustomCalloutInternalImpl) f).destination())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public DualToneMultiFrequency getDtmf() {
    if (null == customCallout
        || !customCallout.isPresent()
        || null == customCallout.get().getDtmf()) {
      return null;
    }
    return customCallout.get().getDtmf();
  }

  public OptionalValue<DualToneMultiFrequency> dtmf() {
    return null != customCallout && customCallout.isPresent()
        ? customCallout
            .map(f -> ((CustomCalloutInternalImpl) f).dtmf())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public String getCustom() {
    if (null == customCallout
        || !customCallout.isPresent()
        || null == customCallout.get().getCustom()) {
      return null;
    }
    return customCallout.get().getCustom();
  }

  public OptionalValue<String> custom() {
    return null != customCallout && customCallout.isPresent()
        ? customCallout
            .map(f -> ((CustomCalloutInternalImpl) f).custom())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public Integer getMaxDuration() {
    if (null == customCallout
        || !customCallout.isPresent()
        || null == customCallout.get().getMaxDuration()) {
      return null;
    }
    return customCallout.get().getMaxDuration();
  }

  public OptionalValue<Integer> maxDuration() {
    return null != customCallout && customCallout.isPresent()
        ? customCallout
            .map(f -> ((CustomCalloutInternalImpl) f).maxDuration())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public String getIce() {
    if (null == customCallout
        || !customCallout.isPresent()
        || null == customCallout.get().getIce()) {
      return null;
    }
    return customCallout.get().getIce();
  }

  public OptionalValue<String> ice() {
    return null != customCallout && customCallout.isPresent()
        ? customCallout
            .map(f -> ((CustomCalloutInternalImpl) f).ice())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public String getAce() {
    if (null == customCallout
        || !customCallout.isPresent()
        || null == customCallout.get().getAce()) {
      return null;
    }
    return customCallout.get().getAce();
  }

  public OptionalValue<String> ace() {
    return null != customCallout && customCallout.isPresent()
        ? customCallout
            .map(f -> ((CustomCalloutInternalImpl) f).ace())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public String getPie() {
    if (null == customCallout
        || !customCallout.isPresent()
        || null == customCallout.get().getPie()) {
      return null;
    }
    return customCallout.get().getPie();
  }

  public OptionalValue<String> pie() {
    return null != customCallout && customCallout.isPresent()
        ? customCallout
            .map(f -> ((CustomCalloutInternalImpl) f).pie())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  /** Return true if this customCalloutRequest object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CalloutRequestCustomImpl customCalloutRequest = (CalloutRequestCustomImpl) o;
    return Objects.equals(this.method, customCalloutRequest.method)
        && Objects.equals(this.customCallout, customCalloutRequest.customCallout);
  }

  @Override
  public int hashCode() {
    return Objects.hash(method, customCallout);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CalloutRequestCustomImpl {\n");
    sb.append("    method: ").append(toIndentedString(method)).append("\n");
    sb.append("    customCallout: ").append(toIndentedString(customCallout)).append("\n");
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
  static class Builder implements CalloutRequestCustom.Builder {
    OptionalValue<MethodEnum> method = OptionalValue.of(MethodEnum.CUSTOM_CALLOUT);
    OptionalValue<CustomCalloutInternal> customCallout = OptionalValue.empty();

    CustomCalloutInternal.Builder _delegatedBuilder = null;

    @JsonProperty(JSON_PROPERTY_CUSTOM_CALLOUT)
    public Builder setCustomCallout(CustomCalloutInternal customCallout) {
      this.customCallout = OptionalValue.of(customCallout);
      return this;
    }

    @JsonIgnore
    public Builder setCli(String cli) {
      getDelegatedBuilder().setCli(cli);
      return this;
    }

    @JsonIgnore
    public Builder setDestination(Destination destination) {
      getDelegatedBuilder().setDestination(destination);
      return this;
    }

    @JsonIgnore
    public Builder setDtmf(DualToneMultiFrequency dtmf) {
      getDelegatedBuilder().setDtmf(dtmf);
      return this;
    }

    @JsonIgnore
    public Builder setCustom(String custom) {
      getDelegatedBuilder().setCustom(custom);
      return this;
    }

    @JsonIgnore
    public Builder setMaxDuration(Integer maxDuration) {
      getDelegatedBuilder().setMaxDuration(maxDuration);
      return this;
    }

    @JsonIgnore
    public Builder setIce(String ice) {
      getDelegatedBuilder().setIce(ice);
      return this;
    }

    @JsonIgnore
    public Builder setAce(String ace) {
      getDelegatedBuilder().setAce(ace);
      return this;
    }

    @JsonIgnore
    public Builder setPie(String pie) {
      getDelegatedBuilder().setPie(pie);
      return this;
    }

    private CustomCalloutInternal.Builder getDelegatedBuilder() {
      if (null == _delegatedBuilder) {
        this._delegatedBuilder = CustomCalloutInternal.builder();
      }
      return this._delegatedBuilder;
    }

    public CalloutRequestCustom build() {
      // delegated builder was used: filling the related source of delegation field
      if (null != this._delegatedBuilder) {
        this.customCallout = OptionalValue.of(this._delegatedBuilder.build());
      }
      return new CalloutRequestCustomImpl(method, customCallout);
    }
  }

  public static class DelegatedSerializer
      extends JsonSerializer<OptionalValue<CalloutRequestCustom>> {
    @Override
    public void serialize(
        OptionalValue<CalloutRequestCustom> value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException {

      if (!value.isPresent()) {
        return;
      }
      CalloutRequestCustomImpl impl = (CalloutRequestCustomImpl) value.get();
      jgen.writeObject(null != impl ? impl.getCustomCallout() : null);
    }
  }

  public static class DelegatedDeSerializer extends JsonDeserializer<CalloutRequestCustom> {
    @Override
    public CalloutRequestCustom deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException {

      CalloutRequestCustomImpl.Builder builder = new CalloutRequestCustomImpl.Builder();
      CustomCalloutInternalImpl deserialized = jp.readValueAs(CustomCalloutInternalImpl.class);
      builder.setCustomCallout(deserialized);
      return builder.build();
    }
  }

  public static Optional<CalloutRequestCustom> delegatedConverter(CustomCalloutInternal internal) {
    if (null == internal) {
      return Optional.empty();
    }
    return Optional.of(new Builder().setCustomCallout(internal).build());
  }
}
