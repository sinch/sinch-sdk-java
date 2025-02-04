package com.sinch.sdk.domains.mailgun.models.v1.templates.response;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.mailgun.models.v1.response.internal.PagingResponse;
import com.sinch.sdk.domains.mailgun.models.v1.templates.Template;
import com.sinch.sdk.domains.mailgun.models.v1.templates.response.internal.ListTemplatesResponseInternal;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@TestWithResources
public class GetListTemplatesResponseTest extends BaseTest {

  @GivenJsonResource("/domains/mailgun/v1/templates/response/ListTemplatesResponseDtoPage0.json")
  ListTemplatesResponseInternal loadListTemplatesResponseDto;

  public static ListTemplatesResponseInternal expectedListTemplatesResponseDto =
      ListTemplatesResponseInternal.builder()
          .setItems(
              Arrays.asList(
                  Template.builder()
                      .setName("created from rest")
                      .setDescription("")
                      .setCreatedAt(Instant.parse("2025-01-29T14:26:24Z"))
                      .setCreatedBy("")
                      .setId("7a766667-99d1-4b0e-b80d-068f1e0e4b24")
                      .build(),
                  Template.builder()
                      .setName("letter template from dashboard")
                      .setDescription("")
                      .setCreatedAt(Instant.parse("2025-01-10T14:01:48Z"))
                      .setCreatedBy("dnd")
                      .setId("a708b1dc-2cff-4710-97ce-9763d829e23c")
                      .build()))
          .setPaging(
              PagingResponse.builder()
                  .setPrevious(
                      "https://api.mailgun.net/v3/sandboxFOO.mailgun.org/templates?page=previous&p=created+from+rest&limit=2")
                  .setFirst("https://api.mailgun.net/v3/sandboxFOO.mailgun.org/templates?limit=2")
                  .setNext(
                      "https://api.mailgun.net/v3/sandboxFOO.mailgun.org/templates?page=next&p=letter+tempalte+from+dashboard&limit=2")
                  .setLast(
                      "https://api.mailgun.net/v3/sandboxFOO.mailgun.org/templates?page=last&limit=2")
                  .build())
          .build();

  @Test
  void deserialize() {
    TestHelpers.recursiveEquals(loadListTemplatesResponseDto, expectedListTemplatesResponseDto);
  }
}
