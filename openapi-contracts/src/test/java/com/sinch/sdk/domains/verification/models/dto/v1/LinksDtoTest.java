package com.sinch.sdk.domains.verification.models.dto.v1;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@TestWithResources
public class LinksDtoTest extends BaseTest {
  @GivenJsonResource("/domains/verification/v1/LinksDto.json")
  static Collection<VerificationResourceLinkDto> linksDto;

  public static List<VerificationResourceLinkDto> expectedLinks =
      Arrays.asList(
          new VerificationResourceLinkDto().rel("status").href("an href for status").method("GET"),
          new VerificationResourceLinkDto().rel("report").href("an href for report").method("PUT"));

  @Test
  void deserialize() {
    Assertions.assertThat(linksDto).usingRecursiveComparison().isEqualTo(expectedLinks);
  }
}
