package com.ssnickolay.nanoid

import scala.util.Random

trait NanoIdLike {
  lazy val DefaultNumberGenerator = new scala.util.Random()

  lazy val Alphabet = "_~0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"

  lazy val DefaultAlphabet = Alphabet.toCharArray()

  lazy val DefaultSize = 21

  def generate: String =
    generate(DefaultNumberGenerator, DefaultAlphabet, DefaultSize)

  def generate(size: Int): String =
    generate(DefaultNumberGenerator, DefaultAlphabet, size)

  def generate(random: Random, alphabet: Array[Char], size: Int): String = {
    val mask: Int = (2 << Math.floor(Math.log(alphabet.length - 1) / Math.log(2)).asInstanceOf[Int]) - 1
    val step: Int = Math.ceil(1.6 * mask * size / alphabet.length).asInstanceOf[Int]
    var bytes: Array[Byte] = new Array[Byte](step)
    random.nextBytes(bytes)

    0.to(step - 1).flatMap(i =>
      alphabet.lift(bytes(i) & mask)
    ).slice(0, size).mkString("")
  }
}
