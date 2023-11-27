package com.sinch.sdk.domains.numbers.models;

import java.util.Collection;

/**
 * Region information related to assigned numbers
 *
 * @since 1.0
 */
public class Region {
  private final String regionCode;

  private final String regionName;

  private final Collection<NumberType> types;

  /**
   * @param regionCode ISO 3166-1 alpha-2 region code. Examples: US, UK or SE.
   * @param regionName Display name of the region. Examples: United States, United Kingdom or
   *     Sweden.
   * @param types A list of the different number types available.
   */
  public Region(String regionCode, String regionName, Collection<NumberType> types) {
    this.regionCode = regionCode;
    this.regionName = regionName;
    this.types = types;
  }

  public String getRegionCode() {
    return regionCode;
  }

  public String getRegionName() {
    return regionName;
  }

  public Collection<NumberType> getTypes() {
    return types;
  }

  @Override
  public String toString() {
    return "AvailableRegion{"
        + "regionCode='"
        + regionCode
        + '\''
        + ", regionName='"
        + regionName
        + '\''
        + ", types="
        + types
        + '}';
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {

    private String regionCode;

    private String regionName;

    private Collection<NumberType> types;

    private Builder() {}

    public Region build() {
      return new Region(regionCode, regionName, types);
    }

    public Builder setRegionCode(String regionCode) {
      this.regionCode = regionCode;
      return this;
    }

    public Builder setRegionName(String regionName) {
      this.regionName = regionName;
      return this;
    }

    public Builder setTypes(Collection<NumberType> types) {
      this.types = types;
      return this;
    }
  }
}
