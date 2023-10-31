package com.sinch.sdk.domains.numbers.models.responses;

import static org.junit.jupiter.api.Assertions.*;

import com.sinch.sdk.domains.numbers.models.NumberType;
import com.sinch.sdk.domains.numbers.models.Region;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class AvailableRegionListResponseTest {

  List<Region> list =
      Stream.generate(
              () ->
                  Region.builder()
                      .setRegionCode(String.valueOf(Math.random()))
                      .setRegionName(String.valueOf(Math.random()))
                      .setTypes(Collections.singletonList(NumberType.TOLL_FREE))
                      .build())
          .limit(15)
          .collect(Collectors.toList());

  AvailableRegionListResponse response = new AvailableRegionListResponse(new ArrayList<>(list));

  @Test
  void autoPageIter() {
    AtomicInteger count = new AtomicInteger();
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
