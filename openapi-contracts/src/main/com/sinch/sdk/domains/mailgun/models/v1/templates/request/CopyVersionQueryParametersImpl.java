package com.sinch.sdk.domains.mailgun.models.v1.templates.request;

import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

public class CopyVersionQueryParametersImpl implements CopyVersionQueryParameters {

  private final OptionalValue<String> comment;

  private CopyVersionQueryParametersImpl(OptionalValue<String> comment) {
    this.comment = comment;
  }

  public OptionalValue<String> getComment() {
    return comment;
  }

  /**
   * Return true if this
   * PUTV3DomainNameTemplatesTemplateNameVersionsVersionNameCopyNewVersionName-QueryParameters
   * object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CopyVersionQueryParametersImpl
        puTV3DomainNameTemplatesTemplateNameVersionsVersionNameCopyNewVersionNameQueryParameters =
            (CopyVersionQueryParametersImpl) o;
    return Objects.equals(
        this.comment,
        puTV3DomainNameTemplatesTemplateNameVersionsVersionNameCopyNewVersionNameQueryParameters
            .comment);
  }

  @Override
  public int hashCode() {
    return Objects.hash(comment);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CopyVersionQueryParametersImpl {\n");
    sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
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

  static class Builder implements CopyVersionQueryParameters.Builder {
    OptionalValue<String> comment = OptionalValue.empty();

    protected Builder() {}

    protected Builder(CopyVersionQueryParameters _parameters) {
      if (null == _parameters) {
        return;
      }
      CopyVersionQueryParametersImpl parameters = (CopyVersionQueryParametersImpl) _parameters;
      this.comment = parameters.getComment();
    }

    public Builder setComment(String comment) {
      this.comment = OptionalValue.of(comment);
      return this;
    }

    public CopyVersionQueryParameters build() {
      return new CopyVersionQueryParametersImpl(comment);
    }
  }
}
