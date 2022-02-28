package com.meowool.mio.internal.channel

/**
 * @author 凛 (RinOrz)
 */
internal interface MutableDataBuffer<S : MutableDataBuffer<S>> : DataBuffer<S> {
  /** Inserts data to this buffer. */
  fun insert(index: Long, data: Byte): S
  fun insert(index: Long, data: Short): S
  fun insert(index: Long, data: Char): S
  fun insert(index: Long, data: Int): S
  fun insert(index: Long, data: Float): S
  fun insert(index: Long, data: Long): S
  fun insert(index: Long, data: Double): S

  /** Removes some data from this buffer. */
  fun remove(index: Long, count: Long = 1): S
}