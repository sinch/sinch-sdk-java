package com.sinch.sdk.domains.verification.models.response;

import com.sinch.sdk.domains.verification.models.Link;
import com.sinch.sdk.domains.verification.models.VerificationId;
import java.util.Collection;

/** Comme class to all Start verification requests */
public class StartVerificationResponse {

  private final VerificationId id;
  private final Collection<Link> links;

  /**
   * @param id Verification identifier used to query for status.
   * @param links Available methods and actions which can be done after a successful Verification
   */
  protected StartVerificationResponse(VerificationId id, Collection<Link> links) {
    this.id = id;
    this.links = links;
  }

  public VerificationId getId() {
    return id;
  }

  public Collection<Link> getLinks() {
    return links;
  }

  @Override
  public String toString() {
    return "StartVerificationResponse{" + "id='" + id + '\'' + ", links=" + links + '}';
  }

  public static Builder<?> builder() {
    return new Builder<>();
  }

  public static class Builder<B extends Builder<B>> {

    VerificationId id;
    Collection<Link> links;

    public B setId(VerificationId id) {
      this.id = id;
      return self();
    }

    public B setLinks(Collection<Link> links) {
      this.links = links;
      return self();
    }

    public StartVerificationResponse build() {
      return new StartVerificationResponse(id, links);
    }

    @SuppressWarnings("unchecked")
    protected B self() {
      return (B) this;
    }
  }
}
