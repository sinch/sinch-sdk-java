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

/** InternalError */
@JsonDeserialize(builder = InternalErrorImpl.Builder.class)
public interface InternalError {

  /** Gets or Sets code */
  public class CodeEnum extends EnumDynamic<Integer, CodeEnum> {
    public static final CodeEnum NUMBER_500 = new CodeEnum(500);

    private static final EnumSupportDynamic<Integer, CodeEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(CodeEnum.class, CodeEnum::new, Arrays.asList(NUMBER_500));

    private CodeEnum(Integer value) {
      super(value);
    }

    public static Stream<CodeEnum> values() {
      return ENUM_SUPPORT.values();
    }

    public static CodeEnum from(Integer value) {
      return ENUM_SUPPORT.from(value);
    }

    public static Integer valueOf(CodeEnum e) {
      return ENUM_SUPPORT.valueOf(e);
    }
  }

  /**
   * Get code
   *
   * @return code
   */
  CodeEnum getCode();

  /**
   * Get message
   *
   * @return message
   */
  String getMessage();

  /** Gets or Sets status */
  public class StatusEnum extends EnumDynamic<String, StatusEnum> {
    public static final StatusEnum INTERNAL = new StatusEnum("INTERNAL");
    public static final StatusEnum UNKNOWN = new StatusEnum("UNKNOWN");

    private static final EnumSupportDynamic<String, StatusEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(
            StatusEnum.class, StatusEnum::new, Arrays.asList(INTERNAL, UNKNOWN));

    private StatusEnum(String value) {
      super(value);
    }

    public static Stream<StatusEnum> values() {
      return ENUM_SUPPORT.values();
    }

    public static StatusEnum from(String value) {
      return ENUM_SUPPORT.from(value);
    }

    public static String valueOf(StatusEnum e) {
      return ENUM_SUPPORT.valueOf(e);
    }
  }

  /**
   * Get status
   *
   * @return status
   */
  StatusEnum getStatus();

  /**
   * Get details
   *
   * @return details
   */
  List<Object> getDetails();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new InternalErrorImpl.Builder();
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
    Builder setCode(CodeEnum code);

    /**
     * see getter
     *
     * @param message see getter
     * @return Current builder
     * @see #getMessage
     */
    Builder setMessage(String message);

    /**
     * see getter
     *
     * @param status see getter
     * @return Current builder
     * @see #getStatus
     */
    Builder setStatus(StatusEnum status);

    /**
     * see getter
     *
     * @param details see getter
     * @return Current builder
     * @see #getDetails
     */
    Builder setDetails(List<Object> details);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    InternalError build();
  }
}
