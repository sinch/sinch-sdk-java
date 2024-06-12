package com.sinch.sdk.domains.verification.models.v1.start.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.verification.models.v1.VerificationMethod;
import com.sinch.sdk.domains.verification.models.v1.start.response.internal.StartVerificationResponseSmsContent;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  StartVerificationResponseSmsImpl.JSON_PROPERTY_ID,
  StartVerificationResponseSmsImpl.JSON_PROPERTY_METHOD,
  StartVerificationResponseSmsImpl.JSON_PROPERTY_LINKS,
  StartVerificationResponseSmsImpl.JSON_PROPERTY_SMS
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class StartVerificationResponseSmsImpl
    implements StartVerificationResponseSms,
        com.sinch.sdk.domains.verification.models.v1.start.response.StartVerificationResponse {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_ID = "id";

  private OptionalValue<String> id;

  public static final String JSON_PROPERTY_METHOD = "method";

  private OptionalValue<VerificationMethod> method;

  public static final String JSON_PROPERTY_LINKS = "_links";

  private OptionalValue<List<Link>> links;

  public static final String JSON_PROPERTY_SMS = "sms";

  private OptionalValue<StartVerificationResponseSmsContent> sms;

  public StartVerificationResponseSmsImpl() {}

  protected StartVerificationResponseSmsImpl(
      OptionalValue<String> id,
      OptionalValue<VerificationMethod> method,
      OptionalValue<List<Link>> links,
      OptionalValue<StartVerificationResponseSmsContent> sms) {
    this.id = id;
    this.method = method;
    this.links = links;
    this.sms = sms;
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

  @JsonIgnore
  public StartVerificationResponseSmsContent getSms() {
    return sms.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SMS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<StartVerificationResponseSmsContent> sms() {
    return sms;
  }

  @JsonIgnore
  public String getTemplate() {
    if (null == sms || !sms.isPresent() || null == sms.get().getTemplate()) {
      return null;
    }
    return sms.get().getTemplate();
  }

  public OptionalValue<String> template() {
    return null != sms
        ? sms.map(StartVerificationResponseSmsContent::getTemplate)
        : OptionalValue.empty();
  }

  @JsonIgnore
  public Integer getInterceptionTimeout() {
    if (null == sms || !sms.isPresent() || null == sms.get().getInterceptionTimeout()) {
      return null;
    }
    return sms.get().getInterceptionTimeout();
  }

  public OptionalValue<Integer> interceptionTimeout() {
    return null != sms
        ? sms.map(StartVerificationResponseSmsContent::getInterceptionTimeout)
        : OptionalValue.empty();
  }

  /** Return true if this StartVerificationSmsResponse object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StartVerificationResponseSmsImpl startVerificationSmsResponse =
        (StartVerificationResponseSmsImpl) o;
    return Objects.equals(this.id, startVerificationSmsResponse.id)
        && Objects.equals(this.method, startVerificationSmsResponse.method)
        && Objects.equals(this.links, startVerificationSmsResponse.links)
        && Objects.equals(this.sms, startVerificationSmsResponse.sms);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, method, links, sms);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StartVerificationResponseSmsImpl {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    method: ").append(toIndentedString(method)).append("\n");
    sb.append("    links: ").append(toIndentedString(links)).append("\n");
    sb.append("    sms: ").append(toIndentedString(sms)).append("\n");
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
  static class Builder implements StartVerificationResponseSms.Builder {
    OptionalValue<String> id = OptionalValue.empty();
    OptionalValue<VerificationMethod> method = OptionalValue.of(VerificationMethod.SMS);
    OptionalValue<List<Link>> links = OptionalValue.empty();
    OptionalValue<StartVerificationResponseSmsContent> sms = OptionalValue.empty();

    StartVerificationResponseSmsContent.Builder _delegatedBuilder = null;

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

    @JsonProperty(JSON_PROPERTY_SMS)
    public Builder setSms(StartVerificationResponseSmsContent sms) {
      this.sms = OptionalValue.of(sms);
      return this;
    }

    @JsonIgnore
    public Builder setTemplate(String template) {
      getDelegatedBuilder().setTemplate(template);
      return this;
    }

    @JsonIgnore
    public Builder setInterceptionTimeout(Integer interceptionTimeout) {
      getDelegatedBuilder().setInterceptionTimeout(interceptionTimeout);
      return this;
    }

    private StartVerificationResponseSmsContent.Builder getDelegatedBuilder() {
      if (null == _delegatedBuilder) {
        this._delegatedBuilder = StartVerificationResponseSmsContent.builder();
      }
      return this._delegatedBuilder;
    }

    public StartVerificationResponseSms build() {
      // delegated builder was used: filling the related source of delegation field
      if (null != this._delegatedBuilder) {
        this.sms = OptionalValue.of(this._delegatedBuilder.build());
      }
      return new StartVerificationResponseSmsImpl(id, method, links, sms);
    }
  }
}
