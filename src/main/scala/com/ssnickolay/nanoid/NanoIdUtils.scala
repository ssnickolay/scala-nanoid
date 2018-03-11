package com.ssnickolay.nanoid

import scala.util.{Random}
import scala.math._

object NanoIdUtils {
  lazy val DefaultNumberGenerator = new scala.util.Random()

  lazy val DefaultAlphabet =
    "_~0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray()

  lazy val DefaultSize = 21

  def defaultGenerate: String =
    generate(DefaultNumberGenerator, DefaultAlphabet, DefaultSize)

  def generate(random: Random, alphabet: Array[Char], size: Int): String = {
    val mask: Int = (2 << Math.floor(Math.log(alphabet.length - 1) / Math.log(2)).asInstanceOf[Int]) - 1;
    val step: Int = Math.ceil(1.6 * mask * size / alphabet.length).asInstanceOf[Int];
    val builder = new StringBuilder()

    while (true) {

      val bytes: Array[Byte] = new Byte[step];
      random.nextBytes(bytes);

      for (int i = 0; i < step; i++) {

        final int alphabetIndex = bytes[i] & mask;

        if (alphabetIndex < alphabet.length) {
          idBuilder.append(alphabet[alphabetIndex]);
          if (idBuilder.length() == size) {
            return idBuilder.toString();
          }
        }

      }

    }
  }
}