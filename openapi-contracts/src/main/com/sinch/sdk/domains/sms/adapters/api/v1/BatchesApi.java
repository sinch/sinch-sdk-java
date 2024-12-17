/*
 * API Overview | Sinch
 * Sinch SMS API is one of the easiest APIs we offer and enables you to add fast and reliable global SMS to your applications. Send single messages, scheduled batch messages, use available message templates and more.
 *
 * The version of the OpenAPI document: v1
 * Contact: Support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.sms.adapters.api.v1;

import com.fasterxml.jackson.core.type.TypeReference;
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
import com.sinch.sdk.core.http.URLPathUtils;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.domains.sms.models.dto.v1.ApiBatchListDto;
import com.sinch.sdk.domains.sms.models.dto.v1.ApiDeliveryFeedbackDto;
import com.sinch.sdk.domains.sms.models.dto.v1.DryRun200ResponseDto;
import com.sinch.sdk.domains.sms.models.dto.v1.SendSMS201ResponseDto;
import com.sinch.sdk.domains.sms.models.dto.v1.SendSMSRequestDto;
import com.sinch.sdk.domains.sms.models.dto.v1.UpdateBatchMessageRequestDto;
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

  public BatchesApi(
      HttpClient httpClient,
      ServerConfiguration serverConfiguration,
      Map<String, AuthManager> authManagersByOasSecuritySchemes,
      HttpMapper mapper) {
    this.httpClient = httpClient;
    this.serverConfiguration = serverConfiguration;
    this.authManagersByOasSecuritySchemes = authManagersByOasSecuritySchemes;
    this.mapper = mapper;
  }

  /**
   * Cancel a batch message A batch can be canceled at any point. If a batch is canceled while
   * it&#39;s currently being delivered some messages currently being processed might still be
   * delivered. The delivery report will indicate which messages were canceled and which
   * weren&#39;t. Canceling a batch scheduled in the future will result in an empty delivery report
   * while canceling an already sent batch would result in no change to the completed delivery
   * report.
   *
   * @param servicePlanId Your service plan ID. You can find this on your
   *     [Dashboard](https://dashboard.sinch.com/sms/api/rest). (required)
   * @param batchId The batch ID you received from sending a message. (required)
   * @return SendSMS201ResponseDto
   * @throws ApiException if fails to make API call
   */
  public SendSMS201ResponseDto cancelBatchMessage(String servicePlanId, String batchId)
      throws ApiException {

    LOGGER.finest(
        "[cancelBatchMessage]"
            + " "
            + "servicePlanId: "
            + servicePlanId
            + ", "
            + "batchId: "
            + batchId);

    HttpRequest httpRequest = cancelBatchMessageRequestBuilder(servicePlanId, batchId);
    HttpResponse response =
        httpClient.invokeAPI(
            this.serverConfiguration, this.authManagersByOasSecuritySchemes, httpRequest);

    if (HttpStatus.isSuccessfulStatus(response.getCode())) {
      TypeReference<SendSMS201ResponseDto> localVarReturnType =
          new TypeReference<SendSMS201ResponseDto>() {};
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

  private HttpRequest cancelBatchMessageRequestBuilder(String servicePlanId, String batchId)
      throws ApiException {
    // verify the required parameter 'servicePlanId' is set
    if (servicePlanId == null) {
      throw new ApiException(
          400, "Missing the required parameter 'servicePlanId' when calling cancelBatchMessage");
    }
    // verify the required parameter 'batchId' is set
    if (batchId == null) {
      throw new ApiException(
          400, "Missing the required parameter 'batchId' when calling cancelBatchMessage");
    }

    String localVarPath =
        "/xms/v1/{service_plan_id}/batches/{batch_id}"
            .replaceAll(
                "\\{" + "service_plan_id" + "\\}",
                URLPathUtils.encodePathSegment(servicePlanId.toString()))
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
   * Send delivery feedback for a message Send feedback if your system can confirm successful
   * message delivery. Feedback can only be provided if &#x60;feedback_enabled&#x60; was set when
   * batch was submitted. **Batches**: It is possible to submit feedback multiple times for the same
   * batch for different recipients. Feedback without specified recipients is treated as successful
   * message delivery to all recipients referenced in the batch. Note that the
   * &#x60;recipients&#x60; key is still required even if the value is empty. **Groups**: If the
   * batch message was creating using a group ID, at least one recipient is required. Excluding
   * recipients (an empty recipient list) does not work and will result in a failed request.
   *
   * @param servicePlanId Your service plan ID. You can find this on your
   *     [Dashboard](https://dashboard.sinch.com/sms/api/rest). (required)
   * @param batchId The batch ID you received from sending a message. (required)
   * @param apiDeliveryFeedbackDto A list of phone numbers (MSISDNs) that successfully received the
   *     message. (required)
   * @throws ApiException if fails to make API call
   */
  public void deliveryFeedback(
      String servicePlanId, String batchId, ApiDeliveryFeedbackDto apiDeliveryFeedbackDto)
      throws ApiException {

    LOGGER.finest(
        "[deliveryFeedback]"
            + " "
            + "servicePlanId: "
            + servicePlanId
            + ", "
            + "batchId: "
            + batchId
            + ", "
            + "apiDeliveryFeedbackDto: "
            + apiDeliveryFeedbackDto);

    HttpRequest httpRequest =
        deliveryFeedbackRequestBuilder(servicePlanId, batchId, apiDeliveryFeedbackDto);
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

  private HttpRequest deliveryFeedbackRequestBuilder(
      String servicePlanId, String batchId, ApiDeliveryFeedbackDto apiDeliveryFeedbackDto)
      throws ApiException {
    // verify the required parameter 'servicePlanId' is set
    if (servicePlanId == null) {
      throw new ApiException(
          400, "Missing the required parameter 'servicePlanId' when calling deliveryFeedback");
    }
    // verify the required parameter 'batchId' is set
    if (batchId == null) {
      throw new ApiException(
          400, "Missing the required parameter 'batchId' when calling deliveryFeedback");
    }
    // verify the required parameter 'apiDeliveryFeedbackDto' is set
    if (apiDeliveryFeedbackDto == null) {
      throw new ApiException(
          400,
          "Missing the required parameter 'apiDeliveryFeedbackDto' when calling deliveryFeedback");
    }

    String localVarPath =
        "/xms/v1/{service_plan_id}/batches/{batch_id}/delivery_feedback"
            .replaceAll(
                "\\{" + "service_plan_id" + "\\}",
                URLPathUtils.encodePathSegment(servicePlanId.toString()))
            .replaceAll(
                "\\{" + "batch_id" + "\\}", URLPathUtils.encodePathSegment(batchId.toString()));

    List<URLParameter> localVarQueryParams = new ArrayList<>();

    Map<String, String> localVarHeaderParams = new HashMap<>();

    final Collection<String> localVarAccepts = Arrays.asList();

    final Collection<String> localVarContentTypes = Arrays.asList("application/json");

    final Collection<String> localVarAuthNames = Arrays.asList("BearerAuth");
    final String serializedBody = mapper.serialize(localVarContentTypes, apiDeliveryFeedbackDto);

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
   * Dry run This operation will perform a dry run of a batch which calculates the bodies and number
   * of parts for all messages in the batch without actually sending any messages.
   *
   * @param servicePlanId Your service plan ID. You can find this on your
   *     [Dashboard](https://dashboard.sinch.com/sms/api/rest). (required)
   * @param perRecipient Whether to include per recipient details in the response (optional)
   * @param numberOfRecipients Max number of recipients to include per recipient details for in the
   *     response (optional, default to 100)
   * @param sendSMSRequestDto (optional)
   * @return DryRun200ResponseDto
   * @throws ApiException if fails to make API call
   */
  public DryRun200ResponseDto dryRun(
      String servicePlanId,
      Boolean perRecipient,
      Integer numberOfRecipients,
      SendSMSRequestDto sendSMSRequestDto)
      throws ApiException {

    LOGGER.finest(
        "[dryRun]"
            + " "
            + "servicePlanId: "
            + servicePlanId
            + ", "
            + "perRecipient: "
            + perRecipient
            + ", "
            + "numberOfRecipients: "
            + numberOfRecipients
            + ", "
            + "sendSMSRequestDto: "
            + sendSMSRequestDto);

    HttpRequest httpRequest =
        dryRunRequestBuilder(servicePlanId, perRecipient, numberOfRecipients, sendSMSRequestDto);
    HttpResponse response =
        httpClient.invokeAPI(
            this.serverConfiguration, this.authManagersByOasSecuritySchemes, httpRequest);

    if (HttpStatus.isSuccessfulStatus(response.getCode())) {
      TypeReference<DryRun200ResponseDto> localVarReturnType =
          new TypeReference<DryRun200ResponseDto>() {};
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
      String servicePlanId,
      Boolean perRecipient,
      Integer numberOfRecipients,
      SendSMSRequestDto sendSMSRequestDto)
      throws ApiException {
    // verify the required parameter 'servicePlanId' is set
    if (servicePlanId == null) {
      throw new ApiException(
          400, "Missing the required parameter 'servicePlanId' when calling dryRun");
    }

    String localVarPath =
        "/xms/v1/{service_plan_id}/batches/dry_run"
            .replaceAll(
                "\\{" + "service_plan_id" + "\\}",
                URLPathUtils.encodePathSegment(servicePlanId.toString()));

    List<URLParameter> localVarQueryParams = new ArrayList<>();
    if (null != perRecipient) {
      localVarQueryParams.add(
          new URLParameter(
              "per_recipient",
              perRecipient,
              URLParameter.STYLE.valueOf("form".toUpperCase()),
              true));
    }
    if (null != numberOfRecipients) {
      localVarQueryParams.add(
          new URLParameter(
              "number_of_recipients",
              numberOfRecipients,
              URLParameter.STYLE.valueOf("form".toUpperCase()),
              true));
    }

    Map<String, String> localVarHeaderParams = new HashMap<>();

    final Collection<String> localVarAccepts = Arrays.asList("application/json");

    final Collection<String> localVarContentTypes = Arrays.asList("application/json");

    final Collection<String> localVarAuthNames = Arrays.asList("BearerAuth");
    final String serializedBody = mapper.serialize(localVarContentTypes, sendSMSRequestDto);

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
   * @param servicePlanId Your service plan ID. You can find this on your
   *     [Dashboard](https://dashboard.sinch.com/sms/api/rest). (required)
   * @param batchId The batch ID you received from sending a message. (required)
   * @return SendSMS201ResponseDto
   * @throws ApiException if fails to make API call
   */
  public SendSMS201ResponseDto getBatchMessage(String servicePlanId, String batchId)
      throws ApiException {

    LOGGER.finest(
        "[getBatchMessage]"
            + " "
            + "servicePlanId: "
            + servicePlanId
            + ", "
            + "batchId: "
            + batchId);

    HttpRequest httpRequest = getBatchMessageRequestBuilder(servicePlanId, batchId);
    HttpResponse response =
        httpClient.invokeAPI(
            this.serverConfiguration, this.authManagersByOasSecuritySchemes, httpRequest);

    if (HttpStatus.isSuccessfulStatus(response.getCode())) {
      TypeReference<SendSMS201ResponseDto> localVarReturnType =
          new TypeReference<SendSMS201ResponseDto>() {};
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

  private HttpRequest getBatchMessageRequestBuilder(String servicePlanId, String batchId)
      throws ApiException {
    // verify the required parameter 'servicePlanId' is set
    if (servicePlanId == null) {
      throw new ApiException(
          400, "Missing the required parameter 'servicePlanId' when calling getBatchMessage");
    }
    // verify the required parameter 'batchId' is set
    if (batchId == null) {
      throw new ApiException(
          400, "Missing the required parameter 'batchId' when calling getBatchMessage");
    }

    String localVarPath =
        "/xms/v1/{service_plan_id}/batches/{batch_id}"
            .replaceAll(
                "\\{" + "service_plan_id" + "\\}",
                URLPathUtils.encodePathSegment(servicePlanId.toString()))
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
   * @param servicePlanId Your service plan ID. You can find this on your
   *     [Dashboard](https://dashboard.sinch.com/sms/api/rest). (required)
   * @param page The page number starting from 0. (optional)
   * @param pageSize Determines the size of a page. (optional, default to 30)
   * @param from Only list messages sent from this sender number. Multiple originating numbers can
   *     be comma separated. Must be phone numbers or short code. (optional)
   * @param startDate Only list messages received at or after this date/time. Formatted as
   *     [ISO-8601](https://en.wikipedia.org/wiki/ISO_8601): &#x60;YYYY-MM-DDThh:mm:ss.SSSZ&#x60;.
   *     Default: Now-24 (optional)
   * @param endDate Only list messages received before this date/time. Formatted as
   *     [ISO-8601](https://en.wikipedia.org/wiki/ISO_8601): &#x60;YYYY-MM-DDThh:mm:ss.SSSZ&#x60;.
   *     (optional)
   * @param clientReference Client reference to include (optional)
   * @return ApiBatchListDto
   * @throws ApiException if fails to make API call
   */
  public ApiBatchListDto listBatches(
      String servicePlanId,
      Integer page,
      Integer pageSize,
      String from,
      String startDate,
      String endDate,
      String clientReference)
      throws ApiException {

    LOGGER.finest(
        "[listBatches]"
            + " "
            + "servicePlanId: "
            + servicePlanId
            + ", "
            + "page: "
            + page
            + ", "
            + "pageSize: "
            + pageSize
            + ", "
            + "from: "
            + from
            + ", "
            + "startDate: "
            + startDate
            + ", "
            + "endDate: "
            + endDate
            + ", "
            + "clientReference: "
            + clientReference);

    HttpRequest httpRequest =
        listBatchesRequestBuilder(
            servicePlanId, page, pageSize, from, startDate, endDate, clientReference);
    HttpResponse response =
        httpClient.invokeAPI(
            this.serverConfiguration, this.authManagersByOasSecuritySchemes, httpRequest);

    if (HttpStatus.isSuccessfulStatus(response.getCode())) {
      TypeReference<ApiBatchListDto> localVarReturnType = new TypeReference<ApiBatchListDto>() {};
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

  private HttpRequest listBatchesRequestBuilder(
      String servicePlanId,
      Integer page,
      Integer pageSize,
      String from,
      String startDate,
      String endDate,
      String clientReference)
      throws ApiException {
    // verify the required parameter 'servicePlanId' is set
    if (servicePlanId == null) {
      throw new ApiException(
          400, "Missing the required parameter 'servicePlanId' when calling listBatches");
    }

    String localVarPath =
        "/xms/v1/{service_plan_id}/batches"
            .replaceAll(
                "\\{" + "service_plan_id" + "\\}",
                URLPathUtils.encodePathSegment(servicePlanId.toString()));

    List<URLParameter> localVarQueryParams = new ArrayList<>();
    if (null != page) {
      localVarQueryParams.add(
          new URLParameter("page", page, URLParameter.STYLE.valueOf("form".toUpperCase()), true));
    }
    if (null != pageSize) {
      localVarQueryParams.add(
          new URLParameter(
              "page_size", pageSize, URLParameter.STYLE.valueOf("form".toUpperCase()), true));
    }
    if (null != from) {
      localVarQueryParams.add(
          new URLParameter("from", from, URLParameter.STYLE.valueOf("form".toUpperCase()), true));
    }
    if (null != startDate) {
      localVarQueryParams.add(
          new URLParameter(
              "start_date", startDate, URLParameter.STYLE.valueOf("form".toUpperCase()), true));
    }
    if (null != endDate) {
      localVarQueryParams.add(
          new URLParameter(
              "end_date", endDate, URLParameter.STYLE.valueOf("form".toUpperCase()), true));
    }
    if (null != clientReference) {
      localVarQueryParams.add(
          new URLParameter(
              "client_reference",
              clientReference,
              URLParameter.STYLE.valueOf("form".toUpperCase()),
              true));
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
   * @param servicePlanId Your service plan ID. You can find this on your
   *     [Dashboard](https://dashboard.sinch.com/sms/api/rest). (required)
   * @param batchId The batch ID you received from sending a message. (required)
   * @param sendSMSRequestDto (optional)
   * @return SendSMS201ResponseDto
   * @throws ApiException if fails to make API call
   */
  public SendSMS201ResponseDto replaceBatch(
      String servicePlanId, String batchId, SendSMSRequestDto sendSMSRequestDto)
      throws ApiException {

    LOGGER.finest(
        "[replaceBatch]"
            + " "
            + "servicePlanId: "
            + servicePlanId
            + ", "
            + "batchId: "
            + batchId
            + ", "
            + "sendSMSRequestDto: "
            + sendSMSRequestDto);

    HttpRequest httpRequest = replaceBatchRequestBuilder(servicePlanId, batchId, sendSMSRequestDto);
    HttpResponse response =
        httpClient.invokeAPI(
            this.serverConfiguration, this.authManagersByOasSecuritySchemes, httpRequest);

    if (HttpStatus.isSuccessfulStatus(response.getCode())) {
      TypeReference<SendSMS201ResponseDto> localVarReturnType =
          new TypeReference<SendSMS201ResponseDto>() {};
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

  private HttpRequest replaceBatchRequestBuilder(
      String servicePlanId, String batchId, SendSMSRequestDto sendSMSRequestDto)
      throws ApiException {
    // verify the required parameter 'servicePlanId' is set
    if (servicePlanId == null) {
      throw new ApiException(
          400, "Missing the required parameter 'servicePlanId' when calling replaceBatch");
    }
    // verify the required parameter 'batchId' is set
    if (batchId == null) {
      throw new ApiException(
          400, "Missing the required parameter 'batchId' when calling replaceBatch");
    }

    String localVarPath =
        "/xms/v1/{service_plan_id}/batches/{batch_id}"
            .replaceAll(
                "\\{" + "service_plan_id" + "\\}",
                URLPathUtils.encodePathSegment(servicePlanId.toString()))
            .replaceAll(
                "\\{" + "batch_id" + "\\}", URLPathUtils.encodePathSegment(batchId.toString()));

    List<URLParameter> localVarQueryParams = new ArrayList<>();

    Map<String, String> localVarHeaderParams = new HashMap<>();

    final Collection<String> localVarAccepts = Arrays.asList("application/json");

    final Collection<String> localVarContentTypes = Arrays.asList("application/json");

    final Collection<String> localVarAuthNames = Arrays.asList("BearerAuth");
    final String serializedBody = mapper.serialize(localVarContentTypes, sendSMSRequestDto);

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
   * Send Send a message or a batch of messages. Depending on the length of the body, one message
   * might be split into multiple parts and charged accordingly. Any groups targeted in a scheduled
   * batch will be evaluated at the time of sending. If a group is deleted between batch creation
   * and scheduled date, it will be considered empty. Be sure to use the correct &lt;a
   * href&#x3D;\&quot;/docs/sms/api-reference/#base-url\&quot;
   * target&#x3D;\&quot;_blank\&quot;&gt;region&lt;/a&gt; in the server URL.
   *
   * @param servicePlanId Your service plan ID. You can find this on your
   *     [Dashboard](https://dashboard.sinch.com/sms/api/rest). (required)
   * @param sendSMSRequestDto Default schema is Text if type is not specified. (optional)
   * @return SendSMS201ResponseDto
   * @throws ApiException if fails to make API call
   */
  public SendSMS201ResponseDto sendSMS(String servicePlanId, SendSMSRequestDto sendSMSRequestDto)
      throws ApiException {

    LOGGER.finest(
        "[sendSMS]"
            + " "
            + "servicePlanId: "
            + servicePlanId
            + ", "
            + "sendSMSRequestDto: "
            + sendSMSRequestDto);

    HttpRequest httpRequest = sendSMSRequestBuilder(servicePlanId, sendSMSRequestDto);
    HttpResponse response =
        httpClient.invokeAPI(
            this.serverConfiguration, this.authManagersByOasSecuritySchemes, httpRequest);

    if (HttpStatus.isSuccessfulStatus(response.getCode())) {
      TypeReference<SendSMS201ResponseDto> localVarReturnType =
          new TypeReference<SendSMS201ResponseDto>() {};
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

  private HttpRequest sendSMSRequestBuilder(
      String servicePlanId, SendSMSRequestDto sendSMSRequestDto) throws ApiException {
    // verify the required parameter 'servicePlanId' is set
    if (servicePlanId == null) {
      throw new ApiException(
          400, "Missing the required parameter 'servicePlanId' when calling sendSMS");
    }

    String localVarPath =
        "/xms/v1/{service_plan_id}/batches"
            .replaceAll(
                "\\{" + "service_plan_id" + "\\}",
                URLPathUtils.encodePathSegment(servicePlanId.toString()));

    List<URLParameter> localVarQueryParams = new ArrayList<>();

    Map<String, String> localVarHeaderParams = new HashMap<>();

    final Collection<String> localVarAccepts = Arrays.asList("application/json");

    final Collection<String> localVarContentTypes = Arrays.asList("application/json");

    final Collection<String> localVarAuthNames = Arrays.asList("BearerAuth");
    final String serializedBody = mapper.serialize(localVarContentTypes, sendSMSRequestDto);

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
   * Update a BatchResponse message This operation updates all specified parameters of a batch that
   * matches the provided batch ID.
   *
   * @param servicePlanId Your service plan ID. You can find this on your
   *     [Dashboard](https://dashboard.sinch.com/sms/api/rest). (required)
   * @param batchId The batch ID you received from sending a message. (required)
   * @param updateBatchMessageRequestDto (optional)
   * @return SendSMS201ResponseDto
   * @throws ApiException if fails to make API call
   */
  public SendSMS201ResponseDto updateBatchMessage(
      String servicePlanId,
      String batchId,
      UpdateBatchMessageRequestDto updateBatchMessageRequestDto)
      throws ApiException {

    LOGGER.finest(
        "[updateBatchMessage]"
            + " "
            + "servicePlanId: "
            + servicePlanId
            + ", "
            + "batchId: "
            + batchId
            + ", "
            + "updateBatchMessageRequestDto: "
            + updateBatchMessageRequestDto);

    HttpRequest httpRequest =
        updateBatchMessageRequestBuilder(servicePlanId, batchId, updateBatchMessageRequestDto);
    HttpResponse response =
        httpClient.invokeAPI(
            this.serverConfiguration, this.authManagersByOasSecuritySchemes, httpRequest);

    if (HttpStatus.isSuccessfulStatus(response.getCode())) {
      TypeReference<SendSMS201ResponseDto> localVarReturnType =
          new TypeReference<SendSMS201ResponseDto>() {};
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

  private HttpRequest updateBatchMessageRequestBuilder(
      String servicePlanId,
      String batchId,
      UpdateBatchMessageRequestDto updateBatchMessageRequestDto)
      throws ApiException {
    // verify the required parameter 'servicePlanId' is set
    if (servicePlanId == null) {
      throw new ApiException(
          400, "Missing the required parameter 'servicePlanId' when calling updateBatchMessage");
    }
    // verify the required parameter 'batchId' is set
    if (batchId == null) {
      throw new ApiException(
          400, "Missing the required parameter 'batchId' when calling updateBatchMessage");
    }

    String localVarPath =
        "/xms/v1/{service_plan_id}/batches/{batch_id}"
            .replaceAll(
                "\\{" + "service_plan_id" + "\\}",
                URLPathUtils.encodePathSegment(servicePlanId.toString()))
            .replaceAll(
                "\\{" + "batch_id" + "\\}", URLPathUtils.encodePathSegment(batchId.toString()));

    List<URLParameter> localVarQueryParams = new ArrayList<>();

    Map<String, String> localVarHeaderParams = new HashMap<>();

    final Collection<String> localVarAccepts = Arrays.asList("application/json");

    final Collection<String> localVarContentTypes = Arrays.asList("application/json");

    final Collection<String> localVarAuthNames = Arrays.asList("BearerAuth");
    final String serializedBody =
        mapper.serialize(localVarContentTypes, updateBatchMessageRequestDto);

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
