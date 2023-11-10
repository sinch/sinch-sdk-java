package com.sinch.sdk.domains.sms.models;

import com.sinch.sdk.core.utils.Pair;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collection;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BatchMediaTest {
  final String id = "an id";

  final Collection<String> to = Arrays.asList("to1", "to2");

  final String from = "from value";

  final boolean canceled = true;
  final Parameters parameters =
      new Parameters(
          Arrays.asList(
              new Parameters.Entry("key 1", new Pair<>("value identifier1", "value 1")),
              new Parameters.Entry(
                  "key 2", new Pair<>("value identifier2", "value 2"), "default value for ")));
  final Instant createdAt = Instant.now();
  final Instant modifiedAt = Instant.now();
  final DeliveryReportType deliveryReport = DeliveryReportType.FULL;
  final Instant sendAt = Instant.now();
  final Instant expireAt = Instant.now();
  final String callbackUrl = "callback value";
  final String clientReference = " client reference";
  final boolean feedbackEnabled = false;
  final MediaBody body = new MediaBody("url value", "body message");
  final boolean strictValidation = true;
  final BatchMedia value =
      new BatchMedia(
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
          feedbackEnabled,
          parameters,
          strictValidation);

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
    Assertions.assertThat(value.getParameters()).usingRecursiveComparison().isEqualTo(parameters);
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
  void isStrictValidation() {
    Assertions.assertThat(value.isStrictValidation()).isEqualTo(strictValidation);
  }
}
