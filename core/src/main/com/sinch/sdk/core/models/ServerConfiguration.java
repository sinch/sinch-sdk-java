package com.sinch.sdk.core.models;

/** Class used to store server related information and configuration */
public class ServerConfiguration {

  private final String url;

  /**
   * Create a server confiration from URL
   *
   * @param url A URL to the target host.
   */
  public ServerConfiguration(String url) {
    this.url = url;
  }

  /**
   * Get URL related to server
   *
   * @return The URL value
   */
  public String getUrl() {
    return url;
  }
}
