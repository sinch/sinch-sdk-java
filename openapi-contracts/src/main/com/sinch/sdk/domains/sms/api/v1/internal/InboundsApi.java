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
import com.sinch.sdk.core.databind.query_parameter.CollectionStringToCommaSerializer;
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
import com.sinch.sdk.domains.sms.models.v1.inbounds.InboundMessage;
import com.sinch.sdk.domains.sms.models.v1.inbounds.request.ListInboundMessagesQueryParameters;
import com.sinch.sdk.domains.sms.models.v1.inbounds.response.internal.ApiInboundList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class InboundsApi {

  private static final Logger LOGGER = Logger.getLogger(InboundsApi.class.getName());
  private HttpClient httpClient;
  private ServerConfiguration serverConfiguration;
  private Map<String, AuthManager> authManagersByOasSecuritySchemes;
  private HttpMapper mapper;

  private final String servicePlanId;

  public InboundsApi(
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
   * List incoming messages With the list operation, you can list all inbound messages that you have
   * received. This operation supports pagination. Inbounds are returned in reverse chronological
   * order.
   *
   * @return ApiInboundList
   * @throws ApiException if fails to make API call
   */
  public ApiInboundList list() throws ApiException {

    return list(null);
  }

  /**
   * List incoming messages With the list operation, you can list all inbound messages that you have
   * received. This operation supports pagination. Inbounds are returned in reverse chronological
   * order.
   *
   * @param queryParameter (optional)
   * @return ApiInboundList
   * @throws ApiException if fails to make API call
   */
  public ApiInboundList list(ListInboundMessagesQueryParameters queryParameter)
      throws ApiException {

    LOGGER.finest("[list]" + " " + "queryParameter: " + queryParameter);

    HttpRequest httpRequest = listRequestBuilder(queryParameter);
    HttpResponse response =
        httpClient.invokeAPI(
            this.serverConfiguration, this.authManagersByOasSecuritySchemes, httpRequest);

    if (HttpStatus.isSuccessfulStatus(response.getCode())) {
      TypeReference<ApiInboundList> localVarReturnType = new TypeReference<ApiInboundList>() {};
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

  private HttpRequest listRequestBuilder(ListInboundMessagesQueryParameters queryParameter)
      throws ApiException {
    // verify the required parameter 'this.servicePlanId' is set
    if (this.servicePlanId == null) {
      throw new ApiException(
          400, "Missing the required parameter 'this.servicePlanId' when calling list");
    }

    String localVarPath =
        "/xms/v1/{service_plan_id}/inbounds"
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
          queryParameter.getTo(),
          "to",
          URLParameter.form,
          CollectionStringToCommaSerializer.getInstance(),
          localVarQueryParams,
          true);

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
   * Retrieve inbound message This operation retrieves a specific inbound message with the provided
   * inbound ID.
   *
   * @param inboundId The inbound ID found when listing inbound messages. (required)
   * @return InboundMessage
   * @throws ApiException if fails to make API call
   */
  public InboundMessage get(String inboundId) throws ApiException {

    LOGGER.finest("[get]" + " " + "inboundId: " + inboundId);

    HttpRequest httpRequest = getRequestBuilder(inboundId);
    HttpResponse response =
        httpClient.invokeAPI(
            this.serverConfiguration, this.authManagersByOasSecuritySchemes, httpRequest);

    if (HttpStatus.isSuccessfulStatus(response.getCode())) {
      TypeReference<InboundMessage> localVarReturnType = new TypeReference<InboundMessage>() {};
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

  private HttpRequest getRequestBuilder(String inboundId) throws ApiException {
    // verify the required parameter 'this.servicePlanId' is set
    if (this.servicePlanId == null) {
      throw new ApiException(
          400, "Missing the required parameter 'this.servicePlanId' when calling get");
    }
    // verify the required parameter 'inboundId' is set
    if (inboundId == null) {
      throw new ApiException(400, "Missing the required parameter 'inboundId' when calling get");
    }

    String localVarPath =
        "/xms/v1/{service_plan_id}/inbounds/{inbound_id}"
            .replaceAll(
                "\\{" + "service_plan_id" + "\\}",
                URLPathUtils.encodePathSegment(this.servicePlanId.toString()))
            .replaceAll(
                "\\{" + "inbound_id" + "\\}", URLPathUtils.encodePathSegment(inboundId.toString()));

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
}
