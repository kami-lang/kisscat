package com.meowool.kisscat.internal

/**
 * Used to mark APIs that are not available externally.
 *
 * @author 凛 (https://github.com/RinOrz)
 */
@RequiresOptIn(
  level = RequiresOptIn.Level.ERROR,
  message = "This is an internal 'com.meowool.kisscat' API that should not be used from outside."
)
public annotation class InternalKisscatApi