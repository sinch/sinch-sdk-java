package com.sinch.sdk.core.models;

/** Representing a Server configuration. */
public class ServerConfiguration {

  private final String url;

  /**
   * @param url A URL to the target host.
   */
  public ServerConfiguration(String url) {
    this.url = url;
  }

  public String getUrl() {
    return url;
  }
}
