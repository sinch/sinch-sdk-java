package com.sinch.sdk.domains.verification.adapters.converters;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.core.http.HttpMethod;
import com.sinch.sdk.domains.verification.models.Link;
import com.sinch.sdk.domains.verification.models.LinkRelType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import org.junit.jupiter.api.Test;

@TestWithResources
public class LinkDtoConverterTest extends BaseTest {

  @GivenJsonResource("/domains/verification/v1/start/LinkDto.json")
  public Collection<com.sinch.sdk.domains.verification.models.v1.start.response.Link> linksDto;

  public static Collection<Link> linksClient =
      new ArrayList<>(
          Arrays.asList(
              Link.builder()
                  .setRel(LinkRelType.STATUS)
                  .setHref("an href for status")
                  .setMethod(HttpMethod.GET)
                  .build(),
              Link.builder()
                  .setRel(LinkRelType.REPORT)
                  .setHref("an href for report")
                  .setMethod(HttpMethod.PUT)
                  .build()));

  @Test
  void convert() {

    TestHelpers.recursiveEquals(LinkDtoConverter.convert(linksDto), linksClient);
  }
}
