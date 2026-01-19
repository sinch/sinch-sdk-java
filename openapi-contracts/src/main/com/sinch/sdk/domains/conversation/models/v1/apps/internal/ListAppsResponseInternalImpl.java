package com.sinch.sdk.domains.conversation.models.v1.apps.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.apps.response.AppResponse;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({ListAppsResponseInternalImpl.JSON_PROPERTY_APPS})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ListAppsResponseInternalImpl implements ListAppsResponseInternal {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_APPS = "apps";

  private OptionalValue<List<AppResponse>> apps;

  public ListAppsResponseInternalImpl() {}

  protected ListAppsResponseInternalImpl(OptionalValue<List<AppResponse>> apps) {
    this.apps = apps;
  }

  @JsonIgnore
  public List<AppResponse> getApps() {
    return apps.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_APPS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<AppResponse>> apps() {
    return apps;
  }

  /** Return true if this ListAppsResponse object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListAppsResponseInternalImpl listAppsResponse = (ListAppsResponseInternalImpl) o;
    return Objects.equals(this.apps, listAppsResponse.apps);
  }

  @Override
  public int hashCode() {
    return Objects.hash(apps);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListAppsResponseInternalImpl {\n");
    sb.append("    apps: ").append(toIndentedString(apps)).append("\n");
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
  static class Builder implements ListAppsResponseInternal.Builder {
    OptionalValue<List<AppResponse>> apps = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_APPS)
    public Builder setApps(List<AppResponse> apps) {
      this.apps = OptionalValue.of(apps);
      return this;
    }

    public ListAppsResponseInternal build() {
      return new ListAppsResponseInternalImpl(apps);
    }
  }
}
