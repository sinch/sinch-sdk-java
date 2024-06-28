package com.sinch.sdk.domains.numbers.models.v1.regions.available.request;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.numbers.models.v1.NumberType;
import java.util.Collection;
import java.util.Objects;

/**
 * Parameters request to list all regions by criteria
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/numbers/api-reference/numbers/tag/Available-Regions/">https://developers.sinch.com/docs/numbers/api-reference/numbers/tag/Available-Regions/</a>
 * @since 1.0
 */
public class AvailableRegionListRequest {

  private final OptionalValue<Collection<NumberType>> types;

  private AvailableRegionListRequest(OptionalValue<Collection<NumberType>> types) {
    this.types = types;
  }

  public OptionalValue<Collection<NumberType>> getTypes() {
    return types;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {
    OptionalValue<Collection<NumberType>> types = OptionalValue.empty();

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof Builder)) {
        return false;
      }
      Builder builder = (Builder) o;
      return Objects.equals(types, builder.types);
    }

    @Override
    public int hashCode() {
      return Objects.hash(types);
    }

    private Builder() {}

    /**
     * @param types Only return regions for which numbers are provided with the given types
     * @return current builder
     */
    public Builder setTypes(Collection<NumberType> types) {
      this.types = OptionalValue.of(types);
      return this;
    }

    public AvailableRegionListRequest build() {
      return new AvailableRegionListRequest(types);
    }
  }
}
