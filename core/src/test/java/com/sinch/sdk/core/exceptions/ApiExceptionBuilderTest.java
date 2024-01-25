package com.sinch.sdk.core.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.utils.databind.Mapper;
import java.util.HashMap;
import org.junit.jupiter.api.Test;

@TestWithResources
class ApiExceptionBuilderTest extends BaseTest {

  private static final String unknownErrorMocked =
      "{ \"foo\": {"
          + "\"foo\": 202,"
          + "\"foo\": \"my error message\","
          + "\"foo\": \"MY_STATUS\""
          + "}}";

  @GivenTextResource("/domains/numbers/v1/error-trial-account.json")
  String numberError;

  @GivenTextResource("/domains/sms/v1/error-response.json")
  String smsError;

  @GivenTextResource("/domains/verification/v1/error-response.json")
  String verificationError;

  @Test
  void buildFromObject() throws JsonProcessingException {
    ApiException e =
        ApiExceptionBuilder.build(
            "message",
            202,
            Mapper.getInstance()
                .readValue(unknownErrorMocked, new TypeReference<HashMap<String, ?>>() {}));
    assertEquals("message", e.getMessage());
    assertEquals(202, e.getCode());
  }

  @Test
  void numbersError() throws JsonProcessingException {
    ApiException e =
        ApiExceptionBuilder.build(
            "message",
            202,
            Mapper.getInstance()
                .readValue(numberError, new TypeReference<HashMap<String, ?>>() {}));
    assertEquals(
        "PERMISSION_DENIED: Trial account is not enabled to rent number. Details:"
            + " {type=ResourceInfo, resourceType=AvailableNumber, resourceName=, owner=,"
            + " description=Trial account is not enabled to rent number}",
        e.getMessage());
    assertEquals(403, e.getCode());
  }

  @Test
  void smsError() throws JsonProcessingException {
    ApiException e =
        ApiExceptionBuilder.build(
            "message",
            202,
            Mapper.getInstance().readValue(smsError, new TypeReference<HashMap<String, ?>>() {}));
    assertEquals(
        "syntax_invalid_parameter_format: 'foo' is not a valid identifier", e.getMessage());
    assertEquals(202, e.getCode());
  }

  @Test
  void verificationError() throws JsonProcessingException {
    ApiException e =
        ApiExceptionBuilder.build(
            "message",
            202,
            Mapper.getInstance()
                .readValue(verificationError, new TypeReference<HashMap<String, ?>>() {}));
    assertEquals("Requested resource was not found. (reference=a reference)", e.getMessage());
    assertEquals(40400, e.getCode());
  }
}
