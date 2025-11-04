package com.sinch.sdk.domains.mailgun.api.v1.adapters;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ArrayToCommaSeparatedFormSerializerTest {

  ArrayToCommaSeparatedFormSerializer serializer = new ArrayToCommaSeparatedFormSerializer();

  @Test
  void serializeNonEmptyList() {
    Map<String, Object> map = new HashMap<>();
    serializer.serialize(Arrays.asList("value1", "value2", "value3, value 4"), "key", map);

    Assertions.assertEquals("value1,value2,value3, value 4", map.get("key"));
  }

  @Test
  void serializeEmptyList() {
    Map<String, Object> map = new HashMap<>();
    serializer.serialize(Collections.emptyList(), "key", map);

    Assertions.assertEquals("", map.get("key"));
  }

  @Test
  void serializeNullList() {
    Map<String, Object> map = new HashMap<>();
    serializer.serialize(null, "key", map);

    Assertions.assertNull(map.get("key"));
  }
}
