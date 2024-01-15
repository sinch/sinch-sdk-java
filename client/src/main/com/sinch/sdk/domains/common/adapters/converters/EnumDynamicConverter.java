package com.sinch.sdk.domains.common.adapters.converters;

import com.sinch.sdk.core.utils.EnumDynamic;

public class EnumDynamicConverter {

  public static String convert(EnumDynamic<String, ?> client) {
    if (null == client) {
      return null;
    }
    return client.value();
  }
}
