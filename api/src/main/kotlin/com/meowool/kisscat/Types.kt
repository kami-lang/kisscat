package com.meowool.kisscat

import com.meowool.kisscat.Type.BuiltIns
import com.meowool.kisscat.Type.BuiltIns.Boolean
import com.meowool.kisscat.Type.BuiltIns.BooleanArray
import com.meowool.kisscat.Type.BuiltIns.BooleanBoxed
import com.meowool.kisscat.Type.BuiltIns.BooleanBoxedArray
import com.meowool.kisscat.Type.BuiltIns.Byte
import com.meowool.kisscat.Type.BuiltIns.ByteArray
import com.meowool.kisscat.Type.BuiltIns.ByteBoxed
import com.meowool.kisscat.Type.BuiltIns.ByteBoxedArray
import com.meowool.kisscat.Type.BuiltIns.Char
import com.meowool.kisscat.Type.BuiltIns.CharArray
import com.meowool.kisscat.Type.BuiltIns.CharBoxed
import com.meowool.kisscat.Type.BuiltIns.CharBoxedArray
import com.meowool.kisscat.Type.BuiltIns.Double
import com.meowool.kisscat.Type.BuiltIns.DoubleArray
import com.meowool.kisscat.Type.BuiltIns.DoubleBoxed
import com.meowool.kisscat.Type.BuiltIns.DoubleBoxedArray
import com.meowool.kisscat.Type.BuiltIns.Float
import com.meowool.kisscat.Type.BuiltIns.FloatArray
import com.meowool.kisscat.Type.BuiltIns.FloatBoxed
import com.meowool.kisscat.Type.BuiltIns.FloatBoxedArray
import com.meowool.kisscat.Type.BuiltIns.Int
import com.meowool.kisscat.Type.BuiltIns.IntArray
import com.meowool.kisscat.Type.BuiltIns.IntBoxed
import com.meowool.kisscat.Type.BuiltIns.IntBoxedArray
import com.meowool.kisscat.Type.BuiltIns.Long
import com.meowool.kisscat.Type.BuiltIns.LongArray
import com.meowool.kisscat.Type.BuiltIns.LongBoxed
import com.meowool.kisscat.Type.BuiltIns.LongBoxedArray
import com.meowool.kisscat.Type.BuiltIns.Null
import com.meowool.kisscat.Type.BuiltIns.Short
import com.meowool.kisscat.Type.BuiltIns.ShortArray
import com.meowool.kisscat.Type.BuiltIns.ShortBoxed
import com.meowool.kisscat.Type.BuiltIns.ShortBoxedArray
import com.meowool.kisscat.Type.BuiltIns.Void
import com.meowool.kisscat.internal.DefaultType
import com.meowool.sweekt.LazyInit

/**
 * Represents a type in the JVM programming language or Dalvik system.
 *
 * @author 凛 (RinOrz)
 */
public interface Type {

  /**
   * The descriptor of this type.
   *
   * For example: `La/b/c/Foo;`
   *
   * [JVM reference](https://docs.oracle.com/javase/specs/jvms/se10/html/jvms-4.html#jvms-4.3)
   * [Dalvik reference](https://source.android.com/devices/tech/dalvik/dex-format#typedescriptor)
   */
  public val descriptor: String

  /**
   * The simple name of this type.
   *
   * For example: `a.b.c.Foo` -> `Foo`
   *
   * @see java.lang.Class.getSimpleName referenced.
   */
  public val simpleName: String

  /**
   * The package name of this type.
   *
   * For example: `a.b.c.Foo` -> `a.b.c`
   *
   * @see java.lang.Class.getPackageName referenced.
   */
  public val packageName: String

  /**
   * The fully qualified name of this type.
   *
   * For example: `a.b.c.Foo`
   */
  public val qualifiedName: String

  /**
   * The canonical name of this type.
   *
   * For example: `[La/b/c/Foo$Bar;` -> `a.b.c.Foo.Bar[]`
   *
   * @see java.lang.Class.getCanonicalName referenced.
   */
  public val canonicalName: String

  /**
   * List of generic arguments of this type.
   * For example, in the type `kotlin.collections.Map<Int, Long>` the returned list is `[Int, Long]`.
   *
   * Note that in case this type is based on an inner class, the returned list only contains the type arguments
   * provided for the innermost class.
   * For example, in the type `com.test.Outer<A>.Inner<B, C>.NestedInner<D, E, F>` the returned list is `[D, E, F]`.
   */
  public val arguments: MutableList<GenericArgument>

  /**
   * 这个类型的种类，一般为 [Unknown],
   * 除非在特殊情况下需要此属性（例如泛型声明）：
   * 在 Dex 泛型的字节码中，接口需要 :: 表示
   */
  public val kind: TypeKind

  /**
   * Built-in common [Type]s.
   *
   * @author 凛 (RinOrz)
   */
  @Suppress("SpellCheckingInspection")
  public companion object BuiltIns {

    @LazyInit public val Unknown: Type = Type(descriptor = "")


    ////////////////////////////////////////////////////////////////////////////////
    ////                          JVM primitive type                            ////
    ////////////////////////////////////////////////////////////////////////////////

    @LazyInit public val Boolean: Type = Type("Z")
    @LazyInit public val Byte: Type = Type("B")
    @LazyInit public val Char: Type = Type("C")
    @LazyInit public val Double: Type = Type("D")
    @LazyInit public val Float: Type = Type("F")
    @LazyInit public val Int: Type = Type("I")
    @LazyInit public val Long: Type = Type("J")
    @LazyInit public val Short: Type = Type("S")

    ////////////////////////////////////////////////////////////////////////////////
    ////                       JVM primitive object type                        ////
    ////////////////////////////////////////////////////////////////////////////////

    @LazyInit public val BooleanBoxed: Type = Type("Ljava/lang/Boolean;")
    @LazyInit public val ByteBoxed: Type = Type("Ljava/lang/Byte;")
    @LazyInit public val CharBoxed: Type = Type("Ljava/lang/Character;")
    @LazyInit public val DoubleBoxed: Type = Type("Ljava/lang/Double;")
    @LazyInit public val FloatBoxed: Type = Type("Ljava/lang/Float;")
    @LazyInit public val IntBoxed: Type = Type("Ljava/lang/Integer;")
    @LazyInit public val LongBoxed: Type = Type("Ljava/lang/Long;")
    @LazyInit public val ShortBoxed: Type = Type("Ljava/lang/Short;")


    ////////////////////////////////////////////////////////////////////////////////
    ////                      JVM primitive array types                         ////
    ////////////////////////////////////////////////////////////////////////////////

    @LazyInit public val BooleanArray: Type = Type("[Z")
    @LazyInit public val ByteArray: Type = Type("[B")
    @LazyInit public val CharArray: Type = Type("[C")
    @LazyInit public val DoubleArray: Type = Type("[D")
    @LazyInit public val FloatArray: Type = Type("[F")
    @LazyInit public val IntArray: Type = Type("[I")
    @LazyInit public val LongArray: Type = Type("[J")
    @LazyInit public val ShortArray: Type = Type("[S")


    ////////////////////////////////////////////////////////////////////////////////
    ////                    JVM primitive object array types                    ////
    ////////////////////////////////////////////////////////////////////////////////

    @LazyInit public val BooleanBoxedArray: Type = Type("[Ljava/lang/Boolean;")
    @LazyInit public val ByteBoxedArray: Type = Type("[Ljava/lang/Byte;")
    @LazyInit public val CharBoxedArray: Type = Type("[Ljava/lang/Character;")
    @LazyInit public val DoubleBoxedArray: Type = Type("[Ljava/lang/Double;")
    @LazyInit public val FloatBoxedArray: Type = Type("[Ljava/lang/Float;")
    @LazyInit public val IntBoxedArray: Type = Type("[Ljava/lang/Integer;")
    @LazyInit public val LongBoxedArray: Type = Type("[Ljava/lang/Long;")
    @LazyInit public val ShortBoxedArray: Type = Type("[Ljava/lang/Short;")


    ////////////////////////////////////////////////////////////////////////////////
    ////                           JVM common types                             ////
    ////////////////////////////////////////////////////////////////////////////////

    @LazyInit public val Null: Type = Type("N")

    @LazyInit public val Void: Type = Type("V")
    @LazyInit public val VoidBoxed: Type = Type("Ljava/lang/Void;")

    @LazyInit public val Number: Type = Type("Ljava/lang/Number;")

    @LazyInit public val Throwable: Type = Type("Ljava/lang/Throwable;")
    @LazyInit public val ThrowableArray: Type = Type("[Ljava/lang/Throwable;")

    @LazyInit public val Object: Type = Type("Ljava/lang/Object;")
    @LazyInit public val ObjectArray: Type = Type("[Ljava/lang/Object;")

    @LazyInit public val String: Type = Type("Ljava/lang/String;")
    @LazyInit public val StringArray: Type = Type("[Ljava/lang/String;")

    @LazyInit public val CharSequence: Type = Type("Ljava/lang/CharSequence;")
    @LazyInit public val CharSequenceArray: Type = Type("[Ljava/lang/CharSequence;")

    @LazyInit public val Collection: Type = Type("Ljava/util/Collection;")
    @LazyInit public val Comparator: Type = Type("Ljava/util/Comparator;")
    @LazyInit public val List: Type = Type("Ljava/util/List;")
    @LazyInit public val Set: Type = Type("Ljava/util/Set;")
    @LazyInit public val Map: Type = Type("Ljava/util/Map;")
    @LazyInit public val MapEntry: Type = Type("Ljava/util/Map\$Entry;")

    /**
     * Dalvik's system annotation types.
     * [Reference](https://source.android.com/devices/tech/dalvik/dex-format#system-annotation)
     *
     * @author 凛 (RinOrz)
     */
    public object Dalvik {
      @LazyInit public val AnnotationDefault: Type = Type("Ldalvik/annotation/AnnotationDefault;")
      @LazyInit public val EnclosingClass: Type = Type("Ldalvik/annotation/EnclosingClass;")
      @LazyInit public val EnclosingMethod: Type = Type("Ldalvik/annotation/EnclosingMethod;")
      @LazyInit public val InnerClass: Type = Type("Ldalvik/annotation/InnerClass;")
      @LazyInit public val MemberClasses: Type = Type("Ldalvik/annotation/MemberClasses;")
      @LazyInit public val MethodParameters: Type = Type("Ldalvik/annotation/MethodParameters;")
      @LazyInit public val Signature: Type = Type("Ldalvik/annotation/Signature;")
      @LazyInit public val SourceDebugExtension: Type = Type("Ldalvik/annotation/SourceDebugExtension;")
      @LazyInit public val Throws: Type = Type("Ldalvik/annotation/Throws;")
    }

    /**
     * Android platform common types.
     *
     * @author 凛 (RinOrz)
     */
    public object Android {
      @LazyInit public val View: Type = Type("Landroid/view/View;")
    }
  }
}

/**
 * Creates a type instance.
 *
 * @param descriptor See [Type.descriptor].
 * @param kind See [Type.kind].
 * @param arguments See [Type.arguments].
 */
public fun Type(
 descriptor: String,
 kind: TypeKind = TypeKind.Unknown,
 arguments: MutableList<GenericArgument> = mutableListOf(),
) : Type = DefaultType(descriptor, kind, arguments)

/**
 * Creates a type instance.
 *
 * @param descriptor See [Type.descriptor].
 * @param simpleName See [Type.simpleName].
 * @param packageName See [Type.packageName].
 * @param qualifiedName See [Type.qualifiedName].
 * @param canonicalName See [Type.canonicalName].
 * @param kind See [Type.kind].
 * @param arguments See [Type.arguments].
 */
public fun Type(
  descriptor: String,
  simpleName: String,
  packageName: String,
  qualifiedName: String,
  canonicalName: String,
  kind: TypeKind = TypeKind.Unknown,
  arguments: MutableList<GenericArgument> = mutableListOf(),
) : Type = object : Type {
  override val descriptor: String = descriptor
  override val simpleName: String = simpleName
  override val packageName: String = packageName
  override val qualifiedName: String = qualifiedName
  override val canonicalName: String = canonicalName
  override val arguments: MutableList<GenericArgument> = arguments
  override val kind: TypeKind = kind
}

/**
 * Returns `true` if this type is a `null` value.
 */
public val Type.isNullValue: Boolean
  get() = when (this) {
    Null -> true
    else -> false
  }

/**
 * Returns `true` if this type is not a `null` value.
 */
public inline val Type.isNotNullValue: Boolean get() = isNullValue.not()

/**
 * Returns `true` if this type is a JVM primitive.
 */
public val Type.isPrimitive: Boolean
  get() = when (this) {
    Boolean, Byte, Char, Double, Float, Int, Long, Short -> true
    else -> false
  }

/**
 * Returns `true` if this type is not a JVM primitive.
 */
public inline val Type.isNotPrimitive: Boolean get() = isPrimitive.not()

/**
 * Returns `true` if this type is a JVM primitive of boxing.
 */
public val Type.isPrimitiveBoxed: Boolean
  get() = when (this) {
    BooleanBoxed, ByteBoxed, CharBoxed, DoubleBoxed, FloatBoxed, IntBoxed, LongBoxed, ShortBoxed -> true
    else -> false
  }

/**
 * Returns `true` if this type is not a JVM primitive of boxing.
 */
public inline val Type.isNotPrimitiveBoxed: Boolean get() = isPrimitiveBoxed.not()

/**
 * Returns `true` if this type is a JVM primitive or a JVM primitive of boxing.
 */
public inline val Type.isPrimitiveOrBoxed: Boolean get() = isPrimitive || isPrimitiveBoxed

/**
 * Returns `true` if this type is not a JVM primitive and not a JVM primitive of boxing.
 */
public inline val Type.isNotPrimitiveAndBoxed: Boolean get() = isPrimitiveOrBoxed.not()

/**
 * Returns `true` if this type is a JVM primitive array.
 */
public val Type.isPrimitiveArray: Boolean
  get() = when (this) {
    BooleanArray, ByteArray, CharArray, DoubleArray, FloatArray, IntArray, LongArray, ShortArray -> true
    else -> false
  }

/**
 * Returns `true` if this type is not a JVM primitive array.
 */
public inline val Type.isNotPrimitiveArray: Boolean get() = isPrimitiveArray.not()

/**
 * Returns `true` if this type is an array of JVM boxed primitive.
 */
public val Type.isPrimitiveBoxedArray: Boolean
  get() = when (this) {
    BooleanBoxedArray, ByteBoxedArray, CharBoxedArray, DoubleBoxedArray,
    FloatBoxedArray, IntBoxedArray, LongBoxedArray, ShortBoxedArray -> true
    else -> false
  }

/**
 * Returns `true` if this type is not an array of JVM boxed primitive.
 */
public inline val Type.isNotPrimitiveBoxedArray: Boolean get() = isPrimitiveBoxedArray.not()

/**
 * Returns `true` if this type is an array.
 */
public val Type.isArray: Boolean get() = descriptor[0] == '['

/**
 * Returns `true` if this type is an array.
 */
public inline val Type.isNotArray: Boolean get() = isArray.not()

/**
 * Returns `true` if this type is an JVM 'void' type.
 */
public val Type.isVoid: Boolean get() = this == Void

/**
 * Returns `true` if this type is not an JVM 'void' type.
 */
public inline val Type.isNotVoid: Boolean get() = isVoid.not()

/**
 * Returns `true` if this type is an JVM 'void' type of boxing.
 */
public val Type.isVoidBoxed: Boolean get() = this == Void

/**
 * Returns `true` if this type is not an JVM 'void' type of boxing.
 */
public inline val Type.isNotVoidBoxed: Boolean get() = isVoid.not()

/**
 * Returns `true` if this type is an array.
 */
public inline val Type.isClass: Boolean
  get() = kind == TypeKind.Class || descriptor[0] == 'L'

/**
 * Built-in common [Type]s.
 *
 * @author 凛 (RinOrz)
 */
public typealias BuiltInTypes = BuiltIns


/**
 * Represents the kind of type.
 *
 * @author 凛 (RinOrz)
 */
public enum class TypeKind {
  Class,
  Interface,
  Unknown,
}