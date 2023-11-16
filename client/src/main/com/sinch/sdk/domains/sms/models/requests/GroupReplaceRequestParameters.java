package com.sinch.sdk.domains.sms.models.requests;

import java.util.Collection;
import java.util.Optional;

/**
 * Parameters request to replace a group
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/sms/api-reference/sms/tag/Groups/#tag/Groups/operation/ReplaceGroup">https://developers.sinch.com/docs/sms/api-reference/sms/tag/Groups/#tag/Groups/operation/ReplaceGroup</a>
 * @since 1.0
 */
public class GroupReplaceRequestParameters {

  private final String name;
  private final Collection<String> members;

  /**
   * @param name Name of the group
   * @param members The initial members of the group.
   *     <p>Constraints: Elements must be phone numbers in E.164 format MSISDNs.
   */
  public GroupReplaceRequestParameters(String name, Collection<String> members) {
    this.name = name;
    this.members = members;
  }

  public Optional<String> getName() {
    return Optional.ofNullable(name);
  }

  public Optional<Collection<String>> getMembers() {
    return Optional.ofNullable(members);
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

    String name;
    Collection<String> members;

    private Builder() {}

    private Builder(GroupReplaceRequestParameters parameters) {
      this.name = parameters.getName().orElse(null);
      this.members = parameters.getMembers().orElse(null);
    }

    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    public Builder setMembers(Collection<String> members) {
      this.members = members;
      return this;
    }

    public GroupReplaceRequestParameters build() {
      return new GroupReplaceRequestParameters(name, members);
    }
  }
}
