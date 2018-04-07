package com.ssnickolay.nanoid

import scala.util.Random
import scala.scalajs.js

object NanoId extends NanoIdLike {
  def generateNative(random: js.Function1[Int, js.Array[Int]], userAlphabet: String, size: Int): String = {
    val alphabet = userAlphabet.toCharArray()
    val mask: Int = (2 << Math.floor(Math.log(alphabet.length - 1) / Math.log(2)).asInstanceOf[Int]) - 1
    val step: Int = Math.ceil(1.6 * mask * size / alphabet.length).asInstanceOf[Int]
    val builder = new StringBuilder()
    var result: String = ""

    while (result == "") {
      var bytes = random(step)

      for (i <- 0 until step) {
        val alphabetIndex: Int = bytes(i) & mask

        if (alphabetIndex < alphabet.length) {
          builder.append(alphabet(alphabetIndex))
          if (builder.length() == size) {
            result = builder.toString()
          }
        }
      }
    }

    result
  }
}