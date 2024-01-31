package com.sinch.sdk.domains.voice.adapters.converters;

import com.sinch.sdk.domains.common.adapters.converters.EnumDynamicConverter;
import com.sinch.sdk.domains.voice.models.ApplicationAssignedNumber;
import com.sinch.sdk.domains.voice.models.ApplicationURL;
import com.sinch.sdk.domains.voice.models.CallbackUrls;
import com.sinch.sdk.domains.voice.models.NumberInformation;
import com.sinch.sdk.domains.voice.models.dto.v1.CallbacksDto;
import com.sinch.sdk.domains.voice.models.dto.v1.CallbacksUrlDto;
import com.sinch.sdk.domains.voice.models.dto.v1.GetNumbersResponseObjDto;
import com.sinch.sdk.domains.voice.models.dto.v1.GetNumbersResponseObjNumbersInnerDto;
import com.sinch.sdk.domains.voice.models.dto.v1.GetQueryNumberDto;
import com.sinch.sdk.domains.voice.models.dto.v1.GetQueryNumberNumberDto;
import com.sinch.sdk.domains.voice.models.dto.v1.UnassignNumbersDto;
import com.sinch.sdk.domains.voice.models.dto.v1.UpdateNumbersDto;
import com.sinch.sdk.domains.voice.models.requests.ApplicationsUpdateNumbersRequestParameters;
import com.sinch.sdk.domains.voice.models.response.AssignedNumbers;
import com.sinch.sdk.models.E164PhoneNumber;
import java.util.List;
import java.util.stream.Collectors;

public class ApplicationsDtoConverter {

  public static AssignedNumbers convert(GetNumbersResponseObjDto dto) {
    if (null == dto) {
      return null;
    }
    List<GetNumbersResponseObjNumbersInnerDto> list = dto.getNumbers();
    if (null == list) {
      return null;
    }
    return AssignedNumbers.builder()
        .setNumbers(
            list.stream().map(ApplicationsDtoConverter::convert).collect(Collectors.toList()))
        .build();
  }

  public static CallbackUrls convert(CallbacksDto dto) {
    if (null == dto) {
      return null;
    }

    return CallbackUrls.builder().setUrl(convert(dto.getUrl())).build();
  }

  public static CallbacksDto convert(CallbackUrls client) {
    if (null == client || null == client.getUrl()) {
      return null;
    }
    CallbacksDto dto = new CallbacksDto();
    dto.url(
        new CallbacksUrlDto()
            .primary(client.getUrl().getPrimary())
            .fallback(client.getUrl().getFallback()));
    return dto;
  }

  public static NumberInformation convert(GetQueryNumberDto dto) {
    if (null == dto || !dto.getNumberDefined()) {
      return null;
    }
    GetQueryNumberNumberDto item = dto.getNumber();
    return NumberInformation.builder()
        .setCountryId(item.getCountryId())
        .setNumberType(NumberTypeDtoConverter.convert(item.getNumberType()))
        .setNormalizedNumber(E164PhoneNumberDtoConverter.convert(item.getNormalizedNumber()))
        .setRestricted(item.getRestricted())
        .setRate(PriceDtoConverter.convert(item.getRate()))
        .build();
  }

  public static UpdateNumbersDto convert(ApplicationsUpdateNumbersRequestParameters client) {
    if (null == client) {
      return null;
    }
    UpdateNumbersDto dto = new UpdateNumbersDto();
    client
        .getNumbers()
        .ifPresent(
            f ->
                dto.numbers(
                    f.stream().map(E164PhoneNumber::stringValue).collect(Collectors.toList())));
    client.getApplicationKey().ifPresent(dto::applicationkey);
    client.getCapability().ifPresent(f -> dto.capability(EnumDynamicConverter.convert(f)));
    return dto;
  }

  public static UnassignNumbersDto convert(E164PhoneNumber phoneNumber, String applicationKey) {

    UnassignNumbersDto dto = new UnassignNumbersDto();
    if (null != phoneNumber) {
      dto.number(phoneNumber.stringValue());
    }
    dto.applicationkey(applicationKey);
    return dto;
  }

  private static ApplicationURL convert(CallbacksUrlDto dto) {
    if (null == dto) {
      return null;
    }

    return ApplicationURL.builder()
        .setPrimary(dto.getPrimary())
        .setFallback(dto.getFallback())
        .build();
  }

  private static ApplicationAssignedNumber convert(GetNumbersResponseObjNumbersInnerDto dto) {
    if (null == dto) {
      return null;
    }

    return ApplicationAssignedNumber.builder()
        .setNumber(E164PhoneNumberDtoConverter.convert(dto.getNumber()))
        .setApplicationKey(dto.getApplicationkey())
        .setCapability(CapabilityDtoConverter.convert(dto.getCapability()))
        .build();
  }
}
