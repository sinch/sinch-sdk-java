package com.sinch.sdk.domains.voice.models.v2.destination;

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

@JsonPropertyOrder({SipImpl.JSON_PROPERTY_TYPE, SipImpl.JSON_PROPERTY_SIP})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class SipImpl implements Sip, CallDestination {
  private static final long serialVersionUID = 1L;

  /** The type property. Must have the value <code>SIP</code>. */
  public static class TypeEnum extends EnumDynamic<String, TypeEnum> {
    /** The <code>SIP</code> type. */
    public static final TypeEnum SIP = new TypeEnum("SIP");

    private static final EnumSupportDynamic<String, TypeEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(TypeEnum.class, TypeEnum::new, Arrays.asList(SIP));

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

  public static final String JSON_PROPERTY_SIP = "sip";

  private OptionalValue<SipDetails> sip;

  public SipImpl() {}

  protected SipImpl(OptionalValue<TypeEnum> type, OptionalValue<SipDetails> sip) {
    this.type = type;
    this.sip = sip;
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
  public SipDetails getSip() {
    return sip.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SIP)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<SipDetails> sip() {
    return sip;
  }

  /** Return true if this Sip object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SipImpl sip = (SipImpl) o;
    return Objects.equals(this.type, sip.type) && Objects.equals(this.sip, sip.sip);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, sip);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SipImpl {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    sip: ").append(toIndentedString(sip)).append("\n");
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
  static class Builder implements Sip.Builder {
    OptionalValue<TypeEnum> type = OptionalValue.of(TypeEnum.SIP);
    OptionalValue<SipDetails> sip = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_TYPE, required = true)
    Builder setType(TypeEnum type) {
      if (!Objects.equals(type, TypeEnum.SIP)) {
        throw new IllegalArgumentException(
            String.format("'type' must be '%s' (is '%s')", TypeEnum.SIP, type));
      }
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_SIP, required = true)
    public Builder setSip(SipDetails sip) {
      this.sip = OptionalValue.of(sip);
      return this;
    }

    public Sip build() {
      return new SipImpl(type, sip);
    }
  }
}
