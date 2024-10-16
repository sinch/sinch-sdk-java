package com.sinch.sdk.domains.voice.models.v1.svaml.action;

import static org.junit.jupiter.api.Assertions.*;

import com.sinch.sdk.domains.voice.models.v1.svaml.action.MenuOptionActionFactory.MenuOptionActionType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MenuOptionActionFactoryTest {

  @Test
  void buildMenu() {
    String value = MenuOptionActionFactory.build(MenuOptionActionType.MENU, "my value");
    Assertions.assertEquals(value, "menu(my value)");
  }

  @Test
  void buildReturn() {
    String value = MenuOptionActionFactory.build(MenuOptionActionType.RETURN, "my value");
    Assertions.assertEquals(value, "return(my value)");
  }

  @Test
  void menuAction() {
    String value = MenuOptionActionFactory.menuAction("my value");
    Assertions.assertEquals(value, "menu(my value)");
  }

  @Test
  void returnAction() {
    String value = MenuOptionActionFactory.returnAction("my value");
    Assertions.assertEquals(value, "return(my value)");
  }

  @Test
  void actionRequired() {

    Exception thrown =
        Assertions.assertThrows(
            Exception.class,
            () -> MenuOptionActionFactory.build(null, "my value"),
            "Expected build() to throw, but it didn't");

    Assertions.assertEquals(thrown.getMessage(), "Action type cannot be null");
  }
}
