package com.sinch.sdk.domains.verification.adapters.converters;

import com.sinch.sdk.core.http.HttpMethod;
import com.sinch.sdk.domains.verification.models.Link;
import com.sinch.sdk.domains.verification.models.LinkRelType;
import java.util.Collection;
import java.util.stream.Collectors;

public class LinkDtoConverter {

  public static Collection<Link> convert(
      Collection<com.sinch.sdk.domains.verification.models.v1.start.response.Link> dto) {
    return dto.stream().map(LinkDtoConverter::convert).collect(Collectors.toList());
  }

  public static Link convert(com.sinch.sdk.domains.verification.models.v1.start.response.Link dto) {
    return Link.builder()
        .setRel(LinkRelType.from(dto.getRel()))
        .setHref(dto.getHref())
        .setMethod(HttpMethod.valueOf(dto.getMethod()))
        .build();
  }
}
