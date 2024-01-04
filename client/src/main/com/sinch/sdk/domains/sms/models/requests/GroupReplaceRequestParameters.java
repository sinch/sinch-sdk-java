package com.sinch.sdk.domains.sms.models.requests;

import com.sinch.sdk.core.models.OptionalValue;
import java.util.Collection;

/**
 * Parameters request to replace a group
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/sms/api-reference/sms/tag/Groups/#tag/Groups/operation/ReplaceGroup">https://developers.sinch.com/docs/sms/api-reference/sms/tag/Groups/#tag/Groups/operation/ReplaceGroup</a>
 * @since 1.0
 */
public class GroupReplaceRequestParameters {

  private final OptionalValue<String> name;
  private final OptionalValue<Collection<String>> members;

  private GroupReplaceRequestParameters(
      OptionalValue<String> name, OptionalValue<Collection<String>> members) {
    this.name = name;
    this.members = members;
  }

  public OptionalValue<String> getName() {
    return name;
  }

  public OptionalValue<Collection<String>> getMembers() {
    return members;
  }

  @Override
  public String toString() {
    return "GroupCreateRequestParameters{" + "name='" + name + '\'' + ", members=" + members + '}';
  }

  public static Builder builder() {
    return new Builder();
  }

  public static Builder builder(GroupReplaceRequestParameters parameters) {
    return new Builder(parameters);
  }

  public static class Builder {

    OptionalValue<String> name = OptionalValue.empty();
    OptionalValue<Collection<String>> members = OptionalValue.empty();

    private Builder() {}

    private Builder(GroupReplaceRequestParameters parameters) {
      this.name = parameters.getName();
      this.members = parameters.getMembers();
    }

    /**
     * @param name Name of the group
     * @return current builder
     */
    public Builder setName(String name) {
      this.name = OptionalValue.of(name);
      return this;
    }

    /**
     * @param members The initial members of the group.
     *     <p>Constraints: Elements must be phone numbers in E.164 format MSISDNs.
     * @return current builder
     */
    public Builder setMembers(Collection<String> members) {
      this.members = OptionalValue.of(members);
      return this;
    }

    public GroupReplaceRequestParameters build() {
      return new GroupReplaceRequestParameters(name, members);
    }
  }
}
