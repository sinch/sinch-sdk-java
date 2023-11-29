package com.sinch.sdk.domains.sms.models;

import com.sinch.sdk.core.models.pagination.PageNavigator;

public class SMSCursorPageNavigator extends PageNavigator<Integer> {

  private final Integer currentPage;
  private final Integer pageSize;

  public SMSCursorPageNavigator(Integer currentPage, Integer pageSize) {
    super(null);
    this.currentPage = currentPage;
    this.pageSize = pageSize;
  }

  private Integer computeNextPageCursor() {
    return null == pageSize || pageSize == 0 ? null : currentPage + 1;
  }

  @Override
  public Integer getToken() {
    return computeNextPageCursor();
  }

  @Override
  public String toString() {
    return "SMSCursorPageNavigator{"
        + "currentPage="
        + currentPage
        + ", pageSize="
        + pageSize
        + "} "
        + super.toString();
  }
}
