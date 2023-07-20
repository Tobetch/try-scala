class Reference[T] {
  private var contents: T = _
  def set(value: T): Unit = { contents = value }
  def get: T = contents
}

object Generics {
  def main(args: Array[String]): Unit = {
    // Int
    val cell = new Reference[Int]
    cell.set(13)
    println("Reference contains the half of " + (cell.get * 2))

    // String
    val cell2 = new Reference[String]
    cell2.set("Hello, ")
    println(cell2.get + "World")
  }
}
