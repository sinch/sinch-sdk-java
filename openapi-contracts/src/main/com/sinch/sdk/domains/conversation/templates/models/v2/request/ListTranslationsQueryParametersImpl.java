package com.sinch.sdk.domains.conversation.templates.models.v2.request;

import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

public class ListTranslationsQueryParametersImpl implements ListTranslationsQueryParameters {

  private final OptionalValue<String> languageCode;
  private final OptionalValue<String> translationVersion;

  private ListTranslationsQueryParametersImpl(
      OptionalValue<String> languageCode, OptionalValue<String> translationVersion) {
    this.languageCode = languageCode;
    this.translationVersion = translationVersion;
  }

  public OptionalValue<String> getLanguageCode() {
    return languageCode;
  }

  public OptionalValue<String> getTranslationVersion() {
    return translationVersion;
  }

  /** Return true if this TemplatesV2ListTranslationsQueryParameters object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListTranslationsQueryParametersImpl templatesV2ListTranslationsQueryParameters =
        (ListTranslationsQueryParametersImpl) o;
    return Objects.equals(
            this.languageCode, templatesV2ListTranslationsQueryParameters.languageCode)
        && Objects.equals(
            this.translationVersion, templatesV2ListTranslationsQueryParameters.translationVersion);
  }

  @Override
  public int hashCode() {
    return Objects.hash(languageCode, translationVersion);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListTranslationsQueryParametersImpl {\n");
    sb.append("    languageCode: ").append(toIndentedString(languageCode)).append("\n");
    sb.append("    translationVersion: ").append(toIndentedString(translationVersion)).append("\n");
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

  static class Builder implements ListTranslationsQueryParameters.Builder {
    OptionalValue<String> languageCode = OptionalValue.empty();
    OptionalValue<String> translationVersion = OptionalValue.empty();

    protected Builder() {}

    protected Builder(ListTranslationsQueryParameters _parameters) {
      if (null == _parameters) {
        return;
      }
      ListTranslationsQueryParametersImpl parameters =
          (ListTranslationsQueryParametersImpl) _parameters;
      this.languageCode = parameters.getLanguageCode();
      this.translationVersion = parameters.getTranslationVersion();
    }

    public Builder setLanguageCode(String languageCode) {
      this.languageCode = OptionalValue.of(languageCode);
      return this;
    }

    public Builder setTranslationVersion(String translationVersion) {
      this.translationVersion = OptionalValue.of(translationVersion);
      return this;
    }

    public ListTranslationsQueryParameters build() {
      return new ListTranslationsQueryParametersImpl(languageCode, translationVersion);
    }
  }
}
