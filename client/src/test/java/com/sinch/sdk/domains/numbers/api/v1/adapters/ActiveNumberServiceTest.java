package com.sinch.sdk.domains.numbers.api.v1.adapters;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.when;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.auth.adapters.OAuthManager;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.AuthManagersTest.AuthManagersMatcher;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpContentType;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.core.http.HttpMethod;
import com.sinch.sdk.core.http.HttpRequest;
import com.sinch.sdk.core.http.HttpRequestTest.HttpRequestMatcher;
import com.sinch.sdk.core.http.HttpResponse;
import com.sinch.sdk.core.http.URLParameter;
import com.sinch.sdk.core.http.URLParameter.STYLE;
import com.sinch.sdk.core.http.URLPathUtils;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.core.models.ServerConfigurationTest.ServerConfigurationMatcher;
import com.sinch.sdk.core.models.pagination.Page;
import com.sinch.sdk.core.models.pagination.PageNavigator;
import com.sinch.sdk.domains.numbers.api.v1.NumbersService;
import com.sinch.sdk.domains.numbers.models.v1.ActiveNumber;
import com.sinch.sdk.domains.numbers.models.v1.ActiveNumberDtoTest;
import com.sinch.sdk.domains.numbers.models.v1.Capability;
import com.sinch.sdk.domains.numbers.models.v1.EmergencyAddress;
import com.sinch.sdk.domains.numbers.models.v1.EmergencyAddressDtoTest;
import com.sinch.sdk.domains.numbers.models.v1.NumberType;
import com.sinch.sdk.domains.numbers.models.v1.SmsConfiguration;
import com.sinch.sdk.domains.numbers.models.v1.VoiceConfiguration;
import com.sinch.sdk.domains.numbers.models.v1.VoiceConfigurationRTC;
import com.sinch.sdk.domains.numbers.models.v1.request.ActiveNumberUpdateRequest;
import com.sinch.sdk.domains.numbers.models.v1.request.ActiveNumbersListQueryParameters;
import com.sinch.sdk.domains.numbers.models.v1.request.EmergencyAddressRequestDtoTest;
import com.sinch.sdk.domains.numbers.models.v1.request.OrderBy;
import com.sinch.sdk.domains.numbers.models.v1.request.SearchPosition;
import com.sinch.sdk.domains.numbers.models.v1.response.ActiveNumbersListResponse;
import com.sinch.sdk.domains.numbers.models.v1.response.ValidateAddressResponse;
import com.sinch.sdk.domains.numbers.models.v1.response.ValidateAddressResponseDtoTest;
import com.sinch.sdk.models.NumbersContext;
import com.sinch.sdk.models.UnifiedCredentials;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

@TestWithResources
class ActiveNumberServiceTest extends NumbersBaseTest {

  @GivenTextResource("/domains/numbers/v1/active/active-numbers-list-light.json")
  String jsonActiveNumberListLightResponse;

  @GivenTextResource("/domains/numbers/v1/active/active-numbers-list.json")
  String jsonActiveNumberListResponse;

  @GivenTextResource("/domains/numbers/v1/active/active-numbers-get.json")
  String jsonActiveGetResponse;

  @GivenTextResource("/domains/numbers/v1/response/validate-address-response.json")
  String jsonValidateAddressResponse;

  @GivenTextResource("/domains/numbers/v1/emergency-address.json")
  String jsonEmergencyAddress;

  @Mock HttpClient httpClient;
  Supplier<HttpClient> httpClientSupplier = () -> httpClient;

  UnifiedCredentials credentials =
      UnifiedCredentials.builder()
          .setProjectId(URI_UUID)
          .setKeyId("keyid")
          .setKeySecret("keysecret")
          .build();
  ServerConfiguration oAuthServer = new ServerConfiguration("https://oauth.foo.url");

  Map<String, AuthManager> authManagers =
      Stream.of(
              new Object[][] {
                {
                  "OAuth2.0",
                  new OAuthManager(
                      credentials, oAuthServer, HttpMapper.getInstance(), httpClientSupplier)
                },
              })
          .collect(Collectors.toMap(data -> (String) data[0], data -> (AuthManager) data[1]));

  ServerConfiguration serverConfiguration = new ServerConfiguration(NUMBERS_URL);
  NumbersContext context = NumbersContext.builder().setNumbersUrl(NUMBERS_URL).build();

  NumbersService service;

  static final String NUMBERS_URL = "https://numbers.url";

  static final String URI_UUID = "uriUUID";
  static final Collection<String> NUMBERS_AUTH_NAMES = Arrays.asList("Basic", "OAuth2.0");

  @BeforeEach
  public void initMocks() {
    service =
        new com.sinch.sdk.domains.numbers.api.v1.adapters.NumbersService(
            credentials, context, oAuthServer, httpClientSupplier);
  }

  @Test
  void listWithRequiredParameters() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            "/v1/projects/" + URLPathUtils.encodePathSegment(URI_UUID) + "/activeNumbers",
            HttpMethod.GET,
            Arrays.asList(
                new URLParameter("regionCode", "region", STYLE.FORM, true),
                new URLParameter("type", NumberType.MOBILE, STYLE.FORM, true)),
            (String) null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            NUMBERS_AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(
            200, null, Collections.emptyMap(), jsonActiveNumberListLightResponse.getBytes());

    when(httpClient.invokeAPI(
            argThat(new ServerConfigurationMatcher(serverConfiguration)),
            argThat(new AuthManagersMatcher(authManagers)),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    ActiveNumberServiceImpl lowService =
        (ActiveNumberServiceImpl)
            (((com.sinch.sdk.domains.numbers.api.v1.adapters.NumbersService) service)
                .active()
                .getService());

    ActiveNumbersListResponse expected =
        new ActiveNumbersListResponse(
            lowService,
            new Page<>(
                null,
                ActiveNumberDtoTest.activeNumberListLight.getActiveNumbers(),
                new PageNavigator<>(null)));

    ActiveNumbersListResponse response =
        service.list(
            ActiveNumbersListQueryParameters.builder()
                .setRegionCode("region")
                .setType(NumberType.MOBILE)
                .build());

    TestHelpers.recursiveEquals(response, expected);
  }

  @Test
  void listWithOptionalParameters() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            "/v1/projects/" + URLPathUtils.encodePathSegment(URI_UUID) + "/activeNumbers",
            HttpMethod.GET,
            Arrays.asList(
                new URLParameter("regionCode", "another region", STYLE.FORM, true),
                new URLParameter("numberPattern.pattern", "pattern value", STYLE.FORM, true),
                new URLParameter(
                    "numberPattern.searchPattern", SearchPosition.END, STYLE.FORM, true),
                new URLParameter("type", NumberType.TOLL_FREE, STYLE.FORM, true),
                new URLParameter("capability", Arrays.asList(Capability.VOICE), STYLE.FORM, true),
                new URLParameter("pageSize", 5, STYLE.FORM, true),
                new URLParameter("pageToken", "foo-req", STYLE.FORM, true),
                new URLParameter("orderBy", OrderBy.PHONE_NUMBER, STYLE.FORM, true)),
            (String) null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            NUMBERS_AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(
            200, null, Collections.emptyMap(), jsonActiveNumberListResponse.getBytes());

    when(httpClient.invokeAPI(
            argThat(new ServerConfigurationMatcher(serverConfiguration)),
            argThat(new AuthManagersMatcher(authManagers)),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    ActiveNumberServiceImpl lowService =
        (ActiveNumberServiceImpl)
            (((com.sinch.sdk.domains.numbers.api.v1.adapters.NumbersService) service)
                .active()
                .getService());

    ActiveNumbersListResponse expected =
        new ActiveNumbersListResponse(
            lowService,
            new Page<>(
                null,
                ActiveNumberDtoTest.activeNumberList.getActiveNumbers(),
                new PageNavigator<>(
                    new HttpRequest(
                        "/v1/projects/"
                            + URLPathUtils.encodePathSegment(URI_UUID)
                            + "/activeNumbers",
                        HttpMethod.GET,
                        Arrays.asList(
                            new URLParameter("regionCode", "another region", STYLE.FORM, true),
                            new URLParameter(
                                "numberPattern.pattern", "pattern value", STYLE.FORM, true),
                            new URLParameter(
                                "numberPattern.searchPattern",
                                SearchPosition.END,
                                STYLE.FORM,
                                true),
                            new URLParameter("type", NumberType.TOLL_FREE, STYLE.FORM, true),
                            new URLParameter(
                                "capability", Arrays.asList(Capability.VOICE), STYLE.FORM, true),
                            new URLParameter("pageSize", 5, STYLE.FORM, true),
                            new URLParameter("pageToken", "foo", STYLE.FORM, true),
                            new URLParameter("orderBy", OrderBy.PHONE_NUMBER, STYLE.FORM, true)),
                        (String) null,
                        Collections.emptyMap(),
                        Collections.singletonList(HttpContentType.APPLICATION_JSON),
                        Collections.emptyList(),
                        NUMBERS_AUTH_NAMES))));

    ActiveNumbersListResponse response =
        service.list(
            ActiveNumbersListQueryParameters.builder()
                .setRegionCode("another region")
                .setType(NumberType.TOLL_FREE)
                .setSearchPattern("pattern value")
                .setSearchPosition(SearchPosition.END)
                .setCapabilities(Arrays.asList(Capability.VOICE))
                .setPageSize(5)
                .setPageToken("foo-req")
                .setOrderBy(OrderBy.PHONE_NUMBER)
                .build());

    TestHelpers.recursiveEquals(response, expected);
  }

  @Test
  void get() throws ApiException {

    String phoneNumber = "+12345678";

    HttpRequest httpRequest =
        new HttpRequest(
            "/v1/projects/"
                + URLPathUtils.encodePathSegment(URI_UUID)
                + "/activeNumbers/"
                + URLPathUtils.encodePathSegment(phoneNumber),
            HttpMethod.GET,
            Collections.emptyList(),
            (String) null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            NUMBERS_AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), jsonActiveGetResponse.getBytes());

    when(httpClient.invokeAPI(
            argThat(new ServerConfigurationMatcher(serverConfiguration)),
            argThat(new AuthManagersMatcher(authManagers)),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    ActiveNumber response = service.get(phoneNumber);

    TestHelpers.recursiveEquals(response, ActiveNumberDtoTest.activeNumber);
  }

  @Test
  void release() throws ApiException {

    String phoneNumber = "+12345678";

    HttpRequest httpRequest =
        new HttpRequest(
            "/v1/projects/"
                + URLPathUtils.encodePathSegment(URI_UUID)
                + "/activeNumbers/"
                + URLPathUtils.encodePathSegment(phoneNumber)
                + ":release",
            HttpMethod.POST,
            Collections.emptyList(),
            (String) null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            NUMBERS_AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), jsonActiveGetResponse.getBytes());

    when(httpClient.invokeAPI(
            argThat(new ServerConfigurationMatcher(serverConfiguration)),
            argThat(new AuthManagersMatcher(authManagers)),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    ActiveNumber response = service.release(phoneNumber);

    TestHelpers.recursiveEquals(response, ActiveNumberDtoTest.activeNumber);
  }

  @Test
  void update() {
    String phoneNumber = "+12345678";

    SmsConfiguration smsConfiguration =
        SmsConfiguration.builder()
            .setServicePlanId("service plan id")
            .setCampaignId("campaign id")
            .build();

    VoiceConfiguration voiceConfiguration =
        VoiceConfigurationRTC.builder().setAppId("app id").build();

    ActiveNumberUpdateRequest parameters =
        ActiveNumberUpdateRequest.builder()
            .setDisplayName("my display name")
            .setSmsConfiguration(smsConfiguration)
            .setVoiceConfiguration(voiceConfiguration)
            .setCallbackUrl("foo callback")
            .build();

    HttpRequest httpRequest =
        new HttpRequest(
            "/v1/projects/"
                + URLPathUtils.encodePathSegment(URI_UUID)
                + "/activeNumbers/"
                + URLPathUtils.encodePathSegment(phoneNumber),
            HttpMethod.PATCH,
            Collections.emptyList(),
            HttpMapper.getInstance()
                .serialize(Collections.singletonList(HttpContentType.APPLICATION_JSON), parameters),
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            NUMBERS_AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), jsonActiveGetResponse.getBytes());

    when(httpClient.invokeAPI(
            argThat(new ServerConfigurationMatcher(serverConfiguration)),
            argThat(new AuthManagersMatcher(authManagers)),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    ActiveNumber response = service.update(phoneNumber, parameters);

    TestHelpers.recursiveEquals(response, ActiveNumberDtoTest.activeNumber);
  }

  @Test
  void validateEmergencyAddress() {
    String phoneNumber = "+12345678";

    HttpRequest httpRequest =
        new HttpRequest(
            "/v1/projects/"
                + URLPathUtils.encodePathSegment(URI_UUID)
                + "/activeNumbers/"
                + URLPathUtils.encodePathSegment(phoneNumber)
                + "/emergencyAddress:validate",
            HttpMethod.POST,
            Collections.emptyList(),
            HttpMapper.getInstance()
                .serialize(
                    Collections.singletonList(HttpContentType.APPLICATION_JSON),
                    EmergencyAddressRequestDtoTest.emergencyAddressRequest),
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            NUMBERS_AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), jsonValidateAddressResponse.getBytes());

    when(httpClient.invokeAPI(
            argThat(new ServerConfigurationMatcher(serverConfiguration)),
            argThat(new AuthManagersMatcher(authManagers)),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    ValidateAddressResponse response =
        service.validateEmergencyAddress(
            phoneNumber, EmergencyAddressRequestDtoTest.emergencyAddressRequest);

    TestHelpers.recursiveEquals(
        response, ValidateAddressResponseDtoTest.validateAddressResponseNearMatch);
  }

  @Test
  void provisionEmergencyAddress() {

    String phoneNumber = "+12345678";

    HttpRequest httpRequest =
        new HttpRequest(
            "/v1/projects/"
                + URLPathUtils.encodePathSegment(URI_UUID)
                + "/activeNumbers/"
                + URLPathUtils.encodePathSegment(phoneNumber)
                + "/emergencyAddress:provision",
            HttpMethod.POST,
            Collections.emptyList(),
            HttpMapper.getInstance()
                .serialize(
                    Collections.singletonList(HttpContentType.APPLICATION_JSON),
                    EmergencyAddressRequestDtoTest.emergencyAddressRequest),
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            NUMBERS_AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), jsonEmergencyAddress.getBytes());

    when(httpClient.invokeAPI(
            argThat(new ServerConfigurationMatcher(serverConfiguration)),
            argThat(new AuthManagersMatcher(authManagers)),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    EmergencyAddress response =
        service.provisionEmergencyAddress(
            phoneNumber, EmergencyAddressRequestDtoTest.emergencyAddressRequest);

    TestHelpers.recursiveEquals(response, EmergencyAddressDtoTest.emergencyAddress);
  }

  @Test
  void deprovisionEmergencyAddress() {

    String phoneNumber = "+12345678";

    HttpRequest httpRequest =
        new HttpRequest(
            "/v1/projects/"
                + URLPathUtils.encodePathSegment(URI_UUID)
                + "/activeNumbers/"
                + URLPathUtils.encodePathSegment(phoneNumber)
                + "/emergencyAddress:deprovision",
            HttpMethod.POST,
            Collections.emptyList(),
            (String) null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            NUMBERS_AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), jsonEmergencyAddress.getBytes());

    when(httpClient.invokeAPI(
            argThat(new ServerConfigurationMatcher(serverConfiguration)),
            argThat(new AuthManagersMatcher(authManagers)),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    service.deprovisionEmergencyAddress(phoneNumber);
  }

  @Test
  void getEmergencyAddress() {
    String phoneNumber = "+12345678";

    HttpRequest httpRequest =
        new HttpRequest(
            "/v1/projects/"
                + URLPathUtils.encodePathSegment(URI_UUID)
                + "/activeNumbers/"
                + URLPathUtils.encodePathSegment(phoneNumber)
                + "/emergencyAddress",
            HttpMethod.GET,
            Collections.emptyList(),
            (String) null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            NUMBERS_AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), jsonEmergencyAddress.getBytes());

    when(httpClient.invokeAPI(
            argThat(new ServerConfigurationMatcher(serverConfiguration)),
            argThat(new AuthManagersMatcher(authManagers)),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    EmergencyAddress response = service.getEmergencyAddress(phoneNumber);
    TestHelpers.recursiveEquals(response, EmergencyAddressDtoTest.emergencyAddress);
  }
}
