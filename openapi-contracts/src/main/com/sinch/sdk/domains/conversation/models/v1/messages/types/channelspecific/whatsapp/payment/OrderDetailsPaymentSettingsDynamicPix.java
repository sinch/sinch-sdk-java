/*
 * Conversation API | Sinch
 *
 * OpenAPI document version: 1.0
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.payment;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** The dynamic Pix payment settings. */
@JsonDeserialize(builder = OrderDetailsPaymentSettingsDynamicPixImpl.Builder.class)
public interface OrderDetailsPaymentSettingsDynamicPix {

  /**
   * The dynamic Pix code to be used by the buyer to pay.
   *
   * @return code
   */
  String getCode();

  /**
   * Account holder name.
   *
   * @return merchantName
   */
  String getMerchantName();

  /**
   * Pix key.
   *
   * @return key
   */
  String getKey();

  /** Pix key type. */
  public class KeyTypeEnum extends EnumDynamic<String, KeyTypeEnum> {
    public static final KeyTypeEnum CPF = new KeyTypeEnum("CPF");
    public static final KeyTypeEnum CNPJ = new KeyTypeEnum("CNPJ");
    public static final KeyTypeEnum EMAIL = new KeyTypeEnum("EMAIL");
    public static final KeyTypeEnum PHONE = new KeyTypeEnum("PHONE");
    public static final KeyTypeEnum EVP = new KeyTypeEnum("EVP");

    private static final EnumSupportDynamic<String, KeyTypeEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(
            KeyTypeEnum.class, KeyTypeEnum::new, Arrays.asList(CPF, CNPJ, EMAIL, PHONE, EVP));

    private KeyTypeEnum(String value) {
      super(value);
    }

    public static Stream<KeyTypeEnum> values() {
      return ENUM_SUPPORT.values();
    }

    public static KeyTypeEnum from(String value) {
      return ENUM_SUPPORT.from(value);
    }

    public static String valueOf(KeyTypeEnum e) {
      return ENUM_SUPPORT.valueOf(e);
    }
  }

  /**
   * Pix key type.
   *
   * @return keyType
   */
  KeyTypeEnum getKeyType();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new OrderDetailsPaymentSettingsDynamicPixImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param code see getter
     * @return Current builder
     * @see #getCode
     */
    Builder setCode(String code);

    /**
     * see getter
     *
     * @param merchantName see getter
     * @return Current builder
     * @see #getMerchantName
     */
    Builder setMerchantName(String merchantName);

    /**
     * see getter
     *
     * @param key see getter
     * @return Current builder
     * @see #getKey
     */
    Builder setKey(String key);

    /**
     * see getter
     *
     * @param keyType see getter
     * @return Current builder
     * @see #getKeyType
     */
    Builder setKeyType(KeyTypeEnum keyType);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    OrderDetailsPaymentSettingsDynamicPix build();
  }
}
