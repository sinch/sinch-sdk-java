package com.sinch.sdk.domains.voice.adapters.converters;

import com.sinch.sdk.models.DualToneMultiFrequency;

public class DualToneMultiFrequencyDtoConverter {

  public static String convert(DualToneMultiFrequency client) {
    if (null == client) {
      return null;
    }
    return client.stringValue();
  }
}
