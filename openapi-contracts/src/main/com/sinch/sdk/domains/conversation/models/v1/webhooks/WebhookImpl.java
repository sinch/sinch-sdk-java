package com.sinch.sdk.domains.conversation.models.v1.webhooks;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  WebhookImpl.JSON_PROPERTY_APP_ID,
  WebhookImpl.JSON_PROPERTY_CLIENT_CREDENTIALS,
  WebhookImpl.JSON_PROPERTY_ID,
  WebhookImpl.JSON_PROPERTY_SECRET,
  WebhookImpl.JSON_PROPERTY_TARGET,
  WebhookImpl.JSON_PROPERTY_TARGET_TYPE,
  WebhookImpl.JSON_PROPERTY_TRIGGERS
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class WebhookImpl implements Webhook {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_APP_ID = "app_id";

  private OptionalValue<String> appId;

  public static final String JSON_PROPERTY_CLIENT_CREDENTIALS = "client_credentials";

  private OptionalValue<ClientCredentials> clientCredentials;

  public static final String JSON_PROPERTY_ID = "id";

  private OptionalValue<String> id;

  public static final String JSON_PROPERTY_SECRET = "secret";

  private OptionalValue<String> secret;

  public static final String JSON_PROPERTY_TARGET = "target";

  private OptionalValue<String> target;

  public static final String JSON_PROPERTY_TARGET_TYPE = "target_type";

  private OptionalValue<WebhookTargetType> targetType;

  public static final String JSON_PROPERTY_TRIGGERS = "triggers";

  private OptionalValue<List<WebhookTrigger>> triggers;

  public WebhookImpl() {}

  protected WebhookImpl(
      OptionalValue<String> appId,
      OptionalValue<ClientCredentials> clientCredentials,
      OptionalValue<String> id,
      OptionalValue<String> secret,
      OptionalValue<String> target,
      OptionalValue<WebhookTargetType> targetType,
      OptionalValue<List<WebhookTrigger>> triggers) {
    this.appId = appId;
    this.clientCredentials = clientCredentials;
    this.id = id;
    this.secret = secret;
    this.target = target;
    this.targetType = targetType;
    this.triggers = triggers;
  }

  @JsonIgnore
  public String getAppId() {
    return appId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_APP_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> appId() {
    return appId;
  }

  @JsonIgnore
  public ClientCredentials getClientCredentials() {
    return clientCredentials.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CLIENT_CREDENTIALS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ClientCredentials> clientCredentials() {
    return clientCredentials;
  }

  @JsonIgnore
  public String getId() {
    return id.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> id() {
    return id;
  }

  @JsonIgnore
  public String getSecret() {
    return secret.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SECRET)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> secret() {
    return secret;
  }

  @JsonIgnore
  public String getTarget() {
    return target.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TARGET)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> target() {
    return target;
  }

  @JsonIgnore
  public WebhookTargetType getTargetType() {
    return targetType.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TARGET_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<WebhookTargetType> targetType() {
    return targetType;
  }

  @JsonIgnore
  public List<WebhookTrigger> getTriggers() {
    return triggers.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TRIGGERS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<List<WebhookTrigger>> triggers() {
    return triggers;
  }

  /** Return true if this Webhook object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WebhookImpl webhook = (WebhookImpl) o;
    return Objects.equals(this.appId, webhook.appId)
        && Objects.equals(this.clientCredentials, webhook.clientCredentials)
        && Objects.equals(this.id, webhook.id)
        && Objects.equals(this.secret, webhook.secret)
        && Objects.equals(this.target, webhook.target)
        && Objects.equals(this.targetType, webhook.targetType)
        && Objects.equals(this.triggers, webhook.triggers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(appId, clientCredentials, id, secret, target, targetType, triggers);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WebhookImpl {\n");
    sb.append("    appId: ").append(toIndentedString(appId)).append("\n");
    sb.append("    clientCredentials: ").append(toIndentedString(clientCredentials)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    secret: ").append(toIndentedString("***")).append("\n");
    sb.append("    target: ").append(toIndentedString(target)).append("\n");
    sb.append("    targetType: ").append(toIndentedString(targetType)).append("\n");
    sb.append("    triggers: ").append(toIndentedString(triggers)).append("\n");
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
  static class Builder implements Webhook.Builder {
    OptionalValue<String> appId = OptionalValue.empty();
    OptionalValue<ClientCredentials> clientCredentials = OptionalValue.empty();
    OptionalValue<String> id = OptionalValue.empty();
    OptionalValue<String> secret = OptionalValue.empty();
    OptionalValue<String> target = OptionalValue.empty();
    OptionalValue<WebhookTargetType> targetType = OptionalValue.empty();
    OptionalValue<List<WebhookTrigger>> triggers = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_APP_ID)
    public Builder setAppId(String appId) {
      this.appId = OptionalValue.of(appId);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CLIENT_CREDENTIALS)
    public Builder setClientCredentials(ClientCredentials clientCredentials) {
      this.clientCredentials = OptionalValue.of(clientCredentials);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_ID)
    public Builder setId(String id) {
      this.id = OptionalValue.of(id);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_SECRET)
    public Builder setSecret(String secret) {
      this.secret = OptionalValue.of(secret);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_TARGET)
    public Builder setTarget(String target) {
      this.target = OptionalValue.of(target);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_TARGET_TYPE)
    public Builder setTargetType(WebhookTargetType targetType) {
      this.targetType = OptionalValue.of(targetType);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_TRIGGERS)
    public Builder setTriggers(List<WebhookTrigger> triggers) {
      this.triggers = OptionalValue.of(triggers);
      return this;
    }

    public Webhook build() {
      return new WebhookImpl(appId, clientCredentials, id, secret, target, targetType, triggers);
    }
  }
}
