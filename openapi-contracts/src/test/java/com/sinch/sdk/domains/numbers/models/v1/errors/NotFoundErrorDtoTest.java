package com.sinch.sdk.domains.numbers.models.v1.errors;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.numbers.api.v1.adapters.NumbersBaseTest;
import com.sinch.sdk.domains.numbers.models.v1.errors.NotFound.CodeEnum;
import com.sinch.sdk.domains.numbers.models.v1.errors.NotFound.StatusEnum;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@TestWithResources
public class NotFoundErrorDtoTest extends NumbersBaseTest {

  @GivenTextResource("/domains/numbers/v1/errors/not-found-error.json")
  String notFoundErrorJson;

  public static NotFound notFoundError =
      NotFound.builder()
          .setCode(CodeEnum.NUMBER_404)
          .setMessage("message string")
          .setStatus(StatusEnum.NOT_FOUND)
          .setDetails(
              Arrays.asList(
                  NotFoundErrorDetails.builder()
                      .setType("type value")
                      .setResourceType("resource type value")
                      .setResourceName("resource name value")
                      .setOwner("owner value")
                      .setDescription("description value")
                      .build()))
          .build();

  @Test
  void deserialize() throws JsonProcessingException {

    NotFound deserializedString = objectMapper.readValue(notFoundErrorJson, NotFound.class);

    TestHelpers.recursiveEquals(notFoundError, deserializedString);
  }
}
