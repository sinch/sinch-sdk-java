package com.sinch.sdk.domains.sms.models;

import com.sinch.sdk.core.utils.Pair;
import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ParametersTest {
  final Parameters parameters =
      new Parameters(
          Arrays.asList(
              new Parameters.Entry("key 1", new Pair<>("value identifier1", "value 1")),
              new Parameters.Entry(
                  "key 2", new Pair<>("value identifier2", "value 2"), "default value for ")));

  @Test
  void getParameters() {
    Assertions.assertThat(parameters.get("key 1"))
        .usingRecursiveComparison()
        .isEqualTo(new Parameters.Entry("key 1", new Pair<>("value identifier1", "value 1")));

    Assertions.assertThat(parameters.get("key 2"))
        .usingRecursiveComparison()
        .isEqualTo(
            new Parameters.Entry(
                "key 2", new Pair<>("value identifier2", "value 2"), "default value for "));
  }
}
