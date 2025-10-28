package com.sinch.sdk.domains.voice.models.v1.svaml.action;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({SvamlActionContinueImpl.JSON_PROPERTY_NAME})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class SvamlActionContinueImpl
    implements SvamlActionContinue, com.sinch.sdk.domains.voice.models.v1.svaml.action.SvamlAction {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_NAME = "name";

  private OptionalValue<NameEnum> name;

  public SvamlActionContinueImpl() {}

  protected SvamlActionContinueImpl(OptionalValue<NameEnum> name) {
    this.name = name;
  }

  @JsonIgnore
  public NameEnum getName() {
    return name.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<NameEnum> name() {
    return name;
  }

  /** Return true if this svaml.action.continue object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SvamlActionContinueImpl svamlActionContinue = (SvamlActionContinueImpl) o;
    return Objects.equals(this.name, svamlActionContinue.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SvamlActionContinueImpl {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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
  static class Builder implements SvamlActionContinue.Builder {
    OptionalValue<NameEnum> name = OptionalValue.of(NameEnum.CONTINUE);

    @JsonProperty(value = JSON_PROPERTY_NAME, required = true)
    Builder setName(NameEnum name) {
      if (!Objects.equals(name, NameEnum.CONTINUE)) {
        throw new IllegalArgumentException(
            String.format("'name' must be '%s' (is '%s')", NameEnum.CONTINUE, name));
      }
      return this;
    }

    public SvamlActionContinue build() {
      return new SvamlActionContinueImpl(name);
    }
  }
}
