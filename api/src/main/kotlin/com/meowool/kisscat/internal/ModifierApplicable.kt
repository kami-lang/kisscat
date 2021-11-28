package com.meowool.kisscat.internal

import com.meowool.kisscat.Modifier

/**
 * [Modifier.applicable]
 *
 * @author 凛 (https://github.com/RinOrz)
 */
@InternalKisscatApi
public object ModifierApplicable {
  public const val All: Int = 0
  public const val ClassesProperties: Int = 1
  public const val ClassesFunctions: Int = 2
  public const val Classes: Int = 3
  public const val Properties: Int = 3
  public const val Functions: Int = 3
}