package com.sinch.sdk.domains.mailgun.models.v1.templates.request;

import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

public class GetTemplateQueryParametersImpl implements GetTemplateQueryParameters {

  private final OptionalValue<Boolean> active;

  private GetTemplateQueryParametersImpl(OptionalValue<Boolean> active) {
    this.active = active;
  }

  public OptionalValue<Boolean> getActive() {
    return active;
  }

  /**
   * Return true if this GETV3DomainNameTemplatesTemplateName-QueryParameters object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetTemplateQueryParametersImpl geTV3DomainNameTemplatesTemplateNameQueryParameters =
        (GetTemplateQueryParametersImpl) o;
    return Objects.equals(this.active, geTV3DomainNameTemplatesTemplateNameQueryParameters.active);
  }

  @Override
  public int hashCode() {
    return Objects.hash(active);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetTemplateQueryParametersImpl {\n");
    sb.append("    active: ").append(toIndentedString(active)).append("\n");
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

  static class Builder implements GetTemplateQueryParameters.Builder {
    OptionalValue<Boolean> active = OptionalValue.empty();

    protected Builder() {}

    protected Builder(GetTemplateQueryParameters _parameters) {
      if (null == _parameters) {
        return;
      }
      GetTemplateQueryParametersImpl parameters = (GetTemplateQueryParametersImpl) _parameters;
      this.active = parameters.getActive();
    }

    public Builder setActive(Boolean active) {
      this.active = OptionalValue.of(active);
      return this;
    }

    public GetTemplateQueryParameters build() {
      return new GetTemplateQueryParametersImpl(active);
    }
  }
}
