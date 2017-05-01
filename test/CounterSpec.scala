import org.scalatestplus.play._
import org.scalatestplus.play.guice.GuiceOneAppPerSuite
import services.Counter

class CounterSpec extends PlaySpec with GuiceOneAppPerSuite {
  "Counter component" should {
    "resolve implementation and produce increasing values" in {
      val counter: Counter = app.injector.instanceOf[Counter]
      counter.nextCount() mustBe 0
      counter.nextCount() mustBe 1
      counter.nextCount() mustBe 2
    }
  }
}