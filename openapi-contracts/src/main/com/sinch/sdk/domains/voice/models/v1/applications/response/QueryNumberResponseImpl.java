package com.sinch.sdk.domains.voice.models.v1.applications.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({QueryNumberResponseImpl.JSON_PROPERTY_NUMBER})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class QueryNumberResponseImpl implements QueryNumberResponse {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_NUMBER = "number";

  private OptionalValue<QueryNumberInformation> number;

  public QueryNumberResponseImpl() {}

  protected QueryNumberResponseImpl(OptionalValue<QueryNumberInformation> number) {
    this.number = number;
  }

  @JsonIgnore
  public QueryNumberInformation getNumber() {
    return number.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<QueryNumberInformation> number() {
    return number;
  }

  /** Return true if this getQueryNumber object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    QueryNumberResponseImpl getQueryNumber = (QueryNumberResponseImpl) o;
    return Objects.equals(this.number, getQueryNumber.number);
  }

  @Override
  public int hashCode() {
    return Objects.hash(number);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class QueryNumberResponseImpl {\n");
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
  static class Builder implements QueryNumberResponse.Builder {
    OptionalValue<QueryNumberInformation> number = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_NUMBER)
    public Builder setNumber(QueryNumberInformation number) {
      this.number = OptionalValue.of(number);
      return this;
    }

    public QueryNumberResponse build() {
      return new QueryNumberResponseImpl(number);
    }
  }
}
