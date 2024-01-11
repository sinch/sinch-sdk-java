package com.sinch.sdk.domains.voice.adapters.converters;

import com.sinch.sdk.core.utils.Pair;
import com.sinch.sdk.domains.common.adapters.converters.EnumDynamicConverter;
import com.sinch.sdk.domains.voice.models.ConferenceDtfmOptions;
import com.sinch.sdk.domains.voice.models.dto.v1.CallHeaderDto;
import com.sinch.sdk.domains.voice.models.dto.v1.MenuDto;
import com.sinch.sdk.domains.voice.models.dto.v1.OptionDto;
import com.sinch.sdk.domains.voice.models.dto.v1.SvamlActionConnectConfConferenceDtmfOptionsDto;
import com.sinch.sdk.domains.voice.models.dto.v1.SvamlActionConnectConfDto;
import com.sinch.sdk.domains.voice.models.dto.v1.SvamlActionConnectMxpDto;
import com.sinch.sdk.domains.voice.models.dto.v1.SvamlActionConnectPstnAmdDto;
import com.sinch.sdk.domains.voice.models.dto.v1.SvamlActionConnectPstnDto;
import com.sinch.sdk.domains.voice.models.dto.v1.SvamlActionConnectSipDto;
import com.sinch.sdk.domains.voice.models.dto.v1.SvamlActionContinueDto;
import com.sinch.sdk.domains.voice.models.dto.v1.SvamlActionDto;
import com.sinch.sdk.domains.voice.models.dto.v1.SvamlActionHangupDto;
import com.sinch.sdk.domains.voice.models.dto.v1.SvamlActionParkDto;
import com.sinch.sdk.domains.voice.models.dto.v1.SvamlActionRunMenuDto;
import com.sinch.sdk.domains.voice.models.svaml.Action;
import com.sinch.sdk.domains.voice.models.svaml.ActionConnectConference;
import com.sinch.sdk.domains.voice.models.svaml.ActionConnectMxp;
import com.sinch.sdk.domains.voice.models.svaml.ActionConnectPstn;
import com.sinch.sdk.domains.voice.models.svaml.ActionConnectSip;
import com.sinch.sdk.domains.voice.models.svaml.ActionContinue;
import com.sinch.sdk.domains.voice.models.svaml.ActionHangUp;
import com.sinch.sdk.domains.voice.models.svaml.ActionPark;
import com.sinch.sdk.domains.voice.models.svaml.ActionRunMenu;
import com.sinch.sdk.domains.voice.models.svaml.AnsweringMachineDetection;
import com.sinch.sdk.domains.voice.models.svaml.Menu;
import com.sinch.sdk.domains.voice.models.svaml.MenuOption;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class SAVMLActionDtoConverter {
  private static final Logger LOGGER = Logger.getLogger(SAVMLActionDtoConverter.class.getName());

  public static SvamlActionDto convert(Action client) {
    if (null == client) {
      return null;
    }
    SvamlActionDto dto = new SvamlActionDto();

    Object convertedDto = null;
    if (client instanceof ActionConnectConference) {
      ActionConnectConference typedClient = (ActionConnectConference) client;
      convertedDto = convertAction(typedClient);
    } else if (client instanceof ActionConnectMxp) {
      ActionConnectMxp typedClient = (ActionConnectMxp) client;
      convertedDto = convertAction(typedClient);
    } else if (client instanceof ActionConnectPstn) {
      ActionConnectPstn typedClient = (ActionConnectPstn) client;
      convertedDto = convertAction(typedClient);
    } else if (client instanceof ActionConnectSip) {
      ActionConnectSip typedClient = (ActionConnectSip) client;
      convertedDto = convertAction(typedClient);
    } else if (client instanceof ActionContinue) {
      ActionContinue typedClient = (ActionContinue) client;
      convertedDto = convertAction(typedClient);
    } else if (client instanceof ActionHangUp) {
      ActionHangUp typedClient = (ActionHangUp) client;
      convertedDto = convertAction(typedClient);
    } else if (client instanceof ActionPark) {
      ActionPark typedClient = (ActionPark) client;
      convertedDto = convertAction(typedClient);
    } else if (client instanceof ActionRunMenu) {
      ActionRunMenu typedClient = (ActionRunMenu) client;
      convertedDto = convertAction(typedClient);
    } else {
      LOGGER.severe(String.format("Unexpected class '%s'", client.getClass()));
    }

    dto.setActualInstance(convertedDto);
    return dto;
  }

  private static SvamlActionConnectConfDto convertAction(ActionConnectConference client) {
    if (null == client) {
      return null;
    }
    SvamlActionConnectConfDto dto = new SvamlActionConnectConfDto();
    dto.setName(SvamlActionConnectConfDto.NameEnum.CONNECTCONF.getValue());
    dto.setConferenceId(client.getConferenceId());
    dto.setMoh(EnumDynamicConverter.convert(client.getMoh()));
    dto.setConferenceDtmfOptions(convert(client.getDtfmOptions()));
    return dto;
  }

  private static SvamlActionConnectMxpDto convertAction(ActionConnectMxp client) {
    if (null == client) {
      return null;
    }
    SvamlActionConnectMxpDto dto = new SvamlActionConnectMxpDto();
    dto.setName(SvamlActionConnectMxpDto.NameEnum.CONNECTMXP.getValue());
    dto.setDestination(DestinationDtoConverter.convert(client.getDestination()));
    dto.setCallheaders(convertHeaderCollection(client.getCallheaders()));
    return dto;
  }

  private static SvamlActionConnectPstnDto convertAction(ActionConnectPstn client) {
    if (null == client) {
      return null;
    }
    SvamlActionConnectPstnDto dto = new SvamlActionConnectPstnDto();
    dto.setName(SvamlActionConnectPstnDto.NameEnum.CONNECTPSTN.getValue());
    dto.setNumber(E164PhoneNumberDtoConverter.convert(client.getNumber()));
    dto.setLocale(client.getLocale());
    dto.setMaxDuration(client.getMaxDuration());
    dto.setDialTimeout(client.getDialTimeout());
    dto.setCli(client.getCli());
    dto.setSuppressCallbacks(client.getSuppressCallbacks());
    dto.setDtmf(DualToneMultiFrequencyDtoConverter.convert(client.getDtmf()));
    dto.setIndications(EnumDynamicConverter.convert(client.getIndications()));
    dto.setAmd(convert(client.getAnsweringMachineDetectionEnabled()));
    return dto;
  }

  private static SvamlActionConnectSipDto convertAction(ActionConnectSip client) {
    if (null == client) {
      return null;
    }
    SvamlActionConnectSipDto dto = new SvamlActionConnectSipDto();
    dto.setName(SvamlActionConnectSipDto.NameEnum.CONNECTSIP.getValue());
    dto.setDestination(DestinationDtoConverter.convert(client.getDestination()));
    dto.setMaxDuration(client.getMaxDuration());
    dto.setCli(client.getCli());
    dto.setTransport(EnumDynamicConverter.convert(client.getTransport()));
    dto.setSuppressCallbacks(client.getSuppressCallbacks());
    dto.setCallHeaders(convertHeaderCollection(client.getCallheaders()));
    dto.setMoh(EnumDynamicConverter.convert(client.getMoh()));
    return dto;
  }

  private static SvamlActionContinueDto convertAction(ActionContinue client) {
    if (null == client) {
      return null;
    }
    SvamlActionContinueDto dto = new SvamlActionContinueDto();
    dto.setName(SvamlActionContinueDto.NameEnum.CONTINUE.getValue());
    return dto;
  }

  private static SvamlActionHangupDto convertAction(ActionHangUp client) {
    if (null == client) {
      return null;
    }
    SvamlActionHangupDto dto = new SvamlActionHangupDto();
    dto.setName(SvamlActionHangupDto.NameEnum.HANGUP.getValue());
    return dto;
  }

  private static SvamlActionParkDto convertAction(ActionPark client) {
    if (null == client) {
      return null;
    }
    SvamlActionParkDto dto = new SvamlActionParkDto();
    dto.setName(SvamlActionParkDto.NameEnum.PARK.getValue());
    dto.setLocale(client.getLocale());
    dto.setIntroPrompt(client.getIntroPrompt());
    dto.setHoldPrompt(client.getHoldPrompt());
    dto.setMaxDuration(client.getMaxDuration());
    return dto;
  }

  private static SvamlActionRunMenuDto convertAction(ActionRunMenu client) {
    if (null == client) {
      return null;
    }
    SvamlActionRunMenuDto dto = new SvamlActionRunMenuDto();
    dto.setName(SvamlActionRunMenuDto.NameEnum.RUNMENU.getValue());
    dto.setBarge(client.getBarge());
    dto.setLocale(client.getLocale());
    dto.setMainMenu(client.getMainMenu());
    dto.setEnableVoice(client.getEnableVoice());
    dto.setMenus(convertMenuCollection(client.getMenus()));
    return dto;
  }

  private static SvamlActionConnectConfConferenceDtmfOptionsDto convert(
      ConferenceDtfmOptions client) {
    if (null == client) {
      return null;
    }
    SvamlActionConnectConfConferenceDtmfOptionsDto dto =
        new SvamlActionConnectConfConferenceDtmfOptionsDto();
    client.getMode().ifPresent(f -> dto.setMode(EnumDynamicConverter.convert(f)));
    client.getMaxDigits().ifPresent(dto::setMaxDigits);
    client.getTimeoutMills().ifPresent(dto::setTimeoutMills);
    return dto;
  }

  private static List<CallHeaderDto> convertHeaderCollection(
      Collection<Pair<String, String>> client) {
    if (null == client) {
      return null;
    }
    return client.stream()
        .map(f -> new CallHeaderDto().key(f.getLeft()).value(f.getRight()))
        .collect(Collectors.toList());
  }

  private static SvamlActionConnectPstnAmdDto convert(AnsweringMachineDetection client) {
    if (null == client) {
      return null;
    }

    SvamlActionConnectPstnAmdDto dto = new SvamlActionConnectPstnAmdDto();
    dto.setEnabled(client.getEnabled());
    return dto;
  }

  private static List<MenuDto> convertMenuCollection(Collection<Menu> client) {
    if (null == client) {
      return null;
    }
    return client.stream().map(SAVMLActionDtoConverter::convert).collect(Collectors.toList());
  }

  private static MenuDto convert(Menu client) {
    if (null == client) {
      return null;
    }
    MenuDto dto = new MenuDto();
    dto.setId(client.getId());
    dto.setMainPrompt(client.getMainPrompt());
    dto.setRepeatPrompt(client.getRepeatPrompt());
    dto.setRepeats(client.getRepeats());
    dto.setMaxDigits(client.getMaxDigits());
    dto.setTimeoutMills(client.getTimeoutMills());
    dto.setMaxTimeoutMills(client.getMaxTimeoutMills());
    dto.setOptions(convertMenuOptionCollection(client.getOptions()));
    return dto;
  }

  private static List<OptionDto> convertMenuOptionCollection(Collection<MenuOption> client) {
    if (null == client) {
      return null;
    }
    return client.stream()
        .map(
            f ->
                new OptionDto()
                    .action(EnumDynamicConverter.convert(f.getAction()))
                    .dtmf(DualToneMultiFrequencyDtoConverter.convert(f.getDtfm())))
        .collect(Collectors.toList());
  }
}
