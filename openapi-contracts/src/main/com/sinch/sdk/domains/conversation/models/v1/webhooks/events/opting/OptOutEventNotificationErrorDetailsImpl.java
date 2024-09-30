package com.sinch.sdk.domains.conversation.models.v1.webhooks.events.opting;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({OptOutEventNotificationErrorDetailsImpl.JSON_PROPERTY_DESCRIPTION})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class OptOutEventNotificationErrorDetailsImpl
    implements OptOutEventNotificationErrorDetails {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_DESCRIPTION = "description";

  private OptionalValue<String> description;

  public OptOutEventNotificationErrorDetailsImpl() {}

  protected OptOutEventNotificationErrorDetailsImpl(OptionalValue<String> description) {
    this.description = description;
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

  /**
   * Return true if this OptOutEvent_allOf_opt_out_notification_error_details object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OptOutEventNotificationErrorDetailsImpl optOutEventAllOfOptOutNotificationErrorDetails =
        (OptOutEventNotificationErrorDetailsImpl) o;
    return Objects.equals(
        this.description, optOutEventAllOfOptOutNotificationErrorDetails.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OptOutEventNotificationErrorDetailsImpl {\n");
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
  static class Builder implements OptOutEventNotificationErrorDetails.Builder {
    OptionalValue<String> description = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_DESCRIPTION)
    public Builder setDescription(String description) {
      this.description = OptionalValue.of(description);
      return this;
    }

    public OptOutEventNotificationErrorDetails build() {
      return new OptOutEventNotificationErrorDetailsImpl(description);
    }
  }
}
