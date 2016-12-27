import scala.annotation.tailrec
import scala.collection.mutable

//Imagine you have two array a = [1,2,3,4,5] and b =[3,2,9,3,7], write a program to find out common elements in both array. 
// Can you write this without using for loop? 
// If i sort those arrays will it make any difference in your code? Can you write better code if arrays are sorted?


object CommonElements {


  def main(args: Array[String]): Unit = {

    val list1 = List(1, 2, 3, 4, 5)
    val list2 = List(3, 2, 9, 3, 7,4)

    val commons = findCommon(list1, list2)

    println (commons)

    val commons2 = findCommon(List.empty, list2)
    val commons3 = findCommon(list1, List.empty)


    val commonsSorted = findCommonSorted(list1.sorted, list2.sorted)

    println (commonsSorted)

  }



  def findCommon(list1: List[Int], list2: List[Int]): Set[Int] = {

    val map = new mutable.HashMap[Int, Int]() ++ list1.map(x => (x, x))
    @tailrec def findCommon_(list2: List[Int], acc: Set[Int]): Set[Int] = {
      list2 match {
        case Nil => acc
        case x :: xs1 if map.contains(x) => findCommon_(xs1, acc + x)
        case x :: xs1 => findCommon_(xs1, acc)
      }
    }

    findCommon_(list2, Set.empty)
  }



  def findCommonSorted(list1: List[Int], list2: List[Int]): Set[Int] = {
    @tailrec def findCommonSorted_(list1: List[Int], list2: List[Int], acc: Set[Int]): Set[Int] = {
      (list1, list2) match {
        case (_, nil) => acc
        case (nil, _) => acc
        case (x :: xs1, y :: ys1) if x > y => findCommonSorted_(list1, ys1, acc)
        case (x :: xs1, y :: ys1) if x < y => findCommonSorted_(xs1, list2, acc)
        case (x :: xs1, y :: ys1) => findCommonSorted_(xs1, ys1, acc + x)

      }
    }

    findCommonSorted_(list1, list2, Set.empty)
  }
}


