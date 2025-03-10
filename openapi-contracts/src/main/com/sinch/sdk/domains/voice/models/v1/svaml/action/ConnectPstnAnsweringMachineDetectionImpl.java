package com.sinch.sdk.domains.voice.models.v1.svaml.action;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({ConnectPstnAnsweringMachineDetectionImpl.JSON_PROPERTY_ENABLED})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ConnectPstnAnsweringMachineDetectionImpl
    implements ConnectPstnAnsweringMachineDetection {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_ENABLED = "enabled";

  private OptionalValue<Boolean> enabled;

  public ConnectPstnAnsweringMachineDetectionImpl() {}

  protected ConnectPstnAnsweringMachineDetectionImpl(OptionalValue<Boolean> enabled) {
    this.enabled = enabled;
  }

  @JsonIgnore
  public Boolean getEnabled() {
    return enabled.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ENABLED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Boolean> enabled() {
    return enabled;
  }

  /** Return true if this svaml_action_connectPstn_amd object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConnectPstnAnsweringMachineDetectionImpl svamlActionConnectPstnAmd =
        (ConnectPstnAnsweringMachineDetectionImpl) o;
    return Objects.equals(this.enabled, svamlActionConnectPstnAmd.enabled);
  }

  @Override
  public int hashCode() {
    return Objects.hash(enabled);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConnectPstnAnsweringMachineDetectionImpl {\n");
    sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
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
  static class Builder implements ConnectPstnAnsweringMachineDetection.Builder {
    OptionalValue<Boolean> enabled = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_ENABLED)
    public Builder setEnabled(Boolean enabled) {
      this.enabled = OptionalValue.of(enabled);
      return this;
    }

    public ConnectPstnAnsweringMachineDetection build() {
      return new ConnectPstnAnsweringMachineDetectionImpl(enabled);
    }
  }
}
