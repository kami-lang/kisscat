package com.meowool.kisscat

/**
 * Represents an annotation applied to [Member].
 *
 * @author 凛 (RinOrz)
 */
public interface Annotation {

  /**
   * The type of this annotation.
   */
  public var type: Type

  /**
   * The expected visibility of this annotation.
   */
  public var visibility: Visibility

  /**
   * The call actual parameters of this annotation.
   * For example: `@Annotation(a = 0x0, b = 0x1)`, this value is `a = 0x0, b = 0x1`.
   */
  public val arguments: Array<Argument>

  /**
   * Visibility value of annotation.
   */
  public enum class Visibility {

    /** Represents that the annotation is only visible at build time. */
    Build,

    /** Represents that the annotation is only visible to the system. */
    System,

    /** Represents that the annotation is visible at runtime. */
    Runtime,
  }
}
