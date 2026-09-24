package com.sinch.sdk.domains.voice.models.v2.destination;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;

@JsonDeserialize(builder = SipFromImpl.Builder.class)
public interface SipFrom extends CallOrigin {

  /** The type property. Must have the value <code>SIP</code>. */
  public class TypeEnum extends EnumDynamic<String, TypeEnum> {
    /** The <code>SIP</code> type. */
    public static final TypeEnum SIP = new TypeEnum("SIP");

    private static final EnumSupportDynamic<String, TypeEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(TypeEnum.class, TypeEnum::new, Arrays.asList(SIP));

    private TypeEnum(String value) {
      super(value);
    }

    public static java.util.stream.Stream<TypeEnum> values() {
      return ENUM_SUPPORT.values();
    }

    public static TypeEnum from(String value) {
      return ENUM_SUPPORT.from(value);
    }

    public static String valueOf(TypeEnum e) {
      return ENUM_SUPPORT.valueOf(e);
    }
  }

  /**
   * Get sip
   *
   * <p>Field is required
   *
   * @return sip
   */
  SipFromDetails getSip();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new SipFromImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param sip see getter
     * @return Current builder
     * @see #getSip
     */
    Builder setSip(SipFromDetails sip);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    SipFrom build();
  }
}
