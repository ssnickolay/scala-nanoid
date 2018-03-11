package com.ssnickolay.nanoid

import scala.util.{Random}

object NanoIdUtils {
  lazy val DefaultNumberGenerator = new scala.util.Random()

  lazy val DefaultAlphabet =
    "_~0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray()

  lazy val DefaultSize = 21

  def defaultGenerate: String =
    generate(DefaultNumberGenerator, DefaultAlphabet, DefaultSize)

  def generate(random: Random, alphabet: Array[Char], size: Int): String = {
    val mask: Int = (2 << Math.floor(Math.log(alphabet.length - 1) / Math.log(2)).asInstanceOf[Int]) - 1
    val step: Int = Math.ceil(1.6 * mask * size / alphabet.length).asInstanceOf[Int]
    val builder = new StringBuilder()
    var result: String = ""

    while (result == "") {
      var bytes: Array[Byte] = new Array[Byte](step)
      random.nextBytes(bytes)

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