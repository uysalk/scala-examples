import scala.annotation.tailrec


//Given a sorted array of positive integers,
// check existence of two integers from that array that sum up to a given number

object CheckExistence {

  def main(args: Array[String]): Unit = {

    val list = Array(2, 5, 7, 9, 13, 24, 323, 23, 42, 43, 45, 6, 3, 4, 5).sorted
    val stringArray = Array ("Hel","lo","wor","ld").sorted

    val stringConcatExists = exists(stringArray, "Helwor") ((x,y) => x + y)
    val intSumExists = exists(list, 26) ((x,y) => x + y)
    val intProductExists = exists(list, 26) ((x,y) => x * y)

  }

  
  def exists[T] (list:Array[T] , value: T )( f: (T,T) => T )(implicit ordering: Ordering[T]): Boolean = {
    @tailrec def existsHelper(list:Array[T ], value:T, beginIndex:Int, endIndex:Int ):Boolean={
      val total =  f( list(beginIndex), list(endIndex))
      if (beginIndex >= endIndex ) return false
      else
      if (ordering.compare(total,value)> 0){
        return existsHelper (list , value, beginIndex, endIndex-1)
      }else if (ordering.compare(total,value)<0){
        return existsHelper (list , value, beginIndex+1, endIndex)
      }else if (ordering.compare(total,value)==0){
        return true
      }
      else return false
    }

    existsHelper(list, value, 0, list.length-1)

  }


}
