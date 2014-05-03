import scala.io.Source

object Question1 extends App {

  val source = Source.fromURL(getClass.getResource("IntegerArray.txt"))
  val input = source.getLines().map(_.toInt).toArray
  val result = Algorithm.inversions(input)

  println(result)
}
