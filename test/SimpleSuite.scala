import org.scalatest.FunSuite

class SimpleSuite extends FunSuite {
  test("what could go wrong here?") {
    val x = 123456789L
    val y = 0f

    println(x.toDouble - x.toFloat)
    val r = x - (if (true) x else y)
    assert(-3 == r)
  }
}
