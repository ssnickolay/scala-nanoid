package com.ssnickolay.nanoid

import scala.scalajs.js
import scala.scalajs.js.annotation._

object FakeRandom extends js.Object {
  def build(size: Int): Array[Int] =
    1.to(size).map(_ => 123).toArray
}

class NanoIdUtilsJSSpec extends UnitSpec {
  it should "generate with seeded JS Random" in {
    var alphabet = NanoIdUtils.DefaultAlphabet
    var size = 21

    assert(NanoIdUtils.generate((i) => FakeRandom.build(i), alphabet, size) === "VVVVVVVVVVVVVVVVVVVVV")
  }
}
