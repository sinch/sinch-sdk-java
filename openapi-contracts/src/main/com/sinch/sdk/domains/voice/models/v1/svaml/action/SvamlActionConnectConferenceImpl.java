package com.sinch.sdk.domains.voice.models.v1.svaml.action;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.voice.models.v1.MusicOnHold;
import com.sinch.sdk.domains.voice.models.v1.conferences.ConferenceDtmfOptions;
import java.util.Objects;

@JsonPropertyOrder({
  SvamlActionConnectConferenceImpl.JSON_PROPERTY_NAME,
  SvamlActionConnectConferenceImpl.JSON_PROPERTY_CONFERENCE_ID,
  SvamlActionConnectConferenceImpl.JSON_PROPERTY_CONFERENCE_DTMF_OPTIONS,
  SvamlActionConnectConferenceImpl.JSON_PROPERTY_MOH
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class SvamlActionConnectConferenceImpl
    implements SvamlActionConnectConference,
        com.sinch.sdk.domains.voice.models.v1.svaml.action.SvamlAction {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_NAME = "name";

  private OptionalValue<NameEnum> name;

  public static final String JSON_PROPERTY_CONFERENCE_ID = "conferenceId";

  private OptionalValue<String> conferenceId;

  public static final String JSON_PROPERTY_CONFERENCE_DTMF_OPTIONS = "conferenceDtmfOptions";

  private OptionalValue<ConferenceDtmfOptions> conferenceDtmfOptions;

  public static final String JSON_PROPERTY_MOH = "moh";

  private OptionalValue<MusicOnHold> MusicOnHold;

  public SvamlActionConnectConferenceImpl() {}

  protected SvamlActionConnectConferenceImpl(
      OptionalValue<NameEnum> name,
      OptionalValue<String> conferenceId,
      OptionalValue<ConferenceDtmfOptions> conferenceDtmfOptions,
      OptionalValue<MusicOnHold> MusicOnHold) {
    this.name = name;
    this.conferenceId = conferenceId;
    this.conferenceDtmfOptions = conferenceDtmfOptions;
    this.MusicOnHold = MusicOnHold;
  }

  @JsonIgnore
  public NameEnum getName() {
    return name.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<NameEnum> name() {
    return name;
  }

  @JsonIgnore
  public String getConferenceId() {
    return conferenceId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CONFERENCE_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> conferenceId() {
    return conferenceId;
  }

  @JsonIgnore
  public ConferenceDtmfOptions getConferenceDtmfOptions() {
    return conferenceDtmfOptions.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CONFERENCE_DTMF_OPTIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ConferenceDtmfOptions> conferenceDtmfOptions() {
    return conferenceDtmfOptions;
  }

  @JsonIgnore
  public MusicOnHold getMusicOnHold() {
    return MusicOnHold.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MOH)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<MusicOnHold> musicOnHold() {
    return MusicOnHold;
  }

  /** Return true if this svaml.action.connectConf object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SvamlActionConnectConferenceImpl svamlActionConnectConf = (SvamlActionConnectConferenceImpl) o;
    return Objects.equals(this.name, svamlActionConnectConf.name)
        && Objects.equals(this.conferenceId, svamlActionConnectConf.conferenceId)
        && Objects.equals(this.conferenceDtmfOptions, svamlActionConnectConf.conferenceDtmfOptions)
        && Objects.equals(this.MusicOnHold, svamlActionConnectConf.MusicOnHold);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, conferenceId, conferenceDtmfOptions, MusicOnHold);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SvamlActionConnectConferenceImpl {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    conferenceId: ").append(toIndentedString(conferenceId)).append("\n");
    sb.append("    conferenceDtmfOptions: ")
        .append(toIndentedString(conferenceDtmfOptions))
        .append("\n");
    sb.append("    MusicOnHold: ").append(toIndentedString(MusicOnHold)).append("\n");
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
  static class Builder implements SvamlActionConnectConference.Builder {
    OptionalValue<NameEnum> name = OptionalValue.of(NameEnum.CONNECT_CONF);
    OptionalValue<String> conferenceId = OptionalValue.empty();
    OptionalValue<ConferenceDtmfOptions> conferenceDtmfOptions = OptionalValue.empty();
    OptionalValue<MusicOnHold> MusicOnHold = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_CONFERENCE_ID, required = true)
    public Builder setConferenceId(String conferenceId) {
      this.conferenceId = OptionalValue.of(conferenceId);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CONFERENCE_DTMF_OPTIONS)
    public Builder setConferenceDtmfOptions(ConferenceDtmfOptions conferenceDtmfOptions) {
      this.conferenceDtmfOptions = OptionalValue.of(conferenceDtmfOptions);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_MOH)
    public Builder setMusicOnHold(MusicOnHold MusicOnHold) {
      this.MusicOnHold = OptionalValue.of(MusicOnHold);
      return this;
    }

    public SvamlActionConnectConference build() {
      return new SvamlActionConnectConferenceImpl(
          name, conferenceId, conferenceDtmfOptions, MusicOnHold);
    }
  }
}
