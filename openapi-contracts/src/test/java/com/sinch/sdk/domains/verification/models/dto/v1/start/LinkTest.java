package com.sinch.sdk.domains.verification.models.dto.v1.start;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.verification.models.v1.start.response.Link;
import com.sinch.sdk.domains.verification.models.v1.start.response.Link.RelEnum;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@TestWithResources
public class LinkTest extends BaseTest {
  @GivenJsonResource("/domains/verification/v1/start/LinkDto.json")
  static List<Link> linksDto;

  public static List<Link> expectedLinks =
      new ArrayList<>(
          Arrays.asList(
              Link.builder()
                  .setRel(RelEnum.STATUS)
                  .setHref("an href for status")
                  .setMethod("GET")
                  .build(),
              Link.builder()
                  .setRel(RelEnum.REPORT)
                  .setHref("an href for report")
                  .setMethod("PUT")
                  .build()));

  @Test
  void deserialize() {
    TestHelpers.recursiveEquals(linksDto, expectedLinks);
  }
}
