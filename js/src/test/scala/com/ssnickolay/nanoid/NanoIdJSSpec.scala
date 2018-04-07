package com.ssnickolay.nanoid

import scala.scalajs.js
import scala.scalajs.js.annotation._

object FakeRandom extends js.Object {
  def build(size: Int): js.Array[Int] = {
    var array = new js.Array[Int]()

    1.to(size).foreach(_ => array.unshift(123))
    array
  }
}

class NanoIdJSSpec extends UnitSpec {
  it should "generate with seeded JS Random" in {
    var alphabet = NanoId.Alphabet
    var size = 21

    assert(NanoId.generateNative(FakeRandom.build _, alphabet, size) === "VVVVVVVVVVVVVVVVVVVVV")
  }
}
