package com.meowool.kisscat

/**
 * Represents a function, which is a member of the [Class] structure.
 *
 * @author 凛 (RinOrz)
 */
public interface Function : Member<Class> {

  /**
   * The parameter list of this function.
   */
  public val parameters: MutableList<Parameter>

  /**
   * The declared return type of this function.
   */
  public var returnType: Type
}