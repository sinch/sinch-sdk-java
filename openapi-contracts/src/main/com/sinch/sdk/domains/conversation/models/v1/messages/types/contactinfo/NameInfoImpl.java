package com.sinch.sdk.domains.conversation.models.v1.messages.types.contactinfo;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  NameInfoImpl.JSON_PROPERTY_FULL_NAME,
  NameInfoImpl.JSON_PROPERTY_FIRST_NAME,
  NameInfoImpl.JSON_PROPERTY_LAST_NAME,
  NameInfoImpl.JSON_PROPERTY_MIDDLE_NAME,
  NameInfoImpl.JSON_PROPERTY_PREFIX,
  NameInfoImpl.JSON_PROPERTY_SUFFIX
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class NameInfoImpl implements NameInfo {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_FULL_NAME = "full_name";

  private OptionalValue<String> fullName;

  public static final String JSON_PROPERTY_FIRST_NAME = "first_name";

  private OptionalValue<String> firstName;

  public static final String JSON_PROPERTY_LAST_NAME = "last_name";

  private OptionalValue<String> lastName;

  public static final String JSON_PROPERTY_MIDDLE_NAME = "middle_name";

  private OptionalValue<String> middleName;

  public static final String JSON_PROPERTY_PREFIX = "prefix";

  private OptionalValue<String> prefix;

  public static final String JSON_PROPERTY_SUFFIX = "suffix";

  private OptionalValue<String> suffix;

  public NameInfoImpl() {}

  protected NameInfoImpl(
      OptionalValue<String> fullName,
      OptionalValue<String> firstName,
      OptionalValue<String> lastName,
      OptionalValue<String> middleName,
      OptionalValue<String> prefix,
      OptionalValue<String> suffix) {
    this.fullName = fullName;
    this.firstName = firstName;
    this.lastName = lastName;
    this.middleName = middleName;
    this.prefix = prefix;
    this.suffix = suffix;
  }

  @JsonIgnore
  public String getFullName() {
    return fullName.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_FULL_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> fullName() {
    return fullName;
  }

  @JsonIgnore
  public String getFirstName() {
    return firstName.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_FIRST_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> firstName() {
    return firstName;
  }

  @JsonIgnore
  public String getLastName() {
    return lastName.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_LAST_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> lastName() {
    return lastName;
  }

  @JsonIgnore
  public String getMiddleName() {
    return middleName.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MIDDLE_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> middleName() {
    return middleName;
  }

  @JsonIgnore
  public String getPrefix() {
    return prefix.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PREFIX)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> prefix() {
    return prefix;
  }

  @JsonIgnore
  public String getSuffix() {
    return suffix.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SUFFIX)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> suffix() {
    return suffix;
  }

  /** Return true if this NameInfo object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NameInfoImpl nameInfo = (NameInfoImpl) o;
    return Objects.equals(this.fullName, nameInfo.fullName)
        && Objects.equals(this.firstName, nameInfo.firstName)
        && Objects.equals(this.lastName, nameInfo.lastName)
        && Objects.equals(this.middleName, nameInfo.middleName)
        && Objects.equals(this.prefix, nameInfo.prefix)
        && Objects.equals(this.suffix, nameInfo.suffix);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fullName, firstName, lastName, middleName, prefix, suffix);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NameInfoImpl {\n");
    sb.append("    fullName: ").append(toIndentedString(fullName)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    middleName: ").append(toIndentedString(middleName)).append("\n");
    sb.append("    prefix: ").append(toIndentedString(prefix)).append("\n");
    sb.append("    suffix: ").append(toIndentedString(suffix)).append("\n");
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
  static class Builder implements NameInfo.Builder {
    OptionalValue<String> fullName = OptionalValue.empty();
    OptionalValue<String> firstName = OptionalValue.empty();
    OptionalValue<String> lastName = OptionalValue.empty();
    OptionalValue<String> middleName = OptionalValue.empty();
    OptionalValue<String> prefix = OptionalValue.empty();
    OptionalValue<String> suffix = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_FULL_NAME, required = true)
    public Builder setFullName(String fullName) {
      this.fullName = OptionalValue.of(fullName);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_FIRST_NAME)
    public Builder setFirstName(String firstName) {
      this.firstName = OptionalValue.of(firstName);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_LAST_NAME)
    public Builder setLastName(String lastName) {
      this.lastName = OptionalValue.of(lastName);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_MIDDLE_NAME)
    public Builder setMiddleName(String middleName) {
      this.middleName = OptionalValue.of(middleName);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_PREFIX)
    public Builder setPrefix(String prefix) {
      this.prefix = OptionalValue.of(prefix);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_SUFFIX)
    public Builder setSuffix(String suffix) {
      this.suffix = OptionalValue.of(suffix);
      return this;
    }

    public NameInfo build() {
      return new NameInfoImpl(fullName, firstName, lastName, middleName, prefix, suffix);
    }
  }
}
