import org.scalatest.{Matchers, path}

class AlgorithmSpec extends path.FunSpec with Matchers {

  describe("Counting number of inversions") {

    it("reports none for empty array") {
      Algorithm.inversions(Array.empty) should equal(0)
    }

    it("reports none for simplest non-empty array") {
      Algorithm.inversions(Array(1)) should equal(0)
    }

    it("reports none for simple sorted two-element array") {
      Algorithm.inversions(Array(1, 2)) should equal(0)
    }

    it("reports 1 for simple two-element array sorted descending") {
      Algorithm.inversions(Array(2, 1)) should equal(1)
    }

    it("reports n-1 for simple n-element array sorted ascending with first element the biggest") {
      Algorithm.inversions(Array(6, 1, 2, 3, 4, 5)) should equal(5)
    }

    it("reports correctly for more complicated input") {
      Algorithm.inversions(Array(1, 3, 5, 2, 4, 6)) should equal(3)
    }
  }
}
