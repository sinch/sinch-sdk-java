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
import com.sinch.sdk.domains.voice.models.v1.Domain;
import com.sinch.sdk.domains.voice.models.v1.MusicOnHold;
import com.sinch.sdk.domains.voice.models.v1.callouts.request.internal.ConferenceCalloutInternal;
import com.sinch.sdk.domains.voice.models.v1.callouts.request.internal.ConferenceCalloutInternalImpl;
import com.sinch.sdk.domains.voice.models.v1.conferences.ConferenceDtmfOptions;
import com.sinch.sdk.domains.voice.models.v1.destination.DestinationConference;
import com.sinch.sdk.models.DualToneMultiFrequency;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

@JsonPropertyOrder({
  CalloutRequestConferenceImpl.JSON_PROPERTY_METHOD,
  CalloutRequestConferenceImpl.JSON_PROPERTY_CONFERENCE_CALLOUT
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class CalloutRequestConferenceImpl
    implements CalloutRequestConference,
        com.sinch.sdk.domains.voice.models.v1.callouts.request.CalloutRequest {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_METHOD = "method";

  private OptionalValue<MethodEnum> method;

  public static final String JSON_PROPERTY_CONFERENCE_CALLOUT = "conferenceCallout";

  private OptionalValue<ConferenceCalloutInternal> conferenceCallout;

  public CalloutRequestConferenceImpl() {}

  protected CalloutRequestConferenceImpl(
      OptionalValue<MethodEnum> method,
      OptionalValue<ConferenceCalloutInternal> conferenceCallout) {
    this.method = method;
    this.conferenceCallout = conferenceCallout;
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
  public ConferenceCalloutInternal getConferenceCallout() {
    return conferenceCallout.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CONFERENCE_CALLOUT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ConferenceCalloutInternal> conferenceCallout() {
    return conferenceCallout;
  }

  @JsonIgnore
  public String getCli() {
    if (null == conferenceCallout
        || !conferenceCallout.isPresent()
        || null == conferenceCallout.get().getCli()) {
      return null;
    }
    return conferenceCallout.get().getCli();
  }

  public OptionalValue<String> cli() {
    return null != conferenceCallout && conferenceCallout.isPresent()
        ? conferenceCallout
            .map(f -> ((ConferenceCalloutInternalImpl) f).cli())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public DualToneMultiFrequency getDtmf() {
    if (null == conferenceCallout
        || !conferenceCallout.isPresent()
        || null == conferenceCallout.get().getDtmf()) {
      return null;
    }
    return conferenceCallout.get().getDtmf();
  }

  public OptionalValue<DualToneMultiFrequency> dtmf() {
    return null != conferenceCallout && conferenceCallout.isPresent()
        ? conferenceCallout
            .map(f -> ((ConferenceCalloutInternalImpl) f).dtmf())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public String getCustom() {
    if (null == conferenceCallout
        || !conferenceCallout.isPresent()
        || null == conferenceCallout.get().getCustom()) {
      return null;
    }
    return conferenceCallout.get().getCustom();
  }

  public OptionalValue<String> custom() {
    return null != conferenceCallout && conferenceCallout.isPresent()
        ? conferenceCallout
            .map(f -> ((ConferenceCalloutInternalImpl) f).custom())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public DestinationConference getDestination() {
    if (null == conferenceCallout
        || !conferenceCallout.isPresent()
        || null == conferenceCallout.get().getDestination()) {
      return null;
    }
    return conferenceCallout.get().getDestination();
  }

  public OptionalValue<DestinationConference> destination() {
    return null != conferenceCallout && conferenceCallout.isPresent()
        ? conferenceCallout
            .map(f -> ((ConferenceCalloutInternalImpl) f).destination())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public String getConferenceId() {
    if (null == conferenceCallout
        || !conferenceCallout.isPresent()
        || null == conferenceCallout.get().getConferenceId()) {
      return null;
    }
    return conferenceCallout.get().getConferenceId();
  }

  public OptionalValue<String> conferenceId() {
    return null != conferenceCallout && conferenceCallout.isPresent()
        ? conferenceCallout
            .map(f -> ((ConferenceCalloutInternalImpl) f).conferenceId())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public ConferenceDtmfOptions getConferenceDtmfOptions() {
    if (null == conferenceCallout
        || !conferenceCallout.isPresent()
        || null == conferenceCallout.get().getConferenceDtmfOptions()) {
      return null;
    }
    return conferenceCallout.get().getConferenceDtmfOptions();
  }

  public OptionalValue<ConferenceDtmfOptions> conferenceDtmfOptions() {
    return null != conferenceCallout && conferenceCallout.isPresent()
        ? conferenceCallout
            .map(f -> ((ConferenceCalloutInternalImpl) f).conferenceDtmfOptions())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public Integer getMaxDuration() {
    if (null == conferenceCallout
        || !conferenceCallout.isPresent()
        || null == conferenceCallout.get().getMaxDuration()) {
      return null;
    }
    return conferenceCallout.get().getMaxDuration();
  }

  public OptionalValue<Integer> maxDuration() {
    return null != conferenceCallout && conferenceCallout.isPresent()
        ? conferenceCallout
            .map(f -> ((ConferenceCalloutInternalImpl) f).maxDuration())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public Boolean getEnableAce() {
    if (null == conferenceCallout
        || !conferenceCallout.isPresent()
        || null == conferenceCallout.get().getEnableAce()) {
      return null;
    }
    return conferenceCallout.get().getEnableAce();
  }

  public OptionalValue<Boolean> enableAce() {
    return null != conferenceCallout && conferenceCallout.isPresent()
        ? conferenceCallout
            .map(f -> ((ConferenceCalloutInternalImpl) f).enableAce())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public Boolean getEnableDice() {
    if (null == conferenceCallout
        || !conferenceCallout.isPresent()
        || null == conferenceCallout.get().getEnableDice()) {
      return null;
    }
    return conferenceCallout.get().getEnableDice();
  }

  public OptionalValue<Boolean> enableDice() {
    return null != conferenceCallout && conferenceCallout.isPresent()
        ? conferenceCallout
            .map(f -> ((ConferenceCalloutInternalImpl) f).enableDice())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public Boolean getEnablePie() {
    if (null == conferenceCallout
        || !conferenceCallout.isPresent()
        || null == conferenceCallout.get().getEnablePie()) {
      return null;
    }
    return conferenceCallout.get().getEnablePie();
  }

  public OptionalValue<Boolean> enablePie() {
    return null != conferenceCallout && conferenceCallout.isPresent()
        ? conferenceCallout
            .map(f -> ((ConferenceCalloutInternalImpl) f).enablePie())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public String getLocale() {
    if (null == conferenceCallout
        || !conferenceCallout.isPresent()
        || null == conferenceCallout.get().getLocale()) {
      return null;
    }
    return conferenceCallout.get().getLocale();
  }

  public OptionalValue<String> locale() {
    return null != conferenceCallout && conferenceCallout.isPresent()
        ? conferenceCallout
            .map(f -> ((ConferenceCalloutInternalImpl) f).locale())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public String getGreeting() {
    if (null == conferenceCallout
        || !conferenceCallout.isPresent()
        || null == conferenceCallout.get().getGreeting()) {
      return null;
    }
    return conferenceCallout.get().getGreeting();
  }

  public OptionalValue<String> greeting() {
    return null != conferenceCallout && conferenceCallout.isPresent()
        ? conferenceCallout
            .map(f -> ((ConferenceCalloutInternalImpl) f).greeting())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public MusicOnHold getMusicOnHold() {
    if (null == conferenceCallout
        || !conferenceCallout.isPresent()
        || null == conferenceCallout.get().getMusicOnHold()) {
      return null;
    }
    return conferenceCallout.get().getMusicOnHold();
  }

  public OptionalValue<MusicOnHold> musicOnHold() {
    return null != conferenceCallout && conferenceCallout.isPresent()
        ? conferenceCallout
            .map(f -> ((ConferenceCalloutInternalImpl) f).musicOnHold())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public Domain getDomain() {
    if (null == conferenceCallout
        || !conferenceCallout.isPresent()
        || null == conferenceCallout.get().getDomain()) {
      return null;
    }
    return conferenceCallout.get().getDomain();
  }

  public OptionalValue<Domain> domain() {
    return null != conferenceCallout && conferenceCallout.isPresent()
        ? conferenceCallout
            .map(f -> ((ConferenceCalloutInternalImpl) f).domain())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  /** Return true if this conferenceCalloutRequest object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CalloutRequestConferenceImpl conferenceCalloutRequest = (CalloutRequestConferenceImpl) o;
    return Objects.equals(this.method, conferenceCalloutRequest.method)
        && Objects.equals(this.conferenceCallout, conferenceCalloutRequest.conferenceCallout);
  }

  @Override
  public int hashCode() {
    return Objects.hash(method, conferenceCallout);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CalloutRequestConferenceImpl {\n");
    sb.append("    method: ").append(toIndentedString(method)).append("\n");
    sb.append("    conferenceCallout: ").append(toIndentedString(conferenceCallout)).append("\n");
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
  static class Builder implements CalloutRequestConference.Builder {
    OptionalValue<MethodEnum> method =
        OptionalValue.of(CalloutRequestConference.MethodEnum.CONFERENCE_CALLOUT);
    OptionalValue<ConferenceCalloutInternal> conferenceCallout = OptionalValue.empty();

    ConferenceCalloutInternal.Builder _delegatedBuilder = null;

    @JsonProperty(JSON_PROPERTY_CONFERENCE_CALLOUT)
    public Builder setConferenceCallout(ConferenceCalloutInternal conferenceCallout) {
      this.conferenceCallout = OptionalValue.of(conferenceCallout);
      return this;
    }

    @JsonIgnore
    public Builder setCli(String cli) {
      getDelegatedBuilder().setCli(cli);
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
    public Builder setDestination(DestinationConference destination) {
      getDelegatedBuilder().setDestination(destination);
      return this;
    }

    @JsonIgnore
    public Builder setConferenceId(String conferenceId) {
      getDelegatedBuilder().setConferenceId(conferenceId);
      return this;
    }

    @JsonIgnore
    public Builder setConferenceDtmfOptions(ConferenceDtmfOptions conferenceDtmfOptions) {
      getDelegatedBuilder().setConferenceDtmfOptions(conferenceDtmfOptions);
      return this;
    }

    @JsonIgnore
    public Builder setMaxDuration(Integer maxDuration) {
      getDelegatedBuilder().setMaxDuration(maxDuration);
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

    @JsonIgnore
    public Builder setLocale(String locale) {
      getDelegatedBuilder().setLocale(locale);
      return this;
    }

    @JsonIgnore
    public Builder setGreeting(String greeting) {
      getDelegatedBuilder().setGreeting(greeting);
      return this;
    }

    @JsonIgnore
    public Builder setMusicOnHold(MusicOnHold MusicOnHold) {
      getDelegatedBuilder().setMusicOnHold(MusicOnHold);
      return this;
    }

    @JsonIgnore
    public Builder setDomain(Domain domain) {
      getDelegatedBuilder().setDomain(domain);
      return this;
    }

    private ConferenceCalloutInternal.Builder getDelegatedBuilder() {
      if (null == _delegatedBuilder) {
        this._delegatedBuilder = ConferenceCalloutInternal.builder();
      }
      return this._delegatedBuilder;
    }

    public CalloutRequestConference build() {
      // delegated builder was used: filling the related source of delegation field
      if (null != this._delegatedBuilder) {
        this.conferenceCallout = OptionalValue.of(this._delegatedBuilder.build());
      }
      return new CalloutRequestConferenceImpl(method, conferenceCallout);
    }
  }

  public static class DelegatedSerializer
      extends JsonSerializer<OptionalValue<CalloutRequestConference>> {
    @Override
    public void serialize(
        OptionalValue<CalloutRequestConference> value,
        JsonGenerator jgen,
        SerializerProvider provider)
        throws IOException {

      if (!value.isPresent()) {
        return;
      }
      CalloutRequestConferenceImpl impl = (CalloutRequestConferenceImpl) value.get();
      jgen.writeObject(null != impl ? impl.getConferenceCallout() : null);
    }
  }

  public static class DelegatedDeSerializer extends JsonDeserializer<CalloutRequestConference> {
    @Override
    public CalloutRequestConference deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException {

      CalloutRequestConferenceImpl.Builder builder = new CalloutRequestConferenceImpl.Builder();
      ConferenceCalloutInternalImpl deserialized =
          jp.readValueAs(ConferenceCalloutInternalImpl.class);
      builder.setConferenceCallout(deserialized);
      return builder.build();
    }
  }

  public static Optional<CalloutRequestConference> delegatedConverter(
      ConferenceCalloutInternal internal) {
    if (null == internal) {
      return Optional.empty();
    }
    return Optional.of(new Builder().setConferenceCallout(internal).build());
  }
}
