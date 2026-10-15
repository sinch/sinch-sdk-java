package com.sinch.sdk.domains.voice.models.v2.svaml.request;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.voice.models.v2.svaml.SvamlInput;
import java.util.Objects;

@JsonPropertyOrder({DescribeSvamlRequestImpl.JSON_PROPERTY_SVAML})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class DescribeSvamlRequestImpl implements DescribeSvamlRequest {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_SVAML = "svaml";

  private OptionalValue<SvamlInput> svaml;

  public DescribeSvamlRequestImpl() {}

  protected DescribeSvamlRequestImpl(OptionalValue<SvamlInput> svaml) {
    this.svaml = svaml;
  }

  @JsonIgnore
  public SvamlInput getSvaml() {
    return svaml.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SVAML)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<SvamlInput> svaml() {
    return svaml;
  }

  /** Return true if this DescribeSvamlRequest object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DescribeSvamlRequestImpl describeSvamlRequest = (DescribeSvamlRequestImpl) o;
    return Objects.equals(this.svaml, describeSvamlRequest.svaml);
  }

  @Override
  public int hashCode() {
    return Objects.hash(svaml);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DescribeSvamlRequestImpl {\n");
    sb.append("    svaml: ").append(toIndentedString(svaml)).append("\n");
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
  static class Builder implements DescribeSvamlRequest.Builder {
    OptionalValue<SvamlInput> svaml = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_SVAML, required = true)
    public Builder setSvaml(SvamlInput svaml) {
      this.svaml = OptionalValue.of(svaml);
      return this;
    }

    public DescribeSvamlRequest build() {
      return new DescribeSvamlRequestImpl(svaml);
    }
  }
}
