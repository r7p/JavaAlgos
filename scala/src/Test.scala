
object ScalaTest extends App {
  println("Hello from scala")

  val names = List("a", "b", "c")

  val arr = Array(44, 30, 24, 32, 35, 30, 40, 38, 15);
  val arrSorted = arr.sorted(Ordering.Int.reverse)

  println(arrSorted.take(4).mkString(","))
}
