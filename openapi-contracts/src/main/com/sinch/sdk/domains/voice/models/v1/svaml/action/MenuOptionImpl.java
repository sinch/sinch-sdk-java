package com.sinch.sdk.domains.voice.models.v1.svaml.action;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.models.DualToneMultiFrequency;
import java.util.Objects;

@JsonPropertyOrder({MenuOptionImpl.JSON_PROPERTY_DTMF, MenuOptionImpl.JSON_PROPERTY_ACTION})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class MenuOptionImpl implements MenuOption {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_DTMF = "dtmf";

  private OptionalValue<DualToneMultiFrequency> dtmf;

  public static final String JSON_PROPERTY_ACTION = "action";

  private OptionalValue<String> action;

  public MenuOptionImpl() {}

  protected MenuOptionImpl(
      OptionalValue<DualToneMultiFrequency> dtmf, OptionalValue<String> action) {
    this.dtmf = dtmf;
    this.action = action;
  }

  @JsonIgnore
  public DualToneMultiFrequency getDtmf() {
    return dtmf.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DTMF)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<DualToneMultiFrequency> dtmf() {
    return dtmf;
  }

  @JsonIgnore
  public String getAction() {
    return action.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ACTION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> action() {
    return action;
  }

  /** Return true if this option object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MenuOptionImpl option = (MenuOptionImpl) o;
    return Objects.equals(this.dtmf, option.dtmf) && Objects.equals(this.action, option.action);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dtmf, action);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MenuOptionImpl {\n");
    sb.append("    dtmf: ").append(toIndentedString(dtmf)).append("\n");
    sb.append("    action: ").append(toIndentedString(action)).append("\n");
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
  static class Builder implements MenuOption.Builder {
    OptionalValue<DualToneMultiFrequency> dtmf = OptionalValue.empty();
    OptionalValue<String> action = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_DTMF)
    public Builder setDtmf(DualToneMultiFrequency dtmf) {
      this.dtmf = OptionalValue.of(dtmf);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_ACTION)
    public Builder setAction(String action) {
      this.action = OptionalValue.of(action);
      return this;
    }

    public MenuOption build() {
      return new MenuOptionImpl(dtmf, action);
    }
  }
}
