package com.sinch.sdk.domains.verification.models;

import com.sinch.sdk.core.http.HttpMethod;

/**
 * Available methods and actions which can be done after a successful Verification
 *
 * @since 1.0
 */
public class Link {
  private final LinkRelType rel;
  private final String href;
  private final HttpMethod method;

  private Link(LinkRelType rel, String href, HttpMethod method) {
    this.rel = rel;
    this.href = href;
    this.method = method;
  }

  /**
   * The related action that can be performed on the initiated Verification
   *
   * @return Related type
   * @since 1.0
   */
  public LinkRelType getRel() {
    return rel;
  }

  /**
   * The complete URL to perform the specified action, localized to the DataCenter which handled the
   * original Verification request
   *
   * @return URL value
   * @since 1.0
   */
  public String getHref() {
    return href;
  }

  /**
   * The HTTP method to use when performing the action using the linked localized URL
   *
   * @return HTTP method
   * @since 1.0
   */
  public HttpMethod getMethod() {
    return method;
  }

  /** {@inheritDoc} */
  @Override
  public String toString() {
    return "Link{" + "rel='" + rel + '\'' + ", href='" + href + '\'' + ", method=" + method + '}';
  }

  /**
   * Getting Builder
   *
   * @return New Builder instance
   * @since 1.0
   */
  public static Builder builder() {
    return new Builder();
  }

  /**
   * Dedicated Builder
   *
   * @since 1.0
   */
  public static class Builder {

    LinkRelType rel;
    String href;
    HttpMethod method;

    private Builder() {}

    /**
     * Setter
     *
     * @param rel See {@link #getRel()} getter
     * @return Current builder
     * @since 1.0
     */
    public Builder setRel(LinkRelType rel) {
      this.rel = rel;
      return this;
    }

    /**
     * Setter
     *
     * @param href See {@link #getHref()} getter
     * @return Current builder
     * @since 1.0
     */
    public Builder setHref(String href) {
      this.href = href;
      return this;
    }

    /**
     * Setter
     *
     * @param method See {@link #getMethod()} getter
     * @return Current builder
     * @since 1.0
     */
    public Builder setMethod(HttpMethod method) {
      this.method = method;
      return this;
    }

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     * @since 1.0
     */
    public Link build() {
      return new Link(rel, href, method);
    }
  }
}
