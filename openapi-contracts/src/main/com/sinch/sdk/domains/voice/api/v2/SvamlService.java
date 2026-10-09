package com.sinch.sdk.domains.voice.api.v2;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.voice.models.v2.svaml.request.DescribeSvamlRequest;
import com.sinch.sdk.domains.voice.models.v2.svaml.response.SvamlDescriptionResponse;

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
}
