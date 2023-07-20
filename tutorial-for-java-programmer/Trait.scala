object Trait {
  def main(args: Array[String]): Unit = {
    val now = new Date(2023, 7, 19)
    val future = new Date(2045, 7, 19)
    val str = "This is not 'Date'"

    print("now : ")
    // println(now)
    println(now.toString())

    print("future : ")
    println(future)

    print("now equals future? : ")
    println(now equals future)

    print("now < future? : ")
    println(now < future)

    try {
      print("now < str? : ")
      println(now < str)
    } catch {
      case e: RuntimeException =>
        println("error: " + e.getMessage())
      case _: Throwable => println("Got some other kind of Throwable exception")
    }
  }
}
