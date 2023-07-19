object ComplexNumbers {
  def main(args: Array[String]): Unit = {
    val c = new Complex(1.2, 3.4)
    // println("imaginary part: " + c.im())
    println("imaginary part: " + c.im) // abbreviate "()"
    println("Overridden toString(): " + c.toString) // ex. override
  }
}
