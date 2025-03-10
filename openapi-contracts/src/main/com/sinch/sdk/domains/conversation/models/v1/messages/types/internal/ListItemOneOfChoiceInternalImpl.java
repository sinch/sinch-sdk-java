package com.sinch.sdk.domains.conversation.models.v1.messages.types.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.messages.ChoiceItem;
import java.util.Objects;

@JsonPropertyOrder({ListItemOneOfChoiceInternalImpl.JSON_PROPERTY_CHOICE})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ListItemOneOfChoiceInternalImpl implements ListItemOneOfChoiceInternal {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CHOICE = "choice";

  private OptionalValue<ChoiceItem> choice;

  public ListItemOneOfChoiceInternalImpl() {}

  protected ListItemOneOfChoiceInternalImpl(OptionalValue<ChoiceItem> choice) {
    this.choice = choice;
  }

  @JsonIgnore
  public ChoiceItem getChoice() {
    return choice.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CHOICE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<ChoiceItem> choice() {
    return choice;
  }

  /** Return true if this Choice_1 object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListItemOneOfChoiceInternalImpl choice1 = (ListItemOneOfChoiceInternalImpl) o;
    return Objects.equals(this.choice, choice1.choice);
  }

  @Override
  public int hashCode() {
    return Objects.hash(choice);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListItemOneOfChoiceInternalImpl {\n");
    sb.append("    choice: ").append(toIndentedString(choice)).append("\n");
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
  static class Builder implements ListItemOneOfChoiceInternal.Builder {
    OptionalValue<ChoiceItem> choice = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_CHOICE, required = true)
    public Builder setChoice(ChoiceItem choice) {
      this.choice = OptionalValue.of(choice);
      return this;
    }

    public ListItemOneOfChoiceInternal build() {
      return new ListItemOneOfChoiceInternalImpl(choice);
    }
  }
}
