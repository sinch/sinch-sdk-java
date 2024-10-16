package com.sinch.sdk.domains.voice.models.v1.svaml;

/**
 * Control URL used during a custom callout
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/voice/api-reference/voice/tag/Callouts/#tag/Callouts/operation/Callouts!path=customCallout&t=request">Custom
 *     Callout Description</a>
 * @since 1.4
 */
public class ControlUrl implements Control {

  private final String url;

  private ControlUrl(String URL) {
    this.url = URL;
  }

  /**
   * @see #from(String)
   */
  public String getUrl() {
    return url;
  }

  @Override
  public String toString() {
    return "ControlUrl{" + "URL='" + url + '\'' + "} " + super.toString();
  }

  /**
   * Create a Custom URL instance from String
   *
   * @param URL URL representation
   * @return A newly created instance
   * @since 1.4
   */
  public static ControlUrl from(String URL) {
    return new ControlUrl(URL);
  }
}
