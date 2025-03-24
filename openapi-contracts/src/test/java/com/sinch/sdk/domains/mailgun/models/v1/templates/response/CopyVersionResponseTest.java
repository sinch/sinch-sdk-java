package com.sinch.sdk.domains.mailgun.models.v1.templates.response;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.mailgun.models.v1.templates.VersionDetails;
import com.sinch.sdk.domains.mailgun.models.v1.templates.internal.CopyVersionResponseInternal;
import java.time.Instant;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

@TestWithResources
public class CopyVersionResponseTest extends BaseTest {

  @GivenJsonResource("/domains/mailgun/v1/templates/response/CopyVersionResponseDto.json")
  CopyVersionResponseInternal loadedVersionDto;

  public static final CopyVersionResponseInternal expectedDto =
      CopyVersionResponseInternal.builder()
          .setMessage("version has been copied")
          .setVersion(
              VersionDetails.builder()
                  .setTag("version of template created  from java sdk(cloned)")
                  .setTemplate("<p>{{firstname}} {{lastname}}</p>")
                  .setEngine("handlebars")
                  .setMjml("")
                  .setCreatedAt(Instant.parse("2025-03-21T15:00:44Z"))
                  .setComment("a comment value from copy")
                  .setActive(false)
                  .setId("95658c55-e93a-40d5-a02f-a4fadfbbb3ca")
                  .setHeaders(
                      Stream.of(
                              new String[][] {
                                {"From", "mygrom@adress.org"},
                                {"Subject", "my subject"}
                              })
                          .collect(Collectors.toMap(data -> data[0], data -> data[1])))
                  .build())
          .build();

  @Test
  void deserialize() {
    TestHelpers.recursiveEquals(loadedVersionDto, expectedDto);
  }
}
