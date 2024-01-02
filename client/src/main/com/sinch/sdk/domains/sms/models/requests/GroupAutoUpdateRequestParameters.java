package com.sinch.sdk.domains.sms.models.requests;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.sms.models.GroupAutoUpdate.Builder;

public class GroupAutoUpdateRequestParameters {
  private final OptionalValue<String> to;
  private final OptionalValue<GroupAutoUpdateKeywordRequestParameters> add;
  private final OptionalValue<GroupAutoUpdateKeywordRequestParameters> remove;

  private GroupAutoUpdateRequestParameters(
      OptionalValue<String> to,
      OptionalValue<GroupAutoUpdateKeywordRequestParameters> add,
      OptionalValue<GroupAutoUpdateKeywordRequestParameters> remove) {
    this.to = to;
    this.add = add;
    this.remove = remove;
  }

  public OptionalValue<String> getTo() {
    return to;
  }

  public OptionalValue<GroupAutoUpdateKeywordRequestParameters> getAdd() {
    return add;
  }

  public OptionalValue<GroupAutoUpdateKeywordRequestParameters> getRemove() {
    return remove;
  }

  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "GroupAutoUpdateRequestParameters{"
        + "to='"
        + to
        + '\''
        + ", add="
        + add
        + ", remove="
        + remove
        + '}';
  }

  public static class Builder {

    OptionalValue<String> to = OptionalValue.empty();
    OptionalValue<GroupAutoUpdateKeywordRequestParameters> add = OptionalValue.empty();
    OptionalValue<GroupAutoUpdateKeywordRequestParameters> remove = OptionalValue.empty();

    private Builder() {}

    /**
     * @param to Short code or long number addressed in MO.<br>
     *     Constraints: Must be valid MSISDN or short code.
     * @return current builder
     */
    public Builder setTo(String to) {
      this.to = OptionalValue.of(to);
      return this;
    }

    /***
     *
     * @param add Keyword to be sent in MO to add MSISDN to a group
     * @return current builder
     */
    public Builder setAdd(GroupAutoUpdateKeywordRequestParameters add) {
      this.add = OptionalValue.of(add);
      return this;
    }

    /**
     * @param remove Keyword to be sent in MO to remove MSISDN to a group
     * @return current builder
     */
    public Builder setRemove(GroupAutoUpdateKeywordRequestParameters remove) {
      this.remove = OptionalValue.of(remove);
      return this;
    }

    public GroupAutoUpdateRequestParameters build() {
      return new GroupAutoUpdateRequestParameters(to, add, remove);
    }
  }
}
