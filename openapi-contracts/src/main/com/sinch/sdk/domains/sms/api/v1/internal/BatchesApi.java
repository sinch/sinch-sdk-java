/*
 * API Overview | Sinch
 *
 * OpenAPI document version: v1
 * Contact: Support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.sms.api.v1.internal;

import com.fasterxml.jackson.core.type.TypeReference;
import com.sinch.sdk.core.databind.query_parameter.InstantToIso8601Serializer;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.exceptions.ApiExceptionBuilder;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.core.http.HttpMethod;
import com.sinch.sdk.core.http.HttpRequest;
import com.sinch.sdk.core.http.HttpResponse;
import com.sinch.sdk.core.http.HttpStatus;
import com.sinch.sdk.core.http.URLParameter;
import com.sinch.sdk.core.http.URLParameterUtils;
import com.sinch.sdk.core.http.URLPathUtils;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.domains.sms.models.v1.batches.request.BatchRequest;
import com.sinch.sdk.domains.sms.models.v1.batches.request.DryRunQueryParameters;
import com.sinch.sdk.domains.sms.models.v1.batches.request.ListBatchesQueryParameters;
import com.sinch.sdk.domains.sms.models.v1.batches.request.SendDeliveryFeedbackRequest;
import com.sinch.sdk.domains.sms.models.v1.batches.request.UpdateBatchRequest;
import com.sinch.sdk.domains.sms.models.v1.batches.response.BatchResponse;
import com.sinch.sdk.domains.sms.models.v1.batches.response.DryRunResponse;
import com.sinch.sdk.domains.sms.models.v1.batches.response.internal.ApiBatchList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class BatchesApi {

  private static final Logger LOGGER = Logger.getLogger(BatchesApi.class.getName());
  private HttpClient httpClient;
  private ServerConfiguration serverConfiguration;
  private Map<String, AuthManager> authManagersByOasSecuritySchemes;
  private HttpMapper mapper;

  private final String servicePlanId;

  public BatchesApi(
      HttpClient httpClient,
      ServerConfiguration serverConfiguration,
      Map<String, AuthManager> authManagersByOasSecuritySchemes,
      HttpMapper mapper,
      String servicePlanId) {
    this.httpClient = httpClient;
    this.serverConfiguration = serverConfiguration;
    this.authManagersByOasSecuritySchemes = authManagersByOasSecuritySchemes;
    this.mapper = mapper;
    this.servicePlanId = servicePlanId;
  }

  /**
   * Cancel a batch message A batch can be canceled at any point. If a batch is canceled while
   * it&#39;s currently being delivered some messages currently being processed might still be
   * delivered. The delivery report will indicate which messages were canceled and which
   * weren&#39;t. Canceling a batch scheduled in the future will result in an empty delivery report
   * while canceling an already sent batch would result in no change to the completed delivery
   * report.
   *
   * @param batchId The batch ID you received from sending a message. (required)
   * @return BatchResponse
   * @throws ApiException if fails to make API call
   */
  public BatchResponse cancel(String batchId) throws ApiException {

    LOGGER.finest("[cancel]" + " " + "batchId: " + batchId);

    HttpRequest httpRequest = cancelRequestBuilder(batchId);
    HttpResponse response =
        httpClient.invokeAPI(
            this.serverConfiguration, this.authManagersByOasSecuritySchemes, httpRequest);

    if (HttpStatus.isSuccessfulStatus(response.getCode())) {
      TypeReference<BatchResponse> localVarReturnType = new TypeReference<BatchResponse>() {};
      return mapper.deserialize(response, localVarReturnType);
    }
    // fallback to default errors handling:
    // all error cases definition are not required from specs: will try some "hardcoded" content
    // parsing
    throw ApiExceptionBuilder.build(
        response.getMessage(),
        response.getCode(),
        mapper.deserialize(response, new TypeReference<HashMap<String, ?>>() {}));
  }

  private HttpRequest cancelRequestBuilder(String batchId) throws ApiException {
    // verify the required parameter 'this.servicePlanId' is set
    if (this.servicePlanId == null) {
      throw new ApiException(
          400, "Missing the required parameter 'this.servicePlanId' when calling cancel");
    }
    // verify the required parameter 'batchId' is set
    if (batchId == null) {
      throw new ApiException(400, "Missing the required parameter 'batchId' when calling cancel");
    }

    String localVarPath =
        "/xms/v1/{service_plan_id}/batches/{batch_id}"
            .replaceAll(
                "\\{" + "service_plan_id" + "\\}",
                URLPathUtils.encodePathSegment(this.servicePlanId.toString()))
            .replaceAll(
                "\\{" + "batch_id" + "\\}", URLPathUtils.encodePathSegment(batchId.toString()));

    List<URLParameter> localVarQueryParams = new ArrayList<>();

    Map<String, String> localVarHeaderParams = new HashMap<>();

    final Collection<String> localVarAccepts = Arrays.asList("application/json");

    final Collection<String> localVarContentTypes = Arrays.asList();

    final Collection<String> localVarAuthNames = Arrays.asList("BearerAuth");
    final String serializedBody = null;

    return new HttpRequest(
        localVarPath,
        HttpMethod.DELETE,
        localVarQueryParams,
        serializedBody,
        localVarHeaderParams,
        localVarAccepts,
        localVarContentTypes,
        localVarAuthNames);
  }

  /**
   * Dry run This operation will perform a dry run of a batch which calculates the bodies and number
   * of parts for all messages in the batch without actually sending any messages.
   *
   * @param sendRequest (optional)
   * @return DryRunResponse
   * @throws ApiException if fails to make API call
   */
  public DryRunResponse dryRun(BatchRequest sendRequest) throws ApiException {

    return dryRun(null, sendRequest);
  }

  /**
   * Dry run This operation will perform a dry run of a batch which calculates the bodies and number
   * of parts for all messages in the batch without actually sending any messages.
   *
   * @param queryParameter (optional)
   * @param sendRequest (optional)
   * @return DryRunResponse
   * @throws ApiException if fails to make API call
   */
  public DryRunResponse dryRun(DryRunQueryParameters queryParameter, BatchRequest sendRequest)
      throws ApiException {

    LOGGER.finest(
        "[dryRun]"
            + " "
            + "queryParameter: "
            + queryParameter
            + ", "
            + "sendRequest: "
            + sendRequest);

    HttpRequest httpRequest = dryRunRequestBuilder(queryParameter, sendRequest);
    HttpResponse response =
        httpClient.invokeAPI(
            this.serverConfiguration, this.authManagersByOasSecuritySchemes, httpRequest);

    if (HttpStatus.isSuccessfulStatus(response.getCode())) {
      TypeReference<DryRunResponse> localVarReturnType = new TypeReference<DryRunResponse>() {};
      return mapper.deserialize(response, localVarReturnType);
    }
    // fallback to default errors handling:
    // all error cases definition are not required from specs: will try some "hardcoded" content
    // parsing
    throw ApiExceptionBuilder.build(
        response.getMessage(),
        response.getCode(),
        mapper.deserialize(response, new TypeReference<HashMap<String, ?>>() {}));
  }

  private HttpRequest dryRunRequestBuilder(
      DryRunQueryParameters queryParameter, BatchRequest sendRequest) throws ApiException {
    // verify the required parameter 'this.servicePlanId' is set
    if (this.servicePlanId == null) {
      throw new ApiException(
          400, "Missing the required parameter 'this.servicePlanId' when calling dryRun");
    }

    String localVarPath =
        "/xms/v1/{service_plan_id}/batches/dry_run"
            .replaceAll(
                "\\{" + "service_plan_id" + "\\}",
                URLPathUtils.encodePathSegment(this.servicePlanId.toString()));

    List<URLParameter> localVarQueryParams = new ArrayList<>();
    if (null != queryParameter) {

      URLParameterUtils.addQueryParam(
          queryParameter.getPerRecipient(),
          "per_recipient",
          URLParameter.form,
          null,
          localVarQueryParams,
          true);

      URLParameterUtils.addQueryParam(
          queryParameter.getNumberOfRecipients(),
          "number_of_recipients",
          URLParameter.form,
          null,
          localVarQueryParams,
          true);
    }

    Map<String, String> localVarHeaderParams = new HashMap<>();

    final Collection<String> localVarAccepts = Arrays.asList("application/json");

    final Collection<String> localVarContentTypes = Arrays.asList("application/json");

    final Collection<String> localVarAuthNames = Arrays.asList("BearerAuth");
    final String serializedBody = mapper.serialize(localVarContentTypes, sendRequest);

    return new HttpRequest(
        localVarPath,
        HttpMethod.POST,
        localVarQueryParams,
        serializedBody,
        localVarHeaderParams,
        localVarAccepts,
        localVarContentTypes,
        localVarAuthNames);
  }

  /**
   * Get a batch message This operation returns a specific batch that matches the provided batch ID.
   *
   * @param batchId The batch ID you received from sending a message. (required)
   * @return BatchResponse
   * @throws ApiException if fails to make API call
   */
  public BatchResponse get(String batchId) throws ApiException {

    LOGGER.finest("[get]" + " " + "batchId: " + batchId);

    HttpRequest httpRequest = getRequestBuilder(batchId);
    HttpResponse response =
        httpClient.invokeAPI(
            this.serverConfiguration, this.authManagersByOasSecuritySchemes, httpRequest);

    if (HttpStatus.isSuccessfulStatus(response.getCode())) {
      TypeReference<BatchResponse> localVarReturnType = new TypeReference<BatchResponse>() {};
      return mapper.deserialize(response, localVarReturnType);
    }
    // fallback to default errors handling:
    // all error cases definition are not required from specs: will try some "hardcoded" content
    // parsing
    throw ApiExceptionBuilder.build(
        response.getMessage(),
        response.getCode(),
        mapper.deserialize(response, new TypeReference<HashMap<String, ?>>() {}));
  }

  private HttpRequest getRequestBuilder(String batchId) throws ApiException {
    // verify the required parameter 'this.servicePlanId' is set
    if (this.servicePlanId == null) {
      throw new ApiException(
          400, "Missing the required parameter 'this.servicePlanId' when calling get");
    }
    // verify the required parameter 'batchId' is set
    if (batchId == null) {
      throw new ApiException(400, "Missing the required parameter 'batchId' when calling get");
    }

    String localVarPath =
        "/xms/v1/{service_plan_id}/batches/{batch_id}"
            .replaceAll(
                "\\{" + "service_plan_id" + "\\}",
                URLPathUtils.encodePathSegment(this.servicePlanId.toString()))
            .replaceAll(
                "\\{" + "batch_id" + "\\}", URLPathUtils.encodePathSegment(batchId.toString()));

    List<URLParameter> localVarQueryParams = new ArrayList<>();

    Map<String, String> localVarHeaderParams = new HashMap<>();

    final Collection<String> localVarAccepts = Arrays.asList("application/json");

    final Collection<String> localVarContentTypes = Arrays.asList();

    final Collection<String> localVarAuthNames = Arrays.asList("BearerAuth");
    final String serializedBody = null;

    return new HttpRequest(
        localVarPath,
        HttpMethod.GET,
        localVarQueryParams,
        serializedBody,
        localVarHeaderParams,
        localVarAccepts,
        localVarContentTypes,
        localVarAuthNames);
  }

  /**
   * List Batches With the list operation you can list batch messages created in the last 14 days
   * that you have created. This operation supports pagination.
   *
   * @return ApiBatchList
   * @throws ApiException if fails to make API call
   */
  public ApiBatchList list() throws ApiException {

    return list(null);
  }

  /**
   * List Batches With the list operation you can list batch messages created in the last 14 days
   * that you have created. This operation supports pagination.
   *
   * @param queryParameter (optional)
   * @return ApiBatchList
   * @throws ApiException if fails to make API call
   */
  public ApiBatchList list(ListBatchesQueryParameters queryParameter) throws ApiException {

    LOGGER.finest("[list]" + " " + "queryParameter: " + queryParameter);

    HttpRequest httpRequest = listRequestBuilder(queryParameter);
    HttpResponse response =
        httpClient.invokeAPI(
            this.serverConfiguration, this.authManagersByOasSecuritySchemes, httpRequest);

    if (HttpStatus.isSuccessfulStatus(response.getCode())) {
      TypeReference<ApiBatchList> localVarReturnType = new TypeReference<ApiBatchList>() {};
      return mapper.deserialize(response, localVarReturnType);
    }
    // fallback to default errors handling:
    // all error cases definition are not required from specs: will try some "hardcoded" content
    // parsing
    throw ApiExceptionBuilder.build(
        response.getMessage(),
        response.getCode(),
        mapper.deserialize(response, new TypeReference<HashMap<String, ?>>() {}));
  }

  private HttpRequest listRequestBuilder(ListBatchesQueryParameters queryParameter)
      throws ApiException {
    // verify the required parameter 'this.servicePlanId' is set
    if (this.servicePlanId == null) {
      throw new ApiException(
          400, "Missing the required parameter 'this.servicePlanId' when calling list");
    }

    String localVarPath =
        "/xms/v1/{service_plan_id}/batches"
            .replaceAll(
                "\\{" + "service_plan_id" + "\\}",
                URLPathUtils.encodePathSegment(this.servicePlanId.toString()));

    List<URLParameter> localVarQueryParams = new ArrayList<>();
    if (null != queryParameter) {

      URLParameterUtils.addQueryParam(
          queryParameter.getPage(), "page", URLParameter.form, null, localVarQueryParams, true);

      URLParameterUtils.addQueryParam(
          queryParameter.getPageSize(),
          "page_size",
          URLParameter.form,
          null,
          localVarQueryParams,
          true);

      URLParameterUtils.addQueryParam(
          queryParameter.getFrom(), "from", URLParameter.form, null, localVarQueryParams, true);

      URLParameterUtils.addQueryParam(
          queryParameter.getStartDate(),
          "start_date",
          URLParameter.form,
          InstantToIso8601Serializer.getInstance(),
          localVarQueryParams,
          true);

      URLParameterUtils.addQueryParam(
          queryParameter.getEndDate(),
          "end_date",
          URLParameter.form,
          InstantToIso8601Serializer.getInstance(),
          localVarQueryParams,
          true);

      URLParameterUtils.addQueryParam(
          queryParameter.getClientReference(),
          "client_reference",
          URLParameter.form,
          null,
          localVarQueryParams,
          true);
    }

    Map<String, String> localVarHeaderParams = new HashMap<>();

    final Collection<String> localVarAccepts = Arrays.asList("application/json");

    final Collection<String> localVarContentTypes = Arrays.asList();

    final Collection<String> localVarAuthNames = Arrays.asList("BearerAuth");
    final String serializedBody = null;

    return new HttpRequest(
        localVarPath,
        HttpMethod.GET,
        localVarQueryParams,
        serializedBody,
        localVarHeaderParams,
        localVarAccepts,
        localVarContentTypes,
        localVarAuthNames);
  }

  /**
   * Replace a batch This operation will replace all the parameters of a batch with the provided
   * values. It is the same as cancelling a batch and sending a new one instead.
   *
   * @param batchId The batch ID you received from sending a message. (required)
   * @param sendRequest (optional)
   * @return BatchResponse
   * @throws ApiException if fails to make API call
   */
  public BatchResponse replace(String batchId, BatchRequest sendRequest) throws ApiException {

    LOGGER.finest("[replace]" + " " + "batchId: " + batchId + ", " + "sendRequest: " + sendRequest);

    HttpRequest httpRequest = replaceRequestBuilder(batchId, sendRequest);
    HttpResponse response =
        httpClient.invokeAPI(
            this.serverConfiguration, this.authManagersByOasSecuritySchemes, httpRequest);

    if (HttpStatus.isSuccessfulStatus(response.getCode())) {
      TypeReference<BatchResponse> localVarReturnType = new TypeReference<BatchResponse>() {};
      return mapper.deserialize(response, localVarReturnType);
    }
    // fallback to default errors handling:
    // all error cases definition are not required from specs: will try some "hardcoded" content
    // parsing
    throw ApiExceptionBuilder.build(
        response.getMessage(),
        response.getCode(),
        mapper.deserialize(response, new TypeReference<HashMap<String, ?>>() {}));
  }

  private HttpRequest replaceRequestBuilder(String batchId, BatchRequest sendRequest)
      throws ApiException {
    // verify the required parameter 'this.servicePlanId' is set
    if (this.servicePlanId == null) {
      throw new ApiException(
          400, "Missing the required parameter 'this.servicePlanId' when calling replace");
    }
    // verify the required parameter 'batchId' is set
    if (batchId == null) {
      throw new ApiException(400, "Missing the required parameter 'batchId' when calling replace");
    }

    String localVarPath =
        "/xms/v1/{service_plan_id}/batches/{batch_id}"
            .replaceAll(
                "\\{" + "service_plan_id" + "\\}",
                URLPathUtils.encodePathSegment(this.servicePlanId.toString()))
            .replaceAll(
                "\\{" + "batch_id" + "\\}", URLPathUtils.encodePathSegment(batchId.toString()));

    List<URLParameter> localVarQueryParams = new ArrayList<>();

    Map<String, String> localVarHeaderParams = new HashMap<>();

    final Collection<String> localVarAccepts = Arrays.asList("application/json");

    final Collection<String> localVarContentTypes = Arrays.asList("application/json");

    final Collection<String> localVarAuthNames = Arrays.asList("BearerAuth");
    final String serializedBody = mapper.serialize(localVarContentTypes, sendRequest);

    return new HttpRequest(
        localVarPath,
        HttpMethod.PUT,
        localVarQueryParams,
        serializedBody,
        localVarHeaderParams,
        localVarAccepts,
        localVarContentTypes,
        localVarAuthNames);
  }

  /**
   * Send delivery feedback for a message Send feedback if your system can confirm successful
   * message delivery. Feedback can only be provided if &#x60;feedback_enabled&#x60; was set when
   * batch was submitted. **Batches**: It is possible to submit feedback multiple times for the same
   * batch for different recipients. Feedback without specified recipients is treated as successful
   * message delivery to all recipients referenced in the batch. Note that the
   * &#x60;recipients&#x60; key is still required even if the value is empty. **Groups**: If the
   * batch message was creating using a group ID, at least one recipient is required. Excluding
   * recipients (an empty recipient list) does not work and will result in a failed request.
   *
   * @param batchId The batch ID you received from sending a message. (required)
   * @param sendDeliveryFeedbackRequest A list of phone numbers (MSISDNs) that successfully received
   *     the message. (required)
   * @throws ApiException if fails to make API call
   */
  public void sendDeliveryFeedback(
      String batchId, SendDeliveryFeedbackRequest sendDeliveryFeedbackRequest) throws ApiException {

    LOGGER.finest(
        "[sendDeliveryFeedback]"
            + " "
            + "batchId: "
            + batchId
            + ", "
            + "sendDeliveryFeedbackRequest: "
            + sendDeliveryFeedbackRequest);

    HttpRequest httpRequest =
        sendDeliveryFeedbackRequestBuilder(batchId, sendDeliveryFeedbackRequest);
    HttpResponse response =
        httpClient.invokeAPI(
            this.serverConfiguration, this.authManagersByOasSecuritySchemes, httpRequest);

    if (HttpStatus.isSuccessfulStatus(response.getCode())) {
      return;
    }
    // fallback to default errors handling:
    // all error cases definition are not required from specs: will try some "hardcoded" content
    // parsing
    throw ApiExceptionBuilder.build(
        response.getMessage(),
        response.getCode(),
        mapper.deserialize(response, new TypeReference<HashMap<String, ?>>() {}));
  }

  private HttpRequest sendDeliveryFeedbackRequestBuilder(
      String batchId, SendDeliveryFeedbackRequest sendDeliveryFeedbackRequest) throws ApiException {
    // verify the required parameter 'this.servicePlanId' is set
    if (this.servicePlanId == null) {
      throw new ApiException(
          400,
          "Missing the required parameter 'this.servicePlanId' when calling sendDeliveryFeedback");
    }
    // verify the required parameter 'batchId' is set
    if (batchId == null) {
      throw new ApiException(
          400, "Missing the required parameter 'batchId' when calling sendDeliveryFeedback");
    }
    // verify the required parameter 'sendDeliveryFeedbackRequest' is set
    if (sendDeliveryFeedbackRequest == null) {
      throw new ApiException(
          400,
          "Missing the required parameter 'sendDeliveryFeedbackRequest' when calling"
              + " sendDeliveryFeedback");
    }

    String localVarPath =
        "/xms/v1/{service_plan_id}/batches/{batch_id}/delivery_feedback"
            .replaceAll(
                "\\{" + "service_plan_id" + "\\}",
                URLPathUtils.encodePathSegment(this.servicePlanId.toString()))
            .replaceAll(
                "\\{" + "batch_id" + "\\}", URLPathUtils.encodePathSegment(batchId.toString()));

    List<URLParameter> localVarQueryParams = new ArrayList<>();

    Map<String, String> localVarHeaderParams = new HashMap<>();

    final Collection<String> localVarAccepts = Arrays.asList();

    final Collection<String> localVarContentTypes = Arrays.asList("application/json");

    final Collection<String> localVarAuthNames = Arrays.asList("BearerAuth");
    final String serializedBody =
        mapper.serialize(localVarContentTypes, sendDeliveryFeedbackRequest);

    return new HttpRequest(
        localVarPath,
        HttpMethod.POST,
        localVarQueryParams,
        serializedBody,
        localVarHeaderParams,
        localVarAccepts,
        localVarContentTypes,
        localVarAuthNames);
  }

  /**
   * Send Send a message or a batch of messages. Depending on the length of the body, one message
   * might be split into multiple parts and charged accordingly. Any groups targeted in a scheduled
   * batch will be evaluated at the time of sending. If a group is deleted between batch creation
   * and scheduled date, it will be considered empty. Be sure to use the correct
   * [region](/docs/sms/api-reference/#base-url) in the server URL.
   *
   * @param sendRequest Default schema is Text if type is not specified. (optional)
   * @return BatchResponse
   * @throws ApiException if fails to make API call
   */
  public BatchResponse send(BatchRequest sendRequest) throws ApiException {

    LOGGER.finest("[send]" + " " + "sendRequest: " + sendRequest);

    HttpRequest httpRequest = sendRequestBuilder(sendRequest);
    HttpResponse response =
        httpClient.invokeAPI(
            this.serverConfiguration, this.authManagersByOasSecuritySchemes, httpRequest);

    if (HttpStatus.isSuccessfulStatus(response.getCode())) {
      TypeReference<BatchResponse> localVarReturnType = new TypeReference<BatchResponse>() {};
      return mapper.deserialize(response, localVarReturnType);
    }
    // fallback to default errors handling:
    // all error cases definition are not required from specs: will try some "hardcoded" content
    // parsing
    throw ApiExceptionBuilder.build(
        response.getMessage(),
        response.getCode(),
        mapper.deserialize(response, new TypeReference<HashMap<String, ?>>() {}));
  }

  private HttpRequest sendRequestBuilder(BatchRequest sendRequest) throws ApiException {
    // verify the required parameter 'this.servicePlanId' is set
    if (this.servicePlanId == null) {
      throw new ApiException(
          400, "Missing the required parameter 'this.servicePlanId' when calling send");
    }

    String localVarPath =
        "/xms/v1/{service_plan_id}/batches"
            .replaceAll(
                "\\{" + "service_plan_id" + "\\}",
                URLPathUtils.encodePathSegment(this.servicePlanId.toString()));

    List<URLParameter> localVarQueryParams = new ArrayList<>();

    Map<String, String> localVarHeaderParams = new HashMap<>();

    final Collection<String> localVarAccepts = Arrays.asList("application/json");

    final Collection<String> localVarContentTypes = Arrays.asList("application/json");

    final Collection<String> localVarAuthNames = Arrays.asList("BearerAuth");
    final String serializedBody = mapper.serialize(localVarContentTypes, sendRequest);

    return new HttpRequest(
        localVarPath,
        HttpMethod.POST,
        localVarQueryParams,
        serializedBody,
        localVarHeaderParams,
        localVarAccepts,
        localVarContentTypes,
        localVarAuthNames);
  }

  /**
   * Update a Batch message This operation updates all specified parameters of a batch that matches
   * the provided batch ID.
   *
   * @param batchId The batch ID you received from sending a message. (required)
   * @param updateBatchRequest (optional)
   * @return BatchResponse
   * @throws ApiException if fails to make API call
   */
  public BatchResponse update(String batchId, UpdateBatchRequest updateBatchRequest)
      throws ApiException {

    LOGGER.finest(
        "[update]"
            + " "
            + "batchId: "
            + batchId
            + ", "
            + "updateBatchRequest: "
            + updateBatchRequest);

    HttpRequest httpRequest = updateRequestBuilder(batchId, updateBatchRequest);
    HttpResponse response =
        httpClient.invokeAPI(
            this.serverConfiguration, this.authManagersByOasSecuritySchemes, httpRequest);

    if (HttpStatus.isSuccessfulStatus(response.getCode())) {
      TypeReference<BatchResponse> localVarReturnType = new TypeReference<BatchResponse>() {};
      return mapper.deserialize(response, localVarReturnType);
    }
    // fallback to default errors handling:
    // all error cases definition are not required from specs: will try some "hardcoded" content
    // parsing
    throw ApiExceptionBuilder.build(
        response.getMessage(),
        response.getCode(),
        mapper.deserialize(response, new TypeReference<HashMap<String, ?>>() {}));
  }

  private HttpRequest updateRequestBuilder(String batchId, UpdateBatchRequest updateBatchRequest)
      throws ApiException {
    // verify the required parameter 'this.servicePlanId' is set
    if (this.servicePlanId == null) {
      throw new ApiException(
          400, "Missing the required parameter 'this.servicePlanId' when calling update");
    }
    // verify the required parameter 'batchId' is set
    if (batchId == null) {
      throw new ApiException(400, "Missing the required parameter 'batchId' when calling update");
    }

    String localVarPath =
        "/xms/v1/{service_plan_id}/batches/{batch_id}"
            .replaceAll(
                "\\{" + "service_plan_id" + "\\}",
                URLPathUtils.encodePathSegment(this.servicePlanId.toString()))
            .replaceAll(
                "\\{" + "batch_id" + "\\}", URLPathUtils.encodePathSegment(batchId.toString()));

    List<URLParameter> localVarQueryParams = new ArrayList<>();

    Map<String, String> localVarHeaderParams = new HashMap<>();

    final Collection<String> localVarAccepts = Arrays.asList("application/json");

    final Collection<String> localVarContentTypes = Arrays.asList("application/json");

    final Collection<String> localVarAuthNames = Arrays.asList("BearerAuth");
    final String serializedBody = mapper.serialize(localVarContentTypes, updateBatchRequest);

    return new HttpRequest(
        localVarPath,
        HttpMethod.POST,
        localVarQueryParams,
        serializedBody,
        localVarHeaderParams,
        localVarAccepts,
        localVarContentTypes,
        localVarAuthNames);
  }
}
