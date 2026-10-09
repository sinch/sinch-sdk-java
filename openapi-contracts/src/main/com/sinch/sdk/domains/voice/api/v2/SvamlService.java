package com.sinch.sdk.domains.voice.api.v2;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.voice.models.v2.svaml.request.DescribeSvamlRequest;
import com.sinch.sdk.domains.voice.models.v2.svaml.request.ValidateSvamlRequest;
import com.sinch.sdk.domains.voice.models.v2.svaml.response.SvamlDescriptionResponse;
import com.sinch.sdk.domains.voice.models.v2.svaml.response.ValidateSvamlResponse;

/** Svaml Service */
public interface SvamlService {

  /**
   * Describe the call flow from the SVAML payload
   *
   * <p>This endpoint is useful for understanding the structure and flow of a SVAML payload without
   * executing it. It provides a detailed description of the commands, events, and messages defined
   * in the SVAML.
   *
   * @param describeSvamlRequest The SVAML payload to describe (required)
   * @return SvamlDescriptionResponse
   * @throws ApiException if fails to make API call
   * @since 2.3
   */
  SvamlDescriptionResponse describe(DescribeSvamlRequest describeSvamlRequest) throws ApiException;

  /**
   * Validate a SVAML payload
   *
   * <p>This endpoint checks the structure and content of the SVAML commands to ensure they conform
   * to the expected schema and rules. Use <code>validationType</code> to choose <code>NORMAL</code>
   * (same rules as initiating a call) or <code>STRICT</code> (errors for unrecognised properties).
   *
   * @param validateSvamlRequest The SVAML payload to validate (required)
   * @return ValidateSvamlResponse
   * @throws ApiException if fails to make API call
   * @since 2.3
   */
  ValidateSvamlResponse validate(ValidateSvamlRequest validateSvamlRequest) throws ApiException;
}
