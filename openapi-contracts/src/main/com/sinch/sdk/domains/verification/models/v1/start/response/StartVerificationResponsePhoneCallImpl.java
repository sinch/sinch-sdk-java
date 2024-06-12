package com.sinch.sdk.domains.verification.models.v1.start.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.verification.models.v1.VerificationMethod;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  StartVerificationResponsePhoneCallImpl.JSON_PROPERTY_ID,
  StartVerificationResponsePhoneCallImpl.JSON_PROPERTY_METHOD,
  StartVerificationResponsePhoneCallImpl.JSON_PROPERTY_LINKS
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class StartVerificationResponsePhoneCallImpl
    implements StartVerificationResponsePhoneCall,
        com.sinch.sdk.domains.verification.models.v1.start.response.StartVerificationResponse {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_ID = "id";

  private OptionalValue<String> id;

  public static final String JSON_PROPERTY_METHOD = "method";

  private OptionalValue<VerificationMethod> method;

  public static final String JSON_PROPERTY_LINKS = "_links";

  private OptionalValue<List<Link>> links;

  public StartVerificationResponsePhoneCallImpl() {}

  protected StartVerificationResponsePhoneCallImpl(
      OptionalValue<String> id,
      OptionalValue<VerificationMethod> method,
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
  public VerificationMethod getMethod() {
    return method.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_METHOD)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<VerificationMethod> method() {
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

  /** Return true if this StartVerificationPhoneCallResponse object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StartVerificationResponsePhoneCallImpl startVerificationPhoneCallResponse =
        (StartVerificationResponsePhoneCallImpl) o;
    return Objects.equals(this.id, startVerificationPhoneCallResponse.id)
        && Objects.equals(this.method, startVerificationPhoneCallResponse.method)
        && Objects.equals(this.links, startVerificationPhoneCallResponse.links);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, method, links);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StartVerificationResponsePhoneCallImpl {\n");
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
  static class Builder implements StartVerificationResponsePhoneCall.Builder {
    OptionalValue<String> id = OptionalValue.empty();
    OptionalValue<VerificationMethod> method = OptionalValue.of(VerificationMethod.PHONE_CALL);
    OptionalValue<List<Link>> links = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_ID)
    public Builder setId(String id) {
      this.id = OptionalValue.of(id);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_LINKS)
    public Builder setLinks(List<Link> links) {
      this.links = OptionalValue.of(links);
      return this;
    }

    public StartVerificationResponsePhoneCall build() {
      return new StartVerificationResponsePhoneCallImpl(id, method, links);
    }
  }
}
