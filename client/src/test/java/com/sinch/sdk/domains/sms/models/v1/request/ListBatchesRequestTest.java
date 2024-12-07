package com.sinch.sdk.domains.sms.models.v1.request;

import com.sinch.sdk.domains.sms.models.v1.batches.request.ListBatchesRequest;
import java.time.Instant;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ListBatchesRequestTest {

  static final String from = "foo from";

  static Instant startDate = Instant.now();
  static Instant endDate = Instant.now();
  static String clientReference = "a client reference";
  static Integer page = 1;
  static Integer pageSize = 3;

  public static final ListBatchesRequest value =
      ListBatchesRequest.builder()
          .setFrom(from)
          .setStartDate(startDate)
          .setEndDate(endDate)
          .setClientReference(clientReference)
          .setPage(page)
          .setPageSize(pageSize)
          .build();

  @Test
  void getFrom() {
    Assertions.assertThat(value.getFrom().get()).isEqualTo(from);
  }

  @Test
  void getStartDate() {
    Assertions.assertThat(value.getStartDate().get()).isEqualTo(startDate);
  }

  @Test
  void getEndDate() {
    Assertions.assertThat(value.getEndDate().get()).isEqualTo(endDate);
  }

  @Test
  void getClientReference() {
    Assertions.assertThat(value.getClientReference().get()).isEqualTo(clientReference);
  }

  @Test
  void getPage() {
    Assertions.assertThat(value.getPage().get()).isEqualTo(page);
  }

  @Test
  void getPageSize() {
    Assertions.assertThat(value.getPageSize().get()).isEqualTo(pageSize);
  }
}
