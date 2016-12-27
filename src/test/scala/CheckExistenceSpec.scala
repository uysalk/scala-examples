import org.scalacheck.Prop.{False, True, forAll}
import org.scalacheck.Test
import org.scalatest._


class CheckExistenceSpec extends FlatSpec with Matchers {
  "check sum of two numbers exist" should " work correctly" in {

    val list = Array(2, 5, 7, 9, 13, 24, 323, 23, 42, 43, 45, 6, 3, 4, 5).sorted
    val f1 =  CheckExistence.exists(list, _:Int) ((x,y) => x + y)


    f1(26) should be === true

    f1(324)should be === false

    val f2 = CheckExistence.exists(list, _:Int) ((x,y) => x * y)

    f2(26) should be === true


    f2(37)  should be ===  false


  }



  "check concatenation of two strings exist" should " work correctly" in {
     val stringArray = Array ("Hel","lo","wor","ld").sorted

    val f1 =  CheckExistence.exists(stringArray, _:String) ((x,y) => x + y)

    f1( "Helwor") should be === true
    f1( "Hellwor") should be === false

  }


}
