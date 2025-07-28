package com.sinch.sdk.domains.verification.models.v1.start.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.verification.models.v1.start.internal.VerificationMethodStart;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  VerificationStartResponsePhoneCallImpl.JSON_PROPERTY_ID,
  VerificationStartResponsePhoneCallImpl.JSON_PROPERTY_METHOD,
  VerificationStartResponsePhoneCallImpl.JSON_PROPERTY_LINKS
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class VerificationStartResponsePhoneCallImpl
    implements VerificationStartResponsePhoneCall,
        com.sinch.sdk.domains.verification.models.v1.start.response.VerificationStartResponse {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_ID = "id";

  private OptionalValue<String> id;

  public static final String JSON_PROPERTY_METHOD = "method";

  private OptionalValue<VerificationMethodStart> method;

  public static final String JSON_PROPERTY_LINKS = "_links";

  private OptionalValue<List<Link>> links;

  public VerificationStartResponsePhoneCallImpl() {}

  protected VerificationStartResponsePhoneCallImpl(
      OptionalValue<String> id,
      OptionalValue<VerificationMethodStart> method,
      OptionalValue<List<Link>> links) {
    this.id = id;
    this.method = method;
    this.links = links;
  }

  @JsonIgnore
  public String getId() {
    return id.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> id() {
    return id;
  }

  @JsonIgnore
  public VerificationMethodStart getMethod() {
    return method.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_METHOD)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<VerificationMethodStart> method() {
    return method;
  }

  @JsonIgnore
  public List<Link> getLinks() {
    return links.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_LINKS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<Link>> links() {
    return links;
  }

  /** Return true if this VerificationStartResponsePhoneCall object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VerificationStartResponsePhoneCallImpl verificationStartResponsePhoneCall =
        (VerificationStartResponsePhoneCallImpl) o;
    return Objects.equals(this.id, verificationStartResponsePhoneCall.id)
        && Objects.equals(this.method, verificationStartResponsePhoneCall.method)
        && Objects.equals(this.links, verificationStartResponsePhoneCall.links);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, method, links);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VerificationStartResponsePhoneCallImpl {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    method: ").append(toIndentedString(method)).append("\n");
    sb.append("    links: ").append(toIndentedString(links)).append("\n");
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
  static class Builder implements VerificationStartResponsePhoneCall.Builder {
    OptionalValue<String> id = OptionalValue.empty();
    OptionalValue<VerificationMethodStart> method =
        OptionalValue.of(VerificationMethodStart.PHONE_CALL);
    OptionalValue<List<Link>> links = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_ID, required = true)
    public Builder setId(String id) {
      this.id = OptionalValue.of(id);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_LINKS)
    public Builder setLinks(List<Link> links) {
      this.links = OptionalValue.of(links);
      return this;
    }

    public VerificationStartResponsePhoneCall build() {
      return new VerificationStartResponsePhoneCallImpl(id, method, links);
    }
  }
}
