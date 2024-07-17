package com.sinch.sdk.domains.conversation.models.v1.webhooks.events.contact.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.contact.DuplicatedIdentities;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  DuplicatedContactIdentitiesNotificationInternalImpl.JSON_PROPERTY_DUPLICATED_IDENTITIES
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class DuplicatedContactIdentitiesNotificationInternalImpl
    implements DuplicatedContactIdentitiesNotificationInternal {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_DUPLICATED_IDENTITIES = "duplicated_identities";

  private OptionalValue<List<DuplicatedIdentities>> duplicatedIdentities;

  public DuplicatedContactIdentitiesNotificationInternalImpl() {}

  protected DuplicatedContactIdentitiesNotificationInternalImpl(
      OptionalValue<List<DuplicatedIdentities>> duplicatedIdentities) {
    this.duplicatedIdentities = duplicatedIdentities;
  }

  @JsonIgnore
  public List<DuplicatedIdentities> getDuplicatedIdentities() {
    return duplicatedIdentities.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DUPLICATED_IDENTITIES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<DuplicatedIdentities>> duplicatedIdentities() {
    return duplicatedIdentities;
  }

  /**
   * Return true if this
   * ContactIdentitiesDuplicationEvent_allOf_duplicated_contact_identities_notification object is
   * equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DuplicatedContactIdentitiesNotificationInternalImpl
        contactIdentitiesDuplicationEventAllOfDuplicatedContactIdentitiesNotification =
            (DuplicatedContactIdentitiesNotificationInternalImpl) o;
    return Objects.equals(
        this.duplicatedIdentities,
        contactIdentitiesDuplicationEventAllOfDuplicatedContactIdentitiesNotification
            .duplicatedIdentities);
  }

  @Override
  public int hashCode() {
    return Objects.hash(duplicatedIdentities);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DuplicatedContactIdentitiesNotificationInternalImpl {\n");
    sb.append("    duplicatedIdentities: ")
        .append(toIndentedString(duplicatedIdentities))
        .append("\n");
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
  static class Builder implements DuplicatedContactIdentitiesNotificationInternal.Builder {
    OptionalValue<List<DuplicatedIdentities>> duplicatedIdentities = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_DUPLICATED_IDENTITIES)
    public Builder setDuplicatedIdentities(List<DuplicatedIdentities> duplicatedIdentities) {
      this.duplicatedIdentities = OptionalValue.of(duplicatedIdentities);
      return this;
    }

    public DuplicatedContactIdentitiesNotificationInternal build() {
      return new DuplicatedContactIdentitiesNotificationInternalImpl(duplicatedIdentities);
    }
  }
}
