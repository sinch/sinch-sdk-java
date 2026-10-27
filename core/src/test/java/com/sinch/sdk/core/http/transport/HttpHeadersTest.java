package com.sinch.sdk.core.http.transport;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class HttpHeadersTest {

  @Test
  void lookupIsCaseInsensitive() {
    HttpHeaders headers = new HttpHeaders().add("Content-Type", "application/json");

    assertEquals(Optional.of("application/json"), headers.getFirst("content-type"));
    assertEquals(Collections.singletonList("application/json"), headers.getAll("CONTENT-TYPE"));
    assertTrue(headers.contains("cOnTeNt-TyPe"));
  }

  @Test
  void addKeepsEveryValueInOrder() {
    HttpHeaders headers =
        new HttpHeaders()
            .add("Set-Cookie", "a=1")
            .add("set-cookie", "b=2")
            .add("SET-COOKIE", "c=3");

    assertEquals(Arrays.asList("a=1", "b=2", "c=3"), headers.getAll("Set-Cookie"));
    assertEquals(Optional.of("a=1"), headers.getFirst("set-cookie"));
  }

  @Test
  void setReplacesEveryValue() {
    HttpHeaders headers =
        new HttpHeaders().add("Accept", "a").add("Accept", "b").set("accept", "c");

    assertEquals(Collections.singletonList("c"), headers.getAll("Accept"));
  }

  @Test
  void namesKeepTheirFirstPositionAndCase() {
    HttpHeaders headers =
        new HttpHeaders().add("X-First", "1").add("X-Second", "2").set("x-first", "3");

    assertEquals(Arrays.asList("X-First", "X-Second"), new ArrayList<>(headers.getNames()));
  }

  @Test
  void forEachVisitsEveryValueInOrder() {
    HttpHeaders headers = new HttpHeaders().add("A", "1").add("B", "2").add("a", "3");
    List<String> visited = new ArrayList<>();

    headers.forEach((name, value) -> visited.add(name + "=" + value));

    assertEquals(Arrays.asList("A=1", "A=3", "B=2"), visited);
  }

  @Test
  void removeDropsEveryValue() {
    HttpHeaders headers = new HttpHeaders().add("A", "1").add("A", "2");

    assertTrue(headers.remove("a"));
    assertFalse(headers.remove("a"));
    assertFalse(headers.contains("A"));
    assertTrue(headers.isEmpty());
    assertEquals(Collections.emptyList(), headers.getAll("A"));
    assertEquals(Optional.empty(), headers.getFirst("A"));
  }

  @Test
  void copyIsIndependent() {
    HttpHeaders source = new HttpHeaders().add("A", "1");
    HttpHeaders copy = new HttpHeaders(source);

    copy.add("A", "2").add("B", "3");

    assertEquals(Collections.singletonList("1"), source.getAll("A"));
    assertFalse(source.contains("B"));
  }

  @Test
  void returnedValuesCannotModifyTheHeaders() {
    HttpHeaders headers = new HttpHeaders().add("A", "1");

    assertThrows(UnsupportedOperationException.class, () -> headers.getAll("A").add("2"));
    headers.toMap().get("A").add("2");

    assertEquals(Collections.singletonList("1"), headers.getAll("A"));
  }

  @Test
  void toMapKeepsNamesAndOrder() {
    HttpHeaders headers = new HttpHeaders().add("B", "1").add("A", "2").add("b", "3");
    Map<String, List<String>> expected = new LinkedHashMap<>();
    expected.put("B", Arrays.asList("1", "3"));
    expected.put("A", Collections.singletonList("2"));

    assertEquals(expected, headers.toMap());
    assertEquals(Arrays.asList("B", "A"), new ArrayList<>(headers.toMap().keySet()));
  }

  @Test
  void equalityIgnoresNameCase() {
    assertEquals(new HttpHeaders().add("A", "1"), new HttpHeaders().add("a", "1"));
    assertNotEquals(new HttpHeaders().add("A", "1"), new HttpHeaders().add("A", "2"));
  }

  @Test
  void nullNamesAndValuesAreRejected() {
    HttpHeaders headers = new HttpHeaders();

    assertThrows(NullPointerException.class, () -> headers.add(null, "1"));
    assertThrows(NullPointerException.class, () -> headers.add("A", null));
    assertThrows(NullPointerException.class, () -> headers.set("A", null));
  }
}
