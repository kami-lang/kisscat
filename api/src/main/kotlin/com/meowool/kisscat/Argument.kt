package com.meowool.kisscat

import com.meowool.kisscat.code.Value

/**
 * Represents an actual parameter.
 * Generally appear on the call statement: `call(args...)`.
 *
 * @see Parameter
 * @author 凛 (https://github.com/RinOrz)
 */
public interface Argument {

  /**
   * The name of this argument.
   * This value can be `null`, e.g, the argument name is not defined.
   *
   * For example: `arg = 0x1`, this name is `arg`.
   */
  public var name: String?

  /**
   * The value of this argument.
   * For example: `arg = 0x1`, this value is `0x1`.
   */
  public var value: Value

  /**
   * This parameter is based on the index of `0` in its argument list.
   *
   * For example: `(a = "...", b = null)`,
   * the current argument name is `b` and the value is `null`, then the index is `1`.
   */
  public var index: Int
}