import org.scalacheck.Prop.forAll
import org.scalatest._

import scala.util.{Failure, Success}
import Palindrome._

class PalindromeSpec extends FlatSpec with Matchers {
  "Palindrome " should " work correctly" in {

    isPalindrome(Seq ('A','B','B','A')) should be ===  true
    isPalindrome(Seq ('A','B','B','B')) should be ===  false
    isPalindrome(Seq ()) should be ===  true
    isPalindrome(Seq ('A')) should be ===  true
    isPalindrome(Seq ('A','A')) should be ===  true

  }

  "Palindrome builtin" should " work correctly" in {

    isPalindromeBuiltIn(Seq ('A','B','B','A')) should be ===  true
    isPalindromeBuiltIn(Seq ('A','B','B','B')) should be ===  false
    isPalindromeBuiltIn(Seq.empty) should be ===  true
    isPalindromeBuiltIn(Seq ('A')) should be ===  true
    isPalindrome("AA") should be ===  true
    isPalindrome(12344321.toString) should be ===  true

  }


}
