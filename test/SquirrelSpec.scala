import org.scalatest.{GivenWhenThen, Outcome, fixture}

/**
  * fixture.FunSpec
  * Probably easier to have a fixture method
  */
class SquirrelSpec extends fixture.FunSpec with GivenWhenThen {

  type FixtureParam = Squirrel

  def withFixture(test: OneArgTest): Outcome = {
    val squirrel = Squirrel()
    test(squirrel)
  }

  case class Squirrel(var nuts: Int = 0) {
    def sleeping() {}
    def awake() {}
    def findNuts(nuts: Int) { this.nuts += nuts}
    def eat(nuts: Int) { this.nuts -= nuts}
  }

  describe("A Squirrel") {

    it("should be awake") { squirrel =>
      Given("A sleepy squirrel without food")
      squirrel.sleeping()
      When("The Squirrel is awake")
      squirrel.awake()
      Then("The Squirrel has no nuts")
      assert(squirrel.nuts == 0)
    }

    it("should be finding nuts") { squirrel =>
      Given("The squirrel is awake")
      squirrel.awake()
      When("The squirrel needs nuts")
      squirrel.findNuts(2)
      Then("The Squirrel finds nuts")
      assert(squirrel.nuts == 2)
    }
  }
}