package com.sinch.sdk.domains.verification.models.v1.start.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  StartVerificationResponseSMSImpl.JSON_PROPERTY_ID,
  StartVerificationResponseSMSImpl.JSON_PROPERTY_METHOD,
  StartVerificationResponseSMSImpl.JSON_PROPERTY_SMS,
  StartVerificationResponseSMSImpl.JSON_PROPERTY_LINKS
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class StartVerificationResponseSMSImpl
    implements StartVerificationResponseSMS,
        com.sinch.sdk.domains.verification.models.v1.response.StartVerificationResponse {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_ID = "id";

  private OptionalValue<String> id;

  public static final String JSON_PROPERTY_METHOD = "method";

  private OptionalValue<String> method;

  public static final String JSON_PROPERTY_SMS = "sms";

  private OptionalValue<StartVerificationResponseSMSContent> sms;

  public static final String JSON_PROPERTY_LINKS = "_links";

  private OptionalValue<List<Link>> links;

  public StartVerificationResponseSMSImpl() {}

  protected StartVerificationResponseSMSImpl(
      OptionalValue<String> id,
      OptionalValue<String> method,
      OptionalValue<StartVerificationResponseSMSContent> sms,
      OptionalValue<List<Link>> links) {
    this.id = id;
    this.method = method;
    this.sms = sms;
    this.links = links;
  }

  @JsonIgnore
  public String getId() {
    return id.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> id() {
    return id;
  }

  @JsonIgnore
  public String getMethod() {
    return method.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_METHOD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> method() {
    return method;
  }

  @JsonIgnore
  public StartVerificationResponseSMSContent getSms() {
    return sms.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SMS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<StartVerificationResponseSMSContent> sms() {
    return sms;
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

  /** Return true if this SMSInitiateVerificationResponse object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StartVerificationResponseSMSImpl smSInitiateVerificationResponse =
        (StartVerificationResponseSMSImpl) o;
    return Objects.equals(this.id, smSInitiateVerificationResponse.id)
        && Objects.equals(this.method, smSInitiateVerificationResponse.method)
        && Objects.equals(this.sms, smSInitiateVerificationResponse.sms)
        && Objects.equals(this.links, smSInitiateVerificationResponse.links);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, method, sms, links);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StartVerificationResponseSMSImpl {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    method: ").append(toIndentedString(method)).append("\n");
    sb.append("    sms: ").append(toIndentedString(sms)).append("\n");
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
  static class Builder implements StartVerificationResponseSMS.Builder {
    OptionalValue<String> id = OptionalValue.empty();
    OptionalValue<String> method = OptionalValue.empty();
    OptionalValue<StartVerificationResponseSMSContent> sms = OptionalValue.empty();
    OptionalValue<List<Link>> links = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_ID)
    public Builder setId(String id) {
      this.id = OptionalValue.of(id);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_METHOD)
    public Builder setMethod(String method) {
      this.method = OptionalValue.of(method);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_SMS)
    public Builder setSms(StartVerificationResponseSMSContent sms) {
      this.sms = OptionalValue.of(sms);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_LINKS)
    public Builder setLinks(List<Link> links) {
      this.links = OptionalValue.of(links);
      return this;
    }

    public StartVerificationResponseSMS build() {
      return new StartVerificationResponseSMSImpl(id, method, sms, links);
    }
  }
}
