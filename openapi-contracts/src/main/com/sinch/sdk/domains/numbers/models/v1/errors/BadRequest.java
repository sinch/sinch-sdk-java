/*
 * Numbers | Sinch
 * An API service for getting, listing and managing Sinch virtual numbers.
 *
 * The version of the OpenAPI document: 1.0.2
 * Contact: Support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.numbers.models.v1.errors;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/** BadRequest */
@JsonDeserialize(builder = BadRequestImpl.Builder.class)
public interface BadRequest {

  /** Gets or Sets type */
  public class TypeEnum extends EnumDynamic<String, TypeEnum> {
    public static final TypeEnum BADREQUEST = new TypeEnum("BadRequest");

    private static final EnumSupportDynamic<String, TypeEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(TypeEnum.class, TypeEnum::new, Arrays.asList(BADREQUEST));

    private TypeEnum(String value) {
      super(value);
    }

    public static Stream<TypeEnum> values() {
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
   * Get fieldViolations
   *
   * @return fieldViolations
   */
  List<FieldViolation> getFieldViolations();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new BadRequestImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param fieldViolations see getter
     * @return Current builder
     * @see #getFieldViolations
     */
    Builder setFieldViolations(List<FieldViolation> fieldViolations);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    BadRequest build();
  }
}
