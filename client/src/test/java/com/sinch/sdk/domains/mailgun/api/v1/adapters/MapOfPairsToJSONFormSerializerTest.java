package com.sinch.sdk.domains.mailgun.api.v1.adapters;

import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.core.utils.Pair;
import java.util.Collections;
import java.util.HashMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MapOfPairsToJSONFormSerializerTest {
  MapOfPairsToJSONFormSerializer serializer = new MapOfPairsToJSONFormSerializer();

  @Test
  void serialize() {

    HashMap<String, Object> map = new HashMap<>();

    serializer.serialize(
        Collections.singletonMap(
            "cc-dest@sinch.com", Collections.singletonList(Pair.of("variable1", "value1"))),
        "foo name",
        map);

    String expected = "{\"cc-dest@sinch.com\":{\"variable1\":\"value1\"}}";

    TestHelpers.recursiveEquals(expected, map.get("foo name"));
  }

  @Test
  void serializeNull() {

    HashMap<String, Object> map = new HashMap<>();

    serializer.serialize(null, "key name", map);

    Assertions.assertTrue(map.isEmpty());
  }
}
