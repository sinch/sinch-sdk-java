package com.sinch.sdk.domains.mailgun.models.v1.emails.request;

import com.sinch.sdk.core.databind.annotation.FormSerialize;
import com.sinch.sdk.core.databind.annotation.Property;
import com.sinch.sdk.core.databind.annotation.Required;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.List;
import java.util.Objects;

public class ResendRequestImpl implements ResendRequest {
  private static final long serialVersionUID = 1L;

  public static final String PROPERTY_TO = "to";

  private OptionalValue<List<String>> to;

  public ResendRequestImpl() {}

  protected ResendRequestImpl(OptionalValue<List<String>> to) {
    this.to = to;
  }

  public List<String> getTo() {
    return to.orElse(null);
  }

  @Required
  @Property(PROPERTY_TO)
  @FormSerialize(
      using =
          com.sinch.sdk.domains.mailgun.api.v1.adapters.ArrayToCommaSeparatedFormSerializer.class)
  public OptionalValue<List<String>> to() {
    return to;
  }

  /**
   * Return true if this
   * POST-v3-domains-domain_name-messages-storage_key-multipart-form-data-RequestBody object is
   * equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResendRequestImpl poSTV3DomainsDomainNameMessagesStorageKeyMultipartFormDataRequestBody =
        (ResendRequestImpl) o;
    return Objects.equals(
        this.to, poSTV3DomainsDomainNameMessagesStorageKeyMultipartFormDataRequestBody.to);
  }

  @Override
  public int hashCode() {
    return Objects.hash(to);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResendRequestImpl {\n");
    sb.append("    to: ").append(toIndentedString(to)).append("\n");
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

  static class Builder implements ResendRequest.Builder {
    OptionalValue<List<String>> to = OptionalValue.empty();

    @Property(value = PROPERTY_TO)
    public Builder setTo(List<String> to) {
      this.to = OptionalValue.of(to);
      return this;
    }

    public ResendRequest build() {
      return new ResendRequestImpl(to);
    }
  }
}
