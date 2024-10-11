package com.sinch.sdk.domains.voice.adapters.converters;

import com.sinch.sdk.core.utils.Pair;
import com.sinch.sdk.domains.common.adapters.converters.EnumDynamicConverter;
import com.sinch.sdk.domains.voice.models.ConferenceDtfmOptions;
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
import com.sinch.sdk.domains.voice.models.svaml.MenuOptionAction;
import com.sinch.sdk.domains.voice.models.v1.MusicOnHold;
import com.sinch.sdk.domains.voice.models.v1.conferences.ConferenceDtmfOptions;
import com.sinch.sdk.domains.voice.models.v1.svaml.action.CallHeader;
import com.sinch.sdk.domains.voice.models.v1.svaml.action.ConnectPstnAnsweringMachineDetection;
import com.sinch.sdk.domains.voice.models.v1.svaml.action.Menu;
import com.sinch.sdk.domains.voice.models.v1.svaml.action.MenuOption;
import com.sinch.sdk.domains.voice.models.v1.svaml.action.SvamlAction;
import com.sinch.sdk.domains.voice.models.v1.svaml.action.SvamlActionConnectConference;
import com.sinch.sdk.domains.voice.models.v1.svaml.action.SvamlActionConnectMxp;
import com.sinch.sdk.domains.voice.models.v1.svaml.action.SvamlActionConnectPstn;
import com.sinch.sdk.domains.voice.models.v1.svaml.action.SvamlActionConnectPstn.IndicationsEnum;
import com.sinch.sdk.domains.voice.models.v1.svaml.action.SvamlActionConnectSip;
import com.sinch.sdk.domains.voice.models.v1.svaml.action.SvamlActionConnectSip.TransportEnum;
import com.sinch.sdk.domains.voice.models.v1.svaml.action.SvamlActionContinue;
import com.sinch.sdk.domains.voice.models.v1.svaml.action.SvamlActionHangup;
import com.sinch.sdk.domains.voice.models.v1.svaml.action.SvamlActionPark;
import com.sinch.sdk.domains.voice.models.v1.svaml.action.SvamlActionRunMenu;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class SVAMLActionDtoConverter {
  private static final Logger LOGGER = Logger.getLogger(SVAMLActionDtoConverter.class.getName());

  public static SvamlAction convert(Action client) {
    if (null == client) {
      return null;
    }

    SvamlAction convertedDto = null;
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

    return convertedDto;
  }

  private static SvamlActionConnectConference convertAction(ActionConnectConference client) {
    if (null == client) {
      return null;
    }
    SvamlActionConnectConference.Builder dto = SvamlActionConnectConference.builder();
    client.getConferenceId().ifPresent(dto::setConferenceId);
    client
        .getMusicOnHold()
        .ifPresent(f -> dto.setMoh(MusicOnHold.from(EnumDynamicConverter.convert(f))));
    client.getDtfmOptions().ifPresent(f -> dto.setConferenceDtmfOptions(convert(f)));
    return dto.build();
  }

  private static SvamlActionConnectMxp convertAction(ActionConnectMxp client) {
    if (null == client) {
      return null;
    }
    SvamlActionConnectMxp.Builder dto = SvamlActionConnectMxp.builder();
    client.getDestination().ifPresent(f -> dto.setDestination(DestinationDtoConverter.convert(f)));
    client.getCallheaders().ifPresent(f -> dto.setCallheaders(convertHeaderCollection(f)));
    return dto.build();
  }

  private static SvamlActionConnectPstn convertAction(ActionConnectPstn client) {
    if (null == client) {
      return null;
    }
    SvamlActionConnectPstn.Builder dto = SvamlActionConnectPstn.builder();
    client.getNumber().ifPresent(f -> dto.setNumber(E164PhoneNumberDtoConverter.convert(f)));
    client.getLocale().ifPresent(dto::setLocale);
    client.getMaxDuration().ifPresent(dto::setMaxDuration);
    client.getDialTimeout().ifPresent(dto::setDialTimeout);
    client.getCli().ifPresent(dto::setCli);
    client.getSuppressCallbacks().ifPresent(dto::setSuppressCallbacks);
    client.getDualToneMultiFrequency().ifPresent(dto::setDtmf);
    client
        .getIndications()
        .ifPresent(f -> dto.setIndications(IndicationsEnum.from(EnumDynamicConverter.convert(f))));
    client.getAnsweringMachineDetection().ifPresent(f -> dto.setAmd(convert(f)));
    return dto.build();
  }

  private static SvamlActionConnectSip convertAction(ActionConnectSip client) {
    if (null == client) {
      return null;
    }
    SvamlActionConnectSip.Builder dto = SvamlActionConnectSip.builder();
    client.getDestination().ifPresent(f -> dto.setDestination(DestinationDtoConverter.convert(f)));
    client.getMaxDuration().ifPresent(dto::setMaxDuration);
    client.getCli().ifPresent(dto::setCli);
    client
        .getTransport()
        .ifPresent(f -> dto.setTransport(TransportEnum.from(EnumDynamicConverter.convert(f))));
    client.getSuppressCallbacks().ifPresent(dto::setSuppressCallbacks);
    client.getCallHeaders().ifPresent(f -> dto.setCallHeaders(convertHeaderCollection(f)));
    client
        .getMusicOnHold()
        .ifPresent(f -> dto.setMoh(MusicOnHold.from(EnumDynamicConverter.convert(f))));
    return dto.build();
  }

  private static SvamlActionContinue convertAction(ActionContinue client) {
    if (null == client) {
      return null;
    }
    return SvamlActionContinue.DEFAULT;
  }

  private static SvamlActionHangup convertAction(ActionHangUp client) {
    if (null == client) {
      return null;
    }
    return SvamlActionHangup.DEFAULT;
  }

  private static SvamlActionPark convertAction(ActionPark client) {
    if (null == client) {
      return null;
    }
    SvamlActionPark.Builder dto = SvamlActionPark.builder();
    client.getLocale().ifPresent(dto::setLocale);
    client.getIntroPrompt().ifPresent(dto::setIntroPrompt);
    client.getHoldPrompt().ifPresent(dto::setHoldPrompt);
    client.getMaxDuration().ifPresent(dto::setMaxDuration);

    return dto.build();
  }

  private static SvamlActionRunMenu convertAction(ActionRunMenu client) {
    if (null == client) {
      return null;
    }
    SvamlActionRunMenu.Builder dto = SvamlActionRunMenu.builder();
    client.getBarge().ifPresent(dto::setBarge);
    client.getLocale().ifPresent(dto::setLocale);
    client.getMainMenu().ifPresent(dto::setMainMenu);
    client.getEnableVoice().ifPresent(dto::setEnableVoice);
    client.getMenus().ifPresent(f -> dto.setMenus(convertMenuCollection(f)));
    return dto.build();
  }

  private static ConferenceDtmfOptions convert(ConferenceDtfmOptions client) {
    if (null == client) {
      return null;
    }
    ConferenceDtmfOptions.Builder builder = ConferenceDtmfOptions.builder();
    client
        .getMode()
        .ifPresent(
            f ->
                builder.setMode(
                    ConferenceDtmfOptions.ModeEnum.from(EnumDynamicConverter.convert(f))));
    client.getMaxDigits().ifPresent(builder::setMaxDigits);
    client.getTimeoutMills().ifPresent(builder::setTimeoutMills);
    return builder.build();
  }

  private static List<CallHeader> convertHeaderCollection(Collection<Pair<String, String>> client) {
    if (null == client) {
      return null;
    }
    return client.stream()
        .map(f -> CallHeader.builder().setKey(f.getLeft()).setValue(f.getRight()).build())
        .collect(Collectors.toList());
  }

  private static ConnectPstnAnsweringMachineDetection convert(AnsweringMachineDetection client) {
    if (null == client) {
      return null;
    }

    ConnectPstnAnsweringMachineDetection.Builder dto =
        ConnectPstnAnsweringMachineDetection.builder();

    client.getEnabled().ifPresent(dto::setEnabled);
    return dto.build();
  }

  private static List<Menu> convertMenuCollection(
      Collection<com.sinch.sdk.domains.voice.models.svaml.Menu> client) {
    if (null == client) {
      return null;
    }
    return client.stream().map(SVAMLActionDtoConverter::convert).collect(Collectors.toList());
  }

  private static Menu convert(com.sinch.sdk.domains.voice.models.svaml.Menu client) {
    if (null == client) {
      return null;
    }
    Menu.Builder dto = Menu.builder();

    client.getId().ifPresent(dto::setId);
    client.getMainPrompt().ifPresent(dto::setMainPrompt);
    client.getRepeatPrompt().ifPresent(dto::setRepeatPrompt);
    client.getRepeats().ifPresent(dto::setRepeats);
    client.getMaxDigits().ifPresent(dto::setMaxDigits);
    client.getTimeoutMills().ifPresent(dto::setTimeoutMills);
    client.getMaxTimeoutMills().ifPresent(dto::setMaxTimeoutMills);
    client.getOptions().ifPresent(f -> dto.setOptions(convertMenuOptionCollection(f)));
    return dto.build();
  }

  private static List<MenuOption> convertMenuOptionCollection(
      Collection<com.sinch.sdk.domains.voice.models.svaml.MenuOption> client) {
    if (null == client) {
      return null;
    }
    return client.stream()
        .map(
            f -> {
              MenuOption.Builder dto = MenuOption.builder();
              f.getAction().ifPresent(f2 -> dto.setAction(convert(f2)));
              f.getDtfm().ifPresent(dto::setDtmf);
              return dto.build();
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
