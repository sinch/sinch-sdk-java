package com.sinch.sdk.domains.sms.models;

import java.time.Instant;
import java.util.Arrays;
import java.util.Collection;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BatchTextTest {

  final String id = "an id";

  final Collection<String> to = Arrays.asList("to1", "to2");

  final String from = "from value";

  final boolean canceled = true;
  final Parameters parameters = null;
  final Instant createdAt = Instant.now();
  final Instant modifiedAt = Instant.now();
  final DeliveryReportType deliveryReport = DeliveryReportType.FULL;
  final Instant sendAt = Instant.now();
  final Instant expireAt = Instant.now();
  final String callbackUrl = "callback value";
  final String clientReference = " client reference";
  final boolean flashMessage = true;
  final boolean feedbackEnabled = false;
  final boolean truncateConcat = true;
  final int maxNumberOfMessageParts = 23;
  final int fromTon = 1234;
  final int fromNpi = 567;
  final String body = "body content";
  final BatchText value =
      new BatchText(
          id,
          to,
          from,
          canceled,
          body,
          createdAt,
          modifiedAt,
          deliveryReport,
          sendAt,
          expireAt,
          callbackUrl,
          clientReference,
          flashMessage,
          feedbackEnabled,
          parameters,
          truncateConcat,
          maxNumberOfMessageParts,
          fromTon,
          fromNpi);

  @Test
  void getId() {
    Assertions.assertThat(value.getId()).isEqualTo(id);
  }

  @Test
  void getTo() {
    Assertions.assertThat(value.getTo()).usingRecursiveComparison().isEqualTo(to);
  }

  @Test
  void getFrom() {
    Assertions.assertThat(value.getFrom()).isEqualTo(from);
  }

  @Test
  void isCanceled() {
    Assertions.assertThat(value.isCanceled()).isEqualTo(canceled);
  }

  @Test
  void getBody() {
    Assertions.assertThat(value.getBody()).isEqualTo(body);
  }

  @Test
  void getParameters() {
    Assertions.assertThat(value.getParameters()).isEqualTo(parameters);
  }

  @Test
  void getExpireAt() {
    Assertions.assertThat(value.getExpireAt()).isEqualTo(expireAt);
  }

  @Test
  void getCreatedAt() {
    Assertions.assertThat(value.getCreatedAt()).isEqualTo(createdAt);
  }

  @Test
  void getModifiedAt() {
    Assertions.assertThat(value.getModifiedAt()).isEqualTo(modifiedAt);
  }

  @Test
  void getDeliveryReport() {
    Assertions.assertThat(value.getDeliveryReport()).isEqualTo(deliveryReport);
  }

  @Test
  void getSendAt() {
    Assertions.assertThat(value.getSendAt()).isEqualTo(sendAt);
  }

  @Test
  void getCallbackUrl() {
    Assertions.assertThat(value.getCallbackUrl()).isEqualTo(callbackUrl);
  }

  @Test
  void getClientReference() {
    Assertions.assertThat(value.getClientReference()).isEqualTo(clientReference);
  }

  @Test
  void isFeedbackEnabled() {
    Assertions.assertThat(value.isFeedbackEnabled()).isEqualTo(feedbackEnabled);
  }

  @Test
  void isTruncateConcat() {
    Assertions.assertThat(value.isTruncateConcat()).isEqualTo(truncateConcat);
  }

  @Test
  void getMaxNumberOfMessageParts() {
    Assertions.assertThat(value.getMaxNumberOfMessageParts()).isEqualTo(maxNumberOfMessageParts);
  }

  @Test
  void getFromTon() {
    Assertions.assertThat(value.getFromTon()).isEqualTo(fromTon);
  }

  @Test
  void getFromNpi() {
    Assertions.assertThat(value.getFromNpi()).isEqualTo(fromNpi);
  }
}
