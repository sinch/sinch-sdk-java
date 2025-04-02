package com.sinch.sdk.domains.mailgun.api.v1.adapters;

import com.sinch.sdk.core.TestHelpers;
import java.util.Arrays;
import java.util.Collections;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MapToJSONStringHelperTest {

  @Test
  void serialize() {

    String serialized =
        MapToJSONStringHelper.serialize(
            Collections.singletonMap(
                "level1",
                Collections.singletonMap("level2", Collections.singletonMap("level3", "value"))));

    String expected = "{\"level1\":{\"level2\":{\"level3\":\"value\"}}}";

    TestHelpers.recursiveEquals(expected, serialized);
  }

  @Test
  void serializeInteger() {

    String serialized =
        MapToJSONStringHelper.serialize(
            Collections.singletonMap(
                "cc-dest@sinch.com", Collections.singletonMap("variable1", 123)));

    String expected = "{\"cc-dest@sinch.com\":{\"variable1\":123}}";

    TestHelpers.recursiveEquals(expected, serialized);
  }

  @Test
  void serializeLong() {

    String serialized =
        MapToJSONStringHelper.serialize(
            Collections.singletonMap(
                "cc-dest@sinch.com", Collections.singletonMap("variable1", 12345678901L)));

    String expected = "{\"cc-dest@sinch.com\":{\"variable1\":12345678901}}";

    TestHelpers.recursiveEquals(expected, serialized);
  }

  @Test
  void serializeDouble() {

    String serialized =
        MapToJSONStringHelper.serialize(
            Collections.singletonMap(
                "cc-dest@sinch.com", Collections.singletonMap("variable1", 0.12345678901d)));

    String expected = "{\"cc-dest@sinch.com\":{\"variable1\":0.12345678901}}";

    TestHelpers.recursiveEquals(expected, serialized);
  }

  @Test
  void serializeFloat() {

    String serialized =
        MapToJSONStringHelper.serialize(
            Collections.singletonMap(
                "cc-dest@sinch.com", Collections.singletonMap("variable1", 0.123456)));

    String expected = "{\"cc-dest@sinch.com\":{\"variable1\":0.123456}}";

    TestHelpers.recursiveEquals(expected, serialized);
  }

  @Test
  void serializeBoolean() {

    String serialized =
        MapToJSONStringHelper.serialize(
            Collections.singletonMap(
                "cc-dest@sinch.com", Collections.singletonMap("variable1", true)));

    String expected = "{\"cc-dest@sinch.com\":{\"variable1\":true}}";

    TestHelpers.recursiveEquals(expected, serialized);
  }

  @Test
  void serializeArray() {

    String serialized =
        MapToJSONStringHelper.serialize(
            Collections.singletonMap(
                "cc-dest@sinch.com",
                Arrays.asList(
                    Collections.singletonMap("variable.1", true),
                    Collections.singletonMap("variable2", "value2"))));

    String expected = "{\"cc-dest@sinch.com\":[{\"variable.1\":true},{\"variable2\":\"value2\"}]}";

    TestHelpers.recursiveEquals(expected, serialized);
  }

  @Test
  void serializeNull() {

    Assertions.assertNull(MapToJSONStringHelper.serialize(null));
  }
}
