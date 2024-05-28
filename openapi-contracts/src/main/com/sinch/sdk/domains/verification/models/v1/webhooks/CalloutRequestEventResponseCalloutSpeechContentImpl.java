package com.sinch.sdk.domains.verification.models.v1.webhooks;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({CalloutRequestEventResponseCalloutSpeechContentImpl.JSON_PROPERTY_LOCALE})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class CalloutRequestEventResponseCalloutSpeechContentImpl
    implements CalloutRequestEventResponseCalloutSpeechContent {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_LOCALE = "locale";

  private OptionalValue<String> locale;

  public CalloutRequestEventResponseCalloutSpeechContentImpl() {}

  protected CalloutRequestEventResponseCalloutSpeechContentImpl(OptionalValue<String> locale) {
    this.locale = locale;
  }

  @JsonIgnore
  public String getLocale() {
    return locale.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_LOCALE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> locale() {
    return locale;
  }

  /** Return true if this CalloutRequestEventResponse_callout_speech object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CalloutRequestEventResponseCalloutSpeechContentImpl calloutRequestEventResponseCalloutSpeech =
        (CalloutRequestEventResponseCalloutSpeechContentImpl) o;
    return Objects.equals(this.locale, calloutRequestEventResponseCalloutSpeech.locale);
  }

  @Override
  public int hashCode() {
    return Objects.hash(locale);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CalloutRequestEventResponseCalloutSpeechContentImpl {\n");
    sb.append("    locale: ").append(toIndentedString(locale)).append("\n");
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
  static class Builder implements CalloutRequestEventResponseCalloutSpeechContent.Builder {
    OptionalValue<String> locale = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_LOCALE)
    public Builder setLocale(String locale) {
      this.locale = OptionalValue.of(locale);
      return this;
    }

    public CalloutRequestEventResponseCalloutSpeechContent build() {
      return new CalloutRequestEventResponseCalloutSpeechContentImpl(locale);
    }
  }
}
