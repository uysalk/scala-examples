package implicits

import org.scalacheck.{Gen, Test}
import org.scalacheck.Prop.{True, forAll}
import org.scalatest._
import implicits.convertToJson
import org.scalacheck.Test.Parameters

class ImplicitsSpec extends FlatSpec with Matchers {
  "convert 2 Json" should " work correctly" in {
    convertToJson("Hello World") === Json.Str("Hello World")
    val propStringConvert = forAll { (str1: String) =>
      convertToJson(str1) == Json.Str(str1)}

     propStringConvert.check(Test.Parameters.default  )


    val propIntConvert = forAll { (int1: Int) =>
      convertToJson(int1) == Json.Num(int1)}

    propIntConvert.check(Test.Parameters.default)


    val propSeqConvert = forAll { (seq: Seq[Int]) =>
      convertToJson(seq) ==        Json.List(seq.map(Json.Num(_)): _*)
    }

    propSeqConvert.check(Test.Parameters.default)



  }


}
