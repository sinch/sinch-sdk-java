package com.sinch.sdk.domains.numbers.models.v1.response.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.numbers.models.v1.ActiveNumber;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  ActiveNumberListResponseInternalImpl.JSON_PROPERTY_ACTIVE_NUMBERS,
  ActiveNumberListResponseInternalImpl.JSON_PROPERTY_NEXT_PAGE_TOKEN,
  ActiveNumberListResponseInternalImpl.JSON_PROPERTY_TOTAL_SIZE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ActiveNumberListResponseInternalImpl implements ActiveNumberListResponseInternal {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_ACTIVE_NUMBERS = "activeNumbers";

  private OptionalValue<List<ActiveNumber>> activeNumbers;

  public static final String JSON_PROPERTY_NEXT_PAGE_TOKEN = "nextPageToken";

  private OptionalValue<String> nextPageToken;

  public static final String JSON_PROPERTY_TOTAL_SIZE = "totalSize";

  private OptionalValue<Integer> totalSize;

  public ActiveNumberListResponseInternalImpl() {}

  protected ActiveNumberListResponseInternalImpl(
      OptionalValue<List<ActiveNumber>> activeNumbers,
      OptionalValue<String> nextPageToken,
      OptionalValue<Integer> totalSize) {
    this.activeNumbers = activeNumbers;
    this.nextPageToken = nextPageToken;
    this.totalSize = totalSize;
  }

  @JsonIgnore
  public List<ActiveNumber> getActiveNumbers() {
    return activeNumbers.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ACTIVE_NUMBERS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<ActiveNumber>> activeNumbers() {
    return activeNumbers;
  }

  @JsonIgnore
  public String getNextPageToken() {
    return nextPageToken.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_NEXT_PAGE_TOKEN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> nextPageToken() {
    return nextPageToken;
  }

  @JsonIgnore
  public Integer getTotalSize() {
    return totalSize.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TOTAL_SIZE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Integer> totalSize() {
    return totalSize;
  }

  /** Return true if this ActiveNumbersResponse object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ActiveNumberListResponseInternalImpl activeNumbersResponse =
        (ActiveNumberListResponseInternalImpl) o;
    return Objects.equals(this.activeNumbers, activeNumbersResponse.activeNumbers)
        && Objects.equals(this.nextPageToken, activeNumbersResponse.nextPageToken)
        && Objects.equals(this.totalSize, activeNumbersResponse.totalSize);
  }

  @Override
  public int hashCode() {
    return Objects.hash(activeNumbers, nextPageToken, totalSize);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ActiveNumberListResponseInternalImpl {\n");
    sb.append("    activeNumbers: ").append(toIndentedString(activeNumbers)).append("\n");
    sb.append("    nextPageToken: ").append(toIndentedString(nextPageToken)).append("\n");
    sb.append("    totalSize: ").append(toIndentedString(totalSize)).append("\n");
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
  static class Builder implements ActiveNumberListResponseInternal.Builder {
    OptionalValue<List<ActiveNumber>> activeNumbers = OptionalValue.empty();
    OptionalValue<String> nextPageToken = OptionalValue.empty();
    OptionalValue<Integer> totalSize = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_ACTIVE_NUMBERS)
    public Builder setActiveNumbers(List<ActiveNumber> activeNumbers) {
      this.activeNumbers = OptionalValue.of(activeNumbers);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_NEXT_PAGE_TOKEN)
    public Builder setNextPageToken(String nextPageToken) {
      this.nextPageToken = OptionalValue.of(nextPageToken);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_TOTAL_SIZE)
    public Builder setTotalSize(Integer totalSize) {
      this.totalSize = OptionalValue.of(totalSize);
      return this;
    }

    public ActiveNumberListResponseInternal build() {
      return new ActiveNumberListResponseInternalImpl(activeNumbers, nextPageToken, totalSize);
    }
  }
}
