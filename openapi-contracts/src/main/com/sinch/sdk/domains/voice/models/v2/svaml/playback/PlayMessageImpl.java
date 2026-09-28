package com.sinch.sdk.domains.voice.models.v2.svaml.playback;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.Objects;

@JsonPropertyOrder({PlayMessageImpl.JSON_PROPERTY_TYPE, PlayMessageImpl.JSON_PROPERTY_PLAY})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class PlayMessageImpl implements PlayMessage, Message {
  private static final long serialVersionUID = 1L;

  /** The type property. Must have the value <code>PLAY</code>. */
  public static class TypeEnum extends EnumDynamic<String, TypeEnum> {
    /** The <code>PLAY</code> type. */
    public static final TypeEnum PLAY = new TypeEnum("PLAY");

    private static final EnumSupportDynamic<String, TypeEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(TypeEnum.class, TypeEnum::new, Arrays.asList(PLAY));

    private TypeEnum(String value) {
      super(value);
    }

    public static java.util.stream.Stream<TypeEnum> values() {
      return ENUM_SUPPORT.values();
    }

    public static TypeEnum from(String value) {
      return ENUM_SUPPORT.from(value);
    }

    public static String valueOf(TypeEnum e) {
      return ENUM_SUPPORT.valueOf(e);
    }
  }

  public static final String JSON_PROPERTY_TYPE = "type";

  private OptionalValue<TypeEnum> type;

  public static final String JSON_PROPERTY_PLAY = "play";

  private OptionalValue<Play> play;

  public PlayMessageImpl() {}

  protected PlayMessageImpl(OptionalValue<TypeEnum> type, OptionalValue<Play> play) {
    this.type = type;
    this.play = play;
  }

  @JsonIgnore
  public TypeEnum getType() {
    return type.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<TypeEnum> type() {
    return type;
  }

  @JsonIgnore
  public Play getPlay() {
    return play.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PLAY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<Play> play() {
    return play;
  }

  /** Return true if this PlayMessage object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PlayMessageImpl playMessage = (PlayMessageImpl) o;
    return Objects.equals(this.type, playMessage.type)
        && Objects.equals(this.play, playMessage.play);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, play);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PlayMessageImpl {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    play: ").append(toIndentedString(play)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

  @JsonPOJOBuilder(withPrefix = "set")
  static class Builder implements PlayMessage.Builder {
    OptionalValue<TypeEnum> type = OptionalValue.of(TypeEnum.PLAY);
    OptionalValue<Play> play = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_TYPE, required = true)
    Builder setType(TypeEnum type) {
      if (!Objects.equals(type, TypeEnum.PLAY)) {
        throw new IllegalArgumentException(
            String.format("'type' must be '%s' (is '%s')", TypeEnum.PLAY, type));
      }
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_PLAY, required = true)
    public Builder setPlay(Play play) {
      this.play = OptionalValue.of(play);
      return this;
    }

    public PlayMessage build() {
      return new PlayMessageImpl(type, play);
    }
  }
}
