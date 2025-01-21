package com.sinch.sdk.core.databind.query_parameter;

import com.sinch.sdk.core.TestHelpers;
import java.time.Instant;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InstantToIso8601SerializerTest {

  InstantToIso8601Serializer serializer = InstantToIso8601Serializer.getInstance();

  @Test
  void serialize() {

    Instant instant = Instant.parse("2024-05-04T10:00:00.123Z");

    String serialized = serializer.apply(instant);

    TestHelpers.recursiveEquals("2024-05-04T10:00:00.123Z", serialized);
  }

  @Test
  void serializeNull() {

    String serialized = serializer.apply(null);

    Assertions.assertNull(serialized);
  }
}
