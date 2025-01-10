package com.sinch.sdk.domains.mailgun.api.v1.adapters;

import com.sinch.sdk.core.TestHelpers;
import java.util.HashMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DeliveryTimeFormSerializerTest {

  DeliveryTimeFormSerializer serializer = new DeliveryTimeFormSerializer();

  @Test
  void serialize() {

    HashMap<String, Object> map = new HashMap<>();

    serializer.serialize(10, "key name", map);

    TestHelpers.recursiveEquals("10h", map.get("key name"));
  }

  @Test
  void serializeNull() {

    HashMap<String, Object> map = new HashMap<>();

    serializer.serialize(null, "key name", map);

    Assertions.assertNull(map.get("key name"));
  }
}
