package com.sinch.sdk.domains.conversation.adapters.messages;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.core.utils.databind.Mapper;
import com.sinch.sdk.domains.conversation.models.v1.messages.ChoiceItem;
import com.sinch.sdk.domains.conversation.models.v1.messages.ListItem;
import com.sinch.sdk.domains.conversation.models.v1.messages.ListSectionImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.ProductItem;
import com.sinch.sdk.domains.conversation.models.v1.messages.internal.ListItemOneOfChoiceInternal;
import com.sinch.sdk.domains.conversation.models.v1.messages.internal.ListItemOneOfInternalImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.internal.ListItemOneOfProductInternal;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

@JsonFilter("uninitializedFilter")
public class ListSectionMapper<T> extends ListSectionImpl<T> {

  private static final Logger LOGGER = Logger.getLogger(ListSectionMapper.class.getName());

  public ListSectionMapper() {
    super();
  }

  public static void initMapper() {
    Mapper.getInstance().addMixIn(ListSectionImpl.class, ListSectionMapper.class);
  }

  @Override
  @JsonSerialize(using = ListSectionSerializer.class)
  public OptionalValue<List<ListItem<T>>> items() {
    return super.items();
  }

  static class ListSectionSerializer<T> extends JsonSerializer<OptionalValue<List<ListItem<T>>>> {

    public ListSectionSerializer() {
      super();
    }

    @Override
    public void serialize(
        OptionalValue<List<ListItem<T>>> optional, JsonGenerator jgen, SerializerProvider provider)
        throws IOException {

      if (!optional.isPresent()) {
        return;
      }

      jgen.writeStartArray();
      for (ListItem<?> item : optional.get()) {
        ListItemOneOfInternalImpl internal = new ListItemOneOfInternalImpl();

        if (item instanceof ChoiceItem) {
          internal.setActualInstance(
              ListItemOneOfChoiceInternal.builder().setChoice((ChoiceItem) item).build());
        } else if (item instanceof ProductItem) {
          internal.setActualInstance(
              ListItemOneOfProductInternal.builder().setProduct((ProductItem) item).build());
        } else {
          LOGGER.severe("Unexpected class '" + item.getClass() + "'");
        }
        jgen.writeObject(internal);
      }
      jgen.writeEndArray();
    }
  }
}
