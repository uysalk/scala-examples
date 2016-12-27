

//Examples from http://www.lihaoyi.com/post/ImplicitDesignPatternsinScala.html
//Type-class Implicit pattern
package implicits {

  sealed trait Json

  object Json {

    case class Str(s: String) extends Json

    case class Num(value: Double) extends Json

    case class List(items: Json*) extends Json

  }


  trait Jsonable[T] {
    def serialize(t: T): Json
  }

  object Jsonable {

    implicit object StringJsonable extends Jsonable[String] {
      def serialize(t: String) = Json.Str(t)
    }

    implicit object DoubleJsonable extends Jsonable[Double] {
      def serialize(t: Double) = Json.Num(t)
    }

    implicit object IntJsonable extends Jsonable[Int] {
      def serialize(t: Int) = Json.Num(t.toDouble)
    }

    implicit def SeqJsonable[T: Jsonable] = new Jsonable[Seq[T]] {
      def serialize(t: Seq[T]) = {
        Json.List(t.map(implicitly[Jsonable[T]].serialize): _*)
      }
    }

  }

  object implicits {
    def convertToJson[T](x: T)(implicit converter: Jsonable[T]): Json = {
      converter.serialize(x)

    }

    def convertToJson2[T: Jsonable](x: T): Json = {
      implicitly[Jsonable[T]].serialize(x)
    }


    implicit object FileJsonable extends Jsonable[java.io.File] {
      def serialize(t: java.io.File) = Json.Str(t.getAbsolutePath)
    }

  }

}

