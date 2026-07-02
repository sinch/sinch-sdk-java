package com.sinch.sdk.domains.numberlookup.models.v2.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.numberlookup.models.v2.errors.LookupError;
import java.util.Objects;

@JsonPropertyOrder({RndImpl.JSON_PROPERTY_DISCONNECTED, RndImpl.JSON_PROPERTY_ERROR})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class RndImpl implements Rnd {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_DISCONNECTED = "disconnected";

  private OptionalValue<Boolean> disconnected;

  public static final String JSON_PROPERTY_ERROR = "error";

  private OptionalValue<LookupError> error;

  public RndImpl() {}

  protected RndImpl(OptionalValue<Boolean> disconnected, OptionalValue<LookupError> error) {
    this.disconnected = disconnected;
    this.error = error;
  }

  @JsonIgnore
  public Boolean getDisconnected() {
    return disconnected.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DISCONNECTED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Boolean> disconnected() {
    return disconnected;
  }

  @JsonIgnore
  public LookupError getError() {
    return error.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ERROR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<LookupError> error() {
    return error;
  }

  /** Return true if this RndResponse object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RndImpl rndResponse = (RndImpl) o;
    return Objects.equals(this.disconnected, rndResponse.disconnected)
        && Objects.equals(this.error, rndResponse.error);
  }

  @Override
  public int hashCode() {
    return Objects.hash(disconnected, error);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RndImpl {\n");
    sb.append("    disconnected: ").append(toIndentedString(disconnected)).append("\n");
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
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
  static class Builder implements Rnd.Builder {
    OptionalValue<Boolean> disconnected = OptionalValue.empty();
    OptionalValue<LookupError> error = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_DISCONNECTED)
    public Builder setDisconnected(Boolean disconnected) {
      this.disconnected = OptionalValue.of(disconnected);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_ERROR)
    public Builder setError(LookupError error) {
      this.error = OptionalValue.of(error);
      return this;
    }

    public Rnd build() {
      return new RndImpl(disconnected, error);
    }
  }
}
