package com.meowool.kisscat

/**
 * Represents the definition of a formal-parameter.
 *
 * @author 凛 (https://github.com/RinOrz)
 */
public interface Parameter {

  /**
   * The name of this parameter.
   * This value can be `null`, e.g, the parameter name is not defined.
   */
  public var name: String?

  /**
   * The type of this parameter
   */
  public var type: Type

  /**
   * This parameter is based on the index of `0` in its parameter list.
   *
   * For example: `(String, Int)`, the current parameter [type] is Int, then the index is `1`.
   */
  public var index: Int
}