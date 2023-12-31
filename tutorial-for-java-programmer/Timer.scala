object Timer {
  // "Unit" equals "void" in Java
  def oncePerSecond(callback: () => Unit): Unit = {
    while (true) { callback(); Thread sleep 1000 }
  }

//   def timeFlies(): Unit = {
//     // this "println" is not in "System.out".
//     println("time flies like an arrow...")
//   }

  def main(args: Array[String]): Unit = {
    oncePerSecond(() =>
      println("time flies like an arrow...")
    ) // Anonymous function
  }
}
