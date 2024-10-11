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
import com.sinch.sdk.domains.voice.models.v1.Domain;
import com.sinch.sdk.domains.voice.models.v1.callouts.request.internal.TtsCalloutInternal;
import com.sinch.sdk.domains.voice.models.v1.callouts.request.internal.TtsCalloutInternalImpl;
import com.sinch.sdk.models.DualToneMultiFrequency;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

@JsonPropertyOrder({
  CalloutRequestTTSImpl.JSON_PROPERTY_METHOD,
  CalloutRequestTTSImpl.JSON_PROPERTY_TTS_CALLOUT
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class CalloutRequestTTSImpl
    implements CalloutRequestTTS,
        com.sinch.sdk.domains.voice.models.v1.callouts.request.CalloutRequest {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_METHOD = "method";

  private OptionalValue<MethodEnum> method;

  public static final String JSON_PROPERTY_TTS_CALLOUT = "ttsCallout";

  private OptionalValue<TtsCalloutInternal> ttsCallout;

  public CalloutRequestTTSImpl() {}

  protected CalloutRequestTTSImpl(
      OptionalValue<MethodEnum> method, OptionalValue<TtsCalloutInternal> ttsCallout) {
    this.method = method;
    this.ttsCallout = ttsCallout;
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
  public TtsCalloutInternal getTtsCallout() {
    return ttsCallout.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TTS_CALLOUT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<TtsCalloutInternal> ttsCallout() {
    return ttsCallout;
  }

  @JsonIgnore
  public String getCli() {
    if (null == ttsCallout || !ttsCallout.isPresent() || null == ttsCallout.get().getCli()) {
      return null;
    }
    return ttsCallout.get().getCli();
  }

  public OptionalValue<String> cli() {
    return null != ttsCallout && ttsCallout.isPresent()
        ? ttsCallout.map(f -> ((TtsCalloutInternalImpl) f).cli()).orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public Destination getDestination() {
    if (null == ttsCallout
        || !ttsCallout.isPresent()
        || null == ttsCallout.get().getDestination()) {
      return null;
    }
    return ttsCallout.get().getDestination();
  }

  public OptionalValue<Destination> destination() {
    return null != ttsCallout && ttsCallout.isPresent()
        ? ttsCallout
            .map(f -> ((TtsCalloutInternalImpl) f).destination())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public DualToneMultiFrequency getDtmf() {
    if (null == ttsCallout || !ttsCallout.isPresent() || null == ttsCallout.get().getDtmf()) {
      return null;
    }
    return ttsCallout.get().getDtmf();
  }

  public OptionalValue<DualToneMultiFrequency> dtmf() {
    return null != ttsCallout && ttsCallout.isPresent()
        ? ttsCallout.map(f -> ((TtsCalloutInternalImpl) f).dtmf()).orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public Domain getDomain() {
    if (null == ttsCallout || !ttsCallout.isPresent() || null == ttsCallout.get().getDomain()) {
      return null;
    }
    return ttsCallout.get().getDomain();
  }

  public OptionalValue<Domain> domain() {
    return null != ttsCallout && ttsCallout.isPresent()
        ? ttsCallout.map(f -> ((TtsCalloutInternalImpl) f).domain()).orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public String getCustom() {
    if (null == ttsCallout || !ttsCallout.isPresent() || null == ttsCallout.get().getCustom()) {
      return null;
    }
    return ttsCallout.get().getCustom();
  }

  public OptionalValue<String> custom() {
    return null != ttsCallout && ttsCallout.isPresent()
        ? ttsCallout.map(f -> ((TtsCalloutInternalImpl) f).custom()).orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public String getLocale() {
    if (null == ttsCallout || !ttsCallout.isPresent() || null == ttsCallout.get().getLocale()) {
      return null;
    }
    return ttsCallout.get().getLocale();
  }

  public OptionalValue<String> locale() {
    return null != ttsCallout && ttsCallout.isPresent()
        ? ttsCallout.map(f -> ((TtsCalloutInternalImpl) f).locale()).orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public String getText() {
    if (null == ttsCallout || !ttsCallout.isPresent() || null == ttsCallout.get().getText()) {
      return null;
    }
    return ttsCallout.get().getText();
  }

  public OptionalValue<String> text() {
    return null != ttsCallout && ttsCallout.isPresent()
        ? ttsCallout.map(f -> ((TtsCalloutInternalImpl) f).text()).orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public String getPrompts() {
    if (null == ttsCallout || !ttsCallout.isPresent() || null == ttsCallout.get().getPrompts()) {
      return null;
    }
    return ttsCallout.get().getPrompts();
  }

  public OptionalValue<String> prompts() {
    return null != ttsCallout && ttsCallout.isPresent()
        ? ttsCallout.map(f -> ((TtsCalloutInternalImpl) f).prompts()).orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public Boolean getEnableAce() {
    if (null == ttsCallout || !ttsCallout.isPresent() || null == ttsCallout.get().getEnableAce()) {
      return null;
    }
    return ttsCallout.get().getEnableAce();
  }

  public OptionalValue<Boolean> enableAce() {
    return null != ttsCallout && ttsCallout.isPresent()
        ? ttsCallout
            .map(f -> ((TtsCalloutInternalImpl) f).enableAce())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public Boolean getEnableDice() {
    if (null == ttsCallout || !ttsCallout.isPresent() || null == ttsCallout.get().getEnableDice()) {
      return null;
    }
    return ttsCallout.get().getEnableDice();
  }

  public OptionalValue<Boolean> enableDice() {
    return null != ttsCallout && ttsCallout.isPresent()
        ? ttsCallout
            .map(f -> ((TtsCalloutInternalImpl) f).enableDice())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public Boolean getEnablePie() {
    if (null == ttsCallout || !ttsCallout.isPresent() || null == ttsCallout.get().getEnablePie()) {
      return null;
    }
    return ttsCallout.get().getEnablePie();
  }

  public OptionalValue<Boolean> enablePie() {
    return null != ttsCallout && ttsCallout.isPresent()
        ? ttsCallout
            .map(f -> ((TtsCalloutInternalImpl) f).enablePie())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  /** Return true if this ttsCalloutRequest object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CalloutRequestTTSImpl ttsCalloutRequest = (CalloutRequestTTSImpl) o;
    return Objects.equals(this.method, ttsCalloutRequest.method)
        && Objects.equals(this.ttsCallout, ttsCalloutRequest.ttsCallout);
  }

  @Override
  public int hashCode() {
    return Objects.hash(method, ttsCallout);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CalloutRequestTTSImpl {\n");
    sb.append("    method: ").append(toIndentedString(method)).append("\n");
    sb.append("    ttsCallout: ").append(toIndentedString(ttsCallout)).append("\n");
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
  static class Builder implements CalloutRequestTTS.Builder {
    OptionalValue<MethodEnum> method = OptionalValue.of(MethodEnum.TTS_CALLOUT);
    OptionalValue<TtsCalloutInternal> ttsCallout = OptionalValue.empty();

    TtsCalloutInternal.Builder _delegatedBuilder = null;

    @JsonProperty(JSON_PROPERTY_TTS_CALLOUT)
    public Builder setTtsCallout(TtsCalloutInternal ttsCallout) {
      this.ttsCallout = OptionalValue.of(ttsCallout);
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
    public Builder setDomain(Domain domain) {
      getDelegatedBuilder().setDomain(domain);
      return this;
    }

    @JsonIgnore
    public Builder setCustom(String custom) {
      getDelegatedBuilder().setCustom(custom);
      return this;
    }

    @JsonIgnore
    public Builder setLocale(String locale) {
      getDelegatedBuilder().setLocale(locale);
      return this;
    }

    @JsonIgnore
    public Builder setText(String text) {
      getDelegatedBuilder().setText(text);
      return this;
    }

    @JsonIgnore
    public Builder setPrompts(String prompts) {
      getDelegatedBuilder().setPrompts(prompts);
      return this;
    }

    @JsonIgnore
    public Builder setEnableAce(Boolean enableAce) {
      getDelegatedBuilder().setEnableAce(enableAce);
      return this;
    }

    @JsonIgnore
    public Builder setEnableDice(Boolean enableDice) {
      getDelegatedBuilder().setEnableDice(enableDice);
      return this;
    }

    @JsonIgnore
    public Builder setEnablePie(Boolean enablePie) {
      getDelegatedBuilder().setEnablePie(enablePie);
      return this;
    }

    private TtsCalloutInternal.Builder getDelegatedBuilder() {
      if (null == _delegatedBuilder) {
        this._delegatedBuilder = TtsCalloutInternal.builder();
      }
      return this._delegatedBuilder;
    }

    public CalloutRequestTTS build() {
      // delegated builder was used: filling the related source of delegation field
      if (null != this._delegatedBuilder) {
        this.ttsCallout = OptionalValue.of(this._delegatedBuilder.build());
      }
      return new CalloutRequestTTSImpl(method, ttsCallout);
    }
  }

  public static class DelegatedSerializer extends JsonSerializer<OptionalValue<CalloutRequestTTS>> {
    @Override
    public void serialize(
        OptionalValue<CalloutRequestTTS> value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException {

      if (!value.isPresent()) {
        return;
      }
      CalloutRequestTTSImpl impl = (CalloutRequestTTSImpl) value.get();
      jgen.writeObject(null != impl ? impl.getTtsCallout() : null);
    }
  }

  public static class DelegatedDeSerializer extends JsonDeserializer<CalloutRequestTTS> {
    @Override
    public CalloutRequestTTS deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException {

      CalloutRequestTTSImpl.Builder builder = new CalloutRequestTTSImpl.Builder();
      TtsCalloutInternalImpl deserialized = jp.readValueAs(TtsCalloutInternalImpl.class);
      builder.setTtsCallout(deserialized);
      return builder.build();
    }
  }

  public static Optional<CalloutRequestTTS> delegatedConverter(TtsCalloutInternal internal) {
    if (null == internal) {
      return Optional.empty();
    }
    return Optional.of(new Builder().setTtsCallout(internal).build());
  }
}
