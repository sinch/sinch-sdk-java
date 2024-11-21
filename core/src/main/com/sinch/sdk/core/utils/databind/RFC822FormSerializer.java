package com.sinch.sdk.core.utils.databind;

import com.sinch.sdk.core.databind.FormSerializer;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class RFC822FormSerializer extends FormSerializer<Instant> {

  @Override
  public String serialize(Instant in) {
    return DateTimeFormatter.RFC_1123_DATE_TIME.format(in.atZone(ZoneId.of("UTC")));
  }
}
