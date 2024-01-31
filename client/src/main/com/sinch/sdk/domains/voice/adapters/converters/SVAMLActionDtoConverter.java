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
import com.sinch.sdk.domains.voice.models.svaml.MenuOptionAction;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class SVAMLActionDtoConverter {
  private static final Logger LOGGER = Logger.getLogger(SVAMLActionDtoConverter.class.getName());

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
    client.getConferenceId().ifPresent(dto::setConferenceId);
    client.getMusicOnHold().ifPresent(f -> dto.setMoh(EnumDynamicConverter.convert(f)));
    client.getDtfmOptions().ifPresent(f -> dto.setConferenceDtmfOptions(convert(f)));
    return dto;
  }

  private static SvamlActionConnectMxpDto convertAction(ActionConnectMxp client) {
    if (null == client) {
      return null;
    }
    SvamlActionConnectMxpDto dto = new SvamlActionConnectMxpDto();
    dto.setName(SvamlActionConnectMxpDto.NameEnum.CONNECTMXP.getValue());
    client.getDestination().ifPresent(f -> dto.setDestination(DestinationDtoConverter.convert(f)));
    client.getCallheaders().ifPresent(f -> dto.setCallheaders(convertHeaderCollection(f)));
    return dto;
  }

  private static SvamlActionConnectPstnDto convertAction(ActionConnectPstn client) {
    if (null == client) {
      return null;
    }
    SvamlActionConnectPstnDto dto = new SvamlActionConnectPstnDto();
    dto.setName(SvamlActionConnectPstnDto.NameEnum.CONNECTPSTN.getValue());
    client.getNumber().ifPresent(f -> dto.setNumber(E164PhoneNumberDtoConverter.convert(f)));
    client.getLocale().ifPresent(dto::setLocale);
    client.getMaxDuration().ifPresent(dto::setMaxDuration);
    client.getDialTimeout().ifPresent(dto::setDialTimeout);
    client.getCli().ifPresent(dto::setCli);
    client.getSuppressCallbacks().ifPresent(dto::setSuppressCallbacks);
    client
        .getDualToneMultiFrequency()
        .ifPresent(f -> dto.setDtmf(DualToneMultiFrequencyDtoConverter.convert(f)));
    client.getIndications().ifPresent(f -> dto.setIndications(EnumDynamicConverter.convert(f)));
    client.getAnsweringMachineDetection().ifPresent(f -> dto.setAmd(convert(f)));
    return dto;
  }

  private static SvamlActionConnectSipDto convertAction(ActionConnectSip client) {
    if (null == client) {
      return null;
    }
    SvamlActionConnectSipDto dto = new SvamlActionConnectSipDto();
    dto.setName(SvamlActionConnectSipDto.NameEnum.CONNECTSIP.getValue());
    client.getDestination().ifPresent(f -> dto.setDestination(DestinationDtoConverter.convert(f)));
    client.getMaxDuration().ifPresent(dto::setMaxDuration);
    client.getCli().ifPresent(dto::setCli);
    client.getTransport().ifPresent(f -> dto.setTransport(EnumDynamicConverter.convert(f)));
    client.getSuppressCallbacks().ifPresent(dto::setSuppressCallbacks);
    client.getCallHeaders().ifPresent(f -> dto.setCallHeaders(convertHeaderCollection(f)));
    client.getMusicOnHold().ifPresent(f -> dto.setMoh(EnumDynamicConverter.convert(f)));
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
    client.getLocale().ifPresent(dto::setLocale);
    client.getIntroPrompt().ifPresent(dto::setIntroPrompt);
    client.getHoldPrompt().ifPresent(dto::setHoldPrompt);
    client.getMaxDuration().ifPresent(dto::setMaxDuration);

    return dto;
  }

  private static SvamlActionRunMenuDto convertAction(ActionRunMenu client) {
    if (null == client) {
      return null;
    }
    SvamlActionRunMenuDto dto = new SvamlActionRunMenuDto();
    dto.setName(SvamlActionRunMenuDto.NameEnum.RUNMENU.getValue());
    client.getBarge().ifPresent(dto::setBarge);
    client.getLocale().ifPresent(dto::setLocale);
    client.getMainMenu().ifPresent(dto::setMainMenu);
    client.getEnableVoice().ifPresent(dto::setEnableVoice);
    client.getMenus().ifPresent(f -> dto.setMenus(convertMenuCollection(f)));
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

    client.getEnabled().ifPresent(dto::setEnabled);
    return dto;
  }

  private static List<MenuDto> convertMenuCollection(Collection<Menu> client) {
    if (null == client) {
      return null;
    }
    return client.stream().map(SVAMLActionDtoConverter::convert).collect(Collectors.toList());
  }

  private static MenuDto convert(Menu client) {
    if (null == client) {
      return null;
    }
    MenuDto dto = new MenuDto();

    client.getId().ifPresent(dto::setId);
    client.getMainPrompt().ifPresent(dto::setMainPrompt);
    client.getRepeatPrompt().ifPresent(dto::setRepeatPrompt);
    client.getRepeats().ifPresent(dto::setRepeats);
    client.getMaxDigits().ifPresent(dto::setMaxDigits);
    client.getTimeoutMills().ifPresent(dto::setTimeoutMills);
    client.getMaxTimeoutMills().ifPresent(dto::setMaxTimeoutMills);
    client.getOptions().ifPresent(f -> dto.setOptions(convertMenuOptionCollection(f)));
    return dto;
  }

  private static List<OptionDto> convertMenuOptionCollection(Collection<MenuOption> client) {
    if (null == client) {
      return null;
    }
    return client.stream()
        .map(
            f -> {
              OptionDto dto = new OptionDto();
              f.getAction().ifPresent(f2 -> dto.action(convert(f2)));
              f.getDtfm().ifPresent(f2 -> dto.dtmf(DualToneMultiFrequencyDtoConverter.convert(f2)));
              return dto;
            })
        .collect(Collectors.toList());
  }

  private static String convert(MenuOptionAction client) {
    if (null == client || null == client.getType()) {
      return null;
    }
    return String.format("%s(%s)", client.getType().value(), client.getId());
  }
}
