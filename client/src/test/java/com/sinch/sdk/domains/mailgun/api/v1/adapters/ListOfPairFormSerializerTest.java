package com.sinch.sdk.domains.mailgun.api.v1.adapters;

import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.core.utils.Pair;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ListOfPairFormSerializerTest {
  ListOfPairFormSerializer serializer = new ListOfPairFormSerializer();

  @Test
  void serialize() {

    HashMap<String, Object> map = new HashMap<>();

    serializer.serialize(
        Arrays.asList(Pair.of("key1", 12345), Pair.of("key2", 789)), "field_name", map);

    Map<String, Object> expected =
        new HashMap<>(Collections.singletonMap("field_name", "{\"key1\":12345,\"key2\":789}"));

    TestHelpers.recursiveEquals(expected, map);
  }

  @Test
  void serializeLong() {

    HashMap<String, Object> map = new HashMap<>();

    serializer.serialize(
        Arrays.asList(Pair.of("key1", 12345678901L), Pair.of("key2", 10234567891L)),
        "field_name",
        map);

    Map<String, Object> expected =
        new HashMap<>(
            Collections.singletonMap("field_name", "{\"key1\":12345678901,\"key2\":10234567891}"));

    TestHelpers.recursiveEquals(expected, map);
  }

  @Test
  void serializeDouble() {

    HashMap<String, Object> map = new HashMap<>();

    serializer.serialize(
        Arrays.asList(Pair.of("key1", 0.12345678901d), Pair.of("key2", 0.0123456789d)),
        "field_name",
        map);

    Map<String, Object> expected =
        new HashMap<>(
            Collections.singletonMap(
                "field_name", "{\"key1\":0.12345678901,\"key2\":0.0123456789}"));

    TestHelpers.recursiveEquals(expected, map);
  }

  @Test
  void serializeFloat() {

    HashMap<String, Object> map = new HashMap<>();

    serializer.serialize(
        Arrays.asList(Pair.of("key1", 0.123456), Pair.of("key2", 0.012345)), "field_name", map);

    Map<String, Object> expected =
        new HashMap<>(
            Collections.singletonMap("field_name", "{\"key1\":0.123456,\"key2\":0.012345}"));

    TestHelpers.recursiveEquals(expected, map);
  }

  @Test
  void serializeBoolean() {

    HashMap<String, Object> map = new HashMap<>();

    serializer.serialize(
        Arrays.asList(Pair.of("key1", true), Pair.of("key2", false)), "field_name", map);

    Map<String, Object> expected =
        new HashMap<>(Collections.singletonMap("field_name", "{\"key1\":true,\"key2\":false}"));

    TestHelpers.recursiveEquals(expected, map);
  }

  @Test
  void serializeNull() {

    HashMap<String, Object> map = new HashMap<>();

    serializer.serialize(null, "field_name", map);

    Assertions.assertEquals(map.keySet().size(), 1);
    Assertions.assertNull(map.get("field_name"));
  }
}
