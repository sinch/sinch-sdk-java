package com.sinch.sdk.domains.sms.api.v1.adapters;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.domains.sms.api.v1.internal.InboundsApi;
import com.sinch.sdk.domains.sms.models.v1.inbounds.BinaryMessage;
import com.sinch.sdk.domains.sms.models.v1.inbounds.InboundMessage;
import com.sinch.sdk.domains.sms.models.v1.inbounds.TextMessage;
import com.sinch.sdk.domains.sms.models.v1.inbounds.request.ListInboundMessagesQueryParameters;
import com.sinch.sdk.domains.sms.models.v1.inbounds.response.ListInboundsResponse;
import com.sinch.sdk.domains.sms.models.v1.inbounds.response.internal.ApiInboundList;
import com.sinch.sdk.models.SmsContext;
import java.time.Instant;
import java.util.Iterator;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

@TestWithResources
class InboundsServiceTest extends BaseTest {

  @Mock SmsContext context;
  @Mock HttpClient httpClient;
  @Mock Map<String, AuthManager> authManagers;
  @Mock InboundsApi api;
  InboundsService service;

  String uriPartID = "foovalue";

  @GivenJsonResource("/domains/sms/v1/inbounds/MOBinaryDto.json")
  InboundMessage binary;

  @GivenJsonResource("/domains/sms/v1/inbounds/MOTextDto.json")
  InboundMessage text;

  @GivenJsonResource("/domains/sms/v1/inbounds/MOMediaDto.json")
  InboundMessage media;

  @GivenJsonResource("/domains/sms/v1/inbounds/response/internal/InboundsListResponseDtoPage0.json")
  ApiInboundList inboundsLisResponseDtoPage0;

  @GivenJsonResource("/domains/sms/v1/inbounds/response/internal/InboundsListResponseDtoPage1.json")
  ApiInboundList inboundsLisResponseDtoPage1;

  @GivenJsonResource("/domains/sms/v1/inbounds/response/internal/InboundsListResponseDtoPage2.json")
  ApiInboundList inboundsLisResponseDtoPage2;

  @BeforeEach
  public void initMocks() {
    service = spy(new InboundsService(uriPartID, context, httpClient, authManagers));
    doReturn(api).when(service).getApi();
  }

  @Test
  void getBinary() throws ApiException {

    when(api.get(eq("foo inbound ID"))).thenReturn(binary);

    InboundMessage response = service.get("foo inbound ID");

    TestHelpers.recursiveEquals(response, binary);
  }

  @Test
  void getText() throws ApiException {

    when(api.get(eq("foo inbound ID"))).thenReturn(text);

    InboundMessage response = service.get("foo inbound ID");

    TestHelpers.recursiveEquals(response, text);
  }

  @Test
  void getMedia() throws ApiException {

    when(api.get(eq("foo inbound ID"))).thenReturn(media);

    InboundMessage response = service.get("foo inbound ID");

    TestHelpers.recursiveEquals(response, media);
  }

  @Test
  void list() throws ApiException {

    ListInboundMessagesQueryParameters initialRequest =
        ListInboundMessagesQueryParameters.builder().build();
    ListInboundMessagesQueryParameters page1 =
        ListInboundMessagesQueryParameters.builder().setPage(1).build();
    ListInboundMessagesQueryParameters page2 =
        ListInboundMessagesQueryParameters.builder().setPage(2).build();

    when(api.list(initialRequest)).thenReturn(inboundsLisResponseDtoPage0);
    when(api.list(page1)).thenReturn(inboundsLisResponseDtoPage1);
    when(api.list(page2)).thenReturn(inboundsLisResponseDtoPage2);

    ListInboundsResponse response = service.list(initialRequest);

    Iterator<InboundMessage> iterator = response.iterator();
    InboundMessage item = iterator.next();
    Assertions.assertThat(item)
        .usingRecursiveComparison()
        .isEqualTo(
            BinaryMessage.builder()
                .setBody("a body")
                .setClientReference("a client reference")
                .setFrom("+11203494390")
                .setId("01FC66621XXXXX119Z8PMV1QPA")
                .setOperatorId("35000")
                .setReceivedAt(Instant.parse("2019-08-24T14:17:22Z"))
                .setSentAt(Instant.parse("2019-08-24T14:15:22Z"))
                .setTo("11203453453")
                .setUdh("foo udh")
                .build());

    item = iterator.next();
    Assertions.assertThat(iterator.hasNext()).isEqualTo(true);
    Assertions.assertThat(item)
        .usingRecursiveComparison()
        .isEqualTo(
            TextMessage.builder()
                .setBody("a body")
                .setClientReference("a client reference")
                .setFrom("+11203494390")
                .setId("01FC66621XXXXX119Z8PMV1QPA")
                .setOperatorId("35000")
                .setReceivedAt(Instant.parse("2019-08-24T14:17:22Z"))
                .setSentAt(Instant.parse("2019-08-24T14:15:22Z"))
                .setTo("11203453453")
                .build());

    item = iterator.next();
    Assertions.assertThat(iterator.hasNext()).isEqualTo(false);
    Assertions.assertThat(item)
        .usingRecursiveComparison()
        .isEqualTo(
            BinaryMessage.builder()
                .setBody("a body")
                .setClientReference("a client reference")
                .setFrom("+11203494390")
                .setId("01FC66621XXXXX119Z8PMV1QPA")
                .setOperatorId("35000")
                .setReceivedAt(Instant.parse("2019-08-24T14:17:22Z"))
                .setSentAt(Instant.parse("2019-08-24T14:15:22Z"))
                .setTo("11203453453")
                .setUdh("foo udh")
                .build());
  }
}
