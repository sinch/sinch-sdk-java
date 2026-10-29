package com.sinch.sdk.http;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpMethod;
import com.sinch.sdk.core.http.transport.BufferedHttpContentParser;
import com.sinch.sdk.core.http.transport.HttpHeaders;
import com.sinch.sdk.core.http.transport.HttpRequest;
import com.sinch.sdk.core.http.transport.HttpResponse;
import com.sinch.sdk.core.http.transport.HttpTransport;
import com.sinch.sdk.core.utils.Pair;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

class TransportCallTest {

  private static final HttpRequest REQUEST =
      HttpRequest.builder()
          .setMethod(HttpMethod.POST)
          .setUrl("https://foo.com/v1/a%20b")
          .setQueryParameters("?x=1")
          .setHeaders(
              new HttpHeaders()
                  .add("Content-Type", "application/json")
                  .add("Authorization", "to be replaced"))
          .build();

  private HttpTransport transport;
  private AuthManager basic;
  private AuthManager bearer;
  private Map<String, AuthManager> authManagers;

  @BeforeEach
  void setUp() throws IOException {
    transport = mock(HttpTransport.class);
    when(transport.send(any()))
        .thenReturn(
            new HttpResponse(
                200, "OK", new HttpHeaders(), new BufferedHttpContentParser(null, null)));

    basic = mock(AuthManager.class);
    when(basic.getAuthorizationHeaders(any(), any(), any(), any()))
        .thenReturn(Collections.singletonList(new Pair<>("Authorization", "Basic abc")));
    bearer = mock(AuthManager.class);
    when(bearer.getAuthorizationHeaders(any(), any(), any(), any()))
        .thenReturn(Collections.singletonList(new Pair<>("Authorization", "Bearer first")))
        .thenReturn(Collections.singletonList(new Pair<>("Authorization", "Bearer second")));

    authManagers = new HashMap<>();
    authManagers.put("BasicAuth", basic);
    authManagers.put("OAuth2", bearer);
  }

  @Test
  void sendsTheRequestAsIsBeforeAuthorizing() throws IOException {
    TransportCall call =
        new TransportCall(
            transport, REQUEST, authManagers, Collections.singletonList("OAuth2"), "{}");

    assertEquals(200, call.send().getCode());

    assertSame(REQUEST, sent().get(0));
    verifyNoInteractions(bearer);
  }

  @Test
  void authorizeUsesTheFirstSupportedSchemeWithAManager() throws IOException {
    TransportCall call =
        new TransportCall(
            transport,
            REQUEST,
            authManagers,
            Arrays.asList("Unknown", "OAuth2", "BasicAuth"),
            "{}");

    call.authorize();
    call.send();

    assertEquals(Optional.of("Bearer first"), sent().get(0).getHeaders().getFirst("Authorization"));
    assertEquals(1, sent().get(0).getHeaders().getAll("authorization").size());
    verify(bearer).getAuthorizationHeaders("POST", "application/json", "/v1/a%20b?x=1", "{}");
    verifyNoInteractions(basic);
  }

  @Test
  void sendKeepsTheLatestAuthorization() throws IOException {
    TransportCall call =
        new TransportCall(
            transport, REQUEST, authManagers, Collections.singletonList("OAuth2"), null);

    call.authorize();
    call.send();
    call.send();
    call.authorize();
    call.send();

    List<HttpRequest> sent = sent();
    assertEquals(Optional.of("Bearer first"), sent.get(0).getHeaders().getFirst("Authorization"));
    assertEquals(Optional.of("Bearer first"), sent.get(1).getHeaders().getFirst("Authorization"));
    assertEquals(Optional.of("Bearer second"), sent.get(2).getHeaders().getFirst("Authorization"));
    verify(bearer, times(2)).getAuthorizationHeaders(any(), any(), any(), any());
  }

  @Test
  void authorizeDoesNotChangeTheRequest() {
    TransportCall call =
        new TransportCall(
            transport, REQUEST, authManagers, Collections.singletonList("OAuth2"), null);

    call.authorize();

    assertSame(REQUEST, call.getRequest());
    assertEquals(Optional.of("to be replaced"), REQUEST.getHeaders().getFirst("Authorization"));
  }

  @Test
  void noSchemeKeepsTheRequest() throws IOException {
    TransportCall call = new TransportCall(transport, REQUEST, authManagers, null, null);

    call.authorize();
    call.send();

    assertSame(REQUEST, sent().get(0));
  }

  @Test
  void noManagerKeepsTheRequest() throws IOException {
    TransportCall call =
        new TransportCall(transport, REQUEST, null, Collections.singletonList("OAuth2"), null);

    call.authorize();
    call.send();

    assertSame(REQUEST, sent().get(0));
  }

  @Test
  void transportFailureIsPropagated() throws IOException {
    when(transport.send(any())).thenThrow(new IOException("connection reset"));
    TransportCall call = new TransportCall(transport, REQUEST, authManagers, null, null);

    assertThrows(IOException.class, call::send);
  }

  private List<HttpRequest> sent() throws IOException {
    ArgumentCaptor<HttpRequest> captor = ArgumentCaptor.forClass(HttpRequest.class);
    verify(transport, atLeastOnce()).send(captor.capture());
    return captor.getAllValues();
  }
}
