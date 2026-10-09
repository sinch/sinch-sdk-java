package com.sinch.sdk.domains.voice.models.v2.svaml.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import com.sinch.sdk.domains.voice.models.v2.svaml.SvamlInput;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Request payload for validating a SVAML document before using it in a call.
 *
 * <p>Use <code>validationType</code> to control how strictly the payload is checked.
 */
@JsonDeserialize(builder = ValidateSvamlRequestImpl.Builder.class)
public interface ValidateSvamlRequest {

  /** Controls how strictly the SVAML payload is validated. */
  public class ValidationTypeEnum extends EnumDynamic<String, ValidationTypeEnum> {
    public static final ValidationTypeEnum NORMAL = new ValidationTypeEnum("NORMAL");

    public static final ValidationTypeEnum STRICT = new ValidationTypeEnum("STRICT");

    private static final EnumSupportDynamic<String, ValidationTypeEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(
            ValidationTypeEnum.class, ValidationTypeEnum::new, Arrays.asList(NORMAL, STRICT));

    private ValidationTypeEnum(String value) {
      super(value);
    }

    public static Stream<ValidationTypeEnum> values() {
      return ENUM_SUPPORT.values();
    }

    public static ValidationTypeEnum from(String value) {
      return ENUM_SUPPORT.from(value);
    }

    public static String valueOf(ValidationTypeEnum e) {
      return ENUM_SUPPORT.valueOf(e);
    }
  }

  /**
   * The SVAML payload to validate.
   *
   * <p>Field is required
   *
   * @return svaml
   */
  SvamlInput getSvaml();

  /**
   * Controls how strictly the SVAML payload is validated.
   *
   * <p><code>NORMAL</code>: applies the same validation rules used when initiating a call. Unknown
   * or extra properties are ignored.
   *
   * <p><code>STRICT</code>: applies stricter validation rules. Returns errors for any properties
   * that are not recognised or not expected in the given context.
   *
   * <p>If omitted, the server applies <code>NORMAL</code>.
   *
   * @return validationType
   */
  ValidationTypeEnum getValidationType();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new ValidateSvamlRequestImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param svaml see getter
     * @return Current builder
     * @see #getSvaml
     */
    Builder setSvaml(SvamlInput svaml);

    /**
     * see getter
     *
     * @param validationType see getter
     * @return Current builder
     * @see #getValidationType
     */
    Builder setValidationType(ValidationTypeEnum validationType);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    ValidateSvamlRequest build();
  }
}
