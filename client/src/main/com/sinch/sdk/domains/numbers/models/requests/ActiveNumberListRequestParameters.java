package com.sinch.sdk.domains.numbers.models.requests;

import com.sinch.sdk.domains.numbers.models.Capability;
import com.sinch.sdk.domains.numbers.models.NumberPattern;
import com.sinch.sdk.domains.numbers.models.NumberType;
import com.sinch.sdk.domains.numbers.models.OrderBy;
import java.util.Collection;
import java.util.Optional;

/**
 * Parameters request to list active numbers for a project
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/numbers/api-reference/numbers/tag/Active-Number">https://developers.sinch.com/docs/numbers/api-reference/numbers/tag/Active-Number/</a>
 * @since 1.0
 */
public class ActiveNumberListRequestParameters {
  private final String regionCode;
  private final NumberType type;
  private final NumberPattern numberPattern;
  private final Collection<Capability> capabilities;
  private final Integer pageSize;
  private final String pageToken;
  private final OrderBy orderBy;

  /**
   * @param regionCode Region code to filter by. ISO 3166-1 alpha-2 country code of the phone
   *     number. Example: US, GB or SE.
   * @param type Number type to filter by
   * @param numberPattern Pattern to search for
   * @param capabilities Number capabilities to filter by
   * @param pageSize The maximum number of items to return.
   * @param pageToken The next page token value returned from a previous List request, if any
   * @param orderBy Ordering results
   */
  public ActiveNumberListRequestParameters(
      String regionCode,
      NumberType type,
      NumberPattern numberPattern,
      Collection<Capability> capabilities,
      Integer pageSize,
      String pageToken,
      OrderBy orderBy) {
    this.regionCode = regionCode;
    this.type = type;
    this.numberPattern = numberPattern;
    this.capabilities = capabilities;
    this.pageSize = pageSize;
    this.pageToken = pageToken;
    this.orderBy = orderBy;
  }

  public String getRegionCode() {
    return regionCode;
  }

  public NumberType getType() {
    return type;
  }

  public Optional<NumberPattern> getNumberPattern() {
    return Optional.ofNullable(numberPattern);
  }

  public Optional<Collection<Capability>> getCapabilities() {
    return Optional.ofNullable(capabilities);
  }

  public Optional<Integer> getPageSize() {
    return Optional.ofNullable(pageSize);
  }

  public Optional<String> getPageToken() {
    return Optional.ofNullable(pageToken);
  }

  public Optional<OrderBy> getOrderBy() {
    return Optional.ofNullable(orderBy);
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
    String regionCode;
    NumberType type;
    NumberPattern numberPattern;
    Collection<Capability> capabilities;
    Integer pageSize;
    String pageToken;
    OrderBy orderBy;

    private Builder() {}

    public Builder(ActiveNumberListRequestParameters parameters) {
      this.setRegionCode(parameters.regionCode)
          .setType(parameters.type)
          .setNumberPattern(parameters.numberPattern)
          .setCapabilities(parameters.capabilities)
          .setPageSize(parameters.pageSize)
          .setPageToken(parameters.pageToken)
          .setOrderBy(parameters.orderBy);
    }

    public Builder setRegionCode(String regionCode) {
      this.regionCode = regionCode;
      return this;
    }

    public Builder setType(NumberType type) {
      this.type = type;
      return this;
    }

    public Builder setNumberPattern(NumberPattern numberPattern) {
      this.numberPattern = numberPattern;
      return this;
    }

    public Builder setCapabilities(Collection<Capability> capabilities) {
      this.capabilities = capabilities;
      return this;
    }

    public Builder setPageSize(Integer pageSize) {
      this.pageSize = pageSize;
      return this;
    }

    public Builder setPageToken(String pageToken) {
      this.pageToken = pageToken;
      return this;
    }

    public Builder setOrderBy(OrderBy orderBy) {
      this.orderBy = orderBy;
      return this;
    }

    public ActiveNumberListRequestParameters build() {
      return new ActiveNumberListRequestParameters(
          regionCode, type, numberPattern, capabilities, pageSize, pageToken, orderBy);
    }
  }
}
