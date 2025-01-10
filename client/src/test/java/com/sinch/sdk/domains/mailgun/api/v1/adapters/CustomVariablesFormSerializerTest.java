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

class CustomVariablesFormSerializerTest {
  CustomVariablesFormSerializer serializer = new CustomVariablesFormSerializer();

  @Test
  void serialize() {

    HashMap<String, Object> map = new HashMap<>();

    serializer.serialize(
        Arrays.asList(
            Pair.of("my-var-key1", "a-var-value1"),
            Pair.of("my-var-key1", "a-var-value2"),
            Pair.of("my-var-key2", "a-var-value3")),
        null,
        map);

    Map<String, Object> expected =
        Stream.of(
                new AbstractMap.SimpleEntry<>(
                    "v:my-var-key1", Arrays.asList("a-var-value1", "a-var-value2")),
                new AbstractMap.SimpleEntry<>("v:my-var-key2", Arrays.asList("a-var-value3")))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    TestHelpers.recursiveEquals(expected, map);
  }

  @Test
  void serializeNull() {

    HashMap<String, Object> map = new HashMap<>();

    serializer.serialize(null, null, map);

    Assertions.assertTrue(map.isEmpty());
  }
}
