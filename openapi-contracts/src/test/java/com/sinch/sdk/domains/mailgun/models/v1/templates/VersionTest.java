package com.sinch.sdk.domains.mailgun.models.v1.templates;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import java.time.Instant;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class VersionTest extends BaseTest {

  @GivenJsonResource("/domains/mailgun/v1/templates/VersionResponseDto.json")
  Version loadedVersionResponseDto;

  @GivenTextResource("/domains/mailgun/v1/templates/VersionRequestDto.json")
  String jsonVersionRequestDto;

  public static Version expectedVersion =
      Version.builder()
          .setTag("template.test")
          .setTemplate(
              "<div class=\"entry\"> <h1>{{title}}</h1> Hello {{ident.name}} !<br/> <div"
                  + " class=\"body\"> {{body}} </div> </div>")
          .setEngine("handlebars")
          .setMjml("mjml content")
          .setCreatedAt(Instant.parse("2025-01-13T07:54:58Z"))
          .setComment("comment value")
          .setActive(true)
          .setId("1a0a286e-65e9-4f4a-8275-6b7edbab3e76")
          .setHeaders(
              Stream.of(
                      new String[][] {
                        {"From", "from header values"},
                        {"Reply-To", "reply to header value"},
                        {"Subject", "Test version"}
                      })
                  .collect(Collectors.toMap(data -> data[0], data -> data[1])))
          .build();

  @Test
  void deserialize() {
    TestHelpers.recursiveEquals(loadedVersionResponseDto, expectedVersion);
  }

  @Test
  void serialize() throws JsonProcessingException, JSONException {

    String serializedString = objectMapper.writeValueAsString(expectedVersion);

    JSONAssert.assertEquals(jsonVersionRequestDto, serializedString, true);
  }
}
