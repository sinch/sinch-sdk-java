package com.sinch.sdk.domains.sms.models.requests;

import com.sinch.sdk.domains.sms.models.DeliveryReportStatus;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collection;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class DeliveryReportListRequestParametersBuilderTest {

  final Instant startDate = Instant.now().plusSeconds(10);
  final Instant endDate = Instant.now().plusSeconds(15);
  final String clientReference = " client reference";
  final Integer page = 12;
  final Integer pageSize = 3;
  final Collection<DeliveryReportStatus> statuses =
      Arrays.asList(DeliveryReportStatus.CANCELLED, DeliveryReportStatus.DELETED);
  final Collection<Integer> codes = Arrays.asList(123, 456);
  final DeliveryReportListRequestParameters value =
      DeliveryReportListRequestParameters.builder()
          .setStartDate(startDate)
          .setEndDate(endDate)
          .setClientReference(clientReference)
          .setPage(page)
          .setPageSize(pageSize)
          .setStatuses(statuses)
          .setCodes(codes)
          .build();

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

  @Test
  void getStatuses() {
    Assertions.assertThat(value.getStatuses().get()).usingRecursiveComparison().isEqualTo(statuses);
  }

  @Test
  void getCodes() {
    Assertions.assertThat(value.getCodes().get()).usingRecursiveComparison().isEqualTo(codes);
  }
}
