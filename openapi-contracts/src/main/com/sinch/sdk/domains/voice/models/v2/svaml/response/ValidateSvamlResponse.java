package com.sinch.sdk.domains.voice.models.v2.svaml.response;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.List;

/**
 * Result of a SVAML validation request.
 *
 * <p>The HTTP <code>200</code> status indicates the validation was successfully performed — not
 * that the payload is valid. Inspect <code>isValid</code> to determine the outcome.
 */
@JsonDeserialize(builder = ValidateSvamlResponseImpl.Builder.class)
public interface ValidateSvamlResponse {

  /**
   * <code>true</code> if the submitted SVAML payload passed validation; <code>false</code> if one
   * or more errors were found.
   *
   * <p>Field is required
   *
   * @return isValid
   */
  Boolean getIsValid();

  /**
   * Validation error messages describing why the SVAML payload is invalid.
   *
   * <p>Present only when <code>isValid</code> is <code>false</code>. Each entry identifies a
   * specific problem, including the affected field or command where applicable.
   *
   * @return errors
   */
  List<String> getErrors();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new ValidateSvamlResponseImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param isValid see getter
     * @return Current builder
     * @see #getIsValid
     */
    Builder setIsValid(Boolean isValid);

    /**
     * see getter
     *
     * @param errors see getter
     * @return Current builder
     * @see #getErrors
     */
    Builder setErrors(List<String> errors);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    ValidateSvamlResponse build();
  }
}
