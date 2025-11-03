package com.sinch.sdk.domains.conversation.api.v1;

import com.sinch.sdk.domains.conversation.models.v1.projectsettings.request.ProjectSettingsRequest;
import com.sinch.sdk.domains.conversation.models.v1.projectsettings.response.ProjectSettingsResponse;

/**
 * Project Settings related service
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/conversation/api-reference/conversation/project-settings">https://developers.sinch.com/docs/conversation/api-reference/conversation/project-settings</a>
 * @since 2.0
 */
public interface ProjectSettingsService {

  /**
   * Create Project Settings Creates initial settings for the project. Useful for enabling features
   * like Unified Contact ID. For new projects with no existing contacts, you can enable Unified
   * Contact ID immediately.
   *
   * @param projectSettingsRequest The project settings to create. (required)
   * @return ProjectSettingsResponse
   */
  ProjectSettingsResponse create(ProjectSettingsRequest projectSettingsRequest);

  /** Delete Project Settings Deletes all project-level settings for the specified project. */
  void delete();

  /**
   * Get Project Settings Retrieves the current settings for the specified project, including
   * contact management options such as Unified Contact ID.
   *
   * @return ProjectSettingsResponse
   */
  ProjectSettingsResponse get();

  /**
   * Update Project Settings Updates project settings (e.g. enabling/disabling Unified Contact ID).
   * For existing projects, you must resolve all identity conflicts before enabling Unified Contact
   * ID.
   *
   * @param projectSettingsRequest The project settings to update. (required)
   * @return ProjectSettingsResponse
   */
  ProjectSettingsResponse update(ProjectSettingsRequest projectSettingsRequest);
}
