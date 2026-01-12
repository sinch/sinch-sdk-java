package com.sinch.sdk.domains.numbers.models.v1.numberorder.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.numbers.models.v1.NumberType;
import com.sinch.sdk.domains.numbers.models.v1.numberorder.OrderSmsConfiguration;
import com.sinch.sdk.domains.numbers.models.v1.numberorder.OrderVoiceConfiguration;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  NumberOrderImpl.JSON_PROPERTY_PROJECT_ID,
  NumberOrderImpl.JSON_PROPERTY_ID_NUMBER_ORDER,
  NumberOrderImpl.JSON_PROPERTY_REGION_CODE,
  NumberOrderImpl.JSON_PROPERTY_STATE,
  NumberOrderImpl.JSON_PROPERTY_NUMBER_TYPE,
  NumberOrderImpl.JSON_PROPERTY_ORDER_NUMBERS,
  NumberOrderImpl.JSON_PROPERTY_SMS_CONFIGURATION,
  NumberOrderImpl.JSON_PROPERTY_VOICE_CONFIGURATION,
  NumberOrderImpl.JSON_PROPERTY_EXPIRE_TIME,
  NumberOrderImpl.JSON_PROPERTY_CREATE_TIME,
  NumberOrderImpl.JSON_PROPERTY_UPDATE_TIME
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class NumberOrderImpl implements NumberOrder {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_PROJECT_ID = "projectId";

  private OptionalValue<String> projectId;

  public static final String JSON_PROPERTY_ID_NUMBER_ORDER = "idNumberOrder";

  private OptionalValue<String> idNumberOrder;

  public static final String JSON_PROPERTY_REGION_CODE = "regionCode";

  private OptionalValue<String> regionCode;

  public static final String JSON_PROPERTY_STATE = "state";

  private OptionalValue<NumberOrderState> state;

  public static final String JSON_PROPERTY_NUMBER_TYPE = "numberType";

  private OptionalValue<NumberType> numberType;

  public static final String JSON_PROPERTY_ORDER_NUMBERS = "orderNumbers";

  private OptionalValue<List<OrderNumber>> orderNumbers;

  public static final String JSON_PROPERTY_SMS_CONFIGURATION = "smsConfiguration";

  private OptionalValue<OrderSmsConfiguration> smsConfiguration;

  public static final String JSON_PROPERTY_VOICE_CONFIGURATION = "voiceConfiguration";

  private OptionalValue<OrderVoiceConfiguration> voiceConfiguration;

  public static final String JSON_PROPERTY_EXPIRE_TIME = "expireTime";

  private OptionalValue<Instant> expireTime;

  public static final String JSON_PROPERTY_CREATE_TIME = "createTime";

  private OptionalValue<Instant> createTime;

  public static final String JSON_PROPERTY_UPDATE_TIME = "updateTime";

  private OptionalValue<Instant> updateTime;

  public NumberOrderImpl() {}

  protected NumberOrderImpl(
      OptionalValue<String> projectId,
      OptionalValue<String> idNumberOrder,
      OptionalValue<String> regionCode,
      OptionalValue<NumberOrderState> state,
      OptionalValue<NumberType> numberType,
      OptionalValue<List<OrderNumber>> orderNumbers,
      OptionalValue<OrderSmsConfiguration> smsConfiguration,
      OptionalValue<OrderVoiceConfiguration> voiceConfiguration,
      OptionalValue<Instant> expireTime,
      OptionalValue<Instant> createTime,
      OptionalValue<Instant> updateTime) {
    this.projectId = projectId;
    this.idNumberOrder = idNumberOrder;
    this.regionCode = regionCode;
    this.state = state;
    this.numberType = numberType;
    this.orderNumbers = orderNumbers;
    this.smsConfiguration = smsConfiguration;
    this.voiceConfiguration = voiceConfiguration;
    this.expireTime = expireTime;
    this.createTime = createTime;
    this.updateTime = updateTime;
  }

  @JsonIgnore
  public String getProjectId() {
    return projectId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PROJECT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> projectId() {
    return projectId;
  }

  @JsonIgnore
  public String getIdNumberOrder() {
    return idNumberOrder.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ID_NUMBER_ORDER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> idNumberOrder() {
    return idNumberOrder;
  }

  @JsonIgnore
  public String getRegionCode() {
    return regionCode.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_REGION_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> regionCode() {
    return regionCode;
  }

  @JsonIgnore
  public NumberOrderState getState() {
    return state.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_STATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<NumberOrderState> state() {
    return state;
  }

  @JsonIgnore
  public NumberType getNumberType() {
    return numberType.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_NUMBER_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<NumberType> numberType() {
    return numberType;
  }

  @JsonIgnore
  public List<OrderNumber> getOrderNumbers() {
    return orderNumbers.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ORDER_NUMBERS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<OrderNumber>> orderNumbers() {
    return orderNumbers;
  }

  @JsonIgnore
  public OrderSmsConfiguration getSmsConfiguration() {
    return smsConfiguration.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SMS_CONFIGURATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<OrderSmsConfiguration> smsConfiguration() {
    return smsConfiguration;
  }

  @JsonIgnore
  public OrderVoiceConfiguration getVoiceConfiguration() {
    return voiceConfiguration.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_VOICE_CONFIGURATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<OrderVoiceConfiguration> voiceConfiguration() {
    return voiceConfiguration;
  }

  @JsonIgnore
  public Instant getExpireTime() {
    return expireTime.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_EXPIRE_TIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Instant> expireTime() {
    return expireTime;
  }

  @JsonIgnore
  public Instant getCreateTime() {
    return createTime.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CREATE_TIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Instant> createTime() {
    return createTime;
  }

  @JsonIgnore
  public Instant getUpdateTime() {
    return updateTime.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_UPDATE_TIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Instant> updateTime() {
    return updateTime;
  }

  /** Return true if this NumberOrder object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NumberOrderImpl numberOrder = (NumberOrderImpl) o;
    return Objects.equals(this.projectId, numberOrder.projectId)
        && Objects.equals(this.idNumberOrder, numberOrder.idNumberOrder)
        && Objects.equals(this.regionCode, numberOrder.regionCode)
        && Objects.equals(this.state, numberOrder.state)
        && Objects.equals(this.numberType, numberOrder.numberType)
        && Objects.equals(this.orderNumbers, numberOrder.orderNumbers)
        && Objects.equals(this.smsConfiguration, numberOrder.smsConfiguration)
        && Objects.equals(this.voiceConfiguration, numberOrder.voiceConfiguration)
        && Objects.equals(this.expireTime, numberOrder.expireTime)
        && Objects.equals(this.createTime, numberOrder.createTime)
        && Objects.equals(this.updateTime, numberOrder.updateTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        projectId,
        idNumberOrder,
        regionCode,
        state,
        numberType,
        orderNumbers,
        smsConfiguration,
        voiceConfiguration,
        expireTime,
        createTime,
        updateTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NumberOrderImpl {\n");
    sb.append("    projectId: ").append(toIndentedString(projectId)).append("\n");
    sb.append("    idNumberOrder: ").append(toIndentedString(idNumberOrder)).append("\n");
    sb.append("    regionCode: ").append(toIndentedString(regionCode)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    numberType: ").append(toIndentedString(numberType)).append("\n");
    sb.append("    orderNumbers: ").append(toIndentedString(orderNumbers)).append("\n");
    sb.append("    smsConfiguration: ").append(toIndentedString(smsConfiguration)).append("\n");
    sb.append("    voiceConfiguration: ").append(toIndentedString(voiceConfiguration)).append("\n");
    sb.append("    expireTime: ").append(toIndentedString(expireTime)).append("\n");
    sb.append("    createTime: ").append(toIndentedString(createTime)).append("\n");
    sb.append("    updateTime: ").append(toIndentedString(updateTime)).append("\n");
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
  static class Builder implements NumberOrder.Builder {
    OptionalValue<String> projectId = OptionalValue.empty();
    OptionalValue<String> idNumberOrder = OptionalValue.empty();
    OptionalValue<String> regionCode = OptionalValue.empty();
    OptionalValue<NumberOrderState> state = OptionalValue.empty();
    OptionalValue<NumberType> numberType = OptionalValue.empty();
    OptionalValue<List<OrderNumber>> orderNumbers = OptionalValue.empty();
    OptionalValue<OrderSmsConfiguration> smsConfiguration = OptionalValue.empty();
    OptionalValue<OrderVoiceConfiguration> voiceConfiguration = OptionalValue.empty();
    OptionalValue<Instant> expireTime = OptionalValue.empty();
    OptionalValue<Instant> createTime = OptionalValue.empty();
    OptionalValue<Instant> updateTime = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_PROJECT_ID)
    public Builder setProjectId(String projectId) {
      this.projectId = OptionalValue.of(projectId);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_ID_NUMBER_ORDER)
    public Builder setIdNumberOrder(String idNumberOrder) {
      this.idNumberOrder = OptionalValue.of(idNumberOrder);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_REGION_CODE)
    public Builder setRegionCode(String regionCode) {
      this.regionCode = OptionalValue.of(regionCode);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_STATE)
    public Builder setState(NumberOrderState state) {
      this.state = OptionalValue.of(state);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_NUMBER_TYPE)
    public Builder setNumberType(NumberType numberType) {
      this.numberType = OptionalValue.of(numberType);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_ORDER_NUMBERS)
    public Builder setOrderNumbers(List<OrderNumber> orderNumbers) {
      this.orderNumbers = OptionalValue.of(orderNumbers);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_SMS_CONFIGURATION)
    public Builder setSmsConfiguration(OrderSmsConfiguration smsConfiguration) {
      this.smsConfiguration = OptionalValue.of(smsConfiguration);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_VOICE_CONFIGURATION)
    public Builder setVoiceConfiguration(OrderVoiceConfiguration voiceConfiguration) {
      this.voiceConfiguration = OptionalValue.of(voiceConfiguration);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_EXPIRE_TIME)
    public Builder setExpireTime(Instant expireTime) {
      this.expireTime = OptionalValue.of(expireTime);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CREATE_TIME)
    public Builder setCreateTime(Instant createTime) {
      this.createTime = OptionalValue.of(createTime);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_UPDATE_TIME)
    public Builder setUpdateTime(Instant updateTime) {
      this.updateTime = OptionalValue.of(updateTime);
      return this;
    }

    public NumberOrder build() {
      return new NumberOrderImpl(
          projectId,
          idNumberOrder,
          regionCode,
          state,
          numberType,
          orderNumbers,
          smsConfiguration,
          voiceConfiguration,
          expireTime,
          createTime,
          updateTime);
    }
  }
}
