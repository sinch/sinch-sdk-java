package com.sinch.sdk.domains.verification.models;

import com.sinch.sdk.core.http.HttpMethod;

/** Available methods and actions which can be done after a successful Verification */
public class Link {
  private final LinkRelType rel;
  private final String href;
  private final HttpMethod method;

  /**
   * @param rel The related action that can be performed on the initiated Verification
   * @param href The complete URL to perform the specified action, localized to the DataCenter which
   *     handled the original Verification request
   * @param method The HTTP method to use when performing the action using the linked localized URL
   */
  public Link(LinkRelType rel, String href, HttpMethod method) {
    this.rel = rel;
    this.href = href;
    this.method = method;
  }

  public LinkRelType getRel() {
    return rel;
  }

  public String getHref() {
    return href;
  }

  public HttpMethod getMethod() {
    return method;
  }

  @Override
  public String toString() {
    return "Link{" + "rel='" + rel + '\'' + ", href='" + href + '\'' + ", method=" + method + '}';
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {

    LinkRelType rel;
    String href;
    HttpMethod method;

    private Builder() {}

    public Builder setRel(LinkRelType rel) {
      this.rel = rel;
      return this;
    }

    public Builder setHref(String href) {
      this.href = href;
      return this;
    }

    public Builder setMethod(HttpMethod method) {
      this.method = method;
      return this;
    }

    public Link build() {
      return new Link(rel, href, method);
    }
  }
}
