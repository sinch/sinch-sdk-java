package com.sinch.sdk.domains.voice.adapters.converters;

import com.sinch.sdk.models.E164PhoneNumber;

public class E164PhoneNumberDtoConverter {

  public static String convert(E164PhoneNumber client) {
    if (null == client) {
      return null;
    }
    return client.stringValue();
  }
}
