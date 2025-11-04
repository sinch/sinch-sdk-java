package com.sinch.sdk.domains.mailgun.api.v1.adapters;

import com.sinch.sdk.core.databind.FormSerializer;
import java.util.List;
import java.util.Map;

public class ArrayToCommaSeparatedFormSerializer extends FormSerializer<List<String>> {

  @Override
  public void serialize(List<String> in, String fieldName, Map<String, Object> out) {
    if (null != in) {
      out.put(fieldName, String.join(",", in));
    }
  }
}
