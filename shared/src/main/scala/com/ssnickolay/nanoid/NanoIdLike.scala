package com.ssnickolay.nanoid

import scala.util.Random

trait NanoIdLike {
  lazy val DefaultNumberGenerator = new scala.util.Random()

  lazy val Alphabet = "_~0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"

  lazy val DefaultAlphabet = Alphabet.toCharArray().toVector

  lazy val DefaultSize = 21

  def generate: String =
    generate(DefaultNumberGenerator, DefaultAlphabet, DefaultSize)

  def generate(size: Int): String =
    generate(DefaultNumberGenerator, DefaultAlphabet, size)

  def generate(random: Random, alphabet: Vector[Char], size: Int): String =
    generateGeneric(size => {
      val bytes: Array[Byte] = new Array[Byte](size)
      random.nextBytes(bytes)
      bytes.toList
    }, alphabet.toVector, size).mkString("")

  protected def generateGeneric(random: Int => List[Byte], alphabet: Vector[Char], size: Int): List[Char] = {
    val mask = (2 << (Math.log(alphabet.length - 1) / Math.log(2)).floor.round).toInt - 1
    val step = (1.6 * mask * size / alphabet.length).ceil.round.toInt
    var bytes = random(step)

    bytes
      .map(_ & mask)
      .flatMap(a => alphabet.lift(a).toList)
      .take(size)
  }
}
