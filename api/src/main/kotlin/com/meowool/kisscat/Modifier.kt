package com.meowool.kisscat

import com.meowool.kisscat.internal.ModifierApplicable

/**
 * Represents available member modifier.
 *
 * [Dalvik reference](https://source.android.com/devices/tech/dalvik/dex-format#access-flags)
 * [Jvm reference](https://docs.oracle.com/javase/specs/jvms/se7/html/jvms-4.html)
 *
 * @param applicable Member class types to which modifiers apply, see [ModifierApplicable].
 * @author 凛 (https://github.com/RinOrz)
 */
public enum class Modifier(public val applicable: Int) {

  ///////////////////////////////////////////////////////////////////////////////
  ////                  Modifiers available for all members                  ////
  ///////////////////////////////////////////////////////////////////////////////

  Public(ModifierApplicable.All),
  Private(ModifierApplicable.All),
  Protected(ModifierApplicable.All),
  Static(ModifierApplicable.All),
  Final(ModifierApplicable.All),
  Synthetic(ModifierApplicable.All),


  ///////////////////////////////////////////////////////////////////////////////
  ////          Modifiers available for class and property members           ////
  ///////////////////////////////////////////////////////////////////////////////

  Enum(ModifierApplicable.ClassesProperties),


  ///////////////////////////////////////////////////////////////////////////////
  ////          Modifiers available for class and function members           ////
  ///////////////////////////////////////////////////////////////////////////////

  Abstract(ModifierApplicable.ClassesFunctions),


  ///////////////////////////////////////////////////////////////////////////////
  ////                 Modifiers available for class members                 ////
  ///////////////////////////////////////////////////////////////////////////////

  Interface(ModifierApplicable.Classes),
  Annotation(ModifierApplicable.Classes),


  ///////////////////////////////////////////////////////////////////////////////
  ////               Modifiers available for property members                ////
  ///////////////////////////////////////////////////////////////////////////////

  Volatile(ModifierApplicable.Properties),
  Transient(ModifierApplicable.Properties),


  ///////////////////////////////////////////////////////////////////////////////
  ////               Modifiers available for function members                ////
  ///////////////////////////////////////////////////////////////////////////////

  Synchronized(ModifierApplicable.Functions),
  Bridge(ModifierApplicable.Functions),
  Varargs(ModifierApplicable.Functions),
  Native(ModifierApplicable.Functions),
  Strict(ModifierApplicable.Functions),
  Constructor(ModifierApplicable.Functions),
}