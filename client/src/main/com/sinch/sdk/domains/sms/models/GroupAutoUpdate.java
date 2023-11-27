package com.sinch.sdk.domains.sms.models;

public class GroupAutoUpdate {
  private final String to;
  private final GroupAutoUpdateKeyword add;
  private final GroupAutoUpdateKeyword remove;

  /**
   * @param to Short code or long number addressed in MO.<br>
   *     Constraints: Must be valid MSISDN or short code.
   * @param add Keyword to be sent in MO to add MSISDN to a group
   * @param remove Keyword to be sent in MO to remove MSISDN to a group
   */
  public GroupAutoUpdate(String to, GroupAutoUpdateKeyword add, GroupAutoUpdateKeyword remove) {
    this.to = to;
    this.add = add;
    this.remove = remove;
  }

  public String getTo() {
    return to;
  }

  public GroupAutoUpdateKeyword getAdd() {
    return add;
  }

  public GroupAutoUpdateKeyword getRemove() {
    return remove;
  }

  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "GroupAutoUpdate{" + "to='" + to + '\'' + ", add=" + add + ", remove=" + remove + '}';
  }

  public static class Builder {

    String to;
    GroupAutoUpdateKeyword add;
    GroupAutoUpdateKeyword remove;

    private Builder() {}

    public Builder setTo(String to) {
      this.to = to;
      return this;
    }

    public Builder setAdd(GroupAutoUpdateKeyword add) {
      this.add = add;
      return this;
    }

    public Builder setRemove(GroupAutoUpdateKeyword remove) {
      this.remove = remove;
      return this;
    }

    public GroupAutoUpdate build() {
      return new GroupAutoUpdate(to, add, remove);
    }
  }
}
