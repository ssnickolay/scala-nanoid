package com.ssnickolay.nanoid

class NanoIdJVMSpec extends UnitSpec {
  "A JVM NanoId" should "generate some value" in {
    val value = NanoId.generate

    assert(value.isInstanceOf[String])
  }
}

