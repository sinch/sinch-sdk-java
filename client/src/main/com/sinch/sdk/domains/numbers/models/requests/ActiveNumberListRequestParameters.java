package com.sinch.sdk.domains.numbers.models.requests;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.numbers.models.Capability;
import com.sinch.sdk.domains.numbers.models.NumberPattern;
import com.sinch.sdk.domains.numbers.models.NumberType;
import com.sinch.sdk.domains.numbers.models.OrderBy;
import java.util.Collection;

/**
 * Parameters request to list active numbers for a project
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/numbers/api-reference/numbers/tag/Active-Number">https://developers.sinch.com/docs/numbers/api-reference/numbers/tag/Active-Number/</a>
 * @since 1.0
 */
public class ActiveNumberListRequestParameters {

  private final OptionalValue<String> regionCode;
  private final OptionalValue<NumberType> type;
  private final OptionalValue<NumberPattern> numberPattern;
  private final OptionalValue<Collection<Capability>> capabilities;
  private final OptionalValue<Integer> pageSize;
  private final OptionalValue<String> pageToken;
  private final OptionalValue<OrderBy> orderBy;

  private ActiveNumberListRequestParameters(
      OptionalValue<String> regionCode,
      OptionalValue<NumberType> type,
      OptionalValue<NumberPattern> numberPattern,
      OptionalValue<Collection<Capability>> capabilities,
      OptionalValue<Integer> pageSize,
      OptionalValue<String> pageToken,
      OptionalValue<OrderBy> orderBy) {
    this.regionCode = regionCode;
    this.type = type;
    this.numberPattern = numberPattern;
    this.capabilities = capabilities;
    this.pageSize = pageSize;
    this.pageToken = pageToken;
    this.orderBy = orderBy;
  }

  public OptionalValue<String> getRegionCode() {
    return regionCode;
  }

  public OptionalValue<NumberType> getType() {
    return type;
  }

  public OptionalValue<NumberPattern> getNumberPattern() {
    return numberPattern;
  }

  public OptionalValue<Collection<Capability>> getCapabilities() {
    return capabilities;
  }

  public OptionalValue<Integer> getPageSize() {
    return pageSize;
  }

  public OptionalValue<String> getPageToken() {
    return pageToken;
  }

  public OptionalValue<OrderBy> getOrderBy() {
    return orderBy;
  }

  @Override
  public String toString() {
    return "ActiveNumberListRequestParameters{"
        + "regionCode='"
        + regionCode
        + '\''
        + ", type="
        + type
        + ", numberPattern="
        + numberPattern
        + ", capabilities="
        + capabilities
        + ", pageSize="
        + pageSize
        + ", pageToken="
        + pageToken
        + ", orderBy="
        + orderBy
        + '}';
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {

    OptionalValue<String> regionCode = OptionalValue.empty();
    OptionalValue<NumberType> type = OptionalValue.empty();
    OptionalValue<NumberPattern> numberPattern = OptionalValue.empty();
    OptionalValue<Collection<Capability>> capabilities = OptionalValue.empty();
    OptionalValue<Integer> pageSize = OptionalValue.empty();
    OptionalValue<String> pageToken = OptionalValue.empty();
    OptionalValue<OrderBy> orderBy = OptionalValue.empty();

    private Builder() {}

    public Builder(ActiveNumberListRequestParameters parameters) {
      parameters.regionCode.ifPresent(this::setRegionCode);
      parameters.type.ifPresent(this::setType);
      parameters.numberPattern.ifPresent(this::setNumberPattern);
      parameters.capabilities.ifPresent(this::setCapabilities);
      parameters.pageSize.ifPresent(this::setPageSize);
      parameters.pageToken.ifPresent(this::setPageToken);
      parameters.orderBy.ifPresent(this::setOrderBy);
    }

    /**
     * @param regionCode Region code to filter by. ISO 3166-1 alpha-2 country code of the phone
     *     number. Example: US, GB or SE.
     * @return Current builder
     */
    public Builder setRegionCode(String regionCode) {
      this.regionCode = OptionalValue.of(regionCode);
      return this;
    }

    /**
     * @param type Number type to filter by
     * @return Current builder
     */
    public Builder setType(NumberType type) {
      this.type = OptionalValue.of(type);
      return this;
    }

    /**
     * @param numberPattern Pattern to search for
     * @return Current builder
     */
    public Builder setNumberPattern(NumberPattern numberPattern) {
      this.numberPattern = OptionalValue.of(numberPattern);
      return this;
    }

    /**
     * @param capabilities Number capabilities to filter by
     * @return Current builder
     */
    public Builder setCapabilities(Collection<Capability> capabilities) {
      this.capabilities = OptionalValue.of(capabilities);
      return this;
    }

    /**
     * @param pageSize The maximum number of items to return.
     * @return Current builder
     */
    public Builder setPageSize(Integer pageSize) {
      this.pageSize = OptionalValue.of(pageSize);
      return this;
    }

    /**
     * @param pageToken The next page token value returned from a previous List request, if any
     * @return Current builder
     */
    public Builder setPageToken(String pageToken) {
      this.pageToken = OptionalValue.of(pageToken);
      return this;
    }

    /**
     * @param orderBy Ordering results
     * @return Current builder
     */
    public Builder setOrderBy(OrderBy orderBy) {
      this.orderBy = OptionalValue.of(orderBy);
      return this;
    }

    public ActiveNumberListRequestParameters build() {
      return new ActiveNumberListRequestParameters(
          regionCode, type, numberPattern, capabilities, pageSize, pageToken, orderBy);
    }
  }
}
