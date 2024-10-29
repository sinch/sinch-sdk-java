package com.sinch.sdk.domains.voice.models.v1.applications;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({CallbacksImpl.JSON_PROPERTY_URL})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class CallbacksImpl implements Callbacks {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_URL = "url";

  private OptionalValue<CallbacksUrl> url;

  public CallbacksImpl() {}

  protected CallbacksImpl(OptionalValue<CallbacksUrl> url) {
    this.url = url;
  }

  @JsonIgnore
  public CallbacksUrl getUrl() {
    return url.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_URL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<CallbacksUrl> url() {
    return url;
  }

  /** Return true if this callbacks object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CallbacksImpl callbacks = (CallbacksImpl) o;
    return Objects.equals(this.url, callbacks.url);
  }

  @Override
  public int hashCode() {
    return Objects.hash(url);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CallbacksImpl {\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
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
  static class Builder implements Callbacks.Builder {
    OptionalValue<CallbacksUrl> url = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_URL)
    public Builder setUrl(CallbacksUrl url) {
      this.url = OptionalValue.of(url);
      return this;
    }

    public Callbacks build() {
      return new CallbacksImpl(url);
    }
  }
}
