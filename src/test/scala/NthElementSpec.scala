import org.scalacheck.Prop.forAll
import org.scalacheck.{Arbitrary, Test}
import org.scalatest._
import org.scalacheck.Gen

import scala.util.Success
import scala.util.Failure

class NthElementSpec extends FlatSpec with Matchers {
  "find nth element of a list" should " work correctly" in {


    NthElement.nthElement(2, List(1, 2, 3)) should be === Success(3)

    NthElement.nthElement(0, List(1, 2, 3)) should be === Success(1)

    NthElement.nthElement(-1, List(1, 2, 3)) shouldBe a[Failure[_]]

    import org.scalacheck.Gen.choose

    val myGen = for {
      n <- choose(1, 50)
      m <- choose(n, 2*n)
    } yield List(n, m)

    val p = forAll (myGen) {
      x => if (x.length > 1)
              NthElement.nthElement(1,x) == Success(x(1))
      else true
    }
    p.check

  }


}
