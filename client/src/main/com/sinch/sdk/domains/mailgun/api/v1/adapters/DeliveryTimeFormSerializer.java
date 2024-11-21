package com.sinch.sdk.domains.mailgun.api.v1.adapters;

import com.sinch.sdk.core.databind.FormSerializer;

public class DeliveryTimeFormSerializer extends FormSerializer<Integer> {

  @Override
  public String serialize(Integer in) {
    return String.format("%dh", in);
  }
}
