/*
 * Numbers | Sinch
 *
 * OpenAPI document version: 1.0.2
 * Contact: Support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.numbers.models.v1.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/** SearchPattern */
@JsonDeserialize(builder = SearchPatternImpl.Builder.class)
public interface SearchPattern {

  /**
   * Sequence of digits to search for.
   *
   * @return pattern
   */
  String getPattern();

  /**
   * Get position
   *
   * @return position
   */
  SearchPosition getPosition();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new SearchPatternImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param pattern see getter
     * @return Current builder
     * @see #getPattern
     */
    Builder setPattern(String pattern);

    /**
     * see getter
     *
     * @param position see getter
     * @return Current builder
     * @see #getPosition
     */
    Builder setPosition(SearchPosition position);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    SearchPattern build();
  }
}
