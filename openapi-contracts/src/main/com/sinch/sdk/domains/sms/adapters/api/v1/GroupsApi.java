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
import com.sinch.sdk.domains.sms.models.dto.v1.ApiGroupListDto;
import com.sinch.sdk.domains.sms.models.dto.v1.CreateGroupResponseDto;
import com.sinch.sdk.domains.sms.models.dto.v1.GroupObjectDto;
import com.sinch.sdk.domains.sms.models.dto.v1.ReplaceGroupRequestDto;
import com.sinch.sdk.domains.sms.models.dto.v1.UpdateGroupRequestDto;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class GroupsApi {

  private static final Logger LOGGER = Logger.getLogger(GroupsApi.class.getName());
  private HttpClient httpClient;
  private ServerConfiguration serverConfiguration;
  private Map<String, AuthManager> authManagersByOasSecuritySchemes;
  private HttpMapper mapper;

  public GroupsApi(
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
   * Create a group A group is a set of phone numbers (MSISDNs) that can be used as a target in the
   * &#x60;send_batch_msg&#x60; operation. An MSISDN can only occur once in a group and any attempts
   * to add a duplicate would be ignored but not rejected.
   *
   * @param servicePlanId Your service plan ID. You can find this on your
   *     [Dashboard](https://dashboard.sinch.com/sms/api/rest). (required)
   * @param groupObjectDto (optional)
   * @return CreateGroupResponseDto
   * @throws ApiException if fails to make API call
   */
  public CreateGroupResponseDto createGroup(String servicePlanId, GroupObjectDto groupObjectDto)
      throws ApiException {

    LOGGER.finest(
        "[createGroup]"
            + " "
            + "servicePlanId: "
            + servicePlanId
            + ", "
            + "groupObjectDto: "
            + groupObjectDto);

    HttpRequest httpRequest = createGroupRequestBuilder(servicePlanId, groupObjectDto);
    HttpResponse response =
        httpClient.invokeAPI(
            this.serverConfiguration, this.authManagersByOasSecuritySchemes, httpRequest);

    if (HttpStatus.isSuccessfulStatus(response.getCode())) {
      TypeReference<CreateGroupResponseDto> localVarReturnType =
          new TypeReference<CreateGroupResponseDto>() {};
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

  private HttpRequest createGroupRequestBuilder(String servicePlanId, GroupObjectDto groupObjectDto)
      throws ApiException {
    // verify the required parameter 'servicePlanId' is set
    if (servicePlanId == null) {
      throw new ApiException(
          400, "Missing the required parameter 'servicePlanId' when calling createGroup");
    }

    String localVarPath =
        "/xms/v1/{service_plan_id}/groups"
            .replaceAll(
                "\\{" + "service_plan_id" + "\\}",
                URLPathUtils.encodePathSegment(servicePlanId.toString()));

    List<URLParameter> localVarQueryParams = new ArrayList<>();

    Map<String, String> localVarHeaderParams = new HashMap<>();

    final Collection<String> localVarAccepts = Arrays.asList("application/json");

    final Collection<String> localVarContentTypes = Arrays.asList("application/json");

    final Collection<String> localVarAuthNames = Arrays.asList("BearerAuth");
    final String serializedBody = mapper.serialize(localVarContentTypes, groupObjectDto);

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
   * Delete a group This operation deletes the group with the provided group ID.
   *
   * @param servicePlanId Your service plan ID. You can find this on your
   *     [Dashboard](https://dashboard.sinch.com/sms/api/rest). (required)
   * @param groupId ID of a group that you are interested in getting. (required)
   * @throws ApiException if fails to make API call
   */
  public void deleteGroup(String servicePlanId, String groupId) throws ApiException {

    LOGGER.finest(
        "[deleteGroup]" + " " + "servicePlanId: " + servicePlanId + ", " + "groupId: " + groupId);

    HttpRequest httpRequest = deleteGroupRequestBuilder(servicePlanId, groupId);
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

  private HttpRequest deleteGroupRequestBuilder(String servicePlanId, String groupId)
      throws ApiException {
    // verify the required parameter 'servicePlanId' is set
    if (servicePlanId == null) {
      throw new ApiException(
          400, "Missing the required parameter 'servicePlanId' when calling deleteGroup");
    }
    // verify the required parameter 'groupId' is set
    if (groupId == null) {
      throw new ApiException(
          400, "Missing the required parameter 'groupId' when calling deleteGroup");
    }

    String localVarPath =
        "/xms/v1/{service_plan_id}/groups/{group_id}"
            .replaceAll(
                "\\{" + "service_plan_id" + "\\}",
                URLPathUtils.encodePathSegment(servicePlanId.toString()))
            .replaceAll(
                "\\{" + "group_id" + "\\}", URLPathUtils.encodePathSegment(groupId.toString()));

    List<URLParameter> localVarQueryParams = new ArrayList<>();

    Map<String, String> localVarHeaderParams = new HashMap<>();

    final Collection<String> localVarAccepts = Arrays.asList();

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
   * Get phone numbers for a group This operation retrieves the members of the group with the
   * provided group ID.
   *
   * @param servicePlanId Your service plan ID. You can find this on your
   *     [Dashboard](https://dashboard.sinch.com/sms/api/rest). (required)
   * @param groupId ID of a group that you are interested in getting. (required)
   * @return List&lt;String&gt;
   * @throws ApiException if fails to make API call
   */
  public List<String> getMembers(String servicePlanId, String groupId) throws ApiException {

    LOGGER.finest(
        "[getMembers]" + " " + "servicePlanId: " + servicePlanId + ", " + "groupId: " + groupId);

    HttpRequest httpRequest = getMembersRequestBuilder(servicePlanId, groupId);
    HttpResponse response =
        httpClient.invokeAPI(
            this.serverConfiguration, this.authManagersByOasSecuritySchemes, httpRequest);

    if (HttpStatus.isSuccessfulStatus(response.getCode())) {
      TypeReference<List<String>> localVarReturnType = new TypeReference<List<String>>() {};
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

  private HttpRequest getMembersRequestBuilder(String servicePlanId, String groupId)
      throws ApiException {
    // verify the required parameter 'servicePlanId' is set
    if (servicePlanId == null) {
      throw new ApiException(
          400, "Missing the required parameter 'servicePlanId' when calling getMembers");
    }
    // verify the required parameter 'groupId' is set
    if (groupId == null) {
      throw new ApiException(
          400, "Missing the required parameter 'groupId' when calling getMembers");
    }

    String localVarPath =
        "/xms/v1/{service_plan_id}/groups/{group_id}/members"
            .replaceAll(
                "\\{" + "service_plan_id" + "\\}",
                URLPathUtils.encodePathSegment(servicePlanId.toString()))
            .replaceAll(
                "\\{" + "group_id" + "\\}", URLPathUtils.encodePathSegment(groupId.toString()));

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
   * List Groups With the list operation you can list all groups that you have created. This
   * operation supports pagination. Groups are returned in reverse chronological order.
   *
   * @param servicePlanId Your service plan ID. You can find this on your
   *     [Dashboard](https://dashboard.sinch.com/sms/api/rest). (required)
   * @param page The page number starting from 0. (optional, default to 0)
   * @param pageSize Determines the size of a page. (optional, default to 30)
   * @return ApiGroupListDto
   * @throws ApiException if fails to make API call
   */
  public ApiGroupListDto listGroups(String servicePlanId, Integer page, Integer pageSize)
      throws ApiException {

    LOGGER.finest(
        "[listGroups]"
            + " "
            + "servicePlanId: "
            + servicePlanId
            + ", "
            + "page: "
            + page
            + ", "
            + "pageSize: "
            + pageSize);

    HttpRequest httpRequest = listGroupsRequestBuilder(servicePlanId, page, pageSize);
    HttpResponse response =
        httpClient.invokeAPI(
            this.serverConfiguration, this.authManagersByOasSecuritySchemes, httpRequest);

    if (HttpStatus.isSuccessfulStatus(response.getCode())) {
      TypeReference<ApiGroupListDto> localVarReturnType = new TypeReference<ApiGroupListDto>() {};
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

  private HttpRequest listGroupsRequestBuilder(String servicePlanId, Integer page, Integer pageSize)
      throws ApiException {
    // verify the required parameter 'servicePlanId' is set
    if (servicePlanId == null) {
      throw new ApiException(
          400, "Missing the required parameter 'servicePlanId' when calling listGroups");
    }

    String localVarPath =
        "/xms/v1/{service_plan_id}/groups"
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
   * Replace a group The replace operation will replace all parameters, including members, of an
   * existing group with new values. Replacing a group targeted by a batch message scheduled in the
   * future is allowed and changes will be reflected when the batch is sent.
   *
   * @param servicePlanId Your service plan ID. You can find this on your
   *     [Dashboard](https://dashboard.sinch.com/sms/api/rest). (required)
   * @param groupId ID of a group that you are interested in getting. (required)
   * @param replaceGroupRequestDto (optional)
   * @return CreateGroupResponseDto
   * @throws ApiException if fails to make API call
   */
  public CreateGroupResponseDto replaceGroup(
      String servicePlanId, String groupId, ReplaceGroupRequestDto replaceGroupRequestDto)
      throws ApiException {

    LOGGER.finest(
        "[replaceGroup]"
            + " "
            + "servicePlanId: "
            + servicePlanId
            + ", "
            + "groupId: "
            + groupId
            + ", "
            + "replaceGroupRequestDto: "
            + replaceGroupRequestDto);

    HttpRequest httpRequest =
        replaceGroupRequestBuilder(servicePlanId, groupId, replaceGroupRequestDto);
    HttpResponse response =
        httpClient.invokeAPI(
            this.serverConfiguration, this.authManagersByOasSecuritySchemes, httpRequest);

    if (HttpStatus.isSuccessfulStatus(response.getCode())) {
      TypeReference<CreateGroupResponseDto> localVarReturnType =
          new TypeReference<CreateGroupResponseDto>() {};
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

  private HttpRequest replaceGroupRequestBuilder(
      String servicePlanId, String groupId, ReplaceGroupRequestDto replaceGroupRequestDto)
      throws ApiException {
    // verify the required parameter 'servicePlanId' is set
    if (servicePlanId == null) {
      throw new ApiException(
          400, "Missing the required parameter 'servicePlanId' when calling replaceGroup");
    }
    // verify the required parameter 'groupId' is set
    if (groupId == null) {
      throw new ApiException(
          400, "Missing the required parameter 'groupId' when calling replaceGroup");
    }

    String localVarPath =
        "/xms/v1/{service_plan_id}/groups/{group_id}"
            .replaceAll(
                "\\{" + "service_plan_id" + "\\}",
                URLPathUtils.encodePathSegment(servicePlanId.toString()))
            .replaceAll(
                "\\{" + "group_id" + "\\}", URLPathUtils.encodePathSegment(groupId.toString()));

    List<URLParameter> localVarQueryParams = new ArrayList<>();

    Map<String, String> localVarHeaderParams = new HashMap<>();

    final Collection<String> localVarAccepts = Arrays.asList("application/json");

    final Collection<String> localVarContentTypes = Arrays.asList("application/json");

    final Collection<String> localVarAuthNames = Arrays.asList("BearerAuth");
    final String serializedBody = mapper.serialize(localVarContentTypes, replaceGroupRequestDto);

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
   * Retrieve a group This operation retrieves a specific group with the provided group ID.
   *
   * @param servicePlanId Your service plan ID. You can find this on your
   *     [Dashboard](https://dashboard.sinch.com/sms/api/rest). (required)
   * @param groupId ID of a group that you are interested in getting. (required)
   * @return CreateGroupResponseDto
   * @throws ApiException if fails to make API call
   */
  public CreateGroupResponseDto retrieveGroup(String servicePlanId, String groupId)
      throws ApiException {

    LOGGER.finest(
        "[retrieveGroup]" + " " + "servicePlanId: " + servicePlanId + ", " + "groupId: " + groupId);

    HttpRequest httpRequest = retrieveGroupRequestBuilder(servicePlanId, groupId);
    HttpResponse response =
        httpClient.invokeAPI(
            this.serverConfiguration, this.authManagersByOasSecuritySchemes, httpRequest);

    if (HttpStatus.isSuccessfulStatus(response.getCode())) {
      TypeReference<CreateGroupResponseDto> localVarReturnType =
          new TypeReference<CreateGroupResponseDto>() {};
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

  private HttpRequest retrieveGroupRequestBuilder(String servicePlanId, String groupId)
      throws ApiException {
    // verify the required parameter 'servicePlanId' is set
    if (servicePlanId == null) {
      throw new ApiException(
          400, "Missing the required parameter 'servicePlanId' when calling retrieveGroup");
    }
    // verify the required parameter 'groupId' is set
    if (groupId == null) {
      throw new ApiException(
          400, "Missing the required parameter 'groupId' when calling retrieveGroup");
    }

    String localVarPath =
        "/xms/v1/{service_plan_id}/groups/{group_id}"
            .replaceAll(
                "\\{" + "service_plan_id" + "\\}",
                URLPathUtils.encodePathSegment(servicePlanId.toString()))
            .replaceAll(
                "\\{" + "group_id" + "\\}", URLPathUtils.encodePathSegment(groupId.toString()));

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
   * Update a group With the update group operation, you can add and remove members in an existing
   * group as well as rename the group. This method encompasses a few ways to update a group: 1. By
   * using &#x60;add&#x60; and &#x60;remove&#x60; arrays containing phone numbers, you control the
   * group movements. Any list of valid numbers in E.164 format can be added. 2. By using the
   * &#x60;auto_update&#x60; object, your customer can add or remove themselves from groups. 3. You
   * can also add or remove other groups into this group with &#x60;add_from_group&#x60; and
   * &#x60;remove_from_group&#x60;. #### Other group update info - The request will not be rejected
   * for duplicate adds or unknown removes. - The additions will be done before the deletions. If an
   * phone number is on both lists, it will not be apart of the resulting group. - Updating a group
   * targeted by a batch message scheduled in the future is allowed. Changes will be reflected when
   * the batch is sent.
   *
   * @param servicePlanId Your service plan ID. You can find this on your
   *     [Dashboard](https://dashboard.sinch.com/sms/api/rest). (required)
   * @param groupId ID of a group that you are interested in getting. (required)
   * @param updateGroupRequestDto (optional)
   * @return CreateGroupResponseDto
   * @throws ApiException if fails to make API call
   */
  public CreateGroupResponseDto updateGroup(
      String servicePlanId, String groupId, UpdateGroupRequestDto updateGroupRequestDto)
      throws ApiException {

    LOGGER.finest(
        "[updateGroup]"
            + " "
            + "servicePlanId: "
            + servicePlanId
            + ", "
            + "groupId: "
            + groupId
            + ", "
            + "updateGroupRequestDto: "
            + updateGroupRequestDto);

    HttpRequest httpRequest =
        updateGroupRequestBuilder(servicePlanId, groupId, updateGroupRequestDto);
    HttpResponse response =
        httpClient.invokeAPI(
            this.serverConfiguration, this.authManagersByOasSecuritySchemes, httpRequest);

    if (HttpStatus.isSuccessfulStatus(response.getCode())) {
      TypeReference<CreateGroupResponseDto> localVarReturnType =
          new TypeReference<CreateGroupResponseDto>() {};
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

  private HttpRequest updateGroupRequestBuilder(
      String servicePlanId, String groupId, UpdateGroupRequestDto updateGroupRequestDto)
      throws ApiException {
    // verify the required parameter 'servicePlanId' is set
    if (servicePlanId == null) {
      throw new ApiException(
          400, "Missing the required parameter 'servicePlanId' when calling updateGroup");
    }
    // verify the required parameter 'groupId' is set
    if (groupId == null) {
      throw new ApiException(
          400, "Missing the required parameter 'groupId' when calling updateGroup");
    }

    String localVarPath =
        "/xms/v1/{service_plan_id}/groups/{group_id}"
            .replaceAll(
                "\\{" + "service_plan_id" + "\\}",
                URLPathUtils.encodePathSegment(servicePlanId.toString()))
            .replaceAll(
                "\\{" + "group_id" + "\\}", URLPathUtils.encodePathSegment(groupId.toString()));

    List<URLParameter> localVarQueryParams = new ArrayList<>();

    Map<String, String> localVarHeaderParams = new HashMap<>();

    final Collection<String> localVarAccepts = Arrays.asList("application/json");

    final Collection<String> localVarContentTypes = Arrays.asList("application/json");

    final Collection<String> localVarAuthNames = Arrays.asList("BearerAuth");
    final String serializedBody = mapper.serialize(localVarContentTypes, updateGroupRequestDto);

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
