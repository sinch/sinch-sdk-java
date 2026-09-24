package com.sinch.sdk.domains.voice.models.v2.destination;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;

/** Routes the call to a phone number on the Public Switched Telephone Network (PSTN). */
@JsonDeserialize(builder = PhoneImpl.Builder.class)
public interface Phone extends CallOrigin, CallDestination {

  /** The type property. Must have the value <code>PHONE</code>. */
  public class TypeEnum extends EnumDynamic<String, TypeEnum> {
    /** The <code>PHONE</code> type. */
    public static final TypeEnum PHONE = new TypeEnum("PHONE");

    private static final EnumSupportDynamic<String, TypeEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(TypeEnum.class, TypeEnum::new, Arrays.asList(PHONE));

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
   * Get phone
   *
   * <p>Field is required
   *
   * @return phone
   */
  PhoneDetails getPhone();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new PhoneImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param phone see getter
     * @return Current builder
     * @see #getPhone
     */
    Builder setPhone(PhoneDetails phone);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    Phone build();
  }
}
