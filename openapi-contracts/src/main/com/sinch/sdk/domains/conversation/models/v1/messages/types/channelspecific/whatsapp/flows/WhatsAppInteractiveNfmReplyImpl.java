package com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.flows;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  WhatsAppInteractiveNfmReplyImpl.JSON_PROPERTY_NAME,
  WhatsAppInteractiveNfmReplyImpl.JSON_PROPERTY_RESPONSE_JSON,
  WhatsAppInteractiveNfmReplyImpl.JSON_PROPERTY_BODY
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class WhatsAppInteractiveNfmReplyImpl implements WhatsAppInteractiveNfmReply {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_NAME = "name";

  private OptionalValue<NameEnum> name;

  public static final String JSON_PROPERTY_RESPONSE_JSON = "response_json";

  private OptionalValue<String> responseJson;

  public static final String JSON_PROPERTY_BODY = "body";

  private OptionalValue<String> body;

  public WhatsAppInteractiveNfmReplyImpl() {}

  protected WhatsAppInteractiveNfmReplyImpl(
      OptionalValue<NameEnum> name,
      OptionalValue<String> responseJson,
      OptionalValue<String> body) {
    this.name = name;
    this.responseJson = responseJson;
    this.body = body;
  }

  @JsonIgnore
  public NameEnum getName() {
    return name.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<NameEnum> name() {
    return name;
  }

  @JsonIgnore
  public String getResponseJson() {
    return responseJson.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_RESPONSE_JSON)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> responseJson() {
    return responseJson;
  }

  @JsonIgnore
  public String getBody() {
    return body.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_BODY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> body() {
    return body;
  }

  /** Return true if this WhatsAppInteractiveNfmReply object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WhatsAppInteractiveNfmReplyImpl whatsAppInteractiveNfmReply =
        (WhatsAppInteractiveNfmReplyImpl) o;
    return Objects.equals(this.name, whatsAppInteractiveNfmReply.name)
        && Objects.equals(this.responseJson, whatsAppInteractiveNfmReply.responseJson)
        && Objects.equals(this.body, whatsAppInteractiveNfmReply.body);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, responseJson, body);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WhatsAppInteractiveNfmReplyImpl {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    responseJson: ").append(toIndentedString(responseJson)).append("\n");
    sb.append("    body: ").append(toIndentedString(body)).append("\n");
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
  static class Builder implements WhatsAppInteractiveNfmReply.Builder {
    OptionalValue<NameEnum> name = OptionalValue.empty();
    OptionalValue<String> responseJson = OptionalValue.empty();
    OptionalValue<String> body = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_NAME)
    public Builder setName(NameEnum name) {
      this.name = OptionalValue.of(name);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_RESPONSE_JSON)
    public Builder setResponseJson(String responseJson) {
      this.responseJson = OptionalValue.of(responseJson);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_BODY)
    public Builder setBody(String body) {
      this.body = OptionalValue.of(body);
      return this;
    }

    public WhatsAppInteractiveNfmReply build() {
      return new WhatsAppInteractiveNfmReplyImpl(name, responseJson, body);
    }
  }
}
