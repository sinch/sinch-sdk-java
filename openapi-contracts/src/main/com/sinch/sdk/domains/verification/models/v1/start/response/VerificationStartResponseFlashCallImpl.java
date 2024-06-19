package com.sinch.sdk.domains.verification.models.v1.start.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.verification.models.v1.VerificationMethod;
import com.sinch.sdk.domains.verification.models.v1.start.response.internal.VerificationStartResponseFlashCallContent;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  VerificationStartResponseFlashCallImpl.JSON_PROPERTY_ID,
  VerificationStartResponseFlashCallImpl.JSON_PROPERTY_METHOD,
  VerificationStartResponseFlashCallImpl.JSON_PROPERTY_LINKS,
  VerificationStartResponseFlashCallImpl.JSON_PROPERTY_FLASH_CALL
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class VerificationStartResponseFlashCallImpl
    implements VerificationStartResponseFlashCall,
        com.sinch.sdk.domains.verification.models.v1.start.response.VerificationStartResponse {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_ID = "id";

  private OptionalValue<String> id;

  public static final String JSON_PROPERTY_METHOD = "method";

  private OptionalValue<VerificationMethod> method;

  public static final String JSON_PROPERTY_LINKS = "_links";

  private OptionalValue<List<Link>> links;

  public static final String JSON_PROPERTY_FLASH_CALL = "flashCall";

  private OptionalValue<VerificationStartResponseFlashCallContent> flashCall;

  public VerificationStartResponseFlashCallImpl() {}

  protected VerificationStartResponseFlashCallImpl(
      OptionalValue<String> id,
      OptionalValue<VerificationMethod> method,
      OptionalValue<List<Link>> links,
      OptionalValue<VerificationStartResponseFlashCallContent> flashCall) {
    this.id = id;
    this.method = method;
    this.links = links;
    this.flashCall = flashCall;
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
  public VerificationStartResponseFlashCallContent getFlashCall() {
    return flashCall.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_FLASH_CALL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<VerificationStartResponseFlashCallContent> flashCall() {
    return flashCall;
  }

  @JsonIgnore
  public String getCliFilter() {
    if (null == flashCall || !flashCall.isPresent() || null == flashCall.get().getCliFilter()) {
      return null;
    }
    return flashCall.get().getCliFilter();
  }

  public OptionalValue<String> cliFilter() {
    return null != flashCall
        ? flashCall.map(VerificationStartResponseFlashCallContent::getCliFilter)
        : OptionalValue.empty();
  }

  @JsonIgnore
  public Integer getInterceptionTimeout() {
    if (null == flashCall
        || !flashCall.isPresent()
        || null == flashCall.get().getInterceptionTimeout()) {
      return null;
    }
    return flashCall.get().getInterceptionTimeout();
  }

  public OptionalValue<Integer> interceptionTimeout() {
    return null != flashCall
        ? flashCall.map(VerificationStartResponseFlashCallContent::getInterceptionTimeout)
        : OptionalValue.empty();
  }

  @JsonIgnore
  public Integer getReportTimeout() {
    if (null == flashCall || !flashCall.isPresent() || null == flashCall.get().getReportTimeout()) {
      return null;
    }
    return flashCall.get().getReportTimeout();
  }

  public OptionalValue<Integer> reportTimeout() {
    return null != flashCall
        ? flashCall.map(VerificationStartResponseFlashCallContent::getReportTimeout)
        : OptionalValue.empty();
  }

  @JsonIgnore
  public Integer getDenyCallAfter() {
    if (null == flashCall || !flashCall.isPresent() || null == flashCall.get().getDenyCallAfter()) {
      return null;
    }
    return flashCall.get().getDenyCallAfter();
  }

  public OptionalValue<Integer> denyCallAfter() {
    return null != flashCall
        ? flashCall.map(VerificationStartResponseFlashCallContent::getDenyCallAfter)
        : OptionalValue.empty();
  }

  /** Return true if this VerificationStartResponseFlashCall object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VerificationStartResponseFlashCallImpl verificationStartResponseFlashCall =
        (VerificationStartResponseFlashCallImpl) o;
    return Objects.equals(this.id, verificationStartResponseFlashCall.id)
        && Objects.equals(this.method, verificationStartResponseFlashCall.method)
        && Objects.equals(this.links, verificationStartResponseFlashCall.links)
        && Objects.equals(this.flashCall, verificationStartResponseFlashCall.flashCall);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, method, links, flashCall);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VerificationStartResponseFlashCallImpl {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    method: ").append(toIndentedString(method)).append("\n");
    sb.append("    links: ").append(toIndentedString(links)).append("\n");
    sb.append("    flashCall: ").append(toIndentedString(flashCall)).append("\n");
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
  static class Builder implements VerificationStartResponseFlashCall.Builder {
    OptionalValue<String> id = OptionalValue.empty();
    OptionalValue<VerificationMethod> method = OptionalValue.of(VerificationMethod.FLASH_CALL);
    OptionalValue<List<Link>> links = OptionalValue.empty();
    OptionalValue<VerificationStartResponseFlashCallContent> flashCall = OptionalValue.empty();

    VerificationStartResponseFlashCallContent.Builder _delegatedBuilder = null;

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

    @JsonProperty(JSON_PROPERTY_FLASH_CALL)
    public Builder setFlashCall(VerificationStartResponseFlashCallContent flashCall) {
      this.flashCall = OptionalValue.of(flashCall);
      return this;
    }

    @JsonIgnore
    public Builder setCliFilter(String cliFilter) {
      getDelegatedBuilder().setCliFilter(cliFilter);
      return this;
    }

    @JsonIgnore
    public Builder setInterceptionTimeout(Integer interceptionTimeout) {
      getDelegatedBuilder().setInterceptionTimeout(interceptionTimeout);
      return this;
    }

    @JsonIgnore
    public Builder setReportTimeout(Integer reportTimeout) {
      getDelegatedBuilder().setReportTimeout(reportTimeout);
      return this;
    }

    @JsonIgnore
    public Builder setDenyCallAfter(Integer denyCallAfter) {
      getDelegatedBuilder().setDenyCallAfter(denyCallAfter);
      return this;
    }

    private VerificationStartResponseFlashCallContent.Builder getDelegatedBuilder() {
      if (null == _delegatedBuilder) {
        this._delegatedBuilder = VerificationStartResponseFlashCallContent.builder();
      }
      return this._delegatedBuilder;
    }

    public VerificationStartResponseFlashCall build() {
      // delegated builder was used: filling the related source of delegation field
      if (null != this._delegatedBuilder) {
        this.flashCall = OptionalValue.of(this._delegatedBuilder.build());
      }
      return new VerificationStartResponseFlashCallImpl(id, method, links, flashCall);
    }
  }
}
