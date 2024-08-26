/*
 * Verification | Sinch
 *
 * OpenAPI document version: 2.0.1
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.verification.models.v1.start.response;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** Available methods and actions which can be done after a successful Verification */
@JsonDeserialize(builder = LinkImpl.Builder.class)
public interface Link {

  /** The related action that can be performed on the initiated Verification. */
  public class RelEnum extends EnumDynamic<String, RelEnum> {
    public static final RelEnum STATUS = new RelEnum("status");
    public static final RelEnum REPORT = new RelEnum("report");

    private static final EnumSupportDynamic<String, RelEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(RelEnum.class, RelEnum::new, Arrays.asList(STATUS, REPORT));

    private RelEnum(String value) {
      super(value);
    }

    public static Stream<RelEnum> values() {
      return ENUM_SUPPORT.values();
    }

    public static RelEnum from(String value) {
      return ENUM_SUPPORT.from(value);
    }

    public static String valueOf(RelEnum e) {
      return ENUM_SUPPORT.valueOf(e);
    }
  }

  /**
   * The related action that can be performed on the initiated Verification.
   *
   * @return rel
   */
  RelEnum getRel();

  /**
   * The complete URL to perform the specified action, localized to the DataCenter which handled the
   * original Verification request.
   *
   * @return href
   */
  String getHref();

  /**
   * The HTTP method to use when performing the action using the linked localized URL.
   *
   * @return method
   */
  String getMethod();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new LinkImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param rel see getter
     * @return Current builder
     * @see #getRel
     */
    Builder setRel(RelEnum rel);

    /**
     * see getter
     *
     * @param href see getter
     * @return Current builder
     * @see #getHref
     */
    Builder setHref(String href);

    /**
     * see getter
     *
     * @param method see getter
     * @return Current builder
     * @see #getMethod
     */
    Builder setMethod(String method);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    Link build();
  }
}
