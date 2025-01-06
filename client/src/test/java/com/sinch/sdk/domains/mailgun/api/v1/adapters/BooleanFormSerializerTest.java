package com.sinch.sdk.domains.mailgun.api.v1.adapters;

import com.sinch.sdk.core.TestHelpers;
import java.util.HashMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BooleanFormSerializerTest {
  BooleanFormSerializer serializer = new BooleanFormSerializer();

  @Test
  void serializeTrue() {

    HashMap<String, Object> map = new HashMap<>();

    serializer.serialize(true, "key name", map);

    TestHelpers.recursiveEquals("true", map.get("key name"));
  }

  @Test
  void serializeFalse() {

    HashMap<String, Object> map = new HashMap<>();

    serializer.serialize(false, "key name", map);

    TestHelpers.recursiveEquals("false", map.get("key name"));
  }

  @Test
  void serializeNull() {

    HashMap<String, Object> map = new HashMap<>();

    serializer.serialize(null, "key name", map);

    Assertions.assertNull(map.get("key name"));
  }
}
