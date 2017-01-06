import scala.util.{Failure, Success, Try}

/**
  * Created by uysal.kara on 06.01.2017.
  */
object NthElement {

  //Find the nth element of a list.

  def nthElementBuilt[T]  (n:Int, xs: List[T]):Try[T] ={

    Try(xs(n))
  }


  def nthElement[T]  (n:Int, xs: List[T]):Try[T] ={
    xs match{
      case (head :: tail) if ( n > 0) => nthElement(n-1, tail)
      case (head :: tail) if ( n == 0) => Success(head)
      case (_ )=> Failure(new NoSuchElementException( "No such element"))
    }

  }

}
