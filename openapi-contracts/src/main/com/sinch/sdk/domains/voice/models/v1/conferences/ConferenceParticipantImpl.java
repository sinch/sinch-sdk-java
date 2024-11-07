package com.sinch.sdk.domains.voice.models.v1.conferences;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  ConferenceParticipantImpl.JSON_PROPERTY_CLI,
  ConferenceParticipantImpl.JSON_PROPERTY_ID,
  ConferenceParticipantImpl.JSON_PROPERTY_DURATION,
  ConferenceParticipantImpl.JSON_PROPERTY_MUTED,
  ConferenceParticipantImpl.JSON_PROPERTY_ONHOLD
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ConferenceParticipantImpl implements ConferenceParticipant {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CLI = "cli";

  private OptionalValue<String> cli;

  public static final String JSON_PROPERTY_ID = "id";

  private OptionalValue<String> id;

  public static final String JSON_PROPERTY_DURATION = "duration";

  private OptionalValue<Integer> duration;

  public static final String JSON_PROPERTY_MUTED = "muted";

  private OptionalValue<Boolean> muted;

  public static final String JSON_PROPERTY_ONHOLD = "onhold";

  private OptionalValue<Boolean> OnHold;

  public ConferenceParticipantImpl() {}

  protected ConferenceParticipantImpl(
      OptionalValue<String> cli,
      OptionalValue<String> id,
      OptionalValue<Integer> duration,
      OptionalValue<Boolean> muted,
      OptionalValue<Boolean> OnHold) {
    this.cli = cli;
    this.id = id;
    this.duration = duration;
    this.muted = muted;
    this.OnHold = OnHold;
  }

  @JsonIgnore
  public String getCli() {
    return cli.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CLI)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> cli() {
    return cli;
  }

  @JsonIgnore
  public String getId() {
    return id.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> id() {
    return id;
  }

  @JsonIgnore
  public Integer getDuration() {
    return duration.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DURATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Integer> duration() {
    return duration;
  }

  @JsonIgnore
  public Boolean getMuted() {
    return muted.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MUTED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Boolean> muted() {
    return muted;
  }

  @JsonIgnore
  public Boolean getOnHold() {
    return OnHold.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ONHOLD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Boolean> onHold() {
    return OnHold;
  }

  /** Return true if this getConferenceInfoResponse_participants_inner object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConferenceParticipantImpl getConferenceInfoResponseParticipantsInner =
        (ConferenceParticipantImpl) o;
    return Objects.equals(this.cli, getConferenceInfoResponseParticipantsInner.cli)
        && Objects.equals(this.id, getConferenceInfoResponseParticipantsInner.id)
        && Objects.equals(this.duration, getConferenceInfoResponseParticipantsInner.duration)
        && Objects.equals(this.muted, getConferenceInfoResponseParticipantsInner.muted)
        && Objects.equals(this.OnHold, getConferenceInfoResponseParticipantsInner.OnHold);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cli, id, duration, muted, OnHold);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConferenceParticipantImpl {\n");
    sb.append("    cli: ").append(toIndentedString(cli)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
    sb.append("    muted: ").append(toIndentedString(muted)).append("\n");
    sb.append("    OnHold: ").append(toIndentedString(OnHold)).append("\n");
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
  static class Builder implements ConferenceParticipant.Builder {
    OptionalValue<String> cli = OptionalValue.empty();
    OptionalValue<String> id = OptionalValue.empty();
    OptionalValue<Integer> duration = OptionalValue.empty();
    OptionalValue<Boolean> muted = OptionalValue.empty();
    OptionalValue<Boolean> OnHold = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_CLI)
    public Builder setCli(String cli) {
      this.cli = OptionalValue.of(cli);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_ID)
    public Builder setId(String id) {
      this.id = OptionalValue.of(id);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_DURATION)
    public Builder setDuration(Integer duration) {
      this.duration = OptionalValue.of(duration);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_MUTED)
    public Builder setMuted(Boolean muted) {
      this.muted = OptionalValue.of(muted);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_ONHOLD)
    public Builder setOnHold(Boolean OnHold) {
      this.OnHold = OptionalValue.of(OnHold);
      return this;
    }

    public ConferenceParticipant build() {
      return new ConferenceParticipantImpl(cli, id, duration, muted, OnHold);
    }
  }
}
