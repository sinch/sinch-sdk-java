package com.sinch.sdk.domains.sms.models;

import java.util.Optional;

/**
 * MediaBody object
 *
 * @since 1.0
 */
public class MediaBody {
  private final String message;
  private final String url;

  /**
   * @param url URL to the media file
   * @param message The message text. Text only media messages will be rejected, please use SMS
   *     instead.
   */
  public MediaBody(String url, String message) {
    this.message = message;
    this.url = url;
  }

  public MediaBody(String url) {
    this(url, null);
  }

  public String getUrl() {
    return url;
  }

  public Optional<String> getMessage() {
    return Optional.ofNullable(message);
  }

  @Override
  public String toString() {
    return "MediaBody{" + "message='" + message + '\'' + ", url='" + url + '\'' + '}';
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {
    private String message;
    private String url;

    private Builder() {}

    public Builder setMessage(String message) {
      this.message = message;
      return this;
    }

    public Builder setUrl(String url) {
      this.url = url;
      return this;
    }

    public MediaBody build() {
      return new MediaBody(url, message);
    }
  }
}
