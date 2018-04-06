//package com.ssnickolay.nanoid
//
//class NanoIdSpec extends UnitSpec {
//
//  "A NanoIdBase" should "generate some value" in {
//    val value = NanoId.generate
//
//    assert(value.isInstanceOf[String])
//  }
//
//  it should "generate 100k random and uniq IDs" in {
//    val ids =
//      Stream
//        .continually(NanoId.generate)
//        .take(100000)
//        .toList
//
//    assert(ids.distinct.length === 100000)
//  }
//
//  it should "generate limited ID" in {
//    1.to(1000).foreach( size =>
//      assert(size === NanoId.generate(size).length)
//    )
//  }
//
//  it should "generate with seeded Random" in {
//    val random = new scala.util.Random(12345)
//    var alphabet = NanoId.DefaultAlphabet
//    var size = 21
//    var exectedIDs = Seq(
//      "kutqLNv1wDmIS56EcT3j7",
//      "U497UttnWzKWWRPMHpLD7",
//      "7nj2dWW1gjKLtgfzeI8eC",
//      "I6BXYvyjszq6xV7L9k2A9",
//      "uIolcQEyyQIcn3iM6Odoa"
//    )
//
//    exectedIDs.foreach(exected => {
//      var actual = NanoId.generate(random, alphabet, size);
//      assert(exected === actual)
//    })
//  }
//}
