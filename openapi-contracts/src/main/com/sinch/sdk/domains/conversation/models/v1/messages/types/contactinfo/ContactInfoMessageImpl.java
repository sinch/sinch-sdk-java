package com.sinch.sdk.domains.conversation.models.v1.messages.types.contactinfo;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  ContactInfoMessageImpl.JSON_PROPERTY_NAME,
  ContactInfoMessageImpl.JSON_PROPERTY_PHONE_NUMBERS,
  ContactInfoMessageImpl.JSON_PROPERTY_ADDRESSES,
  ContactInfoMessageImpl.JSON_PROPERTY_EMAIL_ADDRESSES,
  ContactInfoMessageImpl.JSON_PROPERTY_ORGANIZATION,
  ContactInfoMessageImpl.JSON_PROPERTY_URLS,
  ContactInfoMessageImpl.JSON_PROPERTY_BIRTHDAY
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ContactInfoMessageImpl
    implements ContactInfoMessage,
        com.sinch.sdk.domains.conversation.models.v1.messages.OmniMessageOverride,
        com.sinch.sdk.domains.conversation.models.v1.messages.AppMessage {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_NAME = "name";

  private OptionalValue<NameInfo> name;

  public static final String JSON_PROPERTY_PHONE_NUMBERS = "phone_numbers";

  private OptionalValue<List<PhoneNumberInfo>> phoneNumbers;

  public static final String JSON_PROPERTY_ADDRESSES = "addresses";

  private OptionalValue<List<AddressInfo>> addresses;

  public static final String JSON_PROPERTY_EMAIL_ADDRESSES = "email_addresses";

  private OptionalValue<List<EmailInfo>> emailAddresses;

  public static final String JSON_PROPERTY_ORGANIZATION = "organization";

  private OptionalValue<OrganizationInfo> organization;

  public static final String JSON_PROPERTY_URLS = "urls";

  private OptionalValue<List<UrlInfo>> urls;

  public static final String JSON_PROPERTY_BIRTHDAY = "birthday";

  private OptionalValue<LocalDate> birthday;

  public ContactInfoMessageImpl() {}

  protected ContactInfoMessageImpl(
      OptionalValue<NameInfo> name,
      OptionalValue<List<PhoneNumberInfo>> phoneNumbers,
      OptionalValue<List<AddressInfo>> addresses,
      OptionalValue<List<EmailInfo>> emailAddresses,
      OptionalValue<OrganizationInfo> organization,
      OptionalValue<List<UrlInfo>> urls,
      OptionalValue<LocalDate> birthday) {
    this.name = name;
    this.phoneNumbers = phoneNumbers;
    this.addresses = addresses;
    this.emailAddresses = emailAddresses;
    this.organization = organization;
    this.urls = urls;
    this.birthday = birthday;
  }

  @JsonIgnore
  public NameInfo getName() {
    return name.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<NameInfo> name() {
    return name;
  }

  @JsonIgnore
  public List<PhoneNumberInfo> getPhoneNumbers() {
    return phoneNumbers.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PHONE_NUMBERS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<List<PhoneNumberInfo>> phoneNumbers() {
    return phoneNumbers;
  }

  @JsonIgnore
  public List<AddressInfo> getAddresses() {
    return addresses.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ADDRESSES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<AddressInfo>> addresses() {
    return addresses;
  }

  @JsonIgnore
  public List<EmailInfo> getEmailAddresses() {
    return emailAddresses.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_EMAIL_ADDRESSES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<EmailInfo>> emailAddresses() {
    return emailAddresses;
  }

  @JsonIgnore
  public OrganizationInfo getOrganization() {
    return organization.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ORGANIZATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<OrganizationInfo> organization() {
    return organization;
  }

  @JsonIgnore
  public List<UrlInfo> getUrls() {
    return urls.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_URLS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<UrlInfo>> urls() {
    return urls;
  }

  @JsonIgnore
  public LocalDate getBirthday() {
    return birthday.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_BIRTHDAY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<LocalDate> birthday() {
    return birthday;
  }

  /** Return true if this Contact_Info_Message object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContactInfoMessageImpl contactInfoMessage = (ContactInfoMessageImpl) o;
    return Objects.equals(this.name, contactInfoMessage.name)
        && Objects.equals(this.phoneNumbers, contactInfoMessage.phoneNumbers)
        && Objects.equals(this.addresses, contactInfoMessage.addresses)
        && Objects.equals(this.emailAddresses, contactInfoMessage.emailAddresses)
        && Objects.equals(this.organization, contactInfoMessage.organization)
        && Objects.equals(this.urls, contactInfoMessage.urls)
        && Objects.equals(this.birthday, contactInfoMessage.birthday);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        name, phoneNumbers, addresses, emailAddresses, organization, urls, birthday);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContactInfoMessageImpl {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    phoneNumbers: ").append(toIndentedString(phoneNumbers)).append("\n");
    sb.append("    addresses: ").append(toIndentedString(addresses)).append("\n");
    sb.append("    emailAddresses: ").append(toIndentedString(emailAddresses)).append("\n");
    sb.append("    organization: ").append(toIndentedString(organization)).append("\n");
    sb.append("    urls: ").append(toIndentedString(urls)).append("\n");
    sb.append("    birthday: ").append(toIndentedString(birthday)).append("\n");
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
  static class Builder implements ContactInfoMessage.Builder {
    OptionalValue<NameInfo> name = OptionalValue.empty();
    OptionalValue<List<PhoneNumberInfo>> phoneNumbers = OptionalValue.empty();
    OptionalValue<List<AddressInfo>> addresses = OptionalValue.empty();
    OptionalValue<List<EmailInfo>> emailAddresses = OptionalValue.empty();
    OptionalValue<OrganizationInfo> organization = OptionalValue.empty();
    OptionalValue<List<UrlInfo>> urls = OptionalValue.empty();
    OptionalValue<LocalDate> birthday = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_NAME)
    public Builder setName(NameInfo name) {
      this.name = OptionalValue.of(name);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_PHONE_NUMBERS)
    public Builder setPhoneNumbers(List<PhoneNumberInfo> phoneNumbers) {
      this.phoneNumbers = OptionalValue.of(phoneNumbers);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_ADDRESSES)
    public Builder setAddresses(List<AddressInfo> addresses) {
      this.addresses = OptionalValue.of(addresses);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_EMAIL_ADDRESSES)
    public Builder setEmailAddresses(List<EmailInfo> emailAddresses) {
      this.emailAddresses = OptionalValue.of(emailAddresses);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_ORGANIZATION)
    public Builder setOrganization(OrganizationInfo organization) {
      this.organization = OptionalValue.of(organization);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_URLS)
    public Builder setUrls(List<UrlInfo> urls) {
      this.urls = OptionalValue.of(urls);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_BIRTHDAY)
    public Builder setBirthday(LocalDate birthday) {
      this.birthday = OptionalValue.of(birthday);
      return this;
    }

    public ContactInfoMessage build() {
      return new ContactInfoMessageImpl(
          name, phoneNumbers, addresses, emailAddresses, organization, urls, birthday);
    }
  }
}
