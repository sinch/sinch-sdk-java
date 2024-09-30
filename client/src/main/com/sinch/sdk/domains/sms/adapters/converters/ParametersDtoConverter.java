package com.sinch.sdk.domains.sms.adapters.converters;

import com.sinch.sdk.core.utils.Pair;
import com.sinch.sdk.domains.sms.models.Parameters;
import com.sinch.sdk.domains.sms.models.Parameters.Entry;
import com.sinch.sdk.domains.sms.models.dto.v1.ParameterObjDto;
import com.sinch.sdk.domains.sms.models.dto.v1.ParameterObjParameterKeyDto;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

public class ParametersDtoConverter {

  public static Parameters convert(ParameterObjDto dto) {
    if (null == dto) {
      return null;
    }

    ArrayList<Parameters.Entry> client = new ArrayList<>();
    dto.forEach((key, value) -> client.addAll(convertParameters(key, value)));

    return new Parameters(client);
  }

  public static ParameterObjDto convert(Parameters parameters) {
    ParameterObjDto dto = new ParameterObjDto();

    parameters
        .entrySet()
        .iterator()
        .forEachRemaining(entries -> dto.put(entries.getKey(), convert(entries.getValue())));
    return dto;
  }

  public static HashMap<String, String> convert(Collection<Entry> client) {
    if (null == client) {
      return null;
    }
    HashMap<String, String> dto = new HashMap<>();

    client.forEach(
        entry -> {
          dto.put(entry.getValue().getLeft(), entry.getValue().getRight());
          entry
              .getDefaultValue()
              .ifPresent(def -> dto.put(ParameterObjParameterKeyDto.JSON_PROPERTY_DEFAULT, def));
        });
    return dto;
  }

  public static Collection<Parameters.Entry> convertParameters(String parameterName, Object _dto) {
    if (!(_dto instanceof Map)) {
      return null;
    }
    ArrayList<Parameters.Entry> client = new ArrayList<>();

    @SuppressWarnings("unchecked")
    Map<String, String> dto = (Map<String, String>) _dto;

    AtomicReference<Optional<String>> defValue =
        new AtomicReference<>(
            dto.entrySet().stream()
                .filter(
                    entry ->
                        entry.getKey().equals(ParameterObjParameterKeyDto.JSON_PROPERTY_DEFAULT))
                .map(Map.Entry::getValue)
                .findFirst());

    dto.forEach(
        (key, value) -> {
          if (!key.equals(ParameterObjParameterKeyDto.JSON_PROPERTY_DEFAULT)) {
            client.add(
                new Entry(parameterName, new Pair<>(key, value), defValue.get().orElse(null)));
            defValue.set(Optional.empty());
          }
        });
    return client;
  }
}
