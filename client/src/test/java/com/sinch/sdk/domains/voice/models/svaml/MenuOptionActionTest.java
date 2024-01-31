package com.sinch.sdk.domains.voice.models.svaml;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MenuOptionActionTest {

  @Test
  void getId() {

    assertEquals("an id", MenuOptionAction.from(MenuOptionActionType.MENU, "an id").getId());
  }

  @Test
  void getType() {
    assertEquals(
        MenuOptionActionType.MENU,
        MenuOptionAction.from(MenuOptionActionType.MENU, "an id").getType());
  }

  @Test
  void throwExceptionOntoNullAction() {
    String value = "Action type cannot be null";
    Exception exception =
        assertThrows(NullPointerException.class, () -> MenuOptionAction.from(null, "an id"));
    assertEquals(exception.getMessage(), value);
  }
}
