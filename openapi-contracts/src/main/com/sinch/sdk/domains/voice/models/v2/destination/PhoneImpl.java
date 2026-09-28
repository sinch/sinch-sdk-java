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
import com.sinch.sdk.domains.voice.models.v2.destination.internal.PhoneInternal;
import java.util.Arrays;
import java.util.Objects;

@JsonPropertyOrder({PhoneImpl.JSON_PROPERTY_TYPE, PhoneImpl.JSON_PROPERTY_PHONE})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class PhoneImpl implements Phone, CallOrigin, CallDestination {
  private static final long serialVersionUID = 1L;

  /** The type property. Must have the value <code>PHONE</code>. */
  public static class TypeEnum extends EnumDynamic<String, TypeEnum> {
    /** The <code>PHONE</code> type. */
    public static final TypeEnum PHONE = new TypeEnum("PHONE");

    private static final EnumSupportDynamic<String, TypeEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(TypeEnum.class, TypeEnum::new, Arrays.asList(PHONE));

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

  public static final String JSON_PROPERTY_PHONE = "phone";

  private OptionalValue<PhoneInternal> phone;

  public PhoneImpl() {}

  protected PhoneImpl(OptionalValue<TypeEnum> type, OptionalValue<PhoneInternal> phone) {
    this.type = type;
    this.phone = phone;
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
  public PhoneInternal getPhone() {
    return phone.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PHONE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<PhoneInternal> phone() {
    return phone;
  }

  @JsonIgnore
  public String getNumber() {
    if (null == phone || !phone.isPresent() || null == phone.get().getNumber()) {
      return null;
    }
    return phone.get().getNumber();
  }

  /** Return true if this Phone object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PhoneImpl phone = (PhoneImpl) o;
    return Objects.equals(this.type, phone.type) && Objects.equals(this.phone, phone.phone);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, phone);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PhoneImpl {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
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
  static class Builder implements Phone.Builder {
    OptionalValue<TypeEnum> type = OptionalValue.of(TypeEnum.PHONE);
    OptionalValue<PhoneInternal> phone = OptionalValue.empty();

    PhoneInternal.Builder _delegatedBuilder = null;

    @JsonProperty(value = JSON_PROPERTY_TYPE, required = true)
    Builder setType(TypeEnum type) {
      if (!Objects.equals(type, TypeEnum.PHONE)) {
        throw new IllegalArgumentException(
            String.format("'type' must be '%s' (is '%s')", TypeEnum.PHONE, type));
      }
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_PHONE, required = true)
    public Builder setPhone(PhoneInternal phone) {
      this.phone = OptionalValue.of(phone);
      return this;
    }

    @JsonIgnore
    public Builder setNumber(String number) {
      getDelegatedBuilder().setNumber(number);
      return this;
    }

    private PhoneInternal.Builder getDelegatedBuilder() {
      if (null == _delegatedBuilder) {
        this._delegatedBuilder = PhoneInternal.builder();
      }
      return this._delegatedBuilder;
    }

    public Phone build() {
      // delegated builder was used: filling the related source of delegation field
      if (null != this._delegatedBuilder) {
        this.phone = OptionalValue.of(this._delegatedBuilder.build());
      }
      return new PhoneImpl(type, phone);
    }
  }
}
