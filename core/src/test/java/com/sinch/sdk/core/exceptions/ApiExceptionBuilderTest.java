package com.sinch.sdk.core.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.sinch.sdk.core.utils.databind.Mapper;
import java.util.HashMap;
import org.junit.jupiter.api.Test;

class ApiExceptionBuilderTest {

  private static final String numberErrorMocked =
      "{ \"error\": {"
          + "\"code\": 202,"
          + "\"message\": \"my error message\","
          + "\"status\": \"MY_STATUS\""
          + "}}";

  @Test
  void buildFromMessage() {
    ApiException e = ApiExceptionBuilder.build("message", 202);
    assertEquals("message", e.getMessage());
    assertEquals(202, e.getCode());
  }

  @Test
  void buildFromObject() throws JsonProcessingException {
    ApiException e =
        ApiExceptionBuilder.build(
            "message",
            202,
            Mapper.getInstance()
                .readValue(numberErrorMocked, new TypeReference<HashMap<String, ?>>() {}));
    assertEquals("MY_STATUS: my error message", e.getMessage());
    assertEquals(202, e.getCode());
  }
}
