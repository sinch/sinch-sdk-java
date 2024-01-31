package com.sinch.sdk.domains.voice.models.requests;

/**
 * Control URL used during a custom callout
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/voice/api-reference/voice/tag/Callouts/#tag/Callouts/operation/Callouts!path=customCallout&t=request">Custom
 *     Callout Description</a>
 */
public class ControlUrl extends Control {

  private final String URL;

  private ControlUrl(String URL) {
    this.URL = URL;
  }

  /**
   * @see #from(String)
   */
  public String getURL() {
    return URL;
  }

  @Override
  public String toString() {
    return "ControlUrl{" + "URL='" + URL + '\'' + "} " + super.toString();
  }

  /**
   * Create a Custom URL instance from String
   *
   * @param URL URL representation
   * @return A newly created instance
   */
  public static ControlUrl from(String URL) {
    return new ControlUrl(URL);
  }
}
