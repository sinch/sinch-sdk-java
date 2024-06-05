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
  StartVerificationResponseFlashCallImpl.JSON_PROPERTY_ID,
  StartVerificationResponseFlashCallImpl.JSON_PROPERTY_METHOD,
  StartVerificationResponseFlashCallImpl.JSON_PROPERTY_FLASH_CALL,
  StartVerificationResponseFlashCallImpl.JSON_PROPERTY_LINKS
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class StartVerificationResponseFlashCallImpl
    implements StartVerificationResponseFlashCall,
        com.sinch.sdk.domains.verification.models.v1.response.StartVerificationResponse {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_ID = "id";

  private OptionalValue<String> id;

  public static final String JSON_PROPERTY_METHOD = "method";

  private OptionalValue<String> method;

  public static final String JSON_PROPERTY_FLASH_CALL = "flashCall";

  private OptionalValue<StartVerificationResponseFlashCallContent> flashCall;

  public static final String JSON_PROPERTY_LINKS = "_links";

  private OptionalValue<List<Link>> links;

  public StartVerificationResponseFlashCallImpl() {}

  protected StartVerificationResponseFlashCallImpl(
      OptionalValue<String> id,
      OptionalValue<String> method,
      OptionalValue<StartVerificationResponseFlashCallContent> flashCall,
      OptionalValue<List<Link>> links) {
    this.id = id;
    this.method = method;
    this.flashCall = flashCall;
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
  public StartVerificationResponseFlashCallContent getFlashCall() {
    return flashCall.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_FLASH_CALL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<StartVerificationResponseFlashCallContent> flashCall() {
    return flashCall;
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

  /** Return true if this FlashCallInitiateVerificationResponse object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StartVerificationResponseFlashCallImpl flashCallInitiateVerificationResponse =
        (StartVerificationResponseFlashCallImpl) o;
    return Objects.equals(this.id, flashCallInitiateVerificationResponse.id)
        && Objects.equals(this.method, flashCallInitiateVerificationResponse.method)
        && Objects.equals(this.flashCall, flashCallInitiateVerificationResponse.flashCall)
        && Objects.equals(this.links, flashCallInitiateVerificationResponse.links);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, method, flashCall, links);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StartVerificationResponseFlashCallImpl {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    method: ").append(toIndentedString(method)).append("\n");
    sb.append("    flashCall: ").append(toIndentedString(flashCall)).append("\n");
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
  static class Builder implements StartVerificationResponseFlashCall.Builder {
    OptionalValue<String> id = OptionalValue.empty();
    OptionalValue<String> method = OptionalValue.empty();
    OptionalValue<StartVerificationResponseFlashCallContent> flashCall = OptionalValue.empty();
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

    @JsonProperty(JSON_PROPERTY_FLASH_CALL)
    public Builder setFlashCall(StartVerificationResponseFlashCallContent flashCall) {
      this.flashCall = OptionalValue.of(flashCall);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_LINKS)
    public Builder setLinks(List<Link> links) {
      this.links = OptionalValue.of(links);
      return this;
    }

    public StartVerificationResponseFlashCall build() {
      return new StartVerificationResponseFlashCallImpl(id, method, flashCall, links);
    }
  }
}
