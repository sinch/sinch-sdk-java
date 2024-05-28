package com.sinch.sdk.domains.verification.models.dto.v1.start;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.verification.models.v1.start.response.Link;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@TestWithResources
public class LinkTest extends BaseTest {
  @GivenJsonResource("/domains/verification/v1/start/LinkDto.json")
  static Collection<Link> linksDto;

  public static List<Link> expectedLinks =
      Arrays.asList(
          Link.builder().setRel("status").setHref("an href for status").setMethod("GET").build(),
          Link.builder().setRel("report").setHref("an href for report").setMethod("PUT").build());

  @Test
  void deserialize() {
    Assertions.assertThat(linksDto).usingRecursiveComparison().isEqualTo(expectedLinks);
  }
}
