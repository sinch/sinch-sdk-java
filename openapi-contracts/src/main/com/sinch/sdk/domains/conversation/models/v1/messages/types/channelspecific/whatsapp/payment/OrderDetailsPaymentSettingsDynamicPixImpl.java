package com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.payment;

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
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.payment.internal.WhatsAppPaymentSettingsPixDynamicPix;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.payment.internal.WhatsAppPaymentSettingsPixDynamicPixImpl;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

@JsonPropertyOrder({OrderDetailsPaymentSettingsDynamicPixImpl.JSON_PROPERTY_DYNAMIC_PIX})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class OrderDetailsPaymentSettingsDynamicPixImpl
    implements OrderDetailsPaymentSettingsDynamicPix,
        com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.payment
            .OrderDetailsSettings {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_DYNAMIC_PIX = "dynamic_pix";

  private OptionalValue<WhatsAppPaymentSettingsPixDynamicPix> dynamicPix;

  public OrderDetailsPaymentSettingsDynamicPixImpl() {}

  protected OrderDetailsPaymentSettingsDynamicPixImpl(
      OptionalValue<WhatsAppPaymentSettingsPixDynamicPix> dynamicPix) {
    this.dynamicPix = dynamicPix;
  }

  @JsonIgnore
  public WhatsAppPaymentSettingsPixDynamicPix getDynamicPix() {
    return dynamicPix.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DYNAMIC_PIX)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<WhatsAppPaymentSettingsPixDynamicPix> dynamicPix() {
    return dynamicPix;
  }

  @JsonIgnore
  public String getCode() {
    if (null == dynamicPix || !dynamicPix.isPresent() || null == dynamicPix.get().getCode()) {
      return null;
    }
    return dynamicPix.get().getCode();
  }

  public OptionalValue<String> code() {
    return null != dynamicPix && dynamicPix.isPresent()
        ? dynamicPix
            .map(f -> ((WhatsAppPaymentSettingsPixDynamicPixImpl) f).code())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public String getMerchantName() {
    if (null == dynamicPix
        || !dynamicPix.isPresent()
        || null == dynamicPix.get().getMerchantName()) {
      return null;
    }
    return dynamicPix.get().getMerchantName();
  }

  public OptionalValue<String> merchantName() {
    return null != dynamicPix && dynamicPix.isPresent()
        ? dynamicPix
            .map(f -> ((WhatsAppPaymentSettingsPixDynamicPixImpl) f).merchantName())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public String getKey() {
    if (null == dynamicPix || !dynamicPix.isPresent() || null == dynamicPix.get().getKey()) {
      return null;
    }
    return dynamicPix.get().getKey();
  }

  public OptionalValue<String> key() {
    return null != dynamicPix && dynamicPix.isPresent()
        ? dynamicPix
            .map(f -> ((WhatsAppPaymentSettingsPixDynamicPixImpl) f).key())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public KeyTypeEnum getKeyType() {
    if (null == dynamicPix || !dynamicPix.isPresent() || null == dynamicPix.get().getKeyType()) {
      return null;
    }
    return KeyTypeEnum.from(dynamicPix.get().getKeyType().value());
  }

  public OptionalValue<KeyTypeEnum> keyType() {
    return null != dynamicPix && dynamicPix.isPresent()
        ? dynamicPix.map(f -> KeyTypeEnum.from(dynamicPix.get().getKeyType().value()))
        : OptionalValue.empty();
  }

  /** Return true if this WhatsAppPaymentSettingsPix object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderDetailsPaymentSettingsDynamicPixImpl whatsAppPaymentSettingsPix =
        (OrderDetailsPaymentSettingsDynamicPixImpl) o;
    return Objects.equals(this.dynamicPix, whatsAppPaymentSettingsPix.dynamicPix);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dynamicPix);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderDetailsPaymentSettingsDynamicPixImpl {\n");
    sb.append("    dynamicPix: ").append(toIndentedString(dynamicPix)).append("\n");
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
  static class Builder implements OrderDetailsPaymentSettingsDynamicPix.Builder {
    OptionalValue<WhatsAppPaymentSettingsPixDynamicPix> dynamicPix = OptionalValue.empty();

    WhatsAppPaymentSettingsPixDynamicPix.Builder _delegatedBuilder = null;

    @JsonProperty(value = JSON_PROPERTY_DYNAMIC_PIX, required = true)
    public Builder setDynamicPix(WhatsAppPaymentSettingsPixDynamicPix dynamicPix) {
      this.dynamicPix = OptionalValue.of(dynamicPix);
      return this;
    }

    @JsonIgnore
    public Builder setCode(String code) {
      getDelegatedBuilder().setCode(code);
      return this;
    }

    @JsonIgnore
    public Builder setMerchantName(String merchantName) {
      getDelegatedBuilder().setMerchantName(merchantName);
      return this;
    }

    @JsonIgnore
    public Builder setKey(String key) {
      getDelegatedBuilder().setKey(key);
      return this;
    }

    @JsonIgnore
    public Builder setKeyType(KeyTypeEnum keyType) {
      getDelegatedBuilder()
          .setKeyType(
              null != keyType
                  ? WhatsAppPaymentSettingsPixDynamicPixImpl.KeyTypeEnum.from(keyType.value())
                  : null);
      return this;
    }

    private WhatsAppPaymentSettingsPixDynamicPix.Builder getDelegatedBuilder() {
      if (null == _delegatedBuilder) {
        this._delegatedBuilder = WhatsAppPaymentSettingsPixDynamicPix.builder();
      }
      return this._delegatedBuilder;
    }

    public OrderDetailsPaymentSettingsDynamicPix build() {
      // delegated builder was used: filling the related source of delegation field
      if (null != this._delegatedBuilder) {
        this.dynamicPix = OptionalValue.of(this._delegatedBuilder.build());
      }
      return new OrderDetailsPaymentSettingsDynamicPixImpl(dynamicPix);
    }
  }

  public static class DelegatedSerializer
      extends JsonSerializer<OptionalValue<OrderDetailsPaymentSettingsDynamicPix>> {
    @Override
    public void serialize(
        OptionalValue<OrderDetailsPaymentSettingsDynamicPix> value,
        JsonGenerator jgen,
        SerializerProvider provider)
        throws IOException {

      if (!value.isPresent()) {
        return;
      }
      OrderDetailsPaymentSettingsDynamicPixImpl impl =
          (OrderDetailsPaymentSettingsDynamicPixImpl) value.get();
      jgen.writeObject(null != impl ? impl.getDynamicPix() : null);
    }
  }

  public static class DelegatedDeSerializer
      extends JsonDeserializer<OrderDetailsPaymentSettingsDynamicPix> {
    @Override
    public OrderDetailsPaymentSettingsDynamicPix deserialize(
        JsonParser jp, DeserializationContext ctxt) throws IOException {

      OrderDetailsPaymentSettingsDynamicPixImpl.Builder builder =
          new OrderDetailsPaymentSettingsDynamicPixImpl.Builder();
      WhatsAppPaymentSettingsPixDynamicPixImpl deserialized =
          jp.readValueAs(WhatsAppPaymentSettingsPixDynamicPixImpl.class);
      builder.setDynamicPix(deserialized);
      return builder.build();
    }
  }

  public static Optional<OrderDetailsPaymentSettingsDynamicPix> delegatedConverter(
      WhatsAppPaymentSettingsPixDynamicPix internal) {
    if (null == internal) {
      return Optional.empty();
    }
    return Optional.of(new Builder().setDynamicPix(internal).build());
  }
}
