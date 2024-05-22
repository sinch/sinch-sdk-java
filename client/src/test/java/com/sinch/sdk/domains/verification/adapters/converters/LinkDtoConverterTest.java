package com.sinch.sdk.domains.verification.adapters.converters;

import static org.junit.jupiter.api.Assertions.*;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.http.HttpMethod;
import com.sinch.sdk.domains.verification.models.Link;
import com.sinch.sdk.domains.verification.models.LinkRelType;
import com.sinch.sdk.domains.verification.models.dto.v1.LinksObjectDto;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import org.junit.jupiter.api.Test;

@TestWithResources
public class LinkDtoConverterTest extends BaseTest {

  @GivenJsonResource("/domains/verification/v1/LinksDto.json")
  public Collection<LinksObjectDto> linksDto;

  public static Collection<Link> linksClient =
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
              .build());

  public static void compareWithDto(Link client, LinksObjectDto dto) {
    assertEquals(dto.getRel(), client.getRel().value());
    assertEquals(dto.getHref(), client.getHref());
    assertEquals(dto.getMethod(), client.getMethod().name());
  }

  @Test
  void convert() {
    Iterator<LinksObjectDto> dtoIterator = linksDto.stream().iterator();
    Iterator<Link> clientIterator = linksClient.stream().iterator();
    dtoIterator.forEachRemaining(dtoItem -> compareWithDto(clientIterator.next(), dtoItem));
  }
}
