package com.sinch.sdk.domains.mailgun.api.v1.adapters;

import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.core.utils.Pair;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CustomHeadersFormSerializerTest {
  CustomHeadersFormSerializer serializer = new CustomHeadersFormSerializer();

  @Test
  void serialize() {

    HashMap<String, Object> map = new HashMap<>();

    serializer.serialize(
        Arrays.asList(
            Pair.of("my-header-key1", "a-header-value1"),
            Pair.of("my-header-key1", "a-header-value2"),
            Pair.of("my-header-key2", "a-header-value3")),
        "foo name",
        map);

    Map<String, Object> expected =
        Stream.of(
                new AbstractMap.SimpleEntry<>(
                    "h:my-header-key1", Arrays.asList("a-header-value1", "a-header-value2")),
                new AbstractMap.SimpleEntry<>("h:my-header-key2", Arrays.asList("a-header-value3")))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    TestHelpers.recursiveEquals(expected, map);
  }

  @Test
  void serializeNull() {

    HashMap<String, Object> map = new HashMap<>();

    serializer.serialize(null, "key name", map);

    Assertions.assertTrue(map.isEmpty());
  }
}
