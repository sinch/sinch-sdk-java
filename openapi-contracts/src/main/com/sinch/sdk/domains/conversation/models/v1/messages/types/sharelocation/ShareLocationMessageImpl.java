package com.sinch.sdk.domains.conversation.models.v1.messages.types.sharelocation;

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
import com.sinch.sdk.domains.conversation.models.v1.messages.types.internal.ShareLocationMessageInternal;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.internal.ShareLocationMessageInternalImpl;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

@JsonPropertyOrder({ShareLocationMessageImpl.JSON_PROPERTY_SHARE_LOCATION_MESSAGE})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ShareLocationMessageImpl
    implements ShareLocationMessage,
        com.sinch.sdk.domains.conversation.models.v1.messages.types.choice.ChoiceMessageType {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_SHARE_LOCATION_MESSAGE = "share_location_message";

  private OptionalValue<ShareLocationMessageInternal> shareLocationMessage;

  public ShareLocationMessageImpl() {}

  protected ShareLocationMessageImpl(
      OptionalValue<ShareLocationMessageInternal> shareLocationMessage) {
    this.shareLocationMessage = shareLocationMessage;
  }

  @JsonIgnore
  public ShareLocationMessageInternal getShareLocationMessage() {
    return shareLocationMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SHARE_LOCATION_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ShareLocationMessageInternal> shareLocationMessage() {
    return shareLocationMessage;
  }

  @JsonIgnore
  public String getTitle() {
    if (null == shareLocationMessage
        || !shareLocationMessage.isPresent()
        || null == shareLocationMessage.get().getTitle()) {
      return null;
    }
    return shareLocationMessage.get().getTitle();
  }

  public OptionalValue<String> title() {
    return null != shareLocationMessage && shareLocationMessage.isPresent()
        ? shareLocationMessage
            .map(f -> ((ShareLocationMessageInternalImpl) f).title())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public String getFallbackUrl() {
    if (null == shareLocationMessage
        || !shareLocationMessage.isPresent()
        || null == shareLocationMessage.get().getFallbackUrl()) {
      return null;
    }
    return shareLocationMessage.get().getFallbackUrl();
  }

  public OptionalValue<String> fallbackUrl() {
    return null != shareLocationMessage && shareLocationMessage.isPresent()
        ? shareLocationMessage
            .map(f -> ((ShareLocationMessageInternalImpl) f).fallbackUrl())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  /** Return true if this ShareLocationMessageField object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ShareLocationMessageImpl shareLocationMessageField = (ShareLocationMessageImpl) o;
    return Objects.equals(
        this.shareLocationMessage, shareLocationMessageField.shareLocationMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(shareLocationMessage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ShareLocationMessageImpl {\n");
    sb.append("    shareLocationMessage: ")
        .append(toIndentedString(shareLocationMessage))
        .append("\n");
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
  static class Builder implements ShareLocationMessage.Builder {
    OptionalValue<ShareLocationMessageInternal> shareLocationMessage = OptionalValue.empty();

    ShareLocationMessageInternal.Builder _delegatedBuilder = null;

    @JsonProperty(value = JSON_PROPERTY_SHARE_LOCATION_MESSAGE, required = true)
    public Builder setShareLocationMessage(ShareLocationMessageInternal shareLocationMessage) {
      this.shareLocationMessage = OptionalValue.of(shareLocationMessage);
      return this;
    }

    @JsonIgnore
    public Builder setTitle(String title) {
      getDelegatedBuilder().setTitle(title);
      return this;
    }

    @JsonIgnore
    public Builder setFallbackUrl(String fallbackUrl) {
      getDelegatedBuilder().setFallbackUrl(fallbackUrl);
      return this;
    }

    private ShareLocationMessageInternal.Builder getDelegatedBuilder() {
      if (null == _delegatedBuilder) {
        this._delegatedBuilder = ShareLocationMessageInternal.builder();
      }
      return this._delegatedBuilder;
    }

    public ShareLocationMessage build() {
      // delegated builder was used: filling the related source of delegation field
      if (null != this._delegatedBuilder) {
        this.shareLocationMessage = OptionalValue.of(this._delegatedBuilder.build());
      }
      return new ShareLocationMessageImpl(shareLocationMessage);
    }
  }

  public static class DelegatedSerializer
      extends JsonSerializer<OptionalValue<ShareLocationMessage>> {
    @Override
    public void serialize(
        OptionalValue<ShareLocationMessage> value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException {

      if (!value.isPresent()) {
        return;
      }
      ShareLocationMessageImpl impl = (ShareLocationMessageImpl) value.get();
      jgen.writeObject(null != impl ? impl.getShareLocationMessage() : null);
    }
  }

  public static class DelegatedDeSerializer extends JsonDeserializer<ShareLocationMessage> {
    @Override
    public ShareLocationMessage deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException {

      ShareLocationMessageImpl.Builder builder = new ShareLocationMessageImpl.Builder();
      ShareLocationMessageInternalImpl deserialized =
          jp.readValueAs(ShareLocationMessageInternalImpl.class);
      builder.setShareLocationMessage(deserialized);
      return builder.build();
    }
  }

  public static Optional<ShareLocationMessage> delegatedConverter(
      ShareLocationMessageInternal internal) {
    if (null == internal) {
      return Optional.empty();
    }
    return Optional.of(new Builder().setShareLocationMessage(internal).build());
  }
}
