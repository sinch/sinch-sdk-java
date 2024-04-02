package com.sinch.sdk.domains.conversation.models.v1;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({IdentifiedByImpl.JSON_PROPERTY_CHANNEL_IDENTITIES})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class IdentifiedByImpl implements IdentifiedBy {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CHANNEL_IDENTITIES = "channel_identities";

  private OptionalValue<List<ChannelRecipientIdentity>> channelIdentities;

  public IdentifiedByImpl() {}

  protected IdentifiedByImpl(OptionalValue<List<ChannelRecipientIdentity>> channelIdentities) {
    this.channelIdentities = channelIdentities;
  }

  @JsonIgnore
  public List<ChannelRecipientIdentity> getChannelIdentities() {
    return channelIdentities.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CHANNEL_IDENTITIES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<List<ChannelRecipientIdentity>> channelIdentities() {
    return channelIdentities;
  }

  /** Return true if this IdentifiedBy object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IdentifiedByImpl identifiedBy = (IdentifiedByImpl) o;
    return Objects.equals(this.channelIdentities, identifiedBy.channelIdentities);
  }

  @Override
  public int hashCode() {
    return Objects.hash(channelIdentities);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IdentifiedByImpl {\n");
    sb.append("    channelIdentities: ").append(toIndentedString(channelIdentities)).append("\n");
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
  static class Builder implements IdentifiedBy.Builder {
    OptionalValue<List<ChannelRecipientIdentity>> channelIdentities = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_CHANNEL_IDENTITIES)
    public Builder setChannelIdentities(List<ChannelRecipientIdentity> channelIdentities) {
      this.channelIdentities = OptionalValue.of(channelIdentities);
      return this;
    }

    public IdentifiedBy build() {
      return new IdentifiedByImpl(channelIdentities);
    }
  }
}
