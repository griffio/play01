import org.scalatestplus.play._
import services.AtomicCounter

class AtomicCounterSpec extends PlaySpec {

  "AtomicCounter" must {

    "produce increasing values" in {
      val counter: AtomicCounter = new AtomicCounter
      counter.nextCount() mustBe 0
      counter.nextCount() mustBe 1
      counter.nextCount() mustBe 2
    }
  }
}