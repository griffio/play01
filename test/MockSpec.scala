import org.mockito.Mockito._
import org.scalatest.mockito.MockitoSugar
import org.scalatest.{FunSuite, MustMatchers}

class MockSpec extends FunSuite with MustMatchers with MockitoSugar {

  trait SquirrelBehaviour {
    def awake()
    def sleep()
    def findNuts()
    def hideNuts()
    def eatNuts()
    def nutQuantity:Int
  }

  test("Squirrel stuff") {

    val squirrel = mock[SquirrelBehaviour]

    when(squirrel.nutQuantity).thenReturn(10)

    squirrel.awake()

    for (_ <- 1 to 3) {
      squirrel.findNuts()
      squirrel.hideNuts()
      squirrel.eatNuts()
    }

    squirrel.sleep()

    verify(squirrel).awake()
    verify(squirrel, times(3)).findNuts()
    verify(squirrel, times(3)).hideNuts()
    verify(squirrel, times(3)).eatNuts()
    verify(squirrel).sleep()

    squirrel.nutQuantity mustBe 10

  }
}