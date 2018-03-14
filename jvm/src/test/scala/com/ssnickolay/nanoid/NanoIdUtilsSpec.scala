package com.ssnickolay.nanoid

class NanoIdUtilsSpec extends UnitSpec {

  "A NanoIdUtils" should "generate some value" in {
    val value = NanoIdUtils.defaultGenerate

    assert(value.isInstanceOf[String])
  }
}