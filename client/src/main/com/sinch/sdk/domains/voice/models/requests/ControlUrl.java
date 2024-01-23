package com.sinch.sdk.domains.voice.models.requests;

public class ControlUrl extends Control {

  private final String URL;

  public ControlUrl(String URL) {
    this.URL = URL;
  }

  public String getURL() {
    return URL;
  }

  @Override
  public String toString() {
    return "ControlUrl{" + "URL='" + URL + '\'' + "} " + super.toString();
  }

  public static ControlUrl from(String URL) {
    return new ControlUrl(URL);
  }
}
