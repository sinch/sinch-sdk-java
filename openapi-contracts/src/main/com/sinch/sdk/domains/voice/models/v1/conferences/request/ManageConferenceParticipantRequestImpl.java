package com.sinch.sdk.domains.voice.models.v1.conferences.request;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.voice.models.v1.MusicOnHold;
import java.util.Objects;

@JsonPropertyOrder({
  ManageConferenceParticipantRequestImpl.JSON_PROPERTY_COMMAND,
  ManageConferenceParticipantRequestImpl.JSON_PROPERTY_MOH
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ManageConferenceParticipantRequestImpl implements ManageConferenceParticipantRequest {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_COMMAND = "command";

  private OptionalValue<CommandEnum> command;

  public static final String JSON_PROPERTY_MOH = "moh";

  private OptionalValue<MusicOnHold> MusicOnHold;

  public ManageConferenceParticipantRequestImpl() {}

  protected ManageConferenceParticipantRequestImpl(
      OptionalValue<CommandEnum> command, OptionalValue<MusicOnHold> MusicOnHold) {
    this.command = command;
    this.MusicOnHold = MusicOnHold;
  }

  @JsonIgnore
  public CommandEnum getCommand() {
    return command.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_COMMAND)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<CommandEnum> command() {
    return command;
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

  /** Return true if this manageConferenceParticipantRequest object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ManageConferenceParticipantRequestImpl manageConferenceParticipantRequest =
        (ManageConferenceParticipantRequestImpl) o;
    return Objects.equals(this.command, manageConferenceParticipantRequest.command)
        && Objects.equals(this.MusicOnHold, manageConferenceParticipantRequest.MusicOnHold);
  }

  @Override
  public int hashCode() {
    return Objects.hash(command, MusicOnHold);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ManageConferenceParticipantRequestImpl {\n");
    sb.append("    command: ").append(toIndentedString(command)).append("\n");
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
  static class Builder implements ManageConferenceParticipantRequest.Builder {
    OptionalValue<CommandEnum> command = OptionalValue.empty();
    OptionalValue<MusicOnHold> MusicOnHold = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_COMMAND, required = true)
    public Builder setCommand(CommandEnum command) {
      this.command = OptionalValue.of(command);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_MOH)
    public Builder setMusicOnHold(MusicOnHold MusicOnHold) {
      this.MusicOnHold = OptionalValue.of(MusicOnHold);
      return this;
    }

    public ManageConferenceParticipantRequest build() {
      return new ManageConferenceParticipantRequestImpl(command, MusicOnHold);
    }
  }
}
