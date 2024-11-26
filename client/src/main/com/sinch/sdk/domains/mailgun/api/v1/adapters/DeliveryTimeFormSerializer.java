package com.sinch.sdk.domains.mailgun.api.v1.adapters;

import com.sinch.sdk.core.databind.FormSerializer;
import java.util.Map;

public class DeliveryTimeFormSerializer extends FormSerializer<Integer> {

  @Override
  public void serialize(Integer in, String fieldName, Map<String, Object> out) {
    out.put(fieldName, String.format("%dh", in));
  }
}
