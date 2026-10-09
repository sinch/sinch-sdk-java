package com.sinch.sdk.domains.voice.api.v2;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.voice.models.v2.services.request.CreateServiceRequest;
import com.sinch.sdk.domains.voice.models.v2.services.request.ListServicesQueryParameters;
import com.sinch.sdk.domains.voice.models.v2.services.request.UpdateServiceRequest;
import com.sinch.sdk.domains.voice.models.v2.services.response.ServiceResponse;
import com.sinch.sdk.domains.voice.models.v2.services.response.ServicesListResponse;

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

  /**
   * Delete a voice service by ID
   *
   * <p>Deletes a service permanently.
   *
   * <p><strong>Important:</strong> The default service cannot be deleted. To delete the current
   * default service, a different service must first be designated as the default using the PATCH
   * endpoint.
   *
   * @param serviceId The ID of the service. (required)
   * @throws ApiException if fails to make API call
   * @since 2.3
   */
  void delete(String serviceId) throws ApiException;

  /**
   * Retrieve a voice service by ID
   *
   * <p>Retrieve the full details of a specific voice service by its <code>serviceId</code>.
   *
   * @param serviceId The ID of the service. (required)
   * @return ServiceResponse
   * @throws ApiException if fails to make API call
   * @since 2.3
   */
  ServiceResponse get(String serviceId) throws ApiException;

  /**
   * List all services of a project
   *
   * <p>Retrieve a list of voice services in the specified project.
   *
   * <p>Optionally:
   *
   * <ul>
   *   <li>Filter services by partial match on name or description (<code>filter</code>)
   *   <li>Return only the default service (<code>isDefault=true</code>)
   * </ul>
   *
   * @return ServicesListResponse
   * @throws ApiException if fails to make API call
   * @since 2.3
   */
  ServicesListResponse list() throws ApiException;

  /**
   * List all services of a project
   *
   * <p>Retrieve a list of voice services in the specified project.
   *
   * <p>Optionally:
   *
   * <ul>
   *   <li>Filter services by partial match on name or description (<code>filter</code>)
   *   <li>Return only the default service (<code>isDefault=true</code>)
   * </ul>
   *
   * @param queryParameter (optional)
   * @return ServicesListResponse
   * @throws ApiException if fails to make API call
   * @since 2.3
   */
  ServicesListResponse list(ListServicesQueryParameters queryParameter) throws ApiException;

  /**
   * Update a voice service
   *
   * <p>Updates an existing service resource with the provided properties. Only the fields included
   * in the request body will be modified; omitted fields remain unchanged.
   *
   * <p>To set a service as the default for the project, set <code>isDefault</code> to <code>true
   * </code>. Each project can have only one default service: setting a new default automatically
   * removes the default status from the previously designated service. <code>isDefault</code> set
   * to <code>false</code> is invalid and will not be accepted by the API.
   *
   * @param serviceId The ID of the service. (required)
   * @param updateServiceRequest The properties to update (required)
   * @return ServiceResponse
   * @throws ApiException if fails to make API call
   * @since 2.3
   */
  ServiceResponse update(String serviceId, UpdateServiceRequest updateServiceRequest)
      throws ApiException;
}
