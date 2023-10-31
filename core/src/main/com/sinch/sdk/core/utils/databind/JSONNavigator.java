package com.sinch.sdk.core.utils.databind;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// @javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class JSONNavigator {

  /** A map of discriminators for all model classes. */
  private static final Map<Class<?>, ClassDiscriminatorMapping> modelDiscriminators =
      new HashMap<>();
  /** A map of oneOf/anyOf descendants for each model class. */
  private static final Map<Class<?>, Map<String, Class<?>>> modelDescendants = new HashMap<>();

  private static JSONNavigator jsonNavigator;

  static {
    jsonNavigator = new JSONNavigator();
  }

  /**
   * Returns the target model class that should be used to deserialize the input data. The
   * discriminator mappings are used to determine the target model class.
   *
   * @param node The input data.
   * @param modelClass The class that contains the discriminator mappings.
   * @return the target model class.
   */
  public static Class<?> getClassForElement(JsonNode node, Class<?> modelClass) {
    ClassDiscriminatorMapping cdm = modelDiscriminators.get(modelClass);
    if (cdm != null) {
      return cdm.getClassForElement(node, new HashSet<Class<?>>());
    }
    return null;
  }

  /**
   * Returns true if inst is an instance of modelClass in the OpenAPI model hierarchy.
   *
   * <p>The Java class hierarchy is not implemented the same way as the OpenAPI model hierarchy, so
   * it's not possible to use the instanceof keyword.
   *
   * @param modelClass A OpenAPI model class.
   * @param inst The instance object.
   * @param visitedClasses The set of classes that have already been visited.
   * @return true if inst is an instance of modelClass in the OpenAPI model hierarchy.
   */
  public static boolean isInstanceOf(
      Class<?> modelClass, Object inst, Set<Class<?>> visitedClasses) {
    if (modelClass.isInstance(inst)) {
      // This handles the 'allOf' use case with single parent inheritance.
      return true;
    }
    if (visitedClasses.contains(modelClass)) {
      // This is to prevent infinite recursion when the composed schemas have
      // a circular dependency.
      return false;
    }
    visitedClasses.add(modelClass);

    // Traverse the oneOf/anyOf composed schemas.
    Map<String, Class<?>> descendants = modelDescendants.get(modelClass);
    if (descendants != null) {
      for (Class<?> childType : descendants.values()) {
        if (isInstanceOf(childType, inst, visitedClasses)) {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * Register a model class discriminator.
   *
   * @param modelClass the model class
   * @param discriminatorPropertyName the name of the discriminator property
   * @param mappings a map with the discriminator mappings.
   */
  public static void registerDiscriminator(
      Class<?> modelClass, String discriminatorPropertyName, Map<String, Class<?>> mappings) {
    ClassDiscriminatorMapping m =
        new ClassDiscriminatorMapping(modelClass, discriminatorPropertyName, mappings);
    modelDiscriminators.put(modelClass, m);
  }

  /**
   * Register the oneOf/anyOf descendants of the modelClass.
   *
   * @param modelClass the model class
   * @param descendants a map of oneOf/anyOf descendants.
   */
  public static void registerDescendants(Class<?> modelClass, Map<String, Class<?>> descendants) {
    modelDescendants.put(modelClass, descendants);
  }

  /**
   * Get the default JSONNavigator instance.
   *
   * @return the default JSONNavigator instance
   */
  public static JSONNavigator getDefault() {
    return jsonNavigator;
  }

  /**
   * Set the default JSONNavigator instance.
   *
   * @param jsonNavigator JSONNavigator instance to be used
   */
  public static void setDefault(JSONNavigator jsonNavigator) {
    JSONNavigator.jsonNavigator = jsonNavigator;
  }

  /** Helper class to register the discriminator mappings. */
  private static class ClassDiscriminatorMapping {
    // The model class name.
    Class<?> modelClass;
    // The name of the discriminator property.
    String discriminatorName;
    // The discriminator mappings for a model class.
    Map<String, Class<?>> discriminatorMappings;

    // Constructs a new class discriminator.
    ClassDiscriminatorMapping(Class<?> cls, String propertyName, Map<String, Class<?>> mappings) {
      modelClass = cls;
      discriminatorName = propertyName;
      discriminatorMappings = new HashMap<String, Class<?>>();
      if (mappings != null) {
        discriminatorMappings.putAll(mappings);
      }
    }

    // Return the name of the discriminator property for this model class.
    String getDiscriminatorPropertyName() {
      return discriminatorName;
    }

    // Return the discriminator value or null if the discriminator is not
    // present in the payload.
    String getDiscriminatorValue(JsonNode node) {
      // Determine the value of the discriminator property in the input data.
      if (discriminatorName != null) {
        // Get the value of the discriminator property, if present in the input payload.
        node = node.get(discriminatorName);
        if (node != null && node.isValueNode()) {
          String discrValue = node.asText();
          return discrValue;
        }
      }
      return null;
    }

    /**
     * Returns the target model class that should be used to deserialize the input data. This
     * function can be invoked for anyOf/oneOf composed models with discriminator mappings. The
     * discriminator mappings are used to determine the target model class.
     *
     * @param node The input data.
     * @param visitedClasses The set of classes that have already been visited.
     * @return the target model class.
     */
    Class<?> getClassForElement(JsonNode node, Set<Class<?>> visitedClasses) {
      if (visitedClasses.contains(modelClass)) {
        // Class has already been visited.
        return null;
      }
      // Determine the value of the discriminator property in the input data.
      String discrValue = getDiscriminatorValue(node);
      if (discrValue == null) {
        return null;
      }
      Class<?> cls = discriminatorMappings.get(discrValue);
      // It may not be sufficient to return this cls directly because that target class
      // may itself be a composed schema, possibly with its own discriminator.
      visitedClasses.add(modelClass);
      for (Class<?> childClass : discriminatorMappings.values()) {
        ClassDiscriminatorMapping childCdm = modelDiscriminators.get(childClass);
        if (childCdm == null) {
          continue;
        }
        if (!discriminatorName.equals(childCdm.discriminatorName)) {
          discrValue = getDiscriminatorValue(node);
          if (discrValue == null) {
            continue;
          }
        }
        if (childCdm != null) {
          // Recursively traverse the discriminator mappings.
          Class<?> childDiscr = childCdm.getClassForElement(node, visitedClasses);
          if (childDiscr != null) {
            return childDiscr;
          }
        }
      }
      return cls;
    }
  }
}
