package com.sinch.sdk.domains.conversation.models.v1.contact.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  IdentityConflictsImpl.JSON_PROPERTY_IDENTITY,
  IdentityConflictsImpl.JSON_PROPERTY_CHANNELS,
  IdentityConflictsImpl.JSON_PROPERTY_CONTACT_IDS
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class IdentityConflictsImpl implements IdentityConflicts {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_IDENTITY = "identity";

  private OptionalValue<String> identity;

  public static final String JSON_PROPERTY_CHANNELS = "channels";

  private OptionalValue<List<ConversationChannel>> channels;

  public static final String JSON_PROPERTY_CONTACT_IDS = "contact_ids";

  private OptionalValue<List<String>> contactIds;

  public IdentityConflictsImpl() {}

  protected IdentityConflictsImpl(
      OptionalValue<String> identity,
      OptionalValue<List<ConversationChannel>> channels,
      OptionalValue<List<String>> contactIds) {
    this.identity = identity;
    this.channels = channels;
    this.contactIds = contactIds;
  }

  @JsonIgnore
  public String getIdentity() {
    return identity.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_IDENTITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> identity() {
    return identity;
  }

  @JsonIgnore
  public List<ConversationChannel> getChannels() {
    return channels.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CHANNELS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<ConversationChannel>> channels() {
    return channels;
  }

  @JsonIgnore
  public List<String> getContactIds() {
    return contactIds.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CONTACT_IDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<String>> contactIds() {
    return contactIds;
  }

  /**
   * Return true if this Contact_ListIdentityConflicts_200_response_conflicts_inner object is equal
   * to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IdentityConflictsImpl contactListIdentityConflicts200ResponseConflictsInner =
        (IdentityConflictsImpl) o;
    return Objects.equals(
            this.identity, contactListIdentityConflicts200ResponseConflictsInner.identity)
        && Objects.equals(
            this.channels, contactListIdentityConflicts200ResponseConflictsInner.channels)
        && Objects.equals(
            this.contactIds, contactListIdentityConflicts200ResponseConflictsInner.contactIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(identity, channels, contactIds);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IdentityConflictsImpl {\n");
    sb.append("    identity: ").append(toIndentedString(identity)).append("\n");
    sb.append("    channels: ").append(toIndentedString(channels)).append("\n");
    sb.append("    contactIds: ").append(toIndentedString(contactIds)).append("\n");
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
  static class Builder implements IdentityConflicts.Builder {
    OptionalValue<String> identity = OptionalValue.empty();
    OptionalValue<List<ConversationChannel>> channels = OptionalValue.empty();
    OptionalValue<List<String>> contactIds = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_IDENTITY)
    public Builder setIdentity(String identity) {
      this.identity = OptionalValue.of(identity);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CHANNELS)
    public Builder setChannels(List<ConversationChannel> channels) {
      this.channels = OptionalValue.of(channels);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CONTACT_IDS)
    public Builder setContactIds(List<String> contactIds) {
      this.contactIds = OptionalValue.of(contactIds);
      return this;
    }

    public IdentityConflicts build() {
      return new IdentityConflictsImpl(identity, channels, contactIds);
    }
  }
}
