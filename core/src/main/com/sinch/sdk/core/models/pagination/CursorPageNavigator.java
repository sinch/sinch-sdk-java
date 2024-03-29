package com.sinch.sdk.core.models.pagination;

/** Cursor Based Page Navigator */
public class CursorPageNavigator extends PageNavigator<Integer> {

  private final Integer currentPage;
  private final Integer pageSize;
  private final Long collectionSize;

  /**
   * Create new instance
   *
   * @param currentPage Current page value
   * @param pageSize Page size
   * @param collectionSize Size of collection
   */
  public CursorPageNavigator(Integer currentPage, Integer pageSize, Long collectionSize) {
    super(null);
    this.currentPage = currentPage;
    this.pageSize = pageSize;
    this.collectionSize = collectionSize;
  }

  private Integer computeNextPageCursor() {
    // check end of pagination limit reached: (current page number * page size ) cannot be greater
    // than "count" to be able to call next page
    return ((currentPage + 1) * Long.valueOf(pageSize)) >= collectionSize ? null : currentPage + 1;
  }

  /** {@inheritDoc} */
  @Override
  public Integer getToken() {
    return computeNextPageCursor();
  }

  @Override
  public String toString() {
    return "CursorPageNavigator{"
        + "currentPage="
        + currentPage
        + ", pageSize="
        + pageSize
        + ", collectionSize="
        + collectionSize
        + "} "
        + super.toString();
  }
}
