@file:Suppress("NOTHING_TO_INLINE")

package com.meowool.mio.internal

import com.meowool.mio.OutOfMemoryError
import com.meowool.mio.channel.DataChannelInfo
import com.meowool.sweekt.throwIf

internal const val IntPlaceholder = -1
internal const val LongPlaceholder = -1L
internal const val MaxArraySize = Int.MAX_VALUE - 8
internal const val LineFeed = '\n'.code.toByte()
internal const val CarriageReturn = '\r'.code.toByte()

@OverloadResolutionByLambdaReturnType
internal inline fun Int.ifBoolPlaceholder(another: () -> Boolean): Boolean =
  if (this == IntPlaceholder) another() else this == 1

internal inline fun Int.ifBoolPlaceholder(another: () -> Int): Boolean =
  (if (this == IntPlaceholder) another() else this) == 1

internal inline fun Int.ifPlaceholder(another: () -> Int): Int =
  if (this == IntPlaceholder) another() else this

internal inline fun Long.ifPlaceholder(another: () -> Long): Long =
  if (this == LongPlaceholder) another() else this

internal inline fun Boolean.toInt(): Int = if (this) 1 else 0

internal fun Long.toLegalInt(exception: String = "Required size too large"): Int {
  throwIf(this > MaxArraySize) { OutOfMemoryError(exception) }
  return this.toInt()
}

internal fun Short.reverseBytes(): Short {
  val i = toInt() and 0xffff
  val reversed = (i and 0xff00 ushr 8) or
    (i and 0x00ff shl 8)
  return reversed.toShort()
}

internal fun Int.reverseBytes(): Int =
  (this and -0x1000000 ushr 24) or
    (this and 0x00ff0000 ushr 8) or
    (this and 0x0000ff00 shl 8) or
    (this and 0x000000ff shl 24)

internal fun Long.reverseBytes(): Long =
  (this and -0x100000000000000L ushr 56) or
    (this and 0x00ff000000000000L ushr 40) or
    (this and 0x0000ff0000000000L ushr 24) or
    (this and 0x000000ff00000000L ushr 8) or
    (this and 0x00000000ff000000L shl 8) or
    (this and 0x0000000000ff0000L shl 24) or
    (this and 0x000000000000ff00L shl 40) or
    (this and 0x00000000000000ffL shl 56)

internal fun DataChannelInfo.checkIndices(startIndex: Long, endIndex: Long) {
  throwIf(startIndex < 0) { IndexOutOfBoundsException("startIndex:$startIndex < 0") }
  throwIf(endIndex > size) { IndexOutOfBoundsException("endIndex:$endIndex > channelSize:$size") }
}

internal fun DataChannelInfo.checkIndex(index: Long) {
  throwIf(index < 0) { IndexOutOfBoundsException("index:$index < 0") }
  throwIf(index > size) { IndexOutOfBoundsException("index:$index > channelSize:$size") }
}