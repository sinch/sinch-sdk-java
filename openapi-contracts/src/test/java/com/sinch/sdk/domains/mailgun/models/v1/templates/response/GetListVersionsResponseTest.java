package com.sinch.sdk.domains.mailgun.models.v1.templates.response;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.mailgun.models.v1.response.internal.PagingResponse;
import com.sinch.sdk.domains.mailgun.models.v1.templates.TemplateTest;
import com.sinch.sdk.domains.mailgun.models.v1.templates.response.internal.ListVersionResponseInternal;
import org.junit.jupiter.api.Test;

@TestWithResources
public class GetListVersionsResponseTest extends BaseTest {

  @GivenJsonResource("/domains/mailgun/v1/templates/response/ListVersionsResponseDtoPage0.json")
  ListVersionResponseInternal loadListVersionsResponseDto;

  public static ListVersionResponseInternal expectedListVersionsResponseDto =
      ListVersionResponseInternal.builder()
          .setTemplate(TemplateTest.expectedTemplatePage0)
          .setPaging(
              PagingResponse.builder()
                  .setPrevious(
                      "https://api.mailgun.net/v3/domain.mailgun.org/templates/my-template/versions?page=previous&p=version+1&limit=2")
                  .setFirst(
                      "https://api.mailgun.net/v3/domain.mailgun.org.mailgun.org/templates/my-template/versions?limit=2")
                  .setNext(
                      "https://api.mailgun.net/v3/domain.mailgun.org.mailgun.org/templates/my-template/versions?page=next&p=version+2&limit=2")
                  .setLast(
                      "https://api.mailgun.net/v3/domain.mailgun.org.mailgun.org/templates/my-template/versions?page=last&limit=2")
                  .build())
          .build();

  @Test
  void deserialize() {
    TestHelpers.recursiveEquals(loadListVersionsResponseDto, expectedListVersionsResponseDto);
  }
}
