package com.meowool.kisscat

import java.io.File
import java.util.ServiceLoader

public interface MultiDex : MutableList<Dex> {
  public fun load(vararg dexPaths: String)
  public fun load(vararg dexFiles: File)

  public fun merge()
}

public fun load() {
  val multiDex = ServiceLoader.load(MultiDex::class.java).firstOrNull()
    ?: error("You must add backend implementation dependency of 'MultiDex'")
}