package com.sinch.sdk.domains.numberlookup.models.v2.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  NumberLookupResponseImpl.JSON_PROPERTY_LINE,
  NumberLookupResponseImpl.JSON_PROPERTY_SIM_SWAP,
  NumberLookupResponseImpl.JSON_PROPERTY_VO_I_P_DETECTION,
  NumberLookupResponseImpl.JSON_PROPERTY_RND,
  NumberLookupResponseImpl.JSON_PROPERTY_COUNTRY_CODE,
  NumberLookupResponseImpl.JSON_PROPERTY_TRACE_ID,
  NumberLookupResponseImpl.JSON_PROPERTY_NUMBER
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class NumberLookupResponseImpl implements NumberLookupResponse {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_LINE = "line";

  private OptionalValue<Line> line;

  public static final String JSON_PROPERTY_SIM_SWAP = "simSwap";

  private OptionalValue<SimSwap> simSwap;

  public static final String JSON_PROPERTY_VO_I_P_DETECTION = "voIPDetection";

  private OptionalValue<VoIPDetection> voIPDetection;

  public static final String JSON_PROPERTY_RND = "rnd";

  private OptionalValue<Rnd> rnd;

  public static final String JSON_PROPERTY_COUNTRY_CODE = "countryCode";

  private OptionalValue<String> countryCode;

  public static final String JSON_PROPERTY_TRACE_ID = "traceId";

  private OptionalValue<String> traceId;

  public static final String JSON_PROPERTY_NUMBER = "number";

  private OptionalValue<String> number;

  public NumberLookupResponseImpl() {}

  protected NumberLookupResponseImpl(
      OptionalValue<Line> line,
      OptionalValue<SimSwap> simSwap,
      OptionalValue<VoIPDetection> voIPDetection,
      OptionalValue<Rnd> rnd,
      OptionalValue<String> countryCode,
      OptionalValue<String> traceId,
      OptionalValue<String> number) {
    this.line = line;
    this.simSwap = simSwap;
    this.voIPDetection = voIPDetection;
    this.rnd = rnd;
    this.countryCode = countryCode;
    this.traceId = traceId;
    this.number = number;
  }

  @JsonIgnore
  public Line getLine() {
    return line.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_LINE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Line> line() {
    return line;
  }

  @JsonIgnore
  public SimSwap getSimSwap() {
    return simSwap.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SIM_SWAP)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<SimSwap> simSwap() {
    return simSwap;
  }

  @JsonIgnore
  public VoIPDetection getVoIPDetection() {
    return voIPDetection.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_VO_I_P_DETECTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<VoIPDetection> voIPDetection() {
    return voIPDetection;
  }

  @JsonIgnore
  public Rnd getRnd() {
    return rnd.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_RND)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Rnd> rnd() {
    return rnd;
  }

  @JsonIgnore
  public String getCountryCode() {
    return countryCode.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_COUNTRY_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> countryCode() {
    return countryCode;
  }

  @JsonIgnore
  public String getTraceId() {
    return traceId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TRACE_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> traceId() {
    return traceId;
  }

  @JsonIgnore
  public String getNumber() {
    return number.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> number() {
    return number;
  }

  /** Return true if this NumberLookupResponse object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NumberLookupResponseImpl numberLookupResponse = (NumberLookupResponseImpl) o;
    return Objects.equals(this.line, numberLookupResponse.line)
        && Objects.equals(this.simSwap, numberLookupResponse.simSwap)
        && Objects.equals(this.voIPDetection, numberLookupResponse.voIPDetection)
        && Objects.equals(this.rnd, numberLookupResponse.rnd)
        && Objects.equals(this.countryCode, numberLookupResponse.countryCode)
        && Objects.equals(this.traceId, numberLookupResponse.traceId)
        && Objects.equals(this.number, numberLookupResponse.number);
  }

  @Override
  public int hashCode() {
    return Objects.hash(line, simSwap, voIPDetection, rnd, countryCode, traceId, number);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NumberLookupResponseImpl {\n");
    sb.append("    line: ").append(toIndentedString(line)).append("\n");
    sb.append("    simSwap: ").append(toIndentedString(simSwap)).append("\n");
    sb.append("    voIPDetection: ").append(toIndentedString(voIPDetection)).append("\n");
    sb.append("    rnd: ").append(toIndentedString(rnd)).append("\n");
    sb.append("    countryCode: ").append(toIndentedString(countryCode)).append("\n");
    sb.append("    traceId: ").append(toIndentedString(traceId)).append("\n");
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
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
  static class Builder implements NumberLookupResponse.Builder {
    OptionalValue<Line> line = OptionalValue.empty();
    OptionalValue<SimSwap> simSwap = OptionalValue.empty();
    OptionalValue<VoIPDetection> voIPDetection = OptionalValue.empty();
    OptionalValue<Rnd> rnd = OptionalValue.empty();
    OptionalValue<String> countryCode = OptionalValue.empty();
    OptionalValue<String> traceId = OptionalValue.empty();
    OptionalValue<String> number = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_LINE)
    public Builder setLine(Line line) {
      this.line = OptionalValue.of(line);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_SIM_SWAP)
    public Builder setSimSwap(SimSwap simSwap) {
      this.simSwap = OptionalValue.of(simSwap);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_VO_I_P_DETECTION)
    public Builder setVoIPDetection(VoIPDetection voIPDetection) {
      this.voIPDetection = OptionalValue.of(voIPDetection);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_RND)
    public Builder setRnd(Rnd rnd) {
      this.rnd = OptionalValue.of(rnd);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_COUNTRY_CODE)
    public Builder setCountryCode(String countryCode) {
      this.countryCode = OptionalValue.of(countryCode);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_TRACE_ID)
    public Builder setTraceId(String traceId) {
      this.traceId = OptionalValue.of(traceId);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_NUMBER)
    public Builder setNumber(String number) {
      this.number = OptionalValue.of(number);
      return this;
    }

    public NumberLookupResponse build() {
      return new NumberLookupResponseImpl(
          line, simSwap, voIPDetection, rnd, countryCode, traceId, number);
    }
  }
}
