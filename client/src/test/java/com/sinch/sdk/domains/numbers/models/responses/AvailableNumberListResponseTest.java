package com.sinch.sdk.domains.numbers.models.responses;

import static java.lang.String.valueOf;
import static org.junit.jupiter.api.Assertions.*;

import com.sinch.sdk.domains.numbers.models.AvailableNumber;
import com.sinch.sdk.domains.numbers.models.Capability;
import com.sinch.sdk.domains.numbers.models.Money;
import com.sinch.sdk.domains.numbers.models.NumberType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class AvailableNumberListResponseTest {

  List<AvailableNumber> list =
      Stream.generate(
              () ->
                  AvailableNumber.builder()
                      .setPhoneNumber(valueOf(Math.random()))
                      .setRegionCode(valueOf(Math.random()))
                      .setType(NumberType.LOCAL)
                      .setCapability(Collections.singletonList(Capability.VOICE))
                      .setSetupPrice(new Money(valueOf(Math.random()), Math.random() * 100))
                      .setMonthlyPrice(new Money(valueOf(Math.random()), Math.random() * 100))
                      .setPaymentIntervalMonths((int) (Math.random() * 12))
                      .setSupportingDocumentationRequired(true)
                      .build())
          .limit(15)
          .collect(Collectors.toList());

  AvailableNumberListResponse response = new AvailableNumberListResponse(new ArrayList<>(list));

  @Test
  void autoPageIter() {
    AtomicInteger count = new AtomicInteger();
    response
        .iterator()
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
    assertFalse(response.hasNextPage(), "Has no next page");
  }

  @Test
  void nextPage() {
    assertThrows(NoSuchElementException.class, response::nextPage);
  }

  @Test
  void getContent() {
    Assertions.assertThat(response.getContent()).usingRecursiveComparison().isEqualTo(list);
  }
}
