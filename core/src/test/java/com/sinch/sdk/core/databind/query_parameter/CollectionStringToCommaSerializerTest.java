package com.sinch.sdk.core.databind.query_parameter;

import com.sinch.sdk.core.TestHelpers;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CollectionStringToCommaSerializerTest {

  CollectionStringToCommaSerializer serializer = CollectionStringToCommaSerializer.getInstance();

  @Test
  void serialize() {

    List<String> list = Arrays.asList("foo1", "foo2");

    String serialized = serializer.apply(list);

    TestHelpers.recursiveEquals("foo1,foo2", serialized);
  }

  @Test
  void serializeSingle() {

    List<String> list = Collections.singletonList("foo1");

    String serialized = serializer.apply(list);

    TestHelpers.recursiveEquals("foo1", serialized);
  }

  @Test
  void serializeEmpty() {

    String serialized = serializer.apply(Collections.emptyList());

    Assertions.assertEquals("", serialized);
  }

  @Test
  void serializeNull() {

    String serialized = serializer.apply(null);

    Assertions.assertNull(serialized);
  }
}
