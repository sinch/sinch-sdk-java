package com.sinch.sdk.domains.voice.models.v1.svaml.action;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import com.sinch.sdk.domains.voice.models.svaml.MenuOptionActionType;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;

/** Menu option action factory helper */
public class MenuOptionActionFactory {

  public static class MenuOptionActionType extends EnumDynamic<String, MenuOptionActionType> {

    /**
     * Triggers a Prompt Input Event (PIE)
     *
     * @see <a
     *     href="https://developers.sinch.com/docs/voice/api-reference/voice/tag/Callbacks/#tag/Callbacks/operation/pie">Prompt
     *     Input Event</a>
     */
    public static final MenuOptionActionType RETURN = new MenuOptionActionType("return");

    /** Navigates to the named menu */
    public static final MenuOptionActionType MENU = new MenuOptionActionType("menu");

    /** */
    private static final EnumSupportDynamic<String, MenuOptionActionType> ENUM_SUPPORT =
        new EnumSupportDynamic<>(
            MenuOptionActionType.class, MenuOptionActionType::new, Arrays.asList(RETURN, MENU));

    private MenuOptionActionType(String value) {
      super(value);
    }

    public static Stream<MenuOptionActionType> values() {
      return ENUM_SUPPORT.values();
    }

    public static MenuOptionActionType from(String value) {
      return ENUM_SUPPORT.from(value);
    }

    public static String valueOf(MenuOptionActionType e) {
      return ENUM_SUPPORT.valueOf(e);
    }
  }

  public static String menuAction(String id) {
    return build(MenuOptionActionType.MENU, id);
  }

  public static String returnAction(String id) {
    return build(MenuOptionActionType.RETURN, id);
  }

  public static String build(MenuOptionActionType type, String id) {
    Objects.requireNonNull(type, "Action type cannot be null");
    return String.format("%s(%s)", type.value(), id);
  }
}
