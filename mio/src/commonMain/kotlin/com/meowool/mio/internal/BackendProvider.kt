package com.meowool.mio.internal

/**
 * Provide a backend instance of the implementation, see [backend].
 *
 * @author 凛 (RinOrz)
 */
internal interface BackendProvider<T> {
  val backend: T
}
