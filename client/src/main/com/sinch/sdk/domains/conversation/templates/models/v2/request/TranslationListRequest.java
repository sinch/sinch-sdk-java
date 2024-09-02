package com.sinch.sdk.domains.conversation.templates.models.v2.request;

import java.util.Optional;

/**
 * Parameters request to list translation relate to a template
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/conversation/api-reference/template/tag/Templates-V2/#tag/Templates-V2/operation/Templates_v2_ListTranslations">online
 *     documentation</a>
 * @since _NEXT_VERSION_
 */
public interface TranslationListRequest {

  /**
   * The translation's language code.
   *
   * @return Language code.
   */
  Optional<String> getLanguageCode();

  /**
   * The translation's version
   *
   * @return Translation's version
   */
  Optional<String> getTranslationVersion();

  static Builder builder() {
    return new TranslationListRequestImpl.Builder();
  }

  interface Builder {

    /**
     * see getter
     *
     * @param languageCode see getter
     * @return Current builder
     * @see #getLanguageCode() ()
     */
    Builder setLanguageCode(String languageCode);

    /**
     * see getter
     *
     * @param translationVersion see getter
     * @return Current builder
     * @see #getTranslationVersion() ()
     */
    Builder setTranslationVersion(String translationVersion);

    TranslationListRequest build();
  }
}
