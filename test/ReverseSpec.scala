import java.io.{File, FileWriter}

import org.scalatest.{BeforeAndAfter, FlatSpec}

/**
  * Flatspec is a non-nested behaviour spec the word "test" is not used
  * Trait FlatSpec is named because your specification text and tests line up flat against the left-side indentation level, with no nesting needed.
  *
  * FunSuite: closest to JUnit; not very BDD
  * FlatSpec: transition from JUnit to BDD, enforces BDD style
  * FunSpec: closer to Ruby's RSpec
  * WordSpec: similarities to Specs2 specifications
  * FreeSpec: "build your own BDD style" approach
  * Spec: less compilation leads to faster build-test cycles; needs a significant number of tests to impact
  * PropSpec: Property test style - think ScalaCheck
  * FeatureSpec: Acceptance test style, similarities to Cucumber
  *
  * Fakes actually have working implementations, but usually take some shortcut which makes them not suitable for production
  * Mocks are pre-programmed with expectations which form a specification of the calls they are expected to receive
  * Stubs provide answers to calls made during the test, usually not responding at all to anything outside of what is programmed into the test
  * Spies record calls made for later verification. Provides answers during test similar to a stub
  */

class ReverseSpec extends FlatSpec with BeforeAndAfter {

  def tempFile(testCode: (FileWriter) => Any) {
    val file = File.createTempFile("Pre", "Suf") // create the fixture
    val writer = new FileWriter(file)
    try {
      testCode(writer)
    }
    finally {
      writer.close()
      file.delete()
    }
  }

  behavior of "Reversing a string"

  it should "reverse the order of characters" in {
    val input = "écureuil"
    val result = input.reverse
    assert("liuerucé" == result)
  }

  "reverse" must "produce the opposite ordering of characters" in {
    val input = "eichhörnchen"
    val result = input.reverse
    assert(result.reverse equals input)
  }

  it can "make a fixture" in tempFile { fw =>
    fw.write("écureuil")
  }

  class Squirrel() {
    def translate(): String = "écureuil"
  }

  "Squirrel" must "translate" in new Squirrel() {
    alert("Yep")
    assert(translate() equals "écureuil")
  }

  before {
    println("before")
  }

  after {
    println("after")
  }
}
