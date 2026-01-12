package com.sinch.sdk.domains.numbers.models.v1.numberorder.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.time.Instant;
import java.util.Objects;

@JsonPropertyOrder({
  AttachmentImpl.JSON_PROPERTY_ATTACHMENT_ID,
  AttachmentImpl.JSON_PROPERTY_FILE_NAME,
  AttachmentImpl.JSON_PROPERTY_MIME_TYPE,
  AttachmentImpl.JSON_PROPERTY_CREATE_TIME,
  AttachmentImpl.JSON_PROPERTY_UPDATE_TIME,
  AttachmentImpl.JSON_PROPERTY_UPLOAD_STATUS,
  AttachmentImpl.JSON_PROPERTY_DOCUMENT_TYPE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class AttachmentImpl implements Attachment {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_ATTACHMENT_ID = "attachmentId";

  private OptionalValue<String> attachmentId;

  public static final String JSON_PROPERTY_FILE_NAME = "fileName";

  private OptionalValue<String> fileName;

  public static final String JSON_PROPERTY_MIME_TYPE = "mimeType";

  private OptionalValue<String> mimeType;

  public static final String JSON_PROPERTY_CREATE_TIME = "createTime";

  private OptionalValue<Instant> createTime;

  public static final String JSON_PROPERTY_UPDATE_TIME = "updateTime";

  private OptionalValue<Instant> updateTime;

  public static final String JSON_PROPERTY_UPLOAD_STATUS = "uploadStatus";

  private OptionalValue<UploadStatus> uploadStatus;

  public static final String JSON_PROPERTY_DOCUMENT_TYPE = "documentType";

  private OptionalValue<String> documentType;

  public AttachmentImpl() {}

  protected AttachmentImpl(
      OptionalValue<String> attachmentId,
      OptionalValue<String> fileName,
      OptionalValue<String> mimeType,
      OptionalValue<Instant> createTime,
      OptionalValue<Instant> updateTime,
      OptionalValue<UploadStatus> uploadStatus,
      OptionalValue<String> documentType) {
    this.attachmentId = attachmentId;
    this.fileName = fileName;
    this.mimeType = mimeType;
    this.createTime = createTime;
    this.updateTime = updateTime;
    this.uploadStatus = uploadStatus;
    this.documentType = documentType;
  }

  @JsonIgnore
  public String getAttachmentId() {
    return attachmentId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ATTACHMENT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> attachmentId() {
    return attachmentId;
  }

  @JsonIgnore
  public String getFileName() {
    return fileName.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_FILE_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> fileName() {
    return fileName;
  }

  @JsonIgnore
  public String getMimeType() {
    return mimeType.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MIME_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> mimeType() {
    return mimeType;
  }

  @JsonIgnore
  public Instant getCreateTime() {
    return createTime.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CREATE_TIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Instant> createTime() {
    return createTime;
  }

  @JsonIgnore
  public Instant getUpdateTime() {
    return updateTime.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_UPDATE_TIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Instant> updateTime() {
    return updateTime;
  }

  @JsonIgnore
  public UploadStatus getUploadStatus() {
    return uploadStatus.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_UPLOAD_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<UploadStatus> uploadStatus() {
    return uploadStatus;
  }

  @JsonIgnore
  public String getDocumentType() {
    return documentType.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DOCUMENT_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> documentType() {
    return documentType;
  }

  /** Return true if this Attachment object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AttachmentImpl attachment = (AttachmentImpl) o;
    return Objects.equals(this.attachmentId, attachment.attachmentId)
        && Objects.equals(this.fileName, attachment.fileName)
        && Objects.equals(this.mimeType, attachment.mimeType)
        && Objects.equals(this.createTime, attachment.createTime)
        && Objects.equals(this.updateTime, attachment.updateTime)
        && Objects.equals(this.uploadStatus, attachment.uploadStatus)
        && Objects.equals(this.documentType, attachment.documentType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        attachmentId, fileName, mimeType, createTime, updateTime, uploadStatus, documentType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AttachmentImpl {\n");
    sb.append("    attachmentId: ").append(toIndentedString(attachmentId)).append("\n");
    sb.append("    fileName: ").append(toIndentedString(fileName)).append("\n");
    sb.append("    mimeType: ").append(toIndentedString(mimeType)).append("\n");
    sb.append("    createTime: ").append(toIndentedString(createTime)).append("\n");
    sb.append("    updateTime: ").append(toIndentedString(updateTime)).append("\n");
    sb.append("    uploadStatus: ").append(toIndentedString(uploadStatus)).append("\n");
    sb.append("    documentType: ").append(toIndentedString(documentType)).append("\n");
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
  static class Builder implements Attachment.Builder {
    OptionalValue<String> attachmentId = OptionalValue.empty();
    OptionalValue<String> fileName = OptionalValue.empty();
    OptionalValue<String> mimeType = OptionalValue.empty();
    OptionalValue<Instant> createTime = OptionalValue.empty();
    OptionalValue<Instant> updateTime = OptionalValue.empty();
    OptionalValue<UploadStatus> uploadStatus = OptionalValue.empty();
    OptionalValue<String> documentType = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_ATTACHMENT_ID)
    public Builder setAttachmentId(String attachmentId) {
      this.attachmentId = OptionalValue.of(attachmentId);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_FILE_NAME)
    public Builder setFileName(String fileName) {
      this.fileName = OptionalValue.of(fileName);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_MIME_TYPE)
    public Builder setMimeType(String mimeType) {
      this.mimeType = OptionalValue.of(mimeType);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CREATE_TIME)
    public Builder setCreateTime(Instant createTime) {
      this.createTime = OptionalValue.of(createTime);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_UPDATE_TIME)
    public Builder setUpdateTime(Instant updateTime) {
      this.updateTime = OptionalValue.of(updateTime);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_UPLOAD_STATUS)
    public Builder setUploadStatus(UploadStatus uploadStatus) {
      this.uploadStatus = OptionalValue.of(uploadStatus);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_DOCUMENT_TYPE)
    public Builder setDocumentType(String documentType) {
      this.documentType = OptionalValue.of(documentType);
      return this;
    }

    public Attachment build() {
      return new AttachmentImpl(
          attachmentId, fileName, mimeType, createTime, updateTime, uploadStatus, documentType);
    }
  }
}
