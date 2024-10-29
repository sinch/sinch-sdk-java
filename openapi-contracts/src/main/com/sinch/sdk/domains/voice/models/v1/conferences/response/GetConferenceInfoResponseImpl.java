package com.sinch.sdk.domains.voice.models.v1.conferences.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.voice.models.v1.conferences.ConferenceParticipant;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({GetConferenceInfoResponseImpl.JSON_PROPERTY_PARTICIPANTS})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class GetConferenceInfoResponseImpl implements GetConferenceInfoResponse {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_PARTICIPANTS = "participants";

  private OptionalValue<List<ConferenceParticipant>> participants;

  public GetConferenceInfoResponseImpl() {}

  protected GetConferenceInfoResponseImpl(OptionalValue<List<ConferenceParticipant>> participants) {
    this.participants = participants;
  }

  @JsonIgnore
  public List<ConferenceParticipant> getParticipants() {
    return participants.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PARTICIPANTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<ConferenceParticipant>> participants() {
    return participants;
  }

  /** Return true if this getConferenceInfoResponse object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetConferenceInfoResponseImpl getConferenceInfoResponse = (GetConferenceInfoResponseImpl) o;
    return Objects.equals(this.participants, getConferenceInfoResponse.participants);
  }

  @Override
  public int hashCode() {
    return Objects.hash(participants);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetConferenceInfoResponseImpl {\n");
    sb.append("    participants: ").append(toIndentedString(participants)).append("\n");
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
  static class Builder implements GetConferenceInfoResponse.Builder {
    OptionalValue<List<ConferenceParticipant>> participants = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_PARTICIPANTS)
    public Builder setParticipants(List<ConferenceParticipant> participants) {
      this.participants = OptionalValue.of(participants);
      return this;
    }

    public GetConferenceInfoResponse build() {
      return new GetConferenceInfoResponseImpl(participants);
    }
  }
}
