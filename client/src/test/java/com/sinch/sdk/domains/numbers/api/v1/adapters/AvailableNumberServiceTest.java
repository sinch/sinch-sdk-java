package com.sinch.sdk.domains.numbers.api.v1.adapters;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.when;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
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
import com.sinch.sdk.domains.numbers.api.v1.NumbersService;
import com.sinch.sdk.domains.numbers.models.v1.ActiveNumber;
import com.sinch.sdk.domains.numbers.models.v1.ActiveNumberDtoTest;
import com.sinch.sdk.domains.numbers.models.v1.AvailableNumberDtoTest;
import com.sinch.sdk.domains.numbers.models.v1.Capability;
import com.sinch.sdk.domains.numbers.models.v1.NumberType;
import com.sinch.sdk.domains.numbers.models.v1.SmsConfiguration;
import com.sinch.sdk.domains.numbers.models.v1.VoiceConfigurationRTC;
import com.sinch.sdk.domains.numbers.models.v1.request.AvailableNumberListRequest;
import com.sinch.sdk.domains.numbers.models.v1.request.AvailableNumberRentAnyRequest;
import com.sinch.sdk.domains.numbers.models.v1.request.AvailableNumberRentRequest;
import com.sinch.sdk.domains.numbers.models.v1.request.AvailableNumbersListQueryParameters;
import com.sinch.sdk.domains.numbers.models.v1.request.SearchPattern;
import com.sinch.sdk.domains.numbers.models.v1.request.SearchPosition;
import com.sinch.sdk.domains.numbers.models.v1.response.AvailableNumberListResponse;
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
class AvailableNumberServiceTest extends BaseTest {

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

  @GivenTextResource("/domains/numbers/v1/active/active-numbers-get.json")
  String jsonActiveNumber;

  @GivenTextResource("/domains/numbers/v1/available/available-numbers-list.json")
  String jsonAvailableListResponse;

  @BeforeEach
  public void initMocks() {
    service =
        new com.sinch.sdk.domains.numbers.api.v1.adapters.NumbersService(
            credentials, context, oAuthServer, httpClientSupplier);
  }

  @Test
  void searchForAvailableNumbersWithRequiredParametersDeprecated() throws ApiException {

    AvailableNumberListRequest parameters =
        AvailableNumberListRequest.builder()
            .setRegionCode("region")
            .setType(NumberType.MOBILE)
            .build();

    HttpRequest httpRequest =
        new HttpRequest(
            "/v1/projects/" + URLPathUtils.encodePathSegment(URI_UUID) + "/availableNumbers",
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
        new HttpResponse(200, null, Collections.emptyMap(), jsonAvailableListResponse.getBytes());

    when(httpClient.invokeAPI(
            argThat(new ServerConfigurationMatcher(serverConfiguration)),
            argThat(new AuthManagersMatcher(authManagers)),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    AvailableNumberListResponse response = service.searchForAvailableNumbers(parameters);

    AvailableNumberListResponse expected =
        new AvailableNumberListResponse(
            AvailableNumberDtoTest.availableNumberList.getAvailableNumbers());

    TestHelpers.recursiveEquals(response, expected);
  }

  @Test
  void searchForAvailableNumbersWithRequiredParameters() throws ApiException {

    AvailableNumbersListQueryParameters parameters =
        AvailableNumbersListQueryParameters.builder()
            .setRegionCode("region")
            .setType(NumberType.MOBILE)
            .build();

    HttpRequest httpRequest =
        new HttpRequest(
            "/v1/projects/" + URLPathUtils.encodePathSegment(URI_UUID) + "/availableNumbers",
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
        new HttpResponse(200, null, Collections.emptyMap(), jsonAvailableListResponse.getBytes());

    when(httpClient.invokeAPI(
            argThat(new ServerConfigurationMatcher(serverConfiguration)),
            argThat(new AuthManagersMatcher(authManagers)),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    AvailableNumberListResponse response = service.searchForAvailableNumbers(parameters);

    AvailableNumberListResponse expected =
        new AvailableNumberListResponse(
            AvailableNumberDtoTest.availableNumberList.getAvailableNumbers());

    TestHelpers.recursiveEquals(response, expected);
  }

  @Test
  void searchForAvailableNumbersWithOptionalParameters() throws ApiException {

    AvailableNumbersListQueryParameters parameters =
        AvailableNumbersListQueryParameters.builder()
            .setRegionCode("another region")
            .setType(NumberType.TOLL_FREE)
            .setSearchPattern("pattern value")
            .setSearchPosition(SearchPosition.END)
            .setCapabilities(Arrays.asList(Capability.VOICE))
            .setSize(5)
            .build();

    HttpRequest httpRequest =
        new HttpRequest(
            "/v1/projects/" + URLPathUtils.encodePathSegment(URI_UUID) + "/availableNumbers",
            HttpMethod.GET,
            Arrays.asList(
                new URLParameter("numberPattern.pattern", "pattern value", STYLE.FORM, true),
                new URLParameter(
                    "numberPattern.searchPattern", SearchPosition.END, STYLE.FORM, true),
                new URLParameter("regionCode", "another region", STYLE.FORM, true),
                new URLParameter("type", NumberType.TOLL_FREE, STYLE.FORM, true),
                new URLParameter("capabilities", Arrays.asList(Capability.VOICE), STYLE.FORM, true),
                new URLParameter("size", 5, STYLE.FORM, true)),
            (String) null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            NUMBERS_AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), jsonAvailableListResponse.getBytes());

    when(httpClient.invokeAPI(
            argThat(new ServerConfigurationMatcher(serverConfiguration)),
            argThat(new AuthManagersMatcher(authManagers)),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    AvailableNumberListResponse response = service.searchForAvailableNumbers(parameters);

    AvailableNumberListResponse expected =
        new AvailableNumberListResponse(
            AvailableNumberDtoTest.availableNumberList.getAvailableNumbers());

    TestHelpers.recursiveEquals(response, expected);
  }

  @Test
  void searchForAvailableNumbersWithOptionalParametersDeprecated() throws ApiException {

    AvailableNumberListRequest parameters =
        AvailableNumberListRequest.builder()
            .setRegionCode("another region")
            .setType(NumberType.TOLL_FREE)
            .setSearchPattern(
                SearchPattern.builder()
                    .setPattern("pattern value")
                    .setPosition(SearchPosition.END)
                    .build())
            .setCapabilities(Arrays.asList(Capability.VOICE))
            .setSize(5)
            .build();

    HttpRequest httpRequest =
        new HttpRequest(
            "/v1/projects/" + URLPathUtils.encodePathSegment(URI_UUID) + "/availableNumbers",
            HttpMethod.GET,
            Arrays.asList(
                new URLParameter("numberPattern.pattern", "pattern value", STYLE.FORM, true),
                new URLParameter(
                    "numberPattern.searchPattern", SearchPosition.END, STYLE.FORM, true),
                new URLParameter("regionCode", "another region", STYLE.FORM, true),
                new URLParameter("type", NumberType.TOLL_FREE, STYLE.FORM, true),
                new URLParameter("capabilities", Arrays.asList(Capability.VOICE), STYLE.FORM, true),
                new URLParameter("size", 5, STYLE.FORM, true)),
            (String) null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            NUMBERS_AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), jsonAvailableListResponse.getBytes());

    when(httpClient.invokeAPI(
            argThat(new ServerConfigurationMatcher(serverConfiguration)),
            argThat(new AuthManagersMatcher(authManagers)),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    AvailableNumberListResponse response = service.searchForAvailableNumbers(parameters);

    AvailableNumberListResponse expected =
        new AvailableNumberListResponse(
            AvailableNumberDtoTest.availableNumberList.getAvailableNumbers());

    TestHelpers.recursiveEquals(response, expected);
  }

  @Test
  void rentWithoutConfiguration() {

    String phoneNumber = "+12345678";
    HttpRequest httpRequest =
        new HttpRequest(
            "/v1/projects/"
                + URLPathUtils.encodePathSegment(URI_UUID)
                + "/availableNumbers/"
                + URLPathUtils.encodePathSegment(phoneNumber)
                + ":rent",
            HttpMethod.POST,
            Collections.emptyList(),
            "{}",
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            NUMBERS_AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), jsonActiveNumber.getBytes());

    when(httpClient.invokeAPI(
            argThat(new ServerConfigurationMatcher(serverConfiguration)),
            argThat(new AuthManagersMatcher(authManagers)),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    ActiveNumber response = service.rent(phoneNumber);

    TestHelpers.recursiveEquals(response, ActiveNumberDtoTest.activeNumber);
  }

  @Test
  void rent() {

    String phoneNumber = "+12345678";

    AvailableNumberRentRequest request =
        AvailableNumberRentRequest.builder()
            .setSmsConfiguration(
                SmsConfiguration.builder().setServicePlanId("").setCampaignId("").build())
            .setVoiceConfiguration(VoiceConfigurationRTC.builder().setAppId("").build())
            .setCallbackUrl("foo")
            .build();

    HttpRequest httpRequest =
        new HttpRequest(
            "/v1/projects/"
                + URLPathUtils.encodePathSegment(URI_UUID)
                + "/availableNumbers/"
                + URLPathUtils.encodePathSegment(phoneNumber)
                + ":rent",
            HttpMethod.POST,
            Collections.emptyList(),
            HttpMapper.getInstance()
                .serialize(Collections.singletonList(HttpContentType.APPLICATION_JSON), request),
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            NUMBERS_AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), jsonActiveNumber.getBytes());

    when(httpClient.invokeAPI(
            argThat(new ServerConfigurationMatcher(serverConfiguration)),
            argThat(new AuthManagersMatcher(authManagers)),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    ActiveNumber response = service.rent(phoneNumber, request);

    TestHelpers.recursiveEquals(response, ActiveNumberDtoTest.activeNumber);
  }

  @Test
  void rentAny() {

    AvailableNumberRentAnyRequest request =
        AvailableNumberRentAnyRequest.builder()
            .setRegionCode("foo region")
            .setType(NumberType.MOBILE)
            .build();

    HttpRequest httpRequest =
        new HttpRequest(
            "/v1/projects/"
                + URLPathUtils.encodePathSegment(URI_UUID)
                + "/availableNumbers:rentAny",
            HttpMethod.POST,
            Collections.emptyList(),
            HttpMapper.getInstance()
                .serialize(Collections.singletonList(HttpContentType.APPLICATION_JSON), request),
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            NUMBERS_AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), jsonActiveNumber.getBytes());

    when(httpClient.invokeAPI(
            argThat(new ServerConfigurationMatcher(serverConfiguration)),
            argThat(new AuthManagersMatcher(authManagers)),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    ActiveNumber response = service.rentAny(request);

    TestHelpers.recursiveEquals(response, ActiveNumberDtoTest.activeNumber);
  }
}
