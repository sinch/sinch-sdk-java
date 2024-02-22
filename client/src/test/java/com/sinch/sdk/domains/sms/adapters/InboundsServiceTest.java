package com.sinch.sdk.domains.sms.adapters;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.domains.sms.adapters.api.v1.InboundsApi;
import com.sinch.sdk.domains.sms.adapters.converters.InboundsDtoConverter;
import com.sinch.sdk.domains.sms.models.Inbound;
import com.sinch.sdk.domains.sms.models.InboundBinary;
import com.sinch.sdk.domains.sms.models.InboundText;
import com.sinch.sdk.domains.sms.models.dto.v1.ApiInboundListDto;
import com.sinch.sdk.domains.sms.models.dto.v1.InboundDto;
import com.sinch.sdk.domains.sms.models.responses.InboundsListResponse;
import com.sinch.sdk.models.SmsContext;
import com.sinch.sdk.models.UnifiedCredentials;
import java.time.Instant;
import java.util.Iterator;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

@TestWithResources
class InboundsServiceTest extends BaseTest {

  @Mock UnifiedCredentials credentials;
  @Mock SmsContext context;
  @Mock HttpClient httpClient;
  @Mock Map<String, AuthManager> authManagers;
  @Mock InboundsApi api;
  InboundsService service;

  @GivenJsonResource("/domains/sms/v1/MOBinaryDto.json")
  InboundDto binary;

  @GivenJsonResource("/domains/sms/v1/MOTextDto.json")
  InboundDto text;

  @GivenJsonResource("/domains/sms/v1/InboundsListResponseDtoPage0.json")
  ApiInboundListDto inboundsLisResponseDtoPage0;

  @GivenJsonResource("/domains/sms/v1/InboundsListResponseDtoPage1.json")
  ApiInboundListDto inboundsLisResponseDtoPage1;

  @GivenJsonResource("/domains/sms/v1/InboundsListResponseDtoPage2.json")
  ApiInboundListDto inboundsLisResponseDtoPage2;

  @BeforeEach
  public void initMocks() {
    service = spy(new InboundsService(credentials, context, httpClient, authManagers));
    doReturn(api).when(service).getApi();
  }

  @Test
  void getBinary() throws ApiException {

    when(api.retrieveInboundMessage(eq(credentials.getProjectId()), eq("foo inbound ID")))
        .thenReturn(binary);

    Inbound<?> response = service.get("foo inbound ID");

    assertInstanceOf(InboundBinary.class, response);
    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(InboundsDtoConverter.convert(binary));
  }

  @Test
  void getText() throws ApiException {

    when(api.retrieveInboundMessage(eq(credentials.getProjectId()), eq("foo inbound ID")))
        .thenReturn(text);

    Inbound<?> response = service.get("foo inbound ID");

    assertInstanceOf(InboundText.class, response);
    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(InboundsDtoConverter.convert(text));
  }

  @Test
  void list() throws ApiException {

    when(api.listInboundMessages(
            eq(credentials.getProjectId()),
            eq(null),
            eq(null),
            eq(null),
            eq(null),
            eq(null),
            eq(null)))
        .thenReturn(inboundsLisResponseDtoPage0);
    when(api.listInboundMessages(
            eq(credentials.getProjectId()),
            eq(1),
            eq(null),
            eq(null),
            eq(null),
            eq(null),
            eq(null)))
        .thenReturn(inboundsLisResponseDtoPage1);
    when(api.listInboundMessages(
            eq(credentials.getProjectId()),
            eq(2),
            eq(null),
            eq(null),
            eq(null),
            eq(null),
            eq(null)))
        .thenReturn(inboundsLisResponseDtoPage2);
    InboundsListResponse response = service.list(null);

    Iterator<Inbound<?>> iterator = response.iterator();
    Inbound<?> item = iterator.next();
    Assertions.assertThat(iterator.hasNext()).isEqualTo(true);

    assertInstanceOf(InboundBinary.class, item);
    Assertions.assertThat(item)
        .usingRecursiveComparison()
        .isEqualTo(
            InboundBinary.builder()
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
    assertInstanceOf(InboundText.class, item);
    Assertions.assertThat(item)
        .usingRecursiveComparison()
        .isEqualTo(
            InboundText.builder()
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
    assertInstanceOf(InboundBinary.class, item);
    Assertions.assertThat(item)
        .usingRecursiveComparison()
        .isEqualTo(
            InboundBinary.builder()
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
