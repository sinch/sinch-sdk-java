package com.sinch.sdk.domains.voice.models.v2;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/** Metadata about the paginated list response. */
@JsonDeserialize(builder = PaginationMetaImpl.Builder.class)
public interface PaginationMeta {

  /**
   * Total number of items across all pages.
   *
   * <p>Field is required
   *
   * @return totalCount
   */
  Integer getTotalCount();

  /**
   * Total number of pages.
   *
   * <p>Field is required
   *
   * @return pageCount
   */
  Integer getPageCount();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new PaginationMetaImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param totalCount see getter
     * @return Current builder
     * @see #getTotalCount
     */
    Builder setTotalCount(Integer totalCount);

    /**
     * see getter
     *
     * @param pageCount see getter
     * @return Current builder
     * @see #getPageCount
     */
    Builder setPageCount(Integer pageCount);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    PaginationMeta build();
  }
}
