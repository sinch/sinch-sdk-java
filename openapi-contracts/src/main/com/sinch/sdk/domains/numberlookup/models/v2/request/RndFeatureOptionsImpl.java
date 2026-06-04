package com.sinch.sdk.domains.numberlookup.models.v2.request;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.time.LocalDate;
import java.util.Objects;

@JsonPropertyOrder({RndFeatureOptionsImpl.JSON_PROPERTY_CONTACT_DATE})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class RndFeatureOptionsImpl implements RndFeatureOptions {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CONTACT_DATE = "contactDate";

  private OptionalValue<LocalDate> contactDate;

  public RndFeatureOptionsImpl() {}

  protected RndFeatureOptionsImpl(OptionalValue<LocalDate> contactDate) {
    this.contactDate = contactDate;
  }

  @JsonIgnore
  public LocalDate getContactDate() {
    return contactDate.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CONTACT_DATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<LocalDate> contactDate() {
    return contactDate;
  }

  /** Return true if this RndFeatureOptions object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RndFeatureOptionsImpl rndFeatureOptions = (RndFeatureOptionsImpl) o;
    return Objects.equals(this.contactDate, rndFeatureOptions.contactDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(contactDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RndFeatureOptionsImpl {\n");
    sb.append("    contactDate: ").append(toIndentedString(contactDate)).append("\n");
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
  static class Builder implements RndFeatureOptions.Builder {
    OptionalValue<LocalDate> contactDate = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_CONTACT_DATE)
    public Builder setContactDate(LocalDate contactDate) {
      this.contactDate = OptionalValue.of(contactDate);
      return this;
    }

    public RndFeatureOptions build() {
      return new RndFeatureOptionsImpl(contactDate);
    }
  }
}
