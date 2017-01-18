import scala.annotation.tailrec



object Palindrome {

  def isPalindromeBuiltIn[T] (xs: Seq[T]):Boolean = xs.reverse ==xs

  //Find out whether a list is a palindrome.
  @tailrec def isPalindrome[T](xs: Seq[T]):Boolean ={
    xs match{
      case (head::tail) if (tail.length>0 && head == tail.last)=> isPalindrome(tail.init)
      case (head::tail) if (tail.length>0 && head != tail.last)=> false
      case (head::nil)=>true
      case nil =>true
    }
  }


}
