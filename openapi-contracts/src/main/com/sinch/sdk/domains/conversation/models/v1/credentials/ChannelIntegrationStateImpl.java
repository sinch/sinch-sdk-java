package com.sinch.sdk.domains.conversation.models.v1.credentials;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  ChannelIntegrationStateImpl.JSON_PROPERTY_STATUS,
  ChannelIntegrationStateImpl.JSON_PROPERTY_DESCRIPTION
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ChannelIntegrationStateImpl implements ChannelIntegrationState {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_STATUS = "status";

  private OptionalValue<ChannelIntegrationStatus> status;

  public static final String JSON_PROPERTY_DESCRIPTION = "description";

  private OptionalValue<String> description;

  public ChannelIntegrationStateImpl() {}

  protected ChannelIntegrationStateImpl(
      OptionalValue<ChannelIntegrationStatus> status, OptionalValue<String> description) {
    this.status = status;
    this.description = description;
  }

  @JsonIgnore
  public ChannelIntegrationStatus getStatus() {
    return status.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<ChannelIntegrationStatus> status() {
    return status;
  }

  @JsonIgnore
  public String getDescription() {
    return description.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> description() {
    return description;
  }

  /** Return true if this ChannelIntegrationState object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChannelIntegrationStateImpl channelIntegrationState = (ChannelIntegrationStateImpl) o;
    return Objects.equals(this.status, channelIntegrationState.status)
        && Objects.equals(this.description, channelIntegrationState.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChannelIntegrationStateImpl {\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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
  static class Builder implements ChannelIntegrationState.Builder {
    OptionalValue<ChannelIntegrationStatus> status = OptionalValue.empty();
    OptionalValue<String> description = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_STATUS)
    public Builder setStatus(ChannelIntegrationStatus status) {
      this.status = OptionalValue.of(status);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_DESCRIPTION)
    public Builder setDescription(String description) {
      this.description = OptionalValue.of(description);
      return this;
    }

    public ChannelIntegrationState build() {
      return new ChannelIntegrationStateImpl(status, description);
    }
  }
}
