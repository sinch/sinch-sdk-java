package com.sinch.sdk.domains.conversation.models.v1.webhooks.events.contact;

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
  DuplicatedIdentitiesImpl.JSON_PROPERTY_CHANNEL,
  DuplicatedIdentitiesImpl.JSON_PROPERTY_CONTACT_IDS
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class DuplicatedIdentitiesImpl implements DuplicatedIdentities {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CHANNEL = "channel";

  private OptionalValue<ConversationChannel> channel;

  public static final String JSON_PROPERTY_CONTACT_IDS = "contact_ids";

  private OptionalValue<List<String>> contactIds;

  public DuplicatedIdentitiesImpl() {}

  protected DuplicatedIdentitiesImpl(
      OptionalValue<ConversationChannel> channel, OptionalValue<List<String>> contactIds) {
    this.channel = channel;
    this.contactIds = contactIds;
  }

  @JsonIgnore
  public ConversationChannel getChannel() {
    return channel.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CHANNEL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ConversationChannel> channel() {
    return channel;
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
   * Return true if this
   * ContactIdentitiesDuplicationEvent_allOf_duplicated_contact_identities_notification_duplicated_identities
   * object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DuplicatedIdentitiesImpl
        contactIdentitiesDuplicationEventAllOfDuplicatedContactIdentitiesNotificationDuplicatedIdentities =
            (DuplicatedIdentitiesImpl) o;
    return Objects.equals(
            this.channel,
            contactIdentitiesDuplicationEventAllOfDuplicatedContactIdentitiesNotificationDuplicatedIdentities
                .channel)
        && Objects.equals(
            this.contactIds,
            contactIdentitiesDuplicationEventAllOfDuplicatedContactIdentitiesNotificationDuplicatedIdentities
                .contactIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(channel, contactIds);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DuplicatedIdentitiesImpl {\n");
    sb.append("    channel: ").append(toIndentedString(channel)).append("\n");
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
  static class Builder implements DuplicatedIdentities.Builder {
    OptionalValue<ConversationChannel> channel = OptionalValue.empty();
    OptionalValue<List<String>> contactIds = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_CHANNEL)
    public Builder setChannel(ConversationChannel channel) {
      this.channel = OptionalValue.of(channel);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CONTACT_IDS)
    public Builder setContactIds(List<String> contactIds) {
      this.contactIds = OptionalValue.of(contactIds);
      return this;
    }

    public DuplicatedIdentities build() {
      return new DuplicatedIdentitiesImpl(channel, contactIds);
    }
  }
}
