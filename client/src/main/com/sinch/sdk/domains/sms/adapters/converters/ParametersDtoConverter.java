package com.sinch.sdk.domains.sms.adapters.converters;

import com.sinch.sdk.core.utils.Pair;
import com.sinch.sdk.domains.sms.models.Parameters;
import com.sinch.sdk.domains.sms.models.dto.v1.ParameterObjDto;
import com.sinch.sdk.domains.sms.models.dto.v1.ParameterObjParameterKeyDto;
import java.util.Map;
import java.util.stream.Collectors;

public class ParametersDtoConverter {

  public static Parameters convert(ParameterObjDto dto) {
    return new Parameters(
        dto.entrySet().stream()
            .map(
                entry -> {
                  @SuppressWarnings("unchecked")
                  Map<String, String> entryValue = (Map<String, String>) entry.getValue();
                  return new Parameters.Entry(
                      entry.getKey(),
                      entryValue.entrySet().stream()
                          .filter(
                              value ->
                                  value
                                          .getKey()
                                          .compareTo(
                                              ParameterObjParameterKeyDto.JSON_PROPERTY_DEFAULT)
                                      != 0)
                          .map(e -> new Pair<>(e.getKey(), e.getValue()))
                          .findFirst()
                          .orElse(null),
                      entryValue.entrySet().stream()
                          .filter(
                              value ->
                                  value
                                          .getKey()
                                          .compareTo(
                                              ParameterObjParameterKeyDto.JSON_PROPERTY_DEFAULT)
                                      == 0)
                          .map(Map.Entry::getValue)
                          .findFirst()
                          .orElse(null));
                })
            .collect(Collectors.toList()));
  }
}
