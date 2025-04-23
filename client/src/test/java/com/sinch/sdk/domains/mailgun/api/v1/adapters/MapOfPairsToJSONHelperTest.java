package com.sinch.sdk.domains.mailgun.api.v1.adapters;

import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.core.utils.Pair;
import java.util.Collections;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MapOfPairsToJSONHelperTest {

  @Test
  void serialize() {

    String serialized =
        MapOfPairsToJSONHelper.serialize(
            Collections.singletonMap(
                "cc-dest@sinch.com", Collections.singletonList(Pair.of("variable1", "value1"))));

    String expected = "{\"cc-dest@sinch.com\":{\"variable1\":\"value1\"}}";

    Assertions.assertEquals(expected, serialized);
  }

  @Test
  void serializeInteger() {

    String serialized =
        MapOfPairsToJSONHelper.serialize(
            Collections.singletonMap(
                "cc-dest@sinch.com", Collections.singletonList(Pair.of("variable1", 123))));

    String expected = "{\"cc-dest@sinch.com\":{\"variable1\":123}}";

    TestHelpers.recursiveEquals(expected, serialized);
  }

  @Test
  void serializeLong() {

    String serialized =
        MapOfPairsToJSONHelper.serialize(
            Collections.singletonMap(
                "cc-dest@sinch.com",
                Collections.singletonList(Pair.of("variable1", 12345678901L))));

    String expected = "{\"cc-dest@sinch.com\":{\"variable1\":12345678901}}";

    TestHelpers.recursiveEquals(expected, serialized);
  }

  @Test
  void serializeDouble() {

    String serialized =
        MapOfPairsToJSONHelper.serialize(
            Collections.singletonMap(
                "cc-dest@sinch.com",
                Collections.singletonList(Pair.of("variable1", 0.12345678901d))));

    String expected = "{\"cc-dest@sinch.com\":{\"variable1\":0.12345678901}}";

    TestHelpers.recursiveEquals(expected, serialized);
  }

  @Test
  void serializeFloat() {

    String serialized =
        MapOfPairsToJSONHelper.serialize(
            Collections.singletonMap(
                "cc-dest@sinch.com", Collections.singletonList(Pair.of("variable1", 0.123456))));

    String expected = "{\"cc-dest@sinch.com\":{\"variable1\":0.123456}}";

    TestHelpers.recursiveEquals(expected, serialized);
  }

  @Test
  void serializeBoolean() {

    String serialized =
        MapOfPairsToJSONHelper.serialize(
            Collections.singletonMap(
                "cc-dest@sinch.com", Collections.singletonList(Pair.of("variable1", true))));

    String expected = "{\"cc-dest@sinch.com\":{\"variable1\":true}}";

    TestHelpers.recursiveEquals(expected, serialized);
  }

  @Test
  void serializeNull() {

    Assertions.assertNull(MapOfPairsToJSONHelper.serialize(null));
  }
}
