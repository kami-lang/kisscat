package com.meowool.mio.channel

/**
 * Checked exception thrown when an attempt is made to invoke or complete an I/O operation upon
 * channel that is closed, or at least closed to that operation.  That this exception is thrown
 * does not necessarily imply that the channel is completely closed. A socket channel whose write
 * half has been shut down, for example, may still be open for reading.
 */
open class ClosedChannelException : Exception()

/**
 * Channel is empty exception.
 */
open class ChannelEmptyException(message: String? = null) : Exception(message)

/**
 * Channel data size underflow exception.
 */
open class ChannelUnderflowException(message: String? = null) : Exception(message)

/**
 * Channel data size overflow exception.
 */
open class ChannelOverflowException(message: String? = null) : Exception(message)