/*
 * Voice API | Sinch
 *
 * OpenAPI document version: 1.0.1
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.voice.models.v1.webhooks;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/** An object containing information about the returned menu result. */
@JsonDeserialize(builder = MenuResultImpl.Builder.class)
public interface MenuResult {

  /**
   * The ID of the menu that triggered the prompt input event.
   *
   * @return menuId
   */
  String getMenuId();

  /** The type of information that's returned. */
  public class TypeEnum extends EnumDynamic<String, TypeEnum> {
    public static final TypeEnum ERROR = new TypeEnum("error");
    public static final TypeEnum RETURN = new TypeEnum("return");
    public static final TypeEnum SEQUENCE = new TypeEnum("sequence");
    public static final TypeEnum TIMEOUT = new TypeEnum("timeout");
    public static final TypeEnum HANGUP = new TypeEnum("hangup");
    public static final TypeEnum INVALIDINPUT = new TypeEnum("invalidinput");

    private static final EnumSupportDynamic<String, TypeEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(
            TypeEnum.class,
            TypeEnum::new,
            Arrays.asList(ERROR, RETURN, SEQUENCE, TIMEOUT, HANGUP, INVALIDINPUT));

    private TypeEnum(String value) {
      super(value);
    }

    public static Stream<TypeEnum> values() {
      return ENUM_SUPPORT.values();
    }

    public static TypeEnum from(String value) {
      return ENUM_SUPPORT.from(value);
    }

    public static String valueOf(TypeEnum e) {
      return ENUM_SUPPORT.valueOf(e);
    }
  }

  /**
   * The type of information that's returned.
   *
   * @return type
   */
  TypeEnum getType();

  /**
   * The value of the returned information.
   *
   * @return value
   */
  String getValue();

  /** The type of input received. */
  public class InputMethodEnum extends EnumDynamic<String, InputMethodEnum> {
    public static final InputMethodEnum DTMF = new InputMethodEnum("dtmf");
    public static final InputMethodEnum VOICE = new InputMethodEnum("voice");

    private static final EnumSupportDynamic<String, InputMethodEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(
            InputMethodEnum.class, InputMethodEnum::new, Arrays.asList(DTMF, VOICE));

    private InputMethodEnum(String value) {
      super(value);
    }

    public static Stream<InputMethodEnum> values() {
      return ENUM_SUPPORT.values();
    }

    public static InputMethodEnum from(String value) {
      return ENUM_SUPPORT.from(value);
    }

    public static String valueOf(InputMethodEnum e) {
      return ENUM_SUPPORT.valueOf(e);
    }
  }

  /**
   * The type of input received.
   *
   * @return inputMethod
   */
  InputMethodEnum getInputMethod();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new MenuResultImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param menuId see getter
     * @return Current builder
     * @see #getMenuId
     */
    Builder setMenuId(String menuId);

    /**
     * see getter
     *
     * @param type see getter
     * @return Current builder
     * @see #getType
     */
    Builder setType(TypeEnum type);

    /**
     * see getter
     *
     * @param value see getter
     * @return Current builder
     * @see #getValue
     */
    Builder setValue(String value);

    /**
     * see getter
     *
     * @param inputMethod see getter
     * @return Current builder
     * @see #getInputMethod
     */
    Builder setInputMethod(InputMethodEnum inputMethod);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    MenuResult build();
  }
}