package com.sinch.sdk.domains.mailgun.api.v1.adapters;

import com.sinch.sdk.core.databind.multipart.ObjectMapperTest;
import java.util.HashMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NestedFieldFormSerializerTest {
  NestedFieldFormSerializer serializer = new NestedFieldFormSerializer();

  @Test
  void serialize() {

    HashMap<String, Object> map = new HashMap<>();

    serializer.serialize(ObjectMapperTest.object, null, map);

    Assertions.assertFalse(map.isEmpty());
  }

  @Test
  void serializeNull() {

    HashMap<String, Object> map = new HashMap<>();

    serializer.serialize(null, null, map);

    Assertions.assertTrue(map.isEmpty());
  }
}
