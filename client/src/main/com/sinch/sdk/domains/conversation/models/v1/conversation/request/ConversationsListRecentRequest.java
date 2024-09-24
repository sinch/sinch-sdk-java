package com.sinch.sdk.domains.conversation.models.v1.conversation.request;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Parameters request to list recent messages from a conversation
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/conversation/api-reference/conversation/tag/Conversation/#tag/Conversation/operation/Conversation_ListRecentConversations">online
 *     documentation</a>
 * @since 1.3
 */
public interface ConversationsListRecentRequest {

  /**
   * Filtering onto <code>active</code> conversations only or not
   *
   * <p>True if only active conversations should be listed.
   *
   * @default False
   * @return Only active filter
   */
  Optional<Boolean> getOnlyActive();

  /**
   * Id of the application.
   *
   * @return application id
   */
  Optional<String> getAppId();

  /**
   * Maximum number of conversations to fetch.
   *
   * <p>Defaults to 10 and the maximum is 50.
   *
   * @default 10
   * @return Page size
   */
  Optional<Integer> getPageSize();

  /**
   * Next page token previously returned if any.
   *
   * <p>When specifying this token, make sure to use the same values for the other parameters from
   * the request that originated the token, otherwise the paged results may be inconsistent.
   *
   * @return Page token
   */
  Optional<String> getPageToken();

  /**
   * Only fetch conversations from the active channel
   *
   * @return Channel to filtered on
   */
  Optional<OrderEnum> getOrder();

  public class OrderEnum extends EnumDynamic<String, OrderEnum> {
    public static final OrderEnum ASC = new OrderEnum("ASC");
    public static final OrderEnum DESC = new OrderEnum("DESC");

    private static final EnumSupportDynamic<String, OrderEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(OrderEnum.class, OrderEnum::new, Arrays.asList(ASC, DESC));

    private OrderEnum(String value) {
      super(value);
    }

    public static Stream<OrderEnum> values() {
      return ENUM_SUPPORT.values();
    }

    public static OrderEnum from(String value) {
      return ENUM_SUPPORT.from(value);
    }

    public static String valueOf(OrderEnum e) {
      return ENUM_SUPPORT.valueOf(e);
    }
  }

  static Builder builder() {
    return new ConversationsListRecentRequestImpl.Builder();
  }

  static Builder builder(ConversationsListRecentRequest parameters) {
    return new ConversationsListRecentRequestImpl.Builder(parameters);
  }

  interface Builder {

    /**
     * see getter
     *
     * @param onlyActive see getter
     * @return Current builder
     * @see #setOnlyActive(Boolean) ()
     */
    Builder setOnlyActive(Boolean onlyActive);

    /**
     * see getter
     *
     * @param appId see getter
     * @return Current builder
     * @see #getAppId()
     */
    Builder setAppId(String appId);

    /**
     * see getter
     *
     * @param pageSize see getter
     * @return Current builder
     * @see #getPageSize()
     */
    Builder setPageSize(Integer pageSize);

    /**
     * see getter
     *
     * @param pageToken see getter
     * @return Current builder
     * @see #getPageToken()
     */
    Builder setPageToken(String pageToken);

    /**
     * see getter
     *
     * @param order see getter
     * @return Current builder
     * @see #getOrder() ()
     */
    Builder setOrder(OrderEnum order);

    ConversationsListRecentRequest build();
  }
}
