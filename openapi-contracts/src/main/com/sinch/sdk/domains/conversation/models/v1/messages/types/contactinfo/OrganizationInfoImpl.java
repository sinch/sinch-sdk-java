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
  OrganizationInfoImpl.JSON_PROPERTY_COMPANY,
  OrganizationInfoImpl.JSON_PROPERTY_DEPARTMENT,
  OrganizationInfoImpl.JSON_PROPERTY_TITLE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class OrganizationInfoImpl implements OrganizationInfo {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_COMPANY = "company";

  private OptionalValue<String> company;

  public static final String JSON_PROPERTY_DEPARTMENT = "department";

  private OptionalValue<String> department;

  public static final String JSON_PROPERTY_TITLE = "title";

  private OptionalValue<String> title;

  public OrganizationInfoImpl() {}

  protected OrganizationInfoImpl(
      OptionalValue<String> company,
      OptionalValue<String> department,
      OptionalValue<String> title) {
    this.company = company;
    this.department = department;
    this.title = title;
  }

  @JsonIgnore
  public String getCompany() {
    return company.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_COMPANY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> company() {
    return company;
  }

  @JsonIgnore
  public String getDepartment() {
    return department.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DEPARTMENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> department() {
    return department;
  }

  @JsonIgnore
  public String getTitle() {
    return title.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TITLE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> title() {
    return title;
  }

  /** Return true if this OrganizationInfo object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrganizationInfoImpl organizationInfo = (OrganizationInfoImpl) o;
    return Objects.equals(this.company, organizationInfo.company)
        && Objects.equals(this.department, organizationInfo.department)
        && Objects.equals(this.title, organizationInfo.title);
  }

  @Override
  public int hashCode() {
    return Objects.hash(company, department, title);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrganizationInfoImpl {\n");
    sb.append("    company: ").append(toIndentedString(company)).append("\n");
    sb.append("    department: ").append(toIndentedString(department)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
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
  static class Builder implements OrganizationInfo.Builder {
    OptionalValue<String> company = OptionalValue.empty();
    OptionalValue<String> department = OptionalValue.empty();
    OptionalValue<String> title = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_COMPANY)
    public Builder setCompany(String company) {
      this.company = OptionalValue.of(company);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_DEPARTMENT)
    public Builder setDepartment(String department) {
      this.department = OptionalValue.of(department);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_TITLE)
    public Builder setTitle(String title) {
      this.title = OptionalValue.of(title);
      return this;
    }

    public OrganizationInfo build() {
      return new OrganizationInfoImpl(company, department, title);
    }
  }
}
