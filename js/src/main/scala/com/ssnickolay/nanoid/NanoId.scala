package com.ssnickolay.nanoid

import scala.util.Random
import scala.scalajs.js

object NanoId extends NanoIdLike {
  def generateNative(random: js.Function1[Int, js.Array[Int]], userAlphabet: String, size: Int): String = {
    val alphabet = userAlphabet.toCharArray()
    val mask: Int = (2 << Math.floor(Math.log(alphabet.length - 1) / Math.log(2)).asInstanceOf[Int]) - 1
    val step: Int = Math.ceil(1.6 * mask * size / alphabet.length).asInstanceOf[Int]
    var bytes = random(step)

    0.to(step - 1).flatMap(i =>
      alphabet.lift(bytes(i) & mask)
    ).slice(0, size).mkString("")
  }
}