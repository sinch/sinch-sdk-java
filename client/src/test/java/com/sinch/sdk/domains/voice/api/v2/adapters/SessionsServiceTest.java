package com.sinch.sdk.domains.voice.api.v2.adapters;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpContentType;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.core.http.HttpMethod;
import com.sinch.sdk.core.http.HttpRequest;
import com.sinch.sdk.core.http.HttpRequestTest.HttpRequestMatcher;
import com.sinch.sdk.core.http.HttpResponse;
import com.sinch.sdk.core.http.URLPathUtils;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.domains.voice.api.v2.SessionsService;
import com.sinch.sdk.domains.voice.models.v2.sessions.response.Session;
import com.sinch.sdk.domains.voice.models.v2.sessions.response.SessionDtoTest;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

@TestWithResources
public class SessionsServiceTest extends BaseTest {

  @Mock HttpClient httpClient;
  @Mock ServerConfiguration serverConfiguration;
  @Mock Map<String, AuthManager> authManagers;

  static final String PROJECT_ID = "test_project_id";
  static final Collection<String> AUTH_NAMES = Arrays.asList("BasicAuth", "SinchOAuth2");
  static final Collection<String> ACCEPTS =
      Arrays.asList(HttpContentType.APPLICATION_JSON, "application/problem+json");

  SessionsService service;

  @GivenTextResource("/domains/voice/v2/sessions/response/SessionDto.json")
  String jsonSessionDto;

  @BeforeEach
  public void initMocks() {
    service =
        new SessionsServiceImpl(
            httpClient, serverConfiguration, authManagers, HttpMapper.getInstance(), PROJECT_ID);
  }

  @Test
  void get() throws ApiException {

    String sessionId = "01BX5ZZKBKACTAV9WEVGEMMVRB";
    HttpRequest httpRequest =
        new HttpRequest(
            "/v2/projects/"
                + URLPathUtils.encodePathSegment(PROJECT_ID)
                + "/sessions/"
                + URLPathUtils.encodePathSegment(sessionId),
            HttpMethod.GET,
            Collections.emptyList(),
            (String) null,
            Collections.emptyMap(),
            ACCEPTS,
            Collections.emptyList(),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), jsonSessionDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    Session response = service.get(sessionId);

    TestHelpers.recursiveEquals(response, SessionDtoTest.expectedSession);
  }

  @Test
  void getMissingSessionIdThrows() {

    ApiException thrown = Assertions.assertThrows(ApiException.class, () -> service.get(null));

    Assertions.assertEquals(400, thrown.getCode());
  }

  @Test
  void getMissingProjectIdThrows() {

    SessionsService serviceWithoutProjectId =
        new SessionsServiceImpl(
            httpClient, serverConfiguration, authManagers, HttpMapper.getInstance(), null);

    ApiException thrown =
        Assertions.assertThrows(
            ApiException.class, () -> serviceWithoutProjectId.get("01BX5ZZKBKACTAV9WEVGEMMVRB"));

    Assertions.assertEquals(400, thrown.getCode());
  }
}
