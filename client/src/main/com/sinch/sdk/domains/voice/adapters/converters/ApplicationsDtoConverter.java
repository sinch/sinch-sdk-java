package com.sinch.sdk.domains.voice.adapters.converters;

import com.sinch.sdk.domains.common.adapters.converters.EnumDynamicConverter;
import com.sinch.sdk.domains.voice.models.ApplicationAssignedNumber;
import com.sinch.sdk.domains.voice.models.ApplicationURL;
import com.sinch.sdk.domains.voice.models.CallbackUrls;
import com.sinch.sdk.domains.voice.models.NumberInformation;
import com.sinch.sdk.domains.voice.models.requests.ApplicationsAssignNumbersRequestParameters;
import com.sinch.sdk.domains.voice.models.response.AssignedNumbers;
import com.sinch.sdk.domains.voice.models.v1.applications.Callbacks;
import com.sinch.sdk.domains.voice.models.v1.applications.CallbacksUrl;
import com.sinch.sdk.domains.voice.models.v1.applications.Capability;
import com.sinch.sdk.domains.voice.models.v1.applications.request.UnAssignNumberRequest;
import com.sinch.sdk.domains.voice.models.v1.applications.request.UpdateNumbersRequest;
import com.sinch.sdk.domains.voice.models.v1.applications.response.OwnedNumberInformation;
import com.sinch.sdk.domains.voice.models.v1.applications.response.OwnedNumbersResponse;
import com.sinch.sdk.domains.voice.models.v1.applications.response.QueryNumberInformation;
import com.sinch.sdk.domains.voice.models.v1.applications.response.QueryNumberResponse;
import com.sinch.sdk.models.E164PhoneNumber;
import java.util.List;
import java.util.stream.Collectors;

public class ApplicationsDtoConverter {

  public static AssignedNumbers convert(OwnedNumbersResponse dto) {
    if (null == dto) {
      return null;
    }
    List<OwnedNumberInformation> list = dto.getNumbers();
    if (null == list) {
      return null;
    }
    return AssignedNumbers.builder()
        .setNumbers(
            list.stream().map(ApplicationsDtoConverter::convert).collect(Collectors.toList()))
        .build();
  }

  public static CallbackUrls convert(Callbacks dto) {
    if (null == dto) {
      return null;
    }

    return CallbackUrls.builder().setUrl(convert(dto.getUrl())).build();
  }

  public static Callbacks convert(CallbackUrls client) {
    if (null == client || null == client.getUrl()) {
      return null;
    }
    return Callbacks.builder()
        .setUrl(
            CallbacksUrl.builder()
                .setPrimary(client.getUrl().getPrimary())
                .setFallback(client.getUrl().getFallback())
                .build())
        .build();
  }

  public static NumberInformation convert(QueryNumberResponse dto) {
    if (null == dto) {
      return null;
    }
    NumberInformation.Builder builder = NumberInformation.builder();
    QueryNumberInformation item = dto.getNumber();
    if (null == item) {
      return builder.build();
    }

    return builder
        .setCountryId(item.getCountryId())
        .setNumberType(NumberTypeDtoConverter.convert(item.getNumberType()))
        .setNormalizedNumber(E164PhoneNumberDtoConverter.convert(item.getNormalizedNumber()))
        .setRestricted(item.getRestricted())
        .setRate(PriceDtoConverter.convert(item.getRate()))
        .build();
  }

  public static UpdateNumbersRequest convert(ApplicationsAssignNumbersRequestParameters client) {
    if (null == client) {
      return null;
    }
    UpdateNumbersRequest.Builder dto = UpdateNumbersRequest.builder();
    client
        .getNumbers()
        .ifPresent(
            f ->
                dto.setNumbers(
                    f.stream().map(E164PhoneNumber::stringValue).collect(Collectors.toList())));
    client.getApplicationKey().ifPresent(dto::setApplicationKey);
    client
        .getCapability()
        .ifPresent(f -> dto.setCapability(Capability.from(EnumDynamicConverter.convert(f))));
    return dto.build();
  }

  public static UnAssignNumberRequest convert(E164PhoneNumber phoneNumber, String applicationKey) {

    UnAssignNumberRequest.Builder dto = UnAssignNumberRequest.builder();
    if (null != phoneNumber) {
      dto.setNumber(phoneNumber.stringValue());
    }
    dto.setApplicationKey(applicationKey);
    return dto.build();
  }

  private static ApplicationURL convert(CallbacksUrl dto) {
    if (null == dto) {
      return null;
    }

    return ApplicationURL.builder()
        .setPrimary(dto.getPrimary())
        .setFallback(dto.getFallback())
        .build();
  }

  private static ApplicationAssignedNumber convert(OwnedNumberInformation dto) {
    if (null == dto) {
      return null;
    }

    return ApplicationAssignedNumber.builder()
        .setNumber(E164PhoneNumberDtoConverter.convert(dto.getNumber()))
        .setApplicationKey(dto.getApplicationKey())
        .setCapability(CapabilityDtoConverter.convert(dto.getCapability()))
        .build();
  }
}
