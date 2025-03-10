package com.sinch.sdk.domains.sms.models.v1.groups;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  GroupAutoUpdateImpl.JSON_PROPERTY_TO,
  GroupAutoUpdateImpl.JSON_PROPERTY_ADD,
  GroupAutoUpdateImpl.JSON_PROPERTY_REMOVE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class GroupAutoUpdateImpl implements GroupAutoUpdate {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TO = "to";

  private OptionalValue<String> to;

  public static final String JSON_PROPERTY_ADD = "add";

  private OptionalValue<AddKeyword> add;

  public static final String JSON_PROPERTY_REMOVE = "remove";

  private OptionalValue<RemoveKeyword> remove;

  public GroupAutoUpdateImpl() {}

  protected GroupAutoUpdateImpl(
      OptionalValue<String> to,
      OptionalValue<AddKeyword> add,
      OptionalValue<RemoveKeyword> remove) {
    this.to = to;
    this.add = add;
    this.remove = remove;
  }

  @JsonIgnore
  public String getTo() {
    return to.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TO)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> to() {
    return to;
  }

  @JsonIgnore
  public AddKeyword getAdd() {
    return add.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ADD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<AddKeyword> add() {
    return add;
  }

  @JsonIgnore
  public RemoveKeyword getRemove() {
    return remove.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_REMOVE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<RemoveKeyword> remove() {
    return remove;
  }

  /** Return true if this ApiGroupAutoUpdate object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GroupAutoUpdateImpl apiGroupAutoUpdate = (GroupAutoUpdateImpl) o;
    return Objects.equals(this.to, apiGroupAutoUpdate.to)
        && Objects.equals(this.add, apiGroupAutoUpdate.add)
        && Objects.equals(this.remove, apiGroupAutoUpdate.remove);
  }

  @Override
  public int hashCode() {
    return Objects.hash(to, add, remove);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GroupAutoUpdateImpl {\n");
    sb.append("    to: ").append(toIndentedString(to)).append("\n");
    sb.append("    add: ").append(toIndentedString(add)).append("\n");
    sb.append("    remove: ").append(toIndentedString(remove)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

  @JsonPOJOBuilder(withPrefix = "set")
  static class Builder implements GroupAutoUpdate.Builder {
    OptionalValue<String> to = OptionalValue.empty();
    OptionalValue<AddKeyword> add = OptionalValue.empty();
    OptionalValue<RemoveKeyword> remove = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_TO, required = true)
    public Builder setTo(String to) {
      this.to = OptionalValue.of(to);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_ADD)
    public Builder setAdd(AddKeyword add) {
      this.add = OptionalValue.of(add);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_REMOVE)
    public Builder setRemove(RemoveKeyword remove) {
      this.remove = OptionalValue.of(remove);
      return this;
    }

    public GroupAutoUpdate build() {
      return new GroupAutoUpdateImpl(to, add, remove);
    }
  }
}
