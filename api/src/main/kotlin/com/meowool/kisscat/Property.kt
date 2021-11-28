package com.meowool.kisscat

/**
 * Represents a property, which is a member of the [Class] structure.
 *
 * @author 凛 (https://github.com/RinOrz)
 */
public interface Property : Member<Class> {

  /**
   * The declared type of this property.
   */
  public var type: Type

  /**
   * The 'getter' (aka 'accessor') associated with this property.
   * [Reference](https://en.wikipedia.org/wiki/Mutator_method)
   *
   * Generally, if there are the following similar declarations (consider this rule: the function return type is the
   * same as the property, and the name of the function is "get" + capitalized property name), they will all be
   * considered as getter functions:
   *
   * ```kotlin
   * var property: Boolean = false
   * fun getProperty(): Boolean = property
   * ```
   *
   * ```kotlin
   * var property: Boolean = false
   *   get() = field
   * ```
   *
   * ```java
   * boolean field;
   * boolean getField() {
   *   return field;
   * }
   * ```
   */
  public var getter: Accessor?

  /**
   * The 'setter' (aka 'mutator') associated with this property.
   * [Reference](https://en.wikipedia.org/wiki/Mutator_method)
   *
   * Generally, if there are the following similar declarations (consider this rule: the function has only one
   * parameter type, and it is the same as the property, and the name of the function is "set" + capitalized property
   * name), they will all be considered as setter functions:
   *
   * Generally, if there are the following similar declarations, they will all be considered as setter functions:
   *
   * ```kotlin
   * var property: Boolean = false
   * fun setProperty(value: String) {
   *   property = value
   * }
   * ```
   *
   * ```kotlin
   * var property: Boolean = false
   *   set(value) {
   *     field = value
   *   }
   * ```
   *
   * ```java
   * boolean field;
   * void setField(boolean value) {
   *   field = value;
   * }
   * ```
   */
  public var setter: Accessor?

  /**
   * Represents a function that access or control the value of a [associated] property.
   *
   * @author 凛 (https://github.com/RinOrz)
   */
  public interface Accessor : Function {

    /**
     * The property associated with this accessor function.
     */
    public val associated: Property
  }
}