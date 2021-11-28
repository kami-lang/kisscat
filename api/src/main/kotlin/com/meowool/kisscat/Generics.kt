package com.meowool.kisscat

/**
 * Represents the parameter definition of a generic variable
 *
 * Kotlin example:
 * ```
 * class A<T> { ... }
 * fun <S, R> a() { ... }
 * ```
 *
 * Java example:
 * ```
 * class A<T> { ... }
 * <S, R> void a() { ... }
 * ```
 *
 * @author 凛 (https://github.com/RinOrz)
 */
public interface GenericParameter {

  /**
   * 这个泛型的变量名
   * 注意，只有是一个泛型声明时 [name] 才会存在
   *
   * 例如：
   * `<out T: Any>` (kotlin), [name] 为 `T`;
   * `<R extends Object>` (java), [name] 为 `R`
   */
  public val name: String?

  /**
   * 这个泛型的类型边界
   *
   * Kotlin 例子：
   * ```
   * // bounds 为 `kotlin.Number, kotlin.Cloneable`
   * <T> where T: Number, T: Cloneable
   *
   * // bounds 为 `kotlin.Any`
   * T: Any
   * ```
   *
   * Java 例子：
   * ```
   * // bounds 为 `java.lang.Throwable, java.lang.Exception`
   * T extends Throwable & Exception
   *
   * // bounds 为 `java.lang.Object`
   * T extends Object
   * ```
   */
  public val bounds: MutableList<Type>
}

/**
 * 表示一个泛型的实际参数
 *
 * Kotlin:
 * ```
 * class A : B<Any> { ... }
 * fun a(param: Map<C, D>) { ... }
 * ```
 *
 * Java:
 * ```
 * class A extends B<Object> { ... }
 * void a(Map<C, D> param) { ... }
 * ```
 *
 * @see Type.arguments
 *
 * @author 凛 (https://github.com/RinOrz)
 */
public interface GenericArgument : Type {
  /** 这个泛型的型变 */
  public val variance: GenericVariance
}


/**
 * 表示泛型中的型变
 *
 * @property kotlin 表示在 Kotlin 语言中的型变表达
 * @property kotlin 表示在 Java 语言中的型变表达
 */
public enum class GenericVariance(public val kotlin: String, public val java: String) {

  /**
   * 表示一种未知的泛型
   * 例如: kotlin - `List<*>`, java - `List<?>`,
   * 甚至是 kotlin - `List`, java - `List`
   */
  Unknown("*", "?"),

  /**
   * 表示一种不变的泛型
   * 例如 `List<T>`
   */
  Invariant("", ""),

  /**
   * 表示一种协变的泛型
   * 例如 kotlin - `Foo<out E>`, java - `Foo<? extends E>`
   */
  Covariant("out", "extends"),

  /**
   * 表示一种逆变的泛型
   * 例如 kotlin - `Foo<in E>`, java - `Foo<? super E>`
   */
  Contravariant("in", "super");
}