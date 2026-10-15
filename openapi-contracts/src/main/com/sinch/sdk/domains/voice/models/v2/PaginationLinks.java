package com.sinch.sdk.domains.voice.models.v2;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/** Pagination links for navigating through pages of results in a paginated list response. */
@JsonDeserialize(builder = PaginationLinksImpl.Builder.class)
public interface PaginationLinks {

  /**
   * Absolute URI of the first page.
   *
   * <p>Field is required
   *
   * @return first
   */
  String getFirst();

  /**
   * Absolute URI of the last page.
   *
   * <p>Field is required
   *
   * @return last
   */
  String getLast();

  /**
   * Absolute URI of the next page (omitted if this is the last page).
   *
   * @return next
   */
  String getNext();

  /**
   * Absolute URI of the previous page (omitted if this is the first page).
   *
   * @return prev
   */
  String getPrev();

  /**
   * Absolute URI of the current page.
   *
   * <p>Field is required
   *
   * @return self
   */
  String getSelf();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new PaginationLinksImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param first see getter
     * @return Current builder
     * @see #getFirst
     */
    Builder setFirst(String first);

    /**
     * see getter
     *
     * @param last see getter
     * @return Current builder
     * @see #getLast
     */
    Builder setLast(String last);

    /**
     * see getter
     *
     * @param next see getter
     * @return Current builder
     * @see #getNext
     */
    Builder setNext(String next);

    /**
     * see getter
     *
     * @param prev see getter
     * @return Current builder
     * @see #getPrev
     */
    Builder setPrev(String prev);

    /**
     * see getter
     *
     * @param self see getter
     * @return Current builder
     * @see #getSelf
     */
    Builder setSelf(String self);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    PaginationLinks build();
  }
}
