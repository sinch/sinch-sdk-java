package com.sinch.sdk.domains.numbers.models.responses;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.models.pagination.Page;
import com.sinch.sdk.core.models.pagination.PageToken;
import com.sinch.sdk.domains.numbers.ActiveNumberService;
import com.sinch.sdk.domains.numbers.models.*;
import com.sinch.sdk.domains.numbers.models.requests.ActiveNumberListRequestParameters;
import com.sinch.sdk.domains.numbers.models.requests.ActiveNumberListRequestParametersTest;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class ActiveNumberListResponseTest extends BaseTest {
  @Mock ActiveNumberService service;

  List<ActiveNumber> list =
      Stream.generate(
              () ->
                  ActiveNumber.builder()
                      .setPhoneNumber(String.valueOf(Math.random()))
                      .setProjectId(String.valueOf(Math.random()))
                      .setDisplayName(String.valueOf(Math.random()))
                      .setRegionCode(String.valueOf(Math.random()))
                      .setType(NumberType.from(String.valueOf(Math.random())))
                      .setCapability(Arrays.asList(Capability.VOICE, Capability.SMS))
                      .setMoney(new Money(String.valueOf(Math.random()), Math.random()))
                      .setPaymentIntervalMonths((int) (Math.random() * 12))
                      .setNextChargeDate(
                          Instant.ofEpochMilli(ThreadLocalRandom.current().nextLong()))
                      .setExpireAt(Instant.ofEpochMilli(ThreadLocalRandom.current().nextLong()))
                      .setSmsConfiguration(
                          new SMSConfiguration(
                              String.valueOf(Math.random()),
                              String.valueOf(Math.random()),
                              new ScheduledSmsProvisioning(
                                  String.valueOf(Math.random()),
                                  String.valueOf(Math.random()),
                                  ProvisioningStatus.FAILED,
                                  Instant.ofEpochMilli(ThreadLocalRandom.current().nextLong()),
                                  Collections.singletonList(SmsErrorCode.ERROR_CODE_UNSPECIFIED))))
                      .setVoiceConfiguration(
                          new VoiceConfiguration(
                              String.valueOf(Math.random()),
                              Instant.ofEpochMilli(ThreadLocalRandom.current().nextLong()),
                              new ScheduledVoiceProvisioning(
                                  String.valueOf(Math.random()),
                                  ProvisioningStatus.IN_PROGRESS,
                                  Instant.ofEpochMilli(ThreadLocalRandom.current().nextLong()))))
                      .setCallbackUrl(String.valueOf(Math.random()))
                      .build())
          .limit(13)
          .collect(Collectors.toList());

  List<Page<ActiveNumberListRequestParameters, ActiveNumber, String>> pages =
      Arrays.asList(
          new Page<>(
              ActiveNumberListRequestParametersTest.value,
              list.stream().limit(5).collect(Collectors.toList()),
              new PageToken<>("foo page2")),
          new Page<>(
              ActiveNumberListRequestParametersTest.value,
              list.stream().skip(5).limit(5).collect(Collectors.toList()),
              new PageToken<>("foo page3")),
          new Page<>(
              ActiveNumberListRequestParametersTest.value,
              list.stream().skip(10).collect(Collectors.toList()),
              null));

  @Test
  void autoPageIter() {
    setupMockedService();
    AtomicInteger count = new AtomicInteger();
    ActiveNumberListResponse response = new ActiveNumberListResponse(service, pages.get(0));
    response
        .autoPageIter()
        .forEachRemaining(
            value -> {
              Assertions.assertThat(value)
                  .usingRecursiveComparison()
                  .isEqualTo(list.get(count.get()));
              count.getAndIncrement();
            });
    assertEquals(count.get(), list.size());
  }

  @Test
  void hasNextPage() {

    ActiveNumberListResponse response = new ActiveNumberListResponse(service, pages.get(0));
    assertTrue(response.hasNextPage());
    response = new ActiveNumberListResponse(service, pages.get(1));
    assertTrue(response.hasNextPage());
    response = new ActiveNumberListResponse(service, pages.get(2));
    assertFalse(response.hasNextPage());
  }

  @Test
  void nextPage() {

    setupMockedService();
    ActiveNumberListResponse response = new ActiveNumberListResponse(service, pages.get(0));
    int page = 1;
    while (response.hasNextPage()) {
      response = response.nextPage();
      Assertions.assertThat(response.getContent())
          .usingRecursiveComparison()
          .isEqualTo(pages.get(page).getEntities());
      page++;
    }
    assertThrows(NoSuchElementException.class, response::nextPage);
  }

  @Test
  void getContent() {

    for (Page<ActiveNumberListRequestParameters, ActiveNumber, String> page : pages) {
      ActiveNumberListResponse response = new ActiveNumberListResponse(service, page);
      Assertions.assertThat(response.getContent())
          .usingRecursiveComparison()
          .isEqualTo(page.getEntities());
    }
  }

  void setupMockedService() {
    when(service.list(any(ActiveNumberListRequestParameters.class)))
        .thenAnswer(
            invocation -> {
              ActiveNumberListRequestParameters parameters =
                  invocation.getArgument(0, ActiveNumberListRequestParameters.class);
              switch (parameters.getPageToken().get()) {
                case "foo page2":
                  return new ActiveNumberListResponse(service, pages.get(1));
                case "foo page3":
                  return new ActiveNumberListResponse(service, pages.get(2));
              }
              return null;
            });
  }
}
