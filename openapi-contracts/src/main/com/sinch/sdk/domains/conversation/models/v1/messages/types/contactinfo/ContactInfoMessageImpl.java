package com.sinch.sdk.domains.conversation.models.v1.messages.types.contactinfo;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@JsonPropertyOrder({ContactInfoMessageImpl.JSON_PROPERTY_CONTACT_INFO_MESSAGE})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ContactInfoMessageImpl
    implements ContactInfoMessage,
        com.sinch.sdk.domains.conversation.models.v1.messages.OmniMessageOverride,
        com.sinch.sdk.domains.conversation.models.v1.messages.AppMessageBody {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CONTACT_INFO_MESSAGE = "contact_info_message";

  private OptionalValue<ContactInfoMessageInternal> contactInfoMessage;

  public ContactInfoMessageImpl() {}

  protected ContactInfoMessageImpl(OptionalValue<ContactInfoMessageInternal> contactInfoMessage) {
    this.contactInfoMessage = contactInfoMessage;
  }

  @JsonIgnore
  public ContactInfoMessageInternal getContactInfoMessage() {
    return contactInfoMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CONTACT_INFO_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ContactInfoMessageInternal> contactInfoMessage() {
    return contactInfoMessage;
  }

  @JsonIgnore
  public NameInfo getName() {
    if (null == contactInfoMessage
        || !contactInfoMessage.isPresent()
        || null == contactInfoMessage.get().getName()) {
      return null;
    }
    return contactInfoMessage.get().getName();
  }

  public OptionalValue<NameInfo> name() {
    return null != contactInfoMessage && contactInfoMessage.isPresent()
        ? contactInfoMessage
            .map(f -> ((ContactInfoMessageInternalImpl) f).name())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public List<PhoneNumberInfo> getPhoneNumbers() {
    if (null == contactInfoMessage
        || !contactInfoMessage.isPresent()
        || null == contactInfoMessage.get().getPhoneNumbers()) {
      return null;
    }
    return contactInfoMessage.get().getPhoneNumbers();
  }

  public OptionalValue<List<PhoneNumberInfo>> phoneNumbers() {
    return null != contactInfoMessage && contactInfoMessage.isPresent()
        ? contactInfoMessage
            .map(f -> ((ContactInfoMessageInternalImpl) f).phoneNumbers())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public List<AddressInfo> getAddresses() {
    if (null == contactInfoMessage
        || !contactInfoMessage.isPresent()
        || null == contactInfoMessage.get().getAddresses()) {
      return null;
    }
    return contactInfoMessage.get().getAddresses();
  }

  public OptionalValue<List<AddressInfo>> addresses() {
    return null != contactInfoMessage && contactInfoMessage.isPresent()
        ? contactInfoMessage
            .map(f -> ((ContactInfoMessageInternalImpl) f).addresses())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public List<EmailInfo> getEmailAddresses() {
    if (null == contactInfoMessage
        || !contactInfoMessage.isPresent()
        || null == contactInfoMessage.get().getEmailAddresses()) {
      return null;
    }
    return contactInfoMessage.get().getEmailAddresses();
  }

  public OptionalValue<List<EmailInfo>> emailAddresses() {
    return null != contactInfoMessage && contactInfoMessage.isPresent()
        ? contactInfoMessage
            .map(f -> ((ContactInfoMessageInternalImpl) f).emailAddresses())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public OrganizationInfo getOrganization() {
    if (null == contactInfoMessage
        || !contactInfoMessage.isPresent()
        || null == contactInfoMessage.get().getOrganization()) {
      return null;
    }
    return contactInfoMessage.get().getOrganization();
  }

  public OptionalValue<OrganizationInfo> organization() {
    return null != contactInfoMessage && contactInfoMessage.isPresent()
        ? contactInfoMessage
            .map(f -> ((ContactInfoMessageInternalImpl) f).organization())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public List<UrlInfo> getUrls() {
    if (null == contactInfoMessage
        || !contactInfoMessage.isPresent()
        || null == contactInfoMessage.get().getUrls()) {
      return null;
    }
    return contactInfoMessage.get().getUrls();
  }

  public OptionalValue<List<UrlInfo>> urls() {
    return null != contactInfoMessage && contactInfoMessage.isPresent()
        ? contactInfoMessage
            .map(f -> ((ContactInfoMessageInternalImpl) f).urls())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public LocalDate getBirthday() {
    if (null == contactInfoMessage
        || !contactInfoMessage.isPresent()
        || null == contactInfoMessage.get().getBirthday()) {
      return null;
    }
    return contactInfoMessage.get().getBirthday();
  }

  public OptionalValue<LocalDate> birthday() {
    return null != contactInfoMessage && contactInfoMessage.isPresent()
        ? contactInfoMessage
            .map(f -> ((ContactInfoMessageInternalImpl) f).birthday())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  /** Return true if this ContactInfoMessageField object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContactInfoMessageImpl contactInfoMessageField = (ContactInfoMessageImpl) o;
    return Objects.equals(this.contactInfoMessage, contactInfoMessageField.contactInfoMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(contactInfoMessage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContactInfoMessageImpl {\n");
    sb.append("    contactInfoMessage: ").append(toIndentedString(contactInfoMessage)).append("\n");
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
    OptionalValue<ContactInfoMessageInternal> contactInfoMessage = OptionalValue.empty();

    ContactInfoMessageInternal.Builder _delegatedBuilder = null;

    @JsonProperty(value = JSON_PROPERTY_CONTACT_INFO_MESSAGE, required = true)
    public Builder setContactInfoMessage(ContactInfoMessageInternal contactInfoMessage) {
      this.contactInfoMessage = OptionalValue.of(contactInfoMessage);
      return this;
    }

    @JsonIgnore
    public Builder setName(NameInfo name) {
      getDelegatedBuilder().setName(name);
      return this;
    }

    @JsonIgnore
    public Builder setPhoneNumbers(List<PhoneNumberInfo> phoneNumbers) {
      getDelegatedBuilder().setPhoneNumbers(phoneNumbers);
      return this;
    }

    @JsonIgnore
    public Builder setAddresses(List<AddressInfo> addresses) {
      getDelegatedBuilder().setAddresses(addresses);
      return this;
    }

    @JsonIgnore
    public Builder setEmailAddresses(List<EmailInfo> emailAddresses) {
      getDelegatedBuilder().setEmailAddresses(emailAddresses);
      return this;
    }

    @JsonIgnore
    public Builder setOrganization(OrganizationInfo organization) {
      getDelegatedBuilder().setOrganization(organization);
      return this;
    }

    @JsonIgnore
    public Builder setUrls(List<UrlInfo> urls) {
      getDelegatedBuilder().setUrls(urls);
      return this;
    }

    @JsonIgnore
    public Builder setBirthday(LocalDate birthday) {
      getDelegatedBuilder().setBirthday(birthday);
      return this;
    }

    private ContactInfoMessageInternal.Builder getDelegatedBuilder() {
      if (null == _delegatedBuilder) {
        this._delegatedBuilder = ContactInfoMessageInternal.builder();
      }
      return this._delegatedBuilder;
    }

    public ContactInfoMessage build() {
      // delegated builder was used: filling the related source of delegation field
      if (null != this._delegatedBuilder) {
        this.contactInfoMessage = OptionalValue.of(this._delegatedBuilder.build());
      }
      return new ContactInfoMessageImpl(contactInfoMessage);
    }
  }

  public static class DelegatedSerializer
      extends JsonSerializer<OptionalValue<ContactInfoMessage>> {
    @Override
    public void serialize(
        OptionalValue<ContactInfoMessage> value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException {

      if (!value.isPresent()) {
        return;
      }
      ContactInfoMessageImpl impl = (ContactInfoMessageImpl) value.get();
      jgen.writeObject(impl.getContactInfoMessage());
    }
  }

  public static class DelegatedDeSerializer extends JsonDeserializer<ContactInfoMessage> {
    @Override
    public ContactInfoMessage deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException {

      ContactInfoMessageImpl.Builder builder = new ContactInfoMessageImpl.Builder();
      ContactInfoMessageInternalImpl deserialized =
          jp.readValueAs(ContactInfoMessageInternalImpl.class);
      builder.setContactInfoMessage(deserialized);
      return builder.build();
    }
  }

  public static Optional<ContactInfoMessage> delegatedConverter(
      ContactInfoMessageInternal internal) {
    if (null == internal) {
      return Optional.empty();
    }
    return Optional.of(new Builder().setContactInfoMessage(internal).build());
  }
}
