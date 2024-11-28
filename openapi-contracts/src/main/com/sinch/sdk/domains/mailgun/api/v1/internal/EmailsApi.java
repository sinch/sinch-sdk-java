/*
 * Mailgun API
 *
 * OpenAPI document version: 0.0.0
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.mailgun.api.v1.internal;

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
import com.sinch.sdk.domains.mailgun.models.v1.emails.request.SendEmailRequest;
import com.sinch.sdk.domains.mailgun.models.v1.emails.request.SendMimeEmailRequest;
import com.sinch.sdk.domains.mailgun.models.v1.emails.response.GetStoredEmailResponse;
import com.sinch.sdk.domains.mailgun.models.v1.emails.response.SendEmailResponse;
import com.sinch.sdk.domains.mailgun.models.v1.emails.response.SendingQueuesStatusResponse;
import com.sinch.sdk.domains.mailgun.models.v1.response.GenericResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class EmailsApi {

  private static final Logger LOGGER = Logger.getLogger(EmailsApi.class.getName());
  private HttpClient httpClient;
  private ServerConfiguration serverConfiguration;
  private Map<String, AuthManager> authManagersByOasSecuritySchemes;
  private HttpMapper mapper;

  private final Collection<ServerConfiguration> storageServers;

  public EmailsApi(
      HttpClient httpClient,
      ServerConfiguration serverConfiguration,
      Map<String, AuthManager> authManagersByOasSecuritySchemes,
      HttpMapper mapper,
      Collection<ServerConfiguration> storageServers) {
    this.httpClient = httpClient;
    this.serverConfiguration = serverConfiguration;
    this.authManagersByOasSecuritySchemes = authManagersByOasSecuritySchemes;
    this.mapper = mapper;
    this.storageServers = storageServers;
  }

  /**
   * Retrieve a stored email Event(s) created from sending an email with Mailgun will contain a
   * &#x60;storage.key&#x60; to use to retrieve the email.
   *
   * @param domainName Domain name that was used to send the email (required)
   * @param storageKey Storage key from the emails associated events (required)
   * @return GetStoredEmailResponse
   * @throws ApiException if fails to make API call
   */
  public GetStoredEmailResponse getStoredEmail(String domainName, String storageKey)
      throws ApiException {

    LOGGER.finest(
        "[getStoredEmail]"
            + " "
            + "domainName: "
            + domainName
            + ", "
            + "storageKey: "
            + storageKey);

    HttpRequest httpRequest = getStoredEmailRequestBuilder(domainName, storageKey);
    HttpResponse response =
        httpClient.invokeAPI(
            this.serverConfiguration, this.authManagersByOasSecuritySchemes, httpRequest);

    if (HttpStatus.isSuccessfulStatus(response.getCode())) {
      TypeReference<GetStoredEmailResponse> localVarReturnType =
          new TypeReference<GetStoredEmailResponse>() {};
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

  private HttpRequest getStoredEmailRequestBuilder(String domainName, String storageKey)
      throws ApiException {
    // verify the required parameter 'domainName' is set
    if (domainName == null) {
      throw new ApiException(
          400, "Missing the required parameter 'domainName' when calling getStoredEmail");
    }
    // verify the required parameter 'storageKey' is set
    if (storageKey == null) {
      throw new ApiException(
          400, "Missing the required parameter 'storageKey' when calling getStoredEmail");
    }

    String localVarPath =
        "/v3/domains/{domain_name}/messages/{storage_key}"
            .replaceAll(
                "\\{" + "domain_name" + "\\}",
                URLPathUtils.encodePathSegment(domainName.toString()))
            .replaceAll(
                "\\{" + "storage_key" + "\\}",
                URLPathUtils.encodePathSegment(storageKey.toString()));

    List<URLParameter> localVarQueryParams = new ArrayList<>();

    Map<String, String> localVarHeaderParams = new HashMap<>();

    final Collection<String> localVarAccepts = Arrays.asList("application/json");

    final Collection<String> localVarContentTypes = Arrays.asList();

    final Collection<String> localVarAuthNames = Arrays.asList("basicAuth");
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
   * Delete scheduled and undelivered mail Deletes all scheduled and undelivered mail from the
   * domain queue. This endpoint must be called on the storage API host and in the domain&#39;s
   * region. e.g. https://storage-us-east4.api.mailgun.net/v3/example.com/envelopes The storage
   * hosts are &#x60;storage-us-east4.api.mailgun.net&#x60;,
   * &#x60;storage-us-west1.api.mailgun.net&#x60;, and
   * &#x60;storage-europe-west1.api.mailgun.net&#x60;.
   *
   * @param domainName The name of the domain you want to delete envelope from (required)
   * @param serverConf (required)
   * @return GenericResponse
   * @throws ApiException if fails to make API call
   */
  private GenericResponse purgeQueue(String domainName, ServerConfiguration serverConf)
      throws ApiException {

    LOGGER.finest(
        "[purgeQueue]" + " " + "domainName: " + domainName + ", " + "serverConf: " + serverConf);

    HttpRequest httpRequest = purgeQueueRequestBuilder(domainName, serverConf);
    HttpResponse response =
        httpClient.invokeAPI(serverConf, this.authManagersByOasSecuritySchemes, httpRequest);

    if (HttpStatus.isSuccessfulStatus(response.getCode())) {
      TypeReference<GenericResponse> localVarReturnType = new TypeReference<GenericResponse>() {};
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

  private HttpRequest purgeQueueRequestBuilder(String domainName, ServerConfiguration serverConf)
      throws ApiException {
    // verify the required parameter 'domainName' is set
    if (domainName == null) {
      throw new ApiException(
          400, "Missing the required parameter 'domainName' when calling purgeQueue");
    }
    // verify the required parameter 'serverConf' is set
    if (serverConf == null) {
      throw new ApiException(
          400, "Missing the required parameter 'serverConf' when calling purgeQueue");
    }

    String localVarPath =
        "/v3/{domain_name}/envelopes"
            .replaceAll(
                "\\{" + "domain_name" + "\\}",
                URLPathUtils.encodePathSegment(domainName.toString()));

    List<URLParameter> localVarQueryParams = new ArrayList<>();

    Map<String, String> localVarHeaderParams = new HashMap<>();

    final Collection<String> localVarAccepts = Arrays.asList("application/json");

    final Collection<String> localVarContentTypes = Arrays.asList();

    final Collection<String> localVarAuthNames = Arrays.asList("basicAuth");
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
   * Get messages queue status Provides default and scheduled message queue information.
   *
   * @param name The name of the domain you want get sending queues from (required)
   * @return SendingQueuesStatusResponse
   * @throws ApiException if fails to make API call
   */
  public SendingQueuesStatusResponse getSendingQueuesStatus(String name) throws ApiException {

    LOGGER.finest("[getSendingQueuesStatus]" + " " + "name: " + name);

    HttpRequest httpRequest = getSendingQueuesStatusRequestBuilder(name);
    HttpResponse response =
        httpClient.invokeAPI(
            this.serverConfiguration, this.authManagersByOasSecuritySchemes, httpRequest);

    if (HttpStatus.isSuccessfulStatus(response.getCode())) {
      TypeReference<SendingQueuesStatusResponse> localVarReturnType =
          new TypeReference<SendingQueuesStatusResponse>() {};
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

  private HttpRequest getSendingQueuesStatusRequestBuilder(String name) throws ApiException {
    // verify the required parameter 'name' is set
    if (name == null) {
      throw new ApiException(
          400, "Missing the required parameter 'name' when calling getSendingQueuesStatus");
    }

    String localVarPath =
        "/v3/domains/{name}/sending_queues"
            .replaceAll("\\{" + "name" + "\\}", URLPathUtils.encodePathSegment(name.toString()));

    List<URLParameter> localVarQueryParams = new ArrayList<>();

    Map<String, String> localVarHeaderParams = new HashMap<>();

    final Collection<String> localVarAccepts = Arrays.asList("application/json");

    final Collection<String> localVarContentTypes = Arrays.asList();

    final Collection<String> localVarAuthNames = Arrays.asList("basicAuth");
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
   * Send an email Pass the components of the messages such as To, From, Subject, HTML and text
   * parts, attachments, etc. Mailgun will build a MIME representation of the message and send it.
   * Note: In order to send you must provide one of the following parameters: &#39;text&#39;,
   * &#39;html&#39;, &#39;amp-html&#39; or &#39;template&#39;
   *
   * @param domainName Domain name used to send the message (required)
   * @param requestParameters Request parameters
   * @return SendEmailResponse
   * @throws ApiException if fails to make API call
   */
  public SendEmailResponse sendEmail(String domainName, SendEmailRequest requestParameters)
      throws ApiException {

    LOGGER.finest(
        "[sendEmail] " + "domainName: " + domainName + ", " + " request:" + requestParameters);
    HttpRequest httpRequest = sendEmailRequestBuilder(domainName, requestParameters);
    HttpResponse response =
        httpClient.invokeAPI(
            this.serverConfiguration, this.authManagersByOasSecuritySchemes, httpRequest);

    if (HttpStatus.isSuccessfulStatus(response.getCode())) {
      TypeReference<SendEmailResponse> localVarReturnType =
          new TypeReference<SendEmailResponse>() {};
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

  private HttpRequest sendEmailRequestBuilder(String domainName, SendEmailRequest requestParameters)
      throws ApiException {
    // verify the required parameter 'domainName' is set
    if (domainName == null) {
      throw new ApiException(
          400, "Missing the required parameter 'domainName' when calling sendEmail");
    }

    String localVarPath =
        "/v3/{domain_name}/messages"
            .replaceAll(
                "\\{" + "domain_name" + "\\}",
                URLPathUtils.encodePathSegment(domainName.toString()));

    List<URLParameter> localVarQueryParams = new ArrayList<>();

    Map<String, String> localVarHeaderParams = new HashMap<>();

    final Collection<String> localVarAccepts = Arrays.asList("application/json");
    final Collection<String> localVarContentTypes = Arrays.asList("multipart/form-data");
    final Collection<String> localVarAuthNames = Arrays.asList("basicAuth");
    final Map<String, Object> localFormParams =
        mapper.serializeFormParameters(localVarContentTypes, requestParameters);

    return new HttpRequest(
        localVarPath,
        HttpMethod.POST,
        localVarQueryParams,
        localFormParams,
        localVarHeaderParams,
        localVarAccepts,
        localVarContentTypes,
        localVarAuthNames);
  }

  /**
   * Send an email in MIME format Build a MIME string yourself using a MIME library for your
   * programming language and submit it to Mailgun.
   *
   * @param domainName Domain name used to send the message (required)
   * @param requestParameters Request parameters
   * @return SendEmailResponse
   * @throws ApiException if fails to make API call
   */
  public SendEmailResponse sendMimeEmail(String domainName, SendMimeEmailRequest requestParameters)
      throws ApiException {

    LOGGER.finest(
        "[sendMimeEmail] " + "domainName: " + domainName + ", " + " request:" + requestParameters);
    HttpRequest httpRequest = sendMimeEmailRequestBuilder(domainName, requestParameters);
    HttpResponse response =
        httpClient.invokeAPI(
            this.serverConfiguration, this.authManagersByOasSecuritySchemes, httpRequest);

    if (HttpStatus.isSuccessfulStatus(response.getCode())) {
      TypeReference<SendEmailResponse> localVarReturnType =
          new TypeReference<SendEmailResponse>() {};
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

  private HttpRequest sendMimeEmailRequestBuilder(
      String domainName, SendMimeEmailRequest requestParameters) throws ApiException {
    // verify the required parameter 'domainName' is set
    if (domainName == null) {
      throw new ApiException(
          400, "Missing the required parameter 'domainName' when calling sendMimeEmail");
    }

    String localVarPath =
        "/v3/{domain_name}/messages.mime"
            .replaceAll(
                "\\{" + "domain_name" + "\\}",
                URLPathUtils.encodePathSegment(domainName.toString()));

    List<URLParameter> localVarQueryParams = new ArrayList<>();

    Map<String, String> localVarHeaderParams = new HashMap<>();

    final Collection<String> localVarAccepts = Arrays.asList("application/json");
    final Collection<String> localVarContentTypes = Arrays.asList("multipart/form-data");
    final Collection<String> localVarAuthNames = Arrays.asList("basicAuth");
    final Map<String, Object> localFormParams =
        mapper.serializeFormParameters(localVarContentTypes, requestParameters);

    return new HttpRequest(
        localVarPath,
        HttpMethod.POST,
        localVarQueryParams,
        localFormParams,
        localVarHeaderParams,
        localVarAccepts,
        localVarContentTypes,
        localVarAuthNames);
  }

  private String handleError(
      String domainName, ServerConfiguration serverConfiguration, Throwable throwable) {
    String message =
        String.format(
            "Exception for '%s' domain onto '%s': %s",
            domainName, serverConfiguration.getUrl(), throwable.getMessage());
    LOGGER.finest(message);
    return message;
  }

  /**
   * Delete scheduled and undelivered mail Deletes all scheduled and undelivered mail from the
   * domain queue.
   *
   * @param domainName The name of the domain you want to delete envelope from (required)
   * @throws ApiException if fails to make API call
   */
  public void purgeDomainQueues(String domainName) throws ApiException {

    LOGGER.finest("[purgeDomainQueues]" + " " + "domainName: " + domainName);
    List<CompletableFuture<String>> purgeDomainQueuesFutures =
        storageServers.stream()
            .map(
                server -> {
                  CompletableFuture<GenericResponse> future =
                      CompletableFuture.supplyAsync(() -> purgeQueue(domainName, server));
                  return future
                      .thenApplyAsync(response -> (String) null)
                      .exceptionally(e -> handleError(domainName, server, e));
                })
            .collect(Collectors.toList());

    Map<Boolean, List<String>> result =
        purgeDomainQueuesFutures.stream()
            .map(CompletableFuture::join)
            .collect(Collectors.partitioningBy(Objects::nonNull));

    // all requests were executed fine: no errors
    if (result.containsKey(Boolean.FALSE)
        && result.get(Boolean.FALSE).size() == storageServers.size()) {
      return;
    }

    StringBuilder sb = new StringBuilder("Errors during domain queues purge:");
    result.get(Boolean.TRUE).forEach(error -> sb.append("\n - ").append(error));
    throw new ApiException(sb.toString());
  }
}