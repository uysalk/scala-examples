import org.scalatest._
import org.scalacheck.Prop.{True, forAll}
import org.scalacheck.{Gen, Test}

class CommonElementsSpec extends FlatSpec with Matchers {
  "find common elements" should " work correctly" in {
    CommonElements.findCommon(List(1, 2, 3, 4, 5), List(2, 3, 3, 7, 9)).toSeq.sorted should be === Seq(2,3)

    CommonElements.findCommon(List.empty, List(2, 3, 3, 7, 9)) should be === Set.empty
    CommonElements.findCommon(List.empty, List.empty) should be === Set.empty
    CommonElements.findCommon(List(2, 3, 3, 7, 9), List.empty) should be === Set.empty




    val propConcatLists = forAll { (l1: List[Int], l2: List[Int]) =>
      CommonElements.findCommon (l1,l2).toSeq.sorted ==l1.toSet.intersect(l2.toSet).toSeq.sorted }

    val result = propConcatLists.check(Test.Parameters.default)

  }


  "find common elements with sorted inputs" should " work correctly" in{

    CommonElements.findCommonSorted(List.empty, List(2, 3, 3, 7, 9)) should be === Set.empty
    CommonElements.findCommonSorted(List.empty, List.empty) should be === Set.empty
    CommonElements.findCommonSorted(List(2, 3, 3, 7, 9), List.empty) should be === Set.empty


    val propConcatLists = forAll { (l1: List[Int], l2: List[Int]) =>

      CommonElements.findCommonSorted (l1.sorted,l2.sorted).toSeq.sorted ==l1.sorted.toSet.intersect(l2.sorted.toSet).toSeq.sorted }


     val result = propConcatLists.check(Test.Parameters.default)

  }
}
