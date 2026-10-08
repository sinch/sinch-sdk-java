package com.sinch.sdk.domains.voice.api.v2;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.voice.models.v2.services.request.CreateServiceRequest;
import com.sinch.sdk.domains.voice.models.v2.services.response.ServiceResponse;

/** Services Service */
public interface ServicesService {

  /**
   * Create a new voice service
   *
   * <p>Creates a new voice service in the specified project.
   *
   * @param createServiceRequest The service to create (required)
   * @return ServiceResponse
   * @throws ApiException if fails to make API call
   * @since 2.3
   */
  ServiceResponse create(CreateServiceRequest createServiceRequest) throws ApiException;
}
