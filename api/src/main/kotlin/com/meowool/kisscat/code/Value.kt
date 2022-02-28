package com.meowool.kisscat.code

/**
 * Represents a wrapper of a code value, they are usually also called constant value in bytecode.
 *
 * [JVM reference](https://docs.oracle.com/javase/specs/jvms/se10/html/jvms-4.html#jvms-4.4)
 * [Dalvik reference](https://source.android.com/devices/tech/dalvik/dex-format#value-formats)
 *
 * @author 凛 (RinOrz)
 */
public interface Value {

  /**
   * The kind of the [value] of this wrapper.
   */
  public val kind: ValueKind

  /**
   * The actual value of the value of this wrapper, and its object type corresponds to the [kind].
   */
  public val value: Any?
}

/**
 * The kind of the [Value] wrapping value.
 *
 * @author 凛 (RinOrz)
 */
public enum class ValueKind {
  /** Corresponds to `null` */
  Null,

  /** @see kotlin.Byte */
  Byte,

  /** @see kotlin.Short */
  Short,

  /** @see kotlin.Char */
  Char,

  /** @see kotlin.Int */
  Int,

  /** @see kotlin.Long */
  Long,

  /** @see kotlin.Float */
  Float,

  /** @see kotlin.Double */
  Double,

  /** @see kotlin.Boolean */
  Boolean,

  /** @see kotlin.String */
  String,

  /** @see kotlin.Array */
  Array,

  Type,
}
