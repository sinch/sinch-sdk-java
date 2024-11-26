package com.sinch.sdk.core.utils.databind;

import com.sinch.sdk.core.databind.FormSerializer;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class RFC822FormSerializer extends FormSerializer<Instant> {

  @Override
  public void serialize(Instant in, String fieldName, Map<String, Object> out) {
    out.put(fieldName, DateTimeFormatter.RFC_1123_DATE_TIME.format(in.atZone(ZoneId.of("UTC"))));
  }
}
