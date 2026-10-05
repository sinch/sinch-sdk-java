package com.sinch.sdk.domains.voice.models.v2.svaml;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.sinch.sdk.BaseTest;
import java.io.IOException;
import org.junit.jupiter.api.Test;

public class SvamlCommandTest extends BaseTest {

  @Test
  void deserializeUnknownCommandFails() {
    IOException exception =
        assertThrows(
            IOException.class,
            () -> objectMapper.readValue("{\"command\":\"unknown\"}", SvamlCommand.class));
    assertTrue(exception.getMessage().contains("unknown 'command' value 'unknown'"));
  }

  @Test
  void deserializeMissingCommandFails() {
    IOException exception =
        assertThrows(
            IOException.class,
            () -> objectMapper.readValue("{\"callName\":\"origin\"}", SvamlCommand.class));
    assertTrue(exception.getMessage().contains("unknown 'command' value 'null'"));
  }
}
