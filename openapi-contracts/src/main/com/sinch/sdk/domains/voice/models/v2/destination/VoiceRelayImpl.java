package com.sinch.sdk.domains.voice.models.v2.destination;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import com.sinch.sdk.domains.voice.models.v2.destination.internal.VoiceRelayInternal;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({VoiceRelayImpl.JSON_PROPERTY_TYPE, VoiceRelayImpl.JSON_PROPERTY_VOICE_RELAY})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class VoiceRelayImpl implements VoiceRelay, CallDestination {
  private static final long serialVersionUID = 1L;

  /** The type property. Must have the value <code>VOICE_RELAY</code>. */
  public static class TypeEnum extends EnumDynamic<String, TypeEnum> {
    /** The <code>VOICE_RELAY</code> type. */
    public static final TypeEnum VOICE_RELAY = new TypeEnum("VOICE_RELAY");

    private static final EnumSupportDynamic<String, TypeEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(TypeEnum.class, TypeEnum::new, Arrays.asList(VOICE_RELAY));

    private TypeEnum(String value) {
      super(value);
    }

    public static java.util.stream.Stream<TypeEnum> values() {
      return ENUM_SUPPORT.values();
    }

    public static TypeEnum from(String value) {
      return ENUM_SUPPORT.from(value);
    }

    public static String valueOf(TypeEnum e) {
      return ENUM_SUPPORT.valueOf(e);
    }
  }

  public static final String JSON_PROPERTY_TYPE = "type";

  private OptionalValue<TypeEnum> type;

  public static final String JSON_PROPERTY_VOICE_RELAY = "voiceRelay";

  private OptionalValue<VoiceRelayInternal> voiceRelay;

  public VoiceRelayImpl() {}

  protected VoiceRelayImpl(
      OptionalValue<TypeEnum> type, OptionalValue<VoiceRelayInternal> voiceRelay) {
    this.type = type;
    this.voiceRelay = voiceRelay;
  }

  @JsonIgnore
  public TypeEnum getType() {
    return type.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<TypeEnum> type() {
    return type;
  }

  @JsonIgnore
  public VoiceRelayInternal getVoiceRelay() {
    return voiceRelay.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_VOICE_RELAY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<VoiceRelayInternal> voiceRelay() {
    return voiceRelay;
  }

  @JsonIgnore
  public String getEndpoint() {
    if (null == voiceRelay || !voiceRelay.isPresent() || null == voiceRelay.get().getEndpoint()) {
      return null;
    }
    return voiceRelay.get().getEndpoint();
  }

  @JsonIgnore
  public Boolean getEnableInterruptions() {
    if (null == voiceRelay
        || !voiceRelay.isPresent()
        || null == voiceRelay.get().getEnableInterruptions()) {
      return null;
    }
    return voiceRelay.get().getEnableInterruptions();
  }

  @JsonIgnore
  public String getTtsVoice() {
    if (null == voiceRelay || !voiceRelay.isPresent() || null == voiceRelay.get().getTtsVoice()) {
      return null;
    }
    return voiceRelay.get().getTtsVoice();
  }

  @JsonIgnore
  public String getSttLanguage() {
    if (null == voiceRelay
        || !voiceRelay.isPresent()
        || null == voiceRelay.get().getSttLanguage()) {
      return null;
    }
    return voiceRelay.get().getSttLanguage();
  }

  @JsonIgnore
  public List<CallHeader> getCallHeaders() {
    if (null == voiceRelay
        || !voiceRelay.isPresent()
        || null == voiceRelay.get().getCallHeaders()) {
      return null;
    }
    return voiceRelay.get().getCallHeaders();
  }

  /** Return true if this VoiceRelay object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VoiceRelayImpl voiceRelay = (VoiceRelayImpl) o;
    return Objects.equals(this.type, voiceRelay.type)
        && Objects.equals(this.voiceRelay, voiceRelay.voiceRelay);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, voiceRelay);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VoiceRelayImpl {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    voiceRelay: ").append(toIndentedString(voiceRelay)).append("\n");
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
  static class Builder implements VoiceRelay.Builder {
    OptionalValue<TypeEnum> type = OptionalValue.of(TypeEnum.VOICE_RELAY);
    OptionalValue<VoiceRelayInternal> voiceRelay = OptionalValue.empty();

    VoiceRelayInternal.Builder _delegatedBuilder = null;

    @JsonProperty(value = JSON_PROPERTY_TYPE, required = true)
    Builder setType(TypeEnum type) {
      if (!Objects.equals(type, TypeEnum.VOICE_RELAY)) {
        throw new IllegalArgumentException(
            String.format("'type' must be '%s' (is '%s')", TypeEnum.VOICE_RELAY, type));
      }
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_VOICE_RELAY, required = true)
    public Builder setVoiceRelay(VoiceRelayInternal voiceRelay) {
      this.voiceRelay = OptionalValue.of(voiceRelay);
      return this;
    }

    @JsonIgnore
    public Builder setEndpoint(String endpoint) {
      getDelegatedBuilder().setEndpoint(endpoint);
      return this;
    }

    @JsonIgnore
    public Builder setEnableInterruptions(Boolean enableInterruptions) {
      getDelegatedBuilder().setEnableInterruptions(enableInterruptions);
      return this;
    }

    @JsonIgnore
    public Builder setTtsVoice(String ttsVoice) {
      getDelegatedBuilder().setTtsVoice(ttsVoice);
      return this;
    }

    @JsonIgnore
    public Builder setSttLanguage(String sttLanguage) {
      getDelegatedBuilder().setSttLanguage(sttLanguage);
      return this;
    }

    @JsonIgnore
    public Builder setCallHeaders(List<CallHeader> callHeaders) {
      getDelegatedBuilder().setCallHeaders(callHeaders);
      return this;
    }

    private VoiceRelayInternal.Builder getDelegatedBuilder() {
      if (null == _delegatedBuilder) {
        this._delegatedBuilder = VoiceRelayInternal.builder();
      }
      return this._delegatedBuilder;
    }

    public VoiceRelay build() {
      // delegated builder was used: filling the related source of delegation field
      if (null != this._delegatedBuilder) {
        this.voiceRelay = OptionalValue.of(this._delegatedBuilder.build());
      }
      return new VoiceRelayImpl(type, voiceRelay);
    }
  }
}
