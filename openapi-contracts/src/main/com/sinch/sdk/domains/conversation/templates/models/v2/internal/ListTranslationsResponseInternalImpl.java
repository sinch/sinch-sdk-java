package com.sinch.sdk.domains.conversation.templates.models.v2.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.templates.models.v2.TemplateTranslation;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({ListTranslationsResponseInternalImpl.JSON_PROPERTY_TRANSLATIONS})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ListTranslationsResponseInternalImpl implements ListTranslationsResponseInternal {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TRANSLATIONS = "translations";

  private OptionalValue<List<TemplateTranslation>> translations;

  public ListTranslationsResponseInternalImpl() {}

  protected ListTranslationsResponseInternalImpl(
      OptionalValue<List<TemplateTranslation>> translations) {
    this.translations = translations;
  }

  @JsonIgnore
  public List<TemplateTranslation> getTranslations() {
    return translations.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TRANSLATIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<TemplateTranslation>> translations() {
    return translations;
  }

  /** Return true if this v2ListTranslationsResponse object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListTranslationsResponseInternalImpl v2ListTranslationsResponse =
        (ListTranslationsResponseInternalImpl) o;
    return Objects.equals(this.translations, v2ListTranslationsResponse.translations);
  }

  @Override
  public int hashCode() {
    return Objects.hash(translations);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListTranslationsResponseInternalImpl {\n");
    sb.append("    translations: ").append(toIndentedString(translations)).append("\n");
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
  static class Builder implements ListTranslationsResponseInternal.Builder {
    OptionalValue<List<TemplateTranslation>> translations = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_TRANSLATIONS)
    public Builder setTranslations(List<TemplateTranslation> translations) {
      this.translations = OptionalValue.of(translations);
      return this;
    }

    public ListTranslationsResponseInternal build() {
      return new ListTranslationsResponseInternalImpl(translations);
    }
  }
}
