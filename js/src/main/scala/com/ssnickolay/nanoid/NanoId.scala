package com.ssnickolay.nanoid

import scala.util.Random
import scala.scalajs.js

object NanoId extends NanoIdLike {
  def generateNative(random: js.Function1[Int, js.Array[Int]], userAlphabet: String, size: Int) =
    generateGeneric(random(_).toList.map(_.toByte), userAlphabet.toVector, size).mkString("")
}
