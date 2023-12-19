package com.sinch.sdk.domains.common.adapters.converters;

import java.time.Instant;
import java.time.OffsetDateTime;

public class OffsetDateTimeDtoConverter {

  public static Instant convert(OffsetDateTime dto) {
    return null != dto ? dto.toInstant() : null;
  }
}
