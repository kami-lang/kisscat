package com.meowool.kisscat

/**
 * Represents a member belonging to [T]
 *
 * @author 凛 (RinOrz)
 */
public interface Member<T> {

  /**
   * The name of this member.
   */
  public var name: String

  /**
   * All annotations of this member.
   */
  public val annotations: MutableSet<Annotation>

  /**
   * All modifiers of this member.
   */
  public val modifiers: MutableSet<Modifier>

  /**
   * Whether this member is deprecated.
   */
  public var isDeprecated: Boolean

  /**
   * Type holding this member.
   *
   * @see holder
   */
  public var holderType: Type

  /**
   * Instance holding this member.
   * In other words, this member is declared in the [T] instance.
   */
  public var holder: T
}