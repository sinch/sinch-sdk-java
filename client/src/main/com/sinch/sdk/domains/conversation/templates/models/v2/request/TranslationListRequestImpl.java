package com.sinch.sdk.domains.conversation.templates.models.v2.request;

import com.sinch.sdk.domains.conversation.templates.models.v2.request.TranslationListRequest.Builder;
import java.util.Optional;

public class TranslationListRequestImpl implements TranslationListRequest {

  final String languageCode;
  final String translationVersion;

  public TranslationListRequestImpl(String languageCode, String translationVersion) {
    this.languageCode = languageCode;
    this.translationVersion = translationVersion;
  }

  @Override
  public Optional<String> getLanguageCode() {
    return Optional.ofNullable(languageCode);
  }

  @Override
  public Optional<String> getTranslationVersion() {
    return Optional.ofNullable(translationVersion);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder implements TranslationListRequest.Builder {

    String languageCode;
    String translationVersion;

    Builder() {}

    @Override
    public Builder setLanguageCode(String languageCode) {
      this.languageCode = languageCode;
      return this;
    }

    @Override
    public Builder setTranslationVersion(String translationVersion) {
      this.translationVersion = translationVersion;
      return this;
    }

    public TranslationListRequest build() {
      return new TranslationListRequestImpl(languageCode, translationVersion);
    }
  }
}
