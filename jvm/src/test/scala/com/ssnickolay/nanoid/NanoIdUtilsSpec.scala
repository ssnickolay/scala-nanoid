package com.ssnickolay.nanoid

import scala.collection.mutable.Stack

class NanoIdUtilsSpec extends UnitSpec {

  "A NanoIdUtils" should "generate some value" in {
    val value = NanoIdUtils.generate

    assert(value.isInstanceOf[String])
  }

  it should "generate 100k random and uniq IDs" in {
    var ids = new Stack[String]

    1.to(100000).foreach( _ =>
      ids = ids.push(NanoIdUtils.generate)
    )

    assert(ids.distinct.length === 100000)
  }

  it should "generate limited ID" in {
    1.to(1000).foreach( size =>
      assert(size === NanoIdUtils.generate(size).length)
    )
  }
}
