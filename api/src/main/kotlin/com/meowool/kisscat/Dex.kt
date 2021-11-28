package com.meowool.kisscat

import com.meowool.sweekt.LazyInit
import com.meowool.sweekt.SuspendGetter

/**
 * Represents a parsed dalvik executable file. (Usually `.dex` extension)
 *
 * [Reference](https://source.android.com/devices/tech/dalvik/dex-format#file-layout)
 *
 * @author 凛 (https://github.com/RinOrz)
 */
public interface Dex {

  /**
   * The unique ID of this dex file.
   *
   * Usually used to distinguish when operating multiple dex file at the same time. It may be a path of the input
   * source, or it may be a timestamp.
   */
  public val id: String

  /**
   * The partial header information of this dex file.
   */
  public val header: Header

  /**
   * All data in this dex file that can be considered as strings.
   *
   * It may be literals or types or something...
   */
  @SuspendGetter
  public val strings: MutableSet<String>

  /**
   * All types in this dex file.
   *
   * Note that this value is not equal to [classes], it includes all referenced types (regardless of whether there is a
   * corresponding [Class], such as the referenced system class)
   */
  @SuspendGetter
  public val types: MutableSet<Type>

  /**
   * All classes declaration in this dex file.
   */
  @SuspendGetter
  public val classes: MutableSet<Class>

  /**
   * Determine whether the structure of two dex is the same.
   * Note that this will only determine the dex structure tree, that is [strings] [types] [classes].
   */
  override fun equals(other: Any?): Boolean

  /**
   * The partial header information of the dex format file.
   *
   * [Reference](https://source.android.com/devices/tech/dalvik/dex-format#header-item)
   *
   * @see Header.Empty
   * @author 凛 (https://github.com/RinOrz)
   */
  public interface Header {

    /**
     * The version of the dex file.
     */
    public val version: Int

    /**
     * The adler32 checksum of the dex file.
     * Usually used to detect file corruption.
     */
    @SuspendGetter
    public val checksum: UInt

    /**
     * The SHA-1 signature (hash) of the dex file.
     * Usually used to uniquely identify file.
     */
    @SuspendGetter
    public val signature: ByteArray


    /**
     * Represents an empty dex header.
     *
     * This is usually the default value of [Dex.header] for a new [Dex] instance.
     *
     * @author 凛 (https://github.com/RinOrz)
     */
    public companion object Empty : Header {
      override val version: Int = 0
      override val checksum: UInt = UInt.MIN_VALUE
      @LazyInit
      override val signature: ByteArray = ByteArray(0)
    }
  }
}