/*
 * Conversation API | Sinch
 *
 * OpenAPI document version: 1.0
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.conversation.models.v1.events.types.internal;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Object which contains information of a comment made by an user outside of the main conversation
 * context. Currently only supported on Instagram channel, see Instagram Private Replies for more
 * details
 */
@JsonDeserialize(builder = CommentEventInternalImpl.Builder.class)
public interface CommentEventInternal {

  /**
   * Event's ID
   *
   * @return id
   */
  String getId();

  /**
   * Comment's text
   *
   * @return text
   */
  String getText();

  /** Either LIVE or FEED. Indicates the type of media on which the comment was made. */
  public class CommentTypeEnum extends EnumDynamic<String, CommentTypeEnum> {
    public static final CommentTypeEnum FEED = new CommentTypeEnum("FEED");
    public static final CommentTypeEnum LIVE = new CommentTypeEnum("LIVE");

    private static final EnumSupportDynamic<String, CommentTypeEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(
            CommentTypeEnum.class, CommentTypeEnum::new, Arrays.asList(FEED, LIVE));

    private CommentTypeEnum(String value) {
      super(value);
    }

    public static Stream<CommentTypeEnum> values() {
      return ENUM_SUPPORT.values();
    }

    public static CommentTypeEnum from(String value) {
      return ENUM_SUPPORT.from(value);
    }

    public static String valueOf(CommentTypeEnum e) {
      return ENUM_SUPPORT.valueOf(e);
    }
  }

  /**
   * Either LIVE or FEED. Indicates the type of media on which the comment was made.
   *
   * @return commentType
   */
  CommentTypeEnum getCommentType();

  /**
   * Instagram's URL of the live broadcast or the post on which the comment was made (permalink).
   *
   * @return commentedOn
   */
  String getCommentedOn();

  /**
   * Username of the account that commented in the live broadcast or post.
   *
   * @return user
   */
  String getUser();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new CommentEventInternalImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param id see getter
     * @return Current builder
     * @see #getId
     */
    Builder setId(String id);

    /**
     * see getter
     *
     * @param text see getter
     * @return Current builder
     * @see #getText
     */
    Builder setText(String text);

    /**
     * see getter
     *
     * @param commentType see getter
     * @return Current builder
     * @see #getCommentType
     */
    Builder setCommentType(CommentTypeEnum commentType);

    /**
     * see getter
     *
     * @param commentedOn see getter
     * @return Current builder
     * @see #getCommentedOn
     */
    Builder setCommentedOn(String commentedOn);

    /**
     * see getter
     *
     * @param user see getter
     * @return Current builder
     * @see #getUser
     */
    Builder setUser(String user);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    CommentEventInternal build();
  }
}
