package com.sinch.sdk.domains.sms.models;

import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.core.utils.Pair;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class ParametersTest {
  final Parameters parameters =
      new Parameters(
          Arrays.asList(
              new Parameters.Entry("key 1", new Pair<>("value identifier1", "value 1")),
              new Parameters.Entry(
                  "key 1",
                  new Pair<>("value identifier1 duplicated key", "value 1 duplicated key")),
              new Parameters.Entry(
                  "key 2", new Pair<>("value identifier2", "value 2"), "default value for ")));

  @Test
  void getParameters() {

    TestHelpers.recursiveEquals(
        parameters.get("key 2"),
        new ArrayList(
            Arrays.asList(
                new Parameters.Entry(
                    "key 2", new Pair<>("value identifier2", "value 2"), "default value for "))));
  }

  @Test
  void duplicatedKey() {

    TestHelpers.recursiveEquals(
        parameters.get("key 1"),
        new ArrayList(
            Arrays.asList(
                new Parameters.Entry("key 1", new Pair<>("value identifier1", "value 1")),
                new Parameters.Entry(
                    "key 1",
                    new Pair<>("value identifier1 duplicated key", "value 1 duplicated key")))));
  }
}
