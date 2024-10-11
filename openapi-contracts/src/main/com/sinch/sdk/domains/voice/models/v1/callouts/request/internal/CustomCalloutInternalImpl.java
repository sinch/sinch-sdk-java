package com.sinch.sdk.domains.voice.models.v1.callouts.request.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.voice.models.v1.Destination;
import com.sinch.sdk.domains.voice.models.v1.svaml.Control;
import com.sinch.sdk.models.DualToneMultiFrequency;
import java.util.Objects;

@JsonPropertyOrder({
  CustomCalloutInternalImpl.JSON_PROPERTY_CLI,
  CustomCalloutInternalImpl.JSON_PROPERTY_DESTINATION,
  CustomCalloutInternalImpl.JSON_PROPERTY_DTMF,
  CustomCalloutInternalImpl.JSON_PROPERTY_CUSTOM,
  CustomCalloutInternalImpl.JSON_PROPERTY_MAX_DURATION,
  CustomCalloutInternalImpl.JSON_PROPERTY_ICE,
  CustomCalloutInternalImpl.JSON_PROPERTY_ACE,
  CustomCalloutInternalImpl.JSON_PROPERTY_PIE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class CustomCalloutInternalImpl implements CustomCalloutInternal {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CLI = "cli";

  private OptionalValue<String> cli;

  public static final String JSON_PROPERTY_DESTINATION = "destination";

  private OptionalValue<Destination> destination;

  public static final String JSON_PROPERTY_DTMF = "dtmf";

  private OptionalValue<DualToneMultiFrequency> dtmf;

  public static final String JSON_PROPERTY_CUSTOM = "custom";

  private OptionalValue<String> custom;

  public static final String JSON_PROPERTY_MAX_DURATION = "maxDuration";

  private OptionalValue<Integer> maxDuration;

  public static final String JSON_PROPERTY_ICE = "ice";

  private OptionalValue<Control> ice;

  public static final String JSON_PROPERTY_ACE = "ace";

  private OptionalValue<Control> ace;

  public static final String JSON_PROPERTY_PIE = "pie";

  private OptionalValue<Control> pie;

  public CustomCalloutInternalImpl() {}

  protected CustomCalloutInternalImpl(
      OptionalValue<String> cli,
      OptionalValue<Destination> destination,
      OptionalValue<DualToneMultiFrequency> dtmf,
      OptionalValue<String> custom,
      OptionalValue<Integer> maxDuration,
      OptionalValue<Control> ice,
      OptionalValue<Control> ace,
      OptionalValue<Control> pie) {
    this.cli = cli;
    this.destination = destination;
    this.dtmf = dtmf;
    this.custom = custom;
    this.maxDuration = maxDuration;
    this.ice = ice;
    this.ace = ace;
    this.pie = pie;
  }

  @JsonIgnore
  public String getCli() {
    return cli.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CLI)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> cli() {
    return cli;
  }

  @JsonIgnore
  public Destination getDestination() {
    return destination.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DESTINATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Destination> destination() {
    return destination;
  }

  @JsonIgnore
  public DualToneMultiFrequency getDtmf() {
    return dtmf.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DTMF)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<DualToneMultiFrequency> dtmf() {
    return dtmf;
  }

  @JsonIgnore
  public String getCustom() {
    return custom.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CUSTOM)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> custom() {
    return custom;
  }

  @JsonIgnore
  public Integer getMaxDuration() {
    return maxDuration.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MAX_DURATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Integer> maxDuration() {
    return maxDuration;
  }

  @JsonIgnore
  public Control getIce() {
    return ice.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ICE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Control> ice() {
    return ice;
  }

  @JsonIgnore
  public Control getAce() {
    return ace.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ACE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Control> ace() {
    return ace;
  }

  @JsonIgnore
  public Control getPie() {
    return pie.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PIE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Control> pie() {
    return pie;
  }

  /** Return true if this customCallout object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomCalloutInternalImpl customCallout = (CustomCalloutInternalImpl) o;
    return Objects.equals(this.cli, customCallout.cli)
        && Objects.equals(this.destination, customCallout.destination)
        && Objects.equals(this.dtmf, customCallout.dtmf)
        && Objects.equals(this.custom, customCallout.custom)
        && Objects.equals(this.maxDuration, customCallout.maxDuration)
        && Objects.equals(this.ice, customCallout.ice)
        && Objects.equals(this.ace, customCallout.ace)
        && Objects.equals(this.pie, customCallout.pie);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cli, destination, dtmf, custom, maxDuration, ice, ace, pie);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomCalloutInternalImpl {\n");
    sb.append("    cli: ").append(toIndentedString(cli)).append("\n");
    sb.append("    destination: ").append(toIndentedString(destination)).append("\n");
    sb.append("    dtmf: ").append(toIndentedString(dtmf)).append("\n");
    sb.append("    custom: ").append(toIndentedString(custom)).append("\n");
    sb.append("    maxDuration: ").append(toIndentedString(maxDuration)).append("\n");
    sb.append("    ice: ").append(toIndentedString(ice)).append("\n");
    sb.append("    ace: ").append(toIndentedString(ace)).append("\n");
    sb.append("    pie: ").append(toIndentedString(pie)).append("\n");
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
  static class Builder implements CustomCalloutInternal.Builder {
    OptionalValue<String> cli = OptionalValue.empty();
    OptionalValue<Destination> destination = OptionalValue.empty();
    OptionalValue<DualToneMultiFrequency> dtmf = OptionalValue.empty();
    OptionalValue<String> custom = OptionalValue.empty();
    OptionalValue<Integer> maxDuration = OptionalValue.empty();
    OptionalValue<Control> ice = OptionalValue.empty();
    OptionalValue<Control> ace = OptionalValue.empty();
    OptionalValue<Control> pie = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_CLI)
    public Builder setCli(String cli) {
      this.cli = OptionalValue.of(cli);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_DESTINATION)
    public Builder setDestination(Destination destination) {
      this.destination = OptionalValue.of(destination);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_DTMF)
    public Builder setDtmf(DualToneMultiFrequency dtmf) {
      this.dtmf = OptionalValue.of(dtmf);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CUSTOM)
    public Builder setCustom(String custom) {
      this.custom = OptionalValue.of(custom);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_MAX_DURATION)
    public Builder setMaxDuration(Integer maxDuration) {
      this.maxDuration = OptionalValue.of(maxDuration);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_ICE)
    public Builder setIce(Control ice) {
      this.ice = OptionalValue.of(ice);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_ACE)
    public Builder setAce(Control ace) {
      this.ace = OptionalValue.of(ace);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_PIE)
    public Builder setPie(Control pie) {
      this.pie = OptionalValue.of(pie);
      return this;
    }

    public CustomCalloutInternal build() {
      return new CustomCalloutInternalImpl(
          cli, destination, dtmf, custom, maxDuration, ice, ace, pie);
    }
  }
}
