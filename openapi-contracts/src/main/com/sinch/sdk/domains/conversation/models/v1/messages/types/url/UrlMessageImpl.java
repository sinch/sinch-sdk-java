package com.sinch.sdk.domains.conversation.models.v1.messages.types.url;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.internal.UrlMessageInternal;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.internal.UrlMessageInternalImpl;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

@JsonPropertyOrder({UrlMessageImpl.JSON_PROPERTY_URL_MESSAGE})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class UrlMessageImpl
    implements UrlMessage,
        com.sinch.sdk.domains.conversation.models.v1.messages.types.choice.ChoiceMessageType {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_URL_MESSAGE = "url_message";

  private OptionalValue<UrlMessageInternal> urlMessage;

  public UrlMessageImpl() {}

  protected UrlMessageImpl(OptionalValue<UrlMessageInternal> urlMessage) {
    this.urlMessage = urlMessage;
  }

  @JsonIgnore
  public UrlMessageInternal getUrlMessage() {
    return urlMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_URL_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<UrlMessageInternal> urlMessage() {
    return urlMessage;
  }

  @JsonIgnore
  public String getTitle() {
    if (null == urlMessage || !urlMessage.isPresent() || null == urlMessage.get().getTitle()) {
      return null;
    }
    return urlMessage.get().getTitle();
  }

  public OptionalValue<String> title() {
    return null != urlMessage && urlMessage.isPresent()
        ? urlMessage.map(f -> ((UrlMessageInternalImpl) f).title()).orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public String getUrl() {
    if (null == urlMessage || !urlMessage.isPresent() || null == urlMessage.get().getUrl()) {
      return null;
    }
    return urlMessage.get().getUrl();
  }

  public OptionalValue<String> url() {
    return null != urlMessage && urlMessage.isPresent()
        ? urlMessage.map(f -> ((UrlMessageInternalImpl) f).url()).orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  /** Return true if this UrlMessageField object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UrlMessageImpl urlMessageField = (UrlMessageImpl) o;
    return Objects.equals(this.urlMessage, urlMessageField.urlMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(urlMessage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UrlMessageImpl {\n");
    sb.append("    urlMessage: ").append(toIndentedString(urlMessage)).append("\n");
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
  static class Builder implements UrlMessage.Builder {
    OptionalValue<UrlMessageInternal> urlMessage = OptionalValue.empty();

    UrlMessageInternal.Builder _delegatedBuilder = null;

    @JsonProperty(value = JSON_PROPERTY_URL_MESSAGE, required = true)
    public Builder setUrlMessage(UrlMessageInternal urlMessage) {
      this.urlMessage = OptionalValue.of(urlMessage);
      return this;
    }

    @JsonIgnore
    public Builder setTitle(String title) {
      getDelegatedBuilder().setTitle(title);
      return this;
    }

    @JsonIgnore
    public Builder setUrl(String url) {
      getDelegatedBuilder().setUrl(url);
      return this;
    }

    private UrlMessageInternal.Builder getDelegatedBuilder() {
      if (null == _delegatedBuilder) {
        this._delegatedBuilder = UrlMessageInternal.builder();
      }
      return this._delegatedBuilder;
    }

    public UrlMessage build() {
      // delegated builder was used: filling the related source of delegation field
      if (null != this._delegatedBuilder) {
        this.urlMessage = OptionalValue.of(this._delegatedBuilder.build());
      }
      return new UrlMessageImpl(urlMessage);
    }
  }

  public static class DelegatedSerializer extends JsonSerializer<OptionalValue<UrlMessage>> {
    @Override
    public void serialize(
        OptionalValue<UrlMessage> value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException {

      if (!value.isPresent()) {
        return;
      }
      UrlMessageImpl impl = (UrlMessageImpl) value.get();
      jgen.writeObject(null != impl ? impl.getUrlMessage() : null);
    }
  }

  public static class DelegatedDeSerializer extends JsonDeserializer<UrlMessage> {
    @Override
    public UrlMessage deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {

      UrlMessageImpl.Builder builder = new UrlMessageImpl.Builder();
      UrlMessageInternalImpl deserialized = jp.readValueAs(UrlMessageInternalImpl.class);
      builder.setUrlMessage(deserialized);
      return builder.build();
    }
  }

  public static Optional<UrlMessage> delegatedConverter(UrlMessageInternal internal) {
    if (null == internal) {
      return Optional.empty();
    }
    return Optional.of(new Builder().setUrlMessage(internal).build());
  }
}
