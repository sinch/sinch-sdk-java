package com.sinch.sdk.domains.numbers.models.v1.numberorder.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@JsonPropertyOrder({
  RegistrationImpl.JSON_PROPERTY_DATA,
  RegistrationImpl.JSON_PROPERTY_ATTACHMENTS
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class RegistrationImpl implements Registration {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_DATA = "data";

  private OptionalValue<Map<String, Object>> data;

  public static final String JSON_PROPERTY_ATTACHMENTS = "attachments";

  private OptionalValue<List<Attachment>> attachments;

  public RegistrationImpl() {}

  protected RegistrationImpl(
      OptionalValue<Map<String, Object>> data, OptionalValue<List<Attachment>> attachments) {
    this.data = data;
    this.attachments = attachments;
  }

  @JsonIgnore
  public Map<String, Object> getData() {
    return data.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DATA)
  @JsonInclude(content = JsonInclude.Include.ALWAYS, value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Map<String, Object>> data() {
    return data;
  }

  @JsonIgnore
  public List<Attachment> getAttachments() {
    return attachments.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ATTACHMENTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<Attachment>> attachments() {
    return attachments;
  }

  /** Return true if this Registration object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RegistrationImpl registration = (RegistrationImpl) o;
    return Objects.equals(this.data, registration.data)
        && Objects.equals(this.attachments, registration.attachments);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data, attachments);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RegistrationImpl {\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    attachments: ").append(toIndentedString(attachments)).append("\n");
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
  static class Builder implements Registration.Builder {
    OptionalValue<Map<String, Object>> data = OptionalValue.empty();
    OptionalValue<List<Attachment>> attachments = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_DATA)
    public Builder setData(Map<String, Object> data) {
      this.data = OptionalValue.of(data);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_ATTACHMENTS)
    public Builder setAttachments(List<Attachment> attachments) {
      this.attachments = OptionalValue.of(attachments);
      return this;
    }

    public Registration build() {
      return new RegistrationImpl(data, attachments);
    }
  }
}
