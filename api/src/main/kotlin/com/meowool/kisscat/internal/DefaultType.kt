package com.meowool.kisscat.internal

import com.meowool.kisscat.GenericArgument
import com.meowool.kisscat.Type
import com.meowool.kisscat.TypeKind
import com.meowool.sweekt.Info
import com.meowool.sweekt.LazyInit
import com.meowool.sweekt.toJvmPackageName
import com.meowool.sweekt.toJvmQualifiedTypeName
import com.meowool.sweekt.toJvmTypeSimpleName

/**
 * Common type object implementation.
 *
 * @author 凛 (RinOrz)
 */
public class DefaultType(
  override val descriptor: String,
  override val kind: TypeKind = TypeKind.Unknown,
  override val arguments: MutableList<GenericArgument> = mutableListOf(),
) : Type {
  @LazyInit override val simpleName: String = descriptor.toJvmTypeSimpleName()
  @LazyInit override val packageName: String = descriptor.toJvmPackageName()
  @LazyInit override val qualifiedName: String = descriptor.toJvmQualifiedTypeName()
  @LazyInit override val canonicalName: String = descriptor.toJvmQualifiedTypeName(canonical = true)

  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (other !is Type) return false
    if (descriptor != other.descriptor) return false
    return true
  }

  override fun hashCode(): Int {
    return descriptor.hashCode()
  }
}