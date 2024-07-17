package com.sinch.sdk.domains.conversation.models.v1.webhooks.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.Webhook;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({ListWebhooksResponseImpl.JSON_PROPERTY_WEBHOOKS})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ListWebhooksResponseImpl implements ListWebhooksResponse {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_WEBHOOKS = "webhooks";

  private OptionalValue<List<Webhook>> webhooks;

  public ListWebhooksResponseImpl() {}

  protected ListWebhooksResponseImpl(OptionalValue<List<Webhook>> webhooks) {
    this.webhooks = webhooks;
  }

  @JsonIgnore
  public List<Webhook> getWebhooks() {
    return webhooks.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_WEBHOOKS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<Webhook>> webhooks() {
    return webhooks;
  }

  /** Return true if this ListWebhooksResponse object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListWebhooksResponseImpl listWebhooksResponse = (ListWebhooksResponseImpl) o;
    return Objects.equals(this.webhooks, listWebhooksResponse.webhooks);
  }

  @Override
  public int hashCode() {
    return Objects.hash(webhooks);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListWebhooksResponseImpl {\n");
    sb.append("    webhooks: ").append(toIndentedString(webhooks)).append("\n");
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
  static class Builder implements ListWebhooksResponse.Builder {
    OptionalValue<List<Webhook>> webhooks = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_WEBHOOKS)
    public Builder setWebhooks(List<Webhook> webhooks) {
      this.webhooks = OptionalValue.of(webhooks);
      return this;
    }

    public ListWebhooksResponse build() {
      return new ListWebhooksResponseImpl(webhooks);
    }
  }
}
